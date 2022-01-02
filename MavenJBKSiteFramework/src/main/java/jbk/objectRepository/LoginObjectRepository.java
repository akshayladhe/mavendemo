package jbk.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import jbk.utilities.LogsUtility;

public class LoginObjectRepository extends LogsUtility {

	@FindBy(xpath = ("//img"))
	public WebElement jbkLogo;

	@FindBy(id = "email")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(xpath = ("//button"))
	public WebElement submitButton;

	@FindBy(id = ("email_error"))
	public WebElement errorMessage;

	@FindBy(linkText = ("Register a new membership"))
	public WebElement newMemberReg;

}
