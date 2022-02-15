package com.makemytrip.GeneriUtils;

import java.util.Date;

public class JavaUtility {


	/**
	 * @author Jyoti H M
	 * Get Current Date
	 * @return 
	 */

	public static String getCurrentDate() {
		Date dt=new Date();
		String currentdate = dt.toString().replace(":", "_").replace(" ", "_");
		return currentdate;
	}
}
