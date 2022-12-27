package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class AdminUsersPage {
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();

	public AdminUsersPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = ("//div[@class='os-scrollbar os-scrollbar-vertical os-scrollbar-auto-hidden']"))
	WebElement scrollbar;

	@FindBy(xpath = ("//p[text()='Admin Users']"))
	WebElement manageUsers;

	@FindBy(xpath = ("//input[@id='username']"))
	WebElement username;

	@FindBy(xpath = ("//input[@id='password']"))
	WebElement password;

	@FindBy(xpath = ("//select[@id='user_type']"))
	WebElement userType;

	@FindBy(xpath = ("//button[@name='Create']"))
	WebElement save;

	@FindBy(xpath = ("//a[@class='btn btn-rounded btn-danger']"))
	WebElement newBtn;

	@FindBy(xpath = ("//a[@class='btn btn-rounded btn-primary']"))
	WebElement searchBtn;

	@FindBy(xpath = ("//div[@class='card-footer center']//a[@type='button'][text()='Reset']"))
	WebElement resetBtn;

	@FindBy(xpath = ("(//i[@class='fas fa-edit'])[2]"))
	WebElement edituser_1;

	@FindBy(xpath = ("//button[@name='Update']"))
	WebElement update_Edit;

	@FindBy(xpath = ("//div[@class='card-footer center']//a[@type='button'][text()='Reset']"))
	WebElement reset_Edit;
	
	@FindBy(xpath = ("//div[@class='alert alert-success alert-dismissible']"))
	WebElement newUserSaveAlert;
	
	@FindBy(xpath = ("//div[@class='alert alert-danger alert-dismissible']"))
	WebElement alreadyExistUserAlert;
	
	//--------------------------Action-----------------------------------
	
	public String addNewUser() throws InterruptedException {
		gu.scrollToTheElement(manageUsers, driver);
		gu.mediumDelay(2000);
		gu.clickToTheElement(manageUsers, driver);
		gu.clickToTheElement(newBtn, driver);
		gu.randomUserNames(username);// random username access from fakerclass
		gu.sendText(password, "admi");
		gu.selectFuncbyViText(userType, "Admin");
		gu.clickToTheElement(save, driver);
		return gu.getElementText(newUserSaveAlert);
		
	}
	
	//-------------------------------------------------------------------
	
	public String addAlreadyExistUser() throws InterruptedException {
		gu.scrollToTheElement(manageUsers, driver);
		gu.mediumDelay(2000);
		gu.clickToTheElement(manageUsers, driver);
		gu.clickToTheElement(newBtn, driver);
		gu.sendText(username,"admin");
		gu.sendText(password, "admin");
		gu.selectFuncbyViText(userType, "Admin");
		gu.clickToTheElement(save, driver);
		return gu.getElementText(alreadyExistUserAlert);
		
	}

}
