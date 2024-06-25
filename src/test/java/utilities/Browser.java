package utilities;

import java.io.File;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Browser 
{
	static WebDriver driver;
	static WebDriverWait wait;
	@SuppressWarnings("deprecation")
	public static WebDriver LanchBrowser(String browsername,String drivername)
	{
		if(browsername.equals("chrome"))
		{
			driver=new ChromeDriver();
			// System.setProperty("WebDriver.Chrome.driver", "\\home\\tvisha\\Downloads\\chromedriver-linux64.exe");
			driver.manage().window().maximize();
		      driver. manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		else if(browsername.equals("Edge"))
		{
			driver=new EdgeDriver();
			// System.setProperty("WebDriver.Chrome.driver", "/home/tvisha/Downloads/chromedriver-linux64.exe");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		else
		{
			driver=new FirefoxDriver();
			// System.setProperty("WebDriver.Chrome.driver", "/home/tvisha/Downloads/chromedriver-linux64.exe");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		return driver;
	}
	public static WebDriver openUrl(String url)
	{
		driver.get(url);
		return driver;
	}
	public static WebDriver closebrowser()
	{
		driver.close();
		return driver;
	}
	public static void TakeSelfi(String imageName) throws Exception
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE) ,new File(".//screenshots//"+imageName+".png"));	
	}
	public static void scrolldown(WebElement element) throws InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	public static void Waitmethod(WebElement element) 
	{
	    wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    //wait.until(ExpectedConditions.visibilityOf(element)); 
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	   // element = wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));

	}
//	public static void verifyurl()
//	{
//		String actuallurl=driver.getCurrentUrl();
//		//Assert.assertEquals(actuallurl,DataConfig.validateofExpectedUrl,"test case pass");
//	}

	public static void changeToframe(WebElement element)
	{
		driver.switchTo().frame(element);
	}
}
