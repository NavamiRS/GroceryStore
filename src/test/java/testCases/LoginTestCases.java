package testCases;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import constants.Constant;
import elementRepository.LoginPage;
import net.bytebuddy.agent.builder.AgentBuilder.DescriptionStrategy;

public class LoginTestCases extends BaseClass {
	LoginPage lp;
	List<String> loginList;

	@Test(priority = 1, alwaysRun = true, description = "login with valid credentials (credentials access from constant class)")
	public void verifyLoggedUsers() {
		lp = new LoginPage(driver);
		lp.presteps();

		String expectedProfileName = Constant.EXPECTEDPROFILENAME;// access from Constant class
		String actualProfileName = lp.profileVerification();
		Assert.assertEquals(actualProfileName, expectedProfileName, Constant.LOGINERROR);// access from Constant class

	}

	@Test(priority = 2, alwaysRun = true, description = "Profile name color validation")
	public void profileNameStyleValidation() {
		lp = new LoginPage(driver);
		lp.presteps();

		String profileColor = lp.styleProperty();
		String expectedProfileClr = Constant.ADMIN_CLR_PPTY;
		Assert.assertEquals(profileColor, expectedProfileClr, Constant.STYLE_ERROR);// access from Constant class

	}

	@Test(priority = 3, description = "login using dataprovider", dataProvider = "data", alwaysRun = true)
	public void verifyLoggedUsersDataProvider(String username, String password) {
		lp = new LoginPage(driver);
		// lp.presteps();
		lp.getUserName(username);
		lp.getPassWord(password);
		lp.clickSignin();

		String expectedProfileName = Constant.EXPECTEDPROFILENAME;// access from Constant class
		String actualProfileName = lp.profileVerification();
		Assert.assertEquals(actualProfileName, expectedProfileName, Constant.LOGINERROR);// access from Constant class

	}

	@DataProvider(name = "data")
	public Object[][] getUserData() {
		return new Object[][] { { "admin", "admin" }, { "admin2", "admin4" }, { "admin54", "admin" },
				{ "admin", "admin2" }, };
	}

	@Test(priority = 4, description = "validate remenberme checkbox is slected or not", alwaysRun = true)
	public void remenberMeCheckBoxValidation() {
		lp = new LoginPage(driver);
		lp.getUserName("admin");
		lp.getPassWord("admin");

		boolean actual_Status = lp.rememberMeCheckbox();
		boolean expected_Status = false;
		Assert.assertEquals(actual_Status, expected_Status, Constant.CHECKBOX_ERROR);

	}

	@Test(priority = 5, description = "login credentials access from excel", alwaysRun = true)
	public void excelRead() {
		lp = new LoginPage(driver);
		loginList = lp.getLoginDetails();
		System.out.println(loginList);
		lp.excelSteps(loginList.get(0), loginList.get(1));
	}
}
