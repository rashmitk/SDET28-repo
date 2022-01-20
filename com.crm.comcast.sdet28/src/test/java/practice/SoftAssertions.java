package practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertions {
@Test
public void Sample() {
	String expectedName="Saravanan";
	String actualName="SaravananJ";
	
	Reporter.log("this is soft assert class", true);
	SoftAssert sa = new SoftAssert();
	sa.assertEquals(expectedName, actualName);
	sa.assertAll();
	
}

}
