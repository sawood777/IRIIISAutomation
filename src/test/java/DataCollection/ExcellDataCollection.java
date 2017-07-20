package DataCollection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcellDataCollection {
	XSSFWorkbook wb;
	
	public ExcellDataCollection(){
		File src=new File("./MyTestData/MyTestData.xlsx");
		
		try {
			FileInputStream file=new FileInputStream(src);
			
		 wb=new XSSFWorkbook(file);
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}	
	}
	
	public String getDataByIndex(int SheetIndex, int rows, int  colomn)
	{
		String data=wb.getSheetAt(SheetIndex).getRow(rows).getCell(colomn).getStringCellValue();
		return data;

	}
	
	public String getDataBySheetName(String Sheetname, int rows, int  colomn)
	{
		String data=wb.getSheet(Sheetname).getRow(rows).getCell(colomn).getStringCellValue();
		return data;
		
		
	}
	
	

}
