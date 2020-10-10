package Automation;

import java.text.DateFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MakeMyTrip {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","C:\\Users\\679067\\SeleniumPractice\\ChromeDriver\\chromedriver_win32.exe");
		driver = (WebDriver) new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();
		String actualtitle=driver.getTitle();
		String expectedtitle="MakeMyTrip ";
        if(actualtitle==expectedtitle) {
        	System.out.println("Title Matched");
        }
        //driver.findElement(By.xpath("//a[text()='flights']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class=\"swipCircle\"]/span")).click();
        
        driver.findElement(By.xpath("//label[@for='fromCity']")).click();
        //driver.findElement( By.xpath("//div[@id=\"close\"]")).click();
        
        /*WebDriverWait wait=new WebDriverWait(driver, 10);
  		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='From']"))).sendKeys("Maa");*/
       
        
        //driver.findElement(By.xpath("//input[@placeholder='From']")).click();
        //driver.findElement(By.xpath("//input[@placeholder=\'From\']")).clear();
  		/*Thread.sleep(2000);
        LocationSelector(driver, "Chennai, India");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@for='toCity']")).click();
        driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys("BLR");
        LocationSelector(driver, "Bengaluru, India");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("a.primaryBtn.font24.latoBlack.widgetSearchBtn")).click();
        //driver.findElement(By.xpath("//span[contains(text(),'Bangalore, India ')]")).click();
        */
        
        
        
   
        driver.quit();
        }
	
	/*public static void LocationSelector (WebDriver ChromeDriver,String Sourcename) {
    	List<WebElement> SourceList=driver.findElements(By.xpath("(//div[@id='react-autowhatever-1']/div/ul)[1]/li"));
        int Sourcesize=SourceList.size();
        System.out.println(Sourcesize);
        for(int i=1;i<Sourcesize;i++) {
        	WebElement suggestionElement=driver.findElement(By.xpath(("(//div[@id='react-autowhatever-1']/div/ul)[1]/li["+i+"]//p")));
        	String SuggestionText=suggestionElement.getText();
        	System.out.println(SuggestionText);
        	System.out.println(Sourcename);
            if(Sourcename.equals(SuggestionText)) {
            	 WebDriverWait wait=new WebDriverWait(driver, 10);
           		wait.until(ExpectedConditions.elementToBeClickable(suggestionElement));
            	suggestionElement.click();
            	System.out.println(SuggestionText+i);
            }
         
    }*/

	}

	