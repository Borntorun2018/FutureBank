package com.eBusiness.persist.repo.user;

import java.util.Date;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;
import com.eBusiness.persist.entity.user.UserAttempts;

@Transactional
@RepositoryRestResource
public interface UserLoginAttemptsRepository extends PagingAndSortingRepository<UserAttempts, String> { 
					
	static  final String SQL_USER_FAIL_ATTEMPTS_RESET  	= "UPDATE UserAttempts SET OSA_ATTEMPTS = 0, OSA_LASTMODIFIED = null WHERE OSA_EMAIL = :email";
	static  final String SQL_USER_FAIL_ATTEMPTS_UPDATE 	= "UPDATE UserAttempts SET OSA_ATTEMPTS = OSA_ATTEMPTS + 1, OSA_LASTMODIFIED = :lastmodified WHERE OSA_EMAIL = :email";
	static  final String SQL_USER_FAIL_ATTEMPTS_INSERT	= "INSERT INTO UserAttempts (OSA_EMAIL, OSA_ATTEMPTS, OSA_LASTMODIFIED) VALUES(?,?,?)";
	
	//public static  final String SQL_USER_FAIL_ATTEMPTS_GET 		= "SELECT * FROM OPUS_SATFF_ATTEMPTS WHERE OSA_EMAIL = ?";
	
	
	
	//===========================================================
	//The following are Defining custom access method and queries
	//===========================================================
	
	//APROACH (1)JPQ query by using the @Query annotation
	//====================================================
	//This method resets the number of fail attempts to 0 in the sql call
	@Modifying
    @Query(SQL_USER_FAIL_ATTEMPTS_RESET)
	public void resetFailAttempts(@Param("email") String email);
	
	//This method updates the current number of fail attempts by 1 in the sql call
	@Modifying
    @Query(SQL_USER_FAIL_ATTEMPTS_UPDATE)
	public void updateFailAttempts(@Param("lastmodified") Date lastmodified, @Param("email") String email);
		
	
	//APROACH (2)JPQ query by using the @Query annotation
	//====================================================
	//Examples:- http://docs.spring.io/spring-data/data-jpa/docs/1.1.x/reference/html/#jpa.query-methods.query-creation
	//This method will return a UserAttempts associated with the users email
	public UserAttempts findByUsername(String email);
	
	
	//This method inserts a new record related to a users fail attempts 
	//@Modifying
    //@Query(SQL_USER_FAIL_ATTEMPTS_INSERT)
	//public UserAttempts insertFailAttempts(String email,String attempts, Date lastmodified);  
		
}
