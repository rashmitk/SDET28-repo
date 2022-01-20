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
import com.crm.comcast.objectRepository.ContactInformationPage;
import com.crm.comcast.objectRepository.ContactPage;
import com.crm.comcast.objectRepository.Homepage;
import com.crm.comcast.objectRepository.LoginPage;

/**
 * TestScript for edit the contact
 * @author sarav
 *
 */
public class EditContactTest {

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
		String editedName = eUtil.getStringCellData("Sheet1", 6, 2);
		String expectedResult = eUtil.getStringCellData("Sheet1", 6, 3);
		
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
		
		//edit the contact
		Homepage homepage = new Homepage(driver);
		homepage.clickContact();
		
		ContactPage contactpage = new ContactPage(driver);
		contactpage.clickEdit();
		
		ContactInformationPage contactinfo = new ContactInformationPage(driver);
		contactinfo.EditLastName(editedName);
	
		//verification for edit contact
        String actualResult = driver.findElement(By.linkText("tenSanthoshSanthoshSanthoshSanthoshSanth...")).getText();
        if(actualResult.contains(expectedResult)) {
        	System.out.println("contact is edited");
        }
        else {
        	System.out.println("contact is not edited");
        }
		
		//logout from the application
		homepage.logout();
		}

}
