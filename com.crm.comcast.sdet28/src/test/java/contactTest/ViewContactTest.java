package contactTest;

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
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;
import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathConstants;
import com.crm.comcast.GenericUtility.WebDriverUtility;
import com.crm.comcast.objectRepository.ContactInformationPage;
import com.crm.comcast.objectRepository.ContactPage;
import com.crm.comcast.objectRepository.Homepage;
import com.crm.comcast.objectRepository.LoginPage;

/**
 * TestScript for view the contact
 * @author sarav
 *
 */
public class ViewContactTest extends BaseClass {
@Test (groups= {"regressionTest"})
public void ViewContact() throws Throwable   {
		//getting data from excel sheet
		String filter = eUtil.getStringCellData("Sheet1", 9, 2);
		String expectedResult = eUtil.getStringCellData("Sheet1", 15, 2);
		//View the contact
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
		}
}
/*@Test (groups= {"regressionTest"})
public void EditContact() throws Throwable{
	//getting data from excelsheet
	String editedName = eUtil.getStringCellData("Sheet1", 6, 2);
	String expectedResult = eUtil.getStringCellData("Sheet1", 6, 3);
	
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
}
}*/