package Selenium.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsDemo {

	WebDriver driver;

	@Test
	public void main() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Launch the chrome browser
		driver.manage().window().maximize(); // Maximize your browser/page

		driver.get("https://testautomationpractice.blogspot.com/");

		driver.findElement(By.xpath("//*[@id=\"HTML9\"]/div[1]/button")).click(); //ClickMe button

		Thread.sleep(1000);

		driver.switchTo().alert().accept();//closes popup by using OK button
		//driver.switchTo().alert().dismiss();//closes popup by using Cancel button

		String exp_title = "You pressed OK!";
		WebElement demoTitle = driver.findElement(By.id("demo"));
		String act_title = demoTitle.getText();

		if (act_title.equals(exp_title)) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}
		
		driver.quit();

	}

}