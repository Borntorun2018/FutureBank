package com.smartbank.exceptions;

public class ServiceException extends GeneralException{

	  public ServiceException(String msg) {
	    super(msg);
	  }

	  public ServiceException(String msg, Throwable cause) {
	    super(msg, cause);
	  }

	  public ServiceException(String msg, Throwable cause, String cl) {
	    super(msg, cause, cl);
	  }	
}
