package com.Pages.TestScenarios;

/***************** Header Files ******************/
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Base.testSecnario.base;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Utils.ExtentReportManager;

/***************** Class Sports that inherits base Class ******************/
public class Sports extends base {

	/***************** Declaration of Variables ******************/
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public ExtentTest logger;
	public String namexpath="//*[@id=\"app\"]/div/div/div/div/div[2]/div/header/div/div/div[1]/div[1]/div[1]/h1";
	public String datexpath="//*[@id=\"app\"]/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[1]/div/div";
	public String priceXpath="//*[@id=\"app\"]/div/div/div/div/div[2]/div/header/div/div/div[2]/div/div/div[2]/div[3]/div";
	/*****************
	 * Sports Function that Navigates to Sports Section and Stores and Displays the
	 * Activites along with Date in Price Wise order ..
	 ******************/
	public void Sports() throws InterruptedException {
		// Clicking sports

		Thread.sleep(2000);
		elementFind("Sports_Xpath").click();
		logger = report.createTest("Opening the Sports Section");
		logger.log(Status.INFO, "Sports Section Opened  successfully");

		Thread.sleep(3000);
		// Clicking weekend
		elementFind("This_Weekend_Xpath").click();
		logger.log(Status.PASS, "This Weeekend Selected Successfully");

		// clicking price
		Thread.sleep(3000);
		elementFind("Price_Xpath").click();
		logger.log(Status.PASS, "Price Selected");
		;

		// clicking 0-500
		Thread.sleep(3000);
		elementFind("Range_Xpath").click();
		logger.log(Status.PASS, "Range selected");

		// Get name of all sports
		System.out.println(
				"================================================================================================================");

		List<WebElement> li = driver.findElements(By.xpath("//*[@class=\'sc-7o7nez-0 bJKnib\']"));
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> date = new ArrayList<String>();
		ArrayList<Integer> price = new ArrayList<Integer>();
		Thread.sleep(3000);

		for (int i = 0; i < 12; i++) {

			li.get(i).click();

			Thread.sleep(7000);
			String name1 = driver.findElement(By.xpath(namexpath)).getText();
			String date1 = driver.findElement(By.xpath(datexpath)).getText();
			String price1 = driver.findElement(By.xpath(priceXpath)).getText();
			logger.log(Status.PASS, "Click on Sports Acitivity " + name1);
			String a = price1.substring(2);
			int a1 = Integer.parseInt(a);
			date.add(name1 + " " + date1);
			price.add(a1);
			driver.navigate().back();
			Thread.sleep(5000);
			li = driver.findElements(By.xpath("//*[@class=\'sc-7o7nez-0 bJKnib\']"));

		}
		logger.log(Status.INFO, "All the Sports Activity Selected ");
		Map<Integer, String> k = new TreeMap();
		for (int i = 0; i < 12; i++) {

			k.put(price.get(i), date.get(i));
		}
		for (String ka : k.values()) {
			System.out.println(ka);
		}
		logger.log(Status.PASS, "Test executed " + "Names of the Sports Printed..");
		report.flush();
	}
}
