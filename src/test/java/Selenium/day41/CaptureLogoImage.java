package Selenium.day41;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class CaptureLogoImage {

    static WebDriver driver;

    public static void main(String args[]) throws IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        WebElement logoImageElement = driver.findElement(By.xpath("//*[@id='divLogo']/img"));

        Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImageElement);
        ImageIO.write(logoImageScreenshot.getImage(), "png", new File("E:\\learn-selenium-cucumber-with-java\\Screenshots\\OrangeHRMlogo.png"));

        File f = new File("E:\\learn-selenium-cucumber-with-java\\Screenshots\\OrangeHRMlogo.png");

        if (f.exists()) {
            System.out.println("Image File Captured");
        } else {
            System.out.println("Image File NOT exist");
        }

        driver.close();

    }

}