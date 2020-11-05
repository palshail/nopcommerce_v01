package stepdefication;

import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObject.Addcustomer;
import pageObject.LoginObject;
import pageObject.searchcustomer;
import utilities.Waithelper;


public class BaseClass {
	
	public WebDriver driver; 
	public LoginObject lg; 
	public Addcustomer addcut;
	public Waithelper wait;
	public searchcustomer search;
	public static Logger log;
	public Properties confg;
	

	public static String randomstring(int Number)
	{
		String randomstring = RandomStringUtils.randomAlphabetic(Number);
		return randomstring;
	}

}
