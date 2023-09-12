package Pkg.PageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Step;
public class LoginPage {
	private WebDriver driver;
	private WebDriverWait wait;
	@FindBy (css="div.action-container.account-container")
	public WebElement myAccountLogo;
	
	@FindBy (css="a[title='Log In']")
	private WebElement loginButton;
	
	@FindBy (css="#email")
	public WebElement emailId;
	
	@FindBy (css="#password")
	public WebElement password;
	
	@FindBy (css="button#next")
	public WebElement signInButton;
	
	@FindBy (css="#localAccountForm h2")
	private WebElement SignInEmailAdd;
	
	@FindBy (css="span[class='header-logo'] img")
	private WebElement logoHeader;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	@Step("Click to the profile button and verify that SignInWithEmail text displayed")
	public String SignInWithEmailAddressValidate() {
		myAccountLogo.click();
		loginButton.click();
		
		return SignInEmailAdd.getText();
	}
	@Step("Enter the valid username and password And sing in")
	public boolean loginEmailIdPassword(String emailIdValue,String PasswordValue) {
		emailId.sendKeys(emailIdValue);
		password.sendKeys(PasswordValue);
		signInButton.click();
		return logoHeader.isDisplayed();
	}
	
	
}
