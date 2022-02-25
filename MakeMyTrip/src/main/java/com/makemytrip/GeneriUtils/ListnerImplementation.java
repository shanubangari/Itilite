package com.makemytrip.GeneriUtils;
import java.io.File;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.observer.ExtentObserver;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class ListnerImplementation implements ITestListener{
	/**
	 * @author Jyoti H M
	 * In this class we utilize the Listener feature of testNG and implemented Method Overriding OOP's concept.
	 */
	WebDriverUtility wlib=new WebDriverUtility();
	public ExtentReports reporter=new ExtentReports();
	public ExtentSparkReporter spark=new ExtentSparkReporter("./extentReport/"+"ExtentReport"+JavaUtility.getCurrentDate()+".html");
	
	private ExtentTest test;
	
	//Step1: This logic is used to create test method.
	public void onTestStart(ITestResult result) {
		test=reporter.createTest(result.getMethod().getMethodName());
	}

	//Step2: This logic is used to get method name and mention the Test Script is Passed Successfully.
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName()+" is passed");
	}

	//Step3: This logic is used to get method name and mention the Test Script is Passed Failed and take screenshot of script store it in specified location.
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

	//Step4: This logic is used to get method name and mention the Test Script is Skipped.
	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is skipped");
		test.log(Status.SKIP, result.getThrowable());
	}

	//Step5: This logic is used to Configure the ExtentReports and Attach the ExtentReports and System Configure Details.
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

	//Step6: This logic is used to flush the reports.
	public void onFinish(ITestContext context) {
		reporter.flush();
	}



}
