package com.eBusiness.util;

public class StringUtil {

	public static boolean isEmpty(String s)
	{
	    return s == null || s.trim().length() == 0;
	}
	public static boolean isEmpty(String [] param)
	  {
	    if(null != param && param.length > 0)
	    {
	      for (int i = 0; i < param.length; i++)
	      {
	        if(!StringUtil.isEmpty(param[i]))
	          return false;
	      }
	    }
	    return true;
	}
	
	
}
