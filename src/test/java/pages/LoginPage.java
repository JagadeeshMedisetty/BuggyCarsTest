package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage {


	By name = By.name("login");
	By password = By.name("password");
	By loginGreeting = By.xpath(".//span[@class='nav-link disabled']");
	By loginButton = By.xpath("/html/body/my-app/header/nav/div/my-login/div/form/button");
	By logoutButton = By.xpath("/html/body/my-app/header/nav/div/my-login/div/ul/li[3]/a");
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void loginAs(String _userName, String _password) throws InterruptedException {
		driver.findElement(name).sendKeys(_userName);
		driver.findElement(password).sendKeys(_password);
		Thread.sleep(1000);
		driver.findElement(loginButton).click();
	}

	public void validateWebsiteloggedinState() {
		assert(driver.findElement(loginGreeting).getText().contains("Hi"));
	}

	public void validateWebsiteloggedOutState() {
		assert(!driver.findElement(loginGreeting).getText().contains("Hi"));
	}

	public void clickLogout(){

		driver.findElement(logoutButton).click();
	}
}

