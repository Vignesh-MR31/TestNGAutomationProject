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
		addToCartPage.firstProductImageWebElement().click();
		wishListPage = new WishListPage(DriverManager.getDriver());
		firstRelatedProduct = wishListPage.firstRelatedProductHeaderWebElement().getText();
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInRelatedProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInRelatedProductsWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.wishListButtonInRelatedProductsWebElement().click();
		CommonHelperMethods.scrollIntoView(wishListPage.wishListLinkWebElement(), DriverManager.getDriver());
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
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInFeaturedProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInFeaturedProductsWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);;
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
		CommonHelperMethods.moveToElement(addToCartPage.desktopsDropdownWebElement(), DriverManager.getDriver());
		addToCartPage.desktopsDropdownWebElement().click();
		CommonHelperMethods.moveToElement(addToCartPage.showAllDesktopsWebElement(), DriverManager.getDriver());
		addToCartPage.showAllDesktopsWebElement().click();
		addToCartPage.macOptionWebElement().click();
		firstProduct = addToCartPage.firstProductHeaderWebElement().getText();
		wishListPage = new WishListPage(DriverManager.getDriver());
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInCategoryProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInCategoryProductsWebElement(), DriverManager.getDriver());
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
		try {
			addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		} catch (Exception e) {
			addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		}
		addToCartPage.searchIconButtonWebElement().click();
		wishListPage = new WishListPage(DriverManager.getDriver());
		firstSearchedProduct = wishListPage.firstSearchedProductHeaderWebElement().getText();
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.wishListButtonInSearchedProductsWebElement().click();
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
		try {
			addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		} catch (Exception e) {
			addToCartPage.searchInputTextboxWebElement().sendKeys("iMac");
		}
		addToCartPage.searchIconButtonWebElement().click();
		wishListPage = new WishListPage(DriverManager.getDriver());
		firstSearchedProduct = wishListPage.firstSearchedProductHeaderWebElement().getText();
		Thread.sleep(2000);
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.wishListButtonInSearchedProductsWebElement().click();
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
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.wishListButtonInSearchedProductsWebElement().click();
		Thread.sleep(2000);
		CommonHelperMethods.moveToElement(wishListPage.wishListFooterWebElement(), DriverManager.getDriver());
		wishListPage.wishListFooterWebElement().click();
		Assert.assertEquals(wishListPage.productNameInWishListPageWebElement().getText(), firstSearchedProduct);
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.removeButtonInWishListWebElement().click();
	}
	
	@Test(priority=9,testName="TC_WL_009",enabled=true,groups = "WishListPage")
	public void verifyTheMyWishListPageWhenThereAreNoProductsAdded() {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.myAccountElement().click();
		loginPage.loginOptionElement().click();
		loginPage.emailAddressElement().sendKeys("Vickymr@gmail.com");
		loginPage.passwordElement().sendKeys("123456789");
		loginPage.loginButtonElement().click();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		addToCartPage.wishListHeaderWebElement().click();
		wishListPage = new WishListPage(DriverManager.getDriver());
		Assert.assertEquals(wishListPage.wishListEmptyMessageWebElement().getText(), "Your wish list is empty.");
	}
	
	@Test(priority=10,testName="TC_WL_010",enabled=true,groups = "WishListPage")
	public void verifyTheMyWishListPageWhenOnlyOneProductIsAddedToIt() throws InterruptedException {
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
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.wishListButtonInSearchedProductsWebElement().click();
		Thread.sleep(2000);
		wishListPage.wishListLinkWebElement().click();
		wishListPage.continueButtonInWishListWebElement().click();
		Assert.assertEquals(loginPage.myAccountHeaderElement().getText(), "My Account");
		addToCartPage.wishListHeaderWebElement().click();
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.removeButtonInWishListWebElement().click();
	}
	
	@Test(priority=11,testName="TC_WL_011",enabled=true,groups = "WishListPage")
	public void verifyTheRemovingTheProductFromMyWishListPage() throws InterruptedException {
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
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.wishListButtonInSearchedProductsWebElement().click();
		Thread.sleep(2000);
		wishListPage.wishListLinkWebElement().click();
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.removeButtonInWishListWebElement().click();
		Assert.assertEquals(wishListPage.successMessageAfterRemoveWebElement().getText().replace('×', ' ').trim(), "Success: You have modified your wish list!");
	}
	
	@Test(priority=12,testName="TC_WL_012",enabled=true,groups = "WishListPage")
	public void verifyAddingTheProductToCartFromTheMyWishListPage() throws InterruptedException {
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
		CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		CommonHelperMethods.moveToElement(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
		Thread.sleep(2000);
		wishListPage.wishListButtonInSearchedProductsWebElement().click();
		Thread.sleep(2000);
		wishListPage.wishListLinkWebElement().click();
		firstProductNameInWishList = wishListPage.productNameInWishListPageWebElement().getText();
		addToCartPage.addToCartInWishListWebElement().click();
		Assert.assertEquals(wishListPage.successMessageAfterRemoveWebElement().getText().replace('×', ' ').trim(), "Success: You have added "+firstProductNameInWishList +" to your shopping cart!");
		CommonHelperMethods.moveToElement(wishListPage.removeButtonInWishListWebElement(), DriverManager.getDriver());
		wishListPage.removeButtonInWishListWebElement().click();
	}
	
	@Test(priority=13,testName="TC_WL_013",enabled=true,groups = "WishListPage")
	public void verifyAddingTheMultipleProductsToTheMyWishListPage() throws InterruptedException {
		loginPage = new LoginPage(DriverManager.getDriver());
		loginPage.myAccountElement().click();
		loginPage.loginOptionElement().click();
		loginPage.emailAddressElement().sendKeys("Vickymr@gmail.com");
		loginPage.passwordElement().sendKeys("123456789");
		loginPage.loginButtonElement().click();
		addToCartPage = new AddToCartPage(DriverManager.getDriver());
		multipleProducts.add(firstAddedProduct);
		multipleProducts.add(secondAddedProduct);
		multipleProducts.add(thirdAddedProduct);
		for(String products:multipleProducts) {
			try {
				addToCartPage.searchInputTextboxWebElement().sendKeys(products);
			} catch (Exception e) {
				addToCartPage.searchInputTextboxWebElement().sendKeys(products);
			}
			addToCartPage.searchIconButtonWebElement().click();
			wishListPage = new WishListPage(DriverManager.getDriver());
			addedProducts.add(wishListPage.firstSearchedProductHeaderWebElement().getText());
			CommonHelperMethods.scrollIntoView(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
			CommonHelperMethods.moveToElement(wishListPage.wishListButtonInSearchedProductsWebElement(), DriverManager.getDriver());
			Thread.sleep(2000);
			wishListPage.wishListButtonInSearchedProductsWebElement().click();
			addToCartPage.searchInputTextboxWebElement().clear();
		}
		wishListPage.wishListLinkWebElement().click();
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
			wishListPage.removeButtonInWishListWebElement().click();
			removeButtonsCount--;
		}
	}
}
