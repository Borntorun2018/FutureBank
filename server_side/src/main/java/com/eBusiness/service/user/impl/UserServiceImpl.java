package com.eBusiness.service.user.impl;

import com.eBusiness.exceptions.DataAccessException;
import com.eBusiness.persist.entity.user.User;
import com.eBusiness.persist.repo.user.UserRepository;
import com.eBusiness.persist.repo.user.UserRoleRepository;
import com.eBusiness.security.UserRoleLink;
import com.eBusiness.service.user.UserService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eBusiness.service.PropertyService;

@Service(value = "userService")   
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	UserRoleRepository userRoleRepository;
	
    @Autowired
	PropertyService propertyService;	
		 
    
    @Transactional  
 	public  List<User> findAllUsers() throws DataAccessException{
 		try{
 			List<User> list = new ArrayList<>();
 			userRepository.findAll().iterator().forEachRemaining(list::add);
 			return list;
 		}catch(org.springframework.dao.DataAccessException dae){
 			throw new DataAccessException(propertyService.getPropertyValue("error.calling.repository.findAlll"),dae);
 		}
 	}
    
    
    
    
	@Transactional  
 	public  Page<User> findAllUsers( Specification<User> specification,Pageable pageRequest) throws DataAccessException{
 		try{
 			return userRepository.findAll(specification, pageRequest);
 		}catch(org.springframework.dao.DataAccessException dae){
 			throw new DataAccessException(propertyService.getPropertyValue("error.calling.repository.findAlll"),dae);
 		}
 	}
	
	@Transactional	
	public User findUser(Long userId)throws DataAccessException{
		try{
			User user =  userRepository.findOne(userId);
			
			/**
			Consumer<Role> comsumer = role->System.out.println(role.getName());
			user.getRoles().stream().forEach(role->comsumer.accept(role));
			**/
			
		   return user;
		}catch(org.springframework.dao.DataAccessException dae){
			throw new DataAccessException(propertyService.getPropertyValue("error.calling.repository.findOne"),dae);
		}
	}
	
	@Transactional
	public User updateUser(User user)throws DataAccessException{
		try{
			
			return userRepository.save(user);
		}catch(org.springframework.dao.DataAccessException dae){
			throw new DataAccessException(propertyService.getPropertyValue("error.calling.repository.save"),dae);
		}			
	}
	

	
	
	
	@Transactional
	public UserRoleLink updateUserRoleLink(UserRoleLink userRoleLink)throws DataAccessException{
		try{
			
			return userRoleRepository.save(userRoleLink);
		}catch(org.springframework.dao.DataAccessException dae){
			throw new DataAccessException(propertyService.getPropertyValue("error.calling.repository.save"),dae);
		}			
	}
	
	
	
	@Transactional
	public void deleteUserRoleLink(UserRoleLink userRoleLink)throws DataAccessException{
		try{
		userRoleRepository.delete(userRoleLink); 
		}catch(org.springframework.dao.DataAccessException dae){
			throw new DataAccessException(propertyService.getPropertyValue("error.calling.repository.save"),dae);
		}			
	}
	
	
	
			
	@Transactional
	public void deleteUser(Long userId)throws DataAccessException{
		try{
			userRepository.delete(userId);
		}catch(org.springframework.dao.DataAccessException dae){
			throw new DataAccessException(propertyService.getPropertyValue("DataAccessException on calling repository.delete"),dae);
		}				
	}
	
	@Transactional  
	public User findUserByEmail(String email)throws DataAccessException{
		try{
			return userRepository.findByEmail(email);
		}catch(org.springframework.dao.DataAccessException dae){
			throw new DataAccessException(propertyService.getPropertyValue("DataAccessException on calling repository.findByEmail"),dae);
		}				
	}	 	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
