package org.lennnox.common;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.BaseClass.BaseData;
import org.apache.commons.collections4.map.HashedMap;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.NeedsLocalLogs;
import org.openqa.selenium.remote.NewSessionPayload;
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

		click(TopLevelMenuPageObject.hamburgerMenu, 10);
		click(TopLevelMenuPageObject.productCatalogOptions(LinkName), 10);
		scrollDownByJS(PartsAndSuppliesPageObject.partsAndSuppliesOptions(PageNavigation));
		click(PartsAndSuppliesPageObject.partsAndSuppliesOptions(PageNavigation), 10);
		click(ShopByCategoryPageobject.shopByCategoryOptions(PageTitle), 10);
		click(CompressorsPageobjectModel.partsAndSuppliesOptions(PageTitle));
		assertEquals(CompressorsPageobjectModel.landingPgHeader.getText(), PageTitle);
		assertEquals(CompressorsPageobjectModel.landingPgDesc.getText(), PageDescription);
		findProductOnSearchList(CatalogNo, CompressorsPageobjectModel.nextPgBtn);

	}

	public void findProductOnSearchList(String textToFind, WebElement nextPageButton) {

		for (int i = 1; i <= 20; i++) {

			System.out.println("Text " + textToFind);

			int size = driver.findElements(By.xpath("//*[text()=' " + CatalogNo + "']")).size();
			System.out.println("Size of product element to find " + size);
			if (size != 0) {

				System.out.println("Expected element found.");
				driver.findElements(By.xpath("//*[text()=' " + CatalogNo + "']")).get(0).click();
				break;
			} else {
				System.out.println("Element not found. Navigating to page no : " + (i + 1));
				scrollDownByJS(nextPageButton);
				waitElementClickable(nextPageButton, 10);
				click(nextPageButton, 10);
			}
		}

		WebElement ProductDesc = driver.findElement(By.xpath("//h1[@class='mb-0 pb-3']"));
		String PDesc = ProductDesc.getText();
		System.out.println(PDesc);

		WebElement ModelDesc = driver.findElement(By.xpath("(//p[@class='product-text mb-0'])[2]"));
		String MDesc = ModelDesc.getText();
		MDesc = MDesc.replace("Model/Part # : ", "");
		System.out.println(MDesc);

		Map<String, String> data = new HashedMap<String, String>();
		data.put("ProductName", PDesc);
		data.put("Modelname", MDesc);

		System.out.println(data);

	}

}
