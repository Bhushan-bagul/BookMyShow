package com.Pages.TestScenarios;

/***************** Header Files ******************/
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.Base.testSecnario.base;
import com.aventstack.extentreports.Status;

/***************** Class SignIn that inherits base Class ******************/
public class SignIn extends base {

	/***************** Declaration of Variables ******************/
	FileInputStream read;
	Properties prop;
	XSSFWorkbook wb = null;
	
	/***************** Declaration of Xpaths ******************/
	public String signxpath="//*[@id=\"super-container\"]/div[2]/header/div[1]/div/div/div/div[2]/div[2]/div[1]";
	public String googlexpath="//div[contains(text(),'Continue with Google')]";
	public String usernamexpath="//input[@id='identifierId']";
	public String nextxpath="//span[normalize-space()='Next']";
	public String emailxpath="/html/body/div[2]/div/div/div/div/div[2]/div/div[1]/div/div[3]/div/div";
	public String clickxpath="/html/body/div[2]/div/div/div/div/div[2]/form/div[2]";
	
	
	/*****************
	 * google Function that sign in with Google and Email
	 ******************/
	public void google() throws InterruptedException, IOException {

		logger = report.createTest("Sign in with google");
		logger.log(Status.INFO, "Sign-in successfully");
		driver.findElement(By.xpath(signxpath)).click();
				
		for (String winHandles : driver.getWindowHandles()) {

		}
		Thread.sleep(3000);

		read = new FileInputStream(
				"C:\\Users\\bhush\\eclipse-workspace\\Hackathon\\src\\test\\resources\\Utilites\\Signin.xlsx");

		wb = new XSSFWorkbook(
				"C:\\Users\\bhush\\eclipse-workspace\\Hackathon\\src\\test\\resources\\Utilites\\Signin.xlsx");
		XSSFSheet sheet = wb.getSheet("SG");
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell = row.getCell(0);
		String email = cell.toString();

		// click on google

		WebElement google = driver.findElement(By.xpath(googlexpath));
		google.click();
		logger.log(Status.PASS, "Continue with Google Clicked");

		// Shifting to child window
		Set<String> windowID = driver.getWindowHandles();
		Iterator<String> itr = windowID.iterator();

		String parentW = itr.next();
		String childW = itr.next();

		driver.switchTo().window(childW);
		// Enter email
		driver.findElement(By.xpath(usernamexpath)).sendKeys(email);
		Thread.sleep(3000);
		// clicking on next
		driver.findElement(By.xpath(nextxpath)).click();
		Thread.sleep(3000);

		logger.log(Status.FAIL, " Unable to Login in");
		takeScreenShot("signin");

		driver.close();

		logger = report.createTest("Sign in with Email");
		logger.log(Status.INFO, "Browser opened successfully");

		Set<String> windowID2 = driver.getWindowHandles();
		Iterator<String> itr2 = windowID.iterator();
		String parentW2 = itr2.next();

		driver.switchTo().window(parentW2);

		driver.findElement(By.xpath(emailxpath)).click();
		logger.log(Status.PASS, " Clicked on sign in with Email");

		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"emailId\"]")).sendKeys(email);
		Thread.sleep(3000);

		driver.findElement(By.xpath(clickxpath)).click();
		logger.log(Status.PASS, "OTP Entered");

		logger.log(Status.PASS, "Sign in with Email Successfull");
		report.flush();

	}
}
