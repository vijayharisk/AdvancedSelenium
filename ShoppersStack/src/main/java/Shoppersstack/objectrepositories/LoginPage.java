package Shoppersstack.objectrepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

	// for stale elements
	public LoginPage(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);	
	}
	
	@FindBy(id="Email")
	private WebElement emailTextField;
	
	@FindBy(id="Password")
	private WebElement  passwordTextField;
	
	@FindBy(xpath = "//span[text()='Login']")
	private WebElement loginButton;
	
	@FindBy(id="search")
	private WebElement searchBar;
	
	
	//setter 
	public WebElement getEmailTextField() {
		return emailTextField;
	}
		
	//setter
	public WebElement getPasswordTextField() {
		return passwordTextField;
	}
	
	//setter
	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	
}
