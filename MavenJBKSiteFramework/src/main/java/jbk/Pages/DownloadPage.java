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

import jbk.objectRepository.DownloadObjectRepository;

public class DownloadPage extends DownloadObjectRepository {
	WebDriver driver;
	FileInputStream file;
	Workbook wb;
	String childWinTitle;

	public DownloadPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void validLogin() {
		username.sendKeys("kiran@gmail.com");
		password.sendKeys("123456");
		submitButton.click();
	}

	public String verifyDownloadPageTitle() {
		downld.click();
		String actualTitle = driver.getTitle();
		return actualTitle;
	}

	public String verityDownloadsHeader() {
		String actualTitle = header.getText();
		return actualTitle;
	}

	public boolean verifyHeadings() {
		ArrayList<String> actualList = new ArrayList<>();
		for (WebElement heading : headings) {
			String text = heading.getText();
			actualList.add(text);
		}
		ArrayList<String> expectedList = new ArrayList<>();
		DataFormatter dff = new DataFormatter();
		try {
			file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/downlds.xlsx");
			wb = WorkbookFactory.create(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet("dataSheet");
		//int rowNum = sheet.getLastRowNum();
		//for (int i = 0; i <= rowNum; i++) {
			//int column = sheet.getRow(i).getLastCellNum();}
			for (int j = 0; j <= 8; j++) {
				Cell cell = sheet.getRow(0).getCell(j);
				String text = dff.formatCellValue(cell);
				expectedList.add(text);
			}
			if (actualList.equals(expectedList))
				return true;
		System.out.println(actualList);
		System.out.println(expectedList);
		return false;
}
	
	public String verifyWindow() throws InterruptedException {
		String mainWindow = driver.getWindowHandle();
		for (WebElement window : websites)
			window.click();
		Thread.sleep(30000);
		Set<String> windows = driver.getWindowHandles();
		for (String childWindow : windows) {
			if (!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
				System.out.println(driver.getTitle());
				if (driver.getTitle().contains("Java SE Development Kit 8 Downloads")) {
					childWinTitle = driver.getTitle();
					driver.close();
				}
			}
		}
		return childWinTitle;
	}
}
