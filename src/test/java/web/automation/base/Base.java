package web.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import web.automation.utils.PropertyLoader;

public class Base {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void initiateDriver(){
		String browser = PropertyLoader.propertyLoaderMethod().getProperty("browser").toLowerCase();
		switch(browser){
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "edge":
			driver = new EdgeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			driver = new ChromeDriver();
		}
		driver.get(PropertyLoader.propertyLoaderMethod().getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	@AfterMethod
	public void quitDriver() {
		if(driver!=null) {
			driver.quit();
		}
	}

}
