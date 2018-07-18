package com.eBusiness.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.eBusiness.model.AuthToken;
import com.eBusiness.persist.entity.user.User;
import com.eBusiness.security.AuthenticationMocks;
import com.eBusiness.security.MockMvcSecurityTest;
import com.eBusiness.service.user.UserService;
import com.eBusiness.util.TestUtils;

@WebAppConfiguration
@AutoConfigureMockMvc
public class AuthenticationManagerTest extends MockMvcSecurityTest{
	
	//@Autowired
	//private MockMvc mockMvc;
	
	@MockBean
    private AuthenticationManager authenticationManager;
    @MockBean
    private UserService userService;
    
    
    private final String URL ="/auth";
    
    @Test
    public void testLoginUser() throws Exception{
    	
    	//prepare data and mock behaviour
    	Authentication authenticationStub = AuthenticationMocks.userAuthentication(AuthenticationMocks.email);
     	when(authenticationManager.authenticate(any(UsernamePasswordAuthenticationToken.class))).thenReturn(authenticationStub);
     	
     	//prepare data and mock behaviour
     	User user = AuthenticationMocks.getUser();
      	when(userService.findOne(any(String.class))).thenReturn(user);
      	
     	
    	//execute  -- Call the WS with the param
    	MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(URL).contentType(MediaType.APPLICATION_JSON_UTF8)
    			           .accept(MediaType.APPLICATION_JSON_UTF8).content(TestUtils.objectToJson(authenticationStub))).andReturn();
    	
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
