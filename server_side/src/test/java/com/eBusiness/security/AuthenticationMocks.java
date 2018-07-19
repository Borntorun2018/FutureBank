package com.eBusiness.security;

import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;

//import com.eBusiness.persist.entity.user.User;


/**
 * @author Richard Lucas
 */
public class AuthenticationMocks {
    private AuthenticationMocks() {}

    public static final String email="richardalucas@zoho.com";

    public static Authentication userAuthentication(String pin) {
      return new TestingAuthenticationToken(getUser(), null, "ROLE_ADMIN");
    }
    
    public static JwtUser getUser() {
    	JwtUser createdNewUser= new JwtUser();
        createdNewUser.setUsername("richard");
        createdNewUser.setPassword("password");
        createdNewUser.setId(1l);
        createdNewUser.setEmail(email);
        return createdNewUser;
    }
}