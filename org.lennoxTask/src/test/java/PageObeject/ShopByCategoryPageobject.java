package PageObeject;

import org.BaseClass.BaseData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ShopByCategoryPageobject extends BaseData {
	

	
public static WebElement shopByCategoryOptions(String optionToSelect) {
		
		WebElement xpath  = driver.findElement(By.xpath("//*[text()='"+optionToSelect+"']"));
		
		return xpath;
	}
}
