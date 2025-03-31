package vtiger.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganisationPage {
	
	WebDriver driver;
	 public  CreateOrganisationPage(WebDriver driver)
	 {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
	 }
	 
	  @FindBy(xpath="//img[@title='Create Organization...']")
	    private WebElement createNewOrgBtn;
	  
	  @FindBy(name="accountname")
		 private WebElement orgNameEdtBtn;
	  
	  @FindBy(id="phone")
	   private WebElement phoneTxtBox;
	  
	  @FindBy(id="email1")
	   private WebElement emailTxtBox;
	  
	  @FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement SaveBtn;
	  
	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

	public WebElement getOrgNameEdtBtn() {
		return orgNameEdtBtn;
	}

	public WebElement getPhoneTxtBox() {
		return phoneTxtBox;
	}

	public WebElement getEmailTxtBox() {
		return emailTxtBox;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	  
		//email1

}
