package com.Pages.TestScenarios;

/***************** Header Files ******************/
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.Base.testSecnario.base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.ExtentReportManager;

/***************** Class HomePage that inherits base Class ******************/
public class HomePage extends base {

	/***************** Declaration of Variables ******************/
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;

	/*****************
	 * Homepage Function that invokes browser and Lands on BookMyShow Homepage
	 ******************/
	public void homepage() throws InterruptedException {
		invokeBrowser();
		logger = report.createTest("Opening the browser");
		logger.log(Status.INFO, "Browser opened successfully");
		Thread.sleep(5000);
		elementFind("Cancel_Xpath").click();
		Thread.sleep(2000);
		elementFind("Pune_Xpath").click();
		logger.log(Status.PASS, "Pune City Selected" + " -   successfully");
		Thread.sleep(2000);
		logger.log(Status.PASS, "Test executed " + "BookMyShow Homepage opened..");
		report.flush();
	}
}
