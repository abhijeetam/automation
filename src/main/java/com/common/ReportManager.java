package com.common;

import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportManager {

	private static ReportManager instance;

	private static ExtentReports report;
	
	private static ExtentTest parent;
	
	private static ExtentTest child;

	private ReportManager() {

	}

	public  static ReportManager getInstance() {
		if (instance == null) {
			instance = new ReportManager();
			initializeReport();
		}
		return instance;
	}

	private static void initializeReport() {
		String reportPath = Config.getInstance().getReportOutputPath();
		File file = new File(reportPath + File.separator + "report.html");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {

			}
		}
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(file);
		String extentConfigPath = Config.getInstance().getExtentConfigPath();
		reporter.loadConfig(extentConfigPath + File.separator + "extent-config.xml");
		if(report == null){
			//Set HTML reporting file location
			report = new ExtentReports();
			report.attachReporter(reporter);
		}
	}


	public void startSuite() {
		parent = report.createTest("Report Suite");
	}


	public void endSuite() {
		report.flush();
		report.close();
	}

	public void startClass(String className, String description) {
		child = parent.createNode(className, description);
	}
	
//	public void startTest(String testcaseName, String description) {
//		child.log(Status.INFO, testcaseName + "description" + "started");
//	}
//	
//	public void endTest(String testcaseName, String description) {
//		child.log(Status.INFO, testcaseName + "description" + "ended");
//	}
	
	public void endClass() {
		report.flush();
	}

	public void info(String message) {
		child.log(Status.INFO, message);
	}
	
	
	public void error(String message) {
		child.log(Status.ERROR, message);
	}
	
	public void pass(String message) {
		child.log(Status.PASS, message);
	}

}
