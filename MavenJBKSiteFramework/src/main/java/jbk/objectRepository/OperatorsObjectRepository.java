package jbk.objectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import jbk.utilities.LogsUtility;

public class OperatorsObjectRepository extends LogsUtility {

	@FindBy(id = "email")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(xpath = "//button")
	public WebElement submitButton;
	
	@FindBy(linkText = "Operators")
	public WebElement operators;
	
	@FindBy(className = "box-header")
	public WebElement header;
}
