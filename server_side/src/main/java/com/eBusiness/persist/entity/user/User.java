package com.eBusiness.persist.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.eBusiness.persist.entity.image.Image;
import com.eBusiness.security.Role;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class User implements Serializable {
	private static final long serialVersionUID = -7788619177798333712L;
	
    @Id
    @Column(name="OSTA_ID")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
      
    @Transient
	private boolean userRemovedDisplayedImages; 
    
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

	public String getHomeTelephoneNo() {
		return homeTelephoneNo;
	}

	public void setHomeTelephoneNo(String homeTelephoneNo) {
		this.homeTelephoneNo = homeTelephoneNo;
	}

	public String getMobileTelephoneNo() {
		return mobileTelephoneNo;
	}

	public void setMobileTelephoneNo(String mobileTelephoneNo) {
		this.mobileTelephoneNo = mobileTelephoneNo;
	}

	public String getCreationUser() {
		return creationUser;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public void setAccountNONLocked(int accountNONLocked) {
		this.accountNONLocked = accountNONLocked;
	}

	public void setAccountNONExpired(int accountNONExpired) {
		this.accountNONExpired = accountNONExpired;
	}

	public void setCredentialsNONExpired(int credentialsNONExpired) {
		this.credentialsNONExpired = credentialsNONExpired;
	}

	@Column(name="OSTA_FORENAMES")
	 private String forenames;
	 
	 @Column(name="OSTA_SURNAME")
	 private String surname;
	 
	 @Column(name="OSTA_HOME_TELEPHONE_NO")
	 private String homeTelephoneNo;
	 
	 @Column(name="OSTA_MOBILE_TELEPHONE_NO")
	 private String mobileTelephoneNo;
    
    @Column(name="OSTA_USERNAME")
    private String username;
    
    @Column(name="OSTA_PASSWORD")
    @JsonIgnore
    private String password;
    
    @Column(name="OSTA_SALARY")
    private long salary;
    
    @Column(name="OSTA_AGE")
    private int age;
    
	@Column(name="OSTA_TOKEN")
	private String token;
  	
	@Column(name="OSTA_EXPIRYTIME")
	private Date expiryTime;
	
	@Column(name="OSTA_EMAIL")
	private String email;
		    
    @Column(name="OSTA_ENABLED")
	private int enabled;
	
	@Column(name="OSTA_ACCOUNTNONLOCKED")
	private int accountNONLocked;
	
	@Column(name="OSTA_ACCOUNTNONEXPIRED")
	private int accountNONExpired;
	
	@Column(name="OSTA_CREDENTIALSNONEXPIRED")
	private int credentialsNONExpired;
		
	@Column(name="OSTA_CREATION_USER")
	private String creationUser;
	
	@Column(name="OSTA_CREATION_DATE")
	private Date creationDate;   
        
    @Column(name="OSTA_TERMINATION_DATE")
	private Date terminationDate;
    
    @Column(name="OSTA_LASTPASSWORDRESET_DATE")
    private Date lastPasswordResetDate;
    
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
    
    public String getEmail() {
		return email;
   }
   public void setEmail(String email) {
		this.email = email;
   }	  
      
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
     


   
   
   
   
   
   
   
  //USER is the OWNINS OF ROLS
  	//==========================
  	@JoinTable (name = "OPUS_STAFF_ROLE_LINK", 
  	            joinColumns = { 
  	                      @JoinColumn(name = "OSRL_OSTA_ID", referencedColumnName = "OSTA_ID")    //  OPUS_STAFF_ROLE_LINK.OSRL_PIN       USER.OSTA_ID
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
  	
  	

      public Date getTerminationDate() {
  			return terminationDate;
  	}
      public void setTerminationDate(Date terminationDate) {
  			this.terminationDate = terminationDate;
  	}
      public static long getSerialversionuid() {
  			return serialVersionUID;
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
 
  	public void setCreationUser(String creationUser) {
  		this.creationUser = creationUser;
  	}

  	public void setCreationDate(Date creationDate) {
  		this.creationDate = creationDate;
  	}
    
    public Date getLastPasswordResetDate() {
  		return lastPasswordResetDate;
  	}

  	public void setLastPasswordResetDate(Date lastPasswordResetDate) {
  		this.lastPasswordResetDate = lastPasswordResetDate;
  	}
  	
  	
  	
  	public boolean isUserRemovedDisplayedImages() {
		return userRemovedDisplayedImages;
	}

	public void setUserRemovedDisplayedImages(boolean userRemovedDisplayedImages) {
		this.userRemovedDisplayedImages = userRemovedDisplayedImages;
	}
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
  	
   	public String toString() {
  		StringBuffer buffer= new StringBuffer();
  		buffer.append("{"+"\"id\""+":"+'"'+id+'"');  
  		buffer.append(",");
  		buffer.append("\"username\""+":"+'"'+username+'"');
   		return buffer.toString();
  	}
   
    
    
    
    
    
}
