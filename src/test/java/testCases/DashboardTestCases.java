package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.Dashboard;
import elementRepository.LoginPage;

public class DashboardTestCases extends BaseClass {

	LoginPage lp;
	Dashboard db;

	@Test(priority = 1, alwaysRun = true, description = "validating title of manageExpense")
	public void verifyTitleOfManageExpense() {
		lp = new LoginPage(driver);
		db = new Dashboard(driver);
		lp.presteps();

		String expectedName_ManageExpense = Constant.EXPECTED_TITLE_OF_MANAGEEXPENSE;
		String actualName_ManageExpense = db.manageExpenseNameVerification();
		Assert.assertEquals(actualName_ManageExpense, expectedName_ManageExpense, Constant.MANAGEEXPENSE_TITLE_ERROR);
	}

	@Test(priority = 2, alwaysRun = true, description = "validating title of manageUsers")
	public void verifyTitleOfManageUsers() {

		lp = new LoginPage(driver);
		db = new Dashboard(driver);
		lp.presteps();

		String expectedName_ManageUsers = Constant.EXPECTED_TITLE_OF_MANAGEUSERS;
		String actualName_ManageUsers = db.manageUseresNameVerification();
		Assert.assertEquals(actualName_ManageUsers, expectedName_ManageUsers, Constant.MANAGEUSERS_TITLE_ERROR);

	}

	@Test(priority = 3, alwaysRun = true, description = "validating Home text background color")

	public void home_Background_Clr_Style_Verification() {
		lp = new LoginPage(driver);
		db = new Dashboard(driver);
		lp.presteps();

		String expected_Home_Bg_Clr = Constant.HOME_BACKGROUND_CLR_PPTY;
		String actual_Home_Bg_Clr = db.home_StyleProperty();
		Assert.assertEquals(actual_Home_Bg_Clr, expected_Home_Bg_Clr, Constant.HOME_BACKGROUND_CLR_ERROR);

	}

}
