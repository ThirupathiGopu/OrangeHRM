package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Browser;

public class Loginpage 
{
	    WebDriver driver;
	
	
	@FindBy(css="#app > div.orangehrm-login-layout > div > div.orangehrm-login-container > div > div.orangehrm-login-slot > div.orangehrm-login-form > form > div:nth-child(2) > div > div:nth-child(2) > input")
	@CacheLookup
	WebElement usernamel;
	
	@FindBy(xpath="//input[@name='password']")
	@CacheLookup
	WebElement passwordl;
	
	@FindBy(xpath="//button[text()=' Login ']")
	@CacheLookup
	WebElement loginbtnl;
	
	@FindBy(xpath="//p[text()='Ugtphgckp Auto da Mata']")
	@CacheLookup
	WebElement profilebtn;
	
	@FindBy(xpath="//a[text()='Logout']")
	@CacheLookup
	WebElement logoutbutton;
	
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterusername(String useraname) throws InterruptedException
	{
       
    	 
//    	   usernamel.clear();
    	   Browser.Waitmethod(usernamel);
    	   usernamel.isEnabled();
    	   usernamel.sendKeys(useraname);
				
		System.out.println("enter to username ");
       
       
	}
	public void enterpassword(String password)
	{
	 	
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//    	   WebElement passwordl = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='password']s")));

//		passwordl.clear();
//		passwordl.click();
		Browser.Waitmethod(passwordl);
		passwordl.sendKeys(password);
	
	}
	
	public void clickonloginbutn()
	{
		loginbtnl.click();
		
	}
	
	public void clickonprofile()
	{
		profilebtn.click();
	}
	public void clickonlogoutbtn()
	{
		logoutbutton.click();
		
	}
	public void closebrowser()
	{
		driver.close();
	}
	

}
