package Selenium.day20;

import Selenium.day19.XLUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class LoginTest {

    static WebDriver driver;

    @Test
    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("https://www.saucedemo.com/");

        String path = "src/test/java/Selenium/day20/Login1.xlsx";

        int rows = XLUtils.getRowCount(path, "Sheet1");

        for (int i = 1; i < rows; i++) {
            String username = XLUtils.getCellData(path, "Sheet1", i, 0);
            String password = XLUtils.getCellData(path, "Sheet1", i, 1);

            driver.findElement(By.id("user-name")).sendKeys(username);
            driver.findElement(By.id("password")).sendKeys(password);
            driver.findElement(By.id("login-button")).click();

            int isExists = driver.findElements(By.cssSelector(".title")).size();

            if (isExists != 0) {
                System.out.println("Test Passed");
                XLUtils.setCellData(path, "Sheet1", i, 2, "Passed");

                driver.findElement(By.id("react-burger-menu-btn")).click();
                Thread.sleep(1000);
                driver.findElement(By.id("logout_sidebar_link")).click();

            } else {
                System.out.println("Test Failed");
                XLUtils.setCellData(path, "Sheet1", i, 2, "Failed");

                driver.navigate().refresh();
            }

        }

        driver.close();

    }

}