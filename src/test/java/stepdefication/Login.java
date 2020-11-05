package stepdefication;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObject.Addcustomer;
import pageObject.LoginObject;
import pageObject.searchcustomer;

public class Login extends BaseClass {
	
	public static String randomemailid = "";
	
	@Before
	public void setup() throws IOException
	{
		
		log = Logger.getLogger("npoC_v01_cucmber");
		PropertyConfigurator.configure("log4j.properties");
		
		confg = new Properties();
		FileInputStream confgfile = new FileInputStream("config.properties");
		confg.load(confgfile);
		String br = confg.getProperty("browser");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", confg.getProperty("chromepath"));
		driver = new ChromeDriver();
		}else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", confg.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}
		else 
		{
			System.setProperty("webdriver.chrome.driver", confg.getProperty("chromepath"));
			driver = new ChromeDriver();
		}
		
		
		
	}
	
	
	@Given("User Launch any web application")
	public void user_launch_any_web_application() {
		
		
		lg = new LoginObject(driver);
		driver.manage().window().maximize();
		log.info("chrome open");
	}

	@When("User goto website {string}")
	public void user_goto_website(String url) {
		driver.get(url);
		log.info("url open");
	}

	@Then("user set username as {string}")
	public void user_set_username_as(String username) {
		lg.setusername(username);
		log.info("Username set");
	}

	@Then("Password as {string}")
	public void password_as(String password) {
	   lg.setpassword(password);
	   log.info("Password set");
	}

	@Then("user click on login")
	public void user_click_on_login() {
	    lg.btnlogin();
	    log.info("Login btn click");
	}

	@Then("verifiy page titile as {string}")
	public void verifiy_page_titile_as(String titile) {
		
		log.info("Login success");
		String websitetitile = driver.getTitle();
		if(titile.equals(websitetitile))
		{
			Assert.assertTrue(true);
			log.info("Login titile success");
		}
		else
		{
			Assert.assertTrue(false);
			log.info("Login title incorrect");
		}
	    
	}

	@Then("user clicks on logout")
	public void user_clicks_on_logout() {
		lg.btnlogout();
		log.info("Logout scuucess");
	}

	@Then("verifiy logout page titile as {string}")
	public void verifiy_logout_page_titile_as(String hometitile) {
		
		log.info("Logout success");
		String strhometitile = driver.getTitle();
		if(hometitile.equals(strhometitile))
		{
			Assert.assertTrue(true);
			log.info("Logout titile success");
		}
		else
		{
			Assert.assertTrue(false);
			log.info("Logout title unsuccess");
		}
	   
	}
	
	// Add customer 
	
	@Then("user clicks on cxtab")
	public void user_clicks_on_cxtab() {
	addcut = new Addcustomer(driver);
	addcut.clickcustomer();
	log.info("Add cx clicked");
	  
	}

	@Then("user clicks on subcxtab")
	public void user_clicks_on_subcxtab() {
		addcut.clicksbcustomer();
		log.info("Add subcx clicked");
	}

	@Then("Then user clicks on addcxtab")
	public void then_user_clicks_on_addcxtab() {
		addcut.addnewcustomer();
		log.info("Add new clicked");
	}

	@Then("user fill complete form with valid details")
	public void user_fill_complete_form_with_valid_details() throws InterruptedException {
		
		
		Thread.sleep(2000);
		addcut.setpassword("palshail");
		addcut.setfname("shailendra");
		addcut.setlname("pal");
		addcut.setdob("04/12/1995");
		addcut.setcompanyname("Balaji Software");
		addcut.settax();
		
		addcut.setadmincommebnt("Approved");
		
		addcut.selectgender("Male");
		
		
		addcut.selectnewsletter("Your Store Name");
		
		addcut.selectcxrole("Administrators");
		
		
		addcut.selectvendor("vendor 1");
		
		
		String randomemailid = randomstring(5)+"@gmail.com";
		addcut.setemail(randomemailid);
		log.info("mail id genrated");
		Thread.sleep(5000);
		log.info("form filled succes");
		
		
	}

	@Then("user clicks on save button and validate msg")
	public void user_clicks_on_save_button_and_validate_msg() throws InterruptedException {
		addcut.save();
		log.info("save clicked");
		Thread.sleep(2000);
	}
	
	// serach emails
	
	@Then("user enter search details")
	public void user_enter_search_details() {
		search = new searchcustomer(driver);
		search.enteremailid("palshailendra944@gmail.com");
		log.info("email ID entreted");
	}

	@Then("click on search button")
	public void click_on_search_button() {
		search.clickcearch();
		log.info("search buttom clicked");
	}

	@Then("verifiy serch is succsfull")
	public void verifiy_serch_is_succsfull() throws InterruptedException {
	  Thread.sleep(5000);
	  log.info("search sccues");
	}
	

	@Then("close the browser")
	public void close_the_browser() {
		driver.quit();
		log.info("browser is closed");
	}

}
