package com.eBusiness.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource(name = "userService")
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    public void globalUserDetails(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(encoder());
    }

    @Bean
    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationFilter();
    }

    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web     .ignoring()
                .antMatchers("/resources/**")
                .antMatchers("/resources/application.properties"); 
    }
    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
                 http
                 .csrf().disable()
                 .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                 .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                 
                 .authorizeRequests()
                 .antMatchers("/login/auth/**").permitAll()
                 .antMatchers("/login/currentUser").permitAll()
                 .antMatchers("/users").permitAll()
                 .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                 .anyRequest().authenticated();
                 
                 // Custom JWT based security filter
                 http
                .addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
                 
              // disable page caching
                 http.headers().cacheControl();
                 
    }
 

    @Bean
    public BCryptPasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
