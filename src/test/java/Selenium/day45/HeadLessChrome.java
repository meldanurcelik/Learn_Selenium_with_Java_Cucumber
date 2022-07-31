package Selenium.day45;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadLessChrome {

    public static void main(String args[]) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        // set chrome as Headless
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        //options.addArguments("--headless");

        WebDriver driver = new ChromeDriver(options);   //Instantiate Chrome Driver

        driver.get("http://demo.nopcommerce.com/");

        System.out.println("Title of the page : " + driver.getTitle());
        System.out.println("URL of the page : " + driver.getCurrentUrl());

    }

}
