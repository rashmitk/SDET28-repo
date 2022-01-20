package com.crm.comcast.GenericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.comcast.objectRepository.Homepage;
import com.crm.comcast.objectRepository.LoginPage;
/**
 * This Base class contains all the config annotations
 * @author sarav
 *
 */

public class BaseClass {
	//object creation
	public WebDriver driver;
	public static WebDriver sdriver;
	public FileUtility fUtil=new FileUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public ExcelUtility eUtil = new ExcelUtility();
	
@BeforeSuite (groups= {"smokeTest","regressionTest"})
	public void configBs() {
	//connection to the DB
	System.out.println("==== connection to database===");
	}
@Parameters("browser")
@BeforeClass (groups= {"smokeTest","regressionTest"})
	//lanuch the browser
	public void configBc(String browser) throws Throwable {
	//String browserName = fUtil.getPropertyFileData("browser");
	String url = fUtil.getPropertyFileData("url");
	if(browser.equals("chrome")) {
		System.setProperty(IPathConstants.CHROME_KEY,IPathConstants.CHROME_PATH);
		driver=new ChromeDriver();
		}
	else if (browser.equals("firefox")) {
		System.setProperty(IPathConstants.FIREFOX_KEY,IPathConstants.FIREFOX_PATH);
		driver=new FirefoxDriver();
		} 
		else{
			System.out.println("Browser not available");
		}
	
	sdriver = driver;
	driver.manage().window().maximize();
	driver.get(url);
	wUtil.waitForPageLoad(driver);
	}


@BeforeMethod (groups= {"smokeTest","regressionTest"})
	//login to the application
	public void configBm() throws Throwable {
	String username = fUtil.getPropertyFileData("username");
	String password = fUtil.getPropertyFileData("password");
	LoginPage login = new LoginPage(driver);
	login.loginToApplication(username, password);
	}

@AfterMethod (groups= {"smokeTest","regressionTest"})
	//logout the application
	public void configAm() {
	Homepage homepage = new Homepage(driver);
	homepage.logout();
	}

@AfterClass (groups= {"smokeTest","regressionTest"})
	public void configAc() {
	//quit the browser
	driver.quit();
 	}

@AfterSuite (groups= {"smokeTest","regressionTest"})
	public void configAs() {
	//connection to the DB
	System.out.println("==== closing the database===");
	}
}
