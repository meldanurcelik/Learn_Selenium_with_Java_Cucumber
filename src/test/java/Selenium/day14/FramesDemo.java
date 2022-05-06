package Selenium.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesDemo {

	WebDriver driver;

	@Test
	public void main() {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Launch the chrome browser
		driver.manage().window().maximize(); // Maximize your browser/page

		driver.get("https://seleniumhq.github.io/selenium/docs/api/java/index.html");

		driver.findElement(By.cssSelector("ul.navList:nth-child(1) li:nth-child(1) > a:nth-child(1)")).click();

		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.linkText("org.openqa.selenium")).click(); //1 frame

		driver.switchTo().defaultContent(); // go back to page/focus on the page

		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("WebDriver")).click(); //2 frame

		driver.switchTo().defaultContent(); // go back to page/focus on the page

		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("/html/body/header/nav/div[1]/div[1]/ul[1]/li[6]")).click(); // 3rd frame

		driver.quit();

	}
}