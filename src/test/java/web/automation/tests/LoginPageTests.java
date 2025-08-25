package web.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import web.automation.base.Base;
import web.automation.base.DriverManager;
import web.automation.pages.LoginPage;

public class LoginPageTests extends Base {

	private LoginPage loginPage;

	@Test(priority = 1, groups = "LoginPage")
	public void loginUserWithValidCredentials() {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.clickmyAccount();
		loginPage.clickLoginOption();
		loginPage.enteringEmailAddress("Vickymr@gmail.com");
		loginPage.enteringPassword("123456789");
		loginPage.clickloginButton();
		Assert.assertTrue(loginPage.myAccountHeaderElementIsDisplayed("My Account"));
	}

}
