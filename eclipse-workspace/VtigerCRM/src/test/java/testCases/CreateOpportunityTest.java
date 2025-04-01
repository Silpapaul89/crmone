package testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import BaseTest.BaseClass;

import org.testng.AssertJUnit;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import vtiger.crm.objectRepositoryUtility.CreateOpportunitiesPage;
import vtiger.crm.objectRepositoryUtility.CreateOrganisationPage;
import vtiger.crm.objectRepositoryUtility.HomePage;
import vtiger.crm.objectRepositoryUtility.OrganisationInfoPage;
import vtigerCrm.generic.WebDriverUtility.WebDriverUtility;

public class CreateOpportunityTest extends BaseClass {

	@Test(groups = "regressionTest")
	public void CreateOpportunity() throws Throwable {

		// read testScript data from Excel file
		FileInputStream fise = new FileInputStream("./testData/testScriptData.xlsx");

		String OpportunityName = elib.getTestDataFromExcelFile("Opportunities", 1, 2);
		String OrganizationName = elib.getTestDataFromExcelFile("Opportunities", 1, 3);
		String OrganizationNames = elib.getTestDataFromExcelFile("Organisation", 1, 2)+jlib.getRandomNumber();
		String PhoneNumber = elib.getTestDataFromExcelFile("Organisation", 1, 3);
		String EmailId = elib.getTestDataFromExcelFile("Organisation", 1, 4);
		//Step:2 navigate to organization module
		HomePage hp = new HomePage(driver);
		hp.getOrganizationsLink().click();
		
		CreateOrganisationPage copp= new CreateOrganisationPage(driver);
		copp.getCreateNewOrgBtn().click();
		copp.getOrgNameEdtBtn().sendKeys(OrganizationNames);
		Thread.sleep(2000);
		copp.getPhoneTxtBox().sendKeys(PhoneNumber);
		copp.getEmailTxtBox().sendKeys(EmailId);
		Thread.sleep(2000);
		copp.getSaveBtn().click();
		
		OrganisationInfoPage oipp= new OrganisationInfoPage(driver);
		String actOrgName = oipp.getOrganizationInfoicon().getText();
		AssertJUnit.assertEquals(true, actOrgName.contains(OrganizationNames));
		// step 3 :navigate to opportunity module

		hp.getOpportunitiesLink().click();
		// driver.findElement(By.linkText("Opportunities")).click();
		CreateOpportunitiesPage cop = new CreateOpportunitiesPage(driver);
		cop.getCreateOppotunityIcon().click();
		// driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click();
		cop.getOppotunityNameTxtBox().sendKeys(OpportunityName);
		// driver.findElement(By.name("potentialname")).sendKeys(OpportunityName);
		cop.getSelectOrganisationIcon().click();
		// driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();

		WebDriverUtility wlib = new WebDriverUtility();
		wlib.switchToNewBrowserOnURL(driver, "module=Accounts&action=Popup");
		cop.getSearchTxtBox().sendKeys(OrganizationName);
	
		// driver.findElement(By.name("search_text")).sendKeys(OrganizationName);
		cop.getSearchNowTxtBox().click();
		// driver.findElement(By.name("search")).click();
		Thread.sleep(2000);
		cop.getSearchTxtBox().sendKeys(OrganizationName);
		// driver.findElement(By.name("search_text")).sendKeys(OrganizationName);
		cop.getOrganisationNameIcon().click();
		// driver.findElement(By.id("1")).click();
		Thread.sleep(2000);
		wlib.switchToNewBrowserOnURL(driver, "module=Potentials&action");

		Thread.sleep(5000);
		// http://49.249.28.218:8888/index.php?module=Potentials&action=EditView&return_action=DetailView&parenttab=Sales
		cop.getSavebtn();
		// driver.findElement(By.name("button"));

	}
}
