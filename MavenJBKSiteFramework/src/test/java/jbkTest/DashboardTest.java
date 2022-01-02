package jbkTest;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import jbk.Pages.DashboardPage;
import jbk.base.TestBase;

public class DashboardTest extends TestBase {

	WebDriver driver;
	DashboardPage dp;

	@BeforeSuite
	public void setUp() {
		driver = initialisation();
		dp = new DashboardPage(driver);
	}

	@Test(priority = 1 )
	public void validLogin() {
		testLog().info("valid login");
		dp.validLogin();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Dashboard");
	}

	@Test(priority = 2)
	public void verifyProfileName() {
		testLog().info("profile name is");
		Assert.assertEquals(dp.verifyProfileName(), "Kiran");
	}

	@Test(priority = 3)
	public void verifyProfilePhoto() {
		testLog().info("disply profile photo");
		Assert.assertEquals(dp.verifyProfilePicture(), true);
	}

	@Test(priority = 4)
	public void verifyCourses() {
		Assert.assertTrue(dp.getAllCourses());
	}

	@Test(priority = 5)
	public void verifyMenuElements() {
		Assert.assertTrue(dp.menuElements());
	}

	@Test(priority = 6)
	public void verifyDashboardPageHeading() {
		Assert.assertEquals(dp.dashboardHeading(), "Dashboard Courses Offered");
	}

	@Test(priority = 7)
	public void verifyDashboadCoursesColours() {
		Assert.assertTrue(dp.dashboardCoursesColours());
	}

	@Test(priority = 8)
	public void verifyDashboadCoursesIcons() {
		Assert.assertTrue(dp.DashboardPageCoursesIcons());
	}
	
	@Test(priority = 9, enabled = false)
	public void validateUserPage(){
		dp.nevigateToUsersPage(driver);
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Users");
	}
	
	@Test(priority = 12)
	public void validateOperatorsPage(){
		dp.navigateToOperatorsPage(driver);
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Operators");
	}
	
	@Test(priority = 13)
	public void validateUsefulLinksPage(){
		dp.navigateToUsefulLinksPage(driver);
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Useful Links");
	}
	
	@Test(priority = 14)
	public void validateDownloadPage(){
		dp.navigateToDownloadPage(driver);
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Downloads");
	}

	@Test(priority = 19, enabled = false)
	public void logOut() {
		dp.logOut();
		Assert.assertEquals(driver.getTitle(), "JavaByKiran | Log in");
	}
	
	
}
