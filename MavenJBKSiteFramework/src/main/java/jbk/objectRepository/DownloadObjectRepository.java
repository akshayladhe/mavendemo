package jbk.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import jbk.utilities.LogsUtility;

public class DownloadObjectRepository extends LogsUtility {

	@FindBy(id = "email")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(xpath = "//button")
	public WebElement submitButton;

	@FindBy(linkText = "Downloads")
	public WebElement downld;
	
	@FindBy(className="box-title")
	public WebElement header;
	
	@FindBy(xpath = "//th")
	public List<WebElement> headings;
	
	@FindBy(xpath = "//span[@class='label label-warning']")
	public List<WebElement> websites;
}
