package Pages;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.Keys;
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
	@FindBy(xpath="//button[@ng-click='gotoDashboard()']")private WebElement goToDashboard;
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
	@FindBy(xpath="//button[@ng-click='create()']")private WebElement createButton;
	@FindBy(xpath="//input[@placeholder='Search Contact']")private WebElement contactSearch;
	@FindBy(xpath="//button[@aria-label='Quick contact']")private WebElement quickContact;
	@FindBy(xpath="//input[@ng-model='contact.contactName']")private WebElement quickContactName;
	@FindBy(xpath="//input[@ng-model='contact.contactEmail']")private WebElement quickContactEmail;
	
	
	
	
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
	public void clickGoToDashboard()
	{
		goToDashboard.click();
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
		displayName.click();
		displayName.sendKeys(displayname);
		displayName.sendKeys(Keys.TAB);
	}
	public void enterEmailAddress(String email)
	{
		(new WebDriverWait(driver, 20))
		   .until(ExpectedConditions.visibilityOf(emailAddress)).sendKeys(email);
		
	}
	public void enterPhoneNumbar(String number)
	{
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(phoneNumber)).sendKeys(number);
	}
	public void enterContactTag(String tag)
	{
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(contactTag)).sendKeys(tag);
	}
	public void enterContactNote(String note)
	{
		(new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOf(contactNote)).sendKeys(note);
	}
	public void clickCreateButton()
	{
		(new WebDriverWait(driver, 20))
		   .until(ExpectedConditions.visibilityOf(createButton)).click();
		
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
	
}
