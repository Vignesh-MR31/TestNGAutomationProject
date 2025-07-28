package web.automation.utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import web.automation.base.Base;

public class CommonHelperMethods extends Base{
	static JavascriptExecutor js;
	static WebDriverWait wait;
	static Actions actions;
	
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
	
	public static void handlingStaleElementException(WebElement element) {
		try {
			element.click();
		} catch (StaleElementReferenceException e) {
			element.click();
		}
	}
	
	public static void moveToElement(WebElement element,WebDriver driver) {
		actions = new Actions(driver);
		actions.moveToElement(element);
	}
}
