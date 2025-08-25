package web.automation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import web.automation.base.DriverManager;
import web.automation.utils.CommonHelperMethods;

public class AddToCartPage {
	
	public AddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@id='search']//input")
	private WebElement searchInputTextbox;
	
	@FindBy(xpath = "//div[@id='search']//button")
	private WebElement searchIconButton;
	
	@FindBy(xpath = "(//div[contains(@class,'caption')])[1]/h4")
	private WebElement firstProductHeader;
	
	@FindBy(xpath = "(//div[contains(@class,'image')])")
	private WebElement firstProductImage;
	
	@FindBy(xpath = "(//div[@id='content'])/p[2]")
	private WebElement noProductMessage;
	
	@FindBy(xpath = "//div[@class='caption']/h4")
	private List<WebElement> multipleProducts;
	
	@FindBy(id = "input-search")
	private WebElement searchCriteria;
	
	@FindBy(id = "button-search")
	private WebElement searchButton;
	
	@FindBy(xpath = "(//div[contains(@class,'caption')])[1]/p[1]")
	private WebElement firstDescription;
	
	@FindBy(id = "description")
	private WebElement productDescriptionCheckbox;
	
	@FindBy(xpath = "//div[@class='caption']//p[1]")
	private List<WebElement> searchedProductsDescription;
	
	@FindBy(xpath = "//select[@name='category_id']")
	private WebElement categoryDropdown;
	
	@FindBy(xpath = "//input[@name='sub_category']")
	private WebElement subcategoryCheckbox;
	
	@FindBy(id = "list-view")
	private WebElement listViewButton;
	
	@FindBy(id = "grid-view")
	private WebElement gridViewButton;
	
	@FindBy(id = "compare-total")
	private WebElement productCompareLink;
	
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement productComparisonHeader;
	
	@FindBy(id = "input-sort")
	private WebElement sortOrderDropdown;
	
	@FindBy(xpath = "//div[@class='caption']//p[2]")
	private List<WebElement> priceList;
	
	@FindBy(xpath = "//button[@data-original-title='Compare this Product']")
	private WebElement compareThisProductIcon;
	
	@FindBy(xpath = "//div[@id='cart']//button")
	private WebElement addToCartPopupButton;
	
	@FindBy(xpath = "//div[@id='cart']//ul//img")
	private WebElement addToCartPopupProductImage;
	
	@FindBy(xpath = "(//div[@id='cart']//ul//a)[2]")
	private WebElement addedProductNameInPopup;
	
	@FindBy(xpath = "//div[contains(@class,'button')]//button[1]")
	private WebElement addToCartButton;
	
	@FindBy(id = "button-cart")
	private WebElement addToCartBtn;
	
	@FindBy(xpath = "//div[contains(@class,'alert')]")
	private WebElement addToCartSuccessMessage;
	
	@FindBy(xpath = "(//button[@data-original-title='Add to Wish List'])[1]")
	private WebElement addToWishListButton;
	
	@FindBy(id = "wishlist-total")
	private WebElement wishListHeader;
	
	@FindBy(xpath = "//button[@data-original-title='Add to Cart']")
	private WebElement addToCartInWishList;
	
	@FindBy(xpath = "//a[@title='Shopping Cart']")
	private WebElement shoppingCartHeader;
	
	@FindBy(xpath = "(//div[@id='content']//a)[2]")
	private WebElement productNameInCart;
	
	@FindBy(xpath = "(//div[@id='cart']//ul//a)[3]")
	private WebElement viewCartLink;
	
	@FindBy(xpath = "//button//span[text()='Add to Cart']")
	private WebElement relatedProductsAddToCartButton;
	
	@FindBy(xpath = "//div[@class='caption']//a")
	private WebElement relatedProductsFirstProductName;
	
	@FindBy(xpath = "//a[text()='Desktops']")
	private WebElement desktopsDropdown;
	
	@FindBy(xpath = "//a[text()='Show AllDesktops']")
	private WebElement showAllDesktops;
	
	@FindBy(xpath = "//aside//a[contains(text(),'Mac')]")
	private WebElement macOption;
	
	@FindBy(xpath = "//button[@data-original-title='Compare this Product']")
	private WebElement compareThisProductButton;
	
	@FindBy(linkText = "product comparison")
	private WebElement productComparisonLink;
	
	@FindBy(xpath = "//input[@value='Add to Cart']")
	private WebElement addToCartInProductCompare;
	
	public void enteringProductInSearchInputTextbox(String product) {
		try {
			searchInputTextbox.sendKeys(product);
		} catch (Exception e) {
			searchInputTextbox.sendKeys(product);
		}
	}
	
	public void clearingSearchInputTextbox() {
		searchInputTextbox.clear();
	}
	
	public void searchIconButtonClick() {
		searchIconButton.click();
	}

	public String gettingFirstProductHeader() {
		return firstProductHeader.getText();
	}
	
	public void firstProductImageClick() {
		firstProductImage.click();
	}
	
	public void clickProductCompareLink() {
		productCompareLink.click();
	}
	
	public void clickAddToCartPopupButton() {
		addToCartPopupButton.click();
	}
	
	public WebElement addToCartPopupButtonWebElement() {
		return addToCartPopupButton;
	}
	
	public void clickAddToCartButton() {
		addToCartButton.click();
	}
	
	public void clickAddToCartBtn() {
		addToCartBtn.click();
	}
	
	public WebElement addToCartBtnWebElement() {
		return addToCartBtn;
	}
	
	public String getAddToCartSuccessMessage() {
		return addToCartSuccessMessage.getText().replace('×', ' ').trim();
	}
	
	public void clickAddToWishListButton() {
		addToWishListButton.click();
	}
	
	public WebElement addToWishListButtonWebElement() {
		return addToWishListButton;
	}
	
	public void clickWishListHeader() {
		wishListHeader.click();
	}
	
	public void clickAddToCartInWishList() {
		addToCartInWishList.click();
	}
	
	public void clickShoppingCartHeader() {
		shoppingCartHeader.click();
	}
	
	public String getProductNameInCart() {
		return productNameInCart.getText();
	}
	
	public void clickViewCartLink() {
		viewCartLink.click();
	}
	
	public void clickRelatedProductsAddToCartButton() {
		relatedProductsAddToCartButton.click();
	}
	
	public String getRelatedProductsFirstProductName() {
		return relatedProductsFirstProductName.getText();
	}
	
	public WebElement relatedProductsFirstProductNameWebElement() {
		return relatedProductsFirstProductName;
	}
	
	public void clickDesktopsDropdown() {
		desktopsDropdown.click();
	}
	
	public WebElement desktopsDropdownWebElement() {
		return desktopsDropdown;
	}
	
	public void clickShowAllDesktops() {
		showAllDesktops.click();
	}
	
	public WebElement showAllDesktopsWebElement() {
		return showAllDesktops;
	}
	
	public void clickMacOptionWebElement() {
		macOption.click();
	}
	
	public void clickCompareThisProductButton() {
		compareThisProductButton.click();
	}
	
	public void clickAddToCartInProductCompare() {
		addToCartInProductCompare.click();
	}
}
