package vtigerCrm.generic.WebDriverUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
	
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	public void minimiseWidow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	
	public void waitForElementToPresent(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeSelected(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(element));
	}
	
	public void switchToNewBrowserOnURL(WebDriver driver, String url)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String windowid = it.next();
			driver.switchTo().window(windowid);
			 String windowurl = driver.getCurrentUrl();
			 if(windowurl.contains(url))
			 {
				 break;
			 }
		}
		
	}
	
	public void switchToBrowserOnTitle(WebDriver driver, String title)
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while(it.hasNext())
		{
			String windowid = it.next();
			driver.switchTo().window(windowid);
			String windowTitle = driver.getTitle();
			if(windowTitle.contains(title))
			{
				break;
			}
		}
	}
	
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	
	public void switchToFrame(WebDriver driver, String NameId)
	{
		driver.switchTo().frame(NameId);
	}

	public void switchToFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}	
	
	public void switchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToAlertAndEnterText(WebDriver driver, String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	
	public String switchToAlertAndGetText(WebDriver driver)
	{
		String data = driver.switchTo().alert().getText();
		return data;
	}
	
	public void selectFromDropDownIndex(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public void selectFromDropDownText(WebElement element, String text)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	
	public void selectFromDropDownValue(WebElement element, String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	public void mouseMovementOnElement(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
		
	}
	
	public void DragAndDrop(WebDriver driver, WebElement SrcEle, WebElement DestEle)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(SrcEle, DestEle);
	}
	
	
}


