package Selenium.day11;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1) Open Web Browser(Chrome/IE/firefox).
2) Open URL  https://opensource-demo.orangehrmlive.com/
3) Enter username  (Admin).
4) Enter password  (admin123).   
5) Click on Login.
6) Capture title of the home page.
7) Verify title of the page: OrangeHRM 
8) Close browser
*/

public class LoginTest_OrangeHRM {

    WebDriver driver;

    @Test
    public void main() {

        //1) Open Web Browser
        //Chrome browser
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); //Launch the chrome browser

        driver.manage().window().maximize(); //  Maximize your browser/page

        //2) Open URL  https://opensource-demo.orangehrmlive.com/
        driver.get("https://opensource-demo.orangehrmlive.com/");

        //3) Enter username  (Admin).
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");

        //4) Enter password  (admin123).
        driver.findElement(By.name("txtPassword")).sendKeys("admin123");

        //5) Click on Login.
        driver.findElement(By.name("Submit")).click();

        //6) Capture title of the home page.
        String act_title = driver.getTitle(); // capture the title of current page
        String exp_title = "OrangeHRM";

        //7) Verify title of the page: OrangeHRM
        if (act_title.equals(exp_title)) {
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }

        //8) Close browser
        driver.close();  //driver.quit();

    }
}