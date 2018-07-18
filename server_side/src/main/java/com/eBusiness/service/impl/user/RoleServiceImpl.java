package com.eBusiness.service.impl.user;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eBusiness.exceptions.DataAccessException;
import com.eBusiness.persist.entity.user.User;
import com.eBusiness.persist.repo.user.RoleRepository;
import com.eBusiness.persist.repo.user.UserRepository;
import com.eBusiness.security.Role;
import com.eBusiness.service.user.RoleService;
import com.eBusiness.util.StreamableIterable;


@Service("roleService")
@Transactional
public class RoleServiceImpl implements  RoleService{
	 private static final Logger log = Logger.getLogger(RoleServiceImpl.class);

	 @Autowired
	 RoleRepository roleRepository;
	 
	 @Autowired
	 UserRepository userRepository;
	 
	 //@Autowired
	 //PropertyService propertyService;	 
	
	 
	 /**
	  * Assign a Role to the user
	  * @param role
	  * @param user
	  * @throws DataAccessException
	  */
	 @Transactional	
	 public void assignRoleToUser(final Role role, final User user) throws DataAccessException{
	   Set<Role> roles = new HashSet<>();
	   roles.add(role);
	   assignRolesToUser(roles,user);
	 }
	 
	 /**
	  * Assign Roles to the user
	  * @param roles
	  * @param user
	  * @throws DataAccessException
	  */
	 @Transactional	
	 public void assignRolesToUser(final  Set<Role> roles, final User user) throws DataAccessException{
		   try{
		   user.setRoles(roles);
		   userRepository.save(user);
		   }catch(org.springframework.dao.DataAccessException dae){
				throw new DataAccessException("error calling repository save");
			}					   
	 }
	 
	 /**
	  * Find the Role associated with the roleId
	  * @param roleId
	  * @return
	  * @throws DataAccessException
	  */
	 @Transactional	
	 public  Role findRole(Long roleId)throws DataAccessException{
			try{
				return (Role)roleRepository.findOne(roleId);
			}catch(org.springframework.dao.DataAccessException dae){
				throw new DataAccessException("error calling repository findOne");
			}
	 }
	 
	 /**
	  * Find the current users roles
	  * @param user
	  * @return
	  * @throws DataAccessException
	  */
	 @Transactional	
	 public   Optional<Stream<Role>> findAllUserRoles(final User user)throws DataAccessException{
		try{
			 return convertIterableToStream(userRepository.getUserRoles(user));
			}catch(org.springframework.dao.DataAccessException dae){
				throw new DataAccessException("error calling repository findOne");
			}
	}
	/**
	 * Find all the systems roles 
	 * @return
	 * @throws DataAccessException
	 */
	@Transactional	
	public  Optional<Stream<Role>> findAllRoles()throws DataAccessException{
		try{
			Iterable<Role> roles= roleRepository.findAll();
			return convertIterableToStream(roles);
		}catch(org.springframework.dao.DataAccessException dae){
				throw new DataAccessException("error calling repository findOne");
		}
	}
	private Optional<Stream<Role>> convertIterableToStream(Iterable<Role> roles){
		Optional<Iterable<Role>> optRoles = Optional.of(roles);
		if (optRoles.isPresent()){
			return Optional.of(StreamableIterable.streamOf((Iterable<Role>)optRoles.get()));
		}else{
			return Optional.empty();
		}
	}
	 
	/**
	 * Delete all the current users Roles 
	 * @param user
	 * @throws DataAccessException
	 */
	@Transactional	
	public void deleteAllUserRoles(final User user)throws DataAccessException{
		 Optional<Set<Role>> userRoles =Optional.of(userRepository.getUserRoles(user));
		 if (userRoles.isPresent()){
			 try{
			 roleRepository.delete(userRoles.get());
			 }catch(Exception e){
				 e.printStackTrace();
				 throw new DataAccessException("",e);
			 }
		 }
	}
	
	@Transactional	
	public void deleteRoleFromUser(final User user, Role role)throws DataAccessException{
		roleRepository.delete(role);
	}
}
