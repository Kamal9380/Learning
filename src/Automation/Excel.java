package Automation;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Excel {
	
	static WebDriver driver;
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 10;
	//public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"\\tEST\\ExcelDATA\\TestData.xlsx";
	public static ArrayList<String> claim_List  ; 
	public static int TotalRows = 0;
	public static int TotalColumns = 0;
	public static ArrayList<String> headings =new ArrayList<String>();
	public static String ResultFileNAME="";
	
	public static LinkedHashMap<Integer, Object> map = new LinkedHashMap<Integer,Object>();
		
	public static void storeIntoExcel() {}

	@Test
	public static Integer getColumnNumber(XSSFRow row, String colName) throws Exception {

		int patchColumn = -1;
		for (int cn = 0; cn < row.getLastCellNum(); cn++) {

			XSSFCell c = row.getCell(cn);
			try {
				String text = c.getStringCellValue();

				if (colName.equals(text)) {
					patchColumn = cn;
					break;
				}
			} catch (Exception e) {

			}
		}
		if (patchColumn == -1) {
			throw new Exception("None of the cells in the header row contain '" + colName + "'");
		}
		return patchColumn;

	}

	@Test
	public static void takeScreenshotAtEndOfTest() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(scrFile, new File("./TestReport/screenshots/" + System.currentTimeMillis() + ".png"));
	}
	
	@Test
	@SuppressWarnings({ "resource", "unchecked" })
	public static void readFromExcel() {
  
		try {
			FileInputStream fis=new FileInputStream(new File("C:\\Users\\679067\\OneDrive - Cognizant\\Documents\\Selenium_Project\\CleartripData.xlsx"));
			//InputStream ExcelFileToRead = new FileInputStream(TESTDATA_SHEET_PATH);
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workBook.getSheet("Sheet1");
			
			TotalRows = sheet.getLastRowNum();
			TotalColumns = sheet.getRow(0).getLastCellNum();
			
			XSSFRow header = sheet.getRow(0);
			
			for(int h=0;h<TotalColumns;h++) {
				
				//headings.add(sheet.getRow(0).getCell(h).getStringCellValue().trim());
				//headings.add(getCellValue(sheet.getRow(0).getCell(h)));
				headings.add(getCellValue(sheet.getRow(0).getCell(h)));
				
			}
			
			System.out.println(headings);
			
			for (int row = 1; row <= TotalRows; row++) {

				map.put(row, new LinkedHashMap<String, String>());

				for (int h = 0; h < TotalColumns; h++) {

					/*String Hyperlink_Name = getCellValue(sheet.getRow(row).getCell(getColumnNumber(header, headings.get(h)))).trim();
					String Actual_Locator = getCellValue(sheet.getRow(row).getCell(getColumnNumber(header, headings.get(h)))).trim();
					String Actual_RefString = getCellValue(sheet.getRow(row).getCell(getColumnNumber(header, headings.get(h)))).trim();
					String Taget_Locator = getCellValue(sheet.getRow(row).getCell(getColumnNumber(header, headings.get(h)))).trim();
					String Target_RefString = getCellValue(sheet.getRow(row).getCell(getColumnNumber(header, headings.get(h)))).trim();*/
					
					String cellValue = getCellValue(sheet.getRow(row).getCell(getColumnNumber(header, headings.get(h)))).trim();
					

					/*if (!Hyperlink_Name.isEmpty() && !Actual_Locator.isEmpty()&& !Actual_RefString.isEmpty()
							&&!Taget_Locator.isEmpty()&& !Target_RefString.isEmpty()) {*/
					if(!cellValue.isEmpty()) {

						/*((LinkedHashMap<String, Object>) map.get(row)).put(headings.get(h), Hyperlink_Name);
						((LinkedHashMap<String, Object>) map.get(row)).put(headings.get(h), Actual_Locator);
						((LinkedHashMap<String, Object>) map.get(row)).put(headings.get(h), Actual_RefString);
						((LinkedHashMap<String, Object>) map.get(row)).put(headings.get(h), Taget_Locator);
						((LinkedHashMap<String, Object>) map.get(row)).put(headings.get(h), Target_RefString);*/
						
						((LinkedHashMap<String, Object>) map.get(row)).put(headings.get(h), cellValue);
						
					}
				}
			}
			
			System.out.println("Data from input sheet --> " + map.toString());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 
	}

		
	@Test	
	private static String getCellValue(Cell cell) {
		String value="";
	    switch (cell.getCellType()) {
	       case BOOLEAN:
	            System.out.print(cell.getBooleanCellValue());
	            break;
	        case STRING:
	            value = cell.getRichStringCellValue().getString();
	            break;
	        case NUMERIC:
	            if (DateUtil.isCellDateFormatted(cell)) {
	                value  = cell.getDateCellValue().toString();
	            } else {
	                value  = String.valueOf((int)cell.getNumericCellValue());
	               
	            }
	            break;
	        case FORMULA:
	            System.out.print(cell.getCellFormula());
	            break;
	        case BLANK:
	          
	            break;
	        default:
	          
	    }

	    System.out.print("\t");
		return value;
	}
	

	
	

}



