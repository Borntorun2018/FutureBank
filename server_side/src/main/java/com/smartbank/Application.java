package com.smartbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@PropertySource(value = { "classpath:application.properties" })
@ComponentScan({ "com.smartbank.*" })
@EntityScan("com.smartbank.*")
@EnableAutoConfiguration // Enable auto-configuration of the Spring Application
						 // Context, attempting to guess and configure beans
						 // that you are likely to need.

/**
 * This is the main class that runs spring bootstrap
 * @author 62065
 *
 */
public class Application extends WebMvcConfigurerAdapter {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
