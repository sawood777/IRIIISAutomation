package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	@FindBy(xpath="//p[@class='auth__link']/a")private WebElement signup;
	@FindBy(id="firstname")private WebElement firstname;
	@FindBy(id="secondname")private WebElement lastname;
	@FindBy(id="username")private WebElement username;
	@FindBy(id="email")private WebElement emailAddress;
	@FindBy(id="password")private WebElement password;
	@FindBy(xpath="//button[@type='submit']/span[text()='Create']")private WebElement create;
	@FindBy(xpath="//span[text()='Done']")private WebElement done;
	@FindBy(id="signInUsername")private WebElement signInUsername;
	@FindBy(id="signInPassword")private WebElement signInPassword;
	@FindBy(xpath="//button[@type='submit']/span[text()='Sign in']")private WebElement signin;
	@FindBy(xpath="//span[text()='M']/..")private WebElement openitems;
	@FindBy(xpath="//md-icon[text()='person']/..")private WebElement profileIcon;
	@FindBy(xpath="//*[@id='menu_container_12']/md-menu-content/md-menu-item[5]/button/div")private WebElement signout;
	
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		}
	public void enterSignInUsername(String uname)
	{
		signInUsername.clear();
		signInUsername.sendKeys(uname);
	}
	public void enterSignInPassword(String pass)
	{
		signInPassword.clear();
		signInPassword.sendKeys(pass);
	}
	public void clickSignin()
	{
		signin.click();
	}
	public void clickProfileIcon()
	{
		profileIcon.click();
	}
	public void clickSignout()
	{
		signout.click();
	}
	
	
}
