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

public class CreateOrganiztionTest {

	public static void main(String[] args) throws Throwable {
		//get the data from properties file
		FileInputStream fis = new FileInputStream("./src/test/resources/data02.properties");
		Properties property = new Properties();
		property.load(fis);
		String browserName = property.getProperty("browser");
		String url = property.getProperty("url");
		String username = property.getProperty("username");
		String password = property.getProperty("password");
		
		//how to use browser value and launch the browser
		WebDriver driver=null;
		if (browserName.equals("chrome")) {
		 System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
		 driver=new ChromeDriver();
		}
		else {
			System.out.println("Browser is not supported");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(url);
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("manager");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("JS4 Software Solution");
		driver.findElement(By.name("button")).click();
		
		Thread.sleep(3000);
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a=new Actions(driver);
		a.moveToElement(ele).perform();	
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[text()='Sign Out'])")).click();
	}
		
		 
			
		
		
	}


