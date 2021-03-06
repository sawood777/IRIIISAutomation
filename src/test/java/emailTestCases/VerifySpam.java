package emailTestCases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.MailPage;

public class VerifySpam {

		WebDriver driver;
		public VerifySpam(WebDriver driver) {
			this.driver=driver;
		}
		@Test(priority=6)
		public void testMoveToSpam()
		{
			Boolean flag=false;
			DashboardPage d= new DashboardPage(driver);
			MailPage m= new MailPage(driver);
			//d.clickMailCard();
			List<WebElement> sub=m.GetemailSubjects();
			String subj=sub.get(0).getText();
			m.clickFirstEmail();
			m.clickSpamIcon();
			m.clickMailFilter();
			m.clickSpamFilter();
			List<WebElement> sub1=m.GetemailSubjects();
			for(int i=0;i<sub1.size();i++)
			{
				
				if(sub1.get(i).getText().equals(subj))
				{
					flag=true;
					break;
				}
			}
			Assert.assertEquals((flag==true), true, "Email moved to spam unsucessfully");
			
		}
		@Test(priority=7)
		public void testMarkAsNotSpam()
		{
			Boolean flag=false;
			MailPage m= new MailPage(driver);
			List<WebElement> sub=m.GetemailSubjects();
			String subj=sub.get(0).getText();
			m.clickFirstEmail();
			m.clickNotSpam();
			m.clickMailFilter();
			m.clickUnProcessedFilter();
			List<WebElement> sub1=m.GetemailSubjects();
			for(int i=0;i<sub1.size();i++)
			{
				
				if(sub1.get(i).getText().equals(subj))
				{
					flag=true;
					break;
				}
			}
			Assert.assertEquals((flag==true), true, "Email moved to inbox unsucessfully");
			
		}
		
		
		@Test(priority=8)
		//Only 3 or less than 3 mails are been batch selected
		public void TestBatchMovetoSpamOfEmail()
		{
			Boolean flag=false;
			
			
			
			MailPage m= new MailPage(driver);
		
			List<WebElement> sub=m.GetemailSubjects();
			String[] myStringArray = new String[4];
			for(int i=0;i<4;i++)
			{
				myStringArray[i]=sub.get(i).getText();
				
			}
		
			Actions action = new Actions(driver); 
			 action.moveToElement(m.batchSelection1()).click().build().perform();
			 List<WebElement> box = m.getListOfCheckBox();
				for(int i=1;i<4;i++)
				{
					box.get(i).click();
				}
			m.clickSpamIcon();
			m.clickMailFilter();
			m.clickSpamFilter();
			List<WebElement> sub1=m.GetemailSubjects();
			for(int i=0;i<sub1.size();i++)
			{
				for(int j=0;j<myStringArray.length;j++)
				{
				if(sub1.get(i).getText().equals(myStringArray[j]))
				{
					flag=true;
					break;
				}
			}
			}
			
			Assert.assertEquals(flag==true, true, "Email Batch Operation for Spam failed");
			
		}
		
		@Test(priority=9)
		//Only 3 or less than 3 mails are been batch selected
		public void TestBatchMovetoInboxOfSpamEmail()
		{
			boolean flag=false;
			MailPage m= new MailPage(driver);
			List<WebElement> sub=m.GetemailSubjects();
			String[] myStringArray = new String[4];
			for(int i=0;i<4;i++)
			{
				myStringArray[i]=sub.get(i).getText();
				
			}
			Actions action = new Actions(driver); 
			action.moveToElement(m.batchSelection1()).click().build().perform();
			
			List<WebElement> box = m.getListOfCheckBox();
			for(int i=1;i<4;i++)
			{
				box.get(i).click();
			}
			m.clickNotSpam();
			m.clickMailFilter();
			m.clickUnProcessedFilter();
			List<WebElement> sub1=m.GetemailSubjects();
			for(int i=0;i<sub1.size();i++)
			{
				for(int j=0;j<myStringArray.length;j++)
				{
				if(sub1.get(i).getText().equals(myStringArray[j]))
				{
					flag=true;
					break;
				}
			}
			}
			Assert.assertEquals(flag==true, true, "Email Batch Move to Inbox of Spam email got failed");
			
		}

}

