package emailTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pages.DashboardPage;
import Pages.MailPage;

public class VerifySentEmails {
	
	
WebDriver driver;
	
	public  VerifySentEmails(WebDriver driver) {
		this.driver=driver;
	}
	
public void VerifyAttachment(){
		
		Boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		MailPage m= new MailPage(driver);
		d.clickMailCard();
		
		m.clickMailFilter();
		WebDriverWait waiter1 = new WebDriverWait(driver, 10);
		waiter1.until(ExpectedConditions.visibilityOf(m.hoverAllaccount()));
		
		Actions action = new Actions(driver); 
		action.moveToElement(m.hoverAllaccount()).build().perform();
		
		List<WebElement> acc = m.getAccountList();
		for(int i=0;i<acc.size();i++)
		{
			if(acc.get(i).getText().contains("@iriiis"))
			{
			acc.get(i).click();
			break;
			}
		}
		
		m.clickComposeIcon();
		m.enterToAddreess("devuser1@iriiisdev.com");
		m.enterSubject("String12233");
		m.enterEmailBody("hey test125");
		m.Attacfile();
		m.Selectattachment();
	
	try {
		Thread.sleep(5000);
	} catch (Exception e) {
		
	}
		m.sendmail();
		m.clickMailFilter();
		m.clickSentFilter();
		m.clickFirstEmail();
		m.verifyAttachment();
		
	}


}
