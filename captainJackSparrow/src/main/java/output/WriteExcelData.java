package output;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import baseClasses.BaseTestClass;


public class WriteExcelData {
	
	
	public String path;
	public File file;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;

	public void writeExcel1() throws Exception {
		
		file = new File(System.getProperty("user.dir") +"\\TestData\\test_data.xlsx");
	    fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		
		sheet = workbook.getSheet("Course_Details");
		
		  String[] arr = {"Course_Name","Course_Duration","Course_Rating"};

	
	
	for(int i = 0; i<1; i++) {
		  

		  sheet.createRow(i);
		  
		  for(int j= 0;j<3;j++) {
			  
			
			  sheet.getRow(i).createCell(j).setCellValue(arr[j]);
			 
		  }
		  fileOut = new FileOutputStream(file);
		  workbook.write(fileOut);
		  workbook.close();
	  }
	}
	
		
	public void writeExcel2(String[] array,int index) throws Exception { 
		
		file = new File(System.getProperty("user.dir") +"\\TestData\\test_data.xlsx");
	    fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		
		sheet = workbook.getSheet("Course_Details");
		
	
	 for( int i=index; i<3; i++) {
		  
		  if(row == null)
		  sheet.createRow(i);
		  for(int j=0; j<3; j++) {
			  
			  if(cell == null)
			  sheet.getRow(i).createCell(j).setCellValue(array[j]);
		  }
	  }
	  
	  fileOut = new FileOutputStream(file);
	  workbook.write(fileOut);
	  workbook.close();
	}
	
}
