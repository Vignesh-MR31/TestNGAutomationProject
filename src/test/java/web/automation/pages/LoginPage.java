package web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[@title='My Account']")
	private WebElement myAccount;
	
	@FindBy(linkText = "Login")
	private WebElement loginOption;
	
	@FindBy(id = "input-email")
	private WebElement emailAddress;
	
	@FindBy(id = "input-password")
	private WebElement password;
	
	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;
	
	@FindBy(xpath = "(//div[@id='content']/h2)[1]")
	private WebElement myAccountHeader;
	
	public void clickmyAccount() {
		myAccount.click();
	}
	
	public void clickLoginOption() {
		loginOption.click();
	}
	
	public void enteringEmailAddress(String emailText) {
		emailAddress.sendKeys(emailText);
	}
	
	public void enteringPassword(String passwordText) {
		password.sendKeys(passwordText);
	}
	
	public void clickloginButton() {
		loginButton.click();
	}
	
	public boolean myAccountHeaderElementIsDisplayed(String header) {
		if(myAccountHeader.getText().equalsIgnoreCase(header)) {
			return true;
		}
		else {
			return false;
		}
	}

}
