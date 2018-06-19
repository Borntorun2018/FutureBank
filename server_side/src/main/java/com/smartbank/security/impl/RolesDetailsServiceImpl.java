package com.smartbank.security.impl;


import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartbank.exceptions.DataAccessException;
import com.smartbank.persist.entity.user.User;
import com.smartbank.security.Role;
import com.smartbank.security.RolesDetailsService;
import com.smartbank.service.user.RoleService;


@Service("rolesDetailsService")
public class RolesDetailsServiceImpl implements RolesDetailsService{
	
  private static final Logger log = Logger.getLogger(RolesDetailsServiceImpl.class);	
   
  @Autowired
  private RoleService roleService;
   	
  //Following methods are provided to enable Roles to be accessed via the SecurityManagaerController
  //================================================================================================
  public void assignRoleToUser(final Role role, final User user) throws DataAccessException{
	  roleService.assignRoleToUser(role,user);
  }
  public void assignRolesToUser(final  Set<Role> roles, final User user) throws DataAccessException{
	  roleService. assignRolesToUser(roles,user);
  }
  public  Role findRole(final Long roleId)throws DataAccessException{
	   return roleService.findRole(roleId);
  }
  public  Optional<Stream<Role>> findAllUserRoles(final User user)throws DataAccessException{
	   return roleService.findAllUserRoles(user);
  }
  public  Optional<Stream<Role>> findAllRoles()throws DataAccessException{
	   return roleService. findAllRoles();
  }
  public void deleteAllUserRoles(final User user)throws DataAccessException{
	   roleService.deleteAllUserRoles(user);
  }
  public void deleteRoleFromUser(final User user, Role role)throws DataAccessException{
	   roleService.deleteRoleFromUser(user,role);
  }
  public  Optional<List<Role>> availableRoles (final List<Role>userRoles)throws DataAccessException{
	  if (findAllRoles().isPresent()){
		  List<Role> allRoles =findAllRoles().get().collect(Collectors.toList());
	  	  userRoles.forEach(userRole->deleteRole(allRoles,userRole));
	  	  return Optional.of(allRoles);
	  }else{
		  return Optional.empty();
	  }
  }
  
  /**
   * This method removes the current user Roles from the total roles available
   * @param allRoles
   * @param userRole
   */
 private static void deleteRole (List<Role> allRoles, Role userRole) {
 	 allRoles.removeIf( i -> {
		    	return i.getName().equals(userRole.getName());
		 });
  }
  
}
