package Pkg.PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Pkg.BaseClass.BaseClass;
import Pkg.Utiltiy.UtilClass;
import io.qameta.allure.Step;


public class CreateAccount {
	private WebDriver driver;
	private JavascriptExecutor j;
	private LoginPage loginPage;
	WebDriverWait wait;
	Actions builder;
	
	@FindBy(css="a[title='Create Account']")
	private WebElement createAccount;
	
	@FindBy (xpath="//h3[text()='Player Info']")
	private WebElement playerInfo;
	
	
	@FindBy (css="#PlayerInfo_F_Red")
	private WebElement firstName;
	
	@FindBy (css="#PlayerInfo_L_Orange")
	private WebElement lastName;
	

	public WebElement countryDropDown(String ariaLabel) {
		String locator = String.format("(//span[@class='select2-selection select2-selection--single'])[%s]", ariaLabel);
		return driver.findElement(By.xpath(locator));
	}
	@FindBy (css=".select2-search__field")
	private WebElement searchCountryDropDown;
	
	@FindBy (css=".validate-email")
	private WebElement validEmailId;
	
	@FindBy (css=".validate-password")
	private WebElement validPassword;
	
	@FindBy (css=".validate-equal-to")
	private WebElement validConfirmPassword;
	
	@FindBy (xpath="(//ul[@id='select2-PlayerInfo_SelectedCountry-results']//li)[1]")
	private WebElement liFirstValue;
	
	@FindBy (xpath="(//span[contains(@class,'select2-container--above')])[2]//span")
	private WebElement eductionSelections;
	
	@FindBy (xpath="//input[@class='select2-search__field']")
	private WebElement inputForHowDidYouHear;
	
	@FindBy (xpath="(//span[@class='select2-selection__arrow'])[4]")
	private WebElement eductionDropdownArrow;
	
	@FindBy (xpath="//label[text()='Are you an educator?*']")
	private WebElement educatorText;
	
	@FindBy (css="#OptInToGenericNewsletter")
	private WebElement coolStuffCheckBox;
	
	@FindBy (css="#OptInFoundationNewsletter")
	private WebElement emailNewsLeatters;
	
	@FindBy (css="#AcceptedUserAgreement")
	private WebElement userAggriment;
	
	@FindBy (css="#OptInToEducationCollectiveInfo")
	private WebElement eductionsNewsLeatters;
	
	@FindBy(css="#login")
	private WebElement loginYopMail;
	
	@FindBy (css="button[class='md']")
	private WebElement forwardButtonYopMail;
	
	@FindBy (xpath="(//button[@type='submit'])[2]")
	private WebElement submitButtonCompletedRegestion;
	
	@FindBy (css="div[class=rich-text-area narrowWidth'] h1")
	private WebElement activeAccountHeader;
	
	@FindBy (css=".lmf")
	private WebElement mailIdYopMail;
	
	@FindBy (xpath="//table[@bgcolor='#f64a48']//td[@align='center']//font[text()='ACTIVATE ACCOUNT']")
	private WebElement activeAccount;
	
	@FindBy (xpath="//font[text()=\"ONE MORE CLICK AND YOU'RE IN\"]")
	private WebElement textAtYopMail;
	
	@FindBy (css="#ifmail")
	private WebElement ifrmaeOnYopMail;
	
	@FindBy (css=".intro")
	private WebElement introInfo;
	
	@FindBy (css="span[class='header-logo'] a")
	private WebElement headerOfWebSite;
	
	@FindBy (css="input[placeholder=\"view-this-mailbox\"]")
	private WebElement mailDropInput;
	
	@FindBy (xpath="(//span[text()='View Mailbox'])[1]")
	private WebElement viewMailButton;
	
	@FindBy (css=".pointsBalance")
	private WebElement pointsCredited;
	
	@FindBy (css=".action-container.account-container")
	private WebElement accountLogoHeader;
	
	@FindBy (css="a[title='Player Profile']")
	private WebElement playerProfile;
	
	@FindBy (css=".accountPageTabsWrapper h1")
	private WebElement myAccountHeader;
	
	@FindBy (css=".accountPageActive a[title='MY ACCOUNT']")
	private WebElement myAccountButton;
	
	@FindBy (css=".flexItem h1")
	private WebElement playerProfilesAboveEmail;
	
	@FindBy (css=".display-points")
	private WebElement accountPointDisplayed;
	public WebElement whichInstrumentPlay(String ariaLabel) {
		String locator = String.format("(//*[contains(@class, 'checkboxAccordionWrapper')]//*[contains(@class, 'accordionButton')])[%s]", ariaLabel);
		return driver.findElement(By.xpath(locator));
	}
	
