package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathConstants;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.CreateOrganizationPage;
import com.crm.comcast.objectRepository.Homepage;
import com.crm.comcast.objectRepository.LoginPage;
import com.crm.comcast.objectRepository.OrganizationPage;
import com.crm.comcast.objectRepository.OrganizationinfromationPage;

public class CreateOrganiztionTest3 {

	@Test (groups= {"smokeTest"})
public void CreateOrganiztionTest31() throws Throwable{
		//create object for utilities
		FileUtility fUtil=new FileUtility();
		JavaUtility jUtil = new JavaUtility();
		ExcelUtility eUtil = new ExcelUtility(); 
		WebDriverUtility wUtil = new WebDriverUtility();
		
		//get the data from properties file
		String browserName = fUtil.getPropertyFileData("browser");
		String url = fUtil.getPropertyFileData("url");
		String username = fUtil.getPropertyFileData("username");
		String password = fUtil.getPropertyFileData("password");
		
		//generate random number
		int randomNumber = jUtil.getRandomNumber();
		
		//get data from excelsheet
		String expectedOrganiztionName = eUtil.getStringCellData("sheet1",1,2);
		expectedOrganiztionName=expectedOrganiztionName+randomNumber;
		
		//how to use browser value and launch the browser
		WebDriver driver=null;
		if (browserName.equals("chrome")) {
		System.setProperty(IPathConstants.CHROME_KEY,IPathConstants.CHROME_PATH);
		driver=new ChromeDriver();
		}
		else {
			System.out.println("Browser is not supported");
		}
		
		driver.manage().window().maximize();
		wUtil.waitForPageLoad(driver);
		driver.get(url);
		
		//login to application
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(username, password);
		
		//create organization
		Homepage homepage = new Homepage(driver);
		homepage.clickOrganizationLink();
		
		OrganizationPage orgPage = new OrganizationPage(driver);
		orgPage.clickCreateOrgImg();
		
		CreateOrganizationPage createOrgPage = new CreateOrganizationPage(driver);
		createOrgPage.createOrganization(expectedOrganiztionName);
		OrganizationinfromationPage orgInfroPage = new OrganizationinfromationPage(driver);
		String actualOrgName = orgInfroPage.getOrgInfomationText();
		
		//organization name verification
		if(actualOrgName.contains(expectedOrganiztionName)) {
			System.out.println("Organization is created");
		}
		else {
			System.out.println("Organization is not created");
		}
		//logout action
		homepage.logout();
		//quit the browser
		driver.quit();
	    }
}


