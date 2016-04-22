package org.cloud.utilities;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.Random;

/**
 * 
 * @author Kushagra Mahajan
 * @version 1.0.0.0
 *
 */
public class ApplicationUtil {

	/**
	 * 
	 * @param param
	 * @return TRUE/FALSE
	 */
	public static boolean isNull(Object param) {
		if (param instanceof String) {
			if (param == null || ((String) param).trim().length() == 0) {
				return true;
			}
		} else if (param == null) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param time
	 * @return Current Date
	 */
	public static String convertTimeWithTimeZome(long time) {
		Calendar cal = Calendar.getInstance();
		cal.setTimeZone(TimeZone.getTimeZone("UTC"));
		cal.setTimeInMillis(time);
		return (cal.get(Calendar.YEAR) + " " + (cal.get(Calendar.MONTH) + 1) + " " + cal.get(Calendar.DAY_OF_MONTH));
	}
	
	/**
	 * 
	 * @param min
	 * @param max
	 * @return Random Integer Value
	 */
	public static int randInt(int min, int max) {
	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;
	    return randomNum;
	}

}
