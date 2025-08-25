package web.automation.tests;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
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
	String firstProductNameInWishList;
	String firstAddedProduct = "MacBook";
	String secondAddedProduct = "iMac";
	String thirdAddedProduct = "Apple Cinema 30";
	List<String> multipleProducts = new LinkedList<String>();
	List<String> addedProducts = new LinkedList<String>();
	boolean productNameStatus = false;
	
	@Test(priority=1,testName="TC_WL_001",enabled=true,groups = "WishListPage")
	public void verifyAddingAProductToWishListPageFromTheProductThatIsDisplayedInTheRelatedProductsSectionOfProductDisplayPage() throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.clickmyAccount();
		loginPage.clickLoginOption();
		loginPage.enteringEmailAddress("Vickymr@gmail.com");
		loginPage.enteringPassword("123456789");
		loginPage.clickloginButton();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		addToCartPage.firstProductImageClick();
		wishListPage = new WishListPage(DriverManager.getDriver());
		firstRelatedProduct = wishListPage.getFirstRelatedProductHeader();
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInRelatedProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInRelatedProductsWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.clickWishListButtonInRelatedProducts();
		CommonHelperMethods.scrollIntoView(wishListPage.wishListLinkWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.clickWishListLink();
		Assert.assertEquals(wishListPage.getProductNameInWishListPage(), firstRelatedProduct);
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.clickRemoveButtonInWishList();
	}
	
	@Test(priority=2,testName="TC_WL_002",enabled=true,groups = "WishListPage")
	public void VerifyAddingAProductToWishListPageFromTheProductThatIsDisplayedInTheFeaturedSectionOfHomePage() throws InterruptedException{
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.clickmyAccount();
		loginPage.clickLoginOption();
		loginPage.enteringEmailAddress("Vickymr@gmail.com");
		loginPage.enteringPassword("123456789");
		loginPage.clickloginButton();
		wishListPage = new WishListPage(DriverManager.getDriver());
		CommonHelperMethods.handlingStaleElementException(wishListPage.logoWebElement());
		firstFeaturedProduct = wishListPage.getFirstFeaturedProductHeader();
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInFeaturedProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInFeaturedProductsWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);;
		wishListPage.clickWishListButtonInFeaturedProducts();
		Thread.sleep(2000);
		wishListPage.clickWishListLink();
		Assert.assertEquals(wishListPage.getProductNameInWishListPage(), firstFeaturedProduct);
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.clickRemoveButtonInWishList();
	}

	@Test(priority=3,testName="TC_WL_003",enabled=true,groups = "WishListPage")
	public void VerifyAddingTheProductToWishListFromTheProductsDisplayedInTheCategoryOrSubCategoryPage() throws InterruptedException{
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.clickmyAccount();
		loginPage.clickLoginOption();
		loginPage.enteringEmailAddress("Vickymr@gmail.com");
		loginPage.enteringPassword("123456789");
		loginPage.clickloginButton();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		CommonHelperMethods.moveToElement(addToCartPage.desktopsDropdownWebElement(), DriverManager.getDriver());
		addToCartPage.clickDesktopsDropdown();
		CommonHelperMethods.moveToElement(addToCartPage.showAllDesktopsWebElement(), DriverManager.getDriver());
		addToCartPage.clickShowAllDesktops();
		addToCartPage.clickMacOptionWebElement();
		firstProduct = addToCartPage.gettingFirstProductHeader();
		wishListPage = new WishListPage(DriverManager.getDriver());
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInCategoryProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInCategoryProductsWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.clickWishListButtonInCategoryProducts();
		Thread.sleep(2000);
		wishListPage.clickWishListLink();
		Assert.assertEquals(wishListPage.getProductNameInWishListPage(), firstProduct);
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.clickRemoveButtonInWishList();
	}
	
	@Test(priority=4,testName="TC_WL_004",enabled=true,groups = "WishListPage")
	public void verifyAddingAProductToWishListPageFromTheSearchResultsPage() throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.clickmyAccount();
		loginPage.clickLoginOption();
		loginPage.enteringEmailAddress("Vickymr@gmail.com");
		loginPage.enteringPassword("123456789");
		loginPage.clickloginButton();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		wishListPage = new WishListPage(DriverManager.getDriver());
		firstSearchedProduct = wishListPage.getFirstSearchedProductHeader();
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.clickWishListButtonInSearchedProducts();
		Thread.sleep(2000);
		wishListPage.clickWishListLink();
		Assert.assertEquals(wishListPage.getProductNameInWishListPage(), firstSearchedProduct);
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.clickRemoveButtonInWishList();
	}
	
	@Test(priority=5,testName="TC_WL_005",enabled=true,groups = "WishListPage")
	public void verifyNavigatingToMyWishListPageUsingTheWishListHeaderOption() throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.clickmyAccount();
		loginPage.clickLoginOption();
		loginPage.enteringEmailAddress("Vickymr@gmail.com");
		loginPage.enteringPassword("123456789");
		loginPage.clickloginButton();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		wishListPage = new WishListPage(DriverManager.getDriver());
		firstSearchedProduct = wishListPage.getFirstSearchedProductHeader();
		Thread.sleep(2000);
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.clickWishListButtonInSearchedProducts();
		addToCartPage.clickWishListHeader();
		Assert.assertEquals(wishListPage.getProductNameInWishListPage(), firstSearchedProduct);
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.clickRemoveButtonInWishList();
	}
	
	@Test(priority=6,testName="TC_WL_006",enabled=false,groups = "WishListPage")
	public void verifyNavigatingToMyWishListPageUsingTheRightColumnHeaderOptions() throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.clickmyAccount();
		loginPage.clickLoginOption();
		loginPage.enteringEmailAddress("Vickymr@gmail.com");
		loginPage.enteringPassword("123456789");
		loginPage.clickloginButton();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		wishListPage = new WishListPage(DriverManager.getDriver());
		firstSearchedProduct = wishListPage.getFirstSearchedProductHeader();
		Thread.sleep(2000);
		wishListPage.clickWishListButtonInCategoryProducts();
		wishListPage.clickMyAccountHeader();
		CommonHelperMethods.moveToElement(wishListPage.myAccountOptionWebElement(), DriverManager.getDriver());
		wishListPage.clickMyAccountOption();
		try {
			wishListPage.clickWishListRightOption();
		} catch (Exception e) {
			wishListPage.clickMyAccountHeader();
			CommonHelperMethods.moveToElement(wishListPage.myAccountOptionWebElement(), DriverManager.getDriver());
			wishListPage.clickMyAccountOption();
		}
		Assert.assertEquals(wishListPage.getProductNameInWishListPage(), firstSearchedProduct);
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.clickRemoveButtonInWishList();
	}
	
	@Test(priority=7,testName="TC_WL_007",enabled=false,groups = "WishListPage")
	public void verifyNavigatingToMyWishListPageFromTheMyAccountPage () throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.clickmyAccount();
		loginPage.clickLoginOption();
		loginPage.enteringEmailAddress("Vickymr@gmail.com");
		loginPage.enteringPassword("123456789");
		loginPage.clickloginButton();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		wishListPage = new WishListPage(DriverManager.getDriver());
		firstSearchedProduct = wishListPage.getFirstSearchedProductHeader();
		Thread.sleep(2000);
		wishListPage.clickWishListButtonInCategoryProducts();
		Thread.sleep(2000);
		CommonHelperMethods.scrollIntoViewDownward(DriverManager.getDriver());
		wishListPage.clickMyAccountFooter();
		wishListPage.clickModifyYourWishList();
		Assert.assertEquals(wishListPage.getProductNameInWishListPage(), firstSearchedProduct);
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.clickRemoveButtonInWishList();
	}
	
	@Test(priority=8,testName="TC_WL_008",enabled=true,groups = "WishListPage")
	public void verifyNavigatingToMyWishListPageFromTheFooteroptions() throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.clickmyAccount();
		loginPage.clickLoginOption();
		loginPage.enteringEmailAddress("Vickymr@gmail.com");
		loginPage.enteringPassword("123456789");
		loginPage.clickloginButton();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		wishListPage = new WishListPage(DriverManager.getDriver());
		firstSearchedProduct = wishListPage.getFirstSearchedProductHeader();
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.clickWishListButtonInSearchedProducts();
		Thread.sleep(2000);
		CommonHelperMethods.moveToElement(wishListPage.wishListFooterWebElement(), DriverManager.getDriver());
		wishListPage.clickWishListFooter();
		Assert.assertEquals(wishListPage.getProductNameInWishListPage(), firstSearchedProduct);
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.clickRemoveButtonInWishList();
	}
	
	@Test(priority=9,testName="TC_WL_009",enabled=true,groups = "WishListPage")
	public void verifyTheMyWishListPageWhenThereAreNoProductsAdded() {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.clickmyAccount();
		loginPage.clickLoginOption();
		loginPage.enteringEmailAddress("Vickymr@gmail.com");
		loginPage.enteringPassword("123456789");
		loginPage.clickloginButton();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.clickWishListHeader();
		wishListPage = new WishListPage(DriverManager.getDriver());
		Assert.assertEquals(wishListPage.getWishListEmptyMessage(), "Your wish list is empty.");
	}
	
	@Test(priority=10,testName="TC_WL_010",enabled=true,groups = "WishListPage")
	public void verifyTheMyWishListPageWhenOnlyOneProductIsAddedToIt() throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.clickmyAccount();
		loginPage.clickLoginOption();
		loginPage.enteringEmailAddress("Vickymr@gmail.com");
		loginPage.enteringPassword("123456789");
		loginPage.clickloginButton();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		wishListPage = new WishListPage(DriverManager.getDriver());
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.clickWishListButtonInSearchedProducts();
		Thread.sleep(2000);
		wishListPage.clickWishListLink();
		wishListPage.clickContinueButtonInWishList();
		Assert.assertTrue(loginPage.myAccountHeaderElementIsDisplayed("My Account"));
		addToCartPage.clickWishListHeader();
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.clickRemoveButtonInWishList();
	}
	
	@Test(priority=11,testName="TC_WL_011",enabled=true,groups = "WishListPage")
	public void verifyTheRemovingTheProductFromMyWishListPage() throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.clickmyAccount();
		loginPage.clickLoginOption();
		loginPage.enteringEmailAddress("Vickymr@gmail.com");
		loginPage.enteringPassword("123456789");
		loginPage.clickloginButton();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		wishListPage = new WishListPage(DriverManager.getDriver());
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.clickWishListButtonInSearchedProducts();
		Thread.sleep(2000);
		wishListPage.clickWishListLink();
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.clickRemoveButtonInWishList();
		Assert.assertEquals(wishListPage.getSuccessMessageAfterRemove(), "Success: You have modified your wish list!");
	}
	
	@Test(priority=12,testName="TC_WL_012",enabled=true,groups = "WishListPage")
	public void verifyAddingTheProductToCartFromTheMyWishListPage() throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.clickmyAccount();
		loginPage.clickLoginOption();
		loginPage.enteringEmailAddress("Vickymr@gmail.com");
		loginPage.enteringPassword("123456789");
		loginPage.clickloginButton();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.enteringProductInSearchInputTextbox("iMac");
		addToCartPage.searchIconButtonClick();
		wishListPage = new WishListPage(DriverManager.getDriver());
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.clickWishListButtonInSearchedProducts();
		Thread.sleep(2000);
		wishListPage.clickWishListLink();
		firstProductNameInWishList = wishListPage.getProductNameInWishListPage();
		addToCartPage.clickAddToCartInWishList();
		Assert.assertEquals(wishListPage.getSuccessMessageAfterRemove(), "Success: You have added "+firstProductNameInWishList +" to your shopping cart!");
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.clickRemoveButtonInWishList();
	}
	
	@Test(priority=13,testName="TC_WL_013",enabled=true,groups = "WishListPage")
	public void verifyAddingTheMultipleProductsToTheMyWishListPage() throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.clickmyAccount();
		loginPage.clickLoginOption();
		loginPage.enteringEmailAddress("Vickymr@gmail.com");
		loginPage.enteringPassword("123456789");
		loginPage.clickloginButton();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		multipleProducts.add(firstAddedProduct);
		multipleProducts.add(secondAddedProduct);
		multipleProducts.add(thirdAddedProduct);
		for(String products:multipleProducts) {
			addToCartPage.enteringProductInSearchInputTextbox(products);
			addToCartPage.searchIconButtonClick();
			wishListPage = new WishListPage(DriverManager.getDriver());
			addedProducts.add(wishListPage.getFirstSearchedProductHeader());
			CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
			CommonHelperMethods.moveToElement(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
			Thread.sleep(2000);
			wishListPage.clickWishListButtonInSearchedProducts();
			addToCartPage.clearingSearchInputTextbox();
		}
		wishListPage.clickWishListLink();
		List<WebElement> productNames = wishListPage.productNamesInWishListPageWebElement();
		for(WebElement names:productNames) {
			int count = 0;
			while(count<multipleProducts.size()) {
				if(names.getText().equalsIgnoreCase(addedProducts.get(count))) {
					productNameStatus = true;
					break;
				}
				else {
					productNameStatus = false;
				}
				count++;
			}
		}
		Assert.assertTrue(productNameStatus);
		List<WebElement> removeButtons = wishListPage.removeButtonsInWishListWebElement();
		int removeButtonsCount = removeButtons.size();
		while(removeButtonsCount>0) {
			CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
			wishListPage.clickRemoveButtonInWishList();
			removeButtonsCount--;
		}
	}
}
