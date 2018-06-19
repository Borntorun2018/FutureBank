package com.smartbank.security;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="OPUS_ROLE")
public class Role implements Serializable
{
  private static final long serialVersionUID = -3788619177798333312L;
  
  
  
  @Id
  @Column(name = "OROL_ID")
  private Long id;
  
  @Column(name = "OROL_NAME")
  private String name;
  
  @Column(name = "OROL_DESCRIPTION")
  private String description;
  
  @Column(name = "OROL_APPLICATION")
  private String application;
  
    
  
 public String getApplication() {
	return application;
}
public void setApplication(String application) {
	this.application = application;
}
  //Role is OWNINS to Permission
  @JoinTable (name = "OPUS_ROLE_PERM_LINK", 
		  joinColumns ={@JoinColumn(name = "ORPL_OROL_ID",  referencedColumnName = "OROL_ID")},        //**Link via OPUS_ROLE_PERM_LINK.ORPL_OROL_ID = OPUS_ROLE.OROL_ID **//
		  inverseJoinColumns = {@JoinColumn(name = "ORPL_OPRM_ID", referencedColumnName = "OPRM_ID")   //**Link via OPUS_ROLE_PERM_LINK.ORPL_OPRM_ID = OPUS_PERMISSION.OPRM_ID **//
			            }

		  )
  
 
@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.EAGER) 
private Set<Permission> permissions;

public Set<Permission> getPermissions() {
	return permissions;
}
public void setPermissions(Set<Permission> permissions) {
	this.permissions = permissions;
}

	public Role() {
        super();
    }
    public Role(final String name) {
        super();
        this.name = name;
    }
         
   
     
    public Long getId() {
        return id;
    }
    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(final String name) {
        this.name = name;
    }

    public String getDescription() {
 		return description;
 	}
 	public void setDescription(String description) {
 		this.description = description;
 	}


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Role role = (Role) obj;
        if (!role.equals(role.name)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Role [name=").append(name).append("]").append("[id=").append(id).append("]");
        return builder.toString();
    }
}