package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class Loginpage {
	WebDriver driver;
	
	
	public Loginpage(WebDriver Idriver){
		
		this.driver=Idriver;
	}
	
	
	@FindBy(id="signInUsername") WebElement Userid;
	@FindBy(id="signInPassword") WebElement Userpwd;
	@FindBy(xpath="/html/body/div[2]/div/div/div[1]/div[1]/form/button") WebElement SignIn;
	@FindBy(xpath="/html/body/div[2]/div/div/div[2]/div/div[1]/div[2]/md-menu/button/md-icon") WebElement Profile;
	@FindBy(xpath="//div/md-menu-content/md-menu-item[5]/button") WebElement Singout;
	
	
	public void ClickLogin(String username, String Pwd){
		Userid.sendKeys(username);
		Userpwd.sendKeys(Pwd);
		SignIn.click();
	}
	
	public void Verifytitle(){
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.urlMatches("https://iriiisdev.com/#!/Macro/d"));
		String currenturl=driver.getCurrentUrl();
		System.out.println("the current url is "+ currenturl);
		Assert.assertEquals(currenturl, "https://iriiisdev.com/#!/Macro/d");
		
	}
	
	public void Verifytitle25(){
		//wait.until(ExpectedConditions.titleContains("IRIIIS"));
		System.out.println("title is "+ driver.getTitle());
	}
	
	public void singout(){

		Profile.click();
		Singout.click();
		
	}
	
	
	
	  

}
