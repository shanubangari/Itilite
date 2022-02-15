package com.makemytrip.GeneriUtils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplementation implements ITestListener{
	WebDriverUtility wlib=new WebDriverUtility();
	private ExtentReports reporter=new ExtentReports();
	private ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport"+JavaUtility.getCurrentDate()+".html");
	private ExtentTest test;
	public void onTestStart(ITestResult result) {
		test=reporter.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
		test.log(Status.FAIL, result.getThrowable());
		Object obj = result.getInstance();
		WebDriver driver = null;
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(obj);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String screenshotpath = null;
		try {
			screenshotpath = WebDriverUtility.takeScreenshot(driver, result.getMethod().getMethodName());
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshotpath);
	}

	public void onTestSkipped(ITestResult result) {
	test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
	test.log(Status.SKIP, result.getThrowable());
	}

	public void onStart(ITestContext context) {
		spark.config().setDocumentTitle("Itilite Extent Report");
		spark.config().setTheme(Theme.DARK);
		reporter.attachReporter(spark);
		reporter.setSystemInfo("OS", "Windows 10");
		reporter.setSystemInfo("Reporter Name", "Make My Trip");
	}

	public void onFinish(ITestContext context) {
		reporter.flush();
	}
	
	

}
