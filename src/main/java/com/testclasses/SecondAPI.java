package com.testclasses;

import java.util.Map;

import org.testng.annotations.Test;

import com.common.CommonSuiteClass;
import com.common.ExtendedLogger;

public class SecondAPI extends CommonSuiteClass {

	ExtendedLogger logger = ExtendedLogger.getLogger(SecondAPI.class);

	@Test(dataProvider="data-provider")
	public void test(Map<String, String> testData) {
		logger.info(testData.get("id"));
	}

}
