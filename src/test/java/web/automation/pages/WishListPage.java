package web.automation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WishListPage {
	
	public WishListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//button[@data-original-title='Add to Wish List'])[2]")
	WebElement wishListButtonInRelatedProducts;
	
	@FindBy(xpath = "//div[@class='caption']//h4")
	WebElement firstRelatedProductHeader;
	
	@FindBy(linkText = "wish list")
	WebElement wishListLink;
	
	@FindBy(xpath = "//div[@id='content']//tbody//td[2]")
	WebElement productNameInWishListPage;
	
	@FindBy(linkText = "Qafox.com")
	WebElement logo;
	
	@FindBy(xpath = "(//button[@data-original-title='Add to Wish List'])[1]")
	WebElement wishListButtonInFeaturedProducts;
	
	@FindBy(xpath = "(//div[@class='caption']//h4)[1]")
	WebElement firstFeaturedProductHeader;
	
	@FindBy(xpath = "(//a[@data-original-title='Remove'])[1]")
	WebElement removeButtonInWishList;
	
	@FindBy(xpath = "//button[@data-original-title='Add to Wish List']")
	WebElement wishListButtonInCategoryProducts;
	
	@FindBy(xpath = "//div[@class='caption']//h4")
	WebElement firstSearchedProductHeader;
	
	@FindBy(xpath = "//button[@data-original-title='Add to Wish List']")
	WebElement wishListButtonInSearchedProducts;
	
	@FindBy(xpath = "//a[@title='My Account']")
	WebElement myAccountHeader;
	
	@FindBy(linkText = "My Account")
	WebElement myAccountOption;
	
	@FindBy(linkText = "Wish List")
	WebElement wishListRightOption;
	
	@FindBy(linkText = "Modify your wish list")
	WebElement modifyYourWishList;
	
	@FindBy(linkText = "Wish List")
	WebElement wishListFooter;
	
	@FindBy(linkText = "(//a[text()='My Account'])[2]")
	WebElement myAccountFooter;
	
	@FindBy(xpath = "//div[@id='content']//p")
	WebElement wishListEmptyMessage;
	
	@FindBy(linkText = "Continue")
	WebElement continueButtonInWishList;
	
	@FindBy(xpath = "//div[@id='account-wishlist']//div[contains(@class,'alert')]")
	WebElement successMessageAfterRemove;
	
	@FindBy(xpath = "//div[@id='content']//tbody//td[2]")
	List<WebElement> productNamesInWishListPage;
	
	@FindBy(xpath = "//a[@data-original-title='Remove']")
	List<WebElement> removeButtonsInWishList;
	
	public WebElement wishListButtonInRelatedProductsWebElement() {
		return wishListButtonInRelatedProducts;
	}
	
	public WebElement firstRelatedProductHeaderWebElement() {
		return firstRelatedProductHeader;
	}
	
	public WebElement wishListLinkWebElement() {
		return wishListLink;
	}
	
	public WebElement productNameInWishListPageWebElement() {
		return productNameInWishListPage;
	}
	
	public WebElement logoWebElement() {
		return logo;
	}

	public WebElement wishListButtonInFeaturedProductsWebElement() {
		return wishListButtonInFeaturedProducts;
	}
	
	public WebElement firstFeaturedProductHeaderWebElement() {
		return firstFeaturedProductHeader;
	}
	
	public WebElement removeButtonInWishListWebElement() {
		return removeButtonInWishList;
	}
	
	public WebElement wishListButtonInCategoryProductsWebElement() {
		return wishListButtonInCategoryProducts;
	}
	
	public WebElement firstSearchedProductHeaderWebElement() {
		return firstSearchedProductHeader;
	}
	
	public WebElement wishListButtonInSearchedProductsWebElement() {
		return wishListButtonInSearchedProducts;
	}
	
	public WebElement myAccountHeaderWebElement() {
		return myAccountHeader;
	}
	
	public WebElement myAccountOptionWebElement() {
		return myAccountOption;
	}
	
	public WebElement wishListRightOptionWebElement() {
		return wishListRightOption;
	}
	
	public WebElement modifyYourWishListWebElement() {
		return modifyYourWishList;
	}
	
	public WebElement wishListFooterWebElement() {
		return wishListFooter;
	}
	
	public WebElement myAccountFooterWebElement() {
		return myAccountFooter;
	}
	
	public WebElement wishListEmptyMessageWebElement() {
		return wishListEmptyMessage;
	}
	
	public WebElement continueButtonInWishListWebElement() {
		return continueButtonInWishList;
	}
	
	public WebElement successMessageAfterRemoveWebElement() {
		return successMessageAfterRemove;
	}
	
	public List<WebElement> productNamesInWishListPageWebElement() {
		return productNamesInWishListPage;
	}
	
	public List<WebElement> removeButtonsInWishListWebElement() {
		return removeButtonsInWishList;
	}
	
}
