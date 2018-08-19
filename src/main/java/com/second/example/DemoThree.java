package com.second.example;

import org.testng.annotations.Test;

import com.common.CommonSuiteClass;
import com.common.ExtendedLogger;

public class DemoThree extends CommonSuiteClass {

	ExtendedLogger logger = ExtendedLogger.getLogger(com.second.example.DemoThree.class);

	@Test
	public void test3() {
		//logger.startTestCase("test3", "test3");
		logger.info("Hello here 3");
		//logger.endTestCase("test3", "test3");
	}
	
	@Test
	public void test1() {
		//logger.startTestCase("test1", "test1");
		logger.error("Hello here 3");
		///logger.endTestCase("test1", "test1");
	}
	
	
}
