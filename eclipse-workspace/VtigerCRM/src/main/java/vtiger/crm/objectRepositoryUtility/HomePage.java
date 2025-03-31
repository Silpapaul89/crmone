package vtiger.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(linkText = "Leads")
	private WebElement leadLink;
	
	@FindBy(linkText = "Email")
	private WebElement EmailLink;

	public WebElement getEmailLink() {
		return EmailLink;
	}

	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;

	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLink;

	@FindBy(linkText = "Organizations")
	private WebElement organizationsLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;

	@FindBy(linkText = "Vendors")
	private WebElement vendorsLink;

	@FindBy(linkText = "Products")
	private WebElement productsLink;

	@FindBy(linkText = "More")
	private WebElement MoreLink;

	@FindBy(linkText = " Sales")
	private WebElement salesLink;

	@FindBy(linkText = "Sales Order")
	private WebElement salesorderLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/Home.PNG']")
	private WebElement homePgImg;

	public WebElement getHomePgImg() {
		return homePgImg;
	}

	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement SignOutLink;

	

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getLeadLink() {
		return leadLink;
	}

	public WebElement getOpportunitiesLink() {
		return opportunitiesLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getSalesLink() {
		return salesLink;
	}

	public WebElement getSalesorderLink() {
		return salesorderLink;
	}

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}

	public WebElement getVendorsLink() {
		return vendorsLink;
	}

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}

	public void navigateTosalesorderPage() {
		Actions act = new Actions(driver);
		act.moveToElement(MoreLink).perform();
		salesorderLink.click();
	}

	public void navigateTovendorsPage() {
		Actions act = new Actions(driver);
		act.moveToElement(MoreLink).perform();
		vendorsLink.click();
	}

	public void navigateTocampaignPage() {
		Actions act = new Actions(driver);
		act.moveToElement(MoreLink).perform();
		campaignsLink.click();
	}

	public void logout() {
		Actions act = new Actions(driver);
		act.click(adminImg).perform();
		SignOutLink.click();
	}

	public WebElement getMoreLink() {
		return MoreLink;
	}

	public WebElement getCreateVendorLnk() {
		// TODO Auto-generated method stub
		return null;
	}

}