package Automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
public class AmazonLocators {

	WebDriver driver;


public void AmazonLocators(WebDriver kdriver)
{
	this.driver=kdriver;
}

@FindBy(xpath="//div[@class='_39M2dM JB4AMj']/input[@type='text']")
  @CacheLookup
  WebElement VerifyUsernameText;




}