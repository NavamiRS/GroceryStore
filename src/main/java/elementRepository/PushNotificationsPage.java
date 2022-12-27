package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class PushNotificationsPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public PushNotificationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ("//input[@id='title']"))
	WebElement title_Tb;

	@FindBy(xpath = ("//input[@id='description']"))
	WebElement description_Tb;

	@FindBy(xpath = ("//h1[text()='Push Notifications']"))
	WebElement title_Of_Pn;

	@FindBy(xpath = ("//div[@class='alert alert-success alert-dismissible']"))
	WebElement alert_Msg;

	@FindBy(xpath = ("//button[normalize-space()='Send']"))
	WebElement send_Btn;

	@FindBy(xpath = ("//span[@class='error'][normalize-space()='*']"))
	WebElement mandatory_Sign;

	@FindBy(xpath = ("//p[text()='Push Notifications']"))
	WebElement push_Notification;

	public void enterTile(String title) {
		gu.sendText(title_Tb, title);
	}

	public void enterDescription(String description) {
		gu.sendText(description_Tb, description);
	}

	public void clickOnPushNotification() {
		gu.clickOnElement(push_Notification);
	}

	public String getTitleOfPn() {
		gu.clickOnElement(push_Notification);
		String actual_PnPage_Text = gu.getElementText(title_Of_Pn);
		return actual_PnPage_Text;
	}

	public String getAlertMsg() {
		gu.clickOnElement(send_Btn);
		String actual_AlertMsg = gu.getElementText(alert_Msg);
		return actual_AlertMsg;
	}

	public String bgClrAlert() {
		String actual_bg_Clr = gu.stylePropertyValidation(alert_Msg, "background");
		return actual_bg_Clr;
	}

	public String get_Snd_Clr() {
		String actual_clr = gu.stylePropertyValidation(send_Btn, "color");
		return actual_clr;
	}

	public String get_Mandatory_Sign_Clr() {
		String actual_Clr = gu.stylePropertyValidation(mandatory_Sign, "color");
		return actual_Clr;
	}
}
