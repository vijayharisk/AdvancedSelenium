package shopperstack.logintest;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import fileutility.ReadExcelData;

public class DataProviderTest2 {
	
	@DataProvider
	public Object[][] dataSupplier()
	{
		ReadExcelData read=new ReadExcelData();
		Object[][] data=read.getFromExcel("exceldatafordataproviders","Sheet1");
		return data;
	}

	   @Test(dataProvider="dataSupplier")
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
