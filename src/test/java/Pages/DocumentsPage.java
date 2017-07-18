package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;




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
	

	public DocumentsPage(WebDriver driver){
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void uploadFile(){
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
	}
	

}
