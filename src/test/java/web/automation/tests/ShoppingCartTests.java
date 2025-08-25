package web.automation.tests;

import java.util.LinkedList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import web.automation.base.Base;
import web.automation.base.DriverManager;
import web.automation.pages.AddToCartPage;
import web.automation.pages.ShoppingCartPage;
import web.automation.utils.CommonHelperMethods;
import web.automation.utils.UtilityMethods;

public class ShoppingCartTests extends Base{
	
	AddToCartPage addToCartPage;
	ShoppingCartPage shoppingCartPage;
	String firstProduct;
	String expectedTitle = "Shopping Cart";

	@Test(priority=1,testName="TC_SC_001",enabled=true,groups = "ShoppingCartPage")
	public void verifyNavigatingToShoppingCartPageFromTheSuccessMessage() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		addToCartPage.firstProductImageClick();
		addToCartPage.clickAddToCartBtn();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		shoppingCartPage.clickShoppingCartLink();
		Assert.assertEquals(DriverManager.getDriver().getTitle(), expectedTitle);
		shoppingCartPage.clickRemoveBtnShoppingCart();
	}
	
	@Test(priority=2,testName="TC_SC_002",enabled=true,groups = "ShoppingCartPage")
	public void verifyNavigatingToShoppingCartPageFromTheShoppingCartHeaderOption() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		addToCartPage.clickAddToCartButton();
		addToCartPage.clickShoppingCartHeader();
		Assert.assertEquals(DriverManager.getDriver().getTitle(), expectedTitle);
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		shoppingCartPage.clickRemoveBtnShoppingCart();
	}
	
	@Test(priority=3,testName="TC_SC_003",enabled=true,groups = "ShoppingCartPage")
	public void verifyNavigatingToShoppingCartPageFromTheSiteMapFooterPage() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		addToCartPage.clickAddToCartButton();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		CommonHelperMethods.scrollIntoView(shoppingCartPage.siteMapFooterWebElement(), DriverManager.getDriver());
		shoppingCartPage.clickSiteMapFooter();
		shoppingCartPage.clickShoppingCartSiteMap();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		shoppingCartPage.clickRemoveBtnShoppingCart();
	}
	
	@Test(priority=4,testName="TC_SC_004",enabled=true,groups = "ShoppingCartPage")
	public void verifyTheCartButtonWhenThereAreNoProductsAddedToTheShoppingCart() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.clickAddToCartPopupButton();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		Assert.assertEquals(shoppingCartPage.getShoppingCartEmptyMessage(), "Your shopping cart is empty!");
	}
	
	@Test(priority=5,testName="TC_SC_005",enabled=true,groups = "ShoppingCartPage")
	public void verifyNavigatingToShoppingCartPageUsingTheViewCartOptionInTheCartblock() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		addToCartPage.clickAddToCartButton();
		CommonHelperMethods.moveToElement(addToCartPage.addToCartPopupButtonWebElement(), DriverManager.getDriver());
		addToCartPage.clickAddToCartPopupButton();
		addToCartPage.clickViewCartLink();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		Assert.assertEquals(DriverManager.getDriver().getTitle(), expectedTitle);
		shoppingCartPage.clickRemoveBtnShoppingCart();
	}
	
	@Test(priority=6,testName="TC_SC_006",enabled=true,groups = "ShoppingCartPage",dataProvider="DataProvider",dataProviderClass = UtilityMethods.class)
	public void verifyImageNameModelQuantityUnitPriceAndTotalOfTheProductInTheShoppingCartPage(String name, String model, String unitPrice, String quantity){
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox(name);
		addToCartPage.searchIconButtonClick();
		addToCartPage.firstProductImageClick();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		double totalPrice = Double.parseDouble(shoppingCartPage.getUnitPrice())*Integer.parseInt(quantity);
		String formattedTotalPrice = String.format("$%.2f", totalPrice);
		shoppingCartPage.clearingQuantityInputBox();
		shoppingCartPage.enterQuantityInputBox(quantity);
		CommonHelperMethods.moveToElement(addToCartPage.addToCartBtnWebElement(), DriverManager.getDriver());
		addToCartPage.clickAddToCartBtn();
		addToCartPage.clickShoppingCartHeader();
		List<String> expectedDetails = new LinkedList<String>();
		expectedDetails.add(name);
		expectedDetails.add(model);
		expectedDetails.add(quantity);
		expectedDetails.add(unitPrice);
		expectedDetails.add(formattedTotalPrice);
		List<String> actualDetails = new LinkedList<String>();
		actualDetails.add(shoppingCartPage.getProductName());
		actualDetails.add(shoppingCartPage.getProductModel());
		actualDetails.add(shoppingCartPage.getQuantityInCart("value"));
		actualDetails.add(shoppingCartPage.getUnitPriceInCart());
		actualDetails.add(shoppingCartPage.getTotalInCart());
		Assert.assertEquals(actualDetails, expectedDetails);
		System.out.println(actualDetails);
		System.out.println(expectedDetails);
	}
	
	@Test(priority=7,testName="TC_SC_007",enabled=true,groups = "ShoppingCartPage")
	public void verifyUpdatingTheQuantityOfTheProductInTheShoppingCartPage() throws InterruptedException {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		addToCartPage.firstProductImageClick();
		addToCartPage.clickAddToCartBtn();
		addToCartPage.clickShoppingCartHeader();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		shoppingCartPage.clearQuantityInCart();
		shoppingCartPage.enterQuantityInCart("3");
		shoppingCartPage.clickUpdateButtonInCart();
		Assert.assertEquals(shoppingCartPage.getModifiedMessage(), "Success: You have modified your shopping cart!");
	}
	
	@Test(priority=8,testName="TC_SC_008",enabled=false,groups = "ShoppingCartPage")
	public void verifyRemovingTheItemFromShoppingCartPage() throws InterruptedException {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		addToCartPage.firstProductImageClick();
		addToCartPage.clickAddToCartBtn();
		addToCartPage.clickShoppingCartHeader();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		CommonHelperMethods.moveToElement(shoppingCartPage.removeBtnShoppingCartWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		CommonHelperMethods.jsClick(shoppingCartPage.removeBtnShoppingCartWebElement(), DriverManager.getDriver());
		Assert.assertEquals(shoppingCartPage.getShoppingCartEmptyMessage(), "Your shopping cart is empty!");
	}
	
	@Test(priority=9,testName="TC_SC_009",enabled=true,groups = "ShoppingCartPage")
	public void verifyCouponCodeApplicationInTheShoppingCartPageByProvidingAnInvalidCouponCode() throws InterruptedException {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		addToCartPage.firstProductImageClick();
		addToCartPage.clickAddToCartBtn();
		addToCartPage.clickShoppingCartHeader();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		Thread.sleep(2000);
		shoppingCartPage.clickUseCouponCode();
		shoppingCartPage.enterYourCouponTextbox("xyz");
		shoppingCartPage.clickApplyCouponButton();
		Thread.sleep(2000);
		Assert.assertEquals(shoppingCartPage.getCouponWarningMessage(), "Warning: Coupon is either invalid, expired or reached its usage limit!");
	}
	
	@Test(priority=10,testName="TC_SC_010",enabled=true,groups = "ShoppingCartPage")
	public void verifyCouponCodeFunctionalityInTheShoppingCartPageByNotProvidingAnyCouponCode() throws InterruptedException {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		addToCartPage.firstProductImageClick();
		addToCartPage.clickAddToCartBtn();
		addToCartPage.clickShoppingCartHeader();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		shoppingCartPage.clickUseCouponCode();
		shoppingCartPage.clickApplyCouponButton();
		Thread.sleep(2000);
		Assert.assertEquals(shoppingCartPage.getCouponWarningMessage(), "Warning: Please enter a coupon code!");
	}
	
	@Test(priority=11,testName="TC_SC_011",enabled=true,groups = "ShoppingCartPage")
	public void verifyClosingTheWarningMessageInTheShoppingCartPage() throws InterruptedException {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		addToCartPage.firstProductImageClick();
		addToCartPage.clickAddToCartBtn();
		addToCartPage.clickShoppingCartHeader();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		shoppingCartPage.clickUseCouponCode();
		shoppingCartPage.clickApplyCouponButton();
		Thread.sleep(2000);
		shoppingCartPage.clickCloseButtonInMessage();
		Assert.assertTrue(CommonHelperMethods.inVisibilityOfElement(shoppingCartPage.couponWarningMessageWebElement(), DriverManager.getDriver()));
	}
	
	@Test(priority=12,testName="TC_SC_012",enabled=true,groups = "ShoppingCartPage")
	public void verifyCouponCodeFunctionalityInTheShoppingCartPageIsHavingPlaceholder() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		addToCartPage.firstProductImageClick();
		addToCartPage.clickAddToCartBtn();
		addToCartPage.clickShoppingCartHeader();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		shoppingCartPage.clickUseCouponCode();
		Assert.assertEquals(shoppingCartPage.getEnterYourCouponTextboxPlaceholder("placeholder"), "Enter your coupon here");
	}
	
	@Test(priority=12,testName="TC_SC_012",enabled=true,groups = "ShoppingCartPage")
	public void verifyEstimateShippingAndTaxesFunctionalityInTheShoppingCartPageByProvidingAllMandatoryFields() {
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		addToCartPage.firstProductImageClick();
		addToCartPage.clickAddToCartBtn();
		addToCartPage.clickShoppingCartHeader();
		shoppingCartPage = new ShoppingCartPage(DriverManager.getDriver());
		shoppingCartPage.clickEstimateShippingTaxes();
		CommonHelperMethods.selectDropdown(shoppingCartPage.countryDropdownWebElement(), "United States");
		CommonHelperMethods.selectDropdown(shoppingCartPage.regionStateDropdownWebElement(), "California");
		shoppingCartPage.clickGetQuotesButton();
		shoppingCartPage.clickFlatShippingRateRadioBtn();
		shoppingCartPage.clickApplyShippingButton();
	}
}
