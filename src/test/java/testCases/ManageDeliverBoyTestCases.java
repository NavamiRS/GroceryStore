package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.Dashboard;
import elementRepository.LoginPage;
import elementRepository.ManageDeliveryBoy;

public class ManageDeliverBoyTestCases extends BaseClass {
	LoginPage lp;
	Dashboard db;
	ManageDeliveryBoy mdb;

	@Test(priority = 1, description = "tooltipvalidation", groups = { "SmokeTest" })
	public void validateToolTip() throws InterruptedException {
		lp = new LoginPage(driver);

		mdb = new ManageDeliveryBoy(driver);

		lp.presteps();

		String expectedToolTip_For_Password = Constant.TOOLTIP_PASSWORD;
		String actualToolTip_For_Password = mdb.toolTipValiadation();
		Assert.assertEquals(actualToolTip_For_Password, expectedToolTip_For_Password, Constant.TOOLTIP_ERROR_PASSWORD);

	}

	@Test(priority = 2, description = "New Button Style Validation")

	public void newStyleValidation() throws InterruptedException {
		lp = new LoginPage(driver);

		mdb = new ManageDeliveryBoy(driver);

		lp.presteps();
		String actual_New_Style = mdb.New_Btn_Style_Ppty();
		String expected_New_Style = Constant.NEW_BODY_CLR_PPTY;
		Assert.assertEquals(actual_New_Style, expected_New_Style, Constant.NEW_BODY_CLR_ERROR);

	}

	@Test(priority = 3, description = "New Button Style Validation")

	public void verifySearchBtnIsClickable() throws InterruptedException {
		lp = new LoginPage(driver);
		mdb = new ManageDeliveryBoy(driver);
		lp.presteps();

		boolean actual_Result_Search_Btn = mdb.click_Serch_Btn();
		Assert.assertTrue(actual_Result_Search_Btn);
	}

}
