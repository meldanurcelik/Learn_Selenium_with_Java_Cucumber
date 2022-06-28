package Selenium.day24.PageObjectModel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegistrationTest {

    WebDriver driver;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page
        driver.get("https://demo.guru99.com/test/newtours/");
    }

    @Test
    void userRegistration() throws InterruptedException {

        RegistrationPage RGPage = new RegistrationPage(driver);
        RGPage.clickRegLink();
        Thread.sleep(2000);
        RGPage.setFirstName("Melda");
        RGPage.setLastName("Celik");
        RGPage.setPhone("0555 555 5555");
        RGPage.setemail("melda_celik@hotmail..com");
        RGPage.setAddress1("Samsun/Merkez");
        RGPage.setCity("Samsun");
        RGPage.setState("Merkez");
        RGPage.setPostalCode("55000");
        RGPage.setCountry("TURKEY");
        RGPage.setUserName("melda");
        RGPage.setPassword("123");
        RGPage.setConfirmedPassword("123");
        RGPage.clickRegBtn();

        // Validation
        if (driver.getPageSource().contains("Thank you for registering")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }

        driver.quit();
    }

}