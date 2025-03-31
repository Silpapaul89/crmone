package vtiger.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerCrm.generic.WebDriverUtility.WebDriverUtility;

public class CreatingNewVendorPage {
	
	WebDriver driver;
	WebDriverUtility wb = new WebDriverUtility();

	public CreatingNewVendorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "vendorname")
	private WebElement vendornameTxtBox;
	
	@FindBy(name = "email")
	private WebElement emailTxtBox;
	
	@FindBy(name = "phone")
	private WebElement phoneTxtBox;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getVendornameTxtBox() {
		return vendornameTxtBox;
	}

	public WebElement getEmailTxtBox() {
		return emailTxtBox;
	}

	public WebElement getPhoneTxtBox() {
		return phoneTxtBox;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	

}
