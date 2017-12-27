package practice;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excel {

	@DataProvider(name = "asert")
	public static Object[] [] excel() throws IOException {
		
		String [][] tabdata; ;
		XSSFWorkbook exel = new XSSFWorkbook("./data/UserName.xlsx");
		XSSFSheet sheet = exel.getSheet("Sheet1");
		int lastRowNum = sheet.getLastRowNum();
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		
		XSSFCell cell;
		tabdata = new String [lastRowNum][lastCellNum];
		
		for (int i = 1; i <=lastRowNum; i++) {
			
			
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				cell = row.getCell(j);
				tabdata[i][j] = cell.getStringCellValue();
				System.out.println(cell.getStringCellValue());
			}
		}
		
		return tabdata;
		
		
	}
}
