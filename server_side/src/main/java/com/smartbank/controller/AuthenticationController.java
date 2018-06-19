package com.smartbank.controller;



import com.smartbank.config.JwtTokenUtil;
import com.smartbank.exceptions.ServiceException;
import com.smartbank.model.AuthToken;
import com.smartbank.model.LoginUser;
import com.smartbank.model.SecurityUserResponse;
import com.smartbank.persist.entity.user.User;
import com.smartbank.security.SecurityUser;
import com.smartbank.service.user.UserService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> register(@RequestBody LoginUser loginUser) throws AuthenticationException {

    	System.out.println("Inside register login user "+loginUser.getUsername());
        final Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginUser.getUsername(),
                        loginUser.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final User user = userService.findOne(loginUser.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new AuthToken(token));
    }
    
    
    
    
	//Get the current actual logged in user
    //=====================================
	@RequestMapping(value = "/currentUser", method = RequestMethod.GET)
	public ResponseEntity<SecurityUserResponse> currentActualLoggedInUser() throws ServiceException {
		SecurityUserResponse response = new SecurityUserResponse();
		try {
			
		  Object authentication =	SecurityContextHolder.getContext().getAuthentication();
		  if (authentication instanceof UserDetails) {
			  
			  SecurityUser user = (SecurityUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			  List<SecurityUser>loggedInUser = new ArrayList();
			  loggedInUser.add(user);
			  response.setUsers(loggedInUser);
			  response.setCode(HttpStatus.OK.name());
			  response.setMessage("succ retrieved actual loggedin user");
		  }else {
			  response.setCode(HttpStatus.UNAUTHORIZED.name());
			  response.setMessage("Error user is not loggedin");
		  }

		}catch(Exception e){
			 //log.error(propertyService.getPropertyValue("error.attempting.retrieve.actual.logged.in.user"),e.getCause());
			 throw new ServiceException("error system failure during attempting to retrieve actual logged in user",e);					 
		}
		
		//log.debug(propertyService.getPropertyValue("info.succ.retrieved.actual.logged.in.user"));	
		//log.debug(propertyService.getPropertyValue("info.exit.restful.userManagerController.currentActualLoggedInUser"));
		return new ResponseEntity<SecurityUserResponse>(response, HttpStatus.OK); 
    }	 
    
        
	/**
	 * This service would only be called if the pre filter call to JwtAuthenticationFilter validated
	 * the users JWT
	 * @return
	 * @throws ServiceException
	 */
	@RequestMapping(value = "/currentUserJWT", method = RequestMethod.GET)
	public ResponseEntity<SecurityUserResponse> validateCurrentLoggedInUserJWT() throws ServiceException {
		SecurityUserResponse response = new SecurityUserResponse();
		response.setCode(HttpStatus.OK.name());
		response.setMessage("succ retrieved actual loggedin user");
		return new ResponseEntity<SecurityUserResponse>(response, HttpStatus.OK); 
    }	 

	/**
   @RequestMapping(value = "/currentUser", method = RequestMethod.GET)
    public ResponseEntity<User> curLoggedInUser() throws AuthenticationException {
    	
    	
    	System.out.println("Inside curLoggedInUser ");
    	 	
    	
        //Object object = SecurityContextHolder.getContext().getAuthentication();
        //Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        //Object username= auth.getPrincipal();
        //Object credentials = auth.getCredentials();
        //Object authorities = auth.getAuthorities();
        //Object details = auth.getDetails();
        
        User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        
        
        
        
          Get the username of the logged in user: getPrincipal()
          Get the password of the authenticated user: getCredentials()
          Get the assigned roles of the authenticated user: getAuthorities()
          Get further details of the authenticated user: getDetails()
        
          
        
        
        
        
        return ResponseEntity.ok(user);
    }
    **/
}
