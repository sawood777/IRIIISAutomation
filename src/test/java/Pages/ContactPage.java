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
	@FindBy(xpath="//a[@ui-sref='layout.createContactGroup']")private WebElement contactCreateIcon1;
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
	@FindBy(xpath="//button[@ng-click='chatContact(contact); $event.stopPropagation()']")private WebElement chatButton;
	@FindBy(xpath="//md-toast[contains(@class,'ng-scope _md md-bottom md-left md-default-theme')]")private WebElement toastNotification;	
	@FindBy(xpath="//button[@ng-click='$mdOpenMenu()']")private WebElement contactFilter;	
	@FindBy(xpath="//button[text()='Contacts']") private WebElement filterOptions ;
	@FindBy(xpath="//button[text()='Groups']") private WebElement groupOptions ;
	
	@FindAll({@FindBy(xpath="//md-menu-item[@class='accounts-submenu md-in-menu-bar']")}) private List<WebElement>  contactOptions;
	@FindBy(xpath=" //input[@name='groupName']") private WebElement groupName ;
	@FindBy(xpath="//div[@ng-click='openContactPicker()']") private WebElement contactPicker;
	@FindBy(xpath="//div[@class='contact-picker__img table-cell']") private WebElement contactPickerList;
	@FindBy(xpath="//input[@ng-click='openContactPicker()']") private WebElement contactPicker1;
	@FindAll({@FindBy(xpath="//div[@class='contact-picker__displayname table-cell ng-binding']")}) private List<WebElement> contactsInContactPicket;
	@FindBy(xpath="//button[@ng-click='addItemsToList()']") private WebElement addToGroup;
	@FindAll({@FindBy(xpath="//div[@class='contact-item-header__name contact-item-header__cell table-cell ng-binding']")}) private List<WebElement> contactGroupList;
	@FindBy(xpath="//button[@ng-if='$mdChipsCtrl.isRemovable()']") private WebElement removeContact;
	@FindBy(xpath="//button[@ng-click='updateGroup()']") private WebElement updateGroupIcon;
	@FindBy(xpath="//button[@ng-click='deleteGroup()']") private WebElement deleteGroupIcon;
	@FindBy(xpath="//button[@ng-click='dialog.hide()']") private WebElement confirmationDelete;
	@FindBy(xpath="//textarea[@id='chat-input-textarea']") private WebElement textArea;
	@FindAll({@FindBy(xpath="//button[contains(@ng-disabled,'userInputs.selected')]")}) private List<WebElement> optionsUnderMore;
	@FindBy(xpath="//button[@ng-click='mergeAllDuplicates(duplicateLists)']") private WebElement mergeAll;
	@FindBy(xpath="//div[text()='No duplicates found']") private WebElement noDuplicatesFound;
	@FindAll({@FindBy(xpath="//md-menu-item[contains(@ng-click,'loadContacts')]")}) private List<WebElement> sortOptions;
	@FindBy(xpath="//span[contains(text(),'(')]") private WebElement numberOfContacts;
	@FindBy(xpath="//button[text()='Export Contacts']") private WebElement exportContact ;
	@FindBy(xpath="//button[text()='CSV format']") private WebElement csvExport ;
	@FindBy(xpath="//button[text()='Import Contacts']") private WebElement importContact ;
	@FindAll({@FindBy(xpath="//button[contains(@ng-click,'importContacts(')]")}) private List<WebElement> importTypes;
	@FindBy(xpath="//button[contains(@ng-click,'showOpenDialog()')]") private WebElement selectFromComputer ;
	@FindBy(xpath="//button[@ng-click='initiateUpload(true)']") private WebElement upload ;
	
	
	public ContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		}

	public void clickCreateIcon()
	{
		contactCreateIcon.click();
	}
	public void clickCreateIcon1()
	{
		contactCreateIcon1.click();
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
		(new WebDriverWait(driver, 20))
		   .until(ExpectedConditions.visibilityOf(moreIcon)).click();
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
		public boolean verifyChatButton()
		{
			boolean text;
			try 
			{
			    text = chatButton.isDisplayed();
			}
			catch (NoSuchElementException e)
			{
			    text = false;
			}
			System.out.println(text);
			return text;
		}
		public void clickChatButton()
		{
			chatButton.click();
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
			  text=toastNotification.isDisplayed();
			}
			catch (NoSuchElementException e)
			{
			 text=false;
			}
			System.out.println(text);
			return text;
		}
		public void clickContactFilter(){
			(new WebDriverWait(driver,20)).until(ExpectedConditions.visibilityOf(contactFilter)).click();
		}
		public WebElement clickFilterOptions()
		{
			return (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(filterOptions));
		}
		public List<WebElement> getContactFilters()
		{
			return (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfAllElements(contactOptions));
		}
		public void enterGroupName(String s)
		{
			(new WebDriverWait(driver,20)).until(ExpectedConditions.visibilityOf(groupName)).clear();
			groupName.sendKeys(s);
		}
		public void clickContactPicker()
		{
			(new WebDriverWait(driver,20)).until(ExpectedConditions.visibilityOf(contactPicker)).click();
		}
		public void clickContactPicker1()
		{
			(new WebDriverWait(driver,20)).until(ExpectedConditions.visibilityOf(contactPicker1)).click();
		}
		
		
		public WebElement hoverContactList()
		{
			return (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(contactPickerList));
		}

		public List<WebElement> getContactListInContactPicker()
		{
			return (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfAllElements(contactsInContactPicket));
		}
		public void clickAddToContact()
		{
			(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(addToGroup)).click();
		}
		public List<WebElement> getContactGroupList()
		{
			return (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfAllElements(contactGroupList));
		}
		public void clickRemoveContactIcon()
		{
			 (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(removeContact)).click();
		}
		public void clickUpdateGroupicon()
		{
			(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(updateGroupIcon)).click();
		}
		public void clickDeleteGroupIcon()
		{
			(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(deleteGroupIcon)).click();
		}
		public void clickDeleteInConformationPopUp()
		{
			(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(confirmationDelete)).click();
		}
		public boolean verifyTextArea()
		{
			boolean text;
			try 
			{  
			    text = (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(textArea)).isDisplayed();
			    if(text)
			    {
			    	if(textArea.isEnabled())
			    	{
			    		System.out.println("text box is enabled user can send the message");
			    	}
			    	else
			    	{
			    		System.out.println("Text box is disabled user cannot type the message as the other user has to accept the chat invitation");
			    	}
			    }
			}
			catch (NoSuchElementException e)
			{
			    text = false;
			}
			System.out.println(text);
			return text;
			
		}
		public WebElement clickGroupOptions()
		{
			return (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(groupOptions));
		}
		
		public List<WebElement> getoptionsUnderMore()
		{
			return (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfAllElements(optionsUnderMore));
		}
		public void clickMergeAll()
		{
			 (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(mergeAll)).click();
		}
		
		public boolean verifynoDuplicatesFound()
		{
			boolean text;
			try 
			{  
			    text = noDuplicatesFound.isDisplayed();
			    
			}
			catch (NoSuchElementException e)
			{
			    text = false;
			}
			System.out.println(text);
			return text;
			
		}
		public List<WebElement> getSortOptions()
		{
			return (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfAllElements(sortOptions));
		}
		public String getNumberOfContacts()
		{
			return (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(numberOfContacts)).getText();
		}
		
		public WebElement clickExportOption()
		{
			return (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(exportContact));
		}
		public void clickCSVExport()
		{
			(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(csvExport)).click();
		}
		public WebElement clickImportContact()
		{
			return (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(importContact));
		}
		public List<WebElement> getImportTypes()
		{
			return (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfAllElements(importTypes));
		}
		public void clickSelectFromComputer()
		{
			(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(selectFromComputer)).click();
		}
		public void clickUpload()
		{
			(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(upload)).click();
		}
		
}


