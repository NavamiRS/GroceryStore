package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.MobileSliderPage;

public class MobileSliderTestCases extends BaseClass {
	LoginPage lp;
	MobileSliderPage msp;

	@Test(priority = 1, alwaysRun = true, description = "title verification")
	public void verifyTheTitleOfMsp() throws InterruptedException {
		lp = new LoginPage(driver);
		msp = new MobileSliderPage(driver);
		lp.presteps();
		String expected_Title_Msp = Constant.EXPECTED_TITLE_OF_MOBILESLIDER;
		String actual_Title_Of_Msp = msp.getTitleMsp();

		Assert.assertEquals(actual_Title_Of_Msp, expected_Title_Msp, Constant.MOBILESLIDER_TITLE_ERROR);

	}

	@Test(priority = 2, alwaysRun = true, description = "first image dispalyed or not")
	public void verifyTheFirstImgIsDisplayed() throws InterruptedException {
		lp = new LoginPage(driver);
		msp = new MobileSliderPage(driver);
		lp.presteps();

		boolean actual_Result_Of_FirstImage = msp.firstImgIsDisplayed();
		Assert.assertTrue(actual_Result_Of_FirstImage);

	}

	@Test(priority = 3, alwaysRun = true, description = "image status")
	public void verifyTheFirstImgStatus() throws InterruptedException {
		lp = new LoginPage(driver);
		msp = new MobileSliderPage(driver);
		lp.presteps();
		String expected_Status_Of_FirstImage = Constant.FIRST_IMAGE_STATUS;
		String actual_Status_Of_FirstImage = msp.firstImageStatus();

		Assert.assertEquals(actual_Status_Of_FirstImage, expected_Status_Of_FirstImage,
				Constant.FIRST_IMAGE_STATUS_ERROR);

	}
}
