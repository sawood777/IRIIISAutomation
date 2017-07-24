package IriiisDrive;

import org.testng.annotations.Test;

import DocumentTestCases.VerifyFileTaging;
import emailTestCases.BaseTest;

public class VerifyIriiisFileTaging extends BaseTest {
	
	@Test
	public void VerifyIriiisTag(){
		VerifyFileTaging select=new VerifyFileTaging(driver);
		select.SelectAccount("iriiis");
	}

}
