package Selenium.day21.parameterization;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {

    static WebDriver driver;

    @Parameters("browser")
    @Test(priority = 1)
    public void launchbrowser(String br) {

        if (br.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        } else if (br.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();

        } else if (br.equals("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();

        }

        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 2)
    public void verifyTitle() {
        Assert.assertEquals(driver.getTitle(), "Swag Labs");
    }

    @Test(priority = 3)
    public void registration() {
        Assert.assertTrue(true);
        //write code for registration process
    }

    @Test(priority = 4)
    public void closeBrowser() {
        driver.close();
    }

}