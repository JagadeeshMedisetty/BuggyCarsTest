package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage  {
	
	
	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	By login = By.xpath("//button[contains(@class,'btn-success')][@type='submit']");
	By register = By.xpath("//a[contains(@href,'register')]");
	By popularMake = By.xpath(".//img[@title='Lamborghini']");


	
	public void clickOnLogin() {
		driver.findElement(login).click();
	}
	
	public void clickRegister() {
		driver.findElement(register).click();
	}


	public void clickPopularMake() {
		driver.findElement(popularMake).click();
	}
}
