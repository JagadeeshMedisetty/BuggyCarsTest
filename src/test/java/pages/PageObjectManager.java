package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LandingPage landingPage;
	public HomePage homePage;
	public LoginPage loginpage;
	public LogOutPage logoutpage;
	public RegistrationPage registartionpage;
	public SelectModelPage selectmodelpage;
	public VotingPage votingpage;
	
	public WebDriver driver;
	
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}

	
	
	public LandingPage getLandingPage()
	{
	
	 landingPage= new LandingPage(driver);
	 return landingPage;
	}
	
	public HomePage getHomePage()
	{
		homePage = new HomePage(driver);
		return homePage;
	}
	
	public LoginPage getLoginPage()
	{
		loginpage = new LoginPage(driver);
		return loginpage;
	}
	
	
	public LogOutPage getLogOutPage()
	{
		logoutpage = new LogOutPage(driver);
		return logoutpage;
	}
	
	public RegistrationPage getRegistartionPage()
	{
		registartionpage = new RegistrationPage(driver);
		return registartionpage;
	}
	
	public SelectModelPage getSelectModelPage()
	{
		selectmodelpage = new SelectModelPage(driver);
		return selectmodelpage;
	}
	
	public VotingPage getVotingPage()
	{
		votingpage = new VotingPage(driver);
		return votingpage;
	}
}
