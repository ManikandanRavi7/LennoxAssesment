package org.lennnox.common;

import org.BaseClass.BaseData;
import org.lennox.testcases.PurchaseCompressors_Flow;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import PageObeject.CompressorsPageobjectModel;
import PageObeject.LoginPageObject;
import PageObeject.PartsAndSuppliesPageObject;
import PageObeject.ShopByCategoryPageobject;
import PageObeject.TopLevelMenuPageObject;

public class SignIn extends BaseData {

	TopLevelMenuPageObject tlmPg = PageFactory.initElements(driver, TopLevelMenuPageObject.class);
	PartsAndSuppliesPageObject prtsAndSuppPG = PageFactory.initElements(driver, PartsAndSuppliesPageObject.class);
	ShopByCategoryPageobject shopByCatPg = PageFactory.initElements(driver, ShopByCategoryPageobject.class);
	CompressorsPageobjectModel compPg = PageFactory.initElements(driver, CompressorsPageobjectModel.class);

	public void signIn_From_HomeScreen() {

		ExtentTest test = PurchaseCompressors_Flow.extent.createTest("Sign Inn");
		PageFactory.initElements(driver, LoginPageObject.class);
		System.out.println(LoginPageObject.signInButton);

		click(LoginPageObject.signInButton, 10);
		fillTextBox(LoginPageObject.signInName, EMailID, 10);
		test.log(Status.INFO, "entering username" + EMailID);
		fillTextBox(LoginPageObject.password, Password, 10);
		test.log(Status.INFO, "entering password" + Password);
		click(LoginPageObject.LoginBtn, 10);
		test.log(Status.INFO, "Logged Clicked");
		try {
			assertEquals(LoginPageObject.signInButton, PageTitle);
		} catch (AssertionError e) {
			test.log(Status.FAIL, e.getMessage());
			test.log(Status.FAIL, "Login failed");

		}
	}

}
