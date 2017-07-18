package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
	WebDriver driver;;
	@FindBy(xpath="//div[contains(text(),'Mails')]")private WebElement mailCard;
	@FindBy(xpath="//div[contains(text(),'Contacts')]")private WebElement contactCard;
	

	
	
	
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		}
	public void clickMailCard()
	{
		mailCard.click();
	}
	public void clickContactCard()
	{
		(new WebDriverWait(driver, 20))
		   .until(ExpectedConditions.visibilityOf(contactCard)).click();
		
	}
	
	



}
