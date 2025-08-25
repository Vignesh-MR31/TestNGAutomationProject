package web.automation.utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import web.automation.base.Base;

public class CommonHelperMethods extends Base{
	static JavascriptExecutor js;
	static WebDriverWait wait;
	static Actions actions;
	static Select select;
	
	public static void scrollIntoView(WebElement element,WebDriver driver) {
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public static void scrollIntoViewDownward(WebDriver driver) {
		js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, 500);");
	}
	
	public static void visibilityOfElement(WebElement element,WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static Boolean inVisibilityOfElement(WebElement element,WebDriver driver) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Boolean elementState = wait.until(ExpectedConditions.invisibilityOf(element));
		return elementState;
	}

	public static void handlingStaleElementException(WebElement element) {
		try {
			element.click();
		} catch (StaleElementReferenceException e) {
			element.click();
		}
	}
	
	public static void moveToElement(WebElement element,WebDriver driver) {
		actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	
	public static void jsClick(WebElement element,WebDriver driver) {
	    js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	}
	
	public static String jsValue(WebElement element,WebDriver driver) {
	    js = (JavascriptExecutor) driver;
	    String quantity = (String) js.executeScript("return arguments[0].value;", element);
	    return quantity;
	}
	
	public static void selectDropdown(WebElement element, String visibleText) {
		select = new Select(element);
		select.selectByVisibleText(visibleText);
	}
}
