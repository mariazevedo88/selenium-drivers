package io.github.mariazevedo88.seleniumdrivers.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;

import io.github.mariazevedo88.seleniumdrivers.services.ChromeWebDriverService;
import io.github.mariazevedo88.seleniumdrivers.services.FirefoxWebDriverService;
import io.github.mariazevedo88.seleniumdrivers.util.ApplicationProperties;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;

/**
 * WebDrivers test class
 * 
 * @author Mariana Azevedo
 * @since 20/04/2019
 *
 */
@DisplayName("WebDriversTest")
@TestInstance(Lifecycle.PER_CLASS)
@TestMethodOrder(OrderAnnotation.class)
public class WebDriversTest {
	
	private ChromeWebDriverService chromeDriver;
	private FirefoxWebDriverService firefoxDriver;
	
	private String downloadFilePath;
	
	private String chromeDriverPath;
	private String firefoxDriverPath;
	
	private Properties properties;
	
	/**
	 * Method that initiates class attributes
	 * 
	 * @author Mariana Azevedo
	 * @since 21/04/2019
	 */
	private void init() {
		String chromePath = "chromeDriverUnixPath";
		String firefoxPath = "chromeDriverUnixPath";
		
		if(ApplicationProperties.isWindows()) {
			chromePath = "chromeDriverWindowsPath";
			firefoxPath = "chromeDriverWindowsPath";
		}
		
		chromeDriverPath = ApplicationProperties.getRightPath(properties.getProperty(chromePath));
		firefoxDriverPath = ApplicationProperties.getRightPath(properties.getProperty(firefoxPath));
		downloadFilePath = ApplicationProperties.getRightPath(properties.getProperty("downloadPath"));
	}
	
	@BeforeAll
	public void setUp() throws FileNotFoundException {
		chromeDriver = new ChromeWebDriverService();
		firefoxDriver = new FirefoxWebDriverService();
		
		properties = ApplicationProperties.load("src/main/resources/application.properties");
		
		init();
	}
	
	@Test
	@DisplayName("Create a Chrome web driver")
	@Order(1)
	public void createChromeWebDriver() throws IOException {
		assertNotNull(chromeDriver);
	}
	
	@Test
	@DisplayName("Create a Firefox web driver")
	@Order(2)
	public void createFirefoxWebDriver() throws IOException {
		assertNotNull(firefoxDriver);
	}
	
	@Test
	@DisplayName("Execute a Chrome web driver in headless mode")
	@Order(3)
	public void executeChromeWebDriverInHeadlessMode() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		List<String> properties = new ArrayList<>();
		
		properties.add("--no-sandbox");
		properties.add("--disable-extensions");
		
		WebDriver driver = chromeDriver.getDriver(downloadFilePath, properties, true);
		assertNotNull(driver);
		driver.quit();
	}
	
	@Test
	@DisplayName("Execute a Firefox web driver in headless mode")
	@Order(4)
	public void executeFirefoxWebDriverInHeadlessMode() throws IOException {
		
		System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
		
		List<String> properties = new ArrayList<>();
		
		properties.add("--no-sandbox");
		properties.add("--disable-extensions");
		
		WebDriver driver = firefoxDriver.getDriver(downloadFilePath, properties, true);
		assertNotNull(driver);
		driver.quit();
	}
	
	@AfterAll
	public void tearDown() {
		chromeDriver = null;
		firefoxDriver = null;
		properties = null;
		chromeDriverPath = null;
		firefoxDriverPath = null;
		downloadFilePath = null;
	}

}
