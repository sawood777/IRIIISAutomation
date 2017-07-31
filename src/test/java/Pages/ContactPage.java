package Pages;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//button[@ng-click='createNewContact();']")private WebElement contactCreateIcon;
	@FindBy(xpath="//button[@ng-click='toggleSearch()']")private WebElement contactSearchIcon;
	@FindBy(xpath="//button[@ng-click='gotoContacts()']")private WebElement goToContacts;
	@FindBy(xpath="//button[contains(text(),'More')]")private WebElement moreIcon;
	@FindBy(xpath="//button[contains(text(),'Find and Merge Duplicates')]")private WebElement findAndMerge;
	@FindBy(xpath="//button[@class='accounts-dropdown__top-btn']")private WebElement accountDropDown;
	@FindAll({@FindBy(xpath="//div[@class='contact-item-header__name contact-item-header__cell table-cell ng-binding']")}) private List<WebElement> contactList;
	@FindBy(id="autoCompleteId")private WebElement profileSearch;
	@FindBy(id="contact-dialog-displayname")private WebElement displayName;
	@FindBy(xpath="//input[@type='email']")private WebElement emailAddress;
	@FindBy(xpath="//input[@type='tel']")private WebElement phoneNumber;
	@FindBy(xpath="//textarea[@ng-model='contact.note']")private WebElement contactNote;
	@FindBy(xpath="//input[@placeholder='Tags']")private WebElement contactTag;
	@FindBy(xpath="//button[@ng-click='create()']")private WebElement createUpdateButton;
	@FindBy(xpath="//input[@placeholder='Search Contact']")private WebElement contactSearch;
	@FindBy(xpath="//button[@aria-label='Quick contact']")private WebElement quickContact;
	@FindBy(xpath="//input[@ng-model='contact.contactName']")private WebElement quickContactName;
	@FindBy(xpath="//input[@ng-model='contact.contactEmail']")private WebElement quickContactEmail;
	@FindBy(xpath="//div[contains(text(),'Kindly')]")private WebElement contactError; 
	@FindBy(xpath="//button[@ng-click='editContact()']")private WebElement updateContact; 
	@FindBy(xpath="//p[text()='Name']")private WebElement verifyPageLoded; 
	@FindAll({@FindBy(xpath="//li[@ng-click='$mdAutocompleteCtrl.select($index)']")}) private List<WebElement> profileSearchResult;
	@FindBy(xpath="//button[@ng-click='deleteContact()']")private WebElement contactDeletIcon;
	@FindBy(xpath="//button[@ng-click='dialog.hide()']")private WebElement deleteConfirmation;
	@FindBy(xpath="//button[@ng-click='inviteContact(contact); $event.stopPropagation()']")private WebElement inviteButton;
	@FindBy(xpath="//md-toast[contains(@class,'ng-scope _md md-bottom md-left md-default-theme')]")private WebElement toastNotification;	
	@FindBy(xpath="//button[@ng-click='$mdOpenMenu()']")private WebElement contactFilter;	
	@FindAll({@FindBy(xpath="//button[@aria-owns='menu_container_25']")}) private List<WebElement> filterOptions;
	
	
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		}

	public void clickCreateIcon()
	{
		contactCreateIcon.click();
	}
	public void clickSeachIcon()
	{
		contactSearchIcon.click();
	}
	public void clickGoToContacts()
	{
		goToContacts.click();
	}
	public void clickMoreIcon()
	{
		moreIcon.click();
	}
	public void clickFindAndMerge()
	{
		findAndMerge.click();
	}
	public void clickAccountDropDown()
	{
		accountDropDown.click();
	}
	public List<WebElement> getContactList()
	{
		return (new WebDriverWait(driver, 20))
		   .until(ExpectedConditions.visibilityOfAllElements(contactList));
	} 
	public void enterProfileseachKey(String searchKey)
	{
		profileSearch.sendKeys(searchKey);
	}
	public void enterDisplayName(String displayname)
	{
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(displayName)).click();
		displayName.clear();
		displayName.sendKeys(displayname);
		displayName.sendKeys(Keys.TAB);
	}
	public void enterEmailAddress(String email)
	{
		
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(emailAddress)).clear();
		emailAddress.sendKeys(email);
	}
	public void enterPhoneNumbar(String number)
	{
		
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(phoneNumber)).clear();
		phoneNumber.sendKeys(number);
	}
	public void enterContactTag(String tag)
	{
		
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(contactTag)).clear();
		contactTag.sendKeys(tag);
	}
	public void enterContactNote(String note)
	{
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(contactNote)).clear();
		contactNote.sendKeys(note);
	}
	public void clickCreateButton()
	{
		(new WebDriverWait(driver, 20))
		   .until(ExpectedConditions.visibilityOf(createUpdateButton)).click();
		
	}
	public void enterContactSearchKey(String key)
	{
		(new WebDriverWait(driver, 20))
		   .until(ExpectedConditions.visibilityOf(contactSearch)).sendKeys(key);
		
	}
	public void clickQuickContactIcon()
	{
		(new WebDriverWait(driver, 20)) .until(ExpectedConditions.visibilityOf(quickContact)).click();
	}
	public void enterQuickContactName(String name)
	{
		quickContactName.click();
		(new WebDriverWait(driver, 20)) .until(ExpectedConditions.visibilityOf(quickContactName)).sendKeys(name);
		quickContactName.sendKeys(Keys.TAB);
	}
	public void enterQuickContactEmail(String email)
	{
		(new WebDriverWait(driver, 20))
		   .until(ExpectedConditions.visibilityOf(quickContactEmail)).sendKeys(email);
	}
	public Boolean verifyContactError()
	{
		if(contactError.isDisplayed())
		
			return true;
		else
			return false;
	}
	public void clickUpdateContact()
	{
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(updateContact)).click();
	}
	
	
		public Boolean verifyUpdatePageLoaded()
		{
			if((new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(verifyPageLoded)).isDisplayed())
			
				return true;
			else
				return false;
		}
		public List<WebElement> getProfileSearchResult()
		{
			return (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfAllElements(profileSearchResult));
		} 
		public void clickContactDeletIcon()
		{
			(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(contactDeletIcon)).click();
		}
		public void clickDelete()
		{
			(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(deleteConfirmation)).click();
		}
		public boolean verifyInviteButton()
		{
			boolean text;
			try 
			{
			    text = inviteButton.isDisplayed();
			}
			catch (NoSuchElementException e)
			{
			    text = false;
			}
			System.out.println(text);
			return text;
		}
		public void clickInviteButton()
		{
			inviteButton.click();
		}
		public boolean verifyToastNotification()
		{
			boolean text;
			try 
			{
			    text = (new WebDriverWait(driver,20)).until(ExpectedConditions.visibilityOf(toastNotification)).isDisplayed();
			}
			catch (NoSuchElementException e)
			{
			    text = false;
			}
			System.out.println(text);
			return text;
		}
		public void clickContactFilter(){
			(new WebDriverWait(driver,20)).until(ExpectedConditions.visibilityOf(contactFilter)).click();
		}
		public List<WebElement> getContactFilterOptions()
		{
			return (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfAllElements(filterOptions));
		}
		
}
