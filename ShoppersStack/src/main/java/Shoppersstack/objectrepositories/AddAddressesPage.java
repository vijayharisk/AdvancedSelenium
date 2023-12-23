package Shoppersstack.objectrepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddAddressesPage extends BasePage {
	
	public AddAddressesPage(WebDriver driver)
	{
		super(driver);
	}
	
	@FindBy(id="Name")
	private WebElement namefield;
	
	public WebElement getNamefield() {
		return namefield;
	}

	@FindBy(id="House/Office Info")
	private WebElement house_officeinfofield;
	
	public WebElement getHouse_officeinfofield() {
		return house_officeinfofield;
	}
	
	@FindBy(id="Street Info")
	private WebElement streetinfofield;
	
	public WebElement getStreetinfofield() {
		return streetinfofield;
	}
	
	@FindBy(id="Landmark")
	private WebElement landmarkfield;
	
	public WebElement getLandmarkfield() {
		return landmarkfield;
	}
	
	@FindBy(id="Country")
	private WebElement countrydropdown;
	
	public WebElement getCountrydropdown() {
		return countrydropdown;
	}	
		

	@FindBy(id="State")
	private WebElement statefield;

	public WebElement getStatefield() {
		return statefield;
	}
	
	
	@FindBy(id="City")
	private WebElement cityfield;
	
	public WebElement getCityField() {
		return cityfield;
	}
	
	@FindBy(id="Pincode")
	private WebElement pincodefield;
	
	public WebElement getPincodefield() {
		return pincodefield;
	}

		
	@FindBy(id="Phone Number")
	private WebElement phonenumberfield;

	public WebElement getPhonenumberfield() {
		return phonenumberfield;
	}


	@FindBy(id="addAddress")
	private WebElement addAddresssubmitbutton;

	public WebElement getAddAddresssubmitbutton() {
		return addAddresssubmitbutton;
	}
	
	@FindBy(xpath = "//a[@id='home']/img")
	private WebElement homeLogo;

	public WebElement getHomeLogo() {
		return homeLogo;
	}
	
}
