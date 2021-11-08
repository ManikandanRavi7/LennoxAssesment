package org.lennox.testcases;

import java.io.IOException;

import org.BaseClass.BaseData;
import org.lennnox.common.Purchase_CommonFunctions;
import org.lennnox.common.SignIn;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Report;

public class PurchaseCompressors_Flow extends BaseData {

	Purchase_CommonFunctions purchaseCommon = new Purchase_CommonFunctions();
	SignIn signInCommon = new SignIn();
	private Object LogStatus;

	@BeforeTest
	public void startExecution() throws IOException {

		readTestData();
		openBrowser("chrome");
		navigateToPage(URL);
		// signInCommon.signIn_From_HomeScreen();

	}

	@Test
	public void purchase_compressor_flow() throws InterruptedException {

		purchaseCommon.validatePurchase();
		Thread.sleep(5000);

	}

	@AfterTest
	public void endExecution() {
		assertAll();

		closeBrowser();

	}
}
