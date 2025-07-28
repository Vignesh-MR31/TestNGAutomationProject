package web.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import web.automation.base.Base;
import web.automation.base.DriverManager;
import web.automation.pages.AddToCartPage;
import web.automation.pages.LoginPage;
import web.automation.pages.WishListPage;
import web.automation.utils.CommonHelperMethods;

public class WishListTests extends Base{
	
	private LoginPage loginPage;
	private AddToCartPage addToCartPage;
	WishListPage wishListPage;
	String firstRelatedProduct;
	String firstFeaturedProduct;
	String firstProduct;
	String firstSearchedProduct;
	
	@Test(priority=1,testName="TC_WL_001",enabled=true,groups = "WishListPage")
	public void verifyAddingAProductToWishListPageFromTheProductThatIsDisplayedInTheRelatedProductsSectionOfProductDisplayPage() throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.myAccountElement().click();
		loginPage.loginOptionElement().click();
		loginPage.emailAddressElement().sendKeys("Vickymr@gmail.com");
		loginPage.passwordElement().sendKeys("123456789");
		loginPage.loginButtonElement().click();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		addToCartPage.searchIconButtonWebElement().click();
		addToCartPage.firstProductImageWebElement().click();
		wishListPage = new WishListPage(DriverManager.getDriver());
		firstRelatedProduct = wishListPage.firstRelatedProductHeaderWebElement().getText();
		Thread.sleep(2000);
		wishListPage.wishListButtonInRelatedProductsWebElement().click();
		CommonHelperMethods.scrollIntoView(wishListPage.wishListLinkWebElement(), DriverManager.getDriver());
		CommonHelperMethods.visibilityOfElement(wishListPage.wishListLinkWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.wishListLinkWebElement().click();
		Assert.assertEquals(wishListPage.productNameInWishListPageWebElement().getText(), firstRelatedProduct);
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.removeButtonInWishListWebElement().click();
	}
	
