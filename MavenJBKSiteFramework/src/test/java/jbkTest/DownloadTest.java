package jbkTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import jbk.Pages.DownloadPage;
import jbk.Pages.LoginPage;
import jbk.base.TestBase;

public class DownloadTest extends TestBase {
	WebDriver driver;
	LoginPage lp;
	DownloadPage dwnp;
	
	@BeforeSuite
	public void setUp() {
		driver = initialisation();
		lp = new LoginPage(driver);
		dwnp = lp.nevigateToDashboardPage(driver).navigateToDownloadPage(driver);
		dwnp = new DownloadPage(driver);
	}
	@Test(priority = 2)
	public void verifyDownloadsTitle(){
		Assert.assertEquals(dwnp.verifyDownloadPageTitle(), "JavaByKiran | Downloads");
	}
	
	@Test(priority = 3)
	public void verifyPageHeader(){
		Assert.assertEquals(dwnp.verityDownloadsHeader(), "Downloads List");
	}
	
	@Test(priority = 4)
	public void verifyHeadings(){
		Assert.assertTrue(dwnp.verifyHeadings());
	}
	
	@Test(priority = 5)
	public void verifyWebsites(){
		try {
			Assert.assertEquals(dwnp.verifyWindow(), "Java SE Development Kit 8 Downloads");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
