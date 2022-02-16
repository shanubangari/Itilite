package com.makemytrip.GeneriUtils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListnerImplementation implements ITestListener{
	/**
	 * @author Jyoti H M
	 */
	WebDriverUtility wlib=new WebDriverUtility();
	private ExtentReports reporter=new ExtentReports();
	private ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/"+"ExtentReport"+JavaUtility.getCurrentDate()+".html");
	private ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		test=reporter.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
	}

	public void onTestFailure(ITestResult result) {
		WebDriver driver=null;
		try {
			driver=(WebDriver) result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(result.getInstance());
			EventFiringWebDriver efd=new EventFiringWebDriver(driver);
			File src = efd.getScreenshotAs(OutputType.FILE);
			//File dest=new File("./screenshot/"+result.getMethod().getMethodName()+"_"+JavaUtility.getCurrentDate()+"_.png");
			File dest=new File("./screenshot/"+result.getMethod().getMethodName()+JavaUtility.getCurrentDate()+"_.png");
			Files.copy(src, dest);
			test.addScreenCaptureFromPath(dest.getAbsolutePath());
			test.log(Status.FAIL, result.getMethod().getMethodName()+" is failed");
			test.log(Status.FAIL, result.getThrowable());

		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (NoSuchFieldException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SecurityException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onStart(ITestContext context) {
		//Configure the ExtentReports.
		spark.config().setDocumentTitle("Itilite Extent Report");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("My Testscript ExtentReport");
		
		//Attach the ExtentReports and System Configure Details.
		reporter.attachReporter(spark);
		reporter.setSystemInfo("OS", "Windows 10");
		reporter.setSystemInfo("author", "Jyoti H M");
		reporter.setSystemInfo("Reporter Name", "Make My Trip");
	}

	public void onFinish(ITestContext context) {
		reporter.flush();
	}



}
