package com.smartbank.security;

import java.util.ArrayList;
import java.util.Collection;

import java.util.Set;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smartbank.persist.entity.user.User;
import com.smartbank.persist.repo.user.UserRepository;


@Service("userDetailsService")
public class SecurityUserDetailsService implements UserDetailsService{
	
  private static final Logger log = Logger.getLogger(SecurityUserDetailsService.class);	
	
	
  @Autowired
  private UserRepository repository;
    
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	  
	try{
	    User user=repository.findByEmail(username);    
	    if(null == user){
	    	log.error("Error occurred during and attempted login. User with the email:"+username+" was not found in the database");
	    	throw new UsernameNotFoundException("No user present with username: "+username);	  
	    }
	    		
		Collection<GrantedAuthority> authorities = new ArrayList<>();
		Set<Role> userRoles = user.getRoles();
		
		if (userRoles == null){
			log.error("Error occurred during and attempted login. User with the email:"+username+" no rolls found in the database for this user");
			throw new UsernameNotFoundException("No user rolls present with username: "+username);	
		}
			  
		//Add the current user roles to authorities collection
		UserAuthorites userAuthorites = (role) ->{assignUserAuthorites(authorities,role);};
		userRoles.stream().forEach(role-> userAuthorites.setUserAuthorites(role));
			 	    
  	    SecurityUser securityUser =new SecurityUser(user);
  	    securityUser.setAuthorities(authorities);
  	  
	    return securityUser;
	    
	}catch (Exception e){
	   log.error("Error occurred during and attempted login. using email:"+username,e);
       throw new UsernameNotFoundException("User not found");
    }
  }	
  
  /**
   * The following Interface and method are used to setup the users Roles
   * @author 62065
   *
   */
 @FunctionalInterface
 interface UserAuthorites{
	  public void setUserAuthorites(Role role);
  }
  private void assignUserAuthorites(Collection<GrantedAuthority> authorities, Role role){
	    SimpleGrantedAuthority authority = new SimpleGrantedAuthority(role.getName());
	    authorities.add(authority);
  }
}
