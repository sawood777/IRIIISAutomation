package Pages;

import java.util.List;

import javax.print.Doc;

import org.openqa.selenium.Alert;
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
	@FindBy(xpath="//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item/button")private WebElement Createfolder;
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
	@FindBy(xpath="//md-menu[contains(@class,'accounts-dropdown md-menu ng-scope _md')]")private WebElement DriveDropdown;
	@FindBy(xpath="//span[text()='Accounts']/following::md-menu-item/md-menu/button[@ng-click='$mdOpenMenu()']")private WebElement Allaccuntslink;
	//@FindAll({@FindBy(xpath="//div[@class='file-list__item-cell']/div")})private List<WebElement> AllFileNames;
	@FindAll({@FindBy(xpath="//div[contains(text(), 'KB') or contains(text(), 'MB')]/preceding::div[2]")})private List<WebElement> AllFileNames;
	
	@FindAll({@FindBy(xpath="//li[@class='topic-selector__list-item ng-scope']")}) private List<WebElement> topicListInTagToTopic;
	//@FindBy(xpath="//i[@class='material-icons ng-scope']")private WebElement elipseIcon;
	@FindBy(xpath="//div[contains(text(), 'KB') or contains(text(), 'MB')]/following::div/md-menu/button/i[@class='material-icons ng-scope']")private WebElement elipseIcon;
	
	@FindBy(xpath="//div[contains(text(), '-')]/following::div/md-menu/button/i[@class='material-icons ng-scope']")private WebElement FolderelipseIcon;
	
	
	
