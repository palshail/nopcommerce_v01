package pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.en.Then;
import stepdefication.BaseClass;
import utilities.Waithelper;

public class searchcustomer extends BaseClass {
	
	public WebDriver ldriver;
	

	public searchcustomer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
		wait = new Waithelper(ldriver);
	}
	
	@FindBy(id="SearchEmail") @CacheLookup WebElement emailid;
	@FindBy(id="search-customers") @CacheLookup WebElement btnsearch;
	@FindBy(xpath="//*[@id=\"customers-grid\']") @CacheLookup List<WebElement> table;
	@FindBy(xpath="//*[@id=\"customers-grid\"]/tbody/tr") @CacheLookup List<WebElement> tablerow;
	@FindBy(xpath="//*[@id=\"customers-grid\"]/tbody/tr/td") @CacheLookup List<WebElement> tablecol;
	
	
	public void enteremailid(String textemailid)
	{
		emailid.clear();
		emailid.sendKeys(textemailid);
	}
	public void clickcearch()
	{
		wait.waitforelement(btnsearch, 30);
		btnsearch.click();
	}
	public int getrowcount()
	{
		return(tablerow.size());
	}
	public int getcolcount()
	{
		return(tablecol.size());
	}

}
