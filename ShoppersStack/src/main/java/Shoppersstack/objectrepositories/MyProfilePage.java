package Shoppersstack.objectrepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyProfilePage extends BasePage {

	public MyProfilePage(WebDriver driver) {
		super(driver);
		
	}


	@FindBy(xpath="//div[text()='My Addresses']")
	private WebElement myaddressoption;

	public WebElement getMyAddressesOption() {
		return myaddressoption;
	}
	
	
	
	
	
	
}
