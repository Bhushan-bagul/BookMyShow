package com.Testing.TestScenario;

/***************** Header Files ******************/
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.Base.testSecnario.base;
import com.Pages.TestScenarios.Movies;
import com.Pages.TestScenarios.SignIn;
import com.Pages.TestScenarios.Sports;

	
/***************** Class Regression that inherits base Class ******************/
public class Regression extends base {
	
	/***************** Creation  of Objects ******************/
	Movies mo = new Movies();
	SignIn signin = new SignIn();
	Sports spo =  new Sports();
	
	
	
	/*****************
	 * signin Function calls google funtion in SignIn class
	 ******************/
	@Test(priority= 0)
	public void signin() throws InterruptedException, IOException
	{
		signin.google();
	}
	
	
	/*****************
	 * movies Function calls lang funtion in Movies class
	 ******************/
	@Test(priority= 1)
	public void movies() throws InterruptedException
	{
		mo.Lang();
	}
	
	/*****************
	 * Sports Function calls spo funtion in sports class
	 ******************/
	@Test(priority= 2)
	public void Sports() throws InterruptedException
	{
		spo.Sports();
		
	}
	
	/*****************
	 * CloseBrowser Function closes the Browser
	 ******************/
	@AfterSuite
	public void CloseBrowser()
	{
		browserClose();
	}
	
	
	
	
	
}
