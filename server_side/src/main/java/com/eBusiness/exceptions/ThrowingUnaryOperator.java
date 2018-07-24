package com.eBusiness.exceptions;

import java.util.function.UnaryOperator;
//http://www.baeldung.com/java-lambda-exceptions

public interface ThrowingUnaryOperator<T, E extends Exception> {

	T apply(T t) throws E;

    static <T, E extends Exception> UnaryOperator<T> handlingUnaryOperatorWrapper(
		 
		  ThrowingUnaryOperator<T, E> throwingUnaryOperator, Class<E> exceptionClass) {
		  
		    return i -> {
		        try {
		            return throwingUnaryOperator.apply(i);
		        } catch (Exception ex) {
		            try {
		                E exCast = exceptionClass.cast(ex);
		                System.err.println(
		                  "Exception occured : " + exCast.getMessage());
		                return null;  //Don't like this would have liked to have introduced Optional
		            } catch (ClassCastException ccEx) {
		                throw new RuntimeException(ex);
		                //return null;
		            }
		        }
		    };
     }
}