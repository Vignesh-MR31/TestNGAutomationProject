package web.automation.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public WebElement searchInputTextboxWebElement() {
		return searchInputTextbox;
	}
	
	public WebElement searchIconButtonWebElement() {
		return searchIconButton;
	}

	public WebElement firstProductHeaderWebElement() {
		return firstProductHeader;
	}
	
	public WebElement firstProductImageWebElement() {
		return firstProductImage;
	}
	
	public WebElement noProductMessageWebElement() {
		return noProductMessage;
	}
	
	public List<WebElement> multipleProductsWebElements() {
		return multipleProducts;
	}
	
	public WebElement searchCriteriaWebElement() {
		return searchCriteria;
	}
	
	public WebElement searchButtonWebElement() {
		return searchButton;
	}
	
	public WebElement firstDescriptionWebElement() {
		return firstDescription;
	}
	
	public WebElement productDescriptionCheckboxWebElement() {
		return productDescriptionCheckbox;
	}
	
	public List<WebElement> searchedProductsDescriptionWebElement() {
		return searchedProductsDescription;
	}
	
	public WebElement categoryDropdownWebElement() {
		return categoryDropdown;
	}
	
	public WebElement subcategoryCheckboxWebElement() {
		return subcategoryCheckbox;
	}
	
	public WebElement listViewButtonWebElement() {
		return listViewButton;
	}
	
	public WebElement gridViewButtonWebElement() {
		return gridViewButton;
	}
	
	public WebElement productCompareLinkWebElement() {
		return productCompareLink;
	}
	
	public WebElement productComparisonHeaderWebElement() {
		return productComparisonHeader;
	}
	
	public WebElement sortOrderDropdownWebElement() {
		return sortOrderDropdown;
	}
	
	public List<WebElement> priceListWebElement() {
		return priceList;
	}
	
	public WebElement compareThisProductIconWebElement() {
		return compareThisProductIcon;
	}
	
	public WebElement addToCartPopupProductImageWebElement() {
		return addToCartPopupProductImage;
	}
	
	public WebElement addToCartPopupButtonWebElement() {
		return addToCartPopupButton;
	}
	
	public WebElement addToCartButtonWebElement() {
		return addToCartButton;
	}
	
	public WebElement addedProductNameInPopupWebElement() {
		return addedProductNameInPopup;
	}
	
	public WebElement addToCartBtnWebElement() {
		return addToCartBtn;
	}
	
	public WebElement addToCartSuccessMessageWebElement() {
		return addToCartSuccessMessage;
	}
	
	public WebElement addToWishListButtonWebElement() {
		return addToWishListButton;
	}
	
	public WebElement wishListHeaderWebElement() {
		return wishListHeader;
	}
	
	public WebElement addToCartInWishListWebElement() {
		return addToCartInWishList;
	}
	
	public WebElement shoppingCartHeaderWebElement() {
		return shoppingCartHeader;
	}
	
	public WebElement productNameInCartWebElement() {
		return productNameInCart;
	}
	
	public WebElement viewCartLinkWebElement() {
		return viewCartLink;
	}
	
	public WebElement relatedProductsAddToCartButtonWebElement() {
		return relatedProductsAddToCartButton;
	}
	
	public WebElement relatedProductsFirstProductNameWebElement() {
		return relatedProductsFirstProductName;
	}
	
	public WebElement desktopsDropdownWebElement() {
		return desktopsDropdown;
	}
	
	public WebElement showAllDesktopsWebElement() {
		return showAllDesktops;
	}
	
	public WebElement macOptionWebElement() {
		return macOption;
	}
	
	public WebElement compareThisProductButtonWebElement() {
		return compareThisProductButton;
	}
	
	public WebElement productComparisonLinkWebElement() {
		return productComparisonLink;
	}
	
	public WebElement addToCartInProductCompareWebElement() {
		return addToCartInProductCompare;
	}
}
