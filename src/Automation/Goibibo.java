package Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Goibibo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","F:\\chromedriver\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		driver.getTitle();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[contains(@id,\"gi_roundtrip_label\")]")).click();
		driver.findElement(By.xpath("//*[@id=\"gosuggest_inputSrc\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"gosuggest_inputSrc\"]")).sendKeys("Chennai (MAA)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"gosuggest_inputDest\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"gosuggest_inputDest\"]")).sendKeys("London (LON)");
		Thread.sleep(2000);
		/*WebElement fromdate=driver.findElement(By.xpath("//div[@class=\"shCalenderBox col-md-5 col-sm-5 col-xs-12 pad0 marginTB10 marginAdjust\"]/div[1]//input[@class='form-control inputTxtLarge widgetCalenderTxt']"));
		fromdate.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id=\"fare_20181213\"]")).click();
		Thread.sleep(2000);
		WebElement todate=driver.findElement(By.xpath("//div[@class=\"shCalenderBox col-md-5 col-sm-5 col-xs-12 pad0 marginTB10 marginAdjust\"]/div[2]//input[@class='form-control inputTxtLarge widgetCalenderTxt']"));
		todate.click();
		driver.findElement(By.xpath("//div[@id=\"fare_20181215\"]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@class=\"icon-arrow-down txtgrey ico13 lh1-2 padT5 fr\"]"));
		driver.findElement(By.xpath("//a[@class=\"paxBox mobdn\"]")).click();
		driver.findElement(By.xpath("//input[@id=\"adultPaxBox\"]")).clear();
		driver.findElement(By.xpath("//input[@id=\"adultPaxBox\"]")).sendKeys("2");
		driver.findElement(By.xpath("//*[@id='pax_close']")).click();;
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"col-md-5 col-sm-6 col-xs-12 pad0 fr\"]//button[@class=\"width100 button orange xlarge\"]")).click();
		Thread.sleep(10000);*/
		
		
	}
	public static void Date_method(String date, WebDriver driver) {
		WebElement Webvalue=driver.findElement(By.xpath("//div[@class=\"DayPicker DayPicker--en\"]/div[2]"));
		List<WebElement> ListValues=Webvalue.findElements(By.tagName("tr"));
		
	}
}
