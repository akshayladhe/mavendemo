package jbk.Pages;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import jbk.objectRepository.UsersObjectRepository;

public class UsersPage extends UsersObjectRepository {
	WebDriver driver;

	public UsersPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void validLogin() {
		username.sendKeys("kiran@gmail.com");
		password.sendKeys("123456");
		submitButton.click();
	}

	public String verifyUserPage() {
		usersPage.click();
		String actualTitle = driver.getTitle();
		return actualTitle;
	}

	public boolean varifyUsersDataWithExcel() throws Exception {
		ArrayList<String> expectedUsersData = new ArrayList<String>();
		DataFormatter dff = new DataFormatter();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/UserData.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet("UsersDataSheet");
		int rows = sh.getLastRowNum();
		for (int i = 0; i <= rows; i++) {
			int colm = sh.getRow(i).getLastCellNum();
			for (int j = 0; j < colm; j++) {
				Cell cell = sh.getRow(i).getCell(j);
				String Data = dff.formatCellValue(cell);
				expectedUsersData.add(Data);
			} 
		}
		ArrayList<String> actualUsersData = new ArrayList<String>();
		{
			for (WebElement userData : usersData)
				actualUsersData.add(userData.getText());
			if (actualUsersData.equals(expectedUsersData))
				return true;
		}
		return false;
	}

	public boolean simpleAlertAtDelete() {
		simpleAlert.click();
		String actualAlertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		String expectedAlertMessage = "You can not delete Default User";
		if (actualAlertMessage.equals(expectedAlertMessage)) {
			return true;
		}
		return false;
	}

	public String promptAlertAtDelete() {
		promptAlert.click();
		String actualAlertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		return actualAlertMessage;
	}

	public String addNewUser() {
		newUser.click();
		String actualTitle = driver.getTitle();
		return actualTitle;

	}

	public void logOut() {
		logout.click();
	}
}