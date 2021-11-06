package PageObeject;

import org.BaseClass.BaseData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PartsAndSuppliesPageObject  extends BaseData{



	public static WebElement partsAndSuppliesOptions(String optionToSelect) {

		WebElement xpath  = driver.findElement(By.xpath("//*[text()=' Shop by Category ']//following::a[text()='"+optionToSelect+"']"));
		//*[text()=' Shop by Category ']//following::a[text()='Parts and Supplies']
		return xpath;



	}
}