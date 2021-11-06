package org.lennnox.common;

import org.BaseClass.BaseData;
import org.openqa.selenium.support.PageFactory;

import PageObeject.CompressorsPageobjectModel;
import PageObeject.LoginPageObject;
import PageObeject.PartsAndSuppliesPageObject;
import PageObeject.ShopByCategoryPageobject;
import PageObeject.TopLevelMenuPageObject;

public class Purchase_CommonFunctions extends BaseData {

	public void validatePurchase() {
		PageFactory.initElements(driver, CompressorsPageobjectModel.class);
		PageFactory.initElements(driver, LoginPageObject.class);
		PageFactory.initElements(driver, PartsAndSuppliesPageObject.class);
		PageFactory.initElements(driver, ShopByCategoryPageobject.class);
		PageFactory.initElements(driver, TopLevelMenuPageObject.class);

		click(TopLevelMenuPageObject.hamburgerMenu,10);
		click(TopLevelMenuPageObject.productCatalogOptions("Product Catalog"),10);
		scrollDownByJS(PartsAndSuppliesPageObject.partsAndSuppliesOptions("Parts and Supplies"));
		click(PartsAndSuppliesPageObject.partsAndSuppliesOptions("Parts and Supplies"),10);
		click(ShopByCategoryPageobject.shopByCategoryOptions("Compressors"),10);
		click(CompressorsPageobjectModel.partsAndSuppliesOptions("Compressors"));
		assertEquals(CompressorsPageobjectModel.landingPgHeader.getText(),"Compressors");
		assertEquals(CompressorsPageobjectModel.landingPgDesc.getText(),"\r\n"
				+ "                                Replace your compressor at LennoxPros.com.");
		findProductOnSearchList();


	}


	public void findProductOnSearchList() {

		try {

			System.out.println("Status is ------"+isElementFound("//div[text()=' 10T46']"));

			for(int i=1; i<=25; i++) {
				if(isElementFound("//div[text()=' 10T46']")) {
					click(CompressorsPageobjectModel.productCatNumber("10T46"));
					Thread.sleep(5000); 
					break; 

				} 
				else {

					scrollDownByJS(CompressorsPageobjectModel.nextPgBtn);
					click(CompressorsPageobjectModel.nextPgBtn,10); } }


		}
		catch (Exception e) {

			System.out.println(e.getMessage());

		}


	}

}
