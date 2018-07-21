package com.eBusiness.logging;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.helpers.PatternParser;
public class LogPatternLayout  extends PatternLayout
{
	 public LogPatternLayout ()
	 {
	   super();
	 }
	 public LogPatternLayout (String pattern)
	 {
	   super(pattern);
	 }
	 protected PatternParser createPatternParser(String pattern)
	 {
	   return new LogPatternParser(pattern);
	 }
	}