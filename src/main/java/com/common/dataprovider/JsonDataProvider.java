package com.common.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.common.Config;
import com.common.ExtendedLogger;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonDataProvider implements DataProvider {

	ExtendedLogger logger = ExtendedLogger.getLogger(JsonDataProvider.class);
	
	public List<Map<String,String>> getTestData(String apiName) {
		String dataFolderPath = Config.getInstance().getDataFolderPath();
		File file = new File(dataFolderPath + File.separator + "json" + File.separator + apiName + ".json");
		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		try {
			try (FileInputStream in = new FileInputStream(file)) 
			{
				ObjectMapper objectMapper = new ObjectMapper();
				dataList = objectMapper.readValue(in, new TypeReference<List<Map<String, String>>>(){});
			}
		}
		catch (FileNotFoundException ex) {
			logger.error("file json not found" + file.getName());
		}
		catch (IOException ioex) {
			logger.error("error reading in file json" + file.getName());
		}
		catch (Exception ex) {
			logger.error("Error in parsing json file");
			ex.printStackTrace();
		}
		return dataList;
	}
}
