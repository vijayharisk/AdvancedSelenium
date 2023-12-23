package shopperstack.logintest;


import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Shoppersstack.baseclass.BaseClass;


@Listeners(Listenerimplementation.ListenerImp.class)
public class DemoTest extends BaseClass {

	@Test//(retryAnalyzer=Listenerimplementation.RetryListener.class)
	public void demoTest() {
		//Assert.fail();
		Reporter.log("executed in Successfully", true);
		String s ="vijay";
	 
	}
}
