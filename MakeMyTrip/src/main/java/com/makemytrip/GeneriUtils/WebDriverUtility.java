package com.makemytrip.GeneriUtils;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
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

	/**
	 * @author Jyoti H M
	 * Generic method for take the screenshot.
	 * @param driver
	 * @param screenshotName
	 * @return
	 * @throws Throwable
	 */
	public static String takeScreenshot(WebDriver driver,String screenshotName) throws Throwable {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screesnhot/"+screenshotName+".PNG");
		Files.copy(src, dest);
		return dest.getAbsolutePath();
	}

	/**
	 * @author Jyoti 
	 * Wait for the element visible using WebDriverWait.
	 * @param driver
	 * @param element
	 */
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
		action.moveToElement(element).perform();
	}

	/**
	 * @author Jyoti H M
	 * Method for handling Multiple options using Visible Text.
	 * @param element
	 * @param text
	 */
	public void selectOption(WebElement element, String text) {
		Select option=new Select(element);
		option.selectByVisibleText(text);
	}

	/**
	 * @author Jyoti H M
	 * This method for Drag and drop mouse action. 
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void dragBtn(WebDriver driver, WebElement source, WebElement target) {
		Actions action=new Actions(driver);
		action.dragAndDrop(source, target).perform();

	}

	/**
	 * @author Jyoti H M
	 * Scroll to the particular element.
	 * @param driver
	 * @param element
	 */
	public void scrollToElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * @author Jyoti H M
	 * This method is used to double click on the element.
	 * @param driver
	 * @param element
	 */
	public void doubleClick(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}

	/**
	 * @author Jyoti H M
	 * This method is used to right click on the web page.
	 * @param driver
	 */
	public void rightClick(WebDriver driver) {
		Actions action=new Actions(driver);
		action.contextClick().perform();
	}

	/**
	 * @author Jyoti H M
	 * This method is used to right click on the element.
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}

	/**
	 * @author Jyoti H M
	 * This method is used to switch parent window.
	 * @param driver
	 * @param partialTitle
	 * @return
	 */
	public String switchToWindow(WebDriver driver, String partialTitle) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parentWindow = iterator.next();
		driver.switchTo().window(partialTitle);
		return partialTitle;
	}

	/**
	 * @author Jyoti H M
	 * This method is used to switch child window.
	 * @param partialTitle
	 * @param driver
	 * @return
	 */
	public String switchToWindow(String partialTitle, WebDriver driver) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		String parentWindow = iterator.next();
		String childWindow=iterator.next();
		driver.switchTo().window(partialTitle);
		return partialTitle;
	}

	/**
	 * @author Jyoti H M
	 * This method is used to switch the window using window id.
	 * @param driver
	 * @param partialWinTitle
	 * @return
	 */
	public String switchToParticularWindow(WebDriver driver, String partialWinTitle) {
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		while(iterator.hasNext()) {
			String windId = iterator.next();
			String title=driver.switchTo().window(windId).getTitle();
			if(title.equalsIgnoreCase(partialWinTitle)) {
				break;
			}
		}
		return partialWinTitle;

	}

}
