package jbk.Pages;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import jbk.objectRepository.UsefulLinksObjectRepository;

public class UsefulLinksPage extends UsefulLinksObjectRepository {

	WebDriver driver;
	String childWinTitle;

	public UsefulLinksPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void validLogin() {
		username.sendKeys("kiran@gmail.com");
		password.sendKeys("123456");
		submitButton.click();
	}

	public String usefulLinksPage() {
		usefulLinks.click();
		String actualTitle = driver.getTitle();
		return actualTitle;
	}

	public String requirdCondition() {
		String cond = header.getText();
		return cond;
	}

	public boolean usefulLinks() throws Exception {
		ArrayList<String> actualLinks = new ArrayList<>();
		for (WebElement link : links) {
			String data = link.getText();
			actualLinks.add(data);
		}
		ArrayList<String> expectedLinks = new ArrayList<>();
		DataFormatter dff = new DataFormatter();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/usefullinks.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet("links");
		int rows = sheet.getLastRowNum();
		for (int i = 0; i <= rows; i++) {
			int column = sheet.getRow(i).getLastCellNum();
			for (int j = 0; j <= column; j++) {
				Cell cell = sheet.getRow(i).getCell(j);
				String callData = dff.formatCellValue(cell);
				expectedLinks.add(callData);
			}
			if (actualLinks.equals(expectedLinks))
				return true;
		}
		System.out.println(actualLinks);
		System.out.println(expectedLinks);
		return false;
	}

	public String verifyWindow() throws InterruptedException {
		String mainWindow = driver.getWindowHandle();
		for (WebElement window : goWindows)//6
			window.click();
		Thread.sleep(5000);
		Set<String> windows = driver.getWindowHandles();
		for (String childWindow : windows) {
			if (!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println(driver.getTitle());
				if (driver.getTitle().contains("Videos")) {
					childWinTitle = driver.getTitle();
					driver.close();
				}
			}
		}
		return childWinTitle;
	}
}
