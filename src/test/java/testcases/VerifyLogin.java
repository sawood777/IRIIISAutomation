package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import Pages.LoginPage;

public class VerifyLogin 
{
	
	@DataProvider
	public Object[][] getData()
	{
	//Rows - Number of times your test has to be repeated.
	//Columns - Number of parameters in test data.
	Object[][] data = new Object[4][2];

	// 1st row
	data[0][0] ="praveen.kumar21";
	data[0][1] = "Praveen@1";

	// 2nd row
	data[1][0] ="praveen.kumar41";
	data[1][1] = "Praveen@1";
	
	// 3rd row
	data[2][0] ="praveen.kumar88";
	data[2][1] = "Praveen@1";

	data[3][0] ="praveen.kumar21";
	data[3][1] = "Praveen@123";
	
	return data;
	}
	//@Test(dataProvider="getData")
	public void testLogin(String uname,String pword,WebDriver driver) 
	{
		LoginPage l = new LoginPage(driver);
		
		l.enterSignInUsername(uname);
		l.enterSignInPassword(pword);
		l.clickSignin();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		//@Test
		public void testLogOut(WebDriver driver) 
		{
			LoginPage l1 = new LoginPage(driver);
		if(driver.getCurrentUrl().equals("https://iriiis.com/#!/auth"))
		{
			
		}
		
		else
		{
			l1.clickProfileIcon();
			l1.clickSignout();
		}
}

}
