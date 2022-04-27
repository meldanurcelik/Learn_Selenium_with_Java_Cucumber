package day17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseHover {

    static WebDriver driver;

    @Test
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Login
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        Thread.sleep(3000);

        //Admin-->User Management-->Users
        WebElement admin = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]"));
        WebElement usermgnt = driver.findElement(By.xpath("//*[@id=\"menu_admin_UserManagement\"]"));
        WebElement users = driver.findElement(By.xpath("//*[@id=\"menu_admin_viewSystemUsers\"]"));

        Actions act = new Actions(driver);

        act.moveToElement(admin).moveToElement(usermgnt).moveToElement(users).click().build().perform();

        driver.quit();

    }

}