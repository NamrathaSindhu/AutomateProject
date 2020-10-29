package com.qa.automate.healthcare.pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.qa.automate.healthcare.base.BaseTest;
import com.qa.automate.healthcare.base.Utility;

public class RegisterPage extends BaseTest{

	@FindBy(xpath= "(//a/span[text()='Register'])[2]")
	private WebElement registerLabel;
	
	//RegisterTxtBx
	@FindBy(xpath="//input[@id='email']")
	private WebElement registerTB;

//	@FindBy(xpath="//label[text()='Email']")
//	private WebElement registerEmailLabel;
//	
//	@FindBy(xpath="//div[text()='Please enter an email address.']")
//	private WebElement registerInstruction;
//	
//	@FindBy(xpath="//p[text()='This will be your AARP login and will allow you to stay informed. You can change your communication preferences at any time.']")
//	private WebElement emailConfirmationTextmsg;
//	
	@FindBy(xpath="//div[text()='The email address you entered is invalid. Please make sure you entered your correct email address.']")
	private WebElement emailInvalidTextMsg;
//	
//	@FindBy(xpath="//div[text()='Oops! Some of the information you gave us appears to be incorrect. Please check the highlighted areas below.']")
//	private WebElement missingInfoTextMsg;


	@FindBy(xpath="//input[@name='emailConfirm']")
	private WebElement renterTB;
	
	@FindBy(xpath="//input[@id='firstName']")
	private WebElement FirstTB;
	
	@FindBy(xpath="//input[@id='lasttName']")
	private WebElement lastTB;
	
	@FindBy(xpath="//input[@name='dateOfBirth']")
	private WebElement dateob;
	
	@FindBy(xpath="//input[@id='complexPassword']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='postalCode']")
	private WebElement postal;
	
	
	public RegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	Robot robot;
	public void clickRegisterLink() throws InterruptedException
	{
		registerLabel.click();
		Thread.sleep(3000);
	}
	
//	public void checkMailLabel()
//	{
//		Assert.assertTrue(registerEmailLabel.isDisplayed());
//	}
//	
//	public void checkEmailidInstruction()
//	{
//		registerTB.sendKeys(" ");
//		robot.keyPress(KeyEvent.VK_TAB);
//		Assert.assertTrue(registerInstruction.isDisplayed(), "Is displayed");
//		
//	}
//	
//	public void mailConfirmMsg()
//	{
//		Assert.assertTrue(emailConfirmationTextmsg.isDisplayed(),"is displyed");
//	}
//	
//	public void checkEmailErrorMsg()
//	{
//		registerTB.sendKeys("er.namratha@");
//		Assert.assertTrue(emailInvalidTextMsg.isDisplayed(),"is displayed");
//	}
//	
//	public void checkMissingErrorMsg() throws InterruptedException
//	{
//		Thread.sleep(4000);
//		registerTB.sendKeys("er.namratha@gmail.com");
//		Thread.sleep(4000);
//		robot.keyPress(KeyEvent.VK_TAB);
//		Assert.assertTrue(missingInfoTextMsg.isDisplayed(),"is displayed");
//	}
//	public void fillRegister(String mail)
//	{
//		registerTB.sendKeys(mail);
//		renterTB.sendKeys(reemail);
//		FirstTB.sendKeys(fn);
//		password.sendKeys(pw);
//		lastTB.sendKeys(ln);
//		dateob.sendKeys(dob);
//		postal.sendKeys(zip);
//	}
	
	public void excel() throws InterruptedException
	{
		for(int i=0;i<6;i++)
		{
		String email=Utility.readFromXl(DATAPATH, "sheet", i, i);
		registerTB.sendKeys(email);
		Thread.sleep(2000);
		robot.keyPress(KeyEvent.VK_TAB);
		Assert.assertTrue(emailInvalidTextMsg.isDisplayed(), "true");
		}
	}
public void enterinvalidmailid(String email)
{
	registerTB.sendKeys(email);
}
	
}
