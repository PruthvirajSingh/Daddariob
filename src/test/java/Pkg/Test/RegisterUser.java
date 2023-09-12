package Pkg.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pkg.BaseClass.BaseClass;
import Pkg.Utiltiy.EmailCombinationsGenerator;
import Pkg.Utiltiy.UtilClass;

public class RegisterUser extends BaseClass{
	
	@Test(description="Verify that user able to navigate to login page after the active account",groups = {"Regression"})
	public void loginTestAfterActiveAccount() throws InterruptedException {
		
		String emailIdGenrated=EmailCombinationsGenerator.emailIdAndTheIndexCombinations("testuserforautomationm.time@gmail.com",jsonArrayValueInt("dataForEmailCombinations","TestCase1"));
		createAccount.createAccountOfNewUser(jsonArrayValue("createNewAccountData","firstName"),jsonArrayValue("createNewAccountData","lastName"), jsonArrayValue("createNewAccountData","country"), jsonArrayValue("createNewAccountData","primaryInstrument"), jsonArrayValue("createNewAccountData","hearAboutUs"), jsonArrayValue("createNewAccountData","educatated"),emailIdGenrated,jsonArrayValue("createNewAccountData","password"));
		driver.navigate().to("https://mail.google.com/");
		createAccount.gmailLoginAndAccountVerify("testuserforautomationmtime@gmail.com","Test@1234",jsonArrayValue("createNewAccountData","password"),emailIdGenrated);
		boolean headerValueAfterLogin=createAccount.headerAfterLoginSussusfully();
		Assert.assertEquals(headerValueAfterLogin,true);
	}
	@Test(description="Verify that the user is able to see the '100' points credited message after activating their account",groups = {"Regression"})
	public void hundredPoints() throws InterruptedException {
		String emailIdGenrated=EmailCombinationsGenerator.emailIdAndTheIndexCombinations("testuserforautomationm.time@gmail.com",jsonArrayValueInt("dataForEmailCombinations","TestCase2"));
		createAccount.createAccountOfNewUser(jsonArrayValue("createNewAccountData","firstName"),jsonArrayValue("createNewAccountData","lastName"), jsonArrayValue("createNewAccountData","country"), jsonArrayValue("createNewAccountData","primaryInstrument"), jsonArrayValue("createNewAccountData","hearAboutUs"), jsonArrayValue("createNewAccountData","educatated"),emailIdGenrated,jsonArrayValue("createNewAccountData","password"));
		driver.navigate().to("https://mail.google.com/");
		createAccount.gmailLoginAndAccountVerify("testuserforautomationmtime@gmail.com","Test@1234",jsonArrayValue("createNewAccountData","password"),emailIdGenrated);
		boolean headerValueAfterLogin=createAccount.headerAfterLoginSussusfully();
		Assert.assertEquals(headerValueAfterLogin,true);
		String hunredPoints=createAccount.pointsCreatedToAccountAfterRegister();
		Assert.assertEquals(hunredPoints,jsonArrayValue("Assertions","100PointMessage"));
	}
	@Test(description="Verify that the user is able to see 'MY ACCOUNT' after clicking on the player profile",groups = {"Regression"})
	public void myAccountProfile() throws InterruptedException {
		String emailIdGenrated=EmailCombinationsGenerator.emailIdAndTheIndexCombinations("testuserforautomationm.time@gmail.com",jsonArrayValueInt("dataForEmailCombinations","TestCase3"));
		createAccount.createAccountOfNewUser(jsonArrayValue("createNewAccountData","firstName"),jsonArrayValue("createNewAccountData","lastName"), jsonArrayValue("createNewAccountData","country"), jsonArrayValue("createNewAccountData","primaryInstrument"), jsonArrayValue("createNewAccountData","hearAboutUs"), jsonArrayValue("createNewAccountData","educatated"),emailIdGenrated,jsonArrayValue("createNewAccountData","password"));
		driver.navigate().to("https://mail.google.com/");
		createAccount.gmailLoginAndAccountVerify("testuserforautomationmtime@gmail.com","Test@1234",jsonArrayValue("createNewAccountData","password"),emailIdGenrated);
		boolean headerValueAfterLogin=createAccount.headerAfterLoginSussusfully();
		Assert.assertEquals(headerValueAfterLogin,true);
		String hunredPoints=createAccount.pointsCreatedToAccountAfterRegister();
		Assert.assertEquals(hunredPoints,jsonArrayValue("Assertions","100PointMessage"));
		String myAccountHeader=createAccount.updatedTheProfile();
		Assert.assertEquals(myAccountHeader,jsonArrayValue("Assertions","MyOrderHeader"));
	}
	@Test (description="Verify that the user should be able to see the 500 points credited after updating their profile.",groups = {"Regression"})
	public void fiveHundredPoints() throws InterruptedException {
		String emailIdGenrated=EmailCombinationsGenerator.emailIdAndTheIndexCombinations("testuserforautomationm.time@gmail.com",jsonArrayValueInt("dataForEmailCombinations","TestCase4"));
		createAccount.createAccountOfNewUser(jsonArrayValue("createNewAccountData","firstName"),jsonArrayValue("createNewAccountData","lastName"), jsonArrayValue("createNewAccountData","country"), jsonArrayValue("createNewAccountData","primaryInstrument"), jsonArrayValue("createNewAccountData","hearAboutUs"), jsonArrayValue("createNewAccountData","educatated"),emailIdGenrated,jsonArrayValue("createNewAccountData","password"));
		driver.navigate().to("https://mail.google.com/");
		createAccount.gmailLoginAndAccountVerify("testuserforautomationmtime@gmail.com","Test@1234",jsonArrayValue("createNewAccountData","password"),emailIdGenrated);
		boolean headerValueAfterLogin=createAccount.headerAfterLoginSussusfully();
		Assert.assertEquals(headerValueAfterLogin,true);
		String hunredPoints=createAccount.pointsCreatedToAccountAfterRegister();
		Assert.assertEquals(hunredPoints,jsonArrayValue("Assertions","100PointMessage"));
		String myAccountHeader=createAccount.updatedTheProfile();
		Assert.assertEquals(myAccountHeader,jsonArrayValue("Assertions","MyOrderHeader"));
		String  fiveHundredCoins=createAccount.playerProfile(jsonArrayValue("guitarProfile","playerPlayOwnInstrument"),jsonArrayValue("guitarProfile","typeOfMusicMostOften"),jsonArrayValue("guitarProfile","instrumentDoYouTeach"),jsonArrayValue("guitarProfile","settingCurrentlyTeach"),jsonArrayValue("guitarProfile","studentTeachInWeek"),jsonArrayValue("guitarProfile","levelOfStudent"),jsonArrayValue("guitarProfile","brandAndAccessoriesCurretlyPlay"),jsonArrayValue("guitarProfile","stringInGuitarInstrumentChange"),jsonArrayValue("guitarProfile","setBuyAtATime"),jsonArrayValue("guitarProfile","gender"));
		Assert.assertEquals(fiveHundredCoins,jsonArrayValue("Assertions","500PointsCreadited"));
	}
	@Test(description="Verify that the user is able to see the '600' points credited after clicking on the profile.",groups = {"Smoke", "Regression"})
	public void sixHundredPoints() throws InterruptedException {
		String emailIdGenrated=EmailCombinationsGenerator.emailIdAndTheIndexCombinations("testuserforautomationm.time@gmail.com",jsonArrayValueInt("dataForEmailCombinations","TestCase5"));
		createAccount.createAccountOfNewUser(jsonArrayValue("createNewAccountData","firstName"),jsonArrayValue("createNewAccountData","lastName"), jsonArrayValue("createNewAccountData","country"), jsonArrayValue("createNewAccountData","primaryInstrument"), jsonArrayValue("createNewAccountData","hearAboutUs"), jsonArrayValue("createNewAccountData","educatated"),emailIdGenrated,jsonArrayValue("createNewAccountData","password"));
		driver.navigate().to("https://mail.google.com/");
		createAccount.gmailLoginAndAccountVerify("testuserforautomationmtime@gmail.com","Test@1234",jsonArrayValue("createNewAccountData","password"),emailIdGenrated);
		boolean headerValueAfterLogin=createAccount.headerAfterLoginSussusfully();
		Assert.assertEquals(headerValueAfterLogin,true);
		String hunredPoints=createAccount.pointsCreatedToAccountAfterRegister();
		Assert.assertEquals(hunredPoints,jsonArrayValue("Assertions","100PointMessage"));
		//This method use for the user if he already reisterToAccount
//		String value=login.SignInWithEmailAddressValidate();
//		Assert.assertEquals(value,jsonArrayValue("Assertions","TextInSingInPage"));
//		boolean headerLogo=login.loginEmailIdPassword(jsonArrayValue("createNewAccountData","emailId"),jsonArrayValue("createNewAccountData","password"));
		String myAccountHeader=createAccount.updatedTheProfile();
		Assert.assertEquals(myAccountHeader,jsonArrayValue("Assertions","MyOrderHeader"));
		String  fiveHundredCoins=createAccount.playerProfile(jsonArrayValue("guitarProfile","playerPlayOwnInstrument"),jsonArrayValue("guitarProfile","typeOfMusicMostOften"),jsonArrayValue("guitarProfile","instrumentDoYouTeach"),jsonArrayValue("guitarProfile","settingCurrentlyTeach"),jsonArrayValue("guitarProfile","studentTeachInWeek"),jsonArrayValue("guitarProfile","levelOfStudent"),jsonArrayValue("guitarProfile","brandAndAccessoriesCurretlyPlay"),jsonArrayValue("guitarProfile","stringInGuitarInstrumentChange"),jsonArrayValue("guitarProfile","setBuyAtATime"),jsonArrayValue("guitarProfile","gender")); 
		Assert.assertEquals(fiveHundredCoins,jsonArrayValue("Assertions","500PointsCreadited"));
		String sixHundredCoins=createAccount.checkForTheSixHundredCoins();
		Assert.assertEquals(sixHundredCoins,jsonArrayValue("Assertions","600PointMessage"));
	}
//	@Test(description="Verify that the user is able to see the '600' points credited after clicking on the profile.",groups = {"Smoke", "Regression"})
//	public void sixHundredPoints() throws InterruptedException {
//		String randomStringMail=UtilClass.genratedRandomailId(5);
//		System.out.println(randomStringMail);
//		createAccount.createAccountOfNewUser(jsonArrayValue("createNewAccountData","firstName"),jsonArrayValue("createNewAccountData","lastName"), jsonArrayValue("createNewAccountData","country"), jsonArrayValue("createNewAccountData","primaryInstrument"), jsonArrayValue("createNewAccountData","hearAboutUs"), jsonArrayValue("createNewAccountData","educatated"), randomStringMail, jsonArrayValue("createNewAccountData","password"));
//		driver.navigate().to("https://yopmail.com/en/");
//		boolean headerValueAfterLogin=createAccount.loginToYopMail((randomStringMail),jsonArrayValue("createNewAccountData","password"));
//		Assert.assertEquals(headerValueAfterLogin,true);
//		String hunredPoints=createAccount.pointsCreatedToAccountAfterRegister();
//		Assert.assertEquals(hunredPoints,jsonArrayValue("Assertions","100PointMessage"));
//		//This method use for the user if he already reisterToAccount
////		String value=login.SignInWithEmailAddressValidate();
////		Assert.assertEquals(value,jsonArrayValue("Assertions","TextInSingInPage"));
////		boolean headerLogo=login.loginEmailIdPassword(jsonArrayValue("createNewAccountData","emailId"),jsonArrayValue("createNewAccountData","password"));
//		String myAccountHeader=createAccount.updatedTheProfile();
//		Assert.assertEquals(myAccountHeader,jsonArrayValue("Assertions","MyOrderHeader"));
//		String  fiveHundredCoins=createAccount.playerProfile(jsonArrayValue("guitarProfile","playerPlayOwnInstrument"),jsonArrayValue("guitarProfile","typeOfMusicMostOften"),jsonArrayValue("guitarProfile","instrumentDoYouTeach"),jsonArrayValue("guitarProfile","settingCurrentlyTeach"),jsonArrayValue("guitarProfile","studentTeachInWeek"),jsonArrayValue("guitarProfile","levelOfStudent"),jsonArrayValue("guitarProfile","brandAndAccessoriesCurretlyPlay"),jsonArrayValue("guitarProfile","stringInGuitarInstrumentChange"),jsonArrayValue("guitarProfile","setBuyAtATime"),jsonArrayValue("guitarProfile","gender")); 
//		Assert.assertEquals(fiveHundredCoins,jsonArrayValue("Assertions","500PointsCreadited"));
//		String sixHundredCoins=createAccount.checkForTheSixHundredCoins();
//		Assert.assertEquals(sixHundredCoins,jsonArrayValue("Assertions","600PointMessage"));
//	}
	
	
	
	
	
//	@Test(description="Test with the tutanota")
//	public void registerUser() throws InterruptedException {
//		String randomStringMail=UtilClass.genratedRandomailId(5);
//		System.out.println(randomStringMail);
//		createAccount.createAccountOfNewUser(jsonArrayValue("createNewAccountData","firstName"),jsonArrayValue("createNewAccountData","lastName"), jsonArrayValue("createNewAccountData","country"), jsonArrayValue("createNewAccountData","primaryInstrument"), jsonArrayValue("createNewAccountData","hearAboutUs"), jsonArrayValue("createNewAccountData","educatated"),prop.getProperty("tutanotaMail"), jsonArrayValue("createNewAccountData","password"));
//		driver.navigate().to("https://yopmail.com/en/");
//	}
//	@Test(description="Test With the Gmail Login",groups = {"Regression"})
//	public void  registerIntoSystemTC001() throws InterruptedException {
//		String emailIdGenrated=EmailCombinationsGenerator.emailIdAndTheIndexCombinations("testuserforautomationm.time@gmail.com",23);
//		String randomStringMail=UtilClass.genratedRandomailId(5);
//		System.out.println(randomStringMail);
//		createAccount.createAccountOfNewUser(jsonArrayValue("createNewAccountData","firstName"),jsonArrayValue("createNewAccountData","lastName"), jsonArrayValue("createNewAccountData","country"), jsonArrayValue("createNewAccountData","primaryInstrument"), jsonArrayValue("createNewAccountData","hearAboutUs"), jsonArrayValue("createNewAccountData","educatated"),emailIdGenrated, jsonArrayValue("createNewAccountData","password"));
//		driver.navigate().to("https://mail.google.com/");
//		createAccount.gmailLoginAndAccountVerify("testuserforautomationm.time@gmail.com","Test@1234",jsonArrayValue("createNewAccountData","password"),emailIdGenrated);
//		Assert.assertEquals(headerValueAfterLogin,true);
//		String hunredPoints=createAccount.pointsCreatedToAccountAfterRegister();
//		Assert.assertEquals(hunredPoints,jsonArrayValue("Assertions","100PointMessage"));
////		This method use for the user if he already reisterToAccount
//		String value=login.SignInWithEmailAddressValidate();
//		Assert.assertEquals(value,jsonArrayValue("Assertions","TextInSingInPage"));
//		boolean headerLogo=login.loginEmailIdPassword(jsonArrayValue("createNewAccountData","emailId"),jsonArrayValue("createNewAccountData","password"));
//		String myAccountHeader=createAccount.updatedTheProfile();
//		Assert.assertEquals(myAccountHeader,jsonArrayValue("Assertions","MyOrderHeader"));
//		String  fiveHundredCoins=createAccount.playerProfile(jsonArrayValue("guitarProfile","playerPlayOwnInstrument"),jsonArrayValue("guitarProfile","typeOfMusicMostOften"),jsonArrayValue("guitarProfile","instrumentDoYouTeach"),jsonArrayValue("guitarProfile","settingCurrentlyTeach"),jsonArrayValue("guitarProfile","studentTeachInWeek"),jsonArrayValue("guitarProfile","levelOfStudent"),jsonArrayValue("guitarProfile","brandAndAccessoriesCurretlyPlay"),jsonArrayValue("guitarProfile","stringInGuitarInstrumentChange"),jsonArrayValue("guitarProfile","setBuyAtATime"),jsonArrayValue("guitarProfile","gender")); 
//		Assert.assertEquals(fiveHundredCoins,jsonArrayValue("Assertions","500PointsCreadited"));
//		String sixHundredCoins=createAccount.checkForTheSixHundredCoins();
//		Assert.assertEquals(sixHundredCoins,jsonArrayValue("Assertions","600PointMessage"));
//	}
	

}
