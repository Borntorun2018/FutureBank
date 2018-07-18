package com.eBusiness.security;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;




/**
<class name="org.gmp.opus.security.vo.PermissionVO" table="OPUS_PERMISSION" schema="OPU_CDM" mutable="false" lazy="false">

<cache usage="read-only"/>

<id name="permissionId" type="java.lang.Long">
  <column name="OPRM_ID" precision="9" scale="0" />
  <generator class="sequence">
			<param name="sequence">OPRM_SEQ</param>
		</generator>
</id>

<property name="name" type="java.lang.String" >
  <column name="OPRM_NAME" length="30" not-null="true" />
</property>
<property name="screenName" column="OPRM_SCREEN_NAME" not-null="true" type="java.lang.String"/>
<property name="description" type="java.lang.String">
  <column name="OPRM_DESCRIPTION" length="200" not-null="true" />
</property>
<property name="application" column="OPRM_APPLICATION"/>

	<set name="permissionLink" inverse="true">
    <key column="ORPL_OPRM_ID"/>
    <one-to-many class="org.gmp.opus.security.vo.RolePermLinkVO"/>
</set>	
</class>
**/

@Entity
@Table(name="OPUS_PERMISSION")
public class Permission implements Serializable
{
    private static final long serialVersionUID = -2488619177698333312L;

	@Id
    @Column(name="OPRM_ID")
    private Long id;

    @Column(name="OPRM_NAME")
    private String name;

    @Column(name="OPRM_DESCRIPTION")
    private String description;
                      
    
    @Column(name="OPRM_APPLICATION")
    private String application;
    
            
    
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
 
	public String getApplication() {
		return application;
	}
	public void setApplication(String application) {
		this.application = application;
	}
	
 	
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Permission other = (Permission) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Privilege [name=").append(name).append("]").append("[id=").append(id).append("]");
        return builder.toString();
    }
}
