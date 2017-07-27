package emailTestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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
		//WebDriverWait waiter1 = new WebDriverWait(driver, 10);
		//waiter1.until(ExpectedConditions.visibilityOf(m.hoverAllaccount()));
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			
		}
		
		Actions action = new Actions(driver); 
		action.moveToElement(m.hoverAllaccount()).build().perform();
		
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			
		}
		
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
		m.clickSendButton();
		m.Alert();
		m.clickMailFilter();
		m.clickSentFilter();
		m.clickFirstEmail();
		m.verifyAttachment();
		m.clickCloseButton();
		
	}

	public void ReplyAndForwardwithAttach(String fun, String body){
	
		Boolean flag=false;
		MailPage m= new MailPage(driver);
		//m.clickmailCard();
		m.clickMailFilter();
		m.clickInboxIcon();
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
		m.Attacfile();
		m.Selectattachment();
	
	try {
		Thread.sleep(5000);
	} catch (Exception e) {
		
	}
	
	m.clickSendButton();
	m.Alert();
	
	try {
		Thread.sleep(5000);
	} catch (Exception e) {
		
	}
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
			
			
			m.Attacfile();
			m.Selectattachment();
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			
		}
		
		m.clickSendButton();
		m.Alert();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			
		}
		
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
	
	public void testReplyAllwithAttachment(String body)
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
		
		m.Attacfile();
		m.Selectattachment();
	
	try {
		Thread.sleep(5000);
	} catch (Exception e) {
		
	}
	
	m.clickSendButton();
	m.Alert();
	try {
		Thread.sleep(5000);
	} catch (Exception e) {
		
	}
		
		
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


			m.Attacfile();
			m.Selectattachment();
		
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			
		}
		
		m.clickSendButton();
		m.Alert();
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			
		}
		
		
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
