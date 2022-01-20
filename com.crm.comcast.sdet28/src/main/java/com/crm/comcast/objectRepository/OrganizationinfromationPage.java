package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * organozation infromation page
 * @author sarav
 *
 */

public class OrganizationinfromationPage {
	public OrganizationinfromationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgInfoText;

	public WebElement getOrgInfoText() {
		return orgInfoText;
	}
	public String getOrgInfomationText() {
	return orgInfoText.getText();
	
}
}
