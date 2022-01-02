package jbkTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import jbk.Pages.LoginPage;
import jbk.Pages.OperatorsPage;
import jbk.base.TestBase;

public class OperatorsTest extends TestBase {

	WebDriver driver;
	LoginPage lp;
	OperatorsPage op;

	@BeforeSuite
	public void setUp() {
		driver = initialisation();
		lp = new LoginPage(driver);
		op = lp.nevigateToDashboardPage(driver).navigateToOperatorsPage(driver);
		op = new OperatorsPage(driver);
	}

	@Test(priority = 2)
	public void verifyOperatorsPageTitle() {
		Assert.assertEquals(op.operatorsPage(), "JavaByKiran | Operators");
	}

	@Test(priority = 3)
	public void verifyHeader() {
		Assert.assertEquals(op.header(), "Operator List");
	}

	@Test(priority = 4)
	public void operatorsData() throws EncryptedDocumentException, InvalidFormatException, IOException {
		ArrayList<String> expectedData = new ArrayList<String>();
		DataFormatter df = new DataFormatter();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/AllOperatorsData.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet("ODSheet");
		int rows = sheet.getLastRowNum();
		for (int i = 1; i <= rows; i++) {
			int colm = sheet.getRow(i).getLastCellNum();
			for (int j = 0; j <= colm; j++) {
				Cell cell = sheet.getRow(i).getCell(j);
				String value = df.formatCellValue(cell);
				expectedData.add(value);
				System.out.print(value);
			}
		}
		ArrayList<String> actualData = new ArrayList<String>();
		List<WebElement> Data = driver.findElements(By.xpath("//td"));
		for (WebElement operator : Data)
			actualData.add(operator.getText());
		Assert.assertEquals(actualData, expectedData);
	}

	@Test(priority = 7)

	public void checkUserOnWattapOnly() throws Exception {
		List<WebElement> userNameColumn = driver.findElements(By.xpath("//td[2]"));
		List<WebElement> contactColumn = driver.findElements(By.xpath("//td[4]"));
		ArrayList<String> actaulData = new ArrayList<String>();
		for (int i = 0; i < userNameColumn.size(); i++) {
			String user = userNameColumn.get(i).getText();
			String contactData = contactColumn.get(i).getText();
			if (contactData.contains("Whats App Only")) {
				actaulData.add(user);
			}
		}
		System.out.println("actaul list of user available on wattasap" + actaulData);

		//ArrayList<String> expectedData = new ArrayList<String>();
		DataFormatter df = new DataFormatter();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/AllOperatorsData.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet("ODSheet");
		int row = sheet.getLastRowNum();
		for (int i = 0; i <= row; i++) {
			int column = sheet.getRow(i).getLastCellNum();
			for (int j = 0; j <= column; j++) {
				Cell cell = sheet.getRow(i).getCell(j);
				String value = df.formatCellValue(cell);
				System.out.println(value);
			}

		}

	}
}
