package Selenium.day24.PageObjectModel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginTest {

    WebDriver driver;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page
        driver.get("https://opensource-demo.orangehrmlive.com/");
    }

    @Test
    void login() {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName("Admin");
        lp.setPassword("admin123");
        lp.clickSubmit();
    }

}