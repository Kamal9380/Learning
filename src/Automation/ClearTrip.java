package Automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClearTrip {

	 
	 static WebDriver driver;
	 public static String rowvalues;
	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\679067\\SeleniumPractice\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.cleartrip.com/");
		String Title=driver.getTitle();
		System.out.println(Title);
		driver.manage().window().maximize();
		
		HashMap<String,String> locations=ExcelInput_Hashmap(driver);
		int locationsize=locations.size();
		
		Iterator<Map.Entry<String, String>> itr = locations.entrySet().iterator(); 
        
        while(itr.hasNext()) 
        { 
             Map.Entry<String, String> entry = itr.next(); 
			String fromLocation = entry.getKey();
			String toLocation = entry.getValue();
			System.out.println(fromLocation+toLocation);
		    driver.findElement(By.xpath("//input[@id=\"RoundTrip\"]")).click();
			driver.findElement(By.xpath("//input[@id=\"FromTag\"]")).click();
			driver.findElement(By.xpath("//input[@id=\"FromTag\"]")).clear();
			WebElement FromLocation=driver.findElement(By.xpath("//input[@id=\"FromTag\"]"));
			FromLocation.sendKeys(fromLocation);
			Thread.sleep(2000);
			System.out.println("To Location");
			//driver.findElement(By.xpath("//input[@id=\"ToTag\"]")).click();
			//driver.findElement(By.xpath("//input[@id=\"ToTag\"]")).clear();
			
		    driver.findElement(By.xpath("//input[@id=\"ToTag\"]")).click();
		    driver.findElement(By.xpath("//input[@id=\"ToTag\"]")).clear();
			driver.findElement(By.xpath("//input[@id=\"ToTag\"]")).sendKeys(toLocation);
			//Thread.sleep(2000);
			driver.findElement(By.xpath("//div[@class=\"span span15 datePicker\"]//input[@title=\"Depart date\"]")).click();
			//driver.findElement(By.xpath("//div[@class=\"span span15 datePicker\"]//input[@title=\"Depart date\"]")).clear();
			//Thread.sleep(3000);
			String FromDatexpath="//div[@id='ui-datepicker-div']//div[1]//table//td[@data-month='11']";
			String ToDatexpath="//div[@class='monthBlock last']/table//td[@data-handler='selectDay']";
			DateSelector(driver,"22",FromDatexpath);
			Thread.sleep(2000);
			//driver.findElement(By.xpath("//input[@id=\"ReturnDate\"]")).click();
			Thread.sleep(2000);
			
			//Actions action=new Actions(driver);
			//action.doubleClick(driver.findElement(By.xpath("//select[@id='Adults']")));
			driver.findElement(By.xpath("//input[@etitle='Return Date']")).click();
			DateSelector(driver,"24",ToDatexpath);		
			Thread.sleep(2000);
			driver.findElement(By.id("Adults")).click();
			Select dropdown1=new Select(driver.findElement(By.id("Adults")));
			Thread.sleep(2000);
			dropdown1.selectByValue("4");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@title=\"Search flights\"]")).click();
			Thread.sleep(15000);
			NextPage_Validation(driver);
			driver.navigate().back();
			driver.navigate().refresh();
			Thread.sleep(5000);
			//driver.findElement(By.xpath("//span[@title='Cleartrip']"));
		
		}
        
		driver.quit();
	}

public static void DateSelector (WebDriver chromedriver,String datetoselect, String ElementLocator) throws InterruptedException {
	WebDriverWait wait=new WebDriverWait(chromedriver,30);

	//WebElement elementwait=	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ui-datepicker-div")));
	//WebElement tablevalues=chromedriver.findElement(By.xpath("//div[@id='ui-datepicker-div']/div[1]/table"));
	
	List<WebElement>dates=chromedriver.findElements(By.xpath(ElementLocator));
	int date=dates.size();
	
	for(int i=0;i<date;i++) {
		String datevalue=dates.get(i).getText();
		if(datevalue.equalsIgnoreCase(datetoselect)){
			dates.get(i).click();
			break;
		}
	}
	}
	
	public static List<String> ExcelInput_Reader(WebDriver chromedriver) throws IOException, Exception   {
		//FileInputStream fis=new FileInputStream(new File("E:\\Automation\\Cleartrip.xlsx"));
		String Excelname="F:\\Automation\\Cleartrip.xlsx";

		File file = new File(Excelname);  
		XSSFWorkbook wb = new XSSFWorkbook(file);  
		XSSFSheet sheetname=wb.getSheet("FromLocation");
		int Rowcount=sheetname.getLastRowNum();
		List<String> rowvalues=new ArrayList<String>();
		for(int i=1;i<=Rowcount;i++) {
			System.out.println("Total Row Count is" +Rowcount);
			XSSFRow Rowvalue=sheetname.getRow(i);
			XSSFCell Cellvalue=Rowvalue.getCell(0);
			String FromCell1=Cellvalue.getStringCellValue();
			//XSSFCell Cellvalue1=Rowvalue.getCell(j);
			//String FromCell2=Cellvalue1.getStringCellValue();
			rowvalues.add(FromCell1);
			//rowvalues.add(FromCell2);
			
			System.out.println("FromLocationValue is" +""+FromCell1);
			wb.close();
	    }
			
		
		return rowvalues;
		
			
	}
	
	public static void NextPage_Validation(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1500)");
		//Types of Airline to check whether all checkbox are checked
		List<WebElement> CheckBox=driver.findElements(By.xpath("//nav[@class=\'airlines\']//ul//li"));
		int i=1;
		
		for(WebElement Cbox:CheckBox) {
			
			if(!Cbox.isSelected()) {
				//String airlinename=driver.findElement(By.xpath("//nav[@class='airlines']//ul//li/label//span[@rel='bTooltip']["+i+"]")).getText();
				Thread.sleep(2000);
				
				try {
					Cbox.click();
					
				}
				catch(Exception e) {
					
					JavascriptExecutor js1=(JavascriptExecutor)driver;
					js1.executeScript("arguments[0].click();", Cbox);
					System.out.println(e);
					
				}
				
				//Cbox.click();
				js.executeScript("window.scrollBy(0,1500)");
				String CheckBoxValue=Cbox.getText();
				
				if(CheckBoxValue.contains("SpiceJet"))
				{
					Cbox.click();
					WebDriverWait wait=new WebDriverWait(driver, 30);
					//wait.until(ExpectedConditions.elementToBeClickable(Cbox));
					System.out.println(CheckBoxValue);
				}
			}
			i++;
		}
		
	}
	
	public static HashMap<String,String> ExcelInput_Hashmap(WebDriver chromedriver) throws IOException, Exception   {
		//FileInputStream fis=new FileInputStream(new File("E:\\Automation\\Cleartrip.xlsx"));
		String Excelname="F:\\Automation\\Cleartrip.xlsx";
		HashMap<String, String> maps = new HashMap<>();
		
		File file = new File(Excelname);  
		XSSFWorkbook wb = new XSSFWorkbook(file);  
		XSSFSheet sheetname=wb.getSheet("FromLocation");
		int Rowcount=sheetname.getLastRowNum();
		//List<String> rowvalues=new ArrayList<String>();

			for(int j=1;j<=Rowcount;j++)
			{
				String FirstCellvalue=sheetname.getRow(j).getCell(0).getStringCellValue();
				String SecondCellvalue=sheetname.getRow(j).getCell(1).getStringCellValue();
				maps.put(FirstCellvalue, SecondCellvalue);
			}
			
			wb.close();
			return maps;
			
			
		
		
		
			
	}
		
}
