package com.common;

import org.apache.log4j.Logger;

public class ExtendedLogger {


	private Logger logger;
	private ReportManager report = ReportManager.getInstance();

	public ExtendedLogger(Logger logger) {
		this.logger = logger;
	}

	//----------------------------------------------------------------------
	// Duplicates of base-class static methods.
	//---------------------------------------------------------------------- {=ExtendedLogger.factories}
	/**  Like {@link Logger#getLogger(String)}, but configures the logging
	 *   system using the log4j.properties or log4j.xml file at {@link Places#CONFIG}.
	 */
	public static ExtendedLogger getLogger(String name) {
		return new ExtendedLogger( Logger.getLogger(name) );
	}

	/**  Like {@link Logger#getLogger(Class)}, but configures the logging
	 *   system using the log4j.properties or log4j.xml file at {@link Places#CONFIG}.
	 */
	public static ExtendedLogger getLogger(Class<?> className) {
		return new ExtendedLogger( Logger.getLogger(className) );
	}

	public void startTestCase(String testcaseName) {
		if (Config.getInstance().isExtentReportEnabled()) {
			report.info(testcaseName + "started");
		}
	}
	
	public void endTestCase(String testcaseName) {
		if (Config.getInstance().isExtentReportEnabled()) {
			report.info(testcaseName + "ended");
		}
	}
	
	
	public void info(String message) {
		if (Config.getInstance().isExtentReportEnabled()) {
			report.pass(message);
		}
		logger.info(message);
	}

	public void error(String message) {
		if (Config.getInstance().isExtentReportEnabled()) {
			report.error(message);
		}
		logger.error(message);
	}
}
