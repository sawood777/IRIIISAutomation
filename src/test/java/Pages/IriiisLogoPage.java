package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IriiisLogoPage {
	
	WebDriver driver;
	WebDriverWait  wait;
	@FindBy(xpath="//area[@role='button']")private WebElement iriiisLog;
	@FindBy(xpath="//button[contains(text(),'Topic View')]")private WebElement topicPicker;
	@FindAll({@FindBy(xpath="//div[@class='topic-name ng-binding']")}) private List<WebElement> topicList;
	@FindBy(xpath="//button[@class='md-icon-button topic-menu__closeBtn md-button md-ink-ripple']")private WebElement close;
	@FindBy(xpath="//button[contains(text(),'Macro View')]")private WebElement macroView;
	
	public IriiisLogoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
		}
	public void clickIriiisLog()
	{	
		(new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(iriiisLog)).click();
	}
	public void clickTopicPicker()
	{
		topicPicker.click();
	}
	public List<WebElement> getTopicList()
	{
		return topicList;
	}
	public void clickCloseButton()
	{
		close.click();
	}
	
	public void clickMacroView()
	{
		macroView.click();
	}
	
	
}
