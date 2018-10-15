package properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	public Base() throws IOException {
		FileInputStream fis = new FileInputStream("src/main/java/properties/SetUp.properties");
		Properties prop = new Properties();
		
		prop.load(fis);
		
		String explorer = prop.getProperty("explorer");
		
		if(explorer.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
			driver = new ChromeDriver();
		}
	}
	
	protected static WebDriver driver;

}
