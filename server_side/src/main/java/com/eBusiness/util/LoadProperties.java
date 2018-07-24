package com.eBusiness.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

//Not used since spring boot does all this auto for you************************
public class LoadProperties {
	
	private Properties configProp = new Properties();
	
	/**
	 * This will load the current properties into the system
	 */
	public LoadProperties(){
		InputStream in = this.getClass().getResourceAsStream("config.properties");
		try {
			configProp.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	/**
	 * This will provide the associated value that is ref by the name within config.properties
	 * @param name
	 * @return
	 */
	public String getProperty(String name)
	{
		return configProp.getProperty(name);
	}
	
}
