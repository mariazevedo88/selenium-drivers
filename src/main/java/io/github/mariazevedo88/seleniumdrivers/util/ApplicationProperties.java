package io.github.mariazevedo88.seleniumdrivers.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

/**
 * Class that implements the reading of 'application.properties'
 * 
 * @author Mariana Azevedo
 * @since 20/04/2019
 *
 */
public class ApplicationProperties {
	
	private static Properties prop = null;

	private ApplicationProperties() {}
	
	/**
	 * Method that load application.properties file
	 * 
	 * @author Mariana Azevedo
	 * @since 21/04/2019
	 * 
	 * @param propertiesPath
	 * @return Properties
	 * @throws FileNotFoundException
	 */
	public static Properties load(String propertiesPath) throws FileNotFoundException {

		prop = new Properties();
		try {
			prop.load(new FileInputStream(propertiesPath));
		} catch (Exception ex) {
			prop = null;
			throw new FileNotFoundException("Failed to load application.properties file in directory " + propertiesPath);
		}
		return prop;
	}
	
	/**
	 * Method that retrieves a key from the properties file
	 * 
	 * @author Mariana Azevedo
	 * @since 21/04/2019
	 * 
	 * @param key
	 * @return String
	 */
	public static String getKey(String key) {
		return prop.getProperty(key);
	}
	
	/**
	 * Method that corrects the path according the OS
	 * 
	 * @author Mariana Azevedo
	 * @since 21/04/2019
	 * 
	 * @param key
	 * @return String
	 */
	public static String getRightPath(String key) {
		if(key != null) {
			if(isWindows()){
				key = key.replace("\\", "\\\\");
			}else {
				key = key.replace("\\", "/"); //unix
			}
		}
		return key;
	}
	
	/**
	 * Method that verifies with the OS is Windows
	 * 
	 * @author Mariana Azevedo
	 * @since 21/04/2019
	 * 
	 * @return boolean
	 */
	public static boolean isWindows() {
		return System.getProperty("os.name").toLowerCase().contains("windows");
	}
}
