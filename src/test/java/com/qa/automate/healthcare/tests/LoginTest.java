package com.qa.automate.healthcare.tests;
import org.testng.annotations.Test;
import com.qa.automate.healthcare.base.BaseTest;
import com.qa.automate.healthcare.pages.LoginPage;


public class LoginTest extends BaseTest{

	@Test
	public void login() throws InterruptedException
	{
		LoginPage page= new LoginPage(driver);
		page.menuClick();
		//page.clickWorkNJob();
	}
	
	
}
