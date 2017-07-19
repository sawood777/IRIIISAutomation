package GmailTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Pages.MailPage;
import emailTestCases.BaseTest;
import emailTestCases.VerifyTrash;

public class VerifyTashGmail extends BaseTest{
	
	@Test(priority=19)
	public void testMoveToTrashGmail()
	{
		MailPage m= new MailPage(driver);
		VerifyTrash v= new VerifyTrash(driver);
		m.clickmailCard();
		m.clickMailFilter();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Actions action = new Actions(driver); 
		 action.moveToElement(m.hoverAllaccount()).build().perform();
		 try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> acc = m.getAccountList();
		for(int i=0;i<acc.size();i++)
		{
			if(acc.get(i).getText().contains("@gmail.com"))
			{
			acc.get(i).click();
			break;
			}
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		v.testMoveToTrash();
		}
	@Test(dependsOnMethods="testMoveToTrashGmail")
	public void testMovetoInboxOfTrashEmailGmail()
	{ 
		VerifyTrash v= new VerifyTrash(driver);
		v.testMoveToInboxFromTrashListing();
	
	}
	@Test(dependsOnMethods="testMovetoInboxOfTrashEmailGmail")
	public void testBatchMoveToTrashGmail()
	{ 
		VerifyTrash v= new VerifyTrash(driver);
		v.TestBatchMoveToTrash();
	
	}
	@Test(dependsOnMethods="testBatchMoveToTrashGmail")
	public void testBatchMovetoInboxOfTrashGmail()
	{ 
		VerifyTrash v= new VerifyTrash(driver);
		v.TestBatchMovetoInboxOfTrashEmail();
	
	}
	@Test(dependsOnMethods="testBatchMovetoInboxOfTrashGmail")
	public void testDeleteForeverGmail()
	{ 
		VerifyTrash v= new VerifyTrash(driver);
		v.TestDeleteForever();
	
	}
	@Test(dependsOnMethods="testDeleteForeverGmail")
	public void testBatchDeleteForeverGmail()
	{ 
		//VerifyTrash v= new VerifyTrash(driver);
		//v.TestBatchDeleteForever();
	
	}

}
