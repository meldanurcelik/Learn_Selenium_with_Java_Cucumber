package day17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TooltipDemo {

    static WebDriver driver;

    @Test
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("https://jqueryui.com/tooltip/");

        driver.switchTo().frame(0);

        WebElement agebox = driver.findElement(By.id("age"));

        String tooltiptext = agebox.getAttribute("title");

        System.out.println(tooltiptext);

        if (tooltiptext.equals("We ask for your age only for statistical purposes.")) {
            System.out.println("Tooltip test passed");
        } else {
            System.out.println("Tooltip test failed");
        }

        driver.quit();

    }

}