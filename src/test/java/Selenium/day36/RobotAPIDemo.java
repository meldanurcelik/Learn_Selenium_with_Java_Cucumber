package Selenium.day36;

import Selenium.day35.JavaScriptUtil;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class RobotAPIDemo {

    static WebDriver driver;

    public static void main(String[] args) throws AWTException, InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("https://spreadsheetpage.com/calendar/yearly/"); // sample url

        WebElement download = driver.findElement(By.xpath("//a[contains(text(),'Download this template for free')]"));
        JavaScriptUtil.scrollIntoView(download, driver);
        download.click();

        Robot robot = new Robot();  // Robot class throws AWT Exception
        Thread.sleep(3000); // Thread.sleep throws InterruptedException

        robot.keyPress(KeyEvent.VK_DOWN);  // press arrow down key of keyboard to navigate and select Save radio button
        Thread.sleep(2000);  // sleep has only been used to showcase each event separately

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);

        robot.keyPress(KeyEvent.VK_TAB);
        Thread.sleep(2000);

        robot.keyPress(KeyEvent.VK_ENTER);

        // press enter key of keyboard to perform above selected action

    }

}