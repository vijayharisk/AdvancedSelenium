package fileutility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
public class ReadExcelData {
	 Workbook wb;
	 FileInputStream fis;
	public  Object[][] getFromExcel(String excel,String sheetName) 
	{
		try {
			fis=new FileInputStream("./src/test/resources/"+excel+".xlsx");
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		try {
			wb=WorkbookFactory.create(fis);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		Sheet sheet = wb.getSheet(sheetName);
		int rowcount = sheet.getPhysicalNumberOfRows();
		int column = sheet.getRow(0).getPhysicalNumberOfCells();
		Object data[][]=new Object[rowcount][column];
		for(int i=0;i<rowcount;i++)
		{
			for(int j=0;j<column;j++)
			{
				data[i][j]= sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
	
	
}
	
