package Selenium.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WaitsDemo {

	WebDriver driver;

	@Test
	public void main() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Launch the chrome browser
		driver.manage().window().maximize(); // Maximize your browser/page

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // implicit wait

		driver.get("https://testautomationpractice.blogspot.com/");

		driver.findElement(By.id("field2")).sendKeys("test");

		driver.quit();

	}
}