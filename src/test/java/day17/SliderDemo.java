package day17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

    static WebDriver driver;

    @Test
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("https://jqueryui.com/slider/");

        driver.switchTo().frame(0);

        WebElement slider = driver.findElement(By.xpath("//*[@id=\"slider\"]/span"));

        Actions act = new Actions(driver);

        act.moveToElement(slider).dragAndDropBy(slider, 400, 0).build().perform(); //moving the slider

        Thread.sleep(2000);

        driver.quit();

    }

}