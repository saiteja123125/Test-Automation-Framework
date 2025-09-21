package com.ui.listerners;

import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Utility.BrowserUtility;
import com.Utility.ExtentReporterUtility;
import com.Utility.LoggerUtility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.test.TestBase;

public class TestListerner implements ITestListener {
	 org.apache.logging.log4j.Logger logger = LoggerUtility.getLogger(this.getClass()); //for logs
	 
	 ExtentSparkReporter extentSparkReport;
	 ExtentReports extentReports;
	 ExtentTest extentTest;

	
	 public  void onTestStart(ITestResult result) {
		 logger.info(result.getMethod().getMethodName());
		 logger.info(result.getMethod().getDescription());
		 logger.info(Arrays.toString(result.getMethod().getGroups()));
//		 extentTest = extentReports.createTest(result.getMethod().getMethodName());
		 ExtentReporterUtility.creatExtentTest(result.getMethod().getMethodName());
		 
	 }
		 public void onTestSuccess(ITestResult result) {
			 logger.info(result.getMethod().getMethodName()+ " "+" PASSED");
//			 extentTest.log(Status.PASS, result.getMethod().getMethodName()+ " " +"PASSED");
			 ExtentReporterUtility.getText().log(Status.PASS,result.getMethod().getMethodName()+ " "+ "PASSED");			  
		 
		 
		 }
		 
		 
	public void onTestFailure(ITestResult result) {
		 logger.info(result.getMethod().getMethodName()+ " "+" FAILED");
		 logger.info(result.getThrowable().getMessage());
//		 extentTest.log(Status.FAIL, result.getMethod().getMethodName()+ " " +"FAILED");
		
		 ExtentReporterUtility.getText().log(Status.FAIL,result.getMethod().getMethodName()+ " "+ "FAILED");			 
		 ExtentReporterUtility.getText().log(Status.FAIL,result.getThrowable().getMessage());	 
		 
		 
		Object testClass =  result.getInstance();
		BrowserUtility browserUtility =((TestBase)testClass).getInstance();
		logger.info("Capturing Screenshot for the failed testCases");
		
		String screenshotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
		logger.info("Attaching Screenhot to Html file");
		ExtentReporterUtility.getText().addScreenCaptureFromPath(screenshotPath);
	}
		
		
		
		
		public void onTestSkipped(ITestResult result) {
			 logger.info(result.getMethod().getMethodName()+ " "+" SKIPPED");
//			 extentTest.log(Status.SKIP, result.getMethod().getMethodName()+ " " +"SKIP");
			 ExtentReporterUtility.getText().log(Status.SKIP,result.getMethod().getMethodName()+ " "+ "SKIPPED");			  

			  }
		
		public void onStart(ITestContext context) {
			logger.info("Test Suite Started");
//			extentSparkReport = new ExtentSparkReporter(System.getProperty("user.dir")+"//report.html");
//			extentReports = new ExtentReports();
//			extentReports.attachReporter(extentSparkReport);
			ExtentReporterUtility.setupSparkReporter("report.html");
		  }
		 public void onFinish(ITestContext context) {
			 logger.info("Test Suite Completed");
//			 extentReports.flush();
			 ExtentReporterUtility.flushReport();
			   
			  }
		    
		  }



