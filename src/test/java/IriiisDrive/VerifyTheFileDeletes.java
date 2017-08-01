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
	
	@Test(dependsOnMethods="VerifyIriiisFileDelete")
	public void VerifyBoxdriveFileDelete(){
		
		VerifyBasicFileActivity remove=new VerifyBasicFileActivity(driver);
		remove.VeryFileRemove2("box");
	}
	
	@Test(dependsOnMethods="VerifyBoxdriveFileDelete")
	public void VerifygoogleFileDelete(){
		
		VerifyBasicFileActivity remove=new VerifyBasicFileActivity(driver);
		remove.VeryFileRemove2("google");
	}
	
	
	//@Test(dependsOnMethods="VerifyIriiisFileDelete")
	public void VerifyDropboxFileDelete(){
		
		VerifyBasicFileActivity remove=new VerifyBasicFileActivity(driver);
		remove.VeryFileRemove2("dropbox");
	}
	
	//@Test(dependsOnMethods="VerifyIriiisFileDelete")
	public void VerifyOneDriveFileDelete(){
		
		VerifyBasicFileActivity remove=new VerifyBasicFileActivity(driver);
		remove.VeryFileRemove2("onedrive");
	}
	
	

}
