package com.Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
	private static ExtentReports extentReports;
	
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public static void setupSparkReporter(String reportName) {
		
		 ExtentSparkReporter extentSparkReport = new ExtentSparkReporter(System.getProperty("user.dir")+"//"+reportName);
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReport);
	}

	
	public static void creatExtentTest(String testName) {
		ExtentTest test = extentReports.createTest(testName);
		extentTest.set(test);
	}
	
	public static ExtentTest getText() {
		return extentTest.get();
	}
	 
	public static void flushReport() {
		extentReports.flush();
		
	}
	
}
