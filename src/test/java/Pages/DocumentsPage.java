package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DocumentsPage {
	WebDriver driver; 
	
	@FindBy(xpath="//md-icon[@class='ng-scope md-font material-icons add']")private WebElement FileAdd;
	@FindBy(xpath="//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item[2]/button")private WebElement FileUpload;
	@FindBy(xpath="//dock-modal/dock-modal-content/div[2]/dropzone/div/div/button")private WebElement SelectFromComp;
	@FindBy(xpath="//dock-modal/dock-modal-header/button[2]/md-icon")private WebElement Closebutton;
	@FindBy(xpath="//div[contains(text(),'zyx')]")private WebElement FileName;
	@FindBy(xpath="//div[contains(text(),'IRIIIS')]")private WebElement FileName2;
	//@FindBy(xpath="//div[@class='file-list__items ng-isolate-scope flex']/div/div/div[2]/div")private WebElement FileName;
	@FindBy(linkText="Add more")private WebElement Addmore;
	@FindBy(xpath="//button/img[@src='img/dropbox.png']")private WebElement dropboxlink;
	@FindBy(xpath="//button/img[@src='img/iriiis_logo.png']")private WebElement iriiislink;
	@FindBy(xpath="//button/img[@src='img/google_drive.png']")private WebElement googledrivelink;
	@FindBy(xpath="//button/img[@src='img/one_drive.png']")private WebElement onedrivelink;
	@FindBy(xpath="//button/img[@src='img/box.png']")private WebElement boxdrive;
	@FindBy(xpath="//button[@class='accounts-dropdown__top-btn']")private WebElement DriveDropdown;
	@FindBy(xpath="//span[text()='Accounts']/following::md-menu-item/md-menu/button[@ng-click='$mdOpenMenu()']")private WebElement Allaccuntslink;
	@FindAll({@FindBy(xpath="//div[@class='file-list__item-cell']/div")})private List<WebElement> AllFileNames;
	@FindAll({@FindBy(xpath="//li[@class='topic-selector__list-item ng-scope']")}) private List<WebElement> topicListInTagToTopic;
	@FindBy(xpath="//i[@class='material-icons ng-scope']")private WebElement elipseIcon;
	@FindBy(xpath="//div[@class='file-list__item-cell']/div")private WebElement FirstFileName;
	@FindBy(xpath="//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item[5]/button")private WebElement TagToTopic;
	@FindBy(xpath="//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item[3]/button")private WebElement ShareToTopic;
	@FindBy(xpath="//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item[10]/button")private WebElement TrashFile;
	@FindBy(xpath="//button[contains(text(),'Save')]")private WebElement topicSave;
	@FindAll({@FindBy(xpath="//div[1]/md-checkbox/div[1]")})private List<WebElement> DocBatchselection;
	@FindBy(xpath="//md-menu/button[text()='Drive']")private WebElement Drivebutton1;
	@FindBy(xpath="//md-menu-item/button[text()='Drive']")private WebElement Drivebutton2;
	@FindBy(xpath="//md-menu-content/md-menu-item[2]/button[text()='Trash']")private WebElement TrashButton2;
	@FindBy(xpath="//button[text()='Trash']")private WebElement TrashButton1;
	@FindBy(xpath="//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item/button")private WebElement UntrashIcon;
	@FindBy(xpath="//md-icon[@aria-label='remove_circle']")private WebElement ClosePage;
	
	public DocumentsPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	

	
	public void ClickonDrive(){
		
		DriveDropdown.click();
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
		
	}
	
	public void hoveronAllAccounts(){
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOf(Allaccuntslink));
		Actions action=new Actions(driver);
		action.moveToElement(Allaccuntslink).build().perform();
		action.click();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='All accounts']")));
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}
	}
	
	public void ClickonRequiredAccount(String drivename){
		if(drivename.equalsIgnoreCase("iriiis")){
			iriiislink.click();
		}
		else if(drivename.equalsIgnoreCase("google")){
			googledrivelink.click();
		}
		else if(drivename.equalsIgnoreCase("box")){
			boxdrive.click();
		}
		else if(drivename.equalsIgnoreCase("dropbox")){
			dropboxlink.click();
		}
		else if(drivename.equalsIgnoreCase("onedrive")){
			onedrivelink.click();
		}	
	}
	
	public List<WebElement> getTopicListInTagToTopic()
	{
		return (new WebDriverWait(driver, 20)).until(ExpectedConditions.visibilityOfAllElements(topicListInTagToTopic));
	}
	
	public String Filename(){
		
		String FileName=FirstFileName.getText();
		return FileName;
	}
	
	
	public void clickelipse(){
		elipseIcon.click();
	}
	
	public void clickTagtoTopic(){
		TagToTopic.click();
	}
	
	public void clickSharetoTopic(){
		ShareToTopic.click();
	}
	
	
	public List<WebElement> GetAllFileNames()
	{
		return (new WebDriverWait(driver, 20))
		   .until(ExpectedConditions.visibilityOfAllElements(AllFileNames));
		
	}
	
	public void ClickSelectBacthfiles(){
		
		int size=DocBatchselection.size();
		System.out.println("total number of files"+ size);
		for(int i=0; i<=3; i++){
		DocBatchselection.get(i).click();
			
		}
	}
	
	public void NavigateToDrive(){
		Actions action=new Actions(driver);
		action.moveToElement(Drivebutton1).build().perform();
		action.click();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {

		}

	}
	
	public void clickDrivebutton2(){
		Drivebutton2.click();
	}
	
	public void ClickOnTrashFile(){
	  TrashFile.click();
	}
	
	public void NavigateToTrash(){
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-menu/button[text()='Drive']"))).click();
		System.out.println("Drive button is clicked");
		//Drivebutton1.click();
		
		//Actions action1=new Actions(driver);
		//action1.moveToElement(Drivebutton1).build().perform();
		//action1.click(Drivebutton1);
		
	}
	
	public void clickonTrashButton2(){
		
		TrashButton2.click();
	}
	
	public void clickonCloseIcon(){
		ClosePage.click();
	}
	
  
  
  
	
	
