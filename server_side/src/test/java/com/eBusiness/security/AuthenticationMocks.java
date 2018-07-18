package com.eBusiness.security;

import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import com.eBusiness.persist.entity.user.User;


/**
 * @author Richard Lucas
 */
public class AuthenticationMocks {
    private AuthenticationMocks() {}

    public static final String email="richardalucas@zoho.com";

    public static Authentication userAuthentication(String pin) {
      return new TestingAuthenticationToken(getUser(), null, "ROLE_ADMIN");
    }
    
    public static User getUser() {
        User createdNewUser= new User();
        createdNewUser.setUsername("richard");
        createdNewUser.setPassword("password");
        createdNewUser.setId(1l);
        createdNewUser.setEmail(email);
        return createdNewUser;
    }
}