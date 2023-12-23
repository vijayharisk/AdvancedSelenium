package Shoppersstack.objectrepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//button[@aria-label='Account settings']")
	private WebElement settings_Button;
	
	public WebElement getSettingsButton()
	{
		return settings_Button;
	}
	
	@FindBy(xpath="//ul[contains(@class,'MuiList-root MuiList-padding MuiMenu-list')]/li[7]")
	private WebElement logout_Button;
	
	public WebElement getLogout_Button()
	{
		return logout_Button;
	}
	
	@FindBy(id="search")
	private WebElement searchBar;
	
	
	public WebElement getSearchBar()
	{
		return searchBar;
	}
	
	@FindBy(xpath="//*[@id=\"searchBtn\"]")
	private WebElement searchGlassButton;
	
	
	public WebElement getSearchGlassButton()
	{
		return searchGlassButton;
	}
	
	@FindBy(xpath="//li[contains(@class,'MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters css-1km1ehz')][1]")
	private WebElement myprofileOption;
	
	public WebElement getMyProfileOption()
	{
		return myprofileOption;
	}
}
