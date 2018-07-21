package com.eBusiness.logging;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.FormattingInfo;
import org.apache.log4j.helpers.PatternConverter;
import org.apache.log4j.helpers.PatternParser;
import org.apache.log4j.spi.LoggingEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

//import com.newborn.persist.entity.User;
import com.eBusiness.security.SecurityUser;

public class LogPatternParser  extends PatternParser{
	private static final Logger log = Logger.getLogger(LogPatternParser.class);

	public LogPatternParser (String pattern)
	 {
	   super(pattern);
	 }
	 protected void finalizeConverter(char c)
	 {
	   if (c == 'u')
	   {
	     addConverter(new PINPatternConverter(formattingInfo));
	     currentLiteral.setLength(0);
	   }
	   else
	     super.finalizeConverter(c);
	 }
	 private static class PINPatternConverter extends PatternConverter
	 {
	   private final static String NO_USER_EMAIL = "null";
	   
	   PINPatternConverter(FormattingInfo formattingInfo)
	   {
	     super(formattingInfo);
	   }
	   
	   public String convert(LoggingEvent event)
	   {
	     String converted = null;
	     try
	     {
	        SecurityUser currentUser=null;
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null) {
				currentUser=(SecurityUser)auth.getPrincipal();
			}	    	 
           if(null != currentUser)
	         converted = currentUser.getUsername();  //      getEmail();
	       else
	         converted = NO_USER_EMAIL;
	     }
	     catch (Exception ex)
	     {
    	   converted = NO_USER_EMAIL;
	      // log.error("Error occured while getting current users PIN.", ex);
	     }
	     return converted;
	   }
	 }
	 
	 /**
		public UserDetailsVO getCurrentUserDetails() {
			UserDetailsVO user=null;
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null) {
				user=(UserDetailsVO)auth.getPrincipal();
				
			}
			return user;
		}
		**/
	}