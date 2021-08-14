import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	
	/*
	 *	Identify the testcase column by scanning the entire 1st row
	 *	Once column is identify then scan entire column to identify the purchase test case row
	 *	After grabbing the 2nd scenario, pull the data and feed into test
	 */
	public ArrayList<String> getData(String testCaseName) throws IOException
	{
		ArrayList<String> arr = new ArrayList<String>();
		
		FileInputStream fis = new FileInputStream("D:\\Excel Data\\Data Sheet.xlsx");
		XSSFWorkbook workbk = new XSSFWorkbook(fis);
		
		int sheets = workbk.getNumberOfSheets();
		System.out.println("Total no of sheets: "+sheets);
		
		for(int i=0; i<sheets; i++)
		{
			if(workbk.getSheetName(i).equalsIgnoreCase("TestData"))
			{
			XSSFSheet sheet = workbk.getSheetAt(i);
			//Identify the testcase column by scanning the entire 1st row
			
			Iterator<Row> rows = sheet.iterator();
			Row firstRow = rows.next();
			Iterator<Cell> cell = firstRow.cellIterator();
			int k=0;
			int column = 0;
			while(cell.hasNext())
			{
				Cell value = cell.next();
				if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
				{
					column=k;
					
				}
				k++;
			}
			System.out.println("Required cell value is in: " +column);
			
			//Once column is identify then scan entire column to identify the purchase test case row
			while(rows.hasNext())
			{
				Row r = rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName))
				{
					//After grabbing the 2nd scenario, pull the data and feed into test
					
					Iterator<Cell> cv = r.cellIterator();
					while(cv.hasNext())
					{
						//Write a wrapper code to check if the cell contains string or numeric value
						Cell c = cv.next();
						if(c.getCellType()==CellType.STRING)
						{
						arr.add(cv.next().getStringCellValue()); // data is getting stored in "arr" array list
						}
						else {
							//convert the number value to string since the array list is returning string
							arr.add(NumberToTextConverter.toText(c.getNumericCellValue()));
						}
					}
				}
			}
			
			}
		}
		return arr;
	}

	public static void main(String[] args)
	{
		
	}
}