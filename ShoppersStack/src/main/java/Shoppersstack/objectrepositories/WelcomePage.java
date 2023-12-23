package Shoppersstack.objectrepositories;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactory;
public class WelcomePage extends BasePage {

	public WelcomePage(WebDriver driver) {
		super(driver);
		//PageFactory.initElements(driver, this);	
	}
	
	@FindBy(xpath = "//button[@id='loginBtn']")
	private WebElement loginButton;// name given by the user

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	
	

}
