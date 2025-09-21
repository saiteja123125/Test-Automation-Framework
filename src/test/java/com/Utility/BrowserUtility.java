package com.Utility;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constant.Browser;

public abstract class BrowserUtility {
	
	
	
	
	private static  ThreadLocal <WebDriver> driver = new ThreadLocal <WebDriver>() ;
	org.apache.logging.log4j.Logger logger = LoggerUtility.getLogger(this.getClass()); 
	
	
	
	
	
	public WebDriver getDriver() {
		return driver.get();
	}

	
	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);// initialize the instance variable driver!
	}
	
	
	
	
	public BrowserUtility(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver .set( new ChromeDriver());
		}
		
		else if(browserName.equalsIgnoreCase("edge")) {
			driver.set(new  EdgeDriver());
		}
		else {
			logger.error("Invalid browser name..please select chrome or Edge");
			System.err.print("Invalid browser name..please select chrome or Edge");
			
		}
	}
	
	public BrowserUtility(Browser browserName) {
		logger.info("Launching Browser for "+browserName);
		if(browserName==Browser.CHROME) {
			driver.set (new ChromeDriver());
		}
		
		else if(browserName==Browser.EDGE) {
			driver.set(new  EdgeDriver());
		}
		
		else if(browserName==Browser.FIREFOX) {
			driver.set (new FirefoxDriver());
		}
		else {
			System.err.print("Invalid browser name..please select chrome or edge");
			
		}
	}
	

	public BrowserUtility(Browser browserName, boolean isHeadless) {		
		logger.info("Launching Browser for "+browserName);

		if(browserName==Browser.CHROME ) {
			if(isHeadless) {
				
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless=old");  //headless
			options.addArguments("--window-size=1920,1080");
			driver.set (new ChromeDriver(options));
		}
		else {
			driver.set (new ChromeDriver());
			
		}
	}
		
		
		
		else if(browserName==Browser.EDGE) {
			if(isHeadless) {
				
				EdgeOptions options = new EdgeOptions();	
				options.addArguments("--headless=old");
				driver.set(new  EdgeDriver(options));
			}
			else {
				driver.set(new  EdgeDriver());
			}
				
		}
		
		else if(browserName==Browser.FIREFOX) {
			
			if(isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless=old");
				driver.set(new  FirefoxDriver(options));
			}
			
			else {
				driver.set(new  FirefoxDriver());
				System.err.print("Invalid browser name..please select chrome or edge");
			}
				
		}
			
			
		
		}
	

	
	
	
	
	
	
	public void goToWebsite(String url) {
		logger.info("Visiting the website" +url);
		driver.get().get(url);
	}
	
	public void maximizeWindow(){
		logger.info("Maximizing the browser Window");
		driver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		logger.info("Find Element with locator"+locator);
		WebElement element = driver.get().findElement(locator);
		element.click();
	}
	
	
	public void enterText(By locator, String textToEnter) {
		WebElement element = driver.get().findElement(locator);
		logger.info("Enter  Text" +textToEnter);
		element.sendKeys(textToEnter);
		
		
	}
	
	public  String getVisibleText(By locator) {
		WebElement element = driver.get().findElement(locator);
		logger.info("ENter Visible Text" +locator);
		return element.getText();
		
	}
	
	
	public String takeScreenshot(String name) {
		TakesScreenshot screenshot =(TakesScreenshot) driver.get();
		
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
	    SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss"); 
	    String timeStamp = format.format(date);

	    // Constructing path with timestamp
	    String path = System.getProperty("user.dir") + "//screenshots//"+ name+ " - " +timeStamp +".png";
	               

	    File screenshotFile = new File(path);
	    try {
	        FileUtils.copyFile(screenshotData, screenshotFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return path;
	}
	}
	
	
	
	