package com.common.dataprovider;

import java.util.List;
import java.util.Map;

import com.common.Config;

public class DBDataProvider implements DataProvider {

	public List<Map<String,String>> getTestData(String apiName) {
		// get connection details from where ??
		// we can design based on input from config file and call different factory of data providers.

		String username = Config.getInstance().getMySqlUserName();
		String password = Config.getInstance().getMySqlUserPassword();
		String connectionString = Config.getInstance().getMySqlConnectionString();

		// load the driver (mysql driver) 

		return null;
	}


}
