package com.eBusiness.exceptions.functions;

public interface ExceptionalSupplier<T, E extends Exception> {
    T supply() throws E;
}