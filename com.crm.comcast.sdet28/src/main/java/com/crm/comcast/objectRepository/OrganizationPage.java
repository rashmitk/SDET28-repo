package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * organization page
 * @author sarav
 *
 */

public class OrganizationPage {
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgplusImage;
	
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}

	public WebElement getCreateOrgplusImage() {
		return createOrgplusImage;
	}
	//business logic
	/**
	 * This method will click on createorg plus image
	 */
	
	public void clickCreateOrgImg() {
		createOrgplusImage.click();
	}

}
