package com.smartbank.exceptions;

public class GeneralException extends Exception{

	/**
	   * As soon as a General Exception is wrapped within another General Exception
	   * then it is no longer the top level exception.
	   */
	boolean topLevelException = true;	


	private int code;
	
	protected GeneralException(String msg)
	{
	    super(msg);
	}	
	
	 protected GeneralException(String msg, Throwable cause)
	 {
	    super(msg, cause);
	    if (null != cause && cause instanceof GeneralException)
	    {
	      GeneralException theCause = (GeneralException) cause;
	      theCause.topLevelException = false;
	    }
	 }
	 
	 protected GeneralException(String msg, Throwable cause, String cl)
	  {
	    this(msg + " {" + cl + "}", cause);
	  }
	 
	 public Throwable getRootCause()
	  {
	    Throwable cause = getCause();

	    // Go up the tree until there is no cause.
	    // The cause can equal itself (jdk 1.4 exceptions)
	    while (cause != null && cause.getCause() != null
	        && cause.getCause() != cause)
	    {
	      cause = cause.getCause();
	    }
	    return (null == cause) ? this : cause;
	  }	 
	
	 public void setTopLevelException(boolean topLevelException)
	  {
	    this.topLevelException = topLevelException;
	  }
	 
	  public int getCode() {
			return code;
	  }
	  public void setCode(int code) {
			this.code = code;
	  }
}
