package com.eBusiness.util;

import javax.persistence.AttributeConverter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
/**
 * The method:convertToDatabaseColumn is used to convert the LocalDateTime to a format that wiil be stored within the database
 * The method:convertToEntityAttribute is used to convert the Timestamp to a LocalDateTime - Note that we use jackson-datatype-jsr310-2.9.3.jar in the project buildpath so that this object is seralized correctly
 * @author 62065
 *
 */
public class LocalDateTimeConverter implements AttributeConverter < LocalDateTime, Timestamp > {
 @Override
 public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
  return attribute != null ? Timestamp.valueOf(attribute) : null;
 }
 
 
 @Override
 public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
	 LocalDateTime localDateTime=dbData != null ? dbData.toLocalDateTime() : null;
  return localDateTime;
 }
 
 
}
