package elementRepository;
import java.util.FormatFlagsConversionMismatchException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtilities;

public class ManageOrderPage {



	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	String actualPaymentModeText;
	public ManageOrderPage(WebDriver driver) 
	{
		this.driver=driver;
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


	@FindBy(xpath = ("//button[normalize-space()='Search']"))
	WebElement search_ListOrder;

	@FindBy(xpath = ("//button[normalize-space()='Reset']"))
	WebElement reset_ListOrder;


	@FindBy(xpath = ("//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]"))
	WebElement orderId_TrTd_1;
	
	@FindBy(xpath = ("//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]"))
	WebElement paymentModeTd_5;



	//---------------------------------ACTIONS-------------------------------------------

	public boolean searchPaymentModeListDetails() throws InterruptedException {

		gu.clickToTheElement(manage_Order, driver);
		gu.clickToTheElement(search, driver);
		gu.clickOnElement(payment_Mode);
		gu.mediumDelay(2000);
		gu.selectFuncbyindex(payment_Mode, 2);
		gu.clickToTheElement(search_ListOrder, driver);

		List<WebElement>paymentMode_Lists=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[5]"));
		int size=paymentMode_Lists.size();
		
		for(int i=0;i<size;i++) {
			String paymentModeList=paymentMode_Lists.get(i).getText();
			//System.out.println(paymentModeList);
			if (paymentModeList.equals("Bank")) { 
			return true;

			} 

		}
		return false;
		
		

	}
	
	public void orderIdAndPaymentModeVeri() {
		gu.clickToTheElement(manage_Order, driver);
		gu.clickToTheElement(search, driver);
		gu.sendText(order_Id, "367");
		gu.clickToTheElement(search_ListOrder, driver);
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
		Select select=new Select(status);
		List<WebElement>statusList=select.getOptions();
		int size=statusList.size();
		return size;
	}
}
