package com.common.dataprovider;

public class DataProviderFactory {

	private static DataProviderFactory factory = null;

	private DataProviderFactory() {

	}

	public static DataProviderFactory getInstance() {
		if (factory == null) {
			factory = new DataProviderFactory();
		}
		return factory;
	}

	public DataProvider getDataProvider(String source) {
		if ("db".equals(source)) {
			return new DBDataProvider();
		}
		else if ("csv".equals(source)) {
			return new CsvDataProvider();
		}
		else if ("json".equals(source)) {
			return new JsonDataProvider();
		}
		else if ("xls".equals(source)) {
			return new XlsDataProvider();
		}
		else {
			return new SimpleStaticDataProvider();
		}
	}

}
