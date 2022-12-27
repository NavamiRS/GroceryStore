package elementRepository;

import java.util.List;

import org.apache.poi.ss.formula.functions.Count;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageLocationPage {

	WebDriver driver;

	GeneralUtilities gu = new GeneralUtilities();

	public ManageLocationPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ("//p[text()='Manage Location']"))
	WebElement manageLocation;

	@FindBy(xpath = ("//table[@class='table table-bordered table-hover table-sm']//tr//td[5]"))
	WebElement status_List;

	@FindBy(xpath = ("(//i[@class='fas fa-edit'])[2]"))
	WebElement action_Edit;

	@FindBy(xpath = ("//select[@id='st_id']"))
	WebElement state_EditLocation;

	@FindBy(xpath = ("//button[text()='Update']"))
	WebElement update_EditLocation;

	// -----------------Actions----------------------

	public int activeStatusCount() throws InterruptedException {
		int count = 0;
		gu.clickToTheElement(manageLocation, driver);
		gu.mediumDelay(2000);
		List<WebElement> status_Active = driver
				.findElements(By.xpath("//table[@class='table table-bordered table-hover table-sm']//tr//td[5]"));

		int size = status_Active.size();

		for (int i = 0; i < size; i++) {
			String statusActiveList = status_Active.get(i).getText();
			// System.out.println(paymentModeList);
			if (statusActiveList.equals("Active")) {
				count++;
			}
		}

		// System.out.println(size);
		int actual_active_Status_Count = count;
		System.out.println("Active Status count=" + actual_active_Status_Count);

		/*
		 * int actual_count_Inactivee=size-actual_active_Status_Count;
		 * System.out.println(actual_count_Inactivee);
		 */
		return actual_active_Status_Count;

	}

	public String editState() throws InterruptedException {
		gu.clickToTheElement(manageLocation, driver);
		gu.clickToTheElement(action_Edit, driver);
		gu.clickToTheElement(state_EditLocation, driver);
		gu.mediumDelay(2000);
		gu.selectFuncbyViText(state_EditLocation, "Belfast");
		return gu.FirstSelectedOption(state_EditLocation);
	}

}
