package com.smartbank.service.user;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import com.smartbank.exceptions.DataAccessException;
import com.smartbank.persist.entity.user.User;
import com.smartbank.security.Role;


public interface RoleService {
	
	 public void assignRoleToUser(final Role role, final User user) throws DataAccessException;

	 public void assignRolesToUser(final  Set<Role> roles, final User user) throws DataAccessException;
	 	
	 public  Role findRole(Long roleId)throws DataAccessException;
	 
	 public  Optional<Stream<Role>> findAllUserRoles(final User user)throws DataAccessException;
	
	 public  Optional<Stream<Role>> findAllRoles()throws DataAccessException;

	 public void deleteAllUserRoles(final User user)throws DataAccessException;
		
	 public void deleteRoleFromUser(final User user, Role role)throws DataAccessException;

}
