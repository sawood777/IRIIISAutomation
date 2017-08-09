package DocumentTestCases;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Pages.DashboardPage;
import Pages.DocumentsPage;


public class VerifyFolder {

	WebDriver driver;
	public VerifyFolder(WebDriver driver){
		this.driver=driver;
	}
	
	public void CreateFolder(String drivername, String Foldername){
		

		Boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		DocumentsPage doc=new DocumentsPage(driver);
		d.clickDocumentCard();
		
		doc.ClickonDrive();
		doc.SleepFiveSec();
		doc.hoveronAllAccounts();
		doc.SleepThreeSec();
		doc.ClickonRequiredAccount(drivername);
		
		doc.ClickonFileAdd();
		doc.ClickOnCreateFolderIcon();
		doc.EnterFolderName(Foldername);
		doc.ClickOnfolderCreateBtn();
		doc.SleepThreeSec();
		
		String Nameoffolder=doc.FolderName();
		System.out.println("folder anme is "+ Nameoffolder);
		
		if(Nameoffolder.contains(Foldername)){
			flag=true;
		}
		
		doc.clickonCloseIcon();
		doc.SleepThreeSec();
		
		Assert.assertEquals(flag==true, true, "unable to create folder");
	
	}
	
	
	public void RenameFolderName(String drivername, String FolderRename){
		Boolean flag=false;
		DashboardPage d= new DashboardPage(driver);
		DocumentsPage doc=new DocumentsPage(driver);
		d.clickDocumentCard();
		
		doc.ClickonDrive();
		doc.SleepFiveSec();
		doc.hoveronAllAccounts();
		doc.SleepThreeSec();
		doc.ClickonRequiredAccount(drivername);
		
		doc.clickFolderelipse();
		doc.ClickOnRename();
		doc.EnterFileName(FolderRename);
		doc.ClickOnFilesave();
		doc.SleepFiveSec();
		String Nameofrenamedfolder=doc.FolderName();
		System.out.println("folder anme is "+ Nameofrenamedfolder);
		
		if(Nameofrenamedfolder.contains(FolderRename)){
			flag=true;
		}
		
		doc.clickonCloseIcon();
		doc.SleepThreeSec();
		
		Assert.assertEquals(flag==true, true, "unable to create folder");
		
	}
	
}