	@Test(priority=2,testName="TC_WL_002",enabled=true,groups = "WishListPage")
	public void VerifyAddingAProductToWishListPageFromTheProductThatIsDisplayedInTheFeaturedSectionOfHomePage() throws InterruptedException{
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.myAccountElement().click();
		loginPage.loginOptionElement().click();
		loginPage.emailAddressElement().sendKeys("Vickymr@gmail.com");
		loginPage.passwordElement().sendKeys("123456789");
		loginPage.loginButtonElement().click();
		wishListPage = new WishListPage(DriverManager.getDriver());
		CommonHelperMethods.handlingStaleElementException(wishListPage.logoWebElement());
		firstFeaturedProduct = wishListPage.firstFeaturedProductHeaderWebElement().getText();
		Thread.sleep(2000);
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInFeaturedProductsWebElement(), DriverManager.getDriver());
		wishListPage.wishListButtonInFeaturedProductsWebElement().click();
		Thread.sleep(2000);
		wishListPage.wishListLinkWebElement().click();
		Assert.assertEquals(wishListPage.productNameInWishListPageWebElement().getText(), firstFeaturedProduct);
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.removeButtonInWishListWebElement().click();
	}

	@Test(priority=3,testName="TC_WL_003",enabled=true,groups = "WishListPage")
	public void VerifyAddingTheProductToWishListFromTheProductsDisplayedInTheCategoryOrSubCategoryPage() throws InterruptedException{
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.myAccountElement().click();
		loginPage.loginOptionElement().click();
		loginPage.emailAddressElement().sendKeys("Vickymr@gmail.com");
		loginPage.passwordElement().sendKeys("123456789");
		loginPage.loginButtonElement().click();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.desktopsDropdownWebElement().click();
		addToCartPage.showAllDesktopsWebElement().click();
		addToCartPage.macOptionWebElement().click();
		firstProduct = addToCartPage.firstProductHeaderWebElement().getText();
		wishListPage = new WishListPage(DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.wishListButtonInCategoryProductsWebElement().click();
		Thread.sleep(2000);
		wishListPage.wishListLinkWebElement().click();
		Assert.assertEquals(wishListPage.productNameInWishListPageWebElement().getText(), firstProduct);
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.removeButtonInWishListWebElement().click();
	}
	
	@Test(priority=4,testName="TC_WL_004",enabled=true,groups = "WishListPage")
	public void verifyAddingAProductToWishListPageFromTheSearchResultsPage() throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.myAccountElement().click();
		loginPage.loginOptionElement().click();
		loginPage.emailAddressElement().sendKeys("Vickymr@gmail.com");
		loginPage.passwordElement().sendKeys("123456789");
		loginPage.loginButtonElement().click();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		addToCartPage.searchIconButtonWebElement().click();
		wishListPage = new WishListPage(DriverManager.getDriver());
		firstSearchedProduct = wishListPage.firstSearchedProductHeaderWebElement().getText();
		Thread.sleep(2000);
		wishListPage.wishListButtonInCategoryProductsWebElement().click();
		Thread.sleep(2000);
		wishListPage.wishListLinkWebElement().click();
		Assert.assertEquals(wishListPage.productNameInWishListPageWebElement().getText(), firstSearchedProduct);
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.removeButtonInWishListWebElement().click();
	}
	
	@Test(priority=5,testName="TC_WL_005",enabled=true,groups = "WishListPage")
	public void verifyNavigatingToMyWishListPageUsingTheWishListHeaderOption() throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.myAccountElement().click();
		loginPage.loginOptionElement().click();
		loginPage.emailAddressElement().sendKeys("Vickymr@gmail.com");
		loginPage.passwordElement().sendKeys("123456789");
		loginPage.loginButtonElement().click();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		addToCartPage.searchIconButtonWebElement().click();
		wishListPage = new WishListPage(DriverManager.getDriver());
		firstSearchedProduct = wishListPage.firstSearchedProductHeaderWebElement().getText();
		Thread.sleep(2000);
		wishListPage.wishListButtonInCategoryProductsWebElement().click();
		addToCartPage.wishListHeaderWebElement().click();
		Assert.assertEquals(wishListPage.productNameInWishListPageWebElement().getText(), firstSearchedProduct);
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.removeButtonInWishListWebElement().click();
	}
	
	@Test(priority=6,testName="TC_WL_006",enabled=false,groups = "WishListPage")
	public void verifyNavigatingToMyWishListPageUsingTheRightColumnHeaderOptions() throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.myAccountElement().click();
		loginPage.loginOptionElement().click();
		loginPage.emailAddressElement().sendKeys("Vickymr@gmail.com");
		loginPage.passwordElement().sendKeys("123456789");
		loginPage.loginButtonElement().click();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		addToCartPage.searchIconButtonWebElement().click();
		wishListPage = new WishListPage(DriverManager.getDriver());
		firstSearchedProduct = wishListPage.firstSearchedProductHeaderWebElement().getText();
		Thread.sleep(2000);
		wishListPage.wishListButtonInCategoryProductsWebElement().click();
		wishListPage.myAccountHeaderWebElement().click();
		CommonHelperMethods.moveToElement(wishListPage.myAccountOptionWebElement(), DriverManager.getDriver());
		wishListPage.myAccountOptionWebElement().click();
		try {
			wishListPage.wishListRightOptionWebElement().click();
		} catch (Exception e) {
			wishListPage.myAccountHeaderWebElement().click();
			CommonHelperMethods.moveToElement(wishListPage.myAccountOptionWebElement(), DriverManager.getDriver());
			wishListPage.myAccountOptionWebElement().click();
		}
		Assert.assertEquals(wishListPage.productNameInWishListPageWebElement().getText(), firstSearchedProduct);
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.removeButtonInWishListWebElement().click();
	}
	
	@Test(priority=7,testName="TC_WL_007",enabled=false,groups = "WishListPage")
	public void verifyNavigatingToMyWishListPageFromTheMyAccountPage () throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.myAccountElement().click();
		loginPage.loginOptionElement().click();
		loginPage.emailAddressElement().sendKeys("Vickymr@gmail.com");
		loginPage.passwordElement().sendKeys("123456789");
		loginPage.loginButtonElement().click();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		addToCartPage.searchIconButtonWebElement().click();
		wishListPage = new WishListPage(DriverManager.getDriver());
		firstSearchedProduct = wishListPage.firstSearchedProductHeaderWebElement().getText();
		Thread.sleep(2000);
		wishListPage.wishListButtonInCategoryProductsWebElement().click();
		Thread.sleep(2000);
		CommonHelperMethods.scrollIntoViewDownward(DriverManager.getDriver());
		wishListPage.myAccountFooterWebElement().click();
		wishListPage.modifyYourWishListWebElement().click();
		Assert.assertEquals(wishListPage.productNameInWishListPageWebElement().getText(), firstSearchedProduct);
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.removeButtonInWishListWebElement().click();
	}
	
	@Test(priority=8,testName="TC_WL_008",enabled=true,groups = "WishListPage")
	public void verifyNavigatingToMyWishListPageFromTheFooteroptions() throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.myAccountElement().click();
		loginPage.loginOptionElement().click();
		loginPage.emailAddressElement().sendKeys("Vickymr@gmail.com");
		loginPage.passwordElement().sendKeys("123456789");
		loginPage.loginButtonElement().click();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		try {
			addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		} catch (Exception e) {
			addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		}
		addToCartPage.searchIconButtonWebElement().click();
		wishListPage = new WishListPage(DriverManager.getDriver());
		firstSearchedProduct = wishListPage.firstSearchedProductHeaderWebElement().getText();
		Thread.sleep(2000);
		wishListPage.wishListButtonInCategoryProductsWebElement().click();
		wishListPage.wishListFooterWebElement().click();
		Assert.assertEquals(wishListPage.productNameInWishListPageWebElement().getText(), firstSearchedProduct);
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.removeButtonInWishListWebElement().click();
	}
}
