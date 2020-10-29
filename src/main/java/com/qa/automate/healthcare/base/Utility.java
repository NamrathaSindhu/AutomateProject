package com.qa.automate.healthcare.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Reporter;

import com.google.common.io.Files;
import com.sun.media.sound.InvalidFormatException;

 public class Utility {

	//public static WebDriver driver;

	// get photo
	public static String getPhoto(WebDriver driver,String folder) {
		
			Date date = new Date();
			String dateformatted = date.toString().replaceAll(":", "_");
			String value =folder+"/"+dateformatted+".png";
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest=new File(value);
			Files.copy(src, dest);
		} catch (Exception e) {
			Reporter.log(e.getMessage(), true);
			e.printStackTrace();

		}
		return value;
	}

	// get property

	public static String getProperty(String path,String key) {
		String value="";
		try {
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			value=p.getProperty(key);
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			e.printStackTrace();
		}
		return value;
	}
	// write to xl

	public static String readFromXl( String path,String sheet, int row, int col) {
		String data = "";
		try {
			Workbook book = WorkbookFactory.create(new FileInputStream(path));
			data = book.getSheet(sheet).getRow(row).getCell(col).toString();
		} catch (Exception e) {
			Reporter.log(e.getMessage());
			e.printStackTrace();
		}
		return data;
	}

	// write to xl
//	public static void writeToXl(String path, int passcount, int failcount) {
//		try {
//			Workbook book = WorkbookFactory.create(new FileInputStream(path));
//			book.getSheet("Sheet1").getRow(1).getCell(1).setCellValue(passcount);
//			book.getSheet("Sheet1").getRow(1).getCell(2).setCellValue(failcount);
//			book.write(new FileOutputStream(path));
//			book.close();
//		} catch (Exception e) {
//			Reporter.log(e.getMessage());
//			e.printStackTrace();
//		}
//
//	}
	public static WebDriver openBrowser(String ip, String browser) {

		WebDriver driver;
		if (ip.equals("localhost")) {
			if (browser.equals("chrome")) {
				driver = new ChromeDriver();
			} else {
				driver = new FirefoxDriver();
			}
		} else {
			try {
				URL remoteaddress = new URL("http://"+ip+":4444/wd/hub");
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setBrowserName(browser);
				driver = new RemoteWebDriver(remoteaddress, cap);
			} catch (Exception e) {
				Reporter.log(e.getMessage());
				e.printStackTrace();
				driver=new ChromeDriver();
			}
			
		}
		return driver;
	}
public static String TESTDATAPATH="C:\\Users\\Punith\\Desktop\\FreshAutomation\\Automate\\resources\\email.xlsx";
static Workbook book;
static Sheet sheet;
public static Object[][] gettestdata(String sheetname)
{
	FileInputStream file=null;
	try {
		file=new FileInputStream(TESTDATAPATH);
	}catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	try {
		book=WorkbookFactory.create(file);
	}catch(InvalidFormatException e) {
		e.printStackTrace();
		
	}catch(IOException e)
	{
		e.printStackTrace();
	}
	
	sheet=book.getSheet(sheetname);
	Object[][] data =new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	for(int i=0;i<sheet.getLastRowNum();i++)
	{
		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
		{
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
		}
	}
	return data;
}

	
}
