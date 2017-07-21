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
	
	public void testReply(String fun,String body)
	{
		Boolean flag=false;
		MailPage m= new MailPage(driver);
		//m.clickmailCard();
		List<WebElement> sub = m.GetemailSubjects();
		String s = sub.get(0).getText();
		m.clickFirstEmail();
		m.clickElipses();
		List<WebElement> opt = m.getOptions();
		for(int i=0;i<opt.size();i++)
		{
			
		if(opt.get(i).getText().contains(fun))
		{
			opt.get(i).click();
			break;
		}
		}
		if(fun=="Reply")
		{
		m.enterEmailBody(body);
		m.clickSendButton();
		m.clickCloseButton();
		m.clickMailFilter();
		m.clickSentFilter();
		List<WebElement> sub1=m.GetemailSubjects();
		for(int i=0;i<sub1.size();i++)
		{
			
			if(sub1.get(i).getText().contains(s))
			{
				flag=true;
				break;
			}
		}
		Assert.assertEquals((flag==true), true, "Email not sent");
		}
		else
			if(fun=="Forward")
			{
				m.enterToAddreess("praveen.kumar3@iriiisdev.com");
				m.enterForwardBody(body);
				m.clickSendButton();
				m.clickCloseButton();
				m.clickMailFilter();
				m.clickSentFilter();
				List<WebElement> sub1=m.GetemailSubjects();
				for(int i=0;i<sub1.size();i++)
				{
					
					if(sub1.get(i).getText().contains(s))
					{
						flag=true;
						break;
					}
				}
				Assert.assertEquals((flag==true), true, "Email not sent");
			}
	
		
	}
	public void testReplyAll(String body)
	{
		Boolean flag=false;
		MailPage m= new MailPage(driver);
		//m.clickmailCard();
		List<WebElement> sub = m.GetemailSubjects();
		String s = sub.get(0).getText();
		m.clickFirstEmail();
		m.clickElipses();
		List<WebElement> opt = m.getOptions();
		if(opt.size()>6)
		{
		for(int i=0;i<opt.size();i++)
		{
			
		if(opt.get(i).getText().contains("Reply all"))
		{
			opt.get(i).click();
			break;
		}
		}
		m.enterEmailBody(body);
		m.clickSendButton();
		m.clickCloseButton();
		m.clickMailFilter();
		m.clickSentFilter();
		List<WebElement> sub1=m.GetemailSubjects();
		for(int j=0;j<sub1.size();j++)
		{
			
			if(sub1.get(j).getText().contains(s))
			{
				flag=true;
				break;
			}
		}
		Assert.assertEquals((flag==true), true, "Email not sent");
		}
		else
		{
			System.out.println("There are no multiple recepients found to perform Reply All hence performing Reply");
			List<WebElement> opt1 = m.getOptions();
			for(int i=0;i<opt1.size();i++)
			{
				
			if(opt1.get(i).getText().contains("Reply"))
			{
				opt1.get(i).click();
				break;
			}
			}
			m.enterForwardBody("Replyall");
			m.clickSendButton();
			m.clickCloseButton();
			m.clickMailFilter();
			m.clickSentFilter();
			List<WebElement> sub1=m.GetemailSubjects();
			for(int j=0;j<sub1.size();j++)
			{
				
				if(sub1.get(j).getText().contains(s))
				{
					flag=true;
					break;
				}
			}
			Assert.assertEquals((flag==true), true, "Email not sent");
		}
	}

	
}
