package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.ManageLocationPage;

public class ManageLocationPageTestCases extends BaseClass {
	LoginPage lp;
	ManageLocationPage mlp;

	@Test(priority = 1, description = "take active status count")
	public void verifyTheActiveStatusCount() throws InterruptedException {
		lp = new LoginPage(driver);
		mlp = new ManageLocationPage(driver);
		lp.presteps();
		int actual_Active_Status = mlp.activeStatusCount();
		int expected_Active_Status =17;

		Assert.assertEquals(actual_Active_Status, expected_Active_Status,Constant.ACTIVESTATUSCOUNTERROR);

	}

	@Test(priority = 2, description = "valiadte first selected element from the state dropdown while editing the state")

	public void verifyTheFirstSelectedElementWhileEditingTheState() throws InterruptedException {
		lp = new LoginPage(driver);
		mlp = new ManageLocationPage(driver);
		lp.presteps();
		String actual_First_Selected_Option = mlp.editState();
		String expected_First_Selected_Option = Constant.MANAGE_LOCATION_EDIT_STATE_FIRST_SELECTED_OPTION;

		Assert.assertEquals(actual_First_Selected_Option, expected_First_Selected_Option,
				Constant.MANAGE_LOCATION_EDIT_STATE_FIRST_SELECTED_OPTION_ERROR);
	}
}
