package com.eBusiness.controller;

import com.eBusiness.exceptions.DataAccessException;
import com.eBusiness.exceptions.FunctionWithThrowable;
import com.eBusiness.exceptions.ServiceException;
import com.eBusiness.exceptions.UtilException;
import com.eBusiness.model.Response;
import com.eBusiness.model.UserRequestWrapper;
import com.eBusiness.model.UserResponse;
import com.eBusiness.model.UserRoleRequestWrapper;
import com.eBusiness.persist.entity.user.User;
import com.eBusiness.persist.entity.user.UserSpecificationBuilder;
import com.eBusiness.security.Role;
import com.eBusiness.security.UserRoleLink;
import com.eBusiness.service.PropertyService;
import com.eBusiness.service.user.RoleService;
import com.eBusiness.service.user.UserService;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class UserController {

	private static final Logger log = Logger.getLogger(UserController.class);
	public final static String noReplyEmail 	="no-reply@eBusiness.com"; 
	private final static String SUCCES = "Succes";
		
    @Autowired
    private UserService userService;

    @Autowired
	PropertyService propertyService;
         
    @Autowired
    RoleService roleService;
    
    
    //Get all the current users
    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<User> listUser(){
    	try {
          return userService.findAllUsers();
    	}catch(DataAccessException dae) {
    		return new ArrayList<User>();
    	}
    }
    
    
    //Search for users
    //@PreAuthorize("hasAuthority('CORE OPUS')")
	 @RequestMapping(value = "user/search", method = RequestMethod.POST)
	 public ResponseEntity<UserResponse> search(@RequestBody UserRequestWrapper  request) throws ServiceException {	 	 
		 log.debug(propertyService.getPropertyValue("info.inside.restful.userManagerController.search"));
		 Page<User> result = null;
		 UserResponse response = new UserResponse();
		 try
		 {
			 UserSpecificationBuilder builder = new UserSpecificationBuilder();
			 Specification<User> specification=  builder.find(request.getUser());
		 
			 Pageable pageRequest = new PageRequest(
			        ((request.getPagination().getCurrentPage() == null) ? 0 : (request.getPagination().getCurrentPage()-1)), 
			        ((request.getPagination().getNumPerPage() == null) ? 10 :  request.getPagination().getNumPerPage()));
		 
			 result = userService.findAllUsers(specification, pageRequest);
			 			 
			 response.setCode(HttpStatus.OK.name());
			 response.setMessage(propertyService.getPropertyValue("info.succ.user.search"));
			 response.setUsers(result);
		  }catch(Exception e){
			  
			log.error(propertyService.getPropertyValue("error.restful.usermanagercontroller.search.msg"),e.getCause());
			throw new ServiceException(propertyService.getPropertyValue("error.system.failure.during.user.search.request"),e);
		 }
		 log.debug(propertyService.getPropertyValue("info.succ.user.search"));	
		 log.debug(propertyService.getPropertyValue("info.exit.restful.userManagerController.search"));	
		return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	  }
    
     //Get a User
	 //==========
	 //@PreAuthorize("hasAuthority('CORE OPUS')")
	 @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	 public ResponseEntity<UserResponse>  getUser(@PathVariable("id") String id) throws ServiceException {	 
		 log.debug(propertyService.getPropertyValue("info.exit.restful.userController.search"));		 
		 UserResponse response = new UserResponse();
		 User user = null;
		 try{
		   user = userService.findUser(id);    //findById(id);
		   List<User> content = new ArrayList();
		   content.add(user);
		   Page<User> users = new PageImpl<User>(content);
		   response.setUsers(users);
		   response.setCode(HttpStatus.OK.name());
		   response.setMessage(propertyService.getPropertyValue("info.succ.got.user"));
		 }catch(Exception e){
			 log.error(propertyService.getPropertyValue("error.restful.during.getUser"),e.getCause());
			 throw new ServiceException(propertyService.getPropertyValue("error.system.failure.during.user.details.request"),e);
		 }
		 
	     log.debug(propertyService.getPropertyValue("info.succ.got.user"));	
		 log.debug(propertyService.getPropertyValue("info.exit.restful.userController.getUser"));
		 return new ResponseEntity<UserResponse>(response, HttpStatus.OK);
	  }
    
    
     //Update User
	 //@PreAuthorize("hasAuthority('CORE OPUS')")
	 @RequestMapping(value = "/user", method = RequestMethod.POST)
	 public ResponseEntity<UserResponse>  updateUser(@RequestBody UserRoleRequestWrapper request) throws ServiceException {	
		 
		 UserResponse response = new UserResponse();
		 log.debug(propertyService.getPropertyValue("info.inside.restful.userManagerController.updateUser"));
		 
		 User result= null;
		 try{
			 
			 //Get the User containing all of the users detail changes entered via the User Edit GUI page
			 User user = request.getUser();
									 		 			 
			 //Get the current user from the database.
			 Optional<User> databaseUser=Optional.ofNullable(userService.findUserByEmail(user.getEmail()));
			 if (databaseUser.isPresent())
			 {
				 //Update an existing user
				 //=======================
				 
				 //Delete the user current roles in the database 
				 databaseUser.get().removeAllRoles();
				 userService.updateUser(databaseUser.get());
						 
				 //Check if the user has selected Roles for this user
				 Set<Role> newRoles= mapRoles(request.getRoles());
				 if ((newRoles!=null)&&(newRoles.size()>0)){
					 //Add the new roles to the user in the database in table OPUS_STAFF_ROLE_LINK
					 //==========================================================================
				                                                                /** IMPORTANT this links a STAFF to a ROLE hence user.setRoles is not required**/
					 updateUserRoles(newRoles, databaseUser.get().getId());              /** This will also use the UserRoleLink.java that defines the db sequence on table   OPUS_STAFF_ROLE_LINK**/
				 }
			 			 
				 databaseUser.get().setForenames(user.getForenames());
				 databaseUser.get().setSurname(user.getSurname());
				 databaseUser.get().setEmail(user.getEmail());
				 databaseUser.get().setHomeTelephoneNo(user.getHomeTelephoneNo());
				 databaseUser.get().setMobileTelephoneNo(user.getMobileTelephoneNo());
				 databaseUser.get().setPassword(user.getPassword());
				 databaseUser.get().setTerminationDate(user.getTerminationDate());
			 			 
				 //Update the users details in the database
				 //========================================
				 result =  userService.updateUser(databaseUser.get());
			 }else{
				 				 
				 //Create a new User
				 //=================
				 userService.updateUser(user);
				 
				 //Check if the user has selected Roles for this user
				 Set<Role> newRoles= mapRoles(user.getRoles());
				 if ((newRoles!=null)&&(newRoles.size()>0)){
					 //Add the new roles to the user in the database in table OPUS_STAFF_ROLE_LINK
					 //==========================================================================
				                                                            /** IMPORTANT this links a STAFF to a ROLE hence user.setRoles is not required**/
					 updateUserRoles(newRoles, user.getId());              /** This will also use the UserRoleLink.java that defines the db sequence on table   OPUS_STAFF_ROLE_LINK**/
				 }
				 result=user;
				 
			 }
			 
		     List<User> content = new ArrayList<User>();
		     content.add(result);
		     Page<User> users = new PageImpl<User>(content);		   
		     
		     response.setUsers(users);
		     response.setCode(HttpStatus.OK.name());
		     response.setMessage(propertyService.getPropertyValue("info.succ.update.user.details"));
		     
		 }catch(Exception e){
		     log.error(propertyService.getPropertyValue("eror.during.update.user.details"),e.getCause());
			 throw new ServiceException(propertyService.getPropertyValue("error.system.failure.during.user.update.request"),e);
		 }
		 
	     log.debug(propertyService.getPropertyValue("info.succ.update.user.details"));	
		 log.debug(propertyService.getPropertyValue("info.exit.restful.userManagerController.updateUser"));
		 return new ResponseEntity<UserResponse>(response, HttpStatus.OK); 
	  }
	 
	 //Delete a User
	 //=============
	 //@PreAuthorize("hasAuthority('CORE OPUS')")
	 @RequestMapping(value = "/user", method = RequestMethod.DELETE)
	 public ResponseEntity<Response> deleteUser(@RequestParam("userId") String userId) throws ServiceException {
		 Response response = new Response();
		 log.debug("Inside restful UserController method:deleteUser");
		 try{
			userService.deleteUser(userId);
		 	response.setCode(HttpStatus.OK.name());
			response.setMessage(propertyService.getPropertyValue("info.succ.deleted.user.details"));

	     }catch(Exception e){
			 log.error(propertyService.getPropertyValue("eror.during.delete.user.details"),e.getCause());
			 throw new ServiceException(propertyService.getPropertyValue("error.system.failure.during.user.delete.request"),e);			 
		 }
		 
		 log.debug(propertyService.getPropertyValue("info.succ.deleted.user.details"));			 
		 log.debug(propertyService.getPropertyValue("info.exit.restful.userManagerController.deleteUser"));	
		 return new ResponseEntity<Response>(response, HttpStatus.OK); 
	 }
	    
    
    
    
    
    //Delete a user
	 /**
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User deleteUser(@PathVariable(value = "id") Long id){
        return userService.findById(id);
    }**/

	 
	 
	 
	  //Update a User
	  //=============
	  private  Set<Role> mapRoles(Set<Role> roles) {
		return roles.stream().map(FunctionWithThrowable.castFunctionWithThrowable(role-> roleService.findRole(role.getId()))).collect(Collectors.toSet());
	  }


		private void updateUserRoles(Set<Role> roles, Long userId) throws IOException 
		 {     
		   roles.forEach(UtilException.rethrowConsumer(role-> updateUserRoles(role,userId)));
		 } 
		 private void updateUserRoles(Role role, Long userId) throws  DataAccessException {
			 try{
			 UserRoleLink userRoleLink =new UserRoleLink();
			 userRoleLink.setUserId(userId);
			 userRoleLink.setRolId(role.getId());
			 userRoleLink.setCreationDate(new Date());
			 userRoleLink.setCreationUser("DIVERGENCE");
			 userRoleLink.setSourceSystem("DIVERGENCE");
			 		 
			 userService.updateUserRoleLink(userRoleLink);
			 }catch(Exception e){
				 e.printStackTrace();
				 throw new DataAccessException("",e);
			 }
		 }
	 
	 
	 
}
