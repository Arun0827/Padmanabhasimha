package newPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;



public class WriteExcelData {
	
	
	
// WebDriver driver;
	// @SuppressWarnings({ "resource", "unused" })


@Test
public void writeexcel1(String name) throws Exception { 
	
	File file=new File(System.getProperty("user.dir") +"\\outputexcel\\outputdata.xlsx");
     FileInputStream fis = new FileInputStream(file);
	  XSSFWorkbook workbook= new XSSFWorkbook(fis);
	  XSSFSheet sheet = workbook.createSheet("Course_Details");
	  
	 
	  String[] arr = {"Course_Name","Course_Duration","Course_Rating"};
	  
	 // sheet.createRow(0).createCell(0).setCellValue("Course_Name");
	 // sheet.getRow(0).createCell(1).setCellValue("Course_Duration");
	 // sheet.getRow(0).createCell(2).setCellValue("Course_Rating");
	  
	  for(int i = 0; i<1; i++) {
		  
		  sheet.createRow(i);
		  
		  for(int j= 0;j<3;j++) {
			  
			  
			  sheet.getRow(i).createCell(j).setCellValue(arr[j]);
			 
		  }
	  }
	  


	 
	  
	 /* sheet.createRow(1).createCell(0).setCellValue(a.getText());
	  sheet.getRow(1).createCell(1).setCellValue(b.getText());
	  sheet.getRow(1).createCell(2).setCellValue( c.getText());*/
	  FileOutputStream out = new FileOutputStream(file);
	  workbook.write(out);
	  workbook.close();
	
} 
}
