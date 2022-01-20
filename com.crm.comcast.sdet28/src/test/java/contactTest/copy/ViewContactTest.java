package contactTest.copy;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathConstants;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.ContactPage;
import com.crm.comcast.objectRepository.Homepage;
import com.crm.comcast.objectRepository.LoginPage;

/**
 * TestScript for view the contact
 * @author sarav
 *
 */
public class ViewContactTest {

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
		
		//getting data from excel sheet
		String filter = eUtil.getStringCellData("Sheet1", 9, 2);
		String expectedResult = eUtil.getStringCellData("Sheet1", 15, 2);
		
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
		
		Homepage homepage = new Homepage(driver);
		homepage.clickContact();
		
		//perform drop down action
		ContactPage contactpage = new ContactPage(driver);
		//contactpage.SelectFilters(filter);		
		contactpage.toClickFilters();
		
		//verification for view contact
		String actualResult = driver.findElement(By.xpath("//td[text()=' Administrator ']")).getText();
        if(expectedResult.contains(actualResult)) {
        	System.out.println("contact is viewed");
        }
        else {
        	System.out.println("contact is not viewed");
		
        }
	
		//logout from the application
		homepage.logout();
		}

}
