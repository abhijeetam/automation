package com.first.example;

import org.testng.annotations.Test;

import com.common.CommonSuiteClass;
import com.common.ExtendedLogger;

public class DemoTwo extends CommonSuiteClass {

	ExtendedLogger logger = ExtendedLogger.getLogger(com.first.example.DemoTwo.class);

	@Test
	public void test2() {
		//logger.startTestCase("test2", "test2");
		logger.info("Hello here 2");
		//logger.endTestCase("test2", "test2");
	}

	
	@Test
	public void test1() {
		//logger.startTestCase("test1", "test1");
		logger.error("Hello here ");
		//logger.endTestCase("test1", "test1");
	}

}
