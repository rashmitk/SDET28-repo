package practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.comcast.GenericUtility.BaseClass;

@Listeners(com.crm.comcast.GenericUtility.ListenerImpClass.class)
public class DemoForTakeScreenShot extends BaseClass {
	@Test
	public void Sample() {
	String expectedName="Saravanan";
	String actualName="SaravananJ";
	Assert.assertEquals(expectedName,actualName); 
	}

}
