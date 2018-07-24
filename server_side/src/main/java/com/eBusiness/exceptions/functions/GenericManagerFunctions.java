package com.eBusiness.exceptions.functions;

public class GenericManagerFunctions {

	//Generic function that accepts 3 parameters and returns no result
	 @FunctionalInterface 
	 public interface GenericConsumer<S, T,  V>{
		 public void accept(S s, T t, V v);
	 }
}
