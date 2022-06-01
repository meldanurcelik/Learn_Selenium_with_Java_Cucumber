package Selenium.day20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;

public class LoginTestHashMap {

    static WebDriver driver;

    static HashMap<String, String> loginData() {
        HashMap<String, String> hm = new HashMap<String, String>();

        hm.put("x", "standard_user@secret_sauce");
        hm.put("y", "problem_user@secret_sauce");
        hm.put("z", "performance_glitch_user@secret_sauce");

        return hm;
    }

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("https://www.saucedemo.com/");

        String credentials = loginData().get("x");

        String uarr[] = credentials.split("@"); // splitting

        driver.findElement(By.name("user-name")).sendKeys(uarr[0]);
        driver.findElement(By.name("password")).sendKeys(uarr[1]);
        driver.findElement(By.name("login-button")).click();

        int isExists = driver.findElements(By.cssSelector(".title")).size();

        if (isExists != 0) {
            System.out.println("Test Passed");

        } else {
            System.out.println("Test Failed");

            driver.close();
        }

        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("logout_sidebar_link")).click();

        driver.close();

    }

}