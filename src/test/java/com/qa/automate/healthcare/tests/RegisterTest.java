package com.qa.automate.healthcare.tests;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.automate.healthcare.base.BaseTest;
import com.qa.automate.healthcare.base.Utility;
import com.qa.automate.healthcare.pages.LoginPage;
import com.qa.automate.healthcare.pages.RegisterPage;

public class RegisterTest extends BaseTest{

	@DataProvider
	public Object[][] getRegister()
	{
		Object[][] data=Utility.gettestdata("Sheet1");
		return data;
	}
	@Test(dataProvider="getRegister")
	public void email(String email) throws InterruptedException
	{
		LoginPage page=new LoginPage(driver);
		page.menuClick();
		RegisterPage page1=new RegisterPage(driver);
		page1.clickRegisterLink();
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
	}
	
	@Test
	public void verifyEmailField() throws InterruptedException
	{
		
		LoginPage page=new LoginPage(driver);
		page.menuClick();
		RegisterPage page1=new RegisterPage(driver);
		page1.clickRegisterLink();
		//page1.enterinvalidmailid();
	}
}
