package vtiger.crm.objectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmailPage {
	
	WebDriver driver;
	 public EmailPage(WebDriver driver)
	 {
	 this.driver=driver;
	 PageFactory.initElements(driver,this);
	 }
	 
	 @FindBy(linkText="Compose")
	 private WebElement composelink;
	 
	 //select[@name='parent_type']
	 
	 @FindBy(xpath="//select[@name='parent_type']")
	 private WebElement selectleadIcon;
	 
	 
	 //Select + icon
	 @FindBy(xpath="//img[@title='Select']")
	 private WebElement selectplusIcon;
	 
	 //search_text
	 @FindBy(name="search_text")
	 private WebElement searchBox;
	 
	 //search
	 @FindBy(name="search")
	 private WebElement searchNowBox;
	 
	 //subject
	 @FindBy(name="subject")
	 private WebElement subjectTextBox;
	 
	 @FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	 private WebElement saveTextBox;
	 
	 public WebElement getSaveTextBox() {
		return saveTextBox;
	}

	//dynamic element
	 @FindBy(xpath="//a[@href='javascript:window.close();']")
	 private WebElement dynamicLink;
	 
	 
	public WebElement getSubjectTextBox() {
		return subjectTextBox;
	}

	public WebElement getDynamicLink() {
		return dynamicLink;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchNowBox() {
		return searchNowBox;
	}

	public WebElement getSelectleadIcon() {
		return selectleadIcon;
	}

	public WebElement getSelectplusIcon() {
		return selectplusIcon;
	}

	public WebElement getComposelink() {
		return composelink;
	}
	
	

}
