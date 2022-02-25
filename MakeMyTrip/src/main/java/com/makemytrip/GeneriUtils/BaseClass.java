package com.makemytrip.GeneriUtils;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.poifs.property.DirectoryProperty.PropertyComparator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.makemytrip.POMRepository.Login_SignUP_Page;
import com.makemytrip.POMRepository.MakeMyTripHomePage;
import com.makemytrip.POMRepository.UserHomePage;
import com.makemytrip.log4j.Log4jDemo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	/**
	 * @author Jyoti H M
	 * It contains TestNg Hierarchy basic configuration annotations.  
	 */
	public WebDriver driver;
	public Logger logger=Logger.getLogger(BaseClass.class);
	
	WebDriverUtility wlib=new WebDriverUtility();
	FileUtility flib=new FileUtility();

	//Step1: Launch the browser.
	@Parameters(value="browser")
	@BeforeClass()
	public void launchBrowser(@Optional("chrome") String browser) throws IOException {
		
		PropertyConfigurator.configure("./src/main/resources/Log4j2.properties");
		WebDriverManager.firefoxdriver().setup();
		logger.info("set firefox driver");
		WebDriverManager.chromedriver().setup();
		logger.info("set firefox driver");
		if(browser.equalsIgnoreCase("firefox")) {
			logger.info("Launch the Firefox browser.");
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {
			logger.info("Launch the Firefox browser.");
			driver=new ChromeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			logger.info("Launch the Firefox browser as a default browser.");
			driver=new FirefoxDriver();
		}

		driver.manage().window().maximize();
		//String url="https://www.makemytrip.com/";
		String url1=flib.getDataFromFile("url");
		driver.get(url1);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		logger.info("Browser Launched Successfully.");
		System.out.println("****** Browser Launched Successfully ******");
	}

	//Step2: Login to Make My Trip application.
	@BeforeMethod
	public void signUpUsingGmail() throws InterruptedException, IOException {
		// Sign up using G-mail.
		MakeMyTripHomePage makemytrip=new MakeMyTripHomePage(driver);
		makemytrip.clickOnSignUpUsingEmailOrPhone();

		// Login Credentials: E-mail: jyotihm22.itilite@gmail.com & Password: Itilite22@
		Login_SignUP_Page lgnSgnup=new Login_SignUP_Page(driver);
		String email = flib.getDataFromFile("email");
		String pwd = flib.getDataFromFile("pwd");
		//		String email="jyotihm22.itilite@gmail.com";
		//		String pwd="Itilite22@";
		lgnSgnup.LoginWithCredentials(driver,email,pwd);
	}

	//Step3: Logout from application.
	@AfterMethod
	public void userLogout() throws InterruptedException, AWTException {
		wlib.waitForElement(driver);
		UserHomePage user=new UserHomePage(driver);
		user.clickOnFlights(driver);
		Thread.sleep(5000);
		user.moveToHiJyoti(driver);
		user.clickOnMyProfile(driver);
		user.clickOnLogout(driver);
		//logger.debug("****** User Logout Successfully...! ******");
		logger.info(" User Logout Successfully...!");
		System.out.println("****** User Logout Successfully...! ******");
	}

	//Step4: Close the Current and all browsers.
	@AfterClass
	public void closeBrowser() {
		driver.quit();
		//logger.debug("****** Browser Closed Successfully ******");
		logger.info(" Browser Closed Successfully");
		System.out.println("****** Browser Closed Successfully ******");
	}

}
