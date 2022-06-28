package Selenium.day25;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class LogintestOnWindowsusingChrome {

    static WebDriver driver;

    @Test(priority = 1)
    void setup() throws MalformedURLException {
        String nodeURL = "http://192.168.1.107:4444/wd/hub"; // The URL will be
        // IP Address of Hub Machine + Hub Port + /wd/hub
        // "http://192.168.1.107:4444/wd/hub"
        // Here Hub and Node are same machines

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WIN10);

        driver = new RemoteWebDriver(new URL(nodeURL), cap);
    }

    @Test(priority = 2)
    void login() {
        driver.get("http://practice.automationtesting.in/my-account/");
        driver.findElement(By.id("username")).sendKeys("pavanoltraining");
        driver.findElement(By.id("password")).sendKeys("Test@selenium123");
        driver.findElement(By.cssSelector("input[name='login']")).click();

        String captext = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div/p[1]")).getText();

        if (captext.contains("pavanoltraining")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        driver.close();

    }

}