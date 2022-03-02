package day15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class HandleWindows {

	WebDriver driver;

	@Test
	public void main() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Launch the chrome browser
		driver.manage().window().maximize(); // Maximize your browser/page

		driver.get("http://demo.automationtesting.in/Windows.html");

		driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();

		Set<String> handlevalues = driver.getWindowHandles();

		for (String h : handlevalues) {
			//System.out.println(h);
			String title = driver.switchTo().window(h).getTitle();
			//System.out.println(title);

			if (title.equals("Sakinalium | Home")) {
				driver.findElement(By.xpath("//*[@id=\"container\"]/header/div/div/div[2]/ul/li[4]/a")).click(); //contact menu
			}
		}

	}
}