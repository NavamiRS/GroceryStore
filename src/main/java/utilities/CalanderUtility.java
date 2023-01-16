package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CalanderUtility {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\harit\\git\\SeleniumRepository\\selenium_basics\\src\\main\\resources\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		driver.manage().window().maximize();
		WebElement date=driver.findElement(By.xpath("//input[@id='datepicker']"));
		date.click();
		//date.sendKeys("10/23/2021");
		Thread.sleep(2000);
		
		WebElement month=driver.findElement(By.cssSelector("span.ui-datepicker-month"));
		System.out.println(month.getText());
		
//		while(!month.getText().contains("October")) {
//			WebElement previous=driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']"));
//			previous.click();
//			
//		}
//		Thread.sleep(2000);
		
		while(!driver.findElement(By.cssSelector("span.ui-datepicker-month")).getText().contains("October"))
		{
		//driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
		}
		
		int count=driver.findElements(By.className("ui-state-default")).size();
		System.out.println(count);
		
		for(int i=0;i<count;i++) {
			String text=driver.findElements(By.className("ui-state-default")).get(i).getText();
			if(text.equalsIgnoreCase("23")) {
				driver.findElements(By.className("ui-state-default")).get(i).click();
			}
		}
		Thread.sleep(2000);

	}

}
