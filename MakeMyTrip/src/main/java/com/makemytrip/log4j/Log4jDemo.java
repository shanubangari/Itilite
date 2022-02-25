package com.makemytrip.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4jDemo {
static Logger log=Logger.getLogger(Log4jDemo.class);
	
	public static Logger getLogger() {
		PropertyConfigurator.configure(".\\src\\main\\resources\\log4j.properties");
		return log;
	}
	

}
