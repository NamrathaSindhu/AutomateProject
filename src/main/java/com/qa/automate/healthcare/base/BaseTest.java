package com.qa.automate.healthcare.base;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


@Listeners(Results.class)
 public abstract class BaseTest implements IAutoConstant{

	static
	{
		System.setProperty(CHROME_KEY,CHROME_VALUE);
		System.setProperty(FIREFOX_KEY,FIREFOX_VALUE);
	}
	
	public WebDriver driver;
	
	public String it=Utility.getProperty(CONFIG_PATH,"ito");
	public long l=Long.parseLong(it);
	public String url=Utility.getProperty(CONFIG_PATH,"url");
	
	@Parameters({"ip","browser"})
	@BeforeMethod(alwaysRun=true)
	public void openApp(@Optional("localhost")String ip, @Optional("chrome")String browser)
	{
		driver=Utility.openBrowser(ip,browser);
		//driver.manage().timeouts().pageLoadTimeout(l, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(l,TimeUnit.SECONDS);
		driver.get(url);
		//driver.manage().timeouts().pageLoadTimeout(l, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@AfterMethod(alwaysRun=true)
	public void closeApp(ITestResult result)
	{
		String name=result.getName();
		int status = result.getStatus();
		if(status==2)
		{
			String photo = Utility.getPhoto(driver, "./photo");
			Reporter.log("Test"+ name +"status fail",true);
			Reporter.log("Photo:"+ photo,true);
		}
		else {
			Reporter.log("Test"+ name +"status pass",true);
		}
		driver.quit();
	}
	
	
	
}
