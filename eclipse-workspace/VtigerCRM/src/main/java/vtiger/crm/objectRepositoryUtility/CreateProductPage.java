package vtiger.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vtigerCrm.generic.WebDriverUtility.WebDriverUtility;

public class CreateProductPage {

	public WebElement getCreateProductBtn() {
		return createProductBtn;
	}

	public WebElement getProductNameEdtBtn() {
		return productNameEdtBtn;
	}

	public WebElement getSelectVendorIcon() {
		return selectVendorIcon;
	}


	WebDriver driver;
	WebDriverUtility wb = new WebDriverUtility();

	public CreateProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createProductBtn;
	
	@FindBy(name = "productname")
	private WebElement productNameEdtBtn;
	
	@FindBy(xpath = "//img[@alt='Select']")
	private WebElement selectVendorIcon;
	
	@FindBy(name = "search_text")
	private WebElement searchTxtBtn;
	
	@FindBy(name = "search")
	private WebElement searchnowTxtBtn;
	
	@FindBy(xpath = "//a[@id='1']")
	private WebElement Vendorlnkbtn;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getSearchTxtBtn() {
		return searchTxtBtn;
	}

	public WebElement getSearchnowTxtBtn() {
		return searchnowTxtBtn;
	}

	public WebElement getVendorlnkbtn() {
		return Vendorlnkbtn;
	}
	
	//id="1"
	
	//search_text
	//searchTxtBtn

}

