package com.eBusiness.security;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JwtUser implements UserDetails{
	    private static final long serialVersionUID = -778861917779843712L;
	    
	    
	    private long id;
	    private String username;
	    private String password;
	    private boolean accountNonExpired;
	    private boolean accountNonLocked;
	    private boolean credentialsNonExpired;
	    private boolean enabled;   //int
	    
	    private long salary;
	    private int age;
		private String token;
		private Date expiryTime;
		private String email;
		private int accountNONLocked;
		private int accountNONExpired;
		private int credentialsNONExpired;
		private String creationUser;
		private Date creationDate;   
		private Date terminationDate;
		
		public Collection<? extends GrantedAuthority> getAuthorities() {
			return authorities;
		}
		public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
			this.authorities = authorities;
		}
		Collection<? extends GrantedAuthority>authorities;
	        
	    public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public boolean isAccountNonExpired() {
			return accountNonExpired;
		}
		public void setAccountNonExpired(boolean accountNonExpired) {
			this.accountNonExpired = accountNonExpired;
		}
		public boolean isAccountNonLocked() {
			return accountNonLocked;
		}
		public void setAccountNonLocked(boolean accountNonLocked) {
			this.accountNonLocked = accountNonLocked;
		}
		public boolean isCredentialsNonExpired() {
			return credentialsNonExpired;
		}
		public void setCredentialsNonExpired(boolean credentialsNonExpired) {
			this.credentialsNonExpired = credentialsNonExpired;
		}
		public boolean isEnabled() {
			return enabled;
		}
		public void setEnabled(boolean enabled) {
			this.enabled = enabled;
		}
		public long getSalary() {
			return salary;
		}
		public void setSalary(long salary) {
			this.salary = salary;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
		public Date getExpiryTime() {
			return expiryTime;
		}
		public void setExpiryTime(Date expiryTime) {
			this.expiryTime = expiryTime;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getAccountNONLocked() {
			return accountNONLocked;
		}
		public void setAccountNONLocked(int accountNONLocked) {
			this.accountNONLocked = accountNONLocked;
		}
		public int getAccountNONExpired() {
			return accountNONExpired;
		}
		public void setAccountNONExpired(int accountNONExpired) {
			this.accountNONExpired = accountNONExpired;
		}
		public int getCredentialsNONExpired() {
			return credentialsNONExpired;
		}
		public void setCredentialsNONExpired(int credentialsNONExpired) {
			this.credentialsNONExpired = credentialsNONExpired;
		}
		public String getCreationUser() {
			return creationUser;
		}
		public void setCreationUser(String creationUser) {
			this.creationUser = creationUser;
		}
		public Date getCreationDate() {
			return creationDate;
		}
		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}
		public Date getTerminationDate() {
			return terminationDate;
		}
		public void setTerminationDate(Date terminationDate) {
			this.terminationDate = terminationDate;
		}
		
	    
}
