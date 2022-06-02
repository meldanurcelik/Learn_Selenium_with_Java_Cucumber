package Selenium.day23.reporting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class LoginTest {

    static WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize(); // Maximize your browser/page
    }

    @Test
    public void loginTest() {

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce2");
        driver.findElement(By.name("login-button")).click();

        int isExists = driver.findElements(By.cssSelector(".error-message-container.error")).size();

        Assert.assertEquals(isExists, 1);
    }

    @AfterClass
    public void closeBrowser() {
        driver.quit();
    }

    @AfterMethod
    public void captureScreen(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            TakesScreenshot ts = (TakesScreenshot) driver;

            File source = ts.getScreenshotAs(OutputType.FILE); // capture the screenshot file
            File target = new File(System.getProperty("user.dir") + "/Screenshots/" + result.getName() + ".png");
            FileUtils.copyFile(source, target);
            System.out.println("Screenshot captured");
        }
    }

}