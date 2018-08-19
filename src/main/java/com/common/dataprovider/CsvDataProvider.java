package com.common.dataprovider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.common.Config;
import com.common.ExtendedLogger;
import com.opencsv.CSVReader;

public class CsvDataProvider implements DataProvider {

	ExtendedLogger logger = ExtendedLogger.getLogger(CsvDataProvider.class);
	
	public List<Map<String,String>> getTestData(String apiName) {
		String dataFolderPath = Config.getInstance().getDataFolderPath();
		File file = new File(dataFolderPath + File.separator + "csv" + File.separator + apiName + ".csv");
		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		try {
			try (CSVReader reader = new CSVReader(new FileReader(file), ',');) 
			{
				String[] headers = null;
				headers = reader.readNext();
				String[] record = null;
				while((record = reader.readNext()) != null) {
					Map<String, String> rowMap = new HashMap<>();
					for (int i=0; i<record.length; i++) {
						rowMap.put(headers[i], record[i]);
					}
					dataList.add(rowMap);
				}
			}
		}
		catch (FileNotFoundException ex) {
			
		}
		catch (IOException ioex) {

		}
		return dataList;
	}

}
