package com.ui.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Utility.BrowserUtility;

public class PaymentPage extends BrowserUtility {
	private static final By PAYMENt_BY_WIRE_BUTTON_LOCATOR = By.xpath("//a[@title=\"Pay by bank wire\"]");
	private static final By CONFORM_PAYMENT_BUTTON_LOCATOR = By.xpath("//p[contains(@class,\"cart_navigation\")]/button");
	private static final By ALERT_SUCESS_MESSAGE_LOCATOR = By.xpath("//p[contains(@class,\"success\")]");
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	} 

	public String makePaymentByWire() {
		clickOn(PAYMENt_BY_WIRE_BUTTON_LOCATOR);
		clickOn(CONFORM_PAYMENT_BUTTON_LOCATOR);
		return getVisibleText(ALERT_SUCESS_MESSAGE_LOCATOR);
	}
}
