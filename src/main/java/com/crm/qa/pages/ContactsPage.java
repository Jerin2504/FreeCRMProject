package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	//New Contact
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(id="first_name")
	WebElement fName;
	
	@FindBy(id="surname")
	WebElement lName;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement saveBtn;
			
	//Actions
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsLabel()
	{
	
		return contactsLabel.isDisplayed();
	}
	
	public void createNewContact(String vtitle,String ftName, String ltName)
	{
		Select select = new Select(title);
		select.selectByVisibleText(vtitle);
		
		fName.sendKeys(ftName);
		lName.sendKeys(ltName);
		
		saveBtn.click();
	}
	

}
