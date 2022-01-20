package com.crm.comcast.GenericUtility;

import java.util.Date;
import java.util.Random;
/**
 * utility for random number and system date and time
 * @author sarav
 *
 */

public class JavaUtility {
	/**
	 * This method will return random number
	 * @return
	 */

	public int getRandomNumber() {
		Random ran = new Random();
		int randomnumber = ran.nextInt(1000);
		return randomnumber;
		
	}
	/**
	 * This method will return system date and time
	 * @return
	 */
	public String getSystemDateAndTime() {
		Date date = new Date();
		String dateAndTime = date.toString();
		return dateAndTime;
		
	}

}
