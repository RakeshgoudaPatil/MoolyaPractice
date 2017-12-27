package practice ;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import wrapper.GenericWrapperUtils;

public class TC01 extends GenericWrapperUtils{

	@Test(dataProvider = "asert")
	public void login(String Username, String Password) {
		launchBrowserAndApp("chrome", "http://www.leaftaps.com/opentaps");
		textBoxHandling("id", "username", Username);
		textBoxHandling("name", "PASSWORD", Password );
		buttonHandling("className", "decorativeSubmit");
		linkhandling("CRM/SFA");
	}
	
	@DataProvider(name = "data01")
	public static Object[][] crendentials () {
		return new Object[] []  {{"test", "test123"}, {"test01","test253637"}};
		
		
	}
	
	@DataProvider(name = "asert")
	public static Object[] [] excel() throws IOException {
		
		String [][] tabdata; 
		XSSFWorkbook exel = new XSSFWorkbook("./data/UserName.xlsx");
		XSSFSheet sheet = exel.getSheet("Sheet1");
		int lastRowNum = sheet.getLastRowNum();
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		
		XSSFCell cell;
		tabdata = new String [lastRowNum][lastCellNum];
		int ci =0;
		for (int i = 1; i <=lastRowNum; i++, ci++) {
			
			
			XSSFRow row = sheet.getRow(i);
			int cj =0;
			for (int j = 0; j < lastCellNum; j++ , cj++) {
				cell = row.getCell(j);
				tabdata[ci][cj] = cell.getStringCellValue();
				System.out.println(cell.getStringCellValue());
			}
		}
		
		return tabdata;
		
		
	}
	
	
}
