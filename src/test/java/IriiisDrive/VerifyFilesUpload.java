package IriiisDrive;

import org.testng.annotations.Test;

import DocumentTestCases.Uploaddoc;
import emailTestCases.BaseTest;

public class VerifyFilesUpload extends BaseTest {

	@Test(priority=1)
	public void VerifyIriiisFileUpload(){
		
		Uploaddoc upload=new Uploaddoc(driver);
		upload.SingleFileUpload("iriiis", "iriiis", "D:\\Autoit\\IriiisFile.exe");
	}
	
	@Test(priority=2)
	public void VerifygoogleFileUpload(){
		
		Uploaddoc upload=new Uploaddoc(driver);
		upload.SingleFileUpload2("google", "google", "D:\\Autoitx`\\GoogleFile.exe");
	}
	
	@Test(priority=3)
	public void VerifyboxdriveFileUpload(){
		
		Uploaddoc upload=new Uploaddoc(driver);
		upload.SingleFileUpload2("box", "boxdrive", "D:\\Autoit\\BoxdriveFile.exe");
	}
	
	@Test(priority=4)
	public void VerifydropboxFileUpload(){
		
		Uploaddoc upload=new Uploaddoc(driver);
		upload.SingleFileUpload2("dropbox", "dropbox", "D:\\Autoit\\DropboxFile.exe");
	}
	
	@Test(priority=5)
	public void VerifyonedriveFileUpload(){
		
		Uploaddoc upload=new Uploaddoc(driver);
		upload.SingleFileUpload2("onedrive", "onedrive", "D:\\Autoit\\OnedriveFile.exe");
	}
	
	

}
