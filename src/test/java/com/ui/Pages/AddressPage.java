package com.ui.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Utility.BrowserUtility;
import com.ui.pojo.AddressPOJO;

public class AddressPage  extends BrowserUtility{
	
	private static final By COMPANY_TEXT_LOCATOR = By.id("company");
	private static final By ADDRESS1_TEXT_BOX_LOCATOR = By.id("address1");
	private static final By  ADDRESS2_TEXT_BOX_LOCATOR = By.id("address2");
	private static final By CITY_TEXT_BOX_LOCATOR =By.id("city");
	private static final By POST_CODE_TEXTBX_LOCATOR = By.id("postcode");
	private static final By HOME_PHONE_TEXTBOX_LOCATOR = By.id("phone");
	private static final By MOBILE_NUMBER_TEXT_BOX_LOATOR = By.id("phone_mobile");
	private static final By OTHER_INFORMATION_TEXT_AREA_LOCATOR = By.id("other");
	private static final By ADDRESS_ALIAS_LOCATOR = By.id("alias");
	private static final By STATE_DROPDOWN_LOCATOR = By.id("id_state");
	private static final By SAVE_ADDRESS_LOCATOR = By.id("submitAddress");
	private static final By ADDRESS_HEADING =By.tagName("h3");
	
	public AddressPage(WebDriver driver) {
		super(driver);
		
	}

	
	// Encapulation
	public String saveAddress(AddressPOJO addressPOJO) {
		enterText(COMPANY_TEXT_LOCATOR, addressPOJO.getCompany());
		enterText(ADDRESS1_TEXT_BOX_LOCATOR, addressPOJO.getAddressLine1());
		enterText(ADDRESS2_TEXT_BOX_LOCATOR, addressPOJO.getAddressLine2());
		enterText(CITY_TEXT_BOX_LOCATOR, addressPOJO.getCity());
		enterText(POST_CODE_TEXTBX_LOCATOR, addressPOJO.getPostCode());
		enterText(HOME_PHONE_TEXTBOX_LOCATOR, addressPOJO.getHomephoneNumber());
		enterText(MOBILE_NUMBER_TEXT_BOX_LOATOR, addressPOJO.getMobileNumber());
		enterText(OTHER_INFORMATION_TEXT_AREA_LOCATOR, addressPOJO.getOtherInformation());
		clearText(ADDRESS_ALIAS_LOCATOR);
		enterText(ADDRESS_ALIAS_LOCATOR, addressPOJO.getAddressAlis());
		selectFromDropDown(STATE_DROPDOWN_LOCATOR, addressPOJO.getState());
	clickOn(SAVE_ADDRESS_LOCATOR);
	String newAddress = getVisibleText(ADDRESS_HEADING);
	return newAddress;
	}

}

