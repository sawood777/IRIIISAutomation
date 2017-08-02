package IriiisDrive;

import org.testng.annotations.Test;

import DocumentTestCases.VerifyBasicFileActivity;
import emailTestCases.BaseTest;

public class VerifyTheFileDeletes extends BaseTest {
	
	@Test(priority=1)
	public void VerifyIriiisFileDelete(){
		
		VerifyBasicFileActivity remove=new VerifyBasicFileActivity(driver);
		remove.VeryFileRemove("iriiis");
	}
	
	@Test(priority=2)
	public void VerifyBoxdriveFileDelete(){
		
		VerifyBasicFileActivity remove=new VerifyBasicFileActivity(driver);
		remove.VeryFileRemove2("box");
	}
	
	@Test(priority=3)
	public void VerifygoogleFileDelete(){
		
		VerifyBasicFileActivity remove=new VerifyBasicFileActivity(driver);
		remove.VeryFileRemove2("google");
	}
	
	
	//@Test(priority=4)
	public void VerifyDropboxFileDelete(){
		
		VerifyBasicFileActivity remove=new VerifyBasicFileActivity(driver);
		remove.VeryFileRemove2("dropbox");
	}
	
	//@Test(priority=5)
	public void VerifyOneDriveFileDelete(){
		
		VerifyBasicFileActivity remove=new VerifyBasicFileActivity(driver);
		remove.VeryFileRemove2("onedrive");
	}
	
	

}
