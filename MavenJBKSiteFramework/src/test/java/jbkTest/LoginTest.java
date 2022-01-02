package jbkTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import jbk.Pages.LoginPage;
import jbk.base.TestBase;

public class LoginTest extends TestBase {
	WebDriver driver;
	LoginPage lp;

	@BeforeSuite
	public void setUp() {
		driver = initialisation();
		lp = new LoginPage(driver);
	}

	@Test(priority = 1)
	public void validateJbkPage() {
		Assert.assertTrue(lp.jbkPage());
	}

	@Test(priority = 2)
	public void verifyJBKLogo() {
		Assert.assertEquals(lp.verifyJBKLogo(), true);
	}

	@Test(priority = 9)
	public void validLogin() {
		driver.navigate().refresh();
		lp.nevigateToDashboardPage(driver);
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}

	@Test(priority = 4)
	public void invalidLogin() {
		lp.invalidLogin();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}

	@Test(priority = 3)
	public void blankLogin() {
		lp.blankLogin();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}

	@Test(priority = 5)
	public void errorTextOnWrongEmail() {
		lp.errorTextOnWrongEmail();
		Assert.assertEquals(lp.errorTextOnWrongEmail(), "Please enter email as kiran@gmail.com");
	}

	@Test(priority = 6)
	public void newMembersRegistration() {
		Assert.assertEquals(lp.newMemberRegistration(), "JavaByKiran | Registration Page");
	}

	// @AfterClass
	// public void afterClass() {
	// driver.close();
	// }
}
