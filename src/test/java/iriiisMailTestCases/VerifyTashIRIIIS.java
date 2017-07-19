package iriiisMailTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Pages.MailPage;
import emailTestCases.BaseTest;
import emailTestCases.VerifyTrash;

public class VerifyTashIRIIIS extends BaseTest{
	
	@Test(priority=19)
	public void testMoveToTrashIRIIIS()
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
			if(acc.get(i).getText().contains("@iriiis"))
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
	@Test(dependsOnMethods="testMoveToTrashIRIIIS")
	public void testMovetoInboxOfTrashEmailIRIIIS()
	{ 
		VerifyTrash v= new VerifyTrash(driver);
		v.testMoveToInboxFromTrashListing();
	
	}
	@Test(dependsOnMethods="testMovetoInboxOfTrashEmailIRIIIS")
	public void testBatchMoveToTrashIRIIIS()
	{ 
		VerifyTrash v= new VerifyTrash(driver);
		v.TestBatchMoveToTrash();
	
	}
	@Test(dependsOnMethods="testBatchMoveToTrashIRIIIS")
	public void testBatchMovetoInboxOfTrashIRIIIS()
	{ 
		VerifyTrash v= new VerifyTrash(driver);
		v.TestBatchMovetoInboxOfTrashEmail();
	
	}
	@Test(dependsOnMethods="testBatchMovetoInboxOfTrashIRIIIS")
	public void testDeleteForeverIRIIIS()
	{ 
		VerifyTrash v= new VerifyTrash(driver);
		v.TestDeleteForever();
	
	}
	//@Test(dependsOnMethods="testDeleteForeverGmail")
	//public void testBatchDeleteForeverGmail()
	{ 
		//VerifyTrash v= new VerifyTrash(driver);
		//v.TestBatchDeleteForever();
	
	}

}
