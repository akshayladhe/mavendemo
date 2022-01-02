package jbk.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectUtils {

	
	public void selectText(WebElement WebElement, String text)
	{
		Select sel = new Select(WebElement);
		sel.selectByVisibleText(text);
	}
}
