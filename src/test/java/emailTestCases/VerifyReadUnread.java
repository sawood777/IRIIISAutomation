package emailTestCases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.MailPage;


public class VerifyReadUnread {
	WebDriver driver;
	public VerifyReadUnread(WebDriver driver) 
	{
		this.driver= driver;
	}
	
	@Test(priority=16)
	public void testMarkAsUnread()
	{
		Boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		MailPage m= new MailPage(driver);
		//d.clickMailCard();
		List<WebElement> sub=m.GetemailSubjects();
		String subj=sub.get(0).getText();
		m.clickFirstEmail();
		m.clickElipses();
		m.markUnread();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> sub1 = m.getUnreadEmails();
		for(int i=0;i<sub1.size();i++)
		{
			if(sub1.get(i).getText().contains(subj))
			{
				
				flag=true;
				break;
			}
		}
		Assert.assertEquals(flag==true, true, "Mark as unread of Email is unsucessfully");

}
	
	@Test(priority=17)
	//Only 3 or less than 3 mails are been batch selected
	public void testBatchUnread()
	{
		int n=0;
		MailPage m= new MailPage(driver);
		
		List<WebElement> sub=m.GetemailSubjects();
		Actions action = new Actions(driver); 
		action.moveToElement(m.batchSelection1()).click().build().perform();
		List<WebElement> box = m.getListOfCheckBox();
		for(int i=1;i<4;i++)
		{
			box.get(i).click();
		}
		m.markUnreadIcon();
		m.clickMailFilter();
		m.clickUnProcessedFilter();
		List<WebElement> sub1=m.getUnreadEmails();
		for(int i=0;i<sub1.size();i++)
		{
			for(int j=0;j<sub.size();j++)
			{
			if(sub1.get(i).getText().contains(sub.get(j).getText()))
			{
				n= n+1;
				break;
			}
		}
		}
		Assert.assertEquals(((n>0)&&(n<=sub.size())), true, "Email Batch Unread is unsuccessfull");
		
		
	}
	@Test(priority=18)
	public void testBatchRead()
	{
		int n=0;
		MailPage m= new MailPage(driver);
		
		List<WebElement> sub=m.GetemailSubjects();
		Actions action = new Actions(driver); 
		
		action.moveToElement(m.batchSelection1()).click().build().perform();
		List<WebElement> box = m.getListOfCheckBox();
		for(int i=1;i<4;i++)
		{
			box.get(i).click();
		}
		m.markReadIcon();
		m.clickMailFilter();
		m.clickUnProcessedFilter();
		List<WebElement> sub1=m.getReadEmails();
		for(int i=0;i<sub1.size();i++)
		{
			for(int j=0;j<sub.size();j++)
			{
			if(sub1.get(i).getText().contains(sub.get(j).getText()))
			{
				n= n+1;
				break;
			}
		}
		}
		Assert.assertEquals(((n>0)&&(n<=sub.size())), true, "Email Batch read is unsuccessfull");
		
		
	}
}
