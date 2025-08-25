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
	
	@FindBy(id = "input-quantity")
	WebElement quantityInputBox;
	
	@FindBy(xpath = "(//div[@id='content']//h2)[2]")
	WebElement unitPrice;
	
	@FindBy(xpath = "(//div[@id='content']//table)[1]//tbody//td[2]//a")
	WebElement productName;
	
	@FindBy(xpath = "(//div[@id='content']//table)[1]//tbody//td[3]")
	WebElement productModel;
	
	@FindBy(xpath = "(//div[@id='content']//table)[1]//tbody//td[4]//input")
	WebElement quantityInCart;
	
	@FindBy(xpath = "(//div[@id='content']//table)[1]//tbody//td[5]")
	WebElement unitPriceInCart;
	
	@FindBy(xpath = "(//div[@id='content']//table)[1]//tbody//td[6]")
	WebElement totalInCart;
	
	@FindBy(xpath = "//button[@data-original-title='Update']")
	WebElement updateButtonInCart;
	
	@FindBy(xpath = "(//div[@id = 'checkout-cart']//div[contains(@class,'alert')])[1]")
	WebElement modifiedMessageInCart;
	
	@FindBy(xpath = "//a[@href='#collapse-coupon']")
	WebElement useCouponCode;
	
	@FindBy(id = "input-coupon")
	WebElement enterYourCouponTextbox;
	
	@FindBy(id = "button-coupon")
	WebElement applyCouponButton;
	
	@FindBy(xpath = "//div[contains(@class,'alert')]")
	WebElement couponWarningMessage;
	
	@FindBy(xpath = "//button[@data-dismiss='alert']")
	WebElement closeButtonInMessage;
	
	@FindBy(xpath = "//a[@href='#collapse-shipping']")
	WebElement estimateShippingTaxes;
	
	@FindBy(id = "input-country")
	WebElement countryDropdown;
	
	@FindBy(id = "input-zone")
	WebElement regionStateDropdown;
	
	@FindBy(id = "button-quote")
	WebElement getQuotesButton;
	
	@FindBy(xpath = "//input[@name='shipping_method']")
	WebElement flatShippingRateRadioBtn;
	
	@FindBy(id = "button-shipping")
	WebElement applyShippingButton;
	
	public void clickShoppingCartLink() {
		shoppingCartLink.click();
	}
	
	public void clickRemoveBtnShoppingCart() {
		removeBtnShoppingCart.click();
	}
	
	public WebElement removeBtnShoppingCartWebElement() {
		return removeBtnShoppingCart;
	}
	
	public void clickSiteMapFooter() {
		siteMapFooter.click();
	}
	
	public WebElement siteMapFooterWebElement() {
		return siteMapFooter;
	}

	public void clickShoppingCartSiteMap() {
		shoppingCartSiteMap.click();
	}
	
	public String getShoppingCartEmptyMessage() {
		return shoppingCartEmptyMessage.getText();
	}
	
	public void clearingQuantityInputBox() {
		quantityInputBox.clear();
	}
	
	public void enterQuantityInputBox(String quantity) {
		quantityInputBox.sendKeys(quantity);
	}
	
	public String getUnitPrice() {
		return unitPrice.getText().substring(1);
	}
	
	public String getProductName() {
		return productName.getText();
	}
	
	public String getProductModel() {
		return productModel.getText();
	}
	
	public String getQuantityInCart(String attributeValue) {
		return quantityInCart.getDomAttribute(attributeValue);
	}
	
	public void clearQuantityInCart() {
		quantityInCart.clear();
	}
	
	public void enterQuantityInCart(String quantity) {
		quantityInCart.sendKeys(quantity);
	}
	
	public String getUnitPriceInCart() {
		return unitPriceInCart.getText();
	}
	
	public String getTotalInCart() {
		return totalInCart.getText().replace(",", "");
	}
	
	public void clickUpdateButtonInCart() {
		updateButtonInCart.click();
	}
	
	public String getModifiedMessage() {
		return modifiedMessageInCart.getText().replace("×", " ").trim();
	}
	
	public void clickUseCouponCode() {
		useCouponCode.click();
	}
	
	public void enterYourCouponTextbox(String coupon) {
		enterYourCouponTextbox.sendKeys(coupon);
	}
	
	public String getEnterYourCouponTextboxPlaceholder(String attributeValue) {
		return enterYourCouponTextbox.getDomAttribute(attributeValue);
	}
	
	public void clickApplyCouponButton() {
		applyCouponButton.click();
	}
	
	public String getCouponWarningMessage() {
		return couponWarningMessage.getText().replace("×", " ").trim();
	}
	
	public WebElement couponWarningMessageWebElement() {
		return couponWarningMessage;
	}
	
	public void clickCloseButtonInMessage() {
		closeButtonInMessage.click();
	}
	
	public void clickEstimateShippingTaxes() {
		estimateShippingTaxes.click();
	}
	
	public WebElement countryDropdownWebElement() {
		return countryDropdown;
	}
	
	public WebElement regionStateDropdownWebElement() {
		return regionStateDropdown;
	}
	
	public void clickGetQuotesButton() {
		getQuotesButton.click();
	}
	
	public void clickFlatShippingRateRadioBtn() {
		flatShippingRateRadioBtn.click();
	}
	
	public void clickApplyShippingButton() {
		applyShippingButton.click();
	}
}
