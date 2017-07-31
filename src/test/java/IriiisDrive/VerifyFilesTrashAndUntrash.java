package IriiisDrive;

import org.testng.annotations.Test;

import DocumentTestCases.VerifyTrashandUntrashFile;
import emailTestCases.BaseTest;

public class VerifyFilesTrashAndUntrash extends BaseTest{
	
	
	@Test(priority=1)
	public void VerifyIriiisFileTrash(){
		
		VerifyTrashandUntrashFile Trash=new VerifyTrashandUntrashFile(driver);
		Trash.VerifyTrashFile("iriiis");
	
	}
	
		
	@Test(priority=2)
	public void VerifyGoogleFileTrash(){
		
		VerifyTrashandUntrashFile Trash=new VerifyTrashandUntrashFile(driver);
		Trash.VerifyTrashFile("google");	
	}
	
	@Test(priority=3)
	public void VerifyDropboxFileTrash(){
		
		VerifyTrashandUntrashFile Trash=new VerifyTrashandUntrashFile(driver);
		Trash.VerifyTrashFile("dropbox");	
	}
	
	@Test(priority=4)
	public void VerifyBoxFileTrash(){
		
		VerifyTrashandUntrashFile Trash=new VerifyTrashandUntrashFile(driver);
		Trash.VerifyTrashFile("box");	
	}
	
	@Test(priority=5)
	public void VerifyOnedriveFileTrash(){
		
		VerifyTrashandUntrashFile Trash=new VerifyTrashandUntrashFile(driver);
		Trash.VerifyTrashFile("onedrive");	
	}
	
	
	
}