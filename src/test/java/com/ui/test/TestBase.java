package com.ui.test;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.Utility.BrowserUtility;
import com.Utility.LambdaTestUtility;

import com.Utility.LoggerUtility;
import com.constant.Browser;
import com.ui.Pages.Homepage;

public class TestBase {
	
	
	Homepage homepage;
	 org.apache.logging.log4j.Logger logger = LoggerUtility.getLogger(this.getClass()); 
	 private boolean isLambdaTest;  //if make true run lamda test
//	private boolean isHeadless = true;
	
	@Parameters({"browser", "isLambdaTest","isHeadless"})
	@BeforeMethod(description ="Load the Homepage of the website")
	public void setup(
	@Optional("chrome")String browser, 
	@Optional("false")boolean isLambdaTest, 
	@Optional("true")boolean  isHeadless, ITestResult result) {
		
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;
		if(isLambdaTest) {
			
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser, result.getMethod().getMethodName());
	homepage = new Homepage(lambdaDriver);
			
		}else {
// running in the locall machine 
		logger.info("Load the Homepage of the website");
		   homepage = new Homepage(Browser.valueOf(browser.toUpperCase()),true);	//add  is headless in true if run headless
	}
}
	
	
	
	
	
	public BrowserUtility getInstance() {
		return homepage;
		
	}
	
	@AfterMethod(description ="Tear Down the browser")
	public void tearDown() {
		
		if(isLambdaTest) {
			LambdaTestUtility.quitSession();
		}
		else {
			
			homepage.quit();
		}
		homepage.quit();
	
	}}