package emailTestCases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Pages.DashboardPage;
import Pages.IriiisLogoPage;
import Pages.MailPage;

public class VerifyReplyAndForwardingEmail {
	
	WebDriver driver;
	public VerifyReplyAndForwardingEmail(WebDriver driver) {
		this.driver=driver;;
	}
	
	public void testReply()
	{
		Boolean flag=false;
		MailPage m= new MailPage(driver);
		//m.clickmailCard();
		List<WebElement> sub = m.GetemailSubjects();
		String s = sub.get(0).getText();
		m.clickFirstEmail();
		m.clickReplyButton();
		m.enterEmailBody("Replying to Email");
		m.clickSendButton();
		m.clickMailFilter();
		m.clickSentFilter();
		List<WebElement> sub1=m.GetemailSubjects();
		for(int i=0;i<sub1.size();i++)
		{
			
			if(sub1.get(i).getText().contains("Re: "+ s))
			{
				flag=true;
				break;
			}
		}
		Assert.assertEquals((flag==true), true, "Email not sent");
		
	}

}
