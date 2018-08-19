package com.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Config {
	
	private static Config instance;
	
	private Properties properties = new Properties();
	
	private Config() 
	{
		try {
			String configFile = System.getProperty("config.properties");
			File file = new File(configFile);
			properties.load(new FileReader(file));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}
	
	public boolean isExtentReportEnabled() {
		return "yes".equals(properties.getProperty("extentreport.enabled"));
	}
	
	public String getMySqlUserName() {
		return properties.getProperty("mysqldb.username");
	}
	
	public String getMySqlConnectionString() {
		return properties.getProperty("mysqldb.connectionstring");
	}
	
	public String getMySqlUserPassword() {
		return properties.getProperty("mysqldb.password");
	}
	
	
	public String getDataSource() {
		return properties.getProperty("data.source");
	}

	public String getDataFolderPath() {
		return properties.getProperty("data.folder.path");
	}

	public String getReportOutputPath() {
		return properties.getProperty("report.out.path");
	}

	public String getExtentConfigPath() {
		return properties.getProperty("extent.config.path");
	}
}
