package practice;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationTest {
@BeforeClass
public void bc(){
	System.out.println("Lanching the browser");
}
@AfterClass
public void ac(){
	System.out.println("quit the browser");
}

@BeforeMethod
public void bm() {
	System.out.println("Login to the application");
}
@AfterMethod
public void am() {
	System.out.println("Logout the application");
}

@Test (priority = 1)
public void org() {
	System.out.println("Navigate to organization");
	System.out.println("create to organization");
	System.out.println("verify to organization");
}
@Test (priority = 2)
public void contact() {
	System.out.println("Navigate to contact");
	System.out.println("create to contact");
	System.out.println("verify to contact");
}
@Test (priority = 3)
public void product() {
	System.out.println("Navigate to product");
	System.out.println("create to product");
	System.out.println("verify to product");
}
}
