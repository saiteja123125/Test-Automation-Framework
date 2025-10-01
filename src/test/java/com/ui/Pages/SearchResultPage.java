package com.ui.Pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.Utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility{
	
	private static final By Product_LISTING_TITLE_Locator = By.xpath("//span[@class=\"lighter\"]");
	
	private static final By All_PRODUCT_LIST_NAMES =By.xpath("//h5[@itemprop=\"name\"]/a");
	
	public SearchResultPage(WebDriver driver){
		super(driver);
	}
	public String getSearchResultTitle() {
		return getVisibleText(Product_LISTING_TITLE_Locator);
	}
	
	public boolean isSearchTermPresentInProductList (String  searchTerm) {
		
		List<String> Keywords =Arrays.asList(searchTerm.toLowerCase().split(""));
	    List<String> productNameList =	getAllVisibleText(All_PRODUCT_LIST_NAMES); 
	    boolean result = productNameList.stream()
	    .anyMatch(name -> (Keywords.stream().anyMatch(name.toLowerCase()::contains)));
		return result;
	}
	
	
	public ProductDetailPage clickOnTheProductAtIndex(int index) {
		clickOn(getAlElements(All_PRODUCT_LIST_NAMES).get(index));
		ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
		return productDetailPage;
		
	}
	
	
}


