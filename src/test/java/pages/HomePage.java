package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	By logo = By.xpath(".//a[@href='/']");

	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void launchHomePage(){
		System.out.println("Getting Base URL with driver:"+ driver);
		driver.get("https://buggy.justtestit.org");
	}

	public void clickHomePageLogo(){
		driver.findElement(logo).click();
	}
	
}
