package com.smartbank.config;

import java.util.Properties;

import javax.persistence.PersistenceContext;
import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.hibernate.ejb.HibernatePersistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration   
@EnableTransactionManagement
@EnableJpaRepositories({"com.smartbank.*"})  
public class PersistenceConfig extends WebMvcConfigurerAdapter  {
	
	private static final Logger log = Logger.getLogger(PersistenceConfig.class);
	 
	@Autowired
	private Environment env;
	
	@Bean
    @PersistenceContext
    public JpaTransactionManager transactionManager() throws ClassNotFoundException {
		 System.out.println("************PersistenceConfig is starting.*************");
      JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
      return transactionManager;
    }

	Properties additionalProperties() {
        Properties properties = new Properties();   
        try{
        	
        	//In memory database settings
        	//===========================
        	
        	properties.setProperty("jdbc.driverClassName", env.getProperty("in_memory_jdbc.driver"));       
        	properties.setProperty("jdbc.url", env.getProperty("in_memory_jdbc.url"));      
        	properties.setProperty("hibernate.dialect", env.getProperty("in_memory_database.dialect"));
	        properties.setProperty("hibernate.show_sql", env.getProperty("in_memory_database.show_sql"));
	        properties.setProperty("hibernate.use_sql_comments", env.getProperty("in_memory_database.use_sql_comments"));
	        properties.setProperty("hibernate.format_sql", env.getProperty("in_memory_database.format_sql"));       
	        properties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("in_memory_database.hbm2ddl.auto"));       
        	
        	
        	//Real database settings
        	//======================
        	/**
       	      properties.setProperty("hibernate.dialect", env.getProperty("database.dialect"));
	          properties.setProperty("hibernate.show_sql", env.getProperty("database.show_sql"));
	          properties.setProperty("hibernate.use_sql_comments", env.getProperty("database.use_sql_comments"));
	          properties.setProperty("hibernate.format_sql", env.getProperty("database.format_sql"));       
	        **/
        }catch(NullPointerException npe){
        	log.error("NullPointerException inside method additionalProperties calling properties.setProperty");
        	throw new NullPointerException("NullPointerException inside method additionalProperties calling properties.setProperty");
        }
        return properties;
    }
	
	//Put this in 24 April 2017
	 @Override
     public void addCorsMappings(CorsRegistry registry) {
         registry.addMapping("/authenticate").allowedOrigins("http://localhost:8080");
     }
	
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() throws ClassNotFoundException {
       LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
       
       //entityManagerFactoryBean.setPersistenceUnitName("cpJpaPu");
       //Added 19dec2017
       //entityManagerFactoryBean.setPackagesToScan("com.newborn.persist.entity");
      
       
       
       
       entityManagerFactoryBean.setJpaProperties(additionalProperties());
       entityManagerFactoryBean.setDataSource(dataSource());
       entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistence.class);
       return entityManagerFactoryBean;
    }	 
    
    @Bean
    public DataSource dataSource() {
	  DriverManagerDataSource dataSource = new DriverManagerDataSource();
	  try{
		  
		  /** live database
	      dataSource.setDriverClassName(env.getProperty("database.driver"));
	      dataSource.setUrl(env.getProperty("database.url"));
	      dataSource.setUsername(env.getProperty("database.username"));
	      dataSource.setPassword(env.getProperty("database.password"));
	      **/
		  
		  
		  dataSource.setDriverClassName(env.getProperty("in_memory_jdbc.driver"));
	      dataSource.setUrl(env.getProperty("in_memory_jdbc.url"));
	     
		  
	      
      }catch(NullPointerException npe){
      	log.error("NullPointerException inside method dataSource calling properties.setProperty");
      	throw new NullPointerException("NullPointerException inside method dataSource calling properties.setProperty");
      }      
      
      return dataSource;
	}    
}