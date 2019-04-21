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
	
	public static String getKey(String key) {
		return prop.getProperty(key);
	}
	
	public static String fixPathOnWindows(String key) {
		if(key != null) {
			if(System.getProperty("os.name").toLowerCase().contains("windows")){
				key = key.replace("\\", "\\\\");
			}else {
				key = key.replace("\\", "/"); //unix
			}
		}
		return key;
	}
}
