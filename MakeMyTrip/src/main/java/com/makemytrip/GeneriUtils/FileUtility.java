package com.makemytrip.GeneriUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * @author Jyoti H M
	 * This is code is used read the data from property file for common actions of testscripts.
	 * @return 
	 * @throws IOException 
	 */
	public String getDataFromFile(String key) throws IOException {
		FileInputStream fis=new FileInputStream(IPathConstants.Property_File);
		Properties property=new Properties();
		property.load(fis);
		String value=property.getProperty(key);
		return value;
	}

}
