package dataDrivenTutorial;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static void main(String[] args) throws Exception 
	{
		File src = new File("D:\\Excel Data\\DataFile.xlsx"); //gave the file path knowledge
		
		FileInputStream fis = new FileInputStream(src); //Load the data inside the file using FileInputStream class
		
		XSSFWorkbook wb = new XSSFWorkbook(fis); // Using XSSFWorkbook class all the data inside the excel file will be read and write
		
		XSSFSheet sheet = wb.getSheetAt(0); // Get the sheet data at 0th index i.e Sheet 1
		
		String rowData = sheet.getRow(0).getCell(0).getStringCellValue(); //Read the data in row and col using sheet object of XSSFSheet class
		
		System.out.println("The value of 0th row is " +rowData);
		
		sheet.getRow(0).createCell(2).setCellValue("Pass"); //Write Pass in the cell value
		
		FileOutputStream fos = new FileOutputStream(src); //Use the FileOutputStream class to write the data
		
		wb.write(fos); //Save the excel file
		
		wb.close(); //Close the object to avoid memory leak
	}

}
