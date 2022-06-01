package Selenium.day21.parameterization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {
    WebDriver driver;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test(dataProvider = "users")
        // dataProvider a parameter of @Test annotaion
    void logintest(String uname, String pwd) {

        driver.get("https://www.saucedemo.com/");

        driver.findElement(By.name("user-name")).sendKeys(uname);
        driver.findElement(By.name("password")).sendKeys(pwd);
        driver.findElement(By.name("login-button")).click();

        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @DataProvider(name = "users")
        // @DataProvider is annotation
    String[][] loginData() {
        String data[][] = {{"standard_user", "secret_sauce"}, {"locked_out_user", "secret_sauce"}, {"problem_user", "secret_sauce"}};
        return data;
    }

    @AfterClass
    void closeBrowser() {
        driver.close();
    }

}