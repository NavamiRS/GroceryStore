package testCases;

import java.awt.AWTException;

import org.testng.Assert;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageProductPage;

public class ManageProductPageTestCases extends BaseClass {
	LoginPage lp;
	ManageProductPage mpp;

	

	@Test(priority = 1,  description = "product stock button status")
	public void verify_The_Pdt_Stock_Status() throws InterruptedException {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.presteps();
		mpp.click_Pdt_Mngt();
		mpp.change_Stock_Status();
		String actual_Alt = mpp.get_Stock_Status_Alert();
		String expected_Alt = Constant.EXPECTED_ALERT_STOCK_STATUS_CHANGE;

		Assert.assertEquals(actual_Alt, expected_Alt, Constant.EXPECTED_ALERT_STOCK_STATUS_CHANGE_ERROR);
	}

	@Test(priority = 2,  description = "image verification")
	public void verifyThatUploadedImageIsDisplayed() throws InterruptedException, AWTException {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.presteps();
		mpp.click_Pdt_Mngt();
		mpp.click_New();
		mpp.imageVerification();

		boolean actual_Result = mpp.imageVerification();

		SoftAssert sf = new SoftAssert();
		sf.assertTrue(actual_Result);
		sf.assertAll();
		/*
		 * Assert.assertTrue(
		 * actual_Result,"----------------Image not uploaded-----------------");
		 */

	}

	@Test(priority = 3,  description = "checking the radio butn is selected by default")
	public void verifyTheStockRadioBtnIsSelectedByDefault() throws InterruptedException, AWTException {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.presteps();
		mpp.click_Pdt_Mngt();
		mpp.click_New();
		mpp.javascriptexe();

		boolean actual_Resul = mpp.stockRadioBtnVeri();
		Assert.assertTrue(actual_Resul, "---------Radio botton is not selected-------------");

	}

	@Test(priority = 4, description = "delete option")
	public void verifyDeleteOptionWorkinSucessfully() throws InterruptedException {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.presteps();
		mpp.click_Pdt_Mngt();
		mpp.deleteProduct();
		String actual_Alert = mpp.deleteProduct();
		String expected_Alert = Constant.PRODUCT_DELETE_ALERT;

		Assert.assertEquals(actual_Alert, expected_Alert, Constant.PRODUCT_DELETE_ALERT_ERROR);

	}

	@Test(priority = 5, description = "verify That Uploaded Image Is Displayed From Remote")
	public void verifyThatUploadedImageIsDisplayedFromRemote() throws InterruptedException, AWTException {
		lp = new LoginPage(driver);
		mpp = new ManageProductPage(driver);
		lp.presteps();
		mpp.click_Pdt_Mngt();
		mpp.click_New();
		mpp.imageUploadFromRemote();

		boolean actual_Result = mpp.imageUploadFromRemote();

		SoftAssert sf = new SoftAssert();
		sf.assertTrue(actual_Result);
		sf.assertAll();
	}
}
