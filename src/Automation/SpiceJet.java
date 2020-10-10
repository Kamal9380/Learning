package Automation;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class SpiceJet {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\679067\\SeleniumPractice\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.spicejet.com/Default.aspx");
		String Title=driver.getTitle();
		System.out.println(Title);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_rbtnl_Trip_1\"]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")).clear();
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_originStation1_CTNR\"]//a[contains(text(),'Chennai (MAA)')]")).click();
		//dropdown1.selectByVisibleText("Chennai (MAA)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_ddl_destinationStation1_CTXT\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_ddl_destinationStation1_CTXT\"]")).clear();
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"]//a[contains(text(),'Coimbatore (CJB)')]")).click();
		//Select dropdwon2=new Select(driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"]")));
		//dropdwon2.selectByVisibleText("Coimbatore (CJB)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"picker-first2\"]//input[@id=\"ctl00_mainContent_view_date1\"]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@class=\"picker-first2\"]//input[@id=\"ctl00_mainContent_view_date1\"]")).clear();
		//driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[1]/table/tbody/tr[4]/td[1]/a"));
		Date_Picker("25",driver);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id=\"Div1\"]//input[@id=\"ctl00_mainContent_view_date2\"]")).click();
		
		//driver.findElement(By.xpath("//div[@class=\"ui-datepicker-group ui-datepicker-group-first\"]/table//tr[5]//td[6]")).click();
		Thread.sleep(2000);
		
		try {
			Date_Picker("28",driver);
		}
		catch(Exception ex) {
		Date_Picker("28",driver);
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'1 Adult')]")).click();
		Thread.sleep(3000);
		for(int i=0;i<3;i++) {
			driver.findElement(By.xpath("//div[@id=\"divpaxOptions\"]/div[1]//span[@id=\"hrefIncAdt\"]")).click();
			Thread.sleep(3000);
		}
		
		driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_btn_FindFlights\" and @id=\"ctl00_mainContent_btn_FindFlights\"]")).click();
			/*WebElement Table=driver.findElement(By.xpath("//div[@id='ui-datepicker-div']"));
		List<WebElement> TableRow=Table.findElements(By.tagName("td"));
		for(WebElement Column:TableRow) {
			if(Column.getText().equals("20")) {
				Column.findElement(By.xpath(xpathExpression)
				break;
			}
		}*/
		
		
		
		
	}

	public static void Date_Picker(String date,WebDriver driver) {
	WebElement Table=driver.findElement(By.xpath("//div[@class=\"ui-datepicker-group ui-datepicker-group-first\"]"));
	List<WebElement> TableRow=Table.findElements(By.tagName("tr"));
	int TableSize=TableRow.size();
	System.out.println(TableSize);
	 OUTER_LOOP:
	for(WebElement ListValues:TableRow) {
		List<WebElement> date1=ListValues.findElements(By.tagName("td"));
		for(WebElement d:date1) {
			String DateValue=d.getText();
			System.out.println(DateValue);
			if(DateValue.contains(date)) {
				d.click();
				break OUTER_LOOP;
			}
		}
	
	}
	}
	}

