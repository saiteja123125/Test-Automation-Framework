package com.ui.test;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.Pages.MyAccountpage;

@Listeners({com.ui.listerners.TestListerner.class})


public class SerachProductText  extends TestBase{
	private MyAccountpage myAccountPage;
	private static final String SEARCH_TERM ="Printed Summer Dress";
	
	
	
	@BeforeMethod(description = "valid user login into the application")
	public void setup() {
		myAccountPage =homepage.goToLogin().doLoginWith("likelef296@skateru.com", "password");
	}
	
	@Test(description ="Verify  the login user is able to serach for the product and correct products are displayed",groups = {"e2e","sanity","smoke"})
	
	public void verifyproductSearchTest() {
	boolean actualResult =  myAccountPage.searchforAProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
Assert.assertEquals(actualResult, true);		
	}
	
	
	

}
