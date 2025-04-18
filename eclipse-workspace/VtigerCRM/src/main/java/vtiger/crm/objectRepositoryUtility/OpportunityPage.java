package vtiger.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunityPage {
	
	WebDriver driver;
	 public OpportunityPage(WebDriver driver)
	 {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
	 }
	 
	 @FindBy(linkText="Opportunities")
	 private WebElement Opportunitieslink;
	 
	public WebElement getOpportunitieslink() {
		return Opportunitieslink;
	}

}
