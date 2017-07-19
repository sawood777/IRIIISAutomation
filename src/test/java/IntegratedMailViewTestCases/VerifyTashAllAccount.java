package IntegratedMailViewTestCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Pages.MailPage;
import emailTestCases.BaseTest;
import emailTestCases.VerifyTrash;

public class VerifyTashAllAccount extends BaseTest{
	
	@Test(priority=19)
	public void testMoveToTrashAllAccount()
	{
		MailPage m= new MailPage(driver);
		VerifyTrash v= new VerifyTrash(driver);
		m.clickmailCard();
		v.testMoveToTrash();
		}
	@Test(dependsOnMethods="testMoveToTrashAllAccount")
	public void testMovetoInboxOfTrashEmailAllAccount()
	{ 
		VerifyTrash v= new VerifyTrash(driver);
		v.testMoveToInboxFromTrashListing();
	
	}
	@Test(dependsOnMethods="testMovetoInboxOfTrashEmailAllAccount")
	public void testBatchMoveToTrashAllAccount()
	{ 
		VerifyTrash v= new VerifyTrash(driver);
		v.TestBatchMoveToTrash();
	
	}
	@Test(dependsOnMethods="testBatchMoveToTrashAllAccount")
	public void testBatchMovetoInboxOfTrashAllAccount()
	{ 
		VerifyTrash v= new VerifyTrash(driver);
		v.TestBatchMovetoInboxOfTrashEmail();
	
	}
	@Test(dependsOnMethods="testBatchMovetoInboxOfTrashAllAccount")
	public void testDeleteForeverAllAccount()
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
