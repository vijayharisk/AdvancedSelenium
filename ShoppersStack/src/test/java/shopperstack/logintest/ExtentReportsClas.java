package shopperstack.logintest;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Shoppersstack.baseclass.BaseClass;

public class ExtentReportsClas extends BaseClass {
	
	@Test
	public void demoTest()
	{
		ExtentReports report = new ExtentReports("./AdvancedReports/DemoTest.html");// path to store the result
		ExtentTest test = report.startTest("demoTest");// methodname of this script
		test.log(LogStatus.INFO, "home page not displayed");		
		
		report.endTest(test);
		report.flush();
	}
}
