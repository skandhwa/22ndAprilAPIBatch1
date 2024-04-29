package Utilities;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
		
		static XSSFWorkbook workbook;
		static XSSFSheet sheet;
		
		ReadDataFromExcel(String excelPath,String sheetName) throws IOException
		{
			workbook=new XSSFWorkbook(excelPath);
			sheet=workbook.getSheet(sheetName);
			int x=sheet.getPhysicalNumberOfRows();
			
		}
		
		
		
		
		public static Object getTestData(int rownum,int colnum) throws IOException
		{
			
			
			
	    DataFormatter formatter=new DataFormatter();
		Object value=	formatter.formatCellValue(sheet.getRow(rownum).getCell(colnum));
		return value;
		
			
			
			
			
		}
		

}



