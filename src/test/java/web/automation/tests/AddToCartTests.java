package web.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import web.automation.base.Base;
import web.automation.base.DriverManager;
import web.automation.pages.AddToCartPage;
import web.automation.pages.LoginPage;
import web.automation.pages.WishListPage;
import web.automation.utils.CommonHelperMethods;


public class AddToCartTests extends Base{
	
	private AddToCartPage addToCartPage;
	private LoginPage loginPage;
	WishListPage wishListPage;
	String firstProduct;
	String relatedProductsFirstProduct;

	@Test(priority=1,testName="TC_ATC_001",enabled=true,groups = "AddToCartPage")
	public void verifyAddingTheProductToCartFromProductDisplayPage() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		firstProduct = addToCartPage.gettingFirstProductHeader();
		addToCartPage.firstProductImageClick();
		addToCartPage.clickAddToCartBtn();
		String expectedMessage = "Success: You have added "+firstProduct+" to your shopping cart!";
		Assert.assertEquals(expectedMessage, addToCartPage.getAddToCartSuccessMessage());
	}
	
	@Test(priority=2,testName="TC_ATC_002",enabled=true,groups = "AddToCartPage")
	public void verifyAddingTheProductToCartFromWishListPage() throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.clickmyAccount();
		loginPage.clickLoginOption();
		loginPage.enteringEmailAddress("Vickymr@gmail.com");
		loginPage.enteringPassword("123456789");
		loginPage.clickloginButton();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		firstProduct = addToCartPage.gettingFirstProductHeader();
		addToCartPage.firstProductImageClick();
		Thread.sleep(2000);
		//CommonHelperMethods.scrollIntoView(addToCartPage.addToWishListButtonWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(addToCartPage.addToWishListButtonWebElement(), DriverManager.getDriver());
		addToCartPage.clickAddToWishListButton();
		addToCartPage.clickWishListHeader();
		addToCartPage.clickAddToCartInWishList();
		addToCartPage.clickShoppingCartHeader();
		Assert.assertEquals(firstProduct, addToCartPage.getProductNameInCart());
		addToCartPage.clickWishListHeader();
		wishListPage = new WishListPage(DriverManager.getDriver());
		wishListPage.clickRemoveButtonInWishList();
	}
	
	@Test(priority=3,testName="TC_ATC_003",enabled=true,groups = "AddToCartPage")
	public void verifyAddingTheProductToCartFromSearchResultsPage() throws InterruptedException {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		firstProduct = addToCartPage.gettingFirstProductHeader();
		addToCartPage.clickAddToCartButton();
		Thread.sleep(2000);
		addToCartPage.clickAddToCartPopupButton();
		addToCartPage.clickViewCartLink();
		Assert.assertEquals(firstProduct, addToCartPage.getProductNameInCart());
	}
	
	@Test(priority=4,testName="TC_ATC_004",enabled=true,groups = "AddToCartPage")
	public void verifyingTheProductToCartFromTheRelatedProductsSectionOfTheProductDisplayPage() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("Apple Cinema 30");
		addToCartPage.searchIconButtonClick();
		addToCartPage.firstProductImageClick();
		CommonHelperMethods.visibilityOfElement(addToCartPage.relatedProductsFirstProductNameWebElement(),DriverManager.getDriver());
		relatedProductsFirstProduct = addToCartPage.getRelatedProductsFirstProductName();
		addToCartPage.clickRelatedProductsAddToCartButton();
		addToCartPage.clickShoppingCartHeader();
		Assert.assertEquals(relatedProductsFirstProduct, addToCartPage.getProductNameInCart());
	}
	
	@Test(priority=5,testName="TC_ATC_005",enabled=true,groups = "AddToCartPage")
	public void verifyAddingTheProductToCartFromTheProductsDisplayedInTheCategoryOrSubcategoryPage()  {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.clickDesktopsDropdown();
		addToCartPage.clickShowAllDesktops();
		addToCartPage.clickMacOptionWebElement();
		firstProduct = addToCartPage.gettingFirstProductHeader();
		addToCartPage.clickAddToCartButton();
		addToCartPage.clickShoppingCartHeader();
		Assert.assertEquals(firstProduct, addToCartPage.getProductNameInCart());
	}
	
	@Test(priority=6,testName="TC_ATC_006",enabled=false,groups = "AddToCartPage")
	public void verifyAddingTheProductToCartFromTheProductsDisplayedInTheFeaturedSectionOfHomePage() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		firstProduct = addToCartPage.gettingFirstProductHeader();
		addToCartPage.clickAddToCartButton();
		addToCartPage.clickShoppingCartHeader();
		Assert.assertEquals(firstProduct, addToCartPage.getProductNameInCart());
	}
	
	@Test(priority=7,testName="TC_ATC_007",enabled=true,groups = "AddToCartPage")
	public void verifyAddingTheProductToCartFromProductComparisonPage() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		firstProduct = addToCartPage.gettingFirstProductHeader();
		addToCartPage.clickCompareThisProductButton();
		addToCartPage.clickProductCompareLink();
		addToCartPage.clickAddToCartInProductCompare();
		addToCartPage.clickShoppingCartHeader();
		Assert.assertEquals(firstProduct, addToCartPage.getProductNameInCart());
	}
	
}
