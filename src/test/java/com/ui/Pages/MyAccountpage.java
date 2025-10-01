package com.ui.Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Utility.BrowserUtility;

public class MyAccountpage extends BrowserUtility {
	
	private static final By USER_NAME_LOCATOR = By.xpath("//a[@title = 'View my customer account']/span");
	private static final By SEARCH_TEXT_BOX_Locator = By.id("search_query_top");
	private static final By ADD_NEW_ADDRESS_LINK_LOCATOR = By.xpath("//a[@title=\"Add my first address\"]");
	
	public MyAccountpage(WebDriver driver) {
		super(driver);
		
	}
	
	public String getUserName() {	
		return getVisibleText(USER_NAME_LOCATOR);
	}
	
	
	public SearchResultPage searchforAProduct(String productName) {
enterText(SEARCH_TEXT_BOX_Locator,productName);
enterSpecialKey(SEARCH_TEXT_BOX_Locator,Keys.ENTER);
SearchResultPage searchResultPage = new SearchResultPage(getDriver());
return searchResultPage;
}
	
	
	
	
	public AddressPage goToAddressPage() {
		clickOn(ADD_NEW_ADDRESS_LINK_LOCATOR);
		AddressPage addressPage = new AddressPage(getDriver());
		return addressPage;
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
