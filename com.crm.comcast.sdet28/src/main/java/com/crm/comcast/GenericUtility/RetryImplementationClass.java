package com.crm.comcast.GenericUtility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementationClass implements IRetryAnalyzer {
	int count=0;
	int retryLimit=5;

	public boolean retry(ITestResult result) {
	if(count<retryLimit){
	count++;
		return false;
	}
	return false;

}
}