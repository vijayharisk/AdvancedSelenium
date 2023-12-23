package AddAddressPackage;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Shoppersstack.baseclass.BaseClass;
import Shoppersstack.objectrepositories.AddAddressesPage;
import Shoppersstack.objectrepositories.HomePage;
import Shoppersstack.objectrepositories.MyAddressPage;
import Shoppersstack.objectrepositories.MyProfilePage;
import fileutility.ReadAddressPropertiesFromExcel;
public class AddAddressClass extends BaseClass{

	@DataProvider
	public Object[][] dataSupplier()
	{
		ReadAddressPropertiesFromExcel read = new ReadAddressPropertiesFromExcel();
		Object[][] datas =read.readAddressProperties("address details","Sheet1");
		return datas;
	}

	@Test(dataProvider = "dataSupplier")
	public void addAddress(String name , String house , String street , String landmark,String pincode  ,String phoneno)
	{
	HomePage home = new HomePage(driver);
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	home.getSettingsButton().click();
	home.getMyProfileOption().click();
	
	MyProfilePage profile = new MyProfilePage(driver);
	profile.getMyAddressesOption().click();
	
	MyAddressPage address = new MyAddressPage(driver);
	address.getAddaddressbutton().click();
	
	
	AddAddressesPage add =new AddAddressesPage(driver);
	add.getNamefield().sendKeys(name);	
	
	add.getHouse_officeinfofield().sendKeys(house);
	
	add.getStreetinfofield().sendKeys(street);
	
	add.getLandmarkfield().sendKeys(landmark);
	
	Select country = new Select(add.getCountrydropdown());
	country.selectByIndex(2);
  
	Select state = new Select(add.getStatefield());
	state.selectByIndex(2);
    test.log(LogStatus.INFO, "state is added");  
	Select city = new Select(add.getCityField());
	city.selectByIndex(3);
	List<WebElement> selected_city = city.getAllSelectedOptions();
	String text=null;
	for(WebElement city1:selected_city) {
		 text=city1.getText();
	}
	Assert.assertEquals(text, "chennai");
	add.getPincodefield().sendKeys(pincode);
	add.getPhonenumberfield().sendKeys(phoneno);
  
	add.getAddAddresssubmitbutton().click();
	
	}
}
