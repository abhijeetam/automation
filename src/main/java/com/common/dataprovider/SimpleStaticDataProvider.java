package com.common.dataprovider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SimpleStaticDataProvider implements DataProvider {

	public List<Map<String,String>> getTestData(String apiName) {

		Map<String, List<Map<String, String>>> apiListData = new HashMap<String, List<Map<String,String>>>();

		String[] columnNames = {"id", "description", "result"};

		String[][] testThirdAPIData = {
				{"1", "abc" , "204"}, 
				{"2", "abc" , "201"}, 
				{"3", "abc" , "204"}
		};

		String[][] testFirstAPIData = {
				{"1", "abc" , "204"}, 
				{"2", "abc" , "201"}, 
				{"3", "abc" , "204"}
		};


		String[][] testSecondAPIData = {
				{"1", "abc" , "204"}, 
				{"2", "abc" , "201"}, 
				{"3", "abc" , "204"}
		};
		
		List<Map<String, String>> thirdListData = new ArrayList<Map<String,String>>();

		for (int i=0; i<testSecondAPIData.length; i++) {
			Map<String, String>  rowMapData = new HashMap<String, String>();
			for (int j=0; j<testSecondAPIData[i].length; j++) {
				rowMapData.put(columnNames[j], testThirdAPIData[i][j]);
			}
			thirdListData.add(rowMapData);
		}

		apiListData.put("ThirdAPI", thirdListData);

		List<Map<String, String>> firstListData = new ArrayList<Map<String,String>>();

		for (int i=1; i<testSecondAPIData.length; i++) {
			Map<String, String>  rowMapData = new HashMap<String, String>();
			for (int j=0; j<testSecondAPIData[i].length; j++) {
				rowMapData.put(columnNames[j], testFirstAPIData[i][j]);
			}
			firstListData.add(rowMapData);
		}
		
		apiListData.put("FirstAPI", firstListData);

		List<Map<String, String>> secondListData = new ArrayList<Map<String,String>>();

		for (int i=1; i<testSecondAPIData.length; i++) {
			Map<String, String>  rowMapData = new HashMap<String, String>();
			for (int j=0; j<testSecondAPIData[i].length; j++) {
				rowMapData.put(columnNames[j], testSecondAPIData[i][j]);
			}
			secondListData.add(rowMapData);
		}
		
		apiListData.put("SecondAPI", secondListData);
		
		return apiListData.get(apiName);
	}

}
