package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import vtiger.crm.objectRepositoryUtility.EmailPage;
import vtiger.crm.objectRepositoryUtility.HomePage;
import vtiger.crm.objectRepositoryUtility.LeadInfoPage;
import vtiger.crm.objectRepositoryUtility.LeadPage;
import vtiger.crm.objectRepositoryUtility.LoginPage;
import vtigerCrm.generic.WebDriverUtility.WebDriverUtility;

public class CreateLeadTest extends BaseClass{


	@Test
public void CreateLead() throws Throwable {
	
	//read testScript data from Excel file
	FileInputStream fise = new FileInputStream("./testData/testScriptData.xlsx");
	
	String LastName=elib.getTestDataFromExcelFile("email", 1, 3);
	String Company=elib.getTestDataFromExcelFile("email", 1, 4);
	String Phone=elib.getTestDataFromExcelFile("email", 1, 5);
	String Email=elib.getTestDataFromExcelFile("email", 1, 6);
	String Subject=elib.getTestDataFromExcelFile("email", 1, 7);
	
	//Workbook wb =WorkbookFactory.create(fis1);
	//Sheet sh =wb.getSheet("email");
	//Row row =sh.getRow(1);
	
	//String LastName= row.getCell(3).toString();
	//String Company = row.getCell(4).toString();
	//String Phone = row.getCell(5).toString();
	//String Email = row.getCell(6).toString();
	//String Subject = row.getCell(7).toString();


	//step 1: login to app
	//driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	//driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	//driver.findElement(By.id("submitButton")).click();
	
	// step 2: navigate to lead module
	HomePage hp=new HomePage(driver);
	hp.getLeadLink().click();
	//driver.findElement(By.linkText("Leads")).click();
	LeadPage leap= new LeadPage(driver);
	leap.getLeadlink().click();
	//driver.findElement(By.xpath("//img[@title='Create Lead...']")).click();
	leap.getLastName().sendKeys(LastName);
	//driver.findElement(By.name("lastname")).sendKeys(LastName);
	leap.getCompanyName().sendKeys(Company);
	//driver.findElement(By.name("company")).sendKeys(Company);
	leap.getPhoneNumber().sendKeys(Phone);
	//driver.findElement(By.id("phone")).sendKeys(Phone);
	leap.getEmailId().sendKeys(Email);
	//driver.findElement(By.id("email")).sendKeys(Email);
	Thread.sleep(1000);
	leap.getSaveBtn().click();
	Thread.sleep(2000);
	//driver.findElement(By.name("button")).click();
	
	// step 3:  navigate to email module
	
	hp.getEmailLink().click();
	//driver.findElement(By.linkText("Email")).click();
	EmailPage email= new EmailPage(driver);
	email.getComposelink().click();
	//Thread.sleep(5000);
	//driver.findElement(By.linkText("Compose")).click();
	WebDriverUtility wlib= new WebDriverUtility();
	System.out.println("111111111111");

	/*Set<String> set = driver.getWindowHandles();
	System.out.println("size:"+set.size());
	for(String handle:set) {
		driver.switchTo().window(handle);
		 String windowurl = driver.getCurrentUrl();
		 System.out.println("driver:"+driver.getTitle());
		 if(windowurl.contains("http://49.249.28.218:8888/index.php?module=Emails&action=EmailsAjax&file=EditView"))
		 {
			 break;
		 }
	}*/
	wlib.switchToNewBrowserOnURL(driver,"http://49.249.28.218:8888/index.php?module=Emails&action=EmailsAjax&file=EditView");
	//Set<String> set = driver.getWindowHandles();
	//System.out.println("size:"+set.size());
	//for(String handle:set) {
		//driver.switchTo().window(handle);
		 //String windowurl = driver.getCurrentUrl();
		 //System.out.println("driver:"+driver.getTitle());
		 //if(windowurl.contains("http://49.249.28.218:8888/index.php?module=Emails&action=EmailsAjax&file=EditView"))
		 //{
			 //break;
		// }
	//}
	//module=Emails&action
	email.getSelectleadIcon();

	//WebElement ele= driver.findElement(By.xpath("//select[@name='parent_type']"));
	Thread.sleep(5000);
	//wlib.switchToNewBrowserOnURL(driver, "module=Emails&action");
	wlib.selectFromDropDownText(email.getSelectleadIcon(),"Leads");
	Thread.sleep(2000);
	
	email.getSelectplusIcon().click();

	wlib.switchToNewBrowserOnURL(driver, "Leads&action");
	email.getSearchBox().sendKeys(LastName);
	email.getSearchNowBox().click();
	Thread.sleep(2000);

    //driver.findElement(By.id("search_txt")).sendKeys(LastName);
	email.getDynamicLink().click();
	Thread.sleep(2000);
	wlib.switchToNewBrowserOnURL(driver, "module=Emails&action=EmailsAjax&file=EditView");
	email.getSubjectTextBox().sendKeys(Subject);

	email.getSaveTextBox().click();
	
	Thread.sleep(2000);
	
	wlib.switchToNewBrowserOnURL(driver, "http://49.249.28.218:8888/index.php?module=Home&action=index&parenttab=My%20Home%20Page");

	LeadInfoPage lip= new LeadInfoPage(driver);
	WebElement actualMsg = lip.getHeaderMsg();
}
}
	
	



