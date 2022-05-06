package Selenium.day17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickDemo {

    static WebDriver driver;

    @Test
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");

        Actions act = new Actions(driver);

        WebElement button = driver.findElement(By.xpath("/html/body/div/section/div/div/div/p/span"));

        act.contextClick(button).build().perform(); // Right click on button

        driver.findElement(By.xpath("/html/body/ul/li[3]/span")).click();

        Thread.sleep(3000);

        Alert alert = driver.switchTo().alert();

        System.out.println("Text present on alert window is: " + alert.getText());

        alert.accept(); // this closes alert window

        driver.quit();

    }

}