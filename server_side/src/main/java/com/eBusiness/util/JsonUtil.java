package com.eBusiness.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
	private static final Logger log = Logger.getLogger(JsonUtil.class);
	 
	public static Optional<SystemConfig> getSystemConfig(){
		SystemConfig  systemConfig=null;
		try{
			ObjectMapper mapper = new ObjectMapper();
			TypeReference<SystemConfig> mapType = new TypeReference<SystemConfig>() {};
			InputStream is=TypeReference.class.getResourceAsStream("/static/systemConfiguration.json");
			systemConfig = mapper.readValue(is, mapType);
		}catch(JsonMappingException jme){
		   log.error(jme);
		}catch(JsonParseException jpe){
			   log.error(jpe);		
	    }catch(IOException io){
	    	io.printStackTrace();
			   log.error(io);	    
	    }
		return Optional.of(systemConfig);
	}
}
