package Pkg.Test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Pkg.BaseClass.BaseClass;


public class LoginTest extends BaseClass{
	@Test(description="Verify that the user should be able to log into the system",groups = {"Regression"})
	public void loginTestCaseTC001() {
		String value=login.SignInWithEmailAddressValidate();
		Assert.assertEquals(value,jsonArrayValue("Assertions","TextValueInSignInPageWrong"));
		login.loginEmailIdPassword(prop.getProperty("Username"),prop.getProperty("Password"));
		
	}
	@Test(description="Verify that when a user logs into the system for the first time, the user should be navigated to the dashboard page",groups = {"Smoke", "Regression"})
	public void homePageTestCaseTC002() {
		String value=login.SignInWithEmailAddressValidate();
		Assert.assertEquals(value,jsonArrayValue("Assertions","TextInSingInPage"));
		boolean headerLogo=login.loginEmailIdPassword(prop.getProperty("Username"),prop.getProperty("Password"));
		Assert.assertEquals(headerLogo, true);
	}
	
	
}
