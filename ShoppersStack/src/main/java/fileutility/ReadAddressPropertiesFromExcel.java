package fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;

public class ReadAddressPropertiesFromExcel {
	
	public FileInputStream fis = null;
	public Workbook wb;
	public Object[][] readAddressProperties( String excelname , String sheetname)
	{
	
	try {
		fis = new FileInputStream("./src/test/resources/"+excelname+".xlsx");
	} catch (FileNotFoundException e) {
		Reporter.log("path to excel wrong",true);
	}
		
	try {
		wb = WorkbookFactory.create(fis);
	} 
	catch(IOException e)
	{
		Reporter.log("workbook not created",true);
	}
		Sheet sheet = wb.getSheet(sheetname);
		int rowcount = sheet.getPhysicalNumberOfRows();
		int columncount = sheet.getRow(0).getPhysicalNumberOfCells();
//		System.out.println(rowcount);
//		System.out.println(columncount);
		Object[][] data = new Object[rowcount-1][columncount];
		
		for(int i=1;i<rowcount;i++)
		{
			for(int j=0;j<columncount;j++)
			{
				data[i-1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				//System.out.println(data[i][j]);
			}
		}
		
		return data;
	}
	
//	public static void main(String[] args) {
//		ReadAddressPropertiesFromExcel read=new ReadAddressPropertiesFromExcel();
//		read.readAddressProperties("Sheet1");
//	}

}
