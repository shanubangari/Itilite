package com.makemytrip.GeneriUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class WebDriverUtility {
	/**
	 * @author Jyoti H M
	 * @param driver
	 * This is method is used to handle Synchronization issue, wait for the element present until specified time.
	 */
	public void waitForElement(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public static String takeScreenshot(WebDriver driver,String screenshotName) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screesnhot/"+screenshotName+".PNG");
		Files.copy(src, dest);
		return dest.getAbsolutePath();
	}
	
	public void awaitForElement(WebDriver driver,WebElement element) {
		try {
			System.out.println("retrying for element "+element);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		}
		catch (TimeoutException e) {
			System.out.println("retrying for elemet "+element);
			WebDriverWait wait=new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			// TODO: handle exception
		}
	}

	/**
	 * @author Jyoti H M
	 * This method is used to Mouse Hover on the particular Element.
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();;
	}
	
	public void selectOption(WebElement element, String text) {
		Select option=new Select(element);
		option.selectByVisibleText(text);
	}
	
	public void dragBtn(WebDriver driver, WebElement source, WebElement target) {
		Actions action=new Actions(driver);
		action.dragAndDrop(source, target).perform();
		
	}
	
	public void scrollToElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