	@FindBy(xpath="//span[@class='radio-input-text']")
	private List<WebElement> radioButtonSelections;
	
	@FindBy (css=".checkbox-container label")
	private List<WebElement> instrumentValues;
	
	@FindBy (css="#edit-player-save-button")
	private WebElement saveButton;
	
	@FindBy (css="#global-validation-summary .success-message li")
	private WebElement successMassage;
	
	@FindBy (css="input[type='email']")
	private WebElement emailIDGmail;
	
	@FindBy (xpath="//span[text()='Next']")
	private WebElement nextButtonAfterEmailId;

	@FindBy (xpath="//input[@aria-label='Enter your password']")
	private WebElement passwordGmail;
	

	@FindBy (xpath="//span[text()='Next']")
	private WebElement nextButtonAfterPassword;
	
	@FindBy (xpath="//a[text()='Inbox']")
	private WebElement inboxGmail;
	
	@FindBy (xpath="(//span[@email='playerscircle@enews.daddario.com'])[2]")
	private WebElement clickOnTheLinkToActive;
	
	
	@FindBy (xpath="(//table[contains(@class,'F cf zt')])[2]//span[@class='zF']")
	private List<WebElement> listOfTheEmails;
	@FindBy (xpath="//div[text()='Promotions']")
	private WebElement pramotionsTab;
	
	@FindBy (xpath="//div[contains(@class,'adn ads')]//div[@data-tooltip='Show trimmed content']")
	private WebElement trimmerContentThreeDots;
	@FindBy (css="input[aria-label='Email address']")
	private WebElement tutaEmail;
	
