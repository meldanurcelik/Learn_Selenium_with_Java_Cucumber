package Selenium.day14;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CountingLinks {

    WebDriver driver;

    @Test
    public void main() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); //Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("https://testautomationpractice.blogspot.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        System.out.println(links.size());

        //reading all the links from web page and display

        for (WebElement e : links) {
            System.out.println(e.getText());
        }

        driver.quit();

    }
}