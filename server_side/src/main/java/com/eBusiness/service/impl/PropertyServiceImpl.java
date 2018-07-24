package com.eBusiness.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.eBusiness.service.PropertyService;

@Service ("propertyService")
public class PropertyServiceImpl implements  PropertyService{
	
	 @Autowired
	 private Environment env;
	
	 public String getPropertyValue(String name){
			return env.getProperty(name);
	 }	
}

