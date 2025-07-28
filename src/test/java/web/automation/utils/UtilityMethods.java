package web.automation.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import web.automation.base.Base;

public class UtilityMethods extends Base{

	public static File takeScreenshotMethod(String testName,WebDriver driver) {
		TakesScreenshot screenshot = (TakesScreenshot)driver;
		File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
		File screenshotFolder = new File(System.getProperty("user.dir")+"\\test-reports\\screenshots\\"+testName+".png");
		try {
			FileUtils.copyFile(screenshotFile, screenshotFolder);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return screenshotFile;
		
	}
}
