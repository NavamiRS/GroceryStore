package elementRepository;

import java.util.FormatFlagsConversionMismatchException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;
import utilities.Syncronisation;

public class ManageOrderPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	Syncronisation sn=new Syncronisation();
	String actualPaymentModeText;

	public ManageOrderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ("//p[text()='Manage Orders']"))
	WebElement manage_Order;

	@FindBy(xpath = ("//a[normalize-space()='Search']"))
	WebElement search;

	@FindBy(xpath = ("//a[normalize-space()='Reset']"))
	WebElement reset;

	@FindBy(xpath = ("//input[@id='od']"))
	WebElement order_Id;

	@FindBy(xpath = ("//input[@id='um']"))
	WebElement user_Id;

	@FindBy(xpath = ("//select[@id='pt']"))
	WebElement payment_Mode;

	@FindBy(xpath = ("//select[@id='st']"))
	WebElement status;

	
	@FindBy(xpath = ("//button[normalize-space()='Search']")) WebElement
	  search_ListOrder;
	 
	@FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[7]/button[1]")
	WebElement SearchListOrders_Ex;
	
	

	@FindBy(xpath = ("//button[normalize-space()='Reset']"))
	WebElement reset_ListOrder;

	@FindBy(xpath = ("//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]"))
	WebElement orderId_TrTd_1;

	@FindBy(xpath = ("//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]"))
	WebElement paymentModeTd_5;
	
	@FindBy(xpath = "//a[contains(text(),'Change Delivery Date')]")
	WebElement changeDeliveryDateOfSearchedOrder;
	
	@FindBy(xpath = "(//button[@class='btn btn-info'])[2]")
	WebElement updateButton;
	
	@FindBy(xpath = "//input[@class='jquery-datepicker__input datepicker1']")
	WebElement deliveryDate;
	
	@FindBy(xpath = "//input[@id='basicExample']")
	WebElement fromTime;
	
	@FindBy(xpath = "//input[@id='basicExample1']")
	WebElement toTime;
	
	@FindBy(xpath = "//body/div[1]/div[1]/section[1]/div[2]/div[1]/div[1]")
	WebElement deliveryDateAlert;
	

	// ---------------------------------ACTIONS-------------------------------------------

	public boolean searchPaymentModeListDetails() throws InterruptedException {

		gu.clickToTheElement(manage_Order, driver);
		gu.clickToTheElement(search, driver);
		gu.clickOnElement(payment_Mode);
		gu.mediumDelay(2000);
		gu.selectFuncbyindex(payment_Mode, 2);
		gu.clickToTheElement(search_ListOrder, driver);

		List<WebElement> paymentMode_Lists = driver.findElements(
				By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]"));
		int size = paymentMode_Lists.size();

		for (int i = 0; i < size; i++) {
			String paymentModeList = paymentMode_Lists.get(i).getText();
			// System.out.println(paymentModeList);
			if (paymentModeList.equals("Bank")) {

				return true;

			}

		}
		return false;

	}

	public void orderIdAndPaymentModeVeri() {
		gu.clickToTheElement(manage_Order, driver);
		gu.clickToTheElement(search, driver);
		gu.sendText(order_Id, "325");
		sn.clickElement(driver,"//body/div[1]/div[1]/section[1]/div[3]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[7]/button[1]");
		gu.clickOnElement(SearchListOrders_Ex);
	}

	public String orderIdVerification() {

		return gu.getElementText(orderId_TrTd_1);

	}

	public String PaymentModeVerification() {

		return gu.getElementText(paymentModeTd_5);

	}

	public int statusDropDown() {
		gu.clickToTheElement(manage_Order, driver);
		gu.clickToTheElement(search, driver);
		Select select = new Select(status);
		List<WebElement> statusList = select.getOptions();
		int size = statusList.size();
		return size;
	}
	

	public void clickOnChangeDeliveryDateOfSearchedOrder() throws InterruptedException {
		gu.mediumDelay(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", changeDeliveryDateOfSearchedOrder);
		sn.elementIsToBeClickable(driver, "//a[contains(text(),'Change Delivery Date')]");
		js.executeScript("arguments[0].click();", changeDeliveryDateOfSearchedOrder);
		
		
	}
	public void sendDeliveryDate(String date) {
		gu.sendText(deliveryDate, date);
	}
	public void sendFromTime(String fTime) {
		fromTime.clear();
		gu.sendText(fromTime, fTime);
	}
	public void sendToTime(String TTime) {
		toTime.clear();
		gu.sendText(toTime, TTime);
	}
	public void clickOnUpdateButton() throws InterruptedException {
		gu.mediumDelay(3000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", updateButton);
		js.executeScript("arguments[0].click();", updateButton);
	}
	public String getTextAlertOfChangeDeliveryDate() {
		return gu.getElementText(deliveryDateAlert);
	}
	
	public void changeDeliveryDate() throws InterruptedException {
		
		orderIdAndPaymentModeVeri();
		clickOnChangeDeliveryDateOfSearchedOrder();
		sendDeliveryDate("22052022");
		sendFromTime("11.00am");
		sendToTime("11:30am");
		clickOnUpdateButton();
		
	}
	
	
	
}
