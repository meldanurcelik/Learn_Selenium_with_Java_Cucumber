package Selenium.day15;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedIframe {

    WebDriver driver;

    @Test
    public void main() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); //Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("http://demo.automationtesting.in/Frames.html");

        driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a")).click();//button

        WebElement outerframe = driver.findElement(By.xpath("//*[@id=\"Multiple\"]/iframe"));
        driver.switchTo().frame(outerframe);//swicth to outer frame

        WebElement innerframe = driver.findElement(By.xpath("/html/body/section/div/div/iframe"));
        driver.switchTo().frame(innerframe);

        driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Testing");
    }
}