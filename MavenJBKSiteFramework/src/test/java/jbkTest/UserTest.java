package jbkTest;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import jbk.Pages.LoginPage;
import jbk.Pages.UsersPage;
import jbk.base.TestBase;
import jbk.listeners.TestListeners;

public class UserTest extends TestBase {
	WebDriver driver;
	UsersPage up;
	LoginPage lp;
	TestListeners listen;
	public static Logger log = Logger.getLogger(UserTest.class);

	@BeforeSuite
	public void setUp() {
		driver = initialisation();
		lp = new LoginPage(driver);
		up = lp.nevigateToDashboardPage(driver).nevigateToUsersPage(driver);
		listen = new TestListeners();
	}

	// @Test(priority = 1)
	// public void validLogin() {
	// up.validLogin();
	// Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	// }

	@Test(priority = 2)
	public void verifyUserPage() {
		Assert.assertEquals(up.verifyUserPage(), "JavaByKiran | User");
	}

	@Test(priority = 3)
	public void verifyUsersDataFromExcel() throws Exception {
		Assert.assertTrue(up.varifyUsersDataWithExcel());
	}

	@Test(priority = 4)
	public void simpleAlertMessage() {
		Assert.assertTrue(up.simpleAlertAtDelete());
	}

	@Test(priority = 5)
	public void promptAlertMessage() {
		Assert.assertEquals(up.promptAlertAtDelete(), "Are you sure you want to delete this user");
	}

	@Test(priority = 6)
	public void addNewUser() {
		Assert.assertEquals(up.addNewUser(), "JavaByKiran | Add User");
	}

	@Test(priority = 7, enabled = false)
	public void logOut() {
		up.logOut();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}
}
