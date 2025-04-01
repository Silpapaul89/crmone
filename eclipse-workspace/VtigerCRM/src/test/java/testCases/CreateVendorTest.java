package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import BaseTest.BaseClass;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import vtiger.crm.objectRepositoryUtility.CreateProductInfoPage;
import vtiger.crm.objectRepositoryUtility.CreateProductPage;
import vtiger.crm.objectRepositoryUtility.CreatingNewVendorPage;
import vtiger.crm.objectRepositoryUtility.HomePage;
import vtiger.crm.objectRepositoryUtility.LoginPage;
import vtiger.crm.objectRepositoryUtility.VendorInfoPage;
import vtiger.crm.objectRepositoryUtility.VendorPage;
import vtigerCrm.generic.WebDriverUtility.WebDriverUtility;

public class CreateVendorTest extends BaseClass {

	@Test

	public void CreateVendor() throws Throwable {

		// read testScript data from Excel file
		FileInputStream fise = new FileInputStream("./testData/testScriptData.xlsx");

		String VendorName = elib.getTestDataFromExcelFile("Vendor", 1, 2);
		String Email = elib.getTestDataFromExcelFile("Vendor", 1, 3);
		String Phone = elib.getTestDataFromExcelFile("Vendor", 1, 4);
		String ProductName = elib.getTestDataFromExcelFile("Product", 1, 2);
		String VendorNames = elib.getTestDataFromExcelFile("Product", 1, 3);

		Thread.sleep(2000);
		HomePage hp = new HomePage(driver);
		hp.getMoreLink().click();
		// step 2: navigate to vendor module
		VendorPage vp = new VendorPage(driver);
		Thread.sleep(2000);

		// driver.findElement(By.name("Vendors")).click();
		vp.getVendorLnk().click();
		vp.getCreateVendorLnk().click();

		// driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		CreatingNewVendorPage cnp = new CreatingNewVendorPage(driver);
		cnp.getVendornameTxtBox().sendKeys(VendorName);
		cnp.getEmailTxtBox().sendKeys(Email);
		cnp.getPhoneTxtBox().sendKeys(Phone);
		cnp.getSaveBtn().click();

		VendorInfoPage vip = new VendorInfoPage(driver);
		String headerInfo = vip.getHeaderMsg().getText();

		AssertJUnit.assertEquals(true, headerInfo.contains(VendorName));

		hp.getProductsLink().click();
		// driver.findElement(By.xpath("(//a[text()='Products'])[1]")).click();
		CreateProductPage cpp = new CreateProductPage(driver);
		cpp.getCreateProductBtn().click();
		// driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		cpp.getProductNameEdtBtn().sendKeys(ProductName);
		// driver.findElement(By.name("productname")).sendKeys(ProductName);

		WebDriverUtility wlib = new WebDriverUtility();

		cpp.getSelectVendorIcon().click();
		// driver.findElement(By.xpath("//img[@title='Select']")).click();
		wlib.switchToNewBrowserOnURL(driver, "module=Vendors&action=Popup");
		// driver.findElement(By.xpath("//img[@title='Select']")).click();
		System.out.println(VendorNames);
		cpp.getSearchTxtBtn().sendKeys(VendorNames);
		// driver.findElement(By.id("search_txt")).sendKeys(VendorNames);
		cpp.getSearchnowTxtBtn().click();
		// driver.findElement(By.name("search")).click();
		Thread.sleep(2000);
		cpp.getVendorlnkbtn().click();
		// driver.findElement(By.id("1")).click();
		wlib.switchToNewBrowserOnURL(driver, "module=Products&actio");

		CreateProductInfoPage cpi = new CreateProductInfoPage(driver);
		cpi.getSaveBtn().click();
		// driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		cpi.getHeadericon();
		// driver.findElement(By.xpath("//span[@class='lvtHeaderText']"));

		CreateProductInfoPage oip = new CreateProductInfoPage(driver);
		String actProductName = oip.getHeadericon().getText();
		AssertJUnit.assertEquals(true, actProductName.contains(ProductName));

	}
}
