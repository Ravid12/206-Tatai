package application.utils;

public class StringUtils {
	
	
	
	/**
	 * Method that checks if a string is a number.
	 */
	
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
	/**
	 * Checks if username contains only alphanumeric Characters
	 * or underscores.
	 */
	
	public static boolean isValidUsername(String username) {
		// Regex for all alphanumeric characters and underscores
		return username.matches("^[a-zA-Z0-9_]+$");
	}
}
