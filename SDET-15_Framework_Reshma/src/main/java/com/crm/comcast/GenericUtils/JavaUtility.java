package com.crm.comcast.GenericUtils;

import java.util.Date;
import java.util.Random;

/**
 * This class has all java related generic methods like getRandomNumber
 * @author Reahma
 * 
 * */

public class JavaUtility {
	
	Date dateobj = new Date();
	
	/**
	 * 
	 * This method will return a random number
	 * @author Reshma
	 * @return
	 * 
	 */
	public int getRandomNumber()
	{
		Random random = new Random();
		int ran = random.nextInt(1000);
		return ran;
	}

	public String getCurrentDate() {
		String todaysdate = dateobj.toString();
		return todaysdate;
	
	}
	
	public String getCurrentYear() {
		String todaysdate = dateobj.toString();
		String[] arr = todaysdate.split("");
		return arr[5];
		}
	}
