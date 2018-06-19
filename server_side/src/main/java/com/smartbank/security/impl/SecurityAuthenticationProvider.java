package com.smartbank.security.impl;

import java.util.Date;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.smartbank.persist.entity.user.User;
import com.smartbank.persist.entity.user.UserAttempts;
import com.smartbank.persist.repo.user.UserLoginAttemptsRepository;
import com.smartbank.persist.repo.user.UserRepository;


//   https://www.mkyong.com/spring-security/spring-security-limit-login-attempts-example/
@Component("securityAuthenticationProvider")
public class SecurityAuthenticationProvider extends DaoAuthenticationProvider{
	
	private static final Logger log = Logger.getLogger(SecurityAuthenticationProvider.class);	
    private static final int MAX_ATTEMPTS = 3;
	 
	@Autowired
	private UserLoginAttemptsRepository userLoginAttemptsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	@Qualifier("userDetailsService") //Note that this is SecurityUserDetailsService implements UserDetailsService
	@Override
	public void setUserDetailsService(UserDetailsService userDetailsService) {
		super.setUserDetailsService(userDetailsService);
	}
  	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

	  try {
		//By calling the spring class it undertakes a check to determine if the current user account is locked.    
		Authentication auth = super.authenticate(authentication);
		//since we reached here, it means login success. So reset the fail attempts to zro		
		userLoginAttemptsRepository.resetFailAttempts(auth.getName());
		log.debug("User has succ logged in");
		return auth;
	  } catch (BadCredentialsException e) {
		  try{
			  
			//Check that this user exits in our system
			//=========================================
			if  (isUserExists(authentication.getName())){ 
				//Update the number of attempts to login for this user. 
				//=====================================================  
			    updateFailAttempts(authentication.getName());
			    //Since the user has not exceeded the number of login attempts
			    //============================================================
				UserAttempts userAttempts = userLoginAttemptsRepository.findByUsername(authentication.getName());
				int noOfAttempts  = userAttempts.getAttempts();
				log.error("Loggin failed. Incorrect username/password. You have "+ (3 - noOfAttempts) +" login attempts left out of 3");
			    throw new BadCredentialsException("Loggin failed. Incorrect username/password. You have "+ (3 - noOfAttempts) +" login attempts left out of 3");
			}else{
				log.error("Loggin failed. Your username was not found in the system . Please contact the Help Desk (i.e. via the Contact Us link)");
				throw new BadCredentialsException("Loggin failed. Your username was not found in the system . Please contact the Help Desk (i.e. via the Contact Us link)");
			}
		  }catch(LockedException le){
			log.error("Loggin failed. user account is currently Locked.");
			throw new LockedException(buildLockedExceptionErrorMsg(authentication.getName()));
		  }
	  } catch (LockedException e){
		  log.error("Loggin failed. user account is currently Locked.");
		  throw new LockedException(buildLockedExceptionErrorMsg(authentication.getName()));  
	  } catch (AccountExpiredException e){
		  log.error("Loggin failed. Your user account has expired. Please contact the Help Desk (via the Contact Us link)");
		  throw new AccountExpiredException("Loggin failed. Your user account has expired. Please contact the Help Desk (via the Contact Us link)");
	  } catch (UsernameNotFoundException e){
		  log.error("Loggin failed. Your username was not found in the system . Please contact the Help Desk (i.e. via the Contact Us link)");
		  throw new UsernameNotFoundException("Loggin failed. Your username was not found in the system . Please contact the Help Desk (i.e. via the Contact Us link)");
	  } 
    }
	
/**
	@Override
	public void setPasswordEncoder(Object passwordEncoder){
		super.setPasswordEncoder(passwordEncoder());
	}
	private PasswordEncoder passwordEncoder(){
	  PasswordEncoder encoder = new StandardPasswordEncoder();
	  return encoder;
	}
**/	
	
	
  private String buildLockedExceptionErrorMsg(String username){
	String error = "";
	UserAttempts userAttempts = userLoginAttemptsRepository.findByUsername(username);
	if (userAttempts!=null){
	  Date lastAttempts = userAttempts.getLastModified();
	  error = "Loggin failed. Your user account is locked. Last Attempt was " +lastAttempts + " Please reset your password (i.e. via the Forgot Password link)";
	}else{
	   error = "Loggin failed. Your user account is locked. Please reset your password (i.e. via the Forgot Password link)";
	}	
	return error;
  }
  
 
	
  private void updateFailAttempts(String username) {
      //Get the record containing the users login attempts
	  UserAttempts userAttepts = userLoginAttemptsRepository.findByUsername(username);
	  
	  //Check if we have a record were users login attempts are recorded
	  if (userAttepts == null) {  //No retry attempts
		if (isUserExists(username)) {   //We have a user so create the first user attempt
		    // So lets create a record that will contain a users login attempts
			UserAttempts userAttempts = new UserAttempts(username,1,new Date()); 
			userLoginAttemptsRepository.save(userAttempts);
		}
	  } else {

		//We have found a users login attempts record  
		//===========================================
		//Double checking that we have a user record associated with the login attempts 
		  if (isUserExists(username)) {
			
			//Since we already have a login attempt for this user lets check if we have already reached the max 3 attempts before adding another  
			 if (userAttepts.getAttempts()< MAX_ATTEMPTS) {
		       //Not reached the max counts allowed so update login attempts count by 1 for this user
		       userLoginAttemptsRepository.updateFailAttempts(new Date(),username);
			 }
		}

		//Check if this user has exceeded the no of login retries
		//=======================================================  
		if (userAttepts.getAttempts() + 1 >= MAX_ATTEMPTS) {
			// Oh dear the user needs to be locked user
			//=========================================
			User user =userRepository.findByEmail(username);
			user.setAccountNONLocked(0);  //false
			userRepository.save(user);   ///	getJdbcTemplate().update(SQL_USERS_UPDATE_LOCKED, new Object[] { false, "N", username });
			// throw exception
			throw new LockedException("User Account is locked!");
		}

	  }
  }
  private boolean isUserExists(String username) {

	  boolean result = false;

	  try{
	    User user =userRepository.findByEmail(username);
	    if (user != null) {
			result = true;
		}else{
			log.debug("Inside SecurityAuthenticationProvider calling userRepository.findByEmail("+username+") USER HAS NOT BEEN FOUND");
		}
	  }catch(Exception e){
		  log.error("Error Inside SecurityAuthenticationProvider calling userRepository.findByEmail("+username+")",e);
	  }
	  
	  return result;
	}
}
