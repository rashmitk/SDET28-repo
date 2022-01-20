package com.crm.comcast.GenericUtility;

import java.io.File;
import java.io.IOException;

import javax.print.attribute.standard.Destination;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpClass extends BaseClass implements ITestListener {
	
public void onTestFailure(ITestResult result) {
	String testCaseName=result.getMethod().getMethodName();
	System.out.println(testCaseName);
	
	//take a screenshot code
	EventFiringWebDriver event = new EventFiringWebDriver(BaseClass.sdriver);
	File source = event.getScreenshotAs(OutputType.FILE);
	File destination = new File("./errorshot/"+testCaseName+".png");
	try {
		FileUtils.copyFile(source, destination);
		//source.renameTo(destination);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
}

}
