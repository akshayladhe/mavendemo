package jbk.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import jbk.Pages.LoginPage;
import jbk.utilities.LogsUtility;

public class TestBase extends LogsUtility {
	public static WebDriver driver = null;
	FileInputStream fis = null;
	public static Logger log = Logger.getLogger(TestBase.class);

	public String readProperty(String key) {
		log.info("reading property from property file");
		Properties prop = new Properties();
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		log.info("getting property from property file for " + key);
		return prop.getProperty(key);
	}

	public void launchApplication() {
		log.info("launching an application");
		driver.get(readProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public WebDriver initialisation() {
		log.info("initialising the browser with name" + readProperty("browser"));

		if (readProperty("browser").equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
			driver = new ChromeDriver();
			launchApplication();
			log.info("Chrome browser initialise");
			return driver;
		} else {
			System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
			driver = new FirefoxDriver();
			launchApplication();
			log.info("FireFox browser initialise");
			return driver;
		}
	}
	
	public LoginPage landingToLoginPage(WebDriver driver){
		LoginPage lp = new LoginPage(driver);
		return lp;
	}

	public String takeScreenshot(String name) {
		TakesScreenshot ss = (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir"), "/Screenshot/" + name + ".jpg");
		try {
			FileUtils.copyFile(source, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Screenshot captured";

	}
}
