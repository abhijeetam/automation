package com.common;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.common.dataprovider.DataProviderFactory;



public class CommonSuiteClass {


	@BeforeSuite
	public void beforeSuite() {
		if (Config.getInstance().isExtentReportEnabled()) {
			ReportManager.getInstance().startSuite();
		}
	}

	@AfterSuite
	public void afterSuite() {
		if (Config.getInstance().isExtentReportEnabled()) {
			ReportManager.getInstance().endSuite();
		}
	}


	@BeforeClass
	public void beforeClass() {
		if (Config.getInstance().isExtentReportEnabled()) {
			//String[] tokens = this.getClass().getName().split(".");
			//String className = tokens[tokens.length - 1];
			ReportManager.getInstance().startClass(this.getClass().getSimpleName(), "");
		}
	}



	@AfterClass
	public void afterClass() {
		if (Config.getInstance().isExtentReportEnabled()) {
			ReportManager.getInstance().endClass();
		}
	}


	@DataProvider(name="data-provider")
	public Object[][] getTestCasesFromDB() {
		
		String apiName = this.getClass().getSimpleName();
		
		// read from configuration 
		// 1. may be just now data source (static array) 
		// 2. from DB
		// 3. From Xls
		// 4. From CSV
		// 5. From JSON
		
		// idea here is to make a two dimensional array containing all columns and rows (matrix) - 
		// row being one test case and columns are data
		String source = Config.getInstance().getDataSource();
		
		com.common.dataprovider.DataProvider dataProvider = DataProviderFactory.getInstance().getDataProvider(source);
		List<Map<String, String>> testDataList = dataProvider.getTestData(apiName);

		/*for (int i=0; i<testDataList.size(); i++) {
			Map<String, String> rowMapData = testDataList.get(i);
			Iterator<String> rowMapDataIterator = rowMapData.keySet().iterator();
			while(rowMapDataIterator.hasNext()) {
				String key = rowMapDataIterator.next();
				System.out.println(key + " " +  rowMapData.get(key));
			}
		}*/
		
		Object[][] testData = new Object[testDataList.size()][];
		
		for (int i=0; i < testData.length; i++) {
			testData[i] = new Object[] {testDataList.get(i)};
		}
		return testData;
	}

}
