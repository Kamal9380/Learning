package Automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MercuryTravels {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.mercurytravels.co.in/");
		String Title=driver.getTitle();
		System.out.println(Title);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(@title,\"Flights\")]")).click();
		driver.findElement(By.xpath("//input[@value=\"R\"]")).click();
		driver.findElement(By.xpath("//div[@class=\"col-md-6 form-group\"]//input[@name=\"fromCity\"]")).clear();
		driver.findElement(By.xpath("//div[@class=\"col-md-6 form-group\"]//input[@name=\"fromCity\"]")).click();
		driver.findElement(By.xpath("//div[@class=\"col-md-6 form-group\"]//input[@name=\"fromCity\"]")).sendKeys("Chennai, India - Madras International (MAA)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"col-md-6 form-group rightmargin\"]//input[@name=\"toCity\"]")).clear();
		driver.findElement(By.xpath("//div[@class=\"col-md-6 form-group rightmargin\"]//input[@name=\"toCity\"]")).click();
		driver.findElement(By.xpath("//div[@class=\"col-md-6 form-group rightmargin\"]//input[@name=\"toCity\"]")).sendKeys("London, United Kingdom - London Heathrow (LHR)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class=\"col-md-6 form-group form-inline\"]//input[@name=\"departDate\"]")).clear();
		driver.findElement(By.xpath("//div[@class=\"col-md-6 form-group form-inline\"]//input[@name=\"departDate\"]")).click();
		Date_Method("25",driver);
		Thread.sleep(5000);
		Date_Method("28",driver);
		
		}
	public static void Date_Method(String date,WebDriver driver) {
		
		WebElement table=driver.findElement(By.xpath("//div[@style=\"display: block; top: 453px; left: 100px;\"]"));
		List<WebElement> WebElementsValue=table.findElements(By.tagName("tr"));
		int WebElementSize=WebElementsValue.size();
		System.out.println(WebElementSize);
		for(WebElement ListValue:WebElementsValue) {
			List<WebElement> s=ListValue.findElements(By.tagName("td"));
			for(WebElement datavalues:s)
			{
				String DateValue=datavalues.getText();
				System.out.println(DateValue);
				if(DateValue.contains(date))
				{
					System.out.println("verify");
					datavalues.click();
				}
			}			
		}
	}
}




