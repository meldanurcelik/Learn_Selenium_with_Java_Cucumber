package Selenium.day43;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopups {

    static WebDriver driver;

    public static void main(String args[]) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        //driver.get("http://the-internet.herokuapp.com/basic_auth"); //Popup

        // Syntax: http://username:password@test.com
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");

        String text = driver.findElement(By.cssSelector("p")).getText();
        System.out.println(text);

        driver.close();

    }

}