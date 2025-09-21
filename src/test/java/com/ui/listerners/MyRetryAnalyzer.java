package com.ui.listerners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.Utility.JsonUtility;
import com.Utility.PropertiesUtil;
import com.constant.Environment;

public class MyRetryAnalyzer  implements IRetryAnalyzer{
	
//private static final int MAX_NUMBER_OF_ATTEMPTS = Integer.parseInt(PropertiesUtil.readproperty(Environment.QA, "MAX_NUMBER_OF_ATTEMPTS"));  // we need to sring to integer use Wrapper class
	
	private static final int MAX_NUMBER_OF_ATTEMPTS = JsonUtility.readJSON(Environment.QA).getMAX_NUMBER_OF_ATTEMPTS();  //for json read

	
	private static int CurrentAttempt = 1;

	@Override
	public boolean retry(ITestResult result) {
		if(CurrentAttempt<=MAX_NUMBER_OF_ATTEMPTS) {
			CurrentAttempt++;
			return true;
			
			
		}
		
		
		return false;
	}

}









//first method

//private static final int MAX_NUMBER_OF_ATTEMPTS = 3;
//private static final int CurrentAttempt =1;
//
//@Override
//public boolean retry(ITestResult result) {
//	if(CurrentAttempt<=MAX_NUMBER_OF_ATTEMPTS) {
//		
//	}
//	
//	
//	return false;
//}
//
//}