	@FindBy (css="input[aria-label=\"Password\"]")
	private WebElement passwordTutaNota;
	public CreateAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		j = (JavascriptExecutor) driver;
		loginPage=new LoginPage(driver);
		wait=new WebDriverWait(driver, Duration.ofSeconds(30));
		builder = new Actions(driver);        
		
	}
	@Step("Create the account with the new user and add all the details")
	public void createAccountOfNewUser(String firstNameValue,String lastNameValue,String enterName,String primaryInstrument,String hearAboutUs,String educatated,String emailId,String password) throws InterruptedException {
		loginPage.myAccountLogo.click();
		createAccount.click();
		wait.until(ExpectedConditions.visibilityOf(playerInfo));
		firstName.sendKeys(firstNameValue);
		lastName.sendKeys(lastNameValue);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",countryDropDown("1"));
		wait.until(ExpectedConditions.visibilityOf(countryDropDown("1"))).click();
		selectCountry(enterName);
		wait.until(ExpectedConditions.visibilityOf(countryDropDown("2"))).click();
		UtilClass.asyncClickLiInUlByTextWithCss("//ul[@id='select2-PlayerInfo_SelectedPrimaryInstrument-results']",primaryInstrument);
		wait.until(ExpectedConditions.visibilityOf(countryDropDown("3"))).click();
		inputForHowDidYouHear.sendKeys(hearAboutUs);
		builder.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(countryDropDown("3"))).click();
		wait.until(ExpectedConditions.visibilityOf(countryDropDown("4"))).click();
		UtilClass.asyncClickLiInUlByTextWithCss("//ul[@class='select2-results__options']",educatated);
		validEmailId.sendKeys(emailId);
		validPassword.sendKeys(password);
		validConfirmPassword.sendKeys(password);
		coolStuffCheckBox.click();
		eductionsNewsLeatters.click();
		emailNewsLeatters.click();
		userAggriment.click();
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",submitButtonCompletedRegestion);
		j.executeScript("arguments[0].click();", submitButtonCompletedRegestion);
		
	}
	public void selectCountry(String countryName) {
		wait.until(ExpectedConditions.visibilityOf(searchCountryDropDown)).sendKeys(countryName);
		builder.sendKeys(Keys.ENTER).build().perform();
	}
	@Step("login to yopMail and validate after account active it will shows/navigate to login page")
	public boolean loginToYopMail(String email,String password) {
		loginYopMail.sendKeys(email);
		forwardButtonYopMail.click();
		driver.switchTo().frame(ifrmaeOnYopMail);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",activeAccount);
		activeAccount.click();
		driver.switchTo().defaultContent();
		String winHandleBefore = driver.getWindowHandle();
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		loginPage.emailId.sendKeys(email);
		loginPage.password.sendKeys(password);
		loginPage.signInButton.click();
		return headerOfWebSite.isDisplayed();
	}
	@Step("Return the header after login")
	public boolean headerAfterLoginSussusfully() {
		return headerOfWebSite.isDisplayed();
	}
	@Step("Validate after login '100' points creadited into account")
	public String pointsCreatedToAccountAfterRegister() {
	  return pointsCredited.getText();
	}
	@Step("Update the profile for the '500' points")
	public String updatedTheProfile() {
		accountLogoHeader.click();
		playerProfile.click();
		return myAccountHeader.getText();
	}
	@Step("Select the all dropdown form the palyer profile for update profile")
	public String playerProfile(String playerPlayOwnInstrument,String typeOfMusicMostOften,String instrumentDoYouTeach,String settingCurrentlyTeach,String studentTeachInWeek,String levelOfStudent,String brandAndAccessoriesCurretlyPlay,String stringInGuitarInstrumentChange,String setBuyAtATime,String gender) {
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",myAccountButton);
		j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});",playerProfilesAboveEmail);
		dropdownSelectionForPlayerProfile("1",playerPlayOwnInstrument);
		dropdownSelectionForPlayerProfile("3",typeOfMusicMostOften);
		dropdownSelectionForPlayerProfile("5",instrumentDoYouTeach);
		dropdownSelectionForPlayerProfile("7",settingCurrentlyTeach);
		UtilClass.listOfWebElementMethodToGetTextAndClcik(driver, radioButtonSelections,studentTeachInWeek);
		dropdownSelectionForPlayerProfile("9",levelOfStudent);
		dropdownSelectionForPlayerProfile("11",brandAndAccessoriesCurretlyPlay);
		UtilClass.listOfWebElementMethodToGetTextAndClcik(driver, radioButtonSelections,stringInGuitarInstrumentChange);
		UtilClass.listOfWebElementMethodToGetTextAndClcik(driver, radioButtonSelections,setBuyAtATime);
		UtilClass.listOfWebElementMethodToGetTextAndClcik(driver, radioButtonSelections,gender);
		saveButton.click();
		return successMassage.getText();
	}
	public void dropdownSelectionForPlayerProfile(String num,String dropdownValue) {
		whichInstrumentPlay(num).click();
		UtilClass.listOfWebElementMethodToGetTextAndClcik(driver, instrumentValues,dropdownValue);
		whichInstrumentPlay(num).click();
	}
	
	@Step("Validate the '600' points creadited into the account ")
	public String checkForTheSixHundredCoins() {
		accountLogoHeader.click();
		return accountPointDisplayed.getText();
	}
	@Step("Add the gmail Id with the password")
	public void gmailLoginAndAccountVerify(String gmail, String password, String activePassword, String activeAccountEmail) throws InterruptedException {
	    emailIDGmail.sendKeys(gmail);
	    nextButtonAfterEmailId.click();
	    Thread.sleep(5000);
	    passwordGmail.sendKeys(password);
	    nextButtonAfterPassword.click();
	    Thread.sleep(3000);
	    wait.until(ExpectedConditions.visibilityOf(inboxGmail)).click();
	    wait.until(ExpectedConditions.visibilityOf(pramotionsTab)).click();
	    UtilClass.listOfWebElementMethodToGetTextWithoutActions(listOfTheEmails,"D'Addario Players C.");
	    Thread.sleep(3000);
	    int maxAttempts = 3;
	    int attempts = 0;

	    while (attempts < maxAttempts) {
	        try {
	            if (isElementDisplayed(trimmerContentThreeDots)) {
	                j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", trimmerContentThreeDots);
	                builder.moveToElement(trimmerContentThreeDots).click(trimmerContentThreeDots).build().perform();
	                break; // Exit the loop if the action is successful
	            }
	        } catch (StaleElementReferenceException e) {
	            // Handle the exception or just retry
	            attempts++;
	        }
	    }

	    // Click the activeAccount element
	    j.executeScript("arguments[0].scrollIntoView({block: 'center', inline: 'center'});", activeAccount);
	    activeAccount.click();

	    String winHandleBefore = driver.getWindowHandle();
	    for (String winHandle : driver.getWindowHandles()) {
	        driver.switchTo().window(winHandle);
	    }
	    loginPage.emailId.sendKeys(activeAccountEmail);
	    loginPage.password.sendKeys(activePassword);
	    loginPage.signInButton.click();
	}

	private boolean isElementDisplayed(WebElement element) {
	    try {
	        return element.isDisplayed();
	    } catch (NoSuchElementException | StaleElementReferenceException e) {
	        return false;
	    }
	}

	public void tutaNotaLogin(String mailId,String password) {
		tutaEmail.sendKeys(mailId);
		passwordTutaNota.sendKeys(password);
		
	}
}
