package org.lennnox.common;

import org.BaseClass.BaseData;
import org.openqa.selenium.support.PageFactory;

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
		PageFactory.initElements(driver, LoginPageObject.class);
		System.out.println(LoginPageObject.signInButton);

		click(LoginPageObject.signInButton,10); 
		fillTextBox(LoginPageObject.signInName,EMailID,10); 
		fillTextBox(LoginPageObject.password,Password,10); 
		click(LoginPageObject.LoginBtn,10);
		assertEquals(LoginPageObject.signInButton, PageTitle);


	}

}
