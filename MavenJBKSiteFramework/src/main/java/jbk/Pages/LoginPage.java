package jbk.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

import jbk.objectRepository.LoginObjectRepository;

public class LoginPage extends LoginObjectRepository {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public boolean jbkPage() {
		String actualTitle = driver.getTitle();
		String expectedTitle = "JavaByKiran | Log in";
		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Both are matched");
			return true;
		} else {
			System.out.println("Both are not matched");
			return false;
		}
	}

	public DashboardPage nevigateToDashboardPage(WebDriver driver)
	{ 
		username.sendKeys("kiran@gmail.com");
		password.sendKeys("123456");
		submitButton.click();
		return new DashboardPage(driver);
	}

	public void invalidLogin() {
		driver.navigate().refresh();
		username.sendKeys("kumar@gmail.com");
		password.sendKeys("67890");
		submitButton.click();
	}

	public void blankLogin() {
		username.sendKeys("");
		password.sendKeys("");
		submitButton.click();
	}

	public String errorTextOnWrongEmail() {
		driver.navigate().refresh();
		username.sendKeys("kumar@gmail.com");
		submitButton.click();
		String actualErrorText = errorMessage.getText();
		return actualErrorText;
	}

	public boolean verifyJBKLogo() {
		boolean logo = jbkLogo.isDisplayed();
		return logo;
	}

	public String newMemberRegistration() {
		newMemberReg.click();
		String actualTitle = driver.getTitle();
		driver.navigate().back();
		return actualTitle;
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
