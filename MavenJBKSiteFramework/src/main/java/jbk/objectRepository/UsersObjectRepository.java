package jbk.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import jbk.utilities.LogsUtility;

public class UsersObjectRepository extends LogsUtility {

	@FindBy(id = "email")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(xpath = "//button")
	public WebElement submitButton;

	@FindBy(linkText = "Users")
	public WebElement usersPage;

	@FindBy(tagName = "td")
	public List<WebElement> usersData;

	@FindBy(xpath = "//tr[2]/td[8]/a/span")
	public WebElement simpleAlert;

	@FindBy(xpath = "//*[@id=\"tr_2\"]/td[8]/a/span")
	public WebElement promptAlert;

	@FindBy(linkText = "Add User")
	public WebElement newUser;

	@FindBy(xpath = "//div/ul/li/a")
	public WebElement logout;

}
