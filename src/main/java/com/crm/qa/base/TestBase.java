package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;
	
	
	public TestBase()
	{
		prop = new Properties();
		 try {
			FileInputStream ip = new FileInputStream("/Users/jerinraj/Documents/Java Training/FreeCRMTest/src/main/java/com/crm"
													+"/qa/config/config.properties");
		
				prop.load(ip);

			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	     catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public static void initialization()
	{
		String browsername = prop.getProperty("browser");
		if (browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/jerinraj/Downloads/chromedriver-mac-x64/chromedriver");
			driver = new ChromeDriver();
			
		}
		else if (browsername.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "/Users/jerinraj/Downloads/geckodriver");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));
		
	}
	
	
}
