package Shoppersstack.baseclass;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import Listenerimplementation.ListenerImp;

//import com.beust.jcommander.Parameter;
//import com.beust.jcommander.Parameters;

import Shoppersstack.objectrepositories.LoginPage;
import Shoppersstack.objectrepositories.HomePage;
import Shoppersstack.objectrepositories.WelcomePage;
import fileutility.ReadProperties;

public class BaseClass extends ListenerImp {
	
	public WebDriver driver;
	public static WebDriver sdriver;
	public WebDriverWait wait;
	public int count=1;
	
	
	@BeforeClass(alwaysRun = true)
	public void launchBrowser() 
	{	
			driver = new EdgeDriver();
			sdriver=driver;
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
			
	}
	
	@BeforeMethod(alwaysRun = true)
	public void login() throws IOException
	{	
		ReadProperties properties = new ReadProperties();
		String url = properties.getDataFromProperty("url");
		driver.get(url);
		Reporter.log("i am being called for "+count+" time" , true);
		count=count+1;
		WelcomePage wel = new WelcomePage(driver);
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		wait = new WebDriverWait(driver,Duration.ofSeconds(120));
		wait.until(ExpectedConditions.elementToBeClickable(wel.getLoginButton())).click();
	
		LoginPage log = new LoginPage(driver);
		WebElement user=log.getEmailTextField();
		ReadProperties property = new ReadProperties(); 
		String username=property.getDataFromProperty("username");
		user.sendKeys(username);
		WebElement password=log.getPasswordTextField();
		String pass=property.getDataFromProperty("password");
		password.sendKeys(pass);
		log.getLoginButton().click();
	}
	
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
//		try {
//			//Thread.sleep(6000);
//		} catch (InterruptedException e) {
//			
//			e.printStackTrace();
//		}
	}
	
	@AfterMethod(alwaysRun = true)
	public void logOut()
	{
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HomePage home = new HomePage(driver);
		wait.until(ExpectedConditions.elementToBeClickable(home.getSettingsButton())).click();	
		wait.until(ExpectedConditions.elementToBeClickable(home.getLogout_Button())).click();
		
	}
}
