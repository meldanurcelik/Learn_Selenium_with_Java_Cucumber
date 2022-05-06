package Selenium.day17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

    static WebDriver driver;

    @Test
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("http://the-internet.herokuapp.com/key_presses");

        Actions act = new Actions(driver);

        act.sendKeys(Keys.ENTER).build().perform();

        Thread.sleep(3000);

        act.sendKeys(Keys.ESCAPE).build().perform();

        Thread.sleep(3000);

        act.sendKeys(Keys.SPACE).build().perform();

        Thread.sleep(3000);

        act.sendKeys(Keys.DELETE).build().perform();

        Thread.sleep(2000);

        driver.quit();

    }

}