package com.Utility;

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hpsf.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constant.Browser;

public abstract class BrowserUtility {
	
	
	
	
	private static  ThreadLocal <WebDriver> driver = new ThreadLocal <WebDriver>() ;
	private Logger logger = LoggerUtility.getLogger(this.getClass()); 
	private WebDriverWait wait;
	
	
	
	
	
	public WebDriver getDriver() {
		return driver.get();
	}

	
	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);// initialize the instance variable driver constructor!
		wait = new WebDriverWait(driver,Duration.ofSeconds(30L));
	}
	
	
	
	
	public BrowserUtility(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver .set( new ChromeDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L));

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
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L));

		}
		
		else if(browserName==Browser.EDGE) {
			driver.set(new  EdgeDriver());
		}
		
		else if(browserName==Browser.FIREFOX) {
			driver.set (new FirefoxDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L));

		}
		else {
			System.err.print("Invalid browser name..please select chrome or edge");
			
		}
	}
	

	public BrowserUtility(Browser browserName, boolean isHeadless) {
	    logger.info("Launching Browser for " + browserName);

	    if (browserName == Browser.CHROME) {
	        if (isHeadless) {
	            ChromeOptions options = new ChromeOptions();
	            options.addArguments("--headless=new");  // recommended
	            options.addArguments("--window-size=1920,1080");
	            driver.set(new ChromeDriver(options));
	        } else {
	            driver.set(new ChromeDriver());
	        }
	    }

	    else if (browserName == Browser.EDGE) {
	        if (isHeadless) {
	            EdgeOptions options = new EdgeOptions();
	            options.addArguments("--headless=new");
	            options.addArguments("--window-size=1920,1080");
	            driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L));

	        } else {
	            driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L));

	        }
	    }

	    else if (browserName == Browser.FIREFOX) {
	        if (isHeadless) {
	            FirefoxOptions options = new FirefoxOptions();
	            options.addArguments("--headless"); // Firefox supports just --headless
	            driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L));

	        } else {
	            driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L));

	        }
	    }

	    else {
	        System.err.println("Invalid browser name.. please select CHROME, EDGE or FIREFOX");
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
//		WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		logger.info("Element Found and Now perform Click");
		element.click();
	}
	
	
	
	
	
	public void clickOnCheckBox(By locator) {
		logger.info("Find Element with locator"+locator);
//		WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		logger.info("Element Found and Now  Click on CheckBox");
		element.click();
	}
	
	
	
	
	
	
	public void clickOn(WebElement element) {
		logger.info("Element Found and Now perform Click");
		
		element.click();
	}
	
	
	public void enterText(By locator, String textToEnter) {
//		WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Enter  Text" +textToEnter);
		element.sendKeys(textToEnter);
		
		
	}
	
	
	
	
	public void clearText(By textBoxLocator) {
//		WebElement element = driver.get().findElement(textBoxLocator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(textBoxLocator));

		logger.info("clearing the Text box feild" +textBoxLocator);
		element.clear();
		
		
	}
	
	
	public void selectFromDropDown(By dropDownLocator, String optionToSelect) {
		logger.info("Finding Element With the locator" +dropDownLocator);
		WebElement element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);
		logger.info("Select The option" +optionToSelect);
		select.selectByVisibleText(optionToSelect);
	}
	
	
	
	public void enterSpecialKey(By locator, Keys KeyToEnter) {
//		WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

		logger.info("Element Found and new Special Key" +KeyToEnter);
		element.sendKeys(KeyToEnter);
		
		
	}
	
	public  String getVisibleText(By locator) {
		logger.info("Finding Element with  the locator"+locator);
		WebElement element = driver.get().findElement(locator);
		logger.info("Enter Visible Text" +locator);
		return element.getText();
		
	}
	
	
	public  String getVisibleText(WebElement element) {
		
		logger.info("Returning the visible Text"+element.getText());
		return element.getText();
		
	}
	
	
	
	
	public List<String> getAllVisibleText(By locator) {
		logger.info("Finding Element with  the locator"+locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Enter Found and now printing the List of Elements");
		List<String> visibleTextList = new ArrayList<String>();
		
		for(WebElement element:elementList) {
			System.out.println(getVisibleText(element));
			visibleTextList.add(getVisibleText(element));
		}
		return visibleTextList; 
		
		
	}
	
	
	
	public List<WebElement> getAlElements(By locator) {
		logger.info("Finding Element with  the locator"+locator);
		List<WebElement> elementList = driver.get().findElements(locator);
		logger.info("Enter Found and now printing the List of Elements");
		
	
		return elementList; 
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public String takeScreenshot(String name) {
		TakesScreenshot screenshot =(TakesScreenshot) driver.get();
		
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
	    SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss"); 
	    String timeStamp = format.format(date);

	    // Constructing path with timestamp
	    String path = System.getProperty("user.dir") + "//screenshots//"+ name + " - " +timeStamp +".png";
	               

	    File screenshotFile = new File(path);
	    try {
	        FileUtils.copyFile(screenshotData, screenshotFile);
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return path;
	}
	}
	
	
	