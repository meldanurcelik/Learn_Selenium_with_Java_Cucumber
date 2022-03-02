package day15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Wikipedia {

	WebDriver driver;

	@Test
	public void main() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Launch the chrome browser
		driver.manage().window().maximize(); // Maximize your browser/page

		driver.get("https://testautomationpractice.blogspot.com/");

		driver.findElement(By.id("Wikipedia1_wikipedia-search-input")).sendKeys("Selenium");

		driver.findElement(By.className("wikipedia-search-button")).click();

		Thread.sleep(3000);

		List<WebElement> search_results = driver.findElements(By.xpath("//*[@id='wikipedia-search-result-link']/a"));

		System.out.println(search_results.size());

		for (WebElement e : search_results) {
			String link = e.getText();
			driver.findElement(By.linkText(link)).click();
		}

		driver.quit();

	}
}