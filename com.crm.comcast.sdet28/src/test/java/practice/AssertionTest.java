package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionTest {
@Test
public void demo() {
	System.out.println("lanuch the browser");
	System.out.println("Login to the application");
	System.out.println("Create organization");
	
	int a=10;
	int b= 20;
	Assert.assertEquals(a, b);
	
	int [] arr1 = {1,2,3,4};
	int [] arr2 = {1,2,3,4};
	Assert.assertEquals(arr1,arr2);
	
	String expectedName="Saravanan";
	String actuakName="SaravananJ";
	Assert.assertEquals(expectedName,actuakName);
	
	System.out.println("Logout the application");
	System.out.println("quit the browser");
	
			
}

}
