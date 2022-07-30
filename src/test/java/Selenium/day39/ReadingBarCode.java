package Selenium.day39;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ReadingBarCode {

    static WebDriver driver;

    public static void main(String[] args) throws IOException, NotFoundException, com.google.zxing.NotFoundException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h2[contains(text(),'Bar Codes')]")));

        //String barCodeURL = driver.findElement(By.xpath("//*[@id='HTML12']/div[1]/img[1]")).getAttribute("src");
        String barCodeURL = driver.findElement(By.xpath("//*[@id='HTML12']/div[1]/img[2]")).getAttribute("src");

        System.out.println(barCodeURL);

        URL url = new URL(barCodeURL);

        BufferedImage bufferedimage = ImageIO.read(url);

        LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedimage);
        BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));

        Result result = new MultiFormatReader().decode(binaryBitmap);

        System.out.println(result.getText());

        driver.close();
    }

}