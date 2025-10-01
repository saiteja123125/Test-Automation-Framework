
	package com.ui.test;

	import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.Utility.LoggerUtility;
//import static com.constants.Browser.*;
import com.constant.Browser;
import com.ui.Pages.Homepage;
import com.ui.pojo.User;

import io.opentelemetry.api.logs.Logger;

@Listeners(com.ui.listerners.TestListerner.class) //package name

	public class InvalidCredLoginTest  extends TestBase{
//	Logger logger = LoggerUtility.getLogger(this.getClass());
		
	private static final	 String INVALID_EMAIL_ADDRESS = "saiteja@123.com";
	private static final	 String INVALID_PASSWORD= "password123";	
		
		
		@Test(description = "Verify if the proper error messege is shown for the user when they enter invalid credentials",groups = {"e2e","sanity"})
			
		public void loginTest() {
			assertEquals(homepage.goToLogin().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS,INVALID_PASSWORD)
					.getErrorMessage(),"Authentication failed.");
		}
	}
	
	
	
	
