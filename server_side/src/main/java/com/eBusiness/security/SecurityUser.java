package com.eBusiness.security;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.eBusiness.persist.entity.user.User;



public class SecurityUser implements UserDetails{	
	
	private static final long serialVersionUID = 1L;
	
	private Collection<GrantedAuthority> authorities;
	
	private User user;

	public SecurityUser(User user) {
	  this.user=user;	
	}	
	
	//Note that it is possible during development that some of the users
	//in the database will not have 1 or 0 within the below fields.
	//This should not happen, but as a check for NULL values the added NULL check
	//has been added.
	
	@Override
	public boolean isAccountNonExpired() {  
	  if (user.getAccountNONExpired()==null)return false;  //Defaults to account expired if null
	  return (user.getAccountNONExpired() != 0);		  
	}
	@Override
	public boolean isAccountNonLocked() {
		if (user.getAccountNONLocked()==null)return false;  //Defaults to locked if null
	  return (user.getAccountNONLocked() != 0);
	}
	@Override
	public boolean isCredentialsNonExpired() {
	  if (user.getCredentialsNONExpired()==null)return false;  //Defaults to cred expired if null
	  return (user.getCredentialsNONExpired() != 0);  
	}
	@Override
	public boolean isEnabled() {
	  if (user.getEnabled()==null)return false;  //Defaults to disabled if null
	  return (user.getEnabled() != 0);  
	}	
	
	@Override
	 public String getUsername() {
	  return user.getEmail();
	}	
	
	@Override
	public String getPassword() {
	  return user.getPassword();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	   return this.authorities;	
	}
	
	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	
	public User getUser(){
		return this.user;
	}
}
