package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class MobileSliderPage {

	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();

	public MobileSliderPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = ("//p[text()='Mobile Slider']"))
	WebElement mobileSlider;

	@FindBy(xpath = ("//tbody/tr[1]/td[1]/img[1]"))
	WebElement first_Image;

	@FindBy(xpath = ("//tbody[1]/tr[1]/td[2]/a[1]/span[1]"))
	WebElement Status_First_Img;

	public String getTitleMsp() throws InterruptedException {
		gu.clickOnElement(mobileSlider);
		gu.mediumDelay(3000);
		String actual_Text_Msp = gu.getElementText(mobileSlider);
		return actual_Text_Msp;

	}

	public boolean firstImgIsDisplayed() throws InterruptedException {
		gu.clickOnElement(mobileSlider);
		gu.mediumDelay(3000);
		boolean actual_Result_FirstImg = gu.elementIsDisplayed(first_Image);
		return actual_Result_FirstImg;
	}

	public String firstImageStatus() throws InterruptedException {

		gu.clickOnElement(mobileSlider);
		gu.mediumDelay(3000);
		String actual_Status_FirstImg = gu.getElementText(Status_First_Img);
		return actual_Status_FirstImg;

	}

}
