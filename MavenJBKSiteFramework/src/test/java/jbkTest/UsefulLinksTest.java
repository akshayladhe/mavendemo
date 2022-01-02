package jbkTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import jbk.Pages.LoginPage;
import jbk.Pages.UsefulLinksPage;
import jbk.base.TestBase;

public class UsefulLinksTest extends TestBase {

	WebDriver driver;
	LoginPage lp;
	UsefulLinksPage ulp;

	@BeforeSuite
	public void setUp() {
		driver = initialisation();
		lp = new LoginPage(driver);
		ulp = lp.nevigateToDashboardPage(driver).navigateToUsefulLinksPage(driver);
		ulp = new UsefulLinksPage(driver);
	}

	@Test(priority = 2)
	public void verifyUsefulLinksPage() {
		Assert.assertEquals(ulp.usefulLinksPage(), "JavaByKiran | Useful Links");
	}

	@Test(priority = 3)
	public void verifyRequiredCondition() {
		Assert.assertEquals(ulp.requirdCondition(), "* Internet Required");
	}

	@Test(priority = 4)
	public void verifyUsefulLinks() throws Exception {
		Assert.assertTrue(ulp.usefulLinks());
	}

	@Test(priority = 5, enabled = false)
	public void verifyLiveVideoCW() throws Exception{
		Assert.assertEquals(ulp.verifyWindow(), "Live Videos | javabyKiran");
	}
}
