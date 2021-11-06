package PageObeject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject {
	

	@FindBy(id = "samlSignInLink")
	public static WebElement signInButton;

	@FindBy(id = "signInName")
	public static WebElement signInName;
	
	
	@FindBy(id = "password")
	public static WebElement password;
	
	@FindBy(xpath = "//button[text()='Sign In']")
	public static WebElement LoginBtn;
	
		
	
	

}
