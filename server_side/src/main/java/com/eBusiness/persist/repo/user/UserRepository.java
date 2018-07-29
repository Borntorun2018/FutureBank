package com.eBusiness.persist.repo.user;
import java.util.Set;

import org.hibernate.Hibernate;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import com.eBusiness.persist.entity.user.User;
import com.eBusiness.persist.repo.GeneralJpaSpecificationExecutor;
import com.eBusiness.security.Role;



/**
 * Abstract class JpaSpecificationExecutor
 * =======================================
 * contains the following:-
 * 
 * public abstract Object findOne(Specification arg0);
 * public abstract List   findAll(.Specification arg0);
 * public abstract Page   findAll(Specification arg0, Pageable arg1);
 * public abstract List   findAll(Specification arg0, Sort arg1);
 * public abstract long   count(Specification arg0);
 * 
 * @author 62065
 *
 */
@Transactional
@RepositoryRestResource
public interface UserRepository extends PagingAndSortingRepository<User, Long>,GeneralJpaSpecificationExecutor<User>  { 
	
		
	public User findByEmail(String email);
	
	
	public default  Set<Role> getUserRoles(User user){
		if (user.getRoles() != null){
			Hibernate.initialize(user);
			Hibernate.initialize(user.getRoles());
		}
		return user.getRoles();
	}
		
	
	//Following methods are provided via inheritance
	//Note:- JpaSpecificationExecutor  (i.e.  GeneralJpaSpecificationExecutor<ENTITY> extends JpaSpecificationExecutor<ENTITY>)
	//=========================================================================================================================
	//public abstract java.lang.Object findOne(org.springframework.data.jpa.domain.Specification arg0);
	//public abstract java.util.List findAll(org.springframework.data.jpa.domain.Specification arg0);
	//public abstract org.springframework.data.domain.Page findAll(org.springframework.data.jpa.domain.Specification arg0, org.springframework.data.domain.Pageable arg1);
	//public abstract java.util.List findAll(org.springframework.data.jpa.domain.Specification arg0, org.springframework.data.domain.Sort arg1);
	//public abstract long count(org.springframework.data.jpa.domain.Specification arg0);	
	
	
	//Note:- PagingAndSortingRepository contains:-
	//===========================================
	//public abstract java.lang.Iterable findAll(org.springframework.data.domain.Sort arg0);
	//public abstract org.springframework.data.domain.Page findAll(org.springframework.data.domain.Pageable arg0);
}
