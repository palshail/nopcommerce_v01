package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waithelper {

	public WebDriver driver; 
	
	public Waithelper(WebDriver driver) {
		this.driver = driver;
	}
	
	public void waitforelement(WebElement element,long timeoutinsec)
	{
		WebDriverWait wait = new WebDriverWait(driver,timeoutinsec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	

}
