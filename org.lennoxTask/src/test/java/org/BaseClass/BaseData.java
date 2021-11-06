package org.BaseClass;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class BaseData {


	public static WebDriver driver;
	private SoftAssert softAssert = new SoftAssert();
	public static final String projectPath = System.getProperty("user.dir");
	private WebDriverWait wd;
	private Actions ac;
	private Select dropDown;
	public static final String testFilePath = "\\src\\test\\resources\\TestData\\TestDataXL.xlsx";
	public static final String credentialsFilePath = "\\src\\test\\resources\\TestData\\Credentials.xlsx";
	public static final String UITexts = "\\src\\test\\resources\\TestData\\UITexts.xlsx";
	boolean status = false;
	public void openBrowser(String browserName) {

		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath+"\\src\\test\\resources\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath+"\\src\\test\\resources\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else {
			System.setProperty("webdriver.ie.driver", projectPath+"\\src\\test\\resources\\Drivers\\chromedriver.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}

	}

	public void navigateToPage(String url) {

		driver.navigate().to(url);

	}

	public void fillTextBox(WebElement e, String text) {
		e.sendKeys(text);
	}

	public void fillTextBox(WebElement e, String text, int timeInSecs) {
		waitElementPresents(e, timeInSecs);
		e.sendKeys(text);
	}

	public void click(WebElement e) {

		e.click();

	}

	public void click(WebElement e, int timeInSecs) {

		waitElementClickable(e, timeInSecs);
		e.click();

	}

	public void closeBrowser() {

		driver.quit();
	}

	public void waitElementPresents(WebElement e, int timeInSecs) {

		wd = new WebDriverWait(driver, timeInSecs);
		wd.until(ExpectedConditions.visibilityOf(e));

	}

	public void waitElementClickable(WebElement e, int timeInSecs) {

		wd = new WebDriverWait(driver, timeInSecs);
		wd.until(ExpectedConditions.elementToBeClickable(e));

	}

	public void assertEquals(Object actual, Object expected) {

		softAssert.assertEquals(actual, expected);

	}

	public void assertTrue(boolean condition, String message) {

		softAssert.assertTrue(condition, message);
		System.out.println(message.replace("not", ""));
		Reporter.log(message.replace("not ", ""));

	}

	public void assertAll() {

		softAssert.assertAll();

	}


	public String getElementText(WebElement e) {

		String elementText = e.getText();

		return elementText;

	}

	public String getAttribute(WebElement e, String attribute) {

		e.getAttribute("attribute");

		return attribute;
	}

	public void screenshot(WebElement element) throws IOException {

		TakesScreenshot tk = (TakesScreenshot)driver;
		File sourceFilePath = tk.getScreenshotAs(OutputType.FILE);
		System.out.println(sourceFilePath);

		File d = new File("D:\\Eclipse Installed Folder\\eclipse-committers-oxygen-3a-win32-x86_64\\eclipse\\ProjectClass\\Lennox_AutomationAssessment\\Screenshot\\"+element.getText()+".jpg");
		FileUtils.copyFile(sourceFilePath, d);

	}

	public void scrollDownByJS(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}
	public void scrollUpByJS(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);

	}

	public void moveToElementNClick(WebElement element) {

		ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
		ac.click().build().perform();

	}

	public void dropDownByValue(WebElement e, String value) {

		dropDown = new Select(e);
		dropDown.selectByValue(value);

	}
	public Boolean isElementFound(String elementToVerify) {


		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		if(driver.findElement(By.xpath(elementToVerify)).isDisplayed()) {
			System.out.println("Status --------- "+status);
			return status;
		}
		else {

			return status;
		}
	}
	
	public void readExcelData() {
		
		
		
	}
}