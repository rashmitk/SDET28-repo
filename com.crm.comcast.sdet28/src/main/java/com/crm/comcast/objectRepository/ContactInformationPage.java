package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Contact infromation page
 * @author sarav
 *
 */
public class ContactInformationPage {
	//element initialization
	public ContactInformationPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
	}
	
	//declering or identify the element
	@FindBy(name="lastname")
	private WebElement lastNameTextField;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	//getters method
	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	//business logics
	public void EditLastName(String editedName) {
	lastNameTextField.sendKeys(editedName);
	saveButton.click();
	}
			

}
