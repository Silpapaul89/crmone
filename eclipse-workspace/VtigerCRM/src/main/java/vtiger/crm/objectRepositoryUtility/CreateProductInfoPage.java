package vtiger.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerCrm.generic.WebDriverUtility.WebDriverUtility;

public class CreateProductInfoPage {
	
	WebDriver driver;
	WebDriverUtility wb = new WebDriverUtility();

	public CreateProductInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement headericon;

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getHeadericon() {
		return headericon;
	}
	

	

}
