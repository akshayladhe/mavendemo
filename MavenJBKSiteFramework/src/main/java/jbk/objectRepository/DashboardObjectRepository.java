package jbk.objectRepository;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import jbk.utilities.LogsUtility;

public class DashboardObjectRepository extends LogsUtility {

	@FindBy(id = "email")
	public WebElement username;

	@FindBy(id = "password")
	public WebElement password;

	@FindBy(xpath = "//button")
	public WebElement submitButton;

	@FindBy(xpath = "//div[2]/p")
	public WebElement profileName;

	@FindBy(xpath = "//img")
	public WebElement img;

	@FindBy(tagName = "h3")
	public List<WebElement> courses;

	@FindBy(xpath = "//li//span")
	public List<WebElement> sideMenu;

	@FindBy(xpath = "//div/ul/li/a")
	public WebElement logout;

	@FindBy(linkText = "More info")
	public WebElement moreInfo;

	@FindBy(tagName = "h1")
	public WebElement heading;

	@FindBy(xpath = "//div//parent::div[contains(@class,'small-box ')]")
	public List<WebElement> coursesColours;

	@FindBy(xpath = "//div/i")
	public List<WebElement> icons;
	
	@FindBy(xpath = "//ul/li[3]")
	public WebElement users;

	@FindBy(xpath = "//ul/li[4]")
	public WebElement operator;
	
	@FindBy(xpath = "//ul/li[6]")
	public WebElement downloads;
	
	@FindBy(xpath = "//ul/li[5]")
	public WebElement usefulLnk;
}
