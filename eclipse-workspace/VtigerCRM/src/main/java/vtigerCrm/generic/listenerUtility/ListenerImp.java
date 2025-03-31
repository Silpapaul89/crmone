package vtigerCrm.generic.listenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImp implements ITestListener, ISuiteListener
{
	public ExtentReports report;
	public ExtentTest test;
	
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.STANDARD);
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("BROWSER", "chrome");
		report.setSystemInfo("ENVIRONMENT", "Test environment");
	}

	public void onFinish(ISuite suite) {
		System.out.println("Report backup");
		
		report.flush();
		
	}

	public void onTestStart(ITestResult result) {
		System.out.println("================"+result.getMethod().getMethodName()+"======STARTED======");
		//test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName()+" execution started");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("================"+result.getMethod().getMethodName()+"======END======");
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.PASS, result.getMethod().getMethodName());
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getMethod().getMethodName());
		System.out.println("================"+testName+"======FAILED======");
		TakesScreenshot TS = (TakesScreenshot) BaseClass.sdriver;
		String time = new Date().toString().replace(" ", "").replace(":", "");
		File src = TS.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File(".\\Screenshot\\"+testName+"_"+time+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String FilePath = TS.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(FilePath);
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("================"+result.getMethod().getMethodName()+"======SKIPPED======");
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getMethod().getMethodName());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}
	
}


