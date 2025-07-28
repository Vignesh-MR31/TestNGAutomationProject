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
		loginPage.myAccountElement().click();
		loginPage.loginOptionElement().click();
		loginPage.emailAddressElement().sendKeys("Vickymr@gmail.com");
		loginPage.passwordElement().sendKeys("123456789");
		loginPage.loginButtonElement().click();
		String expectedHeader = "My Account";
		Assert.assertEquals(expectedHeader, loginPage.myAccountHeaderElement().getText());
	}

}
