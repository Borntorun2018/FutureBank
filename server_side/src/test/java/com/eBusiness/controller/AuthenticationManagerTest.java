package com.eBusiness.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.annotation.Resource;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.eBusiness.model.AuthToken;
import com.eBusiness.model.LoginUser;
import com.eBusiness.security.AuthenticationMocks;
import com.eBusiness.security.JwtUser;
import com.eBusiness.security.MockMvcSecurityTest;
import com.eBusiness.util.TestUtils;

@WebAppConfiguration
@AutoConfigureMockMvc
public class AuthenticationManagerTest extends MockMvcSecurityTest{
	
	
	@MockBean
    private AuthenticationManager authenticationManager;
	
    @MockBean
    private UserDetailsService userDetailsService;
	
	
	
    private final String URL ="/auth";
    
    @Test
    public void testLoginUser() throws Exception{
    	
    	
       	JwtUser jwtUser =AuthenticationMocks.getUser();
      	when(userDetailsService.loadUserByUsername(any())).thenReturn(jwtUser);
    	
    	Authentication authenticationStub = AuthenticationMocks.userAuthentication(jwtUser.getEmail());
     	when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authenticationStub);
     	      	  	
      	//jwtTokenUtil.generateToken(userDetails);
      	
     	LoginUser loginUser = new LoginUser();
     	loginUser.setPassword(jwtUser.getPassword());
     	loginUser.setUsername(jwtUser.getUsername());
     	
    	//execute  -- Call the WS with the param
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(URL)
    			                  .contentType(MediaType.APPLICATION_JSON_UTF8)
    			                  .accept(MediaType.APPLICATION_JSON_UTF8)
    			                  .content(TestUtils.objectToJson(loginUser))).andReturn();
    	
    	//verify
    	int status = result.getResponse().getStatus();
    	assertEquals("Incorrect Response Status", HttpStatus.OK.value(), status);
    	
    	//verify that service method was called once
    	verify(authenticationManager).authenticate(any(UsernamePasswordAuthenticationToken.class));
    	
    	
    	//return ResponseEntity.ok(new AuthToken(token));
    	AuthToken authToken =  TestUtils.jsonToObject(result.getResponse().getContentAsString(),AuthToken.class);
    	assertNotNull(authToken);
    	assertNotNull(authToken.getToken());
    	
    }
	
}
