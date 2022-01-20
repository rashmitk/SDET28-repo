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

import com.crm.comcast.GenericUtility.ExcelUtility;
import com.crm.comcast.GenericUtility.FileUtility;
import com.crm.comcast.GenericUtility.IPathConstants;
import com.crm.comcast.GenericUtility.JavaUtility;
import com.crm.comcast.GenericUtility.WebDriverUtility;

public class CreateOrganiztionTest2 {

	public static void main(String[] args) throws Throwable {
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
		String organiztionName = eUtil.getStringCellData("sheet1",1,2);
		organiztionName=organiztionName+randomNumber;
		
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
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		
		//create organization
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("JS4 Software Solution");
		driver.findElement(By.name("button")).click();
		
		//logout action
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();	
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Sign Out'])")).click();
	    }
}


