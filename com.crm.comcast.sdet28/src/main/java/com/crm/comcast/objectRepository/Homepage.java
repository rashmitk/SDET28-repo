package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;
/**
 * Home page
 * @author sarav
 *
 */

public class Homepage extends WebDriverUtility {
	//Element identification or declartion
	@FindBy(linkText="Organizations")
	private WebElement organizationlink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactlink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	//initialzation of elements
	WebDriver driver;
	public Homepage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	//getters methods
	public WebElement getLogoutimg() {
		return logoutImg;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	public WebElement getContactLink() {
		return contactlink;
	}
	public WebElement getOrganizationLink() {
		return organizationlink;
}
	//business logics
	/**
	 * This method will click on organization link
	 */
	public void clickOrganizationLink() {
		organizationlink.click();
	}
	/**
	 * This method will logout the application
	 */
	public void logout() {
		mouseHover(driver, logoutImg);
		signOutLink.click();
	}
	public void clickContact() {
		contactlink.click();
	}
}