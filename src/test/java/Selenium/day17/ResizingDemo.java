package Selenium.day17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ResizingDemo {

    static WebDriver driver;

    @Test
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("https://jqueryui.com/resizable/");

        driver.switchTo().frame(0); //switch to frame

        WebElement element = driver.findElement(By.xpath("//*[@id=\"resizable\"]/div[3]"));

        Actions act = new Actions(driver);

        act.moveToElement(element).dragAndDropBy(element, 200, 150).build().perform(); //resizing

        Thread.sleep(2000);

        driver.quit();

    }

}