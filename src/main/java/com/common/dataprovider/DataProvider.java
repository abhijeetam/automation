package com.common.dataprovider;

import java.util.List;
import java.util.Map;

public interface DataProvider {
	List<Map<String,String>> getTestData(String apiName);
}
