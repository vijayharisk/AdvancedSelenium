package Listenerimplementation;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Generic_Utility.JavaUtility_Class;
import Shoppersstack.baseclass.BaseClass;

public class ListenerImp  implements ITestListener,ISuiteListener {
	
	
	public ExtentReports report;
	public static ExtentTest test;
	
	// before writing the method name yourself press control+tab to  get all the options.

	@Override
	public void onStart(ISuite suite)//we are not passing , but receiving and stored in suite variable
	{
		Reporter.log(suite.getName()+" has started",true);// default suite name is taken
		JavaUtility_Class javautility = new JavaUtility_Class();
		String time = javautility.getDateAndTime();
		
		report = new ExtentReports("./AdvancedReports/"+suite.getName()+time+".html");
	}
	
	@Override
	public void onTestStart(ITestResult result)
	{
		Reporter.log(result.getName()+"test has started",true);
		test = report.startTest(result.getName());// result is suite level (so suite name)
		test.log(LogStatus.INFO,"Test has started");
	
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		String imgpath ="./FailedScreenshots/"+ result.getName()+".png";
		TakesScreenshot ts =(TakesScreenshot) BaseClass.sdriver;
		File ss =ts.getScreenshotAs(OutputType.FILE);//(stored in the script itself but not in the project 
		File path = new File(imgpath);// here we have given the path where the screenshoot to be stored
		
		try {
			FileHandler.copy(ss, path);// copying the screenshot from the script to failedscreenshot folder
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		test.log(LogStatus.FAIL, "TestScript_failed and screenshot is attached");
		test.log(LogStatus.FAIL, test.addScreenCapture("."+imgpath));// we are capturing from the script itself
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		Reporter.log(result.getName()+"test has skipped",true);
		test.log(LogStatus.SKIP,"test is skipped");
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log(result.getName()+"test is successfully executed",true);
		test.log(LogStatus.PASS,"test is PASSED");
	}
	
	@Override 
	public void onFinish(ISuite suite) {
		Reporter.log(suite.getName()+"Has Finished",true);
		test.log(LogStatus.INFO,"test HAS FINISHED");
		report.endTest(test);
		report.flush();
	}
			
}

