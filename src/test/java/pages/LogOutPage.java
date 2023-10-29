package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LogOutPage {

	
	public WebDriver driver;
	
	public LogOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	By logout = By.xpath("//a[contains(@href,'Logout')]");

	
	private void clickLogOut() {
		driver.findElement(logout).click();
	}
	
}
