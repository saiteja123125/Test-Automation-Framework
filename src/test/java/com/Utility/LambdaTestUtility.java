package com.Utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility {
    public static String HUB_URL = "https://hub.lambdatest.com/wd/hub";
    private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver> ();
    
    private static ThreadLocal<DesiredCapabilities> capbilitiesLocal = new ThreadLocal<DesiredCapabilities>();
    
    
    public static WebDriver initializeLambdaTestSession(String browser,String testName) {
    	DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "127");
        Map<String, Object> ltOptions = new HashMap();
        ltOptions.put("user", "stej7002");
        ltOptions.put("accessKey", "LT_CXgwetTbKMKyl1Su7UZKp3rQfAXzZKZ9Iqp2U761yrm41rS");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.23.0");
        capabilities.setCapability("LT:Options", ltOptions);
        capbilitiesLocal.set(capabilities);

        WebDriver driver = null;
		try {
			driver = new RemoteWebDriver(new URL (HUB_URL), capbilitiesLocal.get());
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        driverLocal.set(driver);
    	
    	return driverLocal.get();
    }
    public static void quitSession() {
    	if(driverLocal.get() !=null) {
    		driverLocal.get().quit();	
    	}
    
    	
    	
    
}}
