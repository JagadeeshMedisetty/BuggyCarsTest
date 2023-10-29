package stepDefinitions;

import io.cucumber.java.en.And;
import org.junit.runner.RunWith;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.time.Duration;

public class UserAuthenticationSteps {

    public PageObjectManager pageObjectManager;
    public WebDriver driver=null;
    LandingPage landingpage;
    RegistrationPage registrationpage;
    HomePage homePage;
    LoginPage loginPage;



    @Given("browser is open")
     public void browser_is_open() throws InterruptedException {

        System.out.println("=== Iam inside UserAuthentication Steps_POM");

		System.out.println("Inside step- Browser is open");

	    String projectPath = System.getProperty("user.dir");
	    System.out.println("Project Path is: "+projectPath);

		System.setProperty("webdriver.chrome.driver",projectPath+"/src/test/resources/drivers/chromedriver.exe");

	    //WebDriverManager.chromedriver().driverVersion("116.0.5845.96").setup();
		driver=new ChromeDriver();
        System.out.println("Driver initialized successfully");

	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

		driver.manage().window().maximize();
        pageObjectManager = new PageObjectManager(driver);

        System.out.println("Browser opened successfully");
        Thread.sleep(3000);

}
    @And("^user launches the home page$")
    public void user_launches_the_home_page() throws Throwable {
        homePage = pageObjectManager.getHomePage();
        homePage.launchHomePage();
        Thread.sleep(5000);
    }

    @Given("^website is in a logged in state$")
    public void website_is_in_a_logged_in_state() throws Throwable {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.loginAs("jag.med","Test@2023");
        landingpage = pageObjectManager.getLandingPage();
        landingpage.clickOnLogin();
    }

    @When("^user login with valid credentials$")
    public void user_login_with_valid_credentials() throws Throwable {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.loginAs("jag.med","Test@2023");
        landingpage = pageObjectManager.getLandingPage();
        landingpage.clickOnLogin();
    }

    @When("^user login with invalid credentials$")
    public void user_login_with_invalid_credentials() throws Throwable {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.loginAs("jag.med","Test2023");
        landingpage = pageObjectManager.getLandingPage();
        landingpage.clickOnLogin();
    }

    @When("^user logs out$")
    public void user_logs_out() throws Throwable {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.clickLogout();
        Thread.sleep(1000);
    }

    @Then("^Website should be in a logged in state$")
    public void website_should_be_in_a_logged_in_state() throws Throwable {
        loginPage.validateWebsiteloggedinState();
    }

    @Then("^Website should not be in a logged in state$")
    public void website_should_not_be_in_a_logged_in_state() throws Throwable {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.validateWebsiteloggedOutState();
    }

    @Then("^website should be in a logged out state$")
    public void website_should_be_in_a_logged_out_state() throws Throwable {
        loginPage = pageObjectManager.getLoginPage();
        loginPage.validateWebsiteloggedOutState();
    }
}


