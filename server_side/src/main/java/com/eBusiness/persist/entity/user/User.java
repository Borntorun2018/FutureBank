package com.eBusiness.persist.entity.user;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.eBusiness.persist.entity.image.Image;
import com.eBusiness.security.Role;
import com.eBusiness.util.StringUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = -8788619177798333712L;
		
	 @Id
	 @Column(name="id")
	 @GeneratedValue(strategy= GenerationType.AUTO)
	 private long id;
	
	 @Transient
	 private boolean userRemovedDisplayedImages; 
	    	    
	 @Column(name="title")
	 private String title;
	    
	 @Column(name="gender")
	 private String gender;
			    
	 @Column(name="forenames")
	 private String forenames;
		 
	 @Column(name="surname")
	 private String surname;
		 
	 @Column(name="homePhoneNo")
	 private String homePhoneNo;
		 
	 @Column(name="mobilePhoneNo")
	 private String mobilePhoneNo;
		 
	 @Column(name="username")
	 private String username;
	   
	 @Column(name="password")
	 @JsonIgnore
	 private String password;
	   
	 @Column(name="salary")
	 private long salary;
	   
	 @Column(name="age")
	 private int age;
	   
	 @Column(name="dob")
	 private String dob=null;
	   
	 @Column(name="token")
	 private String token;
	 	
	 @Column(name="expiryTime")
	 private Date expiryTime;
		
	 @Column(name="email")
	 private String email;
			    
	 @Column(name="fullAddress")
	 public String  fullAddress;
		
	 @Column(name="addressLine1")
	 private String addressLine1;
		
	 @Column(name="addressLine2")
	 private String addressLine2;
	
	 @Column(name="addressLine3")
	 private String addressLine3;
		
	 @Column(name="addressCounty")
	 private String addressCounty;
	   
	 @Column(name="addressCity")
	 private String addressCity;

	 @Column(name="addressPostCode")
     private String addressPostCode=null;
	    
	 @Column(name="addressCountry")
	 private String addressCountry;
	    
	 @Column(name="fullDeliveryAddress")
	 private String fullDeliveryAddress;
	    
	 @Column(name="deliveryAddressLine1")
	 private String deliveryAddressLine1;
		
	 @Column(name="deliveryAddressLine2")
	 private String deliveryAddressLine2;
		
	 @Column(name="deliveryAddressLine3")
	 private String deliveryAddressLine3;
		
	 @Column(name="deliveryAddressCounty")
	 private String deliveryAddressCounty;
		
	 @Column(name="deliveryAddressCity")
	 private String deliveryAddressCity;
		
	 @Column(name="deliveryAddressPostCode")
	 private String deliveryAddressPostCode;
		
	 @Column(name="deliveryAddressCountry")
	 private String deliveryAddressCountry;
				
	 @Column(name="enabled")
	 private Integer enabled;
		
	 @Column(name="accountNONLocked")
	 private Integer accountNONLocked;
		
	 @Column(name="accountNONExpired")
	 private Integer accountNONExpired;
		
	 @Column(name="credentialsNONExpired")
	 private Integer credentialsNONExpired;
			
	 @Column(name="creationUser")
	 private String creationUser;
		
	 @Column(name="creationDate")
	 private Date creationDate;   
	       
	 @Column(name="terminationDate")
	 private Date terminationDate;
	   
	 @Column(name="lastPasswordResetDate")
	 private Date lastPasswordResetDate;
	    
	 @Column(name="accountEnabled")
	 private String accountEnabled="N";
	
	 @Column(name="member")
	 private String member;
	 //=======================================================================
	 public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public boolean isUserRemovedDisplayedImages() {
			return userRemovedDisplayedImages;
		}
		public void setUserRemovedDisplayedImages(boolean userRemovedDisplayedImages) {
			this.userRemovedDisplayedImages = userRemovedDisplayedImages;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getForenames() {
			return forenames;
		}
		public void setForenames(String forenames) {
			this.forenames = forenames;
		}
		public String getSurname() {
			return surname;
		}
		public void setSurname(String surname) {
			this.surname = surname;
		}
		public String getHomePhoneNo() {
			return homePhoneNo;
		}
		public void setHomePhoneNo(String homePhoneNo) {
			this.homePhoneNo = homePhoneNo;
		}
		public String getMobilePhoneNo() {
			return mobilePhoneNo;
		}
		public void setMobilePhoneNo(String mobilePhoneNo) {
			this.mobilePhoneNo = mobilePhoneNo;
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
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
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
		public String getFullAddress() {
			return fullAddress;
		}
		public void setFullAddress(String fullAddress) {
			this.fullAddress = fullAddress;
		}
		public String getAddressLine1() {
			return addressLine1;
		}
		public void setAddressLine1(String addressLine1) {
			this.addressLine1 = addressLine1;
		}
		public String getAddressLine2() {
			return addressLine2;
		}
		public void setAddressLine2(String addressLine2) {
			this.addressLine2 = addressLine2;
		}
		public String getAddressLine3() {
			return addressLine3;
		}
		public void setAddressLine3(String addressLine3) {
			this.addressLine3 = addressLine3;
		}
		public String getAddressCounty() {
			return addressCounty;
		}
		public void setAddressCounty(String addressCounty) {
			this.addressCounty = addressCounty;
		}
		public String getAddressCity() {
			return addressCity;
		}
		public void setAddressCity(String addressCity) {
			this.addressCity = addressCity;
		}
		public String getAddressPostCode() {
			return addressPostCode;
		}
		public void setAddressPostCode(String addressPostCode) {
			this.addressPostCode = addressPostCode;
		}
		public String getAddressCountry() {
			return addressCountry;
		}
		public void setAddressCountry(String addressCountry) {
			this.addressCountry = addressCountry;
		}
		public String getFullDeliveryAddress() {
			return fullDeliveryAddress;
		}
		public void setFullDeliveryAddress(String fullDeliveryAddress) {
			this.fullDeliveryAddress = fullDeliveryAddress;
		}
		public String getDeliveryAddressLine1() {
			return deliveryAddressLine1;
		}
		public void setDeliveryAddressLine1(String deliveryAddressLine1) {
			this.deliveryAddressLine1 = deliveryAddressLine1;
		}
		public String getDeliveryAddressLine2() {
			return deliveryAddressLine2;
		}
		public void setDeliveryAddressLine2(String deliveryAddressLine2) {
			this.deliveryAddressLine2 = deliveryAddressLine2;
		}
		public String getDeliveryAddressLine3() {
			return deliveryAddressLine3;
		}
		public void setDeliveryAddressLine3(String deliveryAddressLine3) {
			this.deliveryAddressLine3 = deliveryAddressLine3;
		}
		public String getDeliveryAddressCounty() {
			return deliveryAddressCounty;
		}
		public void setDeliveryAddressCounty(String deliveryAddressCounty) {
			this.deliveryAddressCounty = deliveryAddressCounty;
		}
		public String getDeliveryAddressCity() {
			return deliveryAddressCity;
		}
		public void setDeliveryAddressCity(String deliveryAddressCity) {
			this.deliveryAddressCity = deliveryAddressCity;
		}
		public String getDeliveryAddressPostCode() {
			return deliveryAddressPostCode;
		}
		public void setDeliveryAddressPostCode(String deliveryAddressPostCode) {
			this.deliveryAddressPostCode = deliveryAddressPostCode;
		}
		public String getDeliveryAddressCountry() {
			return deliveryAddressCountry;
		}
		public void setDeliveryAddressCountry(String deliveryAddressCountry) {
			this.deliveryAddressCountry = deliveryAddressCountry;
		}
		public Integer getEnabled() {
			return enabled;
		}
		public void setEnabled(Integer enabled) {
			this.enabled = enabled;
		}
		public Integer getAccountNONLocked() {
			return accountNONLocked;
		}
		public void setAccountNONLocked(Integer accountNONLocked) {
			this.accountNONLocked = accountNONLocked;
		}
		public Integer getAccountNONExpired() {
			return accountNONExpired;
		}
		public void setAccountNONExpired(Integer accountNONExpired) {
			this.accountNONExpired = accountNONExpired;
		}
		public Integer getCredentialsNONExpired() {
			return credentialsNONExpired;
		}
		public void setCredentialsNONExpired(Integer credentialsNONExpired) {
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
		public Date getLastPasswordResetDate() {
			return lastPasswordResetDate;
		}
		public void setLastPasswordResetDate(Date lastPasswordResetDate) {
			this.lastPasswordResetDate = lastPasswordResetDate;
		}
		public String getAccountEnabled() {
			return accountEnabled;
		}
		public void setAccountEnabled(String accountEnabled) {
			this.accountEnabled = accountEnabled;
		}
		public String getMember() {
			return member;
		}
		public void setMember(String member) {
			this.member = member;
		}	 
	//====================================================================		
	 public String getAccountStatus() {
	   if ("Y".equalsIgnoreCase(accountEnabled)) return "Enabled";
	   else return "Disabled";
	 }
	 public String getAddress()
	 {
	   	return StringUtil.checkEmailParam(addressLine1)+" \r"+ 
	   		   StringUtil.checkEmailParam(addressLine2)+" \r"+ 
	   		   StringUtil.checkEmailParam(addressCity)+" \r"+
	   		   StringUtil.checkEmailParam(addressPostCode)+" \r"+
	   		   StringUtil.checkEmailParam(addressCountry);
	}
		    
	public String getDeliveryAddress()
	{
	  return StringUtil.checkEmailParam(deliveryAddressLine1)+" \r"+ 
	         StringUtil.checkEmailParam(deliveryAddressLine2)+" \r"+ 
	    	 StringUtil.checkEmailParam(deliveryAddressCity)+" \r"+
	    	 StringUtil.checkEmailParam(deliveryAddressPostCode)+" \r"+
	    	 StringUtil.checkEmailParam( deliveryAddressCountry);
	}
		
	public String getEmail() {
	  if (!StringUtil.isEmpty(this.email))this.email=this.email.trim();
	  return this.email;
	}
	public void setEmail(final String email) {
	  this.email = email;
	}	    
	//===========================================================================
	//User Image
	//One User is associated with many Images
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "user",fetch = FetchType.EAGER) 
	private Set<Image> images;
	public Set<Image> getImages() {
		return images;
	}
	public void setImages(Set<Image> images) {
		this.images = images;
	}
	public void addImage(Image image) {
	  images.add(image);
	  image.setUser(this);
	}
	public void removeImage(Image image) {
	   images.remove(image);
	   image.setUser(null);
	}
	public void removeAllImages() {
	  images.stream().forEach(image->removeImage(image));
	}	
    //===========================================================================
	//USER is the OWNINS OF ROLS
  	//==========================
  	@JoinTable (name = "OPUS_STAFF_ROLE_LINK", 
  	            joinColumns = { 
  	                      @JoinColumn(name = "OSRL_OSTA_ID", referencedColumnName = "id")    //  OPUS_STAFF_ROLE_LINK.OSRL_PIN       USER.OSTA_ID
  	                          },
  	            inverseJoinColumns ={ 
  	                      @JoinColumn(name = "OSRL_OROL_ID", referencedColumnName = "OROL_ID") //  OPUS_STAFF_ROLE_LINK.OSRL_OROL_ID   OPUS_ROLE.OROL_ID
        	  	               }
	      )
	  		
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER ) 
	private Set<Role> roles = new HashSet<>();	
	 		
	public void removeRole(Role role) {
	  roles.remove(role);
	}
	public void removeAllRoles(){
	  roles.clear();
	}
  	public Set<Role> getRoles() {
      return roles;
  	}
	public void setRoles(Set<Role> roles) {
	  this.roles = roles;
	}
	//===========================================================================
	  	
	  	
	   
	    
}
