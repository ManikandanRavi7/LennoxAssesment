package org.lennox.testcases;


import org.BaseClass.BaseData;
import org.lennnox.common.Purchase_CommonFunctions;
import org.lennnox.common.SignIn;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PurchaseCompressors_Flow extends BaseData {
	
	Purchase_CommonFunctions purchaseCommon = new Purchase_CommonFunctions();
	SignIn signInCommon = new SignIn();
	
	@BeforeTest
	public void startExecution() {

		openBrowser("chrome");
		navigateToPage("https://www.liidaveqa.com");
		signInCommon.signIn_From_HomeScreen();
	}

	@Test
	public void purchase_compressor_flow() {
		
		
		purchaseCommon.validatePurchase();
		
	}

	@AfterTest
	public void endExecution() {
		assertAll();
		closeBrowser();
		
	}
}


