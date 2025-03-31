package vtiger.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage {

	WebDriver driver;

	public LeadPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Lead...']")
	private WebElement leadlink;
	
	@FindBy(name="lastname")
	private WebElement LastName;
	
	@FindBy(name="company")
	private WebElement CompanyName;
	
	@FindBy(name="phone")
	private WebElement phoneNumber;
	
	@FindBy(name="email")
	private WebElement emailId;
	
	public WebElement getLastName() {
		return LastName;
	}

	public WebElement getCompanyName() {
		return CompanyName;
	}

	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getEmailId() {
		return emailId;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(name="button")
	private WebElement saveBtn;
	

	@FindBy(name = "search_text")
	private WebElement searchTxtBox;

	public WebElement getSearchTxtBox() {
		return searchTxtBox;
	}

	public WebElement getSearchnowTxtBox() {
		return searchnowTxtBox;
	}

	@FindBy(name = "search")
	private WebElement searchnowTxtBox;

	public WebElement getLeadlink() {
		return leadlink;
	}

}
