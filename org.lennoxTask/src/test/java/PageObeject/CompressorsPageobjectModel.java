package PageObeject;

import org.BaseClass.BaseData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompressorsPageobjectModel extends BaseData {

	public static WebElement partsAndSuppliesOptions(String optionToSelect) {

		WebElement xpath  = driver.findElement(By.xpath("//*[@class='parent']//following::a[text()='"+optionToSelect+"']"));

		return xpath;

	}

	public static WebElement productCatNumber(String catNo) {

		WebElement xpath =   driver.findElement(By.xpath("//div[text()=' "+catNo+"']"));

		return xpath;
		
		
	}
	
	@FindBy(xpath = "//div[@class='col-md-6']//h1")
	public static WebElement landingPgHeader;
	
	@FindBy(xpath = "//div[@class='col-md-6']//p")
	public static WebElement landingPgDesc;
	
	@FindBy(xpath = "//*[@class='next icon icon-arrow-right']")
	public static WebElement nextPgBtn;

}


