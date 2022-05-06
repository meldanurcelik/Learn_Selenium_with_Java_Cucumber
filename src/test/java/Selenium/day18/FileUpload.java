package Selenium.day18;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

    static WebDriver driver;

    @Test
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("http://demo.automationtesting.in/Register.html");

        String imagesFilepath = "C:\\Users\\melda\\Documents\\IdeaProjects\\learn-selenium-with-java-cucumber\\src\\test\\java\\Selenium\\day18\\Fruites\\";

        WebElement uploadElement = driver.findElement(By.xpath("//input[@id='imagesrc']"));
        uploadElement.sendKeys(imagesFilepath + "Apple.jpg");

        Thread.sleep(3000);

        driver.quit();

    }

}