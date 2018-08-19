package com.first.example;

import org.testng.annotations.Test;

import com.common.CommonSuiteClass;
import com.common.ExtendedLogger;

public class DemoOne extends CommonSuiteClass {
	
	
	ExtendedLogger logger = ExtendedLogger.getLogger(com.first.example.DemoOne.class);
	
	@Test
	public void test1() {
		//logger.startTestCase("DemoOne", "Inside DemoOne");
		logger.info("Hello here 1");
		//logger.endTestCase("DemoOne", "Inside DemoOne");
	}
	
	@Test
	public void test2() {
		//logger.startTestCase("DemoOne", "DemoOne");
		logger.error("Hello here 1");
		//logger.endTestCase("DemoOne", "Inside DemoOne");
	}
	
	
	

}
