package IriiisDrive;

import org.testng.annotations.Test;

import DocumentTestCases.VerifyBasicFileActivity;
import emailTestCases.BaseTest;

public class VerifyRenamingTheFilesName extends BaseTest{
	
	@Test(priority=1)
	public void VerifygoogleFileRename(){
		
		VerifyBasicFileActivity file=new VerifyBasicFileActivity(driver);
		file.RenameFile("google", "tesdrive2");
	}
	
	@Test(priority=2)
	public void VerifyBoxFileRename(){
		
		VerifyBasicFileActivity file=new VerifyBasicFileActivity(driver);
		file.RenameFile("box", "boxcehck2");
	}
	
	@Test(priority=3)
	public void VerifyBoxDriveFileRename(){
		
		VerifyBasicFileActivity file=new VerifyBasicFileActivity(driver);
		file.RenameFile("dropbox", "boxdrivecehck2");
	}
	
	@Test(priority=4)
	public void VerifyOneDriveFileRename(){
		
		VerifyBasicFileActivity file=new VerifyBasicFileActivity(driver);
		file.RenameFile("onedrive", "OneDrive1");
	}
	
	@Test(priority=5)
	public void VerifyIriisFileRename(){
		
		VerifyBasicFileActivity file=new VerifyBasicFileActivity(driver);
		file.RenameFile("iriiis", "iriiis2");
	}


}
