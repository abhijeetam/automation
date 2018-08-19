package com.common;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportExample {
	
	
	public static void main(String args[]) {
		ExtentReports reports = new ExtentReports();
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("/Users/naveenkumar_gupta/workspace/automation/logs/output.html");
		//reporter.loadConfig(stream);
		reports.attachReporter(reporter);
		ExtentTest parent = reports.createTest("Suite");
		ExtentTest child1 = parent.createNode("test1");
		child1.log(Status.PASS, "abcd");
		child1.log(Status.ERROR, "file not found");
		reports.flush();
		
		ExtentTest child2 = parent.createNode("test2");
		child2.log(Status.PASS, "abcd");
		child2.log(Status.ERROR, "file not found");
		reports.flush();
		
		ExtentTest child3 = parent.createNode("test1");
		child3.log(Status.PASS, "abcd");
		child3.log(Status.ERROR, "file not found");
		reports.flush();
		
		reports.close();
	}

}
