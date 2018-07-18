package com.eBusiness.model;

public class Response {

    private String code;

    private String message;

    private Error error;
    
    public Response(){};
    
    public Response(String code, String message, Error error) {
        this.code = code;
        this.message = message;
        this.error = error;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