/*	public void uploadFile(){
		FileAdd.click();
		FileUpload.click();
		SelectFromComp.click();	
	}
	
	public void SelectFromComp(){
		
		Screen screen=new Screen();
		
		Pattern image1=new Pattern("C://Users//Sawood Pasha//Desktop//images//NewFile.PNG");
		
		Pattern image2=new Pattern("C://Users//Sawood Pasha//Desktop//images//Open.PNG");
		
		try {
			screen.click(image1);
			screen.type(image1, "C:\\Users\\Sawood Pasha\\Desktop\\zyx.docx");
			screen.click(image2);
			
		} catch (FindFailed e) {
		}	
	}
	
	public void closebutton(){
		
		Closebutton.click();
	}
	
	public void VerifyFile(){
		String myfile=FileName.getText();
		System.out.println(myfile);
		if(myfile.contains("zyx")){
			
			System.out.println("file is uploaded");
		}
		else{
			System.out.println("Fail to upload the file");
		}
		
	}
	
	public void VerifyFile2(){
		String myfile=FileName.getText();
		String myfile2=FileName2.getText();
		System.out.println(myfile);
		System.out.println(myfile2);
		if(myfile.contains("zyx")&& myfile2.contains("IRIIIS") ){
			
			System.out.println("files are uploaded");
		}
		else{
			System.out.println("Fail to upload the files");
		}
		
	}
	
	public void clickAddmore(){
		Addmore.click();
	}
	
	public void SelectFromComp2(){
		
		Screen screen=new Screen();
		
		Pattern image1=new Pattern("C://Users//Sawood Pasha//Desktop//images//NewFile.PNG");
		
		Pattern image2=new Pattern("C://Users//Sawood Pasha//Desktop//images//Open.PNG");
		
		try {
			screen.click(image1);
			screen.type(image1, "C:\\Users\\Sawood Pasha\\Desktop\\IRIIIS Points zyx.docx");
			screen.click(image2);
			
		} catch (FindFailed e) {
		}	
	}*/
	

}
