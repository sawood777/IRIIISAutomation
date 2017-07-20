package Factory;

import DataCollection.Configdata;
import DataCollection.ExcellDataCollection;

public class DataFactory {
	
	public static Configdata getconfic(){
		
		Configdata config=new Configdata();
		return config;		
	}	
	
public static ExcellDataCollection getdata(){
		
		ExcellDataCollection exceldata=new ExcellDataCollection();
		return exceldata;
		
	}

	
}
