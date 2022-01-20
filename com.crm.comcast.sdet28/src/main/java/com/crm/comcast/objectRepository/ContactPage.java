package com.crm.comcast.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.GenericUtility.WebDriverUtility;

/**
 * Contact Page
 * @author sarav
 *
 */
public class ContactPage extends WebDriverUtility {
	
	//
	WebDriverUtility wUtil=new WebDriverUtility();
	//element initialization
		public ContactPage(WebDriver driver) {
			PageFactory.initElements(driver, this);
		}
		
	//declering or identify the element
		@FindBy(id="43")
		private WebElement clickButton;
		
		@FindBy(id="44")
		private WebElement clickFirstButton;
		
		@FindBy(id="45")
		private WebElement clickSecondButton;
		
		@FindBy(linkText="edit")
		private WebElement clickEditButton;
		
		@FindBy(id="viewname")
		private WebElement clickOnFilters;
		
		@FindBy(xpath="//td[text()=' Administrator ']")
		private WebElement assignToName;
	
		//getter methods
		
		public WebElement getAssignToName() {
			return assignToName;
		}

		public WebElement getClickOnFilters() {
		 return clickOnFilters;
		}

		public WebElement getClickEditButton() {
			return clickEditButton;
		}

		public WebElement getClickFirstButton() {
			return clickFirstButton;
		}

		public WebElement getClickSecondButton() {
			return clickSecondButton;
		}
		@FindBy(xpath="//input[@class='crmbutton small delete']")
		private WebElement clickDeleteButton;
		
		public WebElement getClickDeleteButton() {
			return clickDeleteButton;
		}

		public WebElement getClickButton() {
			return clickButton;
		}
		
		//business logic
		public void clickEdit() {
			clickEditButton.click();
		}
		
		public void SelectContact() {
			clickButton.click();
		}
		
		public void ClickDeteleButton() {
			clickDeleteButton.click();
		}
		
		public void SelectFirstContact() {
			clickFirstButton.click();
		}
		public void SelectSecondContact() {
			clickSecondButton.click();
		}
		public void SelectFilters(String filter) {
		selectOption(filter, clickOnFilters);

		}
		
		public void toClickFilters() {
			clickOnFilters.click();
		  wUtil.selectOption(clickOnFilters, 0);
		  clickOnFilters.click();
		}
		public String AssignToName() {
			return assignToName.getText();
		}
}
