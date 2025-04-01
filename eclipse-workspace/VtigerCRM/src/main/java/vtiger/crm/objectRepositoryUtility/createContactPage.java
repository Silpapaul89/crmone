package vtiger.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerCrm.generic.WebDriverUtility.WebDriverUtility;

public class createContactPage {

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	WebDriver driver;
	WebDriverUtility wb = new WebDriverUtility();

	public createContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstname")
	private WebElement firstNameEdtBtn;

	@FindBy(name = "lastname")
	private WebElement LastNameEdtBtn;

	@FindBy(name = "phone")
	private WebElement phoneNumberEdtBtn;

	@FindBy(name = "email")
	private WebElement emailIdEdtBtn;

	@FindBy(xpath = "(//img[@src='themes/softed/images/select.gif'])[1]")
	private WebElement selectOrgName;

	@FindBy(name = "search_text")
	private WebElement searchTxtBox;

	@FindBy(name = "search")
	private WebElement searchnowTxtBox;

	@FindBy(id = "1")
	private WebElement OrgNamelnkIcon;

	@FindBy(xpath = "(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;

	public WebElement getFirstNameEdtBtn() {
		return firstNameEdtBtn;
	}

	public WebElement getLastNameEdtBtn() {
		return LastNameEdtBtn;
	}

	public WebElement getPhoneNumberEdtBtn() {
		return phoneNumberEdtBtn;
	}

	public WebElement getEmailIdEdtBtn() {
		return emailIdEdtBtn;
	}

	public WebElement getSelectOrgName() {
		return selectOrgName;
	}

	public WebElement getSearchTxtBox() {
		return searchTxtBox;
	}

	public WebElement getSearchnowTxtBox() {
		return searchnowTxtBox;
	}

	public WebElement getOrgNamelnkIcon() {
		return OrgNamelnkIcon;
	}

	public void createlastname(String LastName) {
		LastNameEdtBtn.sendKeys(LastName);
		SaveBtn.click();

	}

	@FindBy(name = "support_start_date")
	private WebElement StartDateBtn;

	@FindBy(name = "support_end_date")
	private WebElement EndDateBtn;

	public WebElement getStartDateBtn() {
		return StartDateBtn;
	}

	public WebElement getEndDateBtn() {
		return EndDateBtn;
	}

	public void createstartdateandenddate(String startdate, String enddate) {
		StartDateBtn.clear();
		StartDateBtn.sendKeys(startdate);
		EndDateBtn.clear();
		StartDateBtn.sendKeys(enddate);
		SaveBtn.click();
	}

	public void Createcontact(String LastName, String startdate, String enddate) {
		LastNameEdtBtn.sendKeys(LastName);
		StartDateBtn.clear();
		StartDateBtn.sendKeys(startdate);
		EndDateBtn.clear();
		EndDateBtn.sendKeys(enddate);
		SaveBtn.click();
	}
}
