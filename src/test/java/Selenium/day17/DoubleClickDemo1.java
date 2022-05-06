package Selenium.day17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickDemo1 {

    static WebDriver driver;

    @Test
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("https://testautomationpractice.blogspot.com/");

        Thread.sleep(3000);

        WebElement button = driver.findElement(By.xpath("//*[@id=\"HTML10\"]/div[1]/button"));

        Actions act = new Actions(driver);

        act.doubleClick(button).build().perform();//Double click

        driver.quit();

    }

}