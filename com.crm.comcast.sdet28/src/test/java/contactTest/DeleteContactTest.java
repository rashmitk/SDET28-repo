package contactTest;

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

import com.crm.comcast.GenericUtility.BaseClass;
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
public class DeleteContactTest extends BaseClass {
@Test (groups= {"smokeTest"})
public void DeteleContact() throws Throwable{
	//getting data from excelsheet
	String expectedResult = eUtil.getStringCellData("Sheet1", 12, 2);
	
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
	
}}