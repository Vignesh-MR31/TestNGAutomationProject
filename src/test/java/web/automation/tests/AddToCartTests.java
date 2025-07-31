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
		addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		addToCartPage.searchIconButtonWebElement().click();
		firstProduct = addToCartPage.firstProductHeaderWebElement().getText();
		addToCartPage.firstProductImageWebElement().click();
		addToCartPage.addToCartBtnWebElement().click();
		String expectedMessage = "Success: You have added "+firstProduct+" to your shopping cart!";
		Assert.assertEquals(expectedMessage, addToCartPage.addToCartSuccessMessageWebElement().getText().replace('×', ' ').trim());
	}
	
	@Test(priority=2,testName="TC_ATC_002",enabled=true,groups = "AddToCartPage")
	public void verifyAddingTheProductToCartFromWishListPage() throws InterruptedException {
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
		firstProduct = addToCartPage.firstProductHeaderWebElement().getText();
		addToCartPage.firstProductImageWebElement().click();
		Thread.sleep(2000);
		CommonHelperMethods.moveToElement(addToCartPage.addToWishListButtonWebElement(), DriverManager.getDriver());
		CommonHelperMethods.jsClick(addToCartPage.addToWishListButtonWebElement(), DriverManager.getDriver());
		//addToCartPage.addToWishListButtonWebElement().click();
		addToCartPage.wishListHeaderWebElement().click();
		addToCartPage.addToCartInWishListWebElement().click();
		addToCartPage.shoppingCartHeaderWebElement().click();
		Assert.assertEquals(firstProduct, addToCartPage.productNameInCartWebElement().getText());
		addToCartPage.wishListHeaderWebElement().click();
		wishListPage = new WishListPage(DriverManager.getDriver());
		wishListPage.removeButtonInWishListWebElement().click();
	}
	
	@Test(priority=3,testName="TC_ATC_003",enabled=true,groups = "AddToCartPage")
	public void verifyAddingTheProductToCartFromSearchResultsPage() throws InterruptedException {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		addToCartPage.searchIconButtonWebElement().click();
		firstProduct = addToCartPage.firstProductHeaderWebElement().getText();
		addToCartPage.addToCartButtonWebElement().click();
		Thread.sleep(2000);
		addToCartPage.addToCartPopupButtonWebElement().click();
		addToCartPage.viewCartLinkWebElement().click();
		Assert.assertEquals(firstProduct, addToCartPage.productNameInCartWebElement().getText());
	}
	
	@Test(priority=4,testName="TC_ATC_004",enabled=true,groups = "AddToCartPage")
	public void verifyingTheProductToCartFromTheRelatedProductsSectionOfTheProductDisplayPage() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.searchInputTextboxWebElement().sendKeys("Apple Cinema 30");
		addToCartPage.searchIconButtonWebElement().click();
		addToCartPage.firstProductImageWebElement().click();
		CommonHelperMethods.visibilityOfElement(addToCartPage.relatedProductsFirstProductNameWebElement(),DriverManager.getDriver());
		relatedProductsFirstProduct = addToCartPage.relatedProductsFirstProductNameWebElement().getText();
		addToCartPage.relatedProductsAddToCartButtonWebElement().click();
		addToCartPage.shoppingCartHeaderWebElement().click();
		Assert.assertEquals(relatedProductsFirstProduct, addToCartPage.productNameInCartWebElement().getText());
	}
	
	@Test(priority=5,testName="TC_ATC_005",enabled=true,groups = "AddToCartPage")
	public void verifyAddingTheProductToCartFromTheProductsDisplayedInTheCategoryOrSubcategoryPage()  {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.desktopsDropdownWebElement().click();
		addToCartPage.showAllDesktopsWebElement().click();
		addToCartPage.macOptionWebElement().click();
		firstProduct = addToCartPage.firstProductHeaderWebElement().getText();
		addToCartPage.addToCartButtonWebElement().click();
		addToCartPage.shoppingCartHeaderWebElement().click();
		Assert.assertEquals(firstProduct, addToCartPage.productNameInCartWebElement().getText());
	}
	
	@Test(priority=6,testName="TC_ATC_006",enabled=false,groups = "AddToCartPage")
	public void verifyAddingTheProductToCartFromTheProductsDisplayedInTheFeaturedSectionOfHomePage() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		firstProduct = addToCartPage.firstProductHeaderWebElement().getText();
		addToCartPage.addToCartButtonWebElement().click();
		addToCartPage.shoppingCartHeaderWebElement().click();
		Assert.assertEquals(firstProduct, addToCartPage.productNameInCartWebElement().getText());
	}
	
	@Test(priority=7,testName="TC_ATC_007",enabled=true,groups = "AddToCartPage")
	public void verifyAddingTheProductToCartFromProductComparisonPage() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		addToCartPage.searchIconButtonWebElement().click();
		firstProduct = addToCartPage.firstProductHeaderWebElement().getText();
		addToCartPage.compareThisProductButtonWebElement().click();
		addToCartPage.productCompareLinkWebElement().click();
		addToCartPage.addToCartInProductCompareWebElement().click();
		addToCartPage.shoppingCartHeaderWebElement().click();
		Assert.assertEquals(firstProduct, addToCartPage.productNameInCartWebElement().getText());
	}
	
}
