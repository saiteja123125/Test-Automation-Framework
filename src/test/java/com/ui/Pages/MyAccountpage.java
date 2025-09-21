package com.ui.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utility.BrowserUtility;

public class MyAccountpage extends BrowserUtility {
	
	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title = 'View my customer account']/span");

	public MyAccountpage(WebDriver driver) {
		super(driver);
		
	}
	
	public String getUserName() {
		
		
		return getVisibleText(USER_NAME_LOCATOR);
	}

}

	
	
		
//		private static final By USER_NAME_LOCATOR = By.xpath("//a[@title='View my customer account']/span");
//
//		public MyAccountpage(WebDriver driver) {
//			super(driver);
//		}
//		
//		public String getUserName() {
//			WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
//	        WebElement userNameElement = wait.until(
//	            ExpectedConditions.visibilityOfElementLocated(USER_NAME_LOCATOR)
//	        );
//
//	        return userNameElement.getText().trim();
//	    }
//	}
