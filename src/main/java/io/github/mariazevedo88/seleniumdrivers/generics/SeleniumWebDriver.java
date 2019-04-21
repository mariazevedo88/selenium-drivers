package io.github.mariazevedo88.seleniumdrivers.generics;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.HttpPost;
import org.openqa.selenium.WebDriver;

/**
 * Interface that defines methods to implement a WebDriver in Selenium
 * 
 * @author Mariana Azevedo
 * @since 20/04/2019
 *
 */
public interface SeleniumWebDriver {
	
	/**
	 * Method that instantiates a Selenium driver
	 * 
	 * @author Mariana Azevedo
	 * @since 20/04/2019
	 * 
	 * @param downloadFilePath
	 * @param browserProperties
	 * @param headless
	 * @return WebDriver
	 * @throws IOException
	 */
	public WebDriver getDriver(String downloadFilePath, List<String> browserProperties, boolean headless) throws IOException;
	
	/**
	 * Method that creates a request with header properties
	 * 
	 * @author Mariana Azevedo
	 * @since 20/04/2019
	 * 
	 * @param command
	 * @param url
	 * @return HttpPost
	 * @throws UnsupportedEncodingException
	 */
	public HttpPost getRequest(String command, String url) throws UnsupportedEncodingException;
	
	/**
	 * Method that configures the driver execution parameters
	 * 
	 * @author Mariana Azevedo
	 * @since 20/04/2019
	 * 
	 * @param params
	 * @return Map<String, Object>
	 */
	public Map<String, Object> configuratingDriverExecutionParams(Map<String, String> params);
	
	/**
	 * Method that configures the generic parameters of the selected browser as driver
	 * 
	 * @author Mariana Azevedo
	 * @since 20/04/2019
	 * 
	 * @param downloadFilePath
	 * @return Map<String, String>
	 */
	public Map<String, String> configurationGenericBrowserParams(String downloadFilePath);
	
	/**
	 * Method that configures browser preferences
	 * 
	 * @author Mariana Azevedo
	 * @since 20/04/2019
	 * 
	 * @param downloadFilePath
	 * @return Map<String, Object>
	 */
	public Map<String, Object> configuratingPreferences(String downloadFilePath);

}
