package testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import vtiger.crm.objectRepositoryUtility.CreateOrganisationPage;
import vtiger.crm.objectRepositoryUtility.HomePage;
import vtiger.crm.objectRepositoryUtility.OrganisationInfoPage;

public class CreateSTContactTest extends BaseClass{
	
	@Test
	public void CreateContactTest() throws Throwable {
		
		FileInputStream fise = new FileInputStream("./testData/testScriptData.xlsx");
		
		String OrganizationNames = elib.getTestDataFromExcelFile("Organisation", 1, 2);
		String PhoneNumber = elib.getTestDataFromExcelFile("Organisation", 1, 3)+ jlib.getRandomNumber();;
		String EmailId = elib.getTestDataFromExcelFile("Organisation", 1, 4)+ jlib.getRandomNumber();;
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
		
	}
	//step 3: Navigate to contact module
	
	

}
