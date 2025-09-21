
	package com.ui.test;

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

	public class LoginTest3  extends TestBase{
		
		
		
		
//		
//		@Test(description = "Verify with the Valid user is able to login in application",groups = {"e2e","sanity"},dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginTestDataprovider")
//		public void loginTest(User user) {
//			String username = homepage.goToLogin().doLoginWith(user.getEmailAdress(),user.getPassword()).getUserName();
//			Assert.assertEquals(username, "Saiteja Chilaka");
//			
//	  }
//	}
//	
//	
//	
//	
//	@Test(description = "Verify with the Valid user is able to login in application",groups = {"e2e","sanity"},dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginTestCSVDataProvider")
//	public void loginCSVTest(User user) {
////		logger.info("Starated My Login CSV test");
//		String username = homepage.goToLogin().doLoginWith(user.getEmailAdress(),user.getPassword()).getUserName();
//		Assert.assertEquals(username, "Saiteja Chilaka");
////		logger.info("  Login CSV test completed!!");
//	}
	
	
	
//	
	@Test(description = "Verify with the Valid user is able to login in application",groups = {"e2e","sanity"},dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,dataProvider = "LoginTetExcelDataProvider",
			retryAnalyzer =com.ui.listerners.MyRetryAnalyzer.class
)
	public void loginExcelTest(User user) {
		
 
  logger.info("Starated My Login Excel test");
		
		String username = homepage.goToLogin().doLoginWith(user.getEmailAdress(),user.getPassword()).getUserName();
		Assert.assertEquals(username, "Saiteja Chilaka");
		logger.info("  Login Excel test completed!!");
		
  }}
			
		
