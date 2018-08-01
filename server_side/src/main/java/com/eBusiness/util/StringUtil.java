package com.eBusiness.util;

import java.util.StringTokenizer;

public class StringUtil {

	 /** Constant defining a space: ' '. */
	  public final static String SPACE = " ";

	  /** Constant defining an empty string: ''. */
	  public final static String EMPTY = "";

	  /** Constant defining a new line: '\n'. */
	  public final static String NEW_LINE = "\n";

	  /** Constant defining a new line carrige return: '\r'. */
	  public final static String NEW_LINE_CARRIGE_RETURN = "\r\n";
	  
	  /** Constant defining a new line carrige return: '\r'. */
	  public final static String DOUBLE_NEW_LINE_CARRIGE_RETURN = "\r\n\n";
	  
	  /** Constant defining a carriage return */
	  public final static String CARRIAGE_RETURN = "\r";
	  
	  /** Constant defining a URL encoded space (i.e. can be used in a URL path) */
	  public final static String URL_ENCODED_SPACE = "%20";
	  
	  /**
	   * Constant defining a comma followed by a space: ', '. Useful for building up
	   * toString
	   */
	  public final static String COMMA_SPACE = ", ";
	  
	  /** Constant defining a comma */
	  public final static String COMMA = ",";
	  
	  /** Constant defining a fullstop */
	  public final static String FULLSTOP = ".";
	  
	  /** Constant defining a dash */
	  public final static String DASH = "-";
	  
	  /** Constant defining a ampersand (&) */
	  public final static String AMPERSAND  = "&";
	  
	  public final static String DOUBLE_SPACE_REG_PATTERN = "\\s+";
	  
	  private static final String REGULAR_EXP_VALID_POSTCODE
	  = "([A-PR-UWYZ0-9][A-HK-Y0-9][AEHMNPRTVXY0-9]?[ABEHMNPRVWXY0-9]? {1,2}[0-9][ABD-HJLN-UW-Z]{2}|GIR 0AA)$";
		
		/**
		 * @param s  The string to test.
		 * @return true if null, empty or just contains white space. false
		 *         otherwise.
		 */
		public static boolean isEmpty(String s) {
			return s == null || s.trim().length() == 0;
		}
		public static boolean isEmpty(Integer s) {
			return s == null;
		}

		public static String checkEmailParam(String s) {
			return isEmpty(s)?"":s.replaceAll("\0", " ");
		}
		
		
		/**
		 * Checks to see if the string array has any none null, none empty strings
		 * within it.
		 * 
		 * @param param
		 * @return true if the array is null, of length 0 or none of the string have
		 *         a value.
		 * @see #isEmpty(String)
		 */
		public static boolean isEmpty(String[] param) {
			if (null != param && param.length > 0) {
				for (int i = 0; i < param.length; i++) {
					if (!StringUtil.isEmpty(param[i]))
						return false;
				}
			}
			return true;
		}
		
		 public static boolean isIntegerString(String s)
		  {
		    return (s.length() == 0) ? true : (inCharSet(s.charAt(0), new char[][]
		    {
		    {'0', '9'}}) ? isIntegerString(s.substring(1, s.length())) : false);
		  }	
		 private static boolean inCharSet(char c, char[][] set)
		  {
		    char from;
		    char to;
		    for (int i = 0; i < set.length; i++)
		    {
		      from = set[i][0];
		      to = set[i][1];

		      if ((c >= from) && (c <= to)) return true;

		    }
		    return false;
		  }	
		 
		 	 
		 public static String initCap(String s)
		  {
		    if (s == null || s.length() == 0)
		    {
		      return "";
		    }
		    StringBuffer sb = new StringBuffer();
		    StringTokenizer st = new StringTokenizer(s);
		    while (st.hasMoreTokens())
		    {
		      String word = st.nextToken();
		      if (sb.length() != 0)
		      {
		        sb.append(' ');
		      }
		      // Handle words in brackets, numbers/codes (inc postcode), etc.
		      if (!Character.isLetter(word.charAt(0)) && word.length() > 1)
		      {
		        if (Character.isDigit(word.charAt(0)))
		        {
		          sb.append(word);
		        }
		        else
		        {
		          sb.append(word.substring(0, 2).toUpperCase());
		          if (word.length() > 2)
		          {
		            sb.append(word.substring(2).toLowerCase());
		          }
		        }
		      }
		      else
		      {
		        sb.append(word.substring(0, 1).toUpperCase());
		        if (word.length() > 1)
		        {
		          sb.append(word.substring(1).toLowerCase());
		        }
		      }
		    }
		    return sb.toString();
		  }	 
		 
		  public static boolean allBlankSpaces(String sText)
		  {
			  if ((sText==null)||(sText.length()==0))return false;
			  
			  //Remove all blanks
			  int afterLength=removeBlankSpaces(sText).length();
			  
			  if (afterLength==0) return true; //All the char were blank have been removed leaving nothing
			  else return false; //We have more than blanks
			  
		  }
		  public static String removeBlankSpaces(String sText){
			  String result="";
			  if ((sText!=null)&&(sText.length()>0))
			  {
			     result= sText.replaceAll("\\s", "");	
			  }
			  return result;
		  }
		  
		 public static void main(String[]arg)
		 {
			 String sText=" ";
			 
			 boolean test=(new StringUtil()).allBlankSpaces(sText);
			 
			 
		 }
	
}
