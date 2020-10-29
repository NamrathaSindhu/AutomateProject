package com.qa.automate.healthcare.base;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import com.qa.automate.healthcare.base.IAutoConstant;
import com.qa.automate.healthcare.base.Utility;

public class Results extends ExtentReportListener implements ITestListener,IAutoConstant {

	 static int passcount=0,failcount=0;
	@Override
	public void onTestSuccess(ITestResult result) {
		String name=result.getName();
		Reporter.log("Test:"+ name + " is pass");
		passcount++;
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		String name=result.getName();
		Reporter.log("Test:"+ name + " is fail");
		failcount++;
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		String name=result.getName();
		Reporter.log("Test:"+ name + " is skipped");
		
	}
	@Override
	public void onFinish(ITestContext context) {
		Reporter.log("Tests passed:" + passcount ,true);
		Reporter.log("Tests failed:" + failcount ,true);
		//Utility.writeToXl(RESULT_PATH, passcount, failcount);
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
