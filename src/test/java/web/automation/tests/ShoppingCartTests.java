package web.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import web.automation.base.Base;
import web.automation.base.DriverManager;
import web.automation.pages.AddToCartPage;
import web.automation.pages.ShoppingCartPage;
import web.automation.utils.CommonHelperMethods;

public class ShoppingCartTests extends Base{
	
	AddToCartPage addToCartPage;
	ShoppingCartPage shoppingCartPage;
	String firstProduct;
	String expectedTitle = "Shopping Cart";

	@Test(priority=1,testName="TC_SC_001",enabled=true,groups = "ShoppingCartPage")
	public void verifyNavigatingToShoppingCartPageFromTheSuccessMessage() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		addToCartPage.searchIconButtonWebElement().click();
		addToCartPage.firstProductImageWebElement().click();
		addToCartPage.addToCartBtnWebElement().click();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		shoppingCartPage.shoppingCartLinkWebElement().click();
		Assert.assertEquals(DriverManager.getDriver().getTitle(), expectedTitle);
		shoppingCartPage.removeBtnShoppingCartWebElement().click();
	}
	
	@Test(priority=2,testName="TC_SC_002",enabled=true,groups = "ShoppingCartPage")
	public void verifyNavigatingToShoppingCartPageFromTheShoppingCartHeaderOption() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		addToCartPage.searchIconButtonWebElement().click();
		addToCartPage.addToCartButtonWebElement().click();
		addToCartPage.shoppingCartHeaderWebElement().click();
		Assert.assertEquals(DriverManager.getDriver().getTitle(), expectedTitle);
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		shoppingCartPage.removeBtnShoppingCartWebElement().click();
	}
	
	@Test(priority=3,testName="TC_SC_003",enabled=true,groups = "ShoppingCartPage")
	public void verifyNavigatingToShoppingCartPageFromTheSiteMapFooterPage() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		addToCartPage.searchIconButtonWebElement().click();
		addToCartPage.addToCartButtonWebElement().click();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		CommonHelperMethods.scrollIntoView(shoppingCartPage.siteMapFooterWebElement(), DriverManager.getDriver());
		shoppingCartPage.siteMapFooterWebElement().click();
		shoppingCartPage.shoppingCartSiteMapWebElement().click();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		shoppingCartPage.removeBtnShoppingCartWebElement().click();
	}
	
	@Test(priority=4,testName="TC_SC_004",enabled=true,groups = "ShoppingCartPage")
	public void verifyTheCartButtonWhenThereAreNoProductsAddedToTheShoppingCart() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.addToCartPopupButtonWebElement().click();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		Assert.assertEquals(shoppingCartPage.shoppingCartEmptyMessageWebElement().getText(), "Your shopping cart is empty!");
	}
	
	@Test(priority=5,testName="TC_SC_005",enabled=true,groups = "ShoppingCartPage")
	public void verifyNavigatingToShoppingCartPageUsingTheViewCartOptionInTheCartblock() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		addToCartPage.searchIconButtonWebElement().click();
		addToCartPage.addToCartButtonWebElement().click();
		CommonHelperMethods.moveToElement(addToCartPage.addToCartPopupButtonWebElement(), DriverManager.getDriver());
		addToCartPage.addToCartPopupButtonWebElement().click();
		addToCartPage.viewCartLinkWebElement().click();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		Assert.assertEquals(DriverManager.getDriver().getTitle(), expectedTitle);
		shoppingCartPage.removeBtnShoppingCartWebElement().click();
	}
}
