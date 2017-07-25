package IriiisDrive;

import org.testng.annotations.Test;

import DocumentTestCases.VerifyFileTaging;
import Pages.IriiisLogoPage;
import emailTestCases.BaseTest;

public class VerifyIriiisFileTaging extends BaseTest {
	
	@Test(priority=1)
	public void VerifyIriiisTag(){
		VerifyFileTaging select=new VerifyFileTaging(driver);
		select.SelectAccount("iriiis");
	}
	
	@Test(priority=2)
	public void VerifgoogleTag(){
		VerifyFileTaging select=new VerifyFileTaging(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		iriiis.clickIriiisLog();
		iriiis.clickMacroView();
		select.SelectAccount("google");
	}
	
	@Test(priority=3)
	public void VerifboxdriveTag(){
		VerifyFileTaging select=new VerifyFileTaging(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		iriiis.clickIriiisLog();
		iriiis.clickMacroView();
		select.SelectAccount("box");
	}

	@Test(priority=4)
	public void VerifdropboxdriveTag(){
		VerifyFileTaging select=new VerifyFileTaging(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		iriiis.clickIriiisLog();
		iriiis.clickMacroView();
		select.SelectAccount("dropbox");
	}
	
	@Test(priority=5)
	public void VerifonedriveTag(){
		VerifyFileTaging select=new VerifyFileTaging(driver);
		IriiisLogoPage iriiis=new IriiisLogoPage(driver); 
		iriiis.clickIriiisLog();
		iriiis.clickMacroView();
		select.SelectAccount("onedrive");
	}

	
	
}