//	@FindBy(xpath="//div[@class='file-list__item-cell']/div")private WebElement FirstFileName;
	@FindBy(xpath="//div[contains(text(), 'KB') or contains(text(), 'MB')]/preceding::div[2]")private WebElement FirstFileName;
	
	@FindBy(xpath="//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item[5]/button[text()='Tag topics']")private WebElement TagToTopic;
	@FindBy(xpath="//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item[3]/button[text()='Share to Topics']")private WebElement ShareToTopic;
	@FindBy(xpath="//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item/button[text()='Trash']")private WebElement TrashFile;

	@FindBy(xpath="//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item/button[text()='Rename']")private WebElement RenameFile;
	@FindBy(xpath="//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item/button[text()='Update Description']")private WebElement UpdateDesc;
	@FindBy(xpath="//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item[1]/button[text()='View Details']")private WebElement ViewDetails;
	@FindBy(xpath="//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item[1]/button[text()='Move To']")private WebElement MoveTo;
	@FindBy(xpath="//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item/button[text()='Copy To']")private WebElement CopyTo;
	@FindAll({@FindBy(xpath="//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item/button")})private List<WebElement> ListOfMenuContents;

	@FindBy(xpath="//button[contains(text(),'Save')]")private WebElement topicSave;
	
	@FindBy(xpath="//button[text()='Drive']")private WebElement Drivebutton1;
	
	@FindBy(xpath="//md-menu[contains(@class,'_md-nested-menu md-menu ng-scope _md')]")private WebElement Drivebutton2;
	@FindAll({@FindBy(xpath="//md-menu-item[@ng-repeat='folder in folders']")})private List<WebElement> TrashButton2;
	@FindBy(xpath="//button[text()='Trash']")private WebElement TrashButton1;
	@FindBy(xpath="//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item/button[text()='Untrash']")private WebElement UntrashIcon;
	@FindBy(xpath="//div[@class='_md md-open-menu-container md-whiteframe-z2 md-active md-clickable']/md-menu-content/md-menu-item/button[text()='Remove']")private WebElement RemoveIcon;
	@FindBy(xpath="//md-icon[@aria-label='remove_circle']")private WebElement ClosePage;
	@FindBy(name="name") WebElement RenameField;
	///*[@name='name']
	@FindBy(xpath="//button[text()=' Save ']")private WebElement SaveFile;
	@FindBy(xpath="//div/textarea[@name='description']")private WebElement UpdateDescField;
	@FindBy(xpath="//div/div[8]")private WebElement DescDetails;
	@FindBy(xpath="//span/span[text()='Trash']")private WebElement TrashMainBtn;
	@FindBy(xpath="//button[text()='Trash']")private WebElement SubTrashBtn;
	@FindBy(xpath="//md-menu-content/md-menu-item[2]/md-menu/button")private WebElement ChangeAccount;
	@FindBy(xpath="//md-icon[@md-font-icon='delete']")private WebElement MoveToTrashBtn;
	@FindBy(xpath="//md-icon[@md-font-icon='undo']")private WebElement UndoBtn;
	@FindBy(xpath="//md-icon[@md-font-icon='delete_forever']")private WebElement DeleteForeverBtn;
	
	//@FindBy(xpath="//div[@class='file-list__item-cell ng-scope']")private WebElement BatchCheck;
	@FindBy(xpath="//div[contains(text(), 'KB') or contains(text(), 'MB')]/preceding::div[4]")private WebElement BatchCheck;
	
	//@FindAll({@FindBy(xpath="//div[1]/md-checkbox")})private List<WebElement> DocBatchselection;
	@FindAll({@FindBy(xpath="//div[contains(text(), 'KB') or contains(text(), 'MB')]/preceding::div[8]")})private List<WebElement> DocBatchselection;
	//div[contains(text(), 'KB')]/preceding::div[8]
	
	@FindBy(xpath="//button[text()=' Select All ']")private WebElement SelectAllBtn;
	
	@FindBy(xpath="//div/span[contains(text(),'No files')]")private WebElement TextAfterDelet;
	@FindBy(xpath="//div/span[@class='file__name file__name--blue ng-binding']")private WebElement FileStatus;
	@FindBy(xpath="//*[@name='folderName']")private WebElement FolderNamefiled;
	@FindBy(xpath="//md-dialog-actions/button[2]")private WebElement FolderCreateButn;
	@FindBy(xpath="//div[contains(text(), 'KB')]/preceding::div[2]")private WebElement Files;
	@FindBy(xpath="//div[@class='file-list__item-cell ng-binding'][contains(text(), '-')]/preceding::div[2]")private WebElement AllFolder;
	
	@FindAll({@FindBy(xpath="//md-list-item[@ng-repeat='folder in folders']/div[@ng-click='selectFolder(folder)']")})private List<WebElement> ListOfFolders;
	
	
	public void draganddrop(){
		Actions act=new Actions(driver);
		act.dragAndDrop(FirstFileName, AllFolder).build().perform();
	}
	
	
	public List<WebElement> GetAllListOfMenuContents()
	{
		return (new WebDriverWait(driver, 20))
		   .until(ExpectedConditions.visibilityOfAllElements(ListOfMenuContents));

	}
	
	public void GetlisofcontentnameandClick(String ContentName){
		int sizeofcontect=ListOfMenuContents.size();
		
		for(int i=0; i<=sizeofcontect; i++){
			//System.out.println("Names are" + ListOfMenuContents.get(i).getText());
			if(ListOfMenuContents.get(i).getText().equalsIgnoreCase(ContentName)){
				System.out.println(ListOfMenuContents.get(i).getText());
				ListOfMenuContents.get(i).click();
				break;
			}
		
		}
	}
	
	
	public List<WebElement> GetAllFolderNames()
	{
		return (new WebDriverWait(driver, 20))
		   .until(ExpectedConditions.visibilityOfAllElements(ListOfFolders));
		
	}
	
	public void OpenFolder(){
		Actions act=new Actions(driver);
		act.doubleClick(AllFolder).build().perform();
	}
	
	
	public void scrolldownpage(){
		//((JavascriptExecutor)driver).executeScript("scroll(0,400)");
	}
	
	public void ClickOnfolderCreateBtn(){
		FolderCreateButn.click();
	}
	
	public void EnterFolderName(String Foldername){
		FolderNamefiled.clear();
		FolderNamefiled.sendKeys(Foldername);
	}
	
	

	public void filestatus(){
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/span[@class='file__name file__name--blue ng-binding']")));
	}

	public void acceptalert(){
		WebDriverWait wait=new WebDriverWait(driver, 10);
		if((ExpectedConditions.alertIsPresent().apply(driver))==null){
				System.out.println("alert is not present");
		}
		
		else{
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
			
			try {
				Thread.sleep(9000);
			} catch (InterruptedException e) {
				
			}
			
		Closebutton.click();	
		
			}  
		
	}
	
	
	public String GetTextAfterTrash(){
		String TextAfterFilesTras=TextAfterDelet.getText();
		return TextAfterFilesTras;
	}
	public void ClickBatchCheck(){
		Actions action=new Actions(driver);
		action.moveToElement(BatchCheck).build().perform();
		//BatchCheck.click();
	}
	
	public void ClickBatchCheck1(){
		BatchCheck.click();
		//BatchCheck.click();
	}
	
