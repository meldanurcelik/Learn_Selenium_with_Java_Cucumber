package Selenium.day44;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaleElementReferenceException extends Throwable {

    static WebDriver driver;

    public static void main(String args[]) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://www.pavantestingtools.com/");

        driver.manage().window().maximize();

        WebElement link = driver.findElement(By.cssSelector("ul#menu-primary-items > li:nth-of-type(5) > a"));

        link.click();

        driver.navigate().back();

        Thread.sleep(2000);

        driver.navigate().refresh();

        try {
            link.click();
        } catch (Exception e) {
            link = driver.findElement(By.cssSelector("ul#menu-primary-items > li:nth-of-type(5) > a"));
            link.click();
        }

        driver.close();

    }

}