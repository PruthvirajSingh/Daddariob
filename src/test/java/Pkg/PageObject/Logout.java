package Pkg.PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;

public class Logout {
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor j;
	 @FindBy (css="div[data-view='MyAccount'] .header-icon")
	 private WebElement logoUserHeader;
	 
	 @FindBy (css="span[class='display-label']")
	 private WebElement myDashboard;
	 
	 @FindBy (xpath="//a[text()='Log out']")
	 private WebElement logoutButton;
 
	 @FindBy (css="//a[text()='Register Products']")
	 private WebElement registerProduct;
	public Logout(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		j = (JavascriptExecutor) driver;
		
	}
	@Step("Logout form the account")
	public void logoutFromApplications() {
		logoUserHeader.click();
		wait.until(ExpectedConditions.visibilityOf(myDashboard));
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",registerProduct);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",logoutButton);
		logoutButton.click();
	}
}
