package com.makemytrip.GeneriUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import com.makemytrip.POMRepository.Login_SignUP_Page;
import com.makemytrip.POMRepository.MakeMyTripHomePage;
import com.makemytrip.POMRepository.UserHomePage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	/**
	 * @author Jyoti H M
	 */
	public WebDriver driver;
	
	WebDriverUtility wlib=new WebDriverUtility();
	FileUtility flib=new FileUtility();

	@BeforeClass()
	public void launchBrowser(@Optional("chrome") String browser) throws IOException {
		WebDriverManager.firefoxdriver().setup();
		WebDriverManager.chromedriver().setup();
		if(browser.equalsIgnoreCase("firefox")) {

			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome")) {

			driver=new ChromeDriver();
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}

		driver.manage().window().maximize();
		//String url="https://www.makemytrip.com/";
		String url1=flib.getDataFromFile("url");
		driver.get(url1);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println("****** Browser Launched Successfully ******");
	}

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
	
	@AfterMethod
	public void userLogout() {
//		wlib.waitForElement(driver);
//		UserHomePage user=new UserHomePage(driver);
//		user.clickOnLogout(driver);
		System.out.println("****** User Logout Successfully...! ******");
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
		System.out.println("****** Browser Closed Successfully ******");
	}

}
