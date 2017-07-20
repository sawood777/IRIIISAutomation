package DataCollection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Configdata {
	
	Properties pro;
	
	public Configdata(){	
		
		File src=new File("./Configurations/Config.properties");
		
		try {
			
			FileInputStream file=new FileInputStream(src);
			
			 pro=new Properties();
			
			pro.load(file);
			
		} catch (Exception e) {
	
				System.out.println("Exception is "+	 e.getMessage());
		}
	
	}
	
      public String getProdurl(){
    	 String Produrl= pro.getProperty("ProdUrl");
    	 return Produrl;
    	  
      }
      
      public String getDevurl(){
     	 String Devdurl= pro.getProperty("DevUrl");
     	 return Devdurl;
     	  
       }
      
      public String getChromepath(){
      	 String Chromepath= pro.getProperty("Chromepath");
      	 return Chromepath;
      	  
        }

}
