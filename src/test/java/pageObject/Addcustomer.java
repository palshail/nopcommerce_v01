package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class Addcustomer {

	public WebDriver ldriver;

	public Addcustomer(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By customer = By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/a");
	By subcustomer = By.xpath("/html/body/div[3]/div[2]/div/ul/li[4]/ul/li[1]/a");
	By addnewcx = By.xpath("/html/body/div[3]/div[3]/div/form[1]/div[1]/div/a/i");
	By email = By.id("Email");
	By password = By.id("Password");
	By fname = By.id("FirstName");
	By lname = By.id("LastName");

	By GenderM = By.id("Gender_Male");
	By GenderF = By.id("Gender_Female");

	By cxDOB = By.id("DateOfBirth");
	By Companyname = By.id("Company");
	By taxcheck = By.xpath("//*[@id=\"IsTaxExempt\"]");

	By yourstorename0 = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[1]/div[9]/div[2]/div/div[1]/div");
	By yourstorename = By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[1]");
	By yourstorename2 = By.xpath("//*[@id=\"SelectedNewsletterSubscriptionStoreIds_listbox\"]/li[2]");

	By cxrole = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[1]/div[10]/div[2]/div/div[1]/div");
	By cxroleadmin = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[1]");
	By cxfourm = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[2]");
	By cxguest = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[3]");
	By cxregistred = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[4]");
	By cxvendor = By.xpath("//*[@id=\"SelectedCustomerRoleIds_listbox\"]/li[5]");

	By drpVendorId = By.id("VendorId");
	By managevendornotven = By.xpath("//*[@id=\"VendorId\"]/option[1]");
	By managevendornotven1 = By.xpath("//*[@id=\"VendorId\"]/option[2]");
	By managevendornotven2 = By.xpath("//*[@id=\"VendorId\"]/option[3]");

	By activecheck = By.id("Active");
	By comment = By.id("AdminComment");

	By savecx = By.xpath("/html/body/div[3]/div[3]/div/form/div[1]/div/button[1]");
	
	By msg = By.xpath("/html/body/div[3]/div[3]/div[1]");


	public void clickcustomer()
	{
		ldriver.findElement(customer).click();;
	}
	public void clicksbcustomer()
	{
		ldriver.findElement(subcustomer).click();;
	}
	public void addnewcustomer()
	{
		ldriver.findElement(addnewcx).click();
	}

	public void selectgender(String morf)
	{
		if(morf.equals("Male"))
		{
			ldriver.findElement(GenderM).click();
		}
		else if(morf.equals("Female"))
		{
			ldriver.findElement(GenderF).click();
		}
		else
		{
			ldriver.findElement(GenderM).click();
		}
	}

	public void selectnewsletter(String name)
	{
		WebElement listeditem;
		ldriver.findElement(yourstorename0).click();
		
		if(name.equals("Your Store Name"))
		{
			listeditem = ldriver.findElement(yourstorename);
		}
		else
		{
			listeditem = ldriver.findElement(yourstorename2);
		}
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click()", listeditem);
				
		
	}

	public void selectcxrole(String rolename)
	{
		
		//ldriver.findElement(cxrole).clear();
		ldriver.findElement(cxrole).click();
		
		WebElement listeditem;
		
		if(rolename.equals("Vendors"))
		{
			listeditem = ldriver.findElement(cxvendor);
		}
		else if(rolename.equals("Administrators"))
		{
			listeditem = ldriver.findElement(cxroleadmin);
		}
		else if(rolename.equals("Fourm Moderators"))
		{
			listeditem = ldriver.findElement(cxfourm);
		}
		else if(rolename.equals("Guests"))
		{
			listeditem = ldriver.findElement(cxguest);
		}
		else
		{
			listeditem = ldriver.findElement(cxregistred);
		}
		JavascriptExecutor js = (JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click()", listeditem);
	}
	
	public void selectvendor(String vendor)
	{
		
		//Select drp = new Select(ldriver.findElement(drpVendorId));
		//drp.selectByVisibleText(vendor);
		//ldriver.findElement(drpVendorId).clear();
		WebElement listeditem;
		
		 if(vendor.equals("Not a vendor")) {
			 listeditem = ldriver.findElement(managevendornotven);
		 
		 }else if(vendor.equals("vendor 1")) {
			 listeditem =  ldriver.findElement(managevendornotven1);
		  
		  }else { listeditem = ldriver.findElement(managevendornotven2); }
		 
		 JavascriptExecutor js = (JavascriptExecutor)ldriver;
			js.executeScript("arguments[0].click()", listeditem);
		 
	}
	
	
	
	public void setemail(String nameemail)
	{
		ldriver.findElement(email).sendKeys(nameemail);
	}
	public void setpassword(String namepaswword)
	{
		ldriver.findElement(password).sendKeys(namepaswword);
	}
	public void setfname(String firstname)
	{
		ldriver.findElement(fname).sendKeys(firstname);
	}
	public void setlname(String lastname)
	{
		ldriver.findElement(lname).sendKeys(lastname);
	}
	public void setdob(String date)
	{
		ldriver.findElement(cxDOB).sendKeys(date);
	}
	public void setcompanyname(String cname)
	{
		ldriver.findElement(Companyname).sendKeys(cname);
	}
	public void settax()
	{
		ldriver.findElement(taxcheck).click();
	}

	/*
	 * public void setactive() { ldriver.findElement() }
	 */
	public void setadmincommebnt(String admincomment)
	{
		ldriver.findElement(comment).sendKeys(admincomment);
	}
	
	public void save()
	{
		ldriver.findElement(savecx).click();
		
		if(ldriver.findElement(msg).getText().equals("The new customer has been added successfully."))
		{
			Assert.assertTrue(true);
		}
		else 
		{
			Assert.assertFalse(false);
		}
	}
}
