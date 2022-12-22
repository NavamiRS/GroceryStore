package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageDeliveryBoy {

	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	public  ManageDeliveryBoy(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this );	
		
	}
	
	@FindBy(xpath =("//a[contains(@class,'nav-link')]//p[contains(text(),'Manage Delivery Boy')]"))
	WebElement manage_Delivery_Boy;
	
	@FindBy(xpath = ("//table[@class='table table-bordered table-hover table-sm']/tbody/tr[1]/td[7]/div/a"))
	WebElement tooltip_Password;
	
	@FindBy(xpath = ("//a[@class='btn btn-rounded btn-danger']"))
	WebElement new_Btn_Style_Ppty;
	
	@FindBy(xpath = ("//a[contains(text(),' Search')]"))
	WebElement search_Btn;
	
	public String toolTipValiadation() throws InterruptedException {
		gu.clickOnElement(manage_Delivery_Boy);
		gu.mediumDelay(3000);
		return gu.toolTip(tooltip_Password);
		
	}
	
	public String New_Btn_Style_Ppty() throws InterruptedException {
		
		gu.clickOnElement(manage_Delivery_Boy);
		gu.mediumDelay(3000);
		String new_Style_Ppty=gu.stylePropertyValidation(new_Btn_Style_Ppty,"border-color");
		return new_Style_Ppty;
	}
	
	public boolean click_Serch_Btn() throws InterruptedException {
		gu.clickOnElement(manage_Delivery_Boy);
		gu.mediumDelay(3000);
		gu.clickOnElement(search_Btn);
		boolean actual_Result_Search_Click=gu.elementIsEnabled(search_Btn);
		return actual_Result_Search_Click;
		
	}
}
