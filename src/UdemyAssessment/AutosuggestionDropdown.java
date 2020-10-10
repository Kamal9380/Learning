package UdemyAssessment;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutosuggestionDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#autocomplete")).sendKeys("Unit");
		//driver.findElement(By.xpath("//input[@id=\"autocomplete\"] ")).sendKeys("Unite");
		Thread.sleep(2000);
	    //driver.findElement(By.xpath("//input[@id=\"autocomplete\"]")).sendKeys(Keys.DOWN);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		String script = "return document.getElementById(\"autocomplete\").value;";
		String text=(String) js.executeScript(script);
		System.out.println(text);
		int i=0;
		while(!text.equalsIgnoreCase("United Kingdom (UK)")){
			i++;
		    driver.findElement(By.xpath("//input[@id=\"autocomplete\"]")).sendKeys(Keys.DOWN);
		    text=(String) js.executeScript(script);
		    System.out.println(text);
		    if(i>5) {
		    	break;
		    }
	    }
		if(i>5) {
			System.out.println("Element not found");
			
		}
		else {
			System.out.println("Elemement found" +":"+text );
		}

	driver.close();
		
	}

}
