package newPackage;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;




public class ReadExcelData {
	
	public String path;
	public File file;
	public FileInputStream fis ;
	public FileOutputStream fileOut;
	public XSSFWorkbook workbook ;
	public XSSFSheet sheet ;
	public XSSFRow row;
	public XSSFCell cell;
	public String s;
	
	
	public  void readExceldata1() throws Exception{
		

		file = new File(System.getProperty("user.dir") +"\\inputexcel\\inputdata.xlsx");
	    fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Input_Data");
		
		s = String.valueOf(sheet.getRow(1).getCell(0));
	
		//System.out.println(s);
		
		 workbook.close();

					
			
		}
	
	
public  void readExceldata2() throws Exception{
		

		file = new File(System.getProperty("user.dir") +"\\inputexcel\\inputdata.xlsx");
	    fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Input_Data");
		
		

			s = String.valueOf(sheet.getRow(1).getCell(1));
	
		//System.out.println(s);
			
			 workbook.close();
	
		}
	
	
		
		
	}



