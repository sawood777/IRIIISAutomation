package emailTestCases;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.DashboardPage;
import Pages.MailPage;

public class VerifyTrash {
	WebDriver driver;
	public VerifyTrash(WebDriver driver) {
		this.driver=driver;
	}
	
		@Test(priority=10)
		public void testMoveToTrash()
		{
			Boolean flag=false;
			DashboardPage d= new DashboardPage(driver);
			MailPage m= new MailPage(driver);
			//d.clickMailCard();
			List<WebElement> sub=m.GetemailSubjects();
			String subj=sub.get(0).getText();
			m.clickFirstEmail();
			m.clickTrashIcon();
			m.clickMailFilter();
			m.clickTrashFilter();
			List<WebElement> sub1=m.GetemailSubjects();
			for(int i=0;i<sub1.size();i++)
			{
				
				if(sub1.get(i).getText().equals(subj))
				{
					flag=true;
					break;
				}
			}
			Assert.assertEquals((flag==true), true, "Email moved to Trash is unsucessfully");
			
		}
		@Test(priority=11)
		public void testMoveToInboxFromTrashListing()
		{
			Boolean flag=false;
			MailPage m= new MailPage(driver);
			List<WebElement> sub=m.GetemailSubjects();
			String subj=sub.get(0).getText();
			m.clickFirstEmail();
			m.clickElipses();
			m.clickunTrashExpandedView();
			if(m.checkcloseMailIcon())
			{
				m.clickCloseMailIcon();
			}
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
			Assert.assertEquals((flag==true), true, "Email moved to Inbox from Untrash List is unsucessfully");
			
		}
		
		
		@Test(priority=12)
		//Only 3 or less than 3 mails are been batch selected
		public void TestBatchMoveToTrash()
		{
			int n=0;

			MailPage m= new MailPage(driver);
			List<WebElement> sub=m.GetemailSubjects();
			String[] myStringArray = new String[sub.size()];
			for(int i=0;i<sub.size();i++)
			{
				myStringArray[i]=sub.get(i).getText();
				
			}
			Actions action = new Actions(driver); 
			action.moveToElement(m.batchSelection1()).click().build().perform();
			 m.clickSelectAll();
			m.clickTrashIcon();
			m.clickMailFilter();
			m.clickTrashFilter();
			List<WebElement> sub1=m.GetemailSubjects();
			for(int i=0;i<sub1.size();i++)
			{
				for(int j=0;j<myStringArray.length;j++)
				{
				if(sub1.get(i).getText().equals(myStringArray[j]))
				{
					n= n+1;
					break;
				}
			}
			}
			Assert.assertEquals(((n>0)&&(n<=myStringArray.length)), true, "Email Batch Operation for Trash failed");
			
		}
		
		@Test(priority=13)
		//Only 3 or less than 3 mails are been batch selected
		public void TestBatchMovetoInboxOfTrashEmail()
		{
			int n=0;

			MailPage m= new MailPage(driver);
		
			List<WebElement> sub=m.GetemailSubjects();
			String[] myStringArray = new String[sub.size()];
			for(int i=0;i<sub.size();i++)
			{
				myStringArray[i]=sub.get(i).getText();
				
			}
			Actions action = new Actions(driver); 
			action.moveToElement(m.batchSelection1()).click().build().perform();
			m.clickSelectAll();
			m.clickUnTrash();
			m.clickMailFilter();
			m.clickUnProcessedFilter();
			List<WebElement> sub1=m.GetemailSubjects();
			for(int i=0;i<sub1.size();i++)
			{
				for(int j=0;j<myStringArray.length;j++)
				{
				if(sub1.get(i).getText().equals(myStringArray[j]))
				{
					n= n+1;
					break;
				}
			}
			}
			Assert.assertEquals(((n>0)&&(n<=myStringArray.length)), true, "Email Batch Move to Inbox from Trash folder got failed");
			
		}
		
		@Test(priority=14)
		//Only 3 or less than 3 mails are been batch selected
		public void TestDeleteForever()
		{
			Boolean flag=false;
			MailPage m= new MailPage(driver);
			m.clickFirstEmail();
			m.clickTrashIcon();
			m.clickMailFilter();
			m.clickTrashFilter();
			List<WebElement> sub=m.GetemailSubjects();
			if(sub.size()==1)
			{
			String subj=sub.get(0).getText();
			System.out.println(subj);
			m.clickFirstEmail();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m.clickDeleteForever();
			
			}
			else
			{
				String subj=sub.get(0).getText();
				System.out.println(subj);
				m.clickFirstEmail();
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				m.clickDeleteForever();
			
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			List<WebElement> sub1=m.GetemailSubjects();
			for(int i=0;i<sub1.size();i++)
			{
				
				if(sub1.get(i).getText().equals(subj))
				{
					System.out.println(sub1.get(i).getText());
					flag=true;
					break;
				}
			}
			
			Assert.assertEquals(flag==false, true, "delete forever of Email is unsucessfully");
			}
			
		}
		
		//@Test(priority=15)
		//Only 3 or less than 3 mails are been batch selected
		public void TestBatchDeleteForever()
		{
			Boolean flag=false;

			MailPage m= new MailPage(driver);
		
			List<WebElement> sub=m.GetemailSubjects();
			String[] myStringArray = new String[sub.size()];
			for(int i=0;i<sub.size();i++)
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
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			m.clickDeleteForever();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
			Assert.assertEquals((flag==false), true, "Batch Email delete forever is unsucessfully");
			
		}


}
