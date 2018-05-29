package com.smartbank.persist.repo.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.smartbank.persist.repo.GeneralJpaSpecificationExecutor;
import com.smartbank.security.UserRoleLink;

@Transactional
@RepositoryRestResource
public interface UserRoleRepository extends CrudRepository<UserRoleLink,Long>, GeneralJpaSpecificationExecutor<UserRoleLink>  { 
	
	public  UserRoleLink save(UserRoleLink userRoleLink);
	
}
