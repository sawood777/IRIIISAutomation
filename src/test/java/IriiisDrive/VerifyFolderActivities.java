package IriiisDrive;

import org.testng.annotations.Test;

import DocumentTestCases.VerifyFolder;
import emailTestCases.BaseTest;

public class VerifyFolderActivities extends BaseTest {
	
	@Test(priority=1)
	public void CreateIriiisFolder(){
		
		VerifyFolder folder=new VerifyFolder(driver);
		folder.CreateFolder("iriiis", "IriiisFolder");
	}
	
	
	@Test(priority=2)
	public void CreategoogleFolder(){
		
		VerifyFolder folder=new VerifyFolder(driver);
		folder.CreateFolder("google", "googleFolder");
	}
	

	@Test(priority=3)
	public void CreateBoxdriveFolder(){
		
		VerifyFolder folder=new VerifyFolder(driver);
		folder.CreateFolder("box", "boxFolder");
	}
	
	@Test(priority=4)
	public void CreatedropboxriveFolder(){
		
		VerifyFolder folder=new VerifyFolder(driver);
		folder.CreateFolder("dropbox", "dropboxFolder");
	}
	
	@Test(priority=5)
	public void CreateonedriveFolder(){
		
		VerifyFolder folder=new VerifyFolder(driver);
		folder.CreateFolder("onedrive", "onedriveFolder");
	}
	
	@Test(priority=6)
	public void RenameIriiisFolder(){
		
		VerifyFolder folder=new VerifyFolder(driver);
		folder.RenameFolderName("iriiis", "IriiisrenamedFolder");
	}
	
	@Test(priority=7)
	public void RenameGoogleFolder(){
		
		VerifyFolder folder=new VerifyFolder(driver);
		folder.RenameFolderName("google", "googlerenamedFolder");
	}
	
	@Test(priority=8)
	public void RenameBoxFolder(){
		
		VerifyFolder folder=new VerifyFolder(driver);
		folder.RenameFolderName("box", "boxrenamedFolder");
	}
	
	@Test(priority=9)
	public void RenamedropboxFolder(){
		
		VerifyFolder folder=new VerifyFolder(driver);
		folder.RenameFolderName("dropbox", "dorpboxrenamedFolder");
	}
	
	@Test(priority=10)
	public void RenameOnedriveFolder(){
		
		VerifyFolder folder=new VerifyFolder(driver);
		folder.RenameFolderName("onedrive", "onerenamedFolder");
	}
	
	

}
