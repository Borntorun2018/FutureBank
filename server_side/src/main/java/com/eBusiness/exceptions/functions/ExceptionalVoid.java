package com.eBusiness.exceptions.functions;

public interface ExceptionalVoid<E extends Exception> {
    void apply() throws E;
}