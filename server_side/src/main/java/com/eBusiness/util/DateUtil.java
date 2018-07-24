package com.eBusiness.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

	private static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";
	
    private static final DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
    
    private static final DateTimeFormatter dateFormat8 = DateTimeFormatter.ofPattern(DATE_FORMAT);
    
    public static Date getCurrentDateTime()
    {
       Date currentDate = new Date();
       //java.text.SimpleDateFormat sdf =new java.text.SimpleDateFormat(DATE_FORMAT);
	   return currentDate;
    }
    
    public static Date adjustLocalDate(int Years, int Months, int Days, int Hours, int Minutes, int Seconds){
    	
		// Get current date
	    Date currentDate = new Date();
	    // convert date to localdatetime
	    LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	    
	    if (Years!=0){
	    	if (Years>0) localDateTime =localDateTime.plusYears(Years);
	    	else localDateTime =localDateTime.minusYears(Years);
	    }
	    if (Months!=0){
	    	if (Months>0) localDateTime =localDateTime.plusMonths(Months);
	    	else localDateTime =localDateTime.minusMonths(Months);
	    }	    
	    if (Days!=0){
	    	if (Days>0) localDateTime =localDateTime.plusDays(Days);
	    	else localDateTime =localDateTime.minusDays(Days);
	    }	    
	    if (Hours!=0){
	    	if (Hours>0) localDateTime =localDateTime.plusHours(Hours);
	    	else localDateTime =localDateTime.minusHours(Hours);
	    }	    	
	    if (Minutes!=0){
	    	if (Minutes>0) localDateTime =localDateTime.plusMinutes(Minutes);
	    	else localDateTime =localDateTime.minusMinutes(Minutes);
	    }	    	    
	    if (Seconds!=0){
	    	if (Seconds>0) localDateTime =localDateTime.plusSeconds(Seconds);
	    	else localDateTime =localDateTime.minusSeconds(Seconds);
	    }	    	   
	    
	    Date currentDatePlusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	    
	    return currentDatePlusOneDay;
    }
    
    public static Date trim(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.clear(); // as per BalusC comment.
        cal.setTime( date );
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
   }
    
	public static void main(String[] args) {
		/**
		// Get current date
	    Date currentDate = new Date();
	    System.out.println("1) date : " + dateFormat.format(currentDate));
	    // convert date to localdatetime
	    LocalDateTime localDateTime = currentDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
	    System.out.println("1) localDateTime : " + dateFormat8.format(localDateTime));
	
	    // plus one
	    localDateTime = localDateTime.plusYears(1).plusMonths(1).plusDays(1);
	    localDateTime = localDateTime.plusHours(1).plusMinutes(1).plusSeconds(1);
	
	    // convert LocalDateTime to date
	    Date currentDatePlusOneDay = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
	
	    System.out.println("\nOutput : " + dateFormat.format(currentDatePlusOneDay));
	    System.out.println("========================================================");
	    System.out.println("\nOutput : " + dateFormat.format(adjustLocalDate(1,1,1,1,1,1)));
	    **/
		
		ZonedDateTime zonedDateTime =ZonedDateTime.now();
		System.out.println(zonedDateTime);
	    
  }
  
		
}
