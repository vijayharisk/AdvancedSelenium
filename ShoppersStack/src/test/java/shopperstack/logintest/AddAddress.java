package shopperstack.logintest;

import org.testng.Reporter;
import org.testng.annotations.Test;


public class AddAddress {


	@Test(groups="smoke")
	public void addressAddition() {
		Reporter.log("address added Successfully", true);
	}
	
	
	
}
