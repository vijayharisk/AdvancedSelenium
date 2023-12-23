package Shoppersstack.objectrepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAddressPage extends BasePage {
	
	public MyAddressPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//button[contains(@class,'MuiButtonBase-root MuiBu')]")
	private WebElement addaddressbutton;

	public WebElement getAddaddressbutton() {
		return addaddressbutton;
	}
	
}
