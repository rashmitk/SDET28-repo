package com.crm.comcast.GenericUtility;

import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Utility for webdrivers
 * @author sarav
 *
 */
public class WebDriverUtility {
	/**
	 * It will wait 20 seconds till the element load in DOM
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver){
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	}
	/**
	 * This method will wait till element is visible
	 * @param driver
	 * @param element
	 */
	public void waitForVisibilityofElement(WebDriver driver,WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOf(element));
	}
	/**
	 * This method will wait till element to be clickable
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClick(WebDriver driver,WebElement element) {
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.elementToBeClickable(element));
	element.click();
	
	}
	/**
	 * This method is used to wait for the element and do click opeartion
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
	int  count=0;
	while(count<50) {
	try {
		element.click();
	}
	 catch (Exception e) {
		 Thread.sleep(1000);
		 count++;
	 }
	}
	}
	/**
	 * This method will select the element based on index
	 * @param element
	 * @param index
	 */
	public void selectOption(WebElement element,int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * This method will select the element based on value
	 * @param element
	 * @param Value
	 */
	public void selectOption(WebElement element,String Value) {
		Select select = new Select(element);
		select.selectByValue(Value);
	}
	/**
	 * This method will select the element based on text
	 * @param text
	 * @param element
	 */
	public void selectOption(String text,WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	/**
	 * This method will verify whether expected option is present in dropdowm list or not
	 * @param element
	 * @param expectedOptions
	 * @return
	 */

	public WebElement verifyTheDropDownList(WebElement element,String expectedOptions) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		for(WebElement ele:options) {
			if(ele.equals(expectedOptions)) {
				System.out.println("value is present in dropdown");
				return ele;
			}else {
				System.out.println("value is not present in dropdown");
				
			}
		}
		return null;
	}
	/**
	 * This method will performs mouse hovering action
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver,WebElement element) {
	Actions action = new Actions(driver);
	action.moveToElement(element).perform();
	}
	/**
	 * This method will performs rightclick action
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver,WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
		}
	/**
	 * Used to perform javascript click on webelement
	 * @param driver
	 * @param element
	 */
	public void jsClick(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click", element);
	}
	/**
	 * This method is used to send the value using javascript executor
	 * @param driver
	 * @param valueToEnter
	 * @param element
	 */
	
	public void enteringDataUsingJs(WebDriver driver,String valueToEnter,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("argument[0].value='"+valueToEnter+"'",element);
	}
	/**
	 * This method will switch to different windows using partial title
	 * @param driver
	 * @param partialWindowTitle
	 */
	public void switchWindow(WebDriver driver,String partialWindowTitle) {
	Set<String> winids = driver.getWindowHandles();
	Iterator<String> it = winids.iterator();
	while(it.hasNext()) {
		String winid = it.next();
		String title= driver.switchTo().window(winid).getTitle();
		if(title.contains(partialWindowTitle)) {
			break;
		}
	}
	}
	/**
	 * This method is used to take a screenshot in the case of failure
	 * @param driver
	 * @param testCaseName
	 * @return
	 */
	public String screenShot(WebDriver driver,String testCaseName) {
	JavaUtility jUtil = new JavaUtility();
	String filePath="./errorshot"+testCaseName+jUtil.getSystemDateAndTime();
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source =ts.getScreenshotAs(OutputType.FILE);
	File destination=new File(filePath);
	//Files.copy(source,destination);
	source.renameTo(destination);
	return filePath;
	}
	/**
	 * This method will swithch the frames baesd on the index passed
	 * @param driver
	 * @param index
	 */
	public void switchFrames(WebDriver driver,int index) {
	driver.switchTo().frame(index);
	}
	/**
	 * This method will switch the frames baesd on the name or id passed
	 * @param driver
	 * @param index
	 */
	public void switchFrames(WebDriver driver,String nameOrId) {
	driver.switchTo().frame(nameOrId);
	}
	/**
	 * This method will switch the frames based on the WebElement passed
	 * @param driver
	 * @param index
	 */
	public void switchFrames(WebDriver driver,WebElement element) {
	driver.switchTo().frame(element);
	}
	/**
	 * This method will accepts the alert
	 * @param driver
	 * @param index
	 */
	
	public void acceptAlert(WebDriver driver) {
	driver.switchTo().alert().accept();	
	}
	/**
	 * This method will click on dismiss button in alert popup
	 * @param driver
	 * @param index
	 */
	
	public void dismissAlert(WebDriver driver) {
	driver.switchTo().alert().dismiss();	
	}
	
	public WebDriver openTheChromeBrowser() {
	WebDriver driver=new ChromeDriver();
	return driver;
	
	}
}