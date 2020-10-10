package Automation;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UdemyAssesmentCheckBox {
	public static String opt;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver\\chromedriver_win32 (2)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		CheckBox(driver);
		Thread.sleep(2000);
		System.out.println("Dropdown chosen from checkbox value");
		Thread.sleep(2000);
		System.out.println("Alert Button Triggered");

	}

	public static void CheckBox(WebDriver driver) throws InterruptedException {

		// String xpathText="(//input[@type='checkbox'])["+i+"]";
		driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();

		String opt = driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
		// driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]/input")).click();
		// String
		// Checkboxvalue=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[2]")).getText();
		System.out.println(opt);
		WebElement DropdownValue = driver.findElement(By.id("dropdown-class-example"));
		Select s = new Select(DropdownValue);
		s.selectByVisibleText(opt);
		// System.out.println(s.getAllSelectedOptions());

		WebElement namebox = driver.findElement(By.name("enter-name"));
		namebox.click();
		namebox.sendKeys(opt);
		driver.findElement(By.id("alertbtn")).click();
		String Alert = driver.switchTo().alert().getText();
		if (Alert.contains(opt))
			System.out.println("Alert Success");
	}
}
