package com.eBusiness.security;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;


import com.eBusiness.Application;
import com.eBusiness.config.WebSecurityConfig;


import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Base class for mock mvc tests with the Spring-Security filter chain.
 * <p>
 * For this example this also loads the repositories and the Spring-Data-Rest configuration.
 *
 * @author Richard Lucas
 */
@ContextConfiguration(classes = {Application.class, WebSecurityConfig.class})
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@TransactionConfiguration
@WebAppConfiguration
public abstract class MockMvcSecurityTest {

    protected MockMvc mockMvc;

    @Autowired
    private FilterChainProxy filterChainProxy;

    @Autowired
    private WebApplicationContext webApplicationContext;

    //1) This setsup a mockMvc object. 
    @Before
    public final void initMockMvc() throws Exception {
        mockMvc = webAppContextSetup(webApplicationContext).addFilter(filterChainProxy).build();
    }

    

    //2) This is the heart of enabling services to be Mock tested with security
    //as it places a SecurityContext object (i.e. a mock Authentication) within the applications session via the key
    //SPRING_SECURITY_CONTEXT
    //=====================================================================
    protected MockHttpSession user() {
        return user(AuthenticationMocks.email);
    }
    protected MockHttpSession user(String email) {
        return buildSession(AuthenticationMocks.userAuthentication(email));
    }
    private MockHttpSession buildSession(Authentication authentication) {
        MockHttpSession session = new MockHttpSession();
        session.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, new MockSecurityContext(authentication));
        return session;
    }
     /**
     * Encapsulate Authentication so that it can be used within the buildSession. Note its extends SecurityContext
     * and overrides getAuthentication
     *
     */
    private static class MockSecurityContext implements SecurityContext {
        private Authentication authentication;

        public MockSecurityContext(Authentication authentication) {
            this.authentication = authentication;
        }

        @Override
        public Authentication getAuthentication() {
            return authentication;
        }

        @Override
        public void setAuthentication(Authentication authentication) {
            this.authentication = authentication;
        }
    }
}
