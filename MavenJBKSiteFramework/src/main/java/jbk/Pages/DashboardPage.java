package jbk.Pages;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import jbk.objectRepository.DashboardObjectRepository;
import jbk.utilities.LogsUtility;

public class DashboardPage extends DashboardObjectRepository {
	WebDriver driver;
	LogsUtility lu;

	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public void validLogin() {
		
		username.sendKeys("kiran@gmail.com");
		password.sendKeys("123456");
		submitButton.click();
	}

	public String verifyProfileName() {
		pageLog().info("profile name is.....");
		String proName = profileName.getText();
		return proName;
	}

	public boolean verifyProfilePicture() {
		pageLog().info("image disply");
		boolean profileImg = img.isDisplayed();
		return profileImg;
	}

	public boolean verifyMoreInfo() {
		pageLog().info("getting selenium window");
		moreInfo.click();
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String ChildWin : windows) {
			if (!ChildWin.equals(mainWindow)) {

				driver.switchTo().window(ChildWin);
				if (driver.getCurrentUrl().contains("Selenium"))
					driver.close();
			}
		}
		return false;
	}

	public boolean getAllCourses() {
		ArrayList<String> actualCourses = new ArrayList<String>();
		for (WebElement course : courses) {
			String Text = course.getText();
			actualCourses.add(Text);
		}
		ArrayList<String> expectedCourses = new ArrayList<String>();
		expectedCourses.add("Selenium");
		expectedCourses.add("Java / J2EE");
		expectedCourses.add("Python");
		expectedCourses.add("Php");
		if (actualCourses.equals(expectedCourses))
			return true;
		return false;
	}

	public boolean menuElements() {
		ArrayList<String> actualElements = new ArrayList<String>();
		for (WebElement elements : sideMenu) {
			String Text = elements.getText();
			actualElements.add(Text);
		}
		ArrayList<String> expectedElements = new ArrayList<String>();
		expectedElements.add("Dashboard");
		expectedElements.add("Users");
		expectedElements.add("Operators");
		expectedElements.add("Useful Links");
		expectedElements.add("Downloads");
		expectedElements.add("Logout");
		if (actualElements.equals(expectedElements))
			return true;
		return false;
	}

	public void logOut() {
		logout.click();
	}

	public String dashboardHeading() {
		String actualText = heading.getText();
		return actualText;
	}

	public boolean dashboardCoursesColours() {
		ArrayList<String> actualColours = new ArrayList<>();
		for (WebElement text : coursesColours) {
			String colourText = text.getAttribute("class");
			String colour = colourText.substring(colourText.lastIndexOf('-') + 1);
			actualColours.add(colour);
		}
		ArrayList<String> expectedColours = new ArrayList<String>();
		{
			expectedColours.add("aqua");
			expectedColours.add("green");
			expectedColours.add("yellow");
			expectedColours.add("red");
			if (actualColours.equals(expectedColours))
				return true;
		}
		return false;
	}

	public boolean DashboardPageCoursesIcons() {
		ArrayList<String> actualIcons = new ArrayList<>();
		for (WebElement text : icons) {
			String iconText = text.getAttribute("class");
			String symbolIcon = iconText.substring(iconText.lastIndexOf('-') + 1);
			actualIcons.add(symbolIcon);
		}
		ArrayList<String> expectedIcons = new ArrayList<>();
		{
			expectedIcons.add("bag");
			expectedIcons.add("bars");
			expectedIcons.add("add");
			expectedIcons.add("graph");
			if (actualIcons.equals(expectedIcons))
				return true;
		}
		return false;
	}

	public UsersPage nevigateToUsersPage(WebDriver driver) {
		users.click();
		return new UsersPage(driver);
	}

	public OperatorsPage navigateToOperatorsPage(WebDriver driver) {
		operator.click();
		return new OperatorsPage(driver);
	}

	public UsefulLinksPage navigateToUsefulLinksPage(WebDriver driver) {
		usefulLnk.click();
		return new UsefulLinksPage(driver);
	}

	public DownloadPage navigateToDownloadPage(WebDriver driver) {
		downloads.click();
		return new DownloadPage(driver);
	}
}
