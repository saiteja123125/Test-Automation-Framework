package com.ui.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Utility.BrowserUtility;
import com.Utility.JsonUtility;
import com.constant.Browser;

public final class Homepage extends  BrowserUtility{
	 private  static final By SIGN_IN_LINK_LOCATOR=By.xpath( "//a[contains(text(),'Sign in')]");
	 private static final JsonUtility JSONUtility = null;
	 private static final Enum QA = null;

   public Homepage(Browser browserName,boolean isHeadless) {
		super(browserName); //if we add is headless,run headless
		goToWebsite(JSONUtility.readJSON(QA).getUrl());

		
	}
   
   public  Homepage (WebDriver driver) {
	   super(driver); // to Call the parent class constructor from the child constructor
	   goToWebsite(JSONUtility.readJSON(QA).getUrl());
   }
   


	
	public LoginPage goToLogin() {
		clickOn(SIGN_IN_LINK_LOCATOR);
		LoginPage loginpage = new LoginPage(getDriver());
		return loginpage;
		
	}


	public void quit() {
		// TODO Auto-generated method stub
		
	}
	
	

}
