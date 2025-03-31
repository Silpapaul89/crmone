package testCases;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import vtiger.crm.datasecurity.DBUtility;
import vtiger.crm.objectRepositoryUtility.HomePage;
import vtiger.crm.objectRepositoryUtility.LoginPage;
import vtigerCrm.generic.fileUtility.excelUtilty;
import vtigerCrm.generic.fileUtility.fileUtility;
import vtigerCrm.generic.WebDriverUtility.JavaUtility;
import vtigerCrm.generic.WebDriverUtility.WebDriverUtility;

public class BaseClass {

	/* Create Object */
	public fileUtility flib = new fileUtility();
	public excelUtilty elib = new excelUtilty();
	public JavaUtility jlib = new JavaUtility();
	public DBUtility dlib = new DBUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(groups = { "smokeTest", "regressionTest" })

	public void configBs() throws SQLException {

		System.out.println("===Connect to DB , report Config===");
		dlib.getDbConnection();

	}

	@BeforeClass

	public void configBC() throws Throwable {

		System.out.println("===Launch the browser===");
		String BROWSER = flib.getCommonDataFromPropertiesFile("browser");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver = driver;

	}

	@BeforeMethod

	public void configBM() throws Throwable {

		System.out.println("===login==");
		String URL = flib.getCommonDataFromPropertiesFile("url");
		String USERNAME = flib.getCommonDataFromPropertiesFile("username");
		String PASSWORD = flib.getCommonDataFromPropertiesFile("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);

	}

	@AfterMethod

	public void configAM() {
		System.out.println("==logout==");
		HomePage hp = new HomePage(driver);
		hp.logout();

	}

	@AfterClass

	public void configAC() {
		System.out.println("===close the BROWSER");
		driver.quit();

	}

	@AfterSuite

	public void configAS() throws Throwable {

		System.out.println("===close Db, Report backUp===");
		dlib.closeDbconnection();

	}

}
