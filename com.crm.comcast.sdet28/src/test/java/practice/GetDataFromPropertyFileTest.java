package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class GetDataFromPropertyFileTest {

	@Test (groups= {"regressionTest"})
	public void GetDataFromPropertyFileTest1() throws Throwable {
	//java object representation of physical property file
	FileInputStream fis = new FileInputStream("./src/test/resources/data02.properties");
	//create an object for properties file
	Properties property = new Properties();
	//load the key and values from the property object
	property.load(fis);
	String browser = property.getProperty("browser");
	String url = property.getProperty("url");
	String username = property.getProperty("username");
	String password = property.getProperty("password");
	
	System.out.println(browser);
	System.out.println(url);
	System.out.println(username);
	System.out.println(password);


	}

}
