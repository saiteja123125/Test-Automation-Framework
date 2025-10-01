package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Utility.FakeAddressUtility;
import com.ui.Pages.AddressPage;
import com.ui.Pages.MyAccountpage;
import com.ui.pojo.AddressPOJO;

public class AddNewFirstAddressTest extends TestBase {
	
	
	
	private MyAccountpage myAccountPage;
	private AddressPage addressPage;
	private AddressPOJO address;

	@BeforeMethod(description = "Valid First Time user  login into the application")
	public void setup() {
		myAccountPage =homepage.goToLogin().doLoginWith("likelef296@skateru.com", "password");
		
//		
//		address = new AddressPOJO("Wipro", "address line1", "address line2", "city", "12345", "9393490427", "9393490428", "other", "office adress", "California");
//	}
//	
		address = FakeAddressUtility.getFakerAddress();
	}
		
	@Test(description ="Verify  the login user is able to click Address",groups = {"e2e","sanity","smoke"})
	
	public void addNewAddress() {
		String newAdress= myAccountPage.goToAddressPage().saveAddress(address);
		Assert.assertEquals(newAdress, address.getAddressAlis().toUpperCase());
	}

}
