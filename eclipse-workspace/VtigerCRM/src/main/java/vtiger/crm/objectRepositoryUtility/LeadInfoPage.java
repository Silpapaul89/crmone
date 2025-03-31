package vtiger.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadInfoPage {

	WebDriver driver;

	public LeadInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

}
