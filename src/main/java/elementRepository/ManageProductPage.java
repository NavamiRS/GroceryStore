package elementRepository;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileHandling;
import utilities.GeneralUtilities;

public class ManageProductPage {
	WebDriver driver;
	GeneralUtilities gu = new GeneralUtilities();
	FileHandling fh = new FileHandling();

	public ManageProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = ("//p[text()='Manage Product']"))
	WebElement manage_pdt;

	@FindBy(xpath = ("//a[@class='btn btn-rounded btn-danger']"))
	WebElement new_Btn;

	@FindBy(xpath = ("//input[@id='title']"))
	WebElement title;

	@FindBy(xpath = ("//div[2]//div[1]//label[2]"))
	WebElement pdt_Type;

	@FindBy(xpath = ("//select[@id='cat_id']"))
	WebElement category;

	@FindBy(xpath = ("//select[@id='sub_id']"))
	WebElement sub_Category;

	@FindBy(xpath = ("//label[@onclick='myFunction_weight(this.value)']"))
	WebElement price_Type;

	@FindBy(xpath = ("//input[@id='m_weight']"))
	WebElement weight_Value;

	@FindBy(xpath = ("//select[@id='w_unit']"))
	WebElement weight_Unit;

	@FindBy(xpath = ("//input[@id='max_weight']"))
	WebElement max_Qnty_Can_Ord;

	@FindBy(xpath = ("//input[@id='w_price']"))
	WebElement price;

	@FindBy(xpath = ("//input[@id='w_stock']"))
	WebElement stock_Avilability;

	@FindBy(xpath = ("//input[@id='main_img']"))
	WebElement image_Upload;

	@FindBy(xpath = ("//button[normalize-space()='Save']"))
	WebElement save;
	@FindBy(xpath = ("//div[@class='alert alert-success alert-dismissible']"))
	WebElement alert_Msg;

	@FindBy(xpath = ("//body[1]/div[1]/div[1]/section[1]/div[4]/div[2]/table[1]/tbody[1]/tr[1]/td[6]/a[2]/span[1]"))
	WebElement stock_status;
	@FindBy(xpath = ("//div[@class='alert alert-success alert-dismissible']"))
	WebElement stock_Staus_Alert;

	@FindBy(xpath = ("//input[@id='main_imgs']"))
	WebElement multiple_FileUpload;
	@FindBy(xpath = ("(//input[@value='yes'])[5]"))
	WebElement stock_Radio_Btn;
	@FindBy(xpath = ("//i[@class='fas fa-trash-alt']"))
	WebElement delete;
	@FindBy(xpath = ("//div[@class='alert alert-success alert-dismissible']"))
	WebElement delete_Alert;

	@FindBy(xpath = ("//div[@id='imagePreview']"))
	WebElement image_Preview;
	// ------------Actions--------------------------

	public void click_Pdt_Mngt() {
		gu.clickOnElement(manage_pdt);
	}

	public void click_New() {
		gu.clickOnElement(new_Btn);
	}

	public void enterDataToTilte() {
		gu.sendText(title, "Coconutoil");
	}

	public void selectProductType() {
		gu.clickOnElement(pdt_Type);
	}

	public void selectCategory() throws InterruptedException {
		gu.clickOnElement(category);
		gu.mediumDelay(3000);
		gu.dropdownSelect_By_Visibletxt(category, 2);

	}

	public void selectSubCategory() throws InterruptedException {
		gu.clickOnElement(sub_Category);
		gu.mediumDelay(2000);
		gu.dropdownSelect_By_Visibletxt(sub_Category, 5);
	}

	public void selectPriceType() {
		gu.clickOnElement(price_Type);
	}

	public void enterWaitValue() throws InterruptedException {
		gu.sendText(weight_Value, "20");
	}

	public void selectWaitUnit() throws InterruptedException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", weight_Unit);
		gu.mediumDelay(2000);
		gu.dropdownSelect_By_Visibletxt(weight_Unit, 2);
	}

	public void enterMaxQuntyCanOrder() {
		gu.sendText(max_Qnty_Can_Ord, "2");
	}

	public void enterPrice() {
		gu.sendText(price, "200");
	}

	public void enterStockAvilability() {
		gu.sendText(stock_Avilability, "Limited");
	}

	public void imageUpload_SendKeys() throws InterruptedException, AWTException {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", image_Upload);

		gu.clickToTheElement(image_Upload, driver);
		gu.mediumDelay(3000);
		gu.sendText(image_Upload, "C:\\Users\\DELL\\OneDrive\\Desktop\\oilpng.png");

		/*
		 * fh.fileUpload("C:\\Users\\DELL\\OneDrive\\Desktop\\oilpng.png", image_Upload,
		 * driver); gu.mediumDelay(2000);
		 */
	}

	public void mutilpleImageUpload() throws AWTException, InterruptedException {

		fh.fileUpload("C:\\Users\\DELL\\OneDrive\\Desktop\\oilpng2.jpg", multiple_FileUpload, driver);
		gu.mediumDelay(2000);
	}

	public void javascriptexe() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", save);
		gu.mediumDelay(2000);
	}

	public void saveItem() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", save);
	}

	public String alertMsg() {
		String actualAlertMsg = gu.getElementText(alert_Msg);
		return actualAlertMsg;

	}

	public void stepToFollowToAddItems() throws InterruptedException, AWTException {
		click_Pdt_Mngt();
		click_New();
		enterDataToTilte();
		selectProductType();
		selectCategory();
		selectSubCategory();
		selectPriceType();
		javascriptexe();
		enterWaitValue();
		selectWaitUnit();
		enterMaxQuntyCanOrder();
		enterPrice();
		enterStockAvilability();
		javascriptexe();
		imageUpload_SendKeys();
		mutilpleImageUpload();
		saveItem();

	}

	public void change_Stock_Status() {
		gu.clickOnElement(stock_status);
	}

	public String get_Stock_Status_Alert() {
		String actual_alt = gu.getElementText(stock_Staus_Alert);
		return actual_alt;
	}

	public boolean imageVerification() throws InterruptedException, AWTException {
		javascriptexe();
		imageUpload_SendKeys();
		gu.mediumDelay(2000);
		/*
		 * boolean actual_Result=gu.elementIsDisplayed(image_Preview); return
		 * actual_Result;
		 */
		Boolean status = gu.elementIsDisplayed(image_Preview);
		return status;
	}

	public boolean stockRadioBtnVeri() {
		boolean actual_Sts = gu.elementIsSelected(stock_Radio_Btn);
		return actual_Sts;
	}

	public String deleteProduct() throws InterruptedException {
		gu.clickOnElement(delete);
		gu.mediumDelay(2000);
		driver.switchTo().alert().accept();
		String actual_Alert = gu.getElementText(delete_Alert);
		return actual_Alert;
	}

	public boolean imageUploadFromRemote() throws InterruptedException, AWTException {
		javascriptexe();
		String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\Images\\oilpng.png";
		gu.sendText(image_Upload, filePath);
		// fh.fileUpload(filePath, image_Upload, driver);
		gu.mediumDelay(2000);
		return gu.elementIsDisplayed(image_Preview);

	}

}
