package vtiger.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createComposePage {

	WebDriver driver;

	public createComposePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "parent_type")
	private WebElement DropDown;

	public WebElement getDropDown() {
		return DropDown;
	}

	@FindBy(xpath = "//img[@title='Select']")
	private WebElement selectBtn;
	
	@FindBy(name = "subject")
	private WebElement subjectBtn;

	@FindBy(id = "parent_name")
	private WebElement recipientTxtBox;
	
	@FindBy(name = "button")
	private WebElement saveBtn;

	public WebElement getSubjectBtn() {
		return subjectBtn;
	}

	public WebElement getRecipientTxtBox() {
		return recipientTxtBox;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getSelectBtn() {
		return selectBtn;

	}
}
