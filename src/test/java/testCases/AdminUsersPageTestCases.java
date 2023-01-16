package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.AdminUsersPage;
import elementRepository.LoginPage;

public class AdminUsersPageTestCases extends BaseClass {

	LoginPage lp;
	AdminUsersPage aup;

	@Test(priority = 1, description = "Add a new user details to adminusers page and verify it")
	public void verifyAddNewAUserToAdminUsersPageWorkingProperly() throws InterruptedException {
		lp = new LoginPage(driver);
		aup = new AdminUsersPage(driver);
		lp.presteps();
		String actual_Save_Result = aup.addNewUser();
		String expected_Save_Result = Constant.MANAGEUSER_ADDNEWUSERALERT;

		Assert.assertEquals(actual_Save_Result, expected_Save_Result, Constant.MANAGEUSER_ADDNEWUSERALERTERROR);
	}

	@Test(priority = 2,  description = "Add a already exist user details to admin users page and verify it")
	public void verifyAddAlreadyExistsUserDetails() throws InterruptedException {
		lp = new LoginPage(driver);
		aup = new AdminUsersPage(driver);
		lp.presteps();
		String actual_Save_Result = aup.addAlreadyExistUser();
		String expected_Save_Result = Constant.MANAGEUSER_ADDALREADYEXISTSUSERALERT;

		Assert.assertEquals(actual_Save_Result, expected_Save_Result,
				Constant.MANAGEUSER_ADDALREADYEXISTSUSERALERTERROR);

	}
	
	
	 @Test(priority = 3,description = "search a username",retryAnalyzer = retryTest.RetryAnalyser.class)
	 public void verifyTheSearchBtnWorking() throws InterruptedException { lp =
	 new LoginPage(driver); aup = new AdminUsersPage(driver); lp.presteps();
	 String actual_Search_Result = aup.searchUserName();
	 String expected_Search_Result=Constant.ADMINUSERNAME;
	 
	 Assert.assertEquals(actual_Search_Result, expected_Search_Result, Constant.ADMINUSERNAME_ERROR);
	 
	  
	  
	  }
	 
}
