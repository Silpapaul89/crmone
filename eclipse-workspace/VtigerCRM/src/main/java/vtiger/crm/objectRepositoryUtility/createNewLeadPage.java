package vtiger.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerCrm.generic.WebDriverUtility.WebDriverUtility;

public class createNewLeadPage {

	WebDriver driver;
	WebDriverUtility wb = new WebDriverUtility();

	public createNewLeadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstname")
	private WebElement firstNameEdtBtn;

	@FindBy(name = "lastname")
	private WebElement lastNameEdtBtn;

	@FindBy(name = "phone")
	private WebElement phoneNumberEdtBtn;

	@FindBy(name = "company")
	private WebElement companyEdtBtn;
	
	@FindBy(name = "email")
	private WebElement emailEdtBtn;

	public WebElement getEmailEdtBtn() {
		return emailEdtBtn;
	}

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;

	public WebElement getFirstNameEdtBtn() {
		return firstNameEdtBtn;
	}

	public WebElement getLastNameEdtBtn() {
		return lastNameEdtBtn;
	}

	public WebElement getPhoneNumberEdtBtn() {
		return phoneNumberEdtBtn;
	}

	public WebElement getCompanyEdtBtn() {
		return companyEdtBtn;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

}
