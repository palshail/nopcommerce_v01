package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginObject {
	
	public WebDriver ldriver;

	public LoginObject(WebDriver rdriver) {
	
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "Email") @CacheLookup WebElement txtusername;
	@FindBy(id = "Password") @CacheLookup WebElement txtpassword;
	@FindBy(xpath = "/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/input") @CacheLookup WebElement btnlogin;
	@FindBy(xpath = "/html/body/div[3]/div[1]/div/div/ul/li[3]/a") @CacheLookup WebElement btnlogout;

	public void setusername(String username)
	{
		txtusername.clear();
		txtusername.sendKeys(username);
	}
	public void setpassword(String password)
	{
		txtpassword.clear();
		txtpassword.sendKeys(password);
	}
	public void btnlogin()
	{
		btnlogin.click();
	}
	public void btnlogout()
	{
		btnlogout.click();
	}
	
}
