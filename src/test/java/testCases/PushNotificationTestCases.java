package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constant;
import elementRepository.LoginPage;
import elementRepository.PushNotificationsPage;

public class PushNotificationTestCases extends BaseClass {
	LoginPage lp;
	PushNotificationsPage pnp;

	@Test(priority = 1, description = "Title validation for PushNotification page", groups = {
	"RegressionTest" })
	public void verifyTheTitleOfPnPage() {
		lp = new LoginPage(driver);
		pnp = new PushNotificationsPage(driver);
		lp.presteps();
		String actual_Title_PnPage = pnp.getTitleOfPn();
		String expected_Title_PnPage = Constant.PUSHNOTIFICATION_EXPECTEDTITLE;

		Assert.assertEquals(actual_Title_PnPage, expected_Title_PnPage, Constant.TITLE_ERROR);
	}

	@Test(priority = 2, description = "get text of aleert message")
	public void verifyTheAlertMsgText() {
		lp = new LoginPage(driver);
		pnp = new PushNotificationsPage(driver);
		lp.presteps();
		pnp.clickOnPushNotification();
		pnp.enterTile("hello");
		pnp.enterDescription("hai hello");
		pnp.getAlertMsg();
		String actual_AlertMsg = pnp.getAlertMsg();
		String expected_AlertMsg = Constant.ALERTMESSAGEPUSHNOTIFICATION;

		Assert.assertEquals(actual_AlertMsg, expected_AlertMsg, Constant.ALERTMESSAGEERROR);

	}

	@Test(priority = 3, description = "get bg clr of aleert message")
	public void verifyTheAlertTextBgColor() {
		lp = new LoginPage(driver);
		pnp = new PushNotificationsPage(driver);
		lp.presteps();
		pnp.clickOnPushNotification();
		pnp.enterTile("hello");
		pnp.enterDescription("hai hello");
		pnp.getAlertMsg();
		String actual_Bg_Clr = pnp.bgClrAlert();
		String expected_Bg_Clr = Constant.ALERTMESSAGE_BG_CLR;

		Assert.assertEquals(actual_Bg_Clr, expected_Bg_Clr, Constant.ALERTMESSAGE_BG_CLR_ERROR);

	}

	@Test(priority = 4, description = "get clr of send button")
	public void verifyTheSendBtnColor() {
		lp = new LoginPage(driver);
		pnp = new PushNotificationsPage(driver);
		lp.presteps();
		pnp.clickOnPushNotification();
		String actual_Clr = pnp.get_Snd_Clr();
		String expected_Clr = Constant.EXPECTEDSEND_BTN_COLOR;

		Assert.assertEquals(actual_Clr, expected_Clr, Constant.EXPECTEDSEND_BTN_CLR_ERROR);

	}

	@Test(priority = 5, description = "get clr of send button")
	public void verifyTheMandatorySignClr() {
		lp = new LoginPage(driver);
		pnp = new PushNotificationsPage(driver);
		lp.presteps();
		pnp.clickOnPushNotification();
		String actual_Color = pnp.get_Mandatory_Sign_Clr();
		String expected_Color = Constant.EXPECTED_MANDATORYSIGN_CLR;

		Assert.assertEquals(actual_Color, expected_Color, Constant.EXPECTED_MANDATORYSIGN_CLR_ERROR);

	}
}
