package Selenium.day41;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageComparison {

    static WebDriver driver;

    public static void main(String args[]) throws IOException, IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://opensource-demo.orangehrmlive.com/");

        BufferedImage expectedImage = ImageIO.read(new File("Screenshots/OrangeHRMlogo.png"));

        WebElement logoImageElement = driver.findElement(By.xpath("//*[@id='divLogo']/img"));

        Screenshot logoImageScreenshot = new AShot().takeScreenshot(driver, logoImageElement);
        BufferedImage actualImage = logoImageScreenshot.getImage();

        ImageDiffer imgDiff = new ImageDiffer();
        ImageDiff diff = imgDiff.makeDiff(actualImage, expectedImage);

        if (diff.hasDiff()) {
            System.out.println("Images are Not Same");
        } else {
            System.out.println("Images are Same");
        }

        driver.quit();
    }

}