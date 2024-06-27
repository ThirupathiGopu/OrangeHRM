package stepDefination;

import java.util.List;
import org.openqa.selenium.WebDriver;
import utilities.Browser;
import utilities.PropertyReader;
import io.cucumber.java.en.*;
import pageObjects.Loginpage;

public class Steps 
{
	static WebDriver driver;
	Loginpage login;
	
	@Given("Lanch chrome browser")
	public void lanch_chrome_browser() throws Exception 
	{
	   List<String>info=PropertyReader.getData("browser", 1);
	   String browsername=info.get(0),drivername=info.get(1);
	   
	   Browser.LanchBrowser(browsername, drivername);
	   login=new Loginpage(driver);
	   
	   
	}

	@When("Enter url{string}")
	public void enter_url(String str) throws Exception 
	
	{
		List<String>info=PropertyReader.getData("browser", 1);
			String url=info.get(2);
			Browser.openUrl(url);
			System.out.println("navigated url ");
			
	   
	}

	@When("Enter user name  as {string}")
	public void enter_user_name_as(String user) throws Exception 
	{
		System.out.println("user name and password text box is displayed");
	    login.enterusername(user);
	    
	}

	@When("Enter Password as {string}")
	public void enter_password_as(String string) {
	    login.enterpassword("admin123");

	 
	}

	@When("click on login link")
	public void click_on_login_link() {
	    
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) 
	{

		  driver.getTitle();
			if (driver.getPageSource().contains("Login was unsuccessful.")) {
				driver.close();
				Assert.assertTrue(false);
			} else {
				Assert.assertEquals(title, driver.getTitle());
			}

	}

	@Then("click on profile button")
	public void click_on_profile_button() 
	{
	 login.clickonprofile();
	}

	@When("click on logout button")
	public void click_on_logout_button() {
		login.clickonlogoutbtn();
	   
	}

	@Then("close browser")
	public void close_browser() {
		login.closebrowser();
	   
	}
}