public void ClickSelectBacthfiles(){
		
		int size=DocBatchselection.size();
		System.out.println("total number of files"+ size);
		for(int i=0; i<=3; i++){
		DocBatchselection.get(i).click();
			
		}
	}


	public void ClickOnSelectAllBtn(){
		SelectAllBtn.click();
	}
	
	public DocumentsPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void ClickOnMoveToTrashBtn(){
		MoveToTrashBtn.click();
	}
	
	public void ClickOnUndoBtn(){
		UndoBtn.click();
	}
	
	public void ClickOnDeleteForeverBtn(){
		DeleteForeverBtn.click();
	}

	
	public void ClickonDrive(){
		
		DriveDropdown.click();

	}
	
	public void hoveronAllAccounts(){
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.visibilityOf(Allaccuntslink));
		
		Actions action=new Actions(driver);
		action.moveToElement(Allaccuntslink).build().perform();
		//action.click();
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
	
	public String FolderName(){
		
		String FileName=AllFolder.getText();
		return FileName;
	}
	
	
	
	
	public void clickelipse(){
		elipseIcon.click();
	}
	
	public void clickFolderelipse(){
		FolderelipseIcon.click();
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
	
	
	
	public void NavigateToDrive(){
		//Actions action=new Actions(driver);
		//action.moveToElement(Drivebutton1).build().perform();
		//action.click();
		
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
	
	public WebElement NavigateToTrash(){
		return (new WebDriverWait(driver, 20))
			   .until(ExpectedConditions.visibilityOf(Drivebutton1));
		
	}
	
	
	public List<WebElement> clickonTrashButton2(){
		
		return TrashButton2;
	}
	
	public void clickonCloseIcon(){
		ClosePage.click();
	}
	
	public void ClickOnRename(){
		RenameFile.click();
	}
  
  public void EnterFileName(String EnterFileName){
	  RenameField.clear();
	  RenameField.sendKeys(EnterFileName);
	  
  }
  
  public void ClickOnFilesave(){
	  SaveFile.click();
  }
  
  public void ClickOnUpdateDesc(){
	  UpdateDesc.click();
  }
 
  public void EnterFileDesc(String EnterFileDesc){
	  UpdateDescField.clear();
	  UpdateDescField.sendKeys(EnterFileDesc);
  }
  
  public void ClickOnViewDetails(){
	  ViewDetails.click();
  }
  
  public String GetDescDetails(){
	  
	  String Desc=DescDetails.getText();
	  return Desc;
  }
  
  public void ClickOnUntrashIcon(){
	  UntrashIcon.click();
  }
  
  public void ClickOnTrashMainBtn(){
	  TrashMainBtn.click();
  }
	
  public void ClickOnSubTrashBtn(){
	  SubTrashBtn.click();
  }
  
  public void SleepFiveSec(){
	  try {
		Thread.sleep(5000);
	} 
	  catch (Exception e) {
	}
  }
  
  public void SleepThreeSec(){
	  try {
		Thread.sleep(3000);
	} 
	  catch (Exception e) {
	}
  }
  
  public void ClickonChangeAccount(){
	  ChangeAccount.click();
  }
  
  public void ClickOnRemove(){
	  RemoveIcon.click();
  }
  
  
	
	public void uploadFile(){
		FileAdd.click();
		FileUpload.click();
		SelectFromComp.click();	
	}
	
	public void ClickonFileAdd(){
		FileAdd.click();
	}
	
	public void ClickOnCreateFolderIcon(){
		Createfolder.click();
	}
	
	
	/*public void SelectFromComp(){
		
		Screen screen=new Screen();
		
		Pattern image1=new Pattern("C://Users//Sawood Pasha//Desktop//images//NewFile.PNG");
		
		Pattern image2=new Pattern("C://Users//Sawood Pasha//Desktop//images//Open.PNG");
		
		try {
			screen.click(image1);
			screen.type(image1, "C:\\Users\\Sawood Pasha\\Desktop\\zyx.docx");
			screen.click(image2);
			
		} catch (FindFailed e) {
		}	
	}*/
	
	public void closebutton(){
		//WebDriverWait wait=new WebDriverWait(driver, 20);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/span[contains(text(),'.pdf')]")));
		
		Closebutton.click();
	}
	
	public void VerifyFile(){
		String myfile=FirstFileName.getText();
		System.out.println(myfile);
		if(myfile.contains("IRIIIS")){
			
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
	
	/*public void SelectFromComp2(){
		
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
