package web.automation.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {
	
	public static Properties propertyLoaderMethod(){
		Properties prop = new Properties();
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		FileInputStream inputStream;
		try {
			inputStream = new FileInputStream(file);
			prop.load(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
