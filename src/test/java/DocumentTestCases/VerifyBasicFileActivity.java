package DocumentTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.DashboardPage;
import Pages.DocumentsPage;

public class VerifyBasicFileActivity {
	
	WebDriver driver;
	
	public VerifyBasicFileActivity(WebDriver driver){
		
		this.driver=driver;
	}
	
	
	public void RenameFile(String driveanme, String EnterFileName){
		Boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		DocumentsPage doc=new DocumentsPage(driver);
		
		d.clickDocumentCard();
		doc.ClickonDrive();
		doc.SleepFiveSec();
		doc.hoveronAllAccounts();
		doc.SleepThreeSec();
		doc.ClickonRequiredAccount(driveanme);
		
		String filename=doc.Filename();
		System.out.println("before refilename is "+ filename);
		doc.SleepThreeSec();
		
		doc.clickelipse();
		doc.ClickOnRename();
		doc.EnterFileName(EnterFileName);
		String newfilename=EnterFileName;
		doc.ClickOnFilesave();
		doc.SleepFiveSec();
		
		String FilenameAfterRename=doc.Filename();
		System.out.println("After rename filename is "+ FilenameAfterRename);
		
		
		if(FilenameAfterRename.startsWith(newfilename)){
			System.out.println("File rename is scuccessfull");
			flag=true;
		}
		
		doc.clickonCloseIcon();
		
		Assert.assertEquals(flag==true, true, "failed to rename the file");
		
	}
	
	public void UpdateDesc(String driveanme, String EnterFileDesc){
		
		Boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		DocumentsPage doc=new DocumentsPage(driver);
		
		d.clickDocumentCard();
		doc.ClickonDrive();
		doc.SleepFiveSec();
		doc.hoveronAllAccounts();
		doc.SleepThreeSec();
		doc.ClickonRequiredAccount(driveanme);
		
		//String filename=doc.Filename();
		//System.out.println("before refilename is "+ filename);
		doc.SleepThreeSec();
		
		doc.clickelipse();
		
		doc.ClickOnUpdateDesc();
		doc.EnterFileDesc(EnterFileDesc);
		String filedesc=EnterFileDesc;
		System.out.println("My Description is "+ filedesc);
		doc.ClickOnFilesave();
		doc.SleepFiveSec();
		doc.clickelipse();
		doc.ClickOnViewDetails();
		
		String MyEnteredDesc=doc.GetDescDetails();
		
		if(MyEnteredDesc.contains(filedesc)){
			System.out.println("File Desc is updated scuccessfull"+ MyEnteredDesc);
			flag=true;
		}
		
		doc.clickonCloseIcon();
		doc.SleepThreeSec();
		
		Assert.assertEquals(flag==true, true, "failed to rename the file");
		
		
	}

}
