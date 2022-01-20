package contactTest.copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathConstants;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.ContactPage;
import com.crm.comcast.objectRepository.Homepage;
import com.crm.comcast.objectRepository.LoginPage;
/**
 * TestScript for delete Multiple contacts
 * @author sarav
 *
 */
public class DeleteContactTest {

	public static void main(String[] args) throws Throwable {
	//create object for utilities
	FileUtility fUtil=new FileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	ExcelUtility eUtil = new ExcelUtility();
	
	//get data from property file
	String browserName = fUtil.getPropertyFileData("browser");
	String url = fUtil.getPropertyFileData("url");
	String username = fUtil.getPropertyFileData("username");
	String password = fUtil.getPropertyFileData("password");
	
	//getting data from excelsheet
	String expectedResult = eUtil.getStringCellData("Sheet1", 12, 2);
	
	//lanuching the browser
	WebDriver driver =null;
	if(browserName.equals("chrome")) {
	System.setProperty(IPathConstants.CHROME_KEY,IPathConstants.CHROME_PATH);
	driver=new ChromeDriver();
	}
	else {
		System.out.println("Browser not available");
	}
	driver.manage().window().maximize();
	driver.get(url);
	wUtil.waitForPageLoad(driver);
	
	//login to application
	LoginPage login = new LoginPage(driver);
	login.loginToApplication(username, password);
	
	//delete  contacts
	Homepage homepage = new Homepage(driver);
	homepage.clickContact();
	
	ContactPage contactpage = new ContactPage(driver);
	contactpage.SelectContact();
	contactpage.ClickDeteleButton();
	
	//accept the alert
	wUtil.acceptAlert(driver);
	
	//verification for delete contact
	 String actualResult = driver.getTitle();
     if(actualResult.equals(expectedResult)) {
     	System.out.println("contact is not deleted");
     }
     else {
     	System.out.println("contact is deleted");
     }
	
	//Logout from the application
     homepage.logout();
	}
}