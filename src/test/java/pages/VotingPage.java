package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class VotingPage {
	
	public WebDriver driver;

	public VotingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	
	
	
	By comment = By.id("comment");
	By vote = By.xpath("//button[contains(text(),'Vote!')]");
	By voteNote = By.xpath("//div[@class='card-block']/p");
	By voteSuccess = By.xpath(".//p[@class ='card-text']");
	By currentVoteCount = By.xpath("/html/body/my-app/div/main/my-model/div/div[1]/div[3]/div[2]/div[1]/h4/strong");
	By votingHistoryCheck = By.xpath("/html/body/my-app/div/main/my-model/div/div[3]/table/tbody/tr[1]/td[3]");



	public void enterComment(String texttoComment) {
		driver.findElement(comment).sendKeys("texttoComment");
}
	
	public void clickVote() {
		driver.findElement(vote).click();

	}
	
	
	private String getVoteNote() {
		return null;
	}


	public void validateVote() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(voteSuccess)));

		assert(driver.findElement(voteSuccess).isDisplayed());
	}

	public int getCurrentVoteCount() {
		System.out.println(driver.findElement(currentVoteCount).getText());
		int count = Integer.parseInt(driver.findElement(currentVoteCount).getText());
		return count;
	}

	public void validateVotingHistory() {
		assert (driver.findElement(votingHistoryCheck).getText().equalsIgnoreCase("Nice Car"));
	}
}


