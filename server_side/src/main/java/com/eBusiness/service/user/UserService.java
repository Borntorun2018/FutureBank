package com.eBusiness.service.user;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.eBusiness.exceptions.DataAccessException;
import com.eBusiness.persist.entity.user.User;
import com.eBusiness.security.UserRoleLink;

public interface UserService {

	/**
    User save(User user);
    List<User> findAll();
    void delete(long id);
    User findOne(String username);
    User findById(Long id);
    **/
	
	
 	public  List<User> findAllUsers() throws DataAccessException;
 		     
    public  Page<User> findAllUsers( Specification<User> specification,Pageable pageRequest) throws DataAccessException;
	
	/**
	 * @param userId
	 * @return
	 * @throws DataAccessException
	 */
	public User findUser(Long userId) throws DataAccessException;
	
	public User updateUser(User user) throws DataAccessException;
	
	public UserRoleLink updateUserRoleLink(UserRoleLink userRoleLink)throws DataAccessException;
	
	public void deleteUserRoleLink(UserRoleLink userRoleLink)throws DataAccessException;
	
	public void deleteUser(Long userId) throws DataAccessException;

	public User findUserByEmail(String email) throws DataAccessException;
    
    
    
    
    
    
    
    
}
