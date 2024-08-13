package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.Browser;

public class Loginpage 
{
	  public  WebDriver driver;
	@FindBy(xpath="//input[@name='username']")
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
    	   //Browser.Waitmethod(usernamel);
//    	   usernamel.isEnabled();
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
