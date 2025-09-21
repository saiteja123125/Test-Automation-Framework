package com.Utility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//globally conf
public class LoggerUtility {
	
//	Logger logger;
//	
//	private static Logger Logger;
//	
//	private LoggerUtility() {
//		
//	}
	
	public  static Logger   getLogger(Class<?> clazz) {
		Logger logger = null;
		if(logger == null) {
			logger = LogManager.getLogger(clazz);
		}
		return logger;
		
	}
}
	
	
