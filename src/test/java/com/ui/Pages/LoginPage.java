package com.ui.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Utility.BrowserUtility;

public class LoginPage  extends  BrowserUtility{
	
	
private static final     By EMAIL_TEXT_BOX_LOCTOR=By.id("email");
private static final	 By PASSWORD_TEXT_BOX_LOCTOR=By.id("passwd");
private static final	 By SUBMIT_BUTTON_LOCATOR =By.id("SubmitLogin");

	public LoginPage(WebDriver driver) {
		super(driver);
		
		
	}
	
	
	public MyAccountpage doLoginWith(String emailAddress,String password) {
		enterText(EMAIL_TEXT_BOX_LOCTOR,emailAddress);
		enterText(PASSWORD_TEXT_BOX_LOCTOR,password);
		clickOn( SUBMIT_BUTTON_LOCATOR);
		MyAccountpage myAccountpage = new MyAccountpage(getDriver());
		return myAccountpage;
		
	}

}
