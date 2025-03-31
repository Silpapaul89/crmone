package vtiger.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorPage {

	WebDriver driver;

	public VendorPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Create Vendor...
	// //img[@title='Create Vendor...']
	
	@FindBy(name="Vendors")
	private WebElement vendorLnk;
	
	public WebElement getVendorLnk() {
		return vendorLnk;
	}

	@FindBy(xpath ="(//img[@alt='Create Vendor...'])")
	private WebElement createVendorLnk;
	
	// //a[text()='More']
	@FindBy(xpath ="//a[text()='More']")
	private WebElement moreLnk;

	public WebElement getMoreLnk() {
		return moreLnk;
	}

	public WebElement getCreateVendorLnk() {
		return createVendorLnk;
	}
}
