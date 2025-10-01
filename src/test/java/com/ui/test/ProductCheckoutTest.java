package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.Pages.SearchResultPage;
import static com.ui.Pages.Size.*;

public class ProductCheckoutTest  extends TestBase{
	
	private static final String SEARCH_TERM = "printed Summer dress";
	 private SearchResultPage searchResultPage;
	@BeforeMethod(description = "User Logs into the application and search for a product")
	public void setup() {
		searchResultPage =	homepage.goToLogin().doLoginWith("likelef296@skateru.com", "password").searchforAProduct(SEARCH_TERM);
		
	}
	
	
	@Test(description = " Verify if the login user is able to buy a dress",groups= {"e2e","sanity","smoke"})
	public void checkoutTest() {
	String result = 	searchResultPage.clickOnTheProductAtIndex(1).changeSize(L).addProductToCart().proceedToCheckout()
		.gotoconiformAddressPage().goToShippmentPage().goToPaymentpage().makePaymentByWire();
	System.out.println(result);
	
	Assert.assertTrue(result.contains("complete"));
		
	}
	
	

}
