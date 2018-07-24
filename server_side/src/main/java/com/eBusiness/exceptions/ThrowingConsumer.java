package com.eBusiness.exceptions;

import java.util.function.Consumer;

@FunctionalInterface
public interface ThrowingConsumer<T> extends Consumer<T> {
	
	@Override
	default void accept(T t){
		try{
			applyThrows(t);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	void applyThrows(T t) throws Exception;
}