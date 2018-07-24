package com.eBusiness.util;
import java.util.UUID;

import com.eBusiness.persist.entity.user.User;


public class PasswordResetUtil {
	public String generateToken(){
	  return UUID.randomUUID().toString();
	}	
	
	public String constructResetTokenEmail(String contextPath,String token, User user) 
	{
	  return "<a href="+'"'+ contextPath + "/#/resetpassword/" + user.getEmail() + "/" + token+'"'+">Click here"+"</a>" ;	
	  //return "<a href="+'"'+ contextPath + "/resetpassword?email=" + user.getEmail() + "&token=" + token+'"'+">Click here"+"</a>" ;
	}
}
