package day13;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class VolunteerSignup {

	WebDriver driver;

	@Test
	public void main() throws InterruptedException {

		//Open Web Browser
		//Chrome browser
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(); //Launch the chrome browser
		driver.manage().window().maximize(); // Maximize your browser/page

		//Open URL
		driver.get("https://goo.gl/RVdKM9");

		String title = driver.getTitle(); // returns the title of the page
		System.out.println("Title of the page is : " + title);

		String url = driver.getCurrentUrl(); // returns the URL of the page
		System.out.println("URL of the page is :" + url);

		//System.out.println(driver.getPageSource()); // returns HTML code for page

		//First Name
		driver.findElement(By.id("RESULT_TextField-1")).sendKeys("Melda");

		//Last Name
		driver.findElement(By.id("RESULT_TextField-2")).sendKeys("Celik");

		//Phone
		driver.findElement(By.id("RESULT_TextField-3")).sendKeys("5555555555");

		//Country
		driver.findElement(By.id("RESULT_TextField-4")).sendKeys("Turkey");

		//City
		driver.findElement(By.id("RESULT_TextField-5")).sendKeys("Samsun");

		//Email Address
		driver.findElement(By.id("RESULT_TextField-6")).sendKeys("melda_celik@hotmail.com");

		//Handling radio buttons - Gender
		//----------------------------
		WebElement radmale = driver.findElement(By.cssSelector("#q26 tr:nth-child(1) label"));

		radmale.click(); // select radio button

		//Handling check boxes
		//-----------------
		driver.findElement(By.cssSelector("#q15 tr:nth-child(1) label")).click();//Sunday
		driver.findElement(By.cssSelector("#q15 tr:nth-child(7) label")).click(); //Saturday

		//Handling Drop down
		//---------------------------
		Select dropdown = new Select(driver.findElement(By.id("RESULT_RadioButton-9")));

		// 1)Find how many options present in drop down
		System.out.println("No of Options present in drop down:" + dropdown.getOptions().size());

		// 2) Extract all the options and print them
		List<WebElement> options = dropdown.getOptions();

		for (WebElement e : options) {
			System.out.println(e.getText());
		}

		// 3) Select option from the dropdown
		dropdown.selectByValue("Radio-1"); //Afternoon

		//Handle Links
		//---------------------------
		driver.findElement(By.linkText("Software Testing Tutorials")).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.navigate().back(); // go back to your previous page
		Thread.sleep(3000);

		driver.findElement(By.partialLinkText("Tools Training")).click();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		driver.navigate().back(); // go back to your previous page
		Thread.sleep(3000);

		/*driver.navigate().forward();//move forward to your page
		Thread.sleep(3000);
		System.out.println(driver.getTitle());*/

		driver.navigate().refresh(); //refresh the page

		//Submit form
		driver.findElement(By.id("FSsubmit")).click();

		driver.quit();
	}
}