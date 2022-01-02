package jbk.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import jbk.objectRepository.OperatorsObjectRepository;

public class OperatorsPage extends OperatorsObjectRepository {

	WebDriver driver;

	public OperatorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void validLogin() {
		username.sendKeys("kiran@gmail.com");
		password.sendKeys("123456");
		submitButton.click();
	}

	public String operatorsPage(){
		operators.click();
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		return actualTitle;
	}
	public String header(){
		String headName = header.getText();
		return headName;
	}

	
	
	
//	public void operatorsDataNew() throws EncryptedDocumentException, InvalidFormatException, IOException{
//		ArrayList<String> Data = new ArrayList<String>();
//		DataFormatter df = new DataFormatter();
//		FileInputStream file = new FileInputStream("OperatorsData.xls");
//		Workbook wb = Workbook.
//		Sheet sheet = wb.getSheet("ODSheet");
//		int rows = sheet.getRows();
//	}
	
}
