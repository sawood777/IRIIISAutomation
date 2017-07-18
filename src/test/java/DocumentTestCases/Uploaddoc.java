/*package DocumentTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import Pages.DashboardPage;
import Pages.DocumentsPage;
import emailTestCases.BaseTest;

public class Uploaddoc extends BaseTest {
	
	
	@Test(priority=1)
	public void SingleFileUpload() throws Exception
	{
		Boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		DocumentsPage doc=new DocumentsPage(driver);
		d.clickDocumentCard();
		Thread.sleep(5000);
		doc.uploadFile();
		doc.SelectFromComp();
		Thread.sleep(5000);
		logger.log(LogStatus.PASS, "File is uploaded");
		doc.closebutton();
		doc.VerifyFile();
	}
	
	@Test(priority=2)
	public void multifileupload() throws Exception{
		Boolean flag=false;
		DocumentsPage doc=new DocumentsPage(driver);
		doc.uploadFile();
		doc.SelectFromComp();
		doc.clickAddmore();
		doc.SelectFromComp2();
		Thread.sleep(5000);
		doc.closebutton();
		doc.VerifyFile2();	
	}
	
	
	
	
		

}*/
