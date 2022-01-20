package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * login page
 * @author sarav
 *
 */

public class LoginPage {
	//Element identification or declartion
	@FindBy(name="user_name")
	private WebElement usernameTextfield;
	
	@FindBy(name="user_password")
	private WebElement passwordTextfield;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
	//element initialization
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//getters methods
	public WebElement getUsernameTextField() {
		return usernameTextfield;
	}
	public WebElement getPasswordTextField() {
		return passwordTextfield;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	//business logic for login action
	/**
	 * This method will perform application login action
	 * @param username
	 * @param password
	 */
	
	public void loginToApplication(String username,String password) {
		usernameTextfield.sendKeys(username);
		passwordTextfield.sendKeys(password);
		loginButton.click();
	}

}
