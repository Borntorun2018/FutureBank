package com.eBusiness.util;

import java.io.IOException;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

@Component
public class CustomDateDeserializer extends JsonDeserializer<Date>{
	
	  @Override
	  public Date deserialize(JsonParser jsonparser,
	                          DeserializationContext deserializationcontext) throws IOException {
	    String jasondate = jsonparser.getText();
	    try {
	      return new Date(jasondate);
	    } catch (Exception e){
	      throw new RuntimeException(e);
	    }
	  }
}
