package com.smartbank.persist.repo.user;

import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.smartbank.persist.repo.GeneralJpaSpecificationExecutor;
import com.smartbank.security.Role;

@Transactional
@RepositoryRestResource
public interface RoleRepository extends CrudRepository<Role,Long>, GeneralJpaSpecificationExecutor<Role>  { 
	
	//public  Set<Role> getUserRoles(User user);
	public  Role save(Role role);
	
	
	
	
	
	
	
}
