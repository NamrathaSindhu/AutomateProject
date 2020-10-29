package com.qa.automate.healthcare.pages;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.automate.healthcare.base.BaseTest;

public class LoginPage extends BaseTest{

	//Menu icon
	@FindBy(className="icon-menu")
	private WebElement menu;
	
	//travel drop down link
	@FindBy(xpath="//a[@data-formelementid='AARPE-NAV-LNK-CLK-WOR-WOR']")
	private WebElement worknJobLink;
	
		
	public LoginPage(WebDriver driver) {
	
	PageFactory.initElements(driver, this);
	}

	public WebElement getMenu() {
		return menu;
	}
	
	public void menuClick() throws InterruptedException
	{
		menu.click();
		Thread.sleep(3000);
	}
	
	public void clickWorkNJob()
	{
		worknJobLink.click();
	}
}
