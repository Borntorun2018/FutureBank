package com.eBusiness;
//Client location C:\Users\richard\git\FutureBankDevelopment
import java.time.format.DateTimeFormatter;

import static java.time.format.DateTimeFormatter.ofPattern;

//import java.time.format.DateTimeFormatter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@PropertySource(value = { "classpath:application.properties" })
@ComponentScan({ "com.eBusiness.*" })
@EntityScan("com.eBusiness.*")
@EnableAutoConfiguration // Enable auto-configuration of the Spring Application
						 // Context, attempting to guess and configure beans
						 // that you are likely to need.

/**
 * This is the main class that runs spring bootstrap
 * @author 62065
 *
 */
public class Application extends WebMvcConfigurerAdapter {
	
	public static final DateTimeFormatter DATETIME_FORMATTER = ofPattern("MM/DD/YYYY HH:MM:SS"); 

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
