package Selenium.day27.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {

    public String baseURL = "http://admin-demo.nopcommerce.com/";
    public String username = "admin@yourstore.com ";

    public String password = "admin";

    static WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}