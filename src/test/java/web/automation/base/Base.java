package web.automation.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.aventstack.chaintest.plugins.ChainTestListener;

import web.automation.utils.PropertyLoader;
import web.automation.utils.UtilityMethods;

public class Base {
	
	public WebDriver driver;
	
	@BeforeMethod @Parameters("browser")
	public void initiateDriver(String browser){
		//String browser = PropertyLoader.propertyLoaderMethod().getProperty("browser").toLowerCase();
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
		DriverManager.setDriver(driver);
		DriverManager.getDriver().get(PropertyLoader.propertyLoaderMethod().getProperty("url"));
		DriverManager.getDriver().manage().window().maximize();
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
	}
	
	@AfterMethod
	public void quitDriver(ITestResult result) {
		if(!result.isSuccess()) {
			ChainTestListener.embed(UtilityMethods.takeScreenshotMethod(result.getName(),DriverManager.getDriver()), "image/png");
		}
		DriverManager.quitDriver();
	}

}
