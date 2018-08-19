package com.testclasses;

import java.util.Map;

import org.testng.annotations.Test;

import com.common.CommonSuiteClass;
import com.common.ExtendedLogger;

public class ThirdAPI extends CommonSuiteClass {

	ExtendedLogger logger = ExtendedLogger.getLogger(ThirdAPI.class);

	@Test(dataProvider="data-provider")
	public void test(Map<String, String> testData) {
		logger.info(testData.get("id"));
	}

}
