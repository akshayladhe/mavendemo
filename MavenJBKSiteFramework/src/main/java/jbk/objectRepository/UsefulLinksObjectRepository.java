package jbk.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import jbk.utilities.LogsUtility;

public class UsefulLinksObjectRepository extends LogsUtility {

	@FindBy(id = "email")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(xpath = "//button")
	public WebElement submitButton;

	@FindBy(linkText = "Useful Links")
	public WebElement usefulLinks;
	
	@FindBy(className = "box-title")
	public WebElement header;
	
	@FindBy(xpath = "//td/a/span")
	public List<WebElement> goWindows;
	
	@FindBy(xpath = "//td")
	public List<WebElement> links;
}
