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

	@Test(priority = 1,  description = "login with valid credentials (credentials access from constant class)")
	public void verifyLoginProfile() {
		lp = new LoginPage(driver);
		lp.presteps();

		String expectedProfileName = Constant.EXPECTEDPROFILENAME;// access from Constant class
		String actualProfileName = lp.profileVerification();
		Assert.assertEquals(actualProfileName, expectedProfileName, Constant.LOGINERROR);// access from Constant class

	}

	@Test(priority = 2,  description = "Profile name color validation")
	public void profileNameStyleValidation() {
		lp = new LoginPage(driver);
		lp.presteps();

		String profileColor = lp.styleProperty();
		String expectedProfileClr = Constant.ADMIN_CLR_PPTY;
		Assert.assertEquals(profileColor, expectedProfileClr, Constant.STYLE_ERROR);// access from Constant class

	}

	@Test(priority = 3, description = "login using dataprovider", dataProvider = "data")
	public void verifyLoginProfile(String username, String password) {
		lp = new LoginPage(driver);
		// lp.presteps();
		lp.getUserName(username);
		lp.getPassWord(password);
		lp.clickSignin();

		boolean actualResult=lp.alertMsg();
		Assert.assertTrue(actualResult,Constant.LOGINERRORS );

	}

	@DataProvider(name = "data")
	public Object[][] getUserData() {
		return new Object[][] {{ "admin2", "admin4" }, { "admin54", "admin" },
				{ "admin", "admin2" }, };
	}

	@Test(priority = 4, description = "validate remenberme checkbox is slected or not")
	public void remenberMeCheckBoxValidation() {
		lp = new LoginPage(driver);
		lp.getUserName("admin");
		lp.getPassWord("admin");

		boolean actual_Status = lp.rememberMeCheckbox();
		boolean expected_Status = false;
		Assert.assertEquals(actual_Status, expected_Status, Constant.CHECKBOX_ERROR);

	}

	@Test(priority = 5, description = "login credentials access from excel")
	public void excelRead() {
		lp = new LoginPage(driver);
		loginList = lp.getLoginDetails();
		System.out.println(loginList);
		lp.excelSteps(loginList.get(0), loginList.get(1));
		String expectedProfileName = Constant.EXPECTEDPROFILENAME;
		String actualProfileName = lp.profileVerification();
		Assert.assertEquals(actualProfileName, expectedProfileName, Constant.LOGINERROR);

	}
}
