package testCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import BaseTest.BaseClass;

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


	@Test(groups = "regressionTest")
public void CreateLead() throws Throwable {
	
	//read testScript data from Excel file
	FileInputStream fise = new FileInputStream("./testData/testScriptData.xlsx");
	
	String LastName=elib.getTestDataFromExcelFile("email", 1, 3);
	String Company=elib.getTestDataFromExcelFile("email", 1, 4);
	String Phone=elib.getTestDataFromExcelFile("email", 1, 5);
	String Email=elib.getTestDataFromExcelFile("email", 1, 6);
	String Subject=elib.getTestDataFromExcelFile("email", 1, 7);
	
	String lastName = elib.getTestDataFromExcelFile("Contact", 1, 2);
	String email = elib.getTestDataFromExcelFile("Contact", 1, 4);
	String phone = elib.getTestDataFromExcelFile("Contact", 1, 5);
	
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
	EmailPage ep= new EmailPage(driver);
	ep.getComposelink().click();
	//Thread.sleep(5000);
	//driver.findElement(By.linkText("Compose")).click();
	WebDriverUtility wlib= new WebDriverUtility();
	
	wlib.switchToNewBrowserOnURL(driver,"http://49.249.28.218:8888/index.php?module=Emails&action=EmailsAjax&file=EditView");

	ep.getSelectleadIcon();

	//WebElement ele= driver.findElement(By.xpath("//select[@name='parent_type']"));
	Thread.sleep(5000);
	//wlib.switchToNewBrowserOnURL(driver, "module=Emails&action");
	wlib.selectFromDropDownText(ep.getSelectleadIcon(),"Leads");
	Thread.sleep(2000);
	
	ep.getSelectplusIcon().click();

	wlib.switchToNewBrowserOnURL(driver, "Leads&action");
	ep.getSearchBox().sendKeys(LastName);
	ep.getSearchNowBox().click();
	Thread.sleep(2000);

    //driver.findElement(By.id("search_txt")).sendKeys(LastName);
	ep.getDynamicLink().click();
	Thread.sleep(2000);
	wlib.switchToNewBrowserOnURL(driver, "module=Emails&action=EmailsAjax&file=EditView");
	ep.getSubjectTextBox().sendKeys(Subject);

	ep.getSaveTextBox().click();
	
	Thread.sleep(2000);
	
	wlib.switchToNewBrowserOnURL(driver, "http://49.249.28.218:8888/index.php?module=Home&action=index&parenttab=My%20Home%20Page");

	LeadInfoPage lip= new LeadInfoPage(driver);
	WebElement actualMsg = lip.getHeaderMsg();
	
	
}
}
	
	



