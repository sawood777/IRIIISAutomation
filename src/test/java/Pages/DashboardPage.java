package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	@FindBy(xpath="//div[contains(text(),'Mails')]")private WebElement mailCard;
	
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	public void clickMailCard()
	{
		mailCard.click();
	}

}
