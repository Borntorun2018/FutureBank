package com.eBusiness.controller;

import com.eBusiness.config.JwtTokenUtil;
import com.eBusiness.exceptions.ServiceException;
import com.eBusiness.model.AuthToken;
import com.eBusiness.model.LoginUser;
import com.eBusiness.model.SecurityUserResponse;
import com.eBusiness.persist.entity.user.User;
import com.eBusiness.security.JwtUser;
import com.eBusiness.security.SecurityUser;
import com.eBusiness.service.user.UserService;

import com.eBusiness.exceptions.AuthenticationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserDetailsService userDetailsService;
 
    @Value("${jwt.header}")
    private String tokenHeader;
    
    @RequestMapping(value = "/login/auth", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginUser loginUser) throws AuthenticationException {
    	System.out.println("Inside register login user "+loginUser.getUsername());
    	authenticate(loginUser.getUsername(), loginUser.getPassword());
     	final UserDetails userDetails = userDetailsService.loadUserByUsername(loginUser.getUsername());
     	
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthToken(token));
       
    }
  
       
    @RequestMapping(value = "/logout/auth", method = RequestMethod.POST)
    public ResponseEntity<String> logout(@RequestBody LoginUser loginUser) throws AuthenticationException {
    	Optional<Authentication> auth=	Optional.ofNullable(SecurityContextHolder.getContext().getAuthentication());
    	if (auth.isPresent()) {
    		SecurityContextHolder.getContext().setAuthentication(null);
    	    //return new ResponseEntity("User successfully logged out",HttpStatus.OK);
    		 return ResponseEntity.ok("");
    	}else {
    		return new ResponseEntity("User unSuccessfully logged out",HttpStatus.EXPECTATION_FAILED);
    	}
    }
    
    /**
    @RequestMapping(value = "${jwt.route.authentication.refresh}", method = RequestMethod.GET)
    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
    	
        String authToken = request.getHeader(tokenHeader);
        
        final String token = authToken.substring(7);
        String username = jwtTokenUtil.getUsernameFromToken(token);
        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
       
        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
            String refreshedToken = jwtTokenUtil.refreshToken(token);
            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }**/
    
    
    
    
    
    
    
    
    
    //**** THIS IS CURRENTLY NOT USED
    
	//Get the current actual logged in user
    //=====================================
    /**
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
			 throw new ServiceException("error system failure during attempting to retrieve actual logged in user",e);					 
		}
		
		return new ResponseEntity<SecurityUserResponse>(response, HttpStatus.OK); 
    }
    **/	 
    
        
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
    private void authenticate(String username, String password) {
    	Objects.requireNonNull(username);
    	Objects.requireNonNull(password);
    	try {
    		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
    	}catch(DisabledException e) {
    		throw new AuthenticationException("User is disacbled",e);
    	}catch(BadCredentialsException e) {
    		throw new AuthenticationException("Bad credentials!",e);
    	}
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
