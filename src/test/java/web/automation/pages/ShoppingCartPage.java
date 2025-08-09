package web.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {
	
	public ShoppingCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "shopping cart")
	WebElement shoppingCartLink;
	
	@FindBy(xpath = "//button[@data-original-title='Remove']")
	WebElement removeBtnShoppingCart;
	
	@FindBy(linkText = "Site Map")
	WebElement siteMapFooter;
	
	@FindBy(linkText = "Shopping Cart")
	WebElement shoppingCartSiteMap;
	
	@FindBy(xpath = "//div[@id='cart']//p")
	WebElement shoppingCartEmptyMessage;
	
	public WebElement shoppingCartLinkWebElement() {
		return shoppingCartLink;
	}
	
	public WebElement removeBtnShoppingCartWebElement() {
		return removeBtnShoppingCart;
	}
	
	public WebElement siteMapFooterWebElement() {
		return siteMapFooter;
	}

	public WebElement shoppingCartSiteMapWebElement() {
		return shoppingCartSiteMap;
	}
	
	public WebElement shoppingCartEmptyMessageWebElement() {
		return shoppingCartEmptyMessage;
	}
}
