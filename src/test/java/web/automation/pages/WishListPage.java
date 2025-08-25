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
	
	public void clickWishListButtonInRelatedProducts() {
		wishListButtonInRelatedProducts.click();
	}
	
	public WebElement wishListButtonInRelatedProductsWebElement() {
		return wishListButtonInRelatedProducts;
	}
	
	public String getFirstRelatedProductHeader() {
		return firstRelatedProductHeader.getText();
	}
	
	public void clickWishListLink() {
		wishListLink.click();
	}
	
	public WebElement wishListLinkWebElement() {
		return wishListLink;
	}
	
	public String getProductNameInWishListPage() {
		return productNameInWishListPage.getText();
	}
	
	public WebElement logoWebElement() {
		return logo;
	}

	public void clickWishListButtonInFeaturedProducts() {
		wishListButtonInFeaturedProducts.click();
	}
	
	public WebElement wishListButtonInFeaturedProductsWebElement() {
		return wishListButtonInFeaturedProducts;
	}
	
	public String getFirstFeaturedProductHeader() {
		return firstFeaturedProductHeader.getText();
	}
	
	public void clickRemoveButtonInWishList() {
		removeButtonInWishList.click();
	}
	
	public WebElement removeButtonInWishListWebElement() {
		return removeButtonInWishList;
	}
	
	public void clickWishListButtonInCategoryProducts() {
		wishListButtonInCategoryProducts.click();
	}
	
	public WebElement wishListButtonInCategoryProductsWebElement() {
		return wishListButtonInCategoryProducts;
	}
	
	public String getFirstSearchedProductHeader() {
		return firstSearchedProductHeader.getText();
	}
	
	public void clickWishListButtonInSearchedProducts() {
		wishListButtonInSearchedProducts.click();
	}
	
	public WebElement wishListButtonInSearchedProductsWebElement() {
		return wishListButtonInSearchedProducts;
	}
	
	public void clickMyAccountHeader() {
		myAccountHeader.click();
	}
	
	public void clickMyAccountOption() {
		myAccountOption.click();
	}
	
	public WebElement myAccountOptionWebElement() {
		return myAccountOption;
	}
	
	public void clickWishListRightOption() {
		wishListRightOption.click();
	}
	
	public void clickModifyYourWishList() {
		modifyYourWishList.click();
	}
	
	public void clickWishListFooter() {
		wishListFooter.click();
	}
	
	public WebElement wishListFooterWebElement() {
		return wishListFooter;
	}
	
	public void clickMyAccountFooter() {
		myAccountFooter.click();
	}
	
	public String getWishListEmptyMessage() {
		return wishListEmptyMessage.getText();
	}
	
	public void clickContinueButtonInWishList() {
		continueButtonInWishList.click();
	}
	
	public String getSuccessMessageAfterRemove() {
		return successMessageAfterRemove.getText().replace('×', ' ').trim();
	}
	
	public List<WebElement> productNamesInWishListPageWebElement() {
		return productNamesInWishListPage;
	}
	
	public List<WebElement> removeButtonsInWishListWebElement() {
		return removeButtonsInWishList;
	}
	
}
