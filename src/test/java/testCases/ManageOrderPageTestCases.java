package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageOrderPage;

public class ManageOrderPageTestCases extends BaseClass {
	@Test(priority = 1, alwaysRun = true, description = "verify the paymentmode list  ")
	public void verifyThePaymentModeList() throws InterruptedException {
		LoginPage lp;
		ManageOrderPage mop;

		lp = new LoginPage(driver);
		mop = new ManageOrderPage(driver);
		lp.presteps();
		boolean actual_PaymentMode = mop.searchPaymentModeListDetails();

		Assert.assertTrue(actual_PaymentMode, Constant.PAYMENTMODEERROR);

	}

	@Test(priority = 2, alwaysRun = true, description = "verifyThatOrderIdAndPaymentModeWhileClickingSearchOption ")
	public void verifyThatOrderIdAndPaymentModeWhileClickingSearchOption() throws InterruptedException {
		LoginPage lp;
		ManageOrderPage mop;

		lp = new LoginPage(driver);
		mop = new ManageOrderPage(driver);
		lp.presteps();
		mop.orderIdAndPaymentModeVeri();

		String actual_Orderid = mop.orderIdVerification();
		String actual_PaymentMode = mop.PaymentModeVerification();

		String expected_OrderId = "367";

		String expected_PaymentMode = "COD";

		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual_Orderid, expected_OrderId, Constant.PAYMENTMODE_ORDERIDERROR);
		sa.assertEquals(actual_PaymentMode, expected_PaymentMode, Constant.PAYMENTMODEERROR);
		sa.assertAll();
	}

	@Test(priority = 3, alwaysRun = true, description = "verify the status dropdown size")
	public void verifyStatusDropDownSize() throws InterruptedException {
		LoginPage lp;
		ManageOrderPage mop;

		lp = new LoginPage(driver);
		mop = new ManageOrderPage(driver);
		lp.presteps();
		int actualSize = mop.statusDropDown();
		int expectedSize = 5;

		Assert.assertEquals(actualSize, expectedSize, Constant.PAYMENTMODE_DROPDOWNSIZE_ERROR);
	}
}
