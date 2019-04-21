package io.github.mariazevedo88.seleniumdrivers.services;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.mariazevedo88.seleniumdrivers.generics.SeleniumWebDriver;

/**
 * Class that starts and runs the chrome driver
 * 
 * @author Mariana Azevedo
 * @since 20/04/2019
 *
 */
public class ChromeWebDriverService implements SeleniumWebDriver{
	
	private static Logger logger = Logger.getLogger(ChromeWebDriverService.class);
	
	/**
	 * @see SeleniumWebDriver#getDriver(String, List, boolean)
	 */
	@Override
	public WebDriver getDriver(String downloadFilePath, List<String> browserProperties, boolean headless) throws IOException {

		long initialTime = System.currentTimeMillis();
		
		logger.info("Getting started " + ChromeWebDriverService.class.getSimpleName() + " on " + LocalDateTime.now());
		logger.info("Setting driver...");

		ChromeDriverService driverService = ChromeDriverService.createDefaultService();

		Map<String, Object> chromePrefs = configuratingPreferences(downloadFilePath);
		
		ChromeOptions chromeOpts = getChromeOptions(chromePrefs, browserProperties, headless);
		
		WebDriver driver = new ChromeDriver(driverService, chromeOpts);
		
		Map<String, String> params = configurationGenericBrowserParams(downloadFilePath);

		Map<String, Object> commandParams = configuratingDriverExecutionParams(params);
		
		ObjectMapper objectMapper = new ObjectMapper();
		String command = objectMapper.writeValueAsString(commandParams);
		String url = driverService.getUrl().toString() + "/session/" + ((RemoteWebDriver) driver).getSessionId() + "/chromium/send_command";
		
		HttpPost request = getRequest(command, url);
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		httpClient.execute(request);

		logger.info("Driver started successfully!");
		
		long endTime = System.currentTimeMillis();
		logger.info(ChromeWebDriverService.class.getSimpleName() + " started on " + (endTime - initialTime)/1000d + " seconds.");
		
		logger.info(ChromeWebDriverService.class.getSimpleName() + " completed on " + LocalDateTime.now());

		return driver;
	}

	/**
	 * @see SeleniumWebDriver#configuratingDriverExecutionParams(Map)
	 */
	@Override
	public Map<String, Object> configuratingDriverExecutionParams(Map<String, String> params) {
		
		Map<String, Object> commandParams = new HashMap<>();
		commandParams.put("cmd", "Page.setDownloadBehavior");
		commandParams.put("params", params);
		
		return commandParams;
	}

	/**
	 * @see SeleniumWebDriver#configurationGenericBrowserParams(String)
	 */
	@Override
	public Map<String, String> configurationGenericBrowserParams(String downloadFilePath) {
		
		Map<String, String> params = new HashMap<>();
		params.put("behavior", "allow");
		params.put("downloadPath", downloadFilePath);
		
		return params;
	}

	/**
	 * @see SeleniumWebDriver#configuratingPreferences(String)
	 */
	@Override
	public Map<String, Object> configuratingPreferences(String downloadFilePath) {
		
		Map<String, Object> chromePrefs = new HashMap<>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilePath);
		
		return chromePrefs;
	}
	
	/**
	 * @see SeleniumWebDriver#getRequest(String, String)
	 */
	@Override
	public HttpPost getRequest(String command, String url) throws UnsupportedEncodingException {
		
		HttpPost request = new HttpPost(url);
		request.addHeader("content-type", "application/json");
		request.setEntity(new StringEntity(command));
		
		return request;
	} 
	
	/**
	 * Method that adds chrome driver execution options
	 * 
	 * @author Mariana Azevedo
	 * @since 20/04/2019
	 * 
	 * @param chromePrefs
	 * @param properties
	 * @param headless
	 * 
	 * @return ChromeOptions
	 */
	private static ChromeOptions getChromeOptions(Map<String, Object> chromePrefs, List<String> properties, boolean headless) {
		
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setExperimentalOption("prefs", chromePrefs);
		
		chromeOptions.setHeadless(headless);
		
		properties.forEach(prop -> chromeOptions.addArguments(prop));
		
		return chromeOptions;
	}

}
