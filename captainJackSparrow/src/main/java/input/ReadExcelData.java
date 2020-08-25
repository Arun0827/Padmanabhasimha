package input;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import baseClasses.BaseTestClass;



public class ReadExcelData extends BaseTestClass {
	
	public String path;
	public File file;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	public String s;
	public String s1;

	
	public String[] readExceldata1() throws Exception{
		
		file = new File(System.getProperty("user.dir") +"\\TestData\\test_data.xlsx");
	    fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Input_Data");
	
		s = String.valueOf(sheet.getRow(1).getCell(0));
		s1 = String.valueOf(sheet.getRow(1).getCell(1));
		String[] value = {s,s1};

		 workbook.close();
			return value;
		}
		
	}


