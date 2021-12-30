package com.Testing.TestScenario;

import java.io.IOException;

import org.testng.annotations.Test;

import com.Base.testSecnario.base;
import com.Pages.TestScenarios.HomePage;
import com.Pages.TestScenarios.Movies;
import com.Pages.TestScenarios.SignIn;
import com.Pages.TestScenarios.Sports;

public class Smoke extends base{

	HomePage hp = new HomePage();
	Movies mo = new Movies();
	SignIn signin = new SignIn();
	Sports spo =  new Sports();
	
	@Test
	public void testCases() throws InterruptedException, IOException
	{
		hp.homepage();
		
		
		//report.flush();
		
			
		
	}
	
	
}