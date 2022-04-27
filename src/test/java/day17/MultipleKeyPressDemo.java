package day17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MultipleKeyPressDemo {

    static WebDriver driver;

    @Test
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("https://github.com/");

        Thread.sleep(3000);

        Actions act = new Actions(driver);

        act.keyDown(Keys.CONTROL).sendKeys("a").build().perform();

        Thread.sleep(3000);

        driver.quit();

    }

}