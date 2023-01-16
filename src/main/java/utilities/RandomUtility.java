package utilities;

import org.openqa.selenium.WebElement;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

public class RandomUtility {
	static Faker faker;
	public void randomUserNames(WebElement element) {
		faker=new Faker();
		String userName=faker.name().username();
		element.sendKeys(userName);
	}
	public void randomNames(WebElement element) {
		faker=new Faker();
		String name=faker.name().name();
		element.sendKeys(name);
	}
	public void randomFullNames(WebElement element) {
		faker=new Faker();
		String fullName=faker.name().fullName();
		element.sendKeys(fullName);
	}
	public void randomLastNames(WebElement element) {
		faker=new Faker();
		String lastName=faker.name().lastName();
		element.sendKeys(lastName);
	}
	public void randomMidNames(WebElement element) {
		faker=new Faker();
		String midName=faker.name().nameWithMiddle();
		element.sendKeys(midName);
	}
	public void randomTitle(WebElement element) {
		faker=new Faker();
		String title=faker.name().title();
		element.sendKeys(title);
	}
	public void randomBloodGroup(WebElement element) {
		faker=new Faker();
		String bloodGroup=faker.name().bloodGroup();
		element.sendKeys(bloodGroup);
	}
	
}
