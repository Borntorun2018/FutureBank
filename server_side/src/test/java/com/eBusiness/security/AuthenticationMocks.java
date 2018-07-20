package com.eBusiness.security;

import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;


/**
 * @author Richard Lucas
 */
public class AuthenticationMocks {
    private AuthenticationMocks() {}

    public static final String email="Richard.Lucas@eBusiness.uk";

    public static Authentication userAuthentication(String pin) {
      return new TestingAuthenticationToken(getUser(), null, "ROLE_ADMIN");
    }
    
    public static JwtUser getUser() {
    	JwtUser createdNewUser= new JwtUser();
        createdNewUser.setUsername(email);
        createdNewUser.setPassword("password");
        createdNewUser.setId(1l);
        createdNewUser.setEmail(email);
        return createdNewUser;
    }
}