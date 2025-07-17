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
	
	public WebElement myAccountElement() {
		return myAccount;
	}
	
	public WebElement loginOptionElement() {
		return loginOption;
	}
	
	public WebElement emailAddressElement() {
		return emailAddress;
	}
	
	public WebElement passwordElement() {
		return password;
	}
	
	public WebElement loginButtonElement() {
		return loginButton;
	}
	
	public WebElement myAccountHeaderElement() {
		return myAccountHeader;
	}

}
