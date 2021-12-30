package com.Pages.TestScenarios;

/***************** Header Files ******************/
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Base.testSecnario.base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.ExtentReportManager;

/***************** Class HomePage that inherits base Class ******************/
public class Movies extends base {

	/***************** Declaration of Variables ******************/
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;

	/*****************
	 * Lang Function that Navigates to Movies Section and Stores and Displays the
	  Languages Present..
	 ******************/
	public void Lang() throws InterruptedException {

		Thread.sleep(20000);
		elementFind("Movies_Xpath").click();
		logger = report.createTest("Opening the Movies Section");
		logger.log(Status.INFO, "Movies Section Opened  successfully");
		List<WebElement> li = driver
				.findElements(By.xpath("//*[@id=\"super-container\"]/div[2]/div[4]/div[2]/div[2]/div"));
		logger.log(Status.PASS, "Test executed " + "Languages selected");
		Thread.sleep(3000);
		for (WebElement x : li) {
			System.out.println(x.getText());
		}
		logger.log(Status.PASS, "Test executed " + "Names of the Movies Printed..");

		report.flush();

	}
}
