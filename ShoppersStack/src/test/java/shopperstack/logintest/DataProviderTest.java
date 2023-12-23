package shopperstack.logintest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {

	
	
	@DataProvider
	public Object[][] dataSupplier()
	{
		Object[][] data = new Object[3][2];
		data[0][0]="username1";
		data[0][1]="password1";
		data[1][0]="username2";
		data[1][1]="password2";
		data[2][0]="username3";
		data[2][1]="password3";
		return data;
	}

	
	
	   @Test(dataProvider="dataSupplier",retryAnalyzer=Listenerimplementation.RetryListener.class)
	   public void loginTestt(String username,String password) throws Throwable{
		   WebDriver driver = new EdgeDriver();
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		   driver.get("https://www.shoppersstack.com/");
		   driver.findElement(By.id("loginBtn")).click();
		   driver.findElement(By.id("Email")).sendKeys(username);
		   driver.findElement(By.id("Password")).sendKeys(password);
		   driver.findElement(By.xpath("(//*[name()='svg' and @viewBox='0 0 24 24'])[1]")).click();
		   //driver.findElement(By.xpath("//span[text()='Login']")).click();	   
		   driver.quit();
	   }
}
