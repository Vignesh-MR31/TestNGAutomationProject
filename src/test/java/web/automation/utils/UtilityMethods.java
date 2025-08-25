package web.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

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
	
	@DataProvider(name = "DataProvider")
	public static Object[][] dataReaderMethod(){
		File file = new File(System.getProperty("user.dir")+"\\test-data\\Products.xlsx");
		FileInputStream fis;
		Object[][] productDetails = null;
		try {
			fis = new FileInputStream(file);
			XSSFWorkbook workBook = new XSSFWorkbook(fis);
			XSSFSheet sheet = workBook.getSheet("Product-Details");
			int totalRows = sheet.getLastRowNum();
			int totalColumns = sheet.getRow(totalRows).getLastCellNum();
			productDetails = new Object[totalRows][totalColumns-1];
			for(int i = 0; i<totalRows;i++) {
				XSSFRow row = sheet.getRow(i+1);
				for(int j = 0;j<(totalColumns-1);j++) {
					XSSFCell cell = row.getCell(j+1);
					DataFormatter formatter = new DataFormatter();
					productDetails[i][j] = formatter.formatCellValue(cell);
				}
			}
			workBook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productDetails;
	}
}
