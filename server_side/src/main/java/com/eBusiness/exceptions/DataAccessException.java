package com.eBusiness.exceptions;

public class DataAccessException extends GeneralException {

    public DataAccessException(String msg) {
        super(msg);
    }

    public DataAccessException(String msg, Throwable cause) {
        super(msg, cause);
    }

    public DataAccessException(String msg, Throwable cause, String cl) {
        super(msg, cause, cl);
    }
}