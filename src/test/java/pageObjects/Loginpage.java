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

public class Loginpage 
{
	 WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(xpath="//input[@name='username']")
//	@CacheLookup
//	WebElement usernamel;
	
//	@FindBy(xpath="//input[@name='password']")
//	@CacheLookup
//	WebElement passwordl;
	
	@FindBy(xpath="//button[text()=' Login ']")
	@CacheLookup
	WebElement loginbtnl;
	
	@FindBy(xpath="//p[text()='Ugtphgckp Auto da Mata']")
	@CacheLookup
	WebElement profilebtn;
	
	@FindBy(xpath="//a[text()='Logout']")
	@CacheLookup
	WebElement logoutbutton;
	
	public void enterusername(String useraname) throws InterruptedException
	{
       try 
       {  
//		usernamel.clear();
//		usernamel.click();
    	 
    	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	   WebElement usernamel = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
    	   usernamel.clear();
    	   usernamel.sendKeys(useraname);
		//usernamel.sendKeys(useraname);
		
		System.out.println("enter to username ");
       }
       catch(NullPointerException e)
       {
    	   e.printStackTrace();
    	   
       }
       
	}
	public void enterpassword(String password)
	{
	 	try
	 	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	   WebElement passwordl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']s")));

		passwordl.clear();
		passwordl.click();
		passwordl.sendKeys(password);
	}
	 	catch(NullPointerException e)
	       {
	    	   e.printStackTrace();
	 		
	 	}
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
