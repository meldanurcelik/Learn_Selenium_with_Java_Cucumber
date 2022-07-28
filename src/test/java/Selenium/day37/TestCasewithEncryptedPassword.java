package Selenium.day37;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCasewithEncryptedPassword {

    static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("http://demo.nopcommerce.com/login");

        driver.findElement(By.linkText("Log in")).click();

        driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("melda_celik@hotmail.com");

        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(decodeString("dGVzdDEyMw=="));

        driver.findElement(By.xpath("//button[contains(text(),'Log in')]")).click();

        driver.findElement(By.cssSelector(".bar-notification.success .content")).isDisplayed();

        driver.close();
    }

    static String decodeString(String password) {
        byte[] decodedString = Base64.decodeBase64(password);
        return (new String(decodedString));
    }

}