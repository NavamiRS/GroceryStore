package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;


public class Dashboard {
	
	WebDriver driver;
	GeneralUtilities gu=new GeneralUtilities();
	public Dashboard(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this );	
		
	}
	
	@FindBy(xpath = "(//p[contains(text(),'Manage Expense')])[1]")
	WebElement manage_Expense;
	
	@FindBy(xpath = "(//p[text()='Manage Users'] )[1]")
	WebElement manage_User;
	
	@FindBy(xpath="//a[text()='Home']")
	WebElement home;
	
	public String manageExpenseNameVerification() {
		String actualName_ManageExpense=gu.getElementText(manage_Expense);
		return actualName_ManageExpense;
	}
	
	public String manageUseresNameVerification() {
		String actualName_ManageUsers=gu.getElementText(manage_User);
		return actualName_ManageUsers;
	}

	public String home_StyleProperty() {
		
		String home_Background_Clr=gu.stylePropertyValidation(home, "background-color");
		return home_Background_Clr;
	}
	
	
}
