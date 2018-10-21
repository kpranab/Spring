package com.flight.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author Pranab Kumar Sahoo
 *
 */
public class DateUtils {

	/**
	 * @param Strin date
	 * @return Date date
	 */
	public static Date parseDateByString(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		SimpleDateFormat hipenFormatter = new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
		try {
			if(null !=date && date.contains("-"))
			return hipenFormatter.parse(date);
			else
				return formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * @param Date date
	 * @return String date
	 */
	public static String parseDateToString(Date date){
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");  
	    return formatter.format(date);  
	}
	
	/**
	 * @param String date
	 * @return String replaceDate
	 */
	public static String parseDateFormat(String date){
		String replace = date;
		if(date!= null && date.contains("-")){
			replace = date.replace("-", "/");
		}
		return replace; 
	}

}
