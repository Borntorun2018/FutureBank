package com.eBusiness.security;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import com.eBusiness.exceptions.DataAccessException;
import com.eBusiness.persist.entity.user.User;



public interface RolesDetailsService {
	
	  public void assignRoleToUser(final Role role, final User user) throws DataAccessException;
	  
	  public void assignRolesToUser(final  Set<Role> roles, final User user) throws DataAccessException;
	  
	  public  Role findRole(final Long roleId)throws DataAccessException;
	  
	  public  Optional<Stream<Role>> findAllUserRoles(final User user)throws DataAccessException;
	  
	  public  Optional<Stream<Role>> findAllRoles()throws DataAccessException;
	  
	  public void deleteAllUserRoles(final User user)throws DataAccessException;
	  	
	  public void deleteRoleFromUser(final User user, Role role)throws DataAccessException;
	  
	  public  Optional<List<Role>> availableRoles (final List<Role>userRoles)throws DataAccessException;
	
}
