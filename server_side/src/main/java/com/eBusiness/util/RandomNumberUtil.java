package com.eBusiness.util;
import java.util.Random;
public class RandomNumberUtil {
	

	public static String getRandomNumberStr()
	{
	   //Random randomGenerator = new Random();
	   //int randomInt = randomGenerator.nextInt(1000000);
	   //int randomInt = (new Random()).nextInt(1000);
	   return Integer.toString(getRandomNumber());
	}

	
	public static Integer getRandomNumber()
	{
	   return ((new Random()).nextInt(1000));
	}
}
