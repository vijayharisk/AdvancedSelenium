package GenericUtility;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebDriver_Utilities {
	
	public void clickOnElement(WebElement element)
	{
		element.click();	
	}
	
	public String getPageTitle(WebDriver driver)
	{
		String title= driver.getTitle();
		return title;
	}
	
	public String getCurrentUrl(WebDriver driver)
	{
		String url = driver.getCurrentUrl();
		return url;
	}
	
	
	public void selectDropdownByIndex(WebElement dropdown , int index)
	{
		Select sel = new Select(dropdown);
		sel.selectByIndex(index);
	}
	
	
	public void selectDropdownByValue(WebElement dropdown , String string)
	{
		Select sel = new Select(dropdown);
		sel.selectByValue(string);	
	}
	
	public void selectDropdownByVisibleText(WebElement dropdown , String visibleText )
	{
		Select sel = new Select(dropdown);
		sel.selectByVisibleText(visibleText);
	}
	
	public void deselectByIndex(WebElement dropdown, int index)
	{
		Select sel = new Select(dropdown);
		sel.deselectByIndex(index);
	}
	
	public void deselectByValue(WebElement dropdown, String value)
	{
		Select sel = new Select(dropdown);
		sel.deselectByValue(value);
	}
	
	public void deselectByVisibleText(WebElement dropdown, String visibleText)
	{
		Select sel = new Select(dropdown);
		sel.deselectByValue(visibleText);
	}
	
	public String getTextFromElement(WebElement element)
	{
		String elementText = element.getText();
		return elementText;
	}
	
	
	public void sendText(WebElement element , String stringToBeTyped)
	{
		element.sendKeys(stringToBeTyped);
	}
	
	
	public void switchToAlertAndAccept(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void switchToAlertAndDismisst(WebDriver driver)
	{
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	
	public void switchToAlertAndSendText(WebDriver driver,String text)
	{
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(text);
	}
	
	public void dragAndDrop(WebDriver driver , WebElement element1 , WebElement element2)
	{
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element1, element2).perform();
	}

	
	public void moveToElement(WebDriver driver, WebElement element)
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();;
	}
	
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();		
	}
	
	public void doubleClickOnElement(WebDriver driver,WebElement element)
	{

		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	public void scrollToElement(WebDriver driver,WebElement element )
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",element);
	}
	
	public void switchToFrameByIndex(WebDriver driver , int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrameById(WebDriver driver , String attributeName)
	{
		driver.switchTo().frame(attributeName);
	}
	
	
}	

