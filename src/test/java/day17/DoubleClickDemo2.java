package day17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DoubleClickDemo2 {

    static WebDriver driver;

    @Test
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("http://api.jquery.com/dblclick/");

        driver.switchTo().frame(0); //switch to frame

        WebElement ele = driver.findElement(By.xpath("/html/body/div"));

        Thread.sleep(3000);

        Actions act = new Actions(driver);

        act.doubleClick(ele).build().perform(); // Double click on element

        Thread.sleep(2000);

        act.doubleClick(ele).build().perform(); // Double click on element

        Thread.sleep(2000);

        act.doubleClick(ele).build().perform(); // Double click on element

        driver.quit();

    }

}