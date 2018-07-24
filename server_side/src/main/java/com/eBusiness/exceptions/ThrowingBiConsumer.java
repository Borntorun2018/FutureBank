package com.eBusiness.exceptions;

import java.util.function.BiConsumer;

@FunctionalInterface
public interface ThrowingBiConsumer<T,U> extends BiConsumer<T,U> {
	
	@Override
	default void accept(T t, U u){
		try{
			applyThrows(t,u);
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	void applyThrows(T t, U u) throws Exception;
}