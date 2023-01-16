package utilities;



import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.github.javafaker.Faker;

public class GeneralUtilities 
{
	WebDriver driver;
	JavascriptExecutor js;
	static Faker faker;
	public String getElementText(WebElement element) 
	{
		String text=element.getText();
		return text;
	}
	public void clickOnElement(WebElement element) {
		element.click();

	}
	public void sendText(WebElement element,String text) {
		element.sendKeys(text);
	}
	public String stylePropertyValidation(WebElement element,String propertyType) {

		return element.getCssValue(propertyType);

	}

	public String toolTip(WebElement element) {
		return element.getAttribute("title");

	}

	public void mediumDelay(int x) throws InterruptedException {
		Thread.sleep(x);
	}

	public boolean elementIsDisplayed(WebElement element) {
		return element.isDisplayed();

	}

	public boolean elementIsEnabled(WebElement element) {
		return element.isEnabled();

	}

	public boolean elementIsSelected(WebElement element) {
		return element.isSelected();
	}

	public void dropdownSelect_By_Visibletxt(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void scrollToTheElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",element);
	}

	public void clickToTheElement(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();",element);
	}
	public void dragandDrop(WebElement source, WebElement destination, WebDriver driver) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, destination).perform();
	}
	public void alertHandlingaccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public String alertGetText(WebDriver driver) {
		return (driver.switchTo().alert().getText());
	}
	public void alertDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public void selectFuncbyindex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	public void selectFuncbyValue(WebElement element, String value) {
		Select select1 = new Select(element);
		select1.selectByValue(value);

	}
	public void selectFuncbyViText(WebElement element, String visisbletext) {
		Select select1 = new Select(element);
		select1.selectByVisibleText(visisbletext);

	}
	public String FirstSelectedOption(WebElement element) {
		Select select1 = new Select(element);
		String firstoption = select1.getFirstSelectedOption().getText();
		return (firstoption);
	}
	public void randomUserNames(WebElement element) {
		faker=new Faker();
		String userName=faker.name().username();
		element.sendKeys(userName);
	}


	public String getcurrentUrl(WebDriver driver)
	{
		return driver.getCurrentUrl();
	}

	public void clearElement(WebElement element)
	{
		element.clear();
	}

	public void sendTextToAlert(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}

	public void deselectFuncbyindex(WebElement element, int index) {
		Select select = new Select(element);
		select.deselectByIndex(index);
	}
	public void deselectFuncbyValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue(value);
	}
	public void deselectFuncbyViText(WebElement element, String visisbletext) {
		Select select = new Select(element);
		select.deselectByVisibleText(visisbletext);
	}
	public void getOptions(WebElement element) 
	{
		Select select1 = new Select(element);
		List<WebElement> list=select1.getOptions();

	}
	public void submit(WebElement element) {
		element.submit();
	}

	public void clearInputField(WebElement element) {
		element.clear();
	}

	public String gettingTagName(WebElement element) {
		return element.getTagName();
	}

	public Dimension getSizeOfElement(WebElement element) {
		return element.getSize();
	}

	public Point getLocationOfElement(WebElement element) {
		return element.getLocation();
	}
	public String getTitleOfPage(WebDriver driver) {
		return driver.getTitle();
	}

	public String gettingCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String gettingPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void navigateToThePage(WebDriver driver, String url) {
		driver.navigate().to(url);
	}

	public void navigateBack(WebDriver driver) {
		driver.navigate().back();
	}

	public void navigateForward(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void keyUpAction(WebDriver driver, CharSequence keyName) {
		Actions a = new Actions(driver);
		a.keyUp(keyName).build().perform();
	}

	public void keyDownAction(WebDriver driver, CharSequence keyName) {
		Actions a = new Actions(driver);
		a.keyDown(keyName).build().perform();
	}
	public void clickAndHoldAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.clickAndHold(element).build().perform();
	}

	public void contextClickAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).build().perform();
	}

	public void doubleClickAction(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).build().perform();
	}

	public void moveToTheElement(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	public void dragandDropElement(WebElement source, WebElement destination, WebDriver driver) {
		Actions a = new Actions(driver);
		a.dragAndDrop(source, destination).perform();
	}

	public void sendKeysUsingAction(WebDriver driver, WebElement element, CharSequence keyName) {
		Actions a = new Actions(driver);
		a.sendKeys(element, keyName);
	}
	public Boolean isDropdownMultiSelect(WebElement element) {
		Select select = new Select(element);
		return select.isMultiple();
	}

	public void deselectAllOptions(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	public void switchToIFrameByIndex(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToIFrameByIdOrName(WebDriver driver, String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	public void switchToIFrameByElementName(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public void switchToParentFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	public void switchToMainPage(WebDriver driver) {
		driver.switchTo().defaultContent();
	}




}
