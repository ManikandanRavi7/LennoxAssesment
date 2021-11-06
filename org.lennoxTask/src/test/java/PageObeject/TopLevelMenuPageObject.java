package PageObeject;

import org.BaseClass.BaseData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TopLevelMenuPageObject extends BaseData {
	
	
	@FindBy(xpath = "//a[@href='#navigation']")
	public static WebElement hamburgerMenu;

	
	public static WebElement productCatalogOptions(String optionToSelect) {
		
		WebElement xpath  = driver.findElement(By.xpath("//*[text()='PRODUCT']//following::*[text()='"+optionToSelect+"']"));
		
		return xpath;
	}

	
	
}
