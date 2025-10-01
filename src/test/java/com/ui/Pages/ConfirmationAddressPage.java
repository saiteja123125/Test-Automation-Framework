package com.ui.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Utility.BrowserUtility;

public class ConfirmationAddressPage extends BrowserUtility {
	public static final By PROCEED_TO_CHECKOUT = By.name("processAddress");

	public ConfirmationAddressPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


	
	public ShippmentPage goToShippmentPage() {
		clickOn(PROCEED_TO_CHECKOUT);
		return new ShippmentPage(getDriver());
	}
}
