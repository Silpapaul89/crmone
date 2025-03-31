package vtiger.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOpportunitiesPage {
	
	WebDriver driver;
	 public CreateOpportunitiesPage(WebDriver driver)
	 {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
	 }
	 
	 @FindBy(xpath="//img[@alt='Create Opportunity...']")
	 private WebElement createOppotunityIcon;
	 
	 @FindBy(name="potentialname")
	 private WebElement OppotunityNameTxtBox;
	 
	 @FindBy(xpath="(//img[@src='themes/softed/images/select.gif'])[1]")
	 private WebElement selectOrganisationIcon;
	 
	 @FindBy(name="search_text")
	 private WebElement searchTxtBox;
	 
	 @FindBy(name="search")
	 private WebElement searchNowTxtBox;
	 
	 @FindBy(id="1")
	 private WebElement OrganisationNameIcon;
	 
	 @FindBy(name="button")
	 private WebElement savebtn;
	 
	public WebElement getCreateOppotunityIcon() {
		return createOppotunityIcon;
	}

	public WebElement getOppotunityNameTxtBox() {
		return OppotunityNameTxtBox;
	}

	public WebElement getSelectOrganisationIcon() {
		return selectOrganisationIcon;
	}

	public WebElement getSearchTxtBox() {
		return searchTxtBox;
	}

	public WebElement getSearchNowTxtBox() {
		return searchNowTxtBox;
	}

	public WebElement getOrganisationNameIcon() {
		return OrganisationNameIcon;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}
	 
	
	 
	 
	 
	 

}
