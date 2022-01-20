package com.crm.comcast.GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
/**
 * Utility for property file
 * @author sarav
 *
 */

public class FileUtility {
	/**
	 * This method will fetch the data from property file
	 * @param key
	 * @return
	 * @throws Throwable 
	 */
public String getPropertyFileData(String key) throws Throwable {
	
	FileInputStream file = new FileInputStream(IPathConstants.PROPERTY_FILEPATH);
	Properties Property = new Properties();
	Property.load(file);
	return Property.getProperty(key);
}

}
