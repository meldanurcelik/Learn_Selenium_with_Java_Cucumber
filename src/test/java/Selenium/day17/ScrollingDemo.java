package Selenium.day17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingDemo {

    static WebDriver driver;

    @Test
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");

        Thread.sleep(3000);

        //Create JavascriptExecor variable
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Approach1 - number of pixels
        //js.executeScript("window.scrollBy(0,2000)", "");

        //Approach2 - till we found certain element on the web page
        //WebElement flag=driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/table[2]/tbody/tr[88]/td[1]/img"));
        //js.executeScript("arguments[0].scrollIntoView();",flag);

        //Appraoch3 - till end of the page
        js.executeScript("window.scrollBy(0,document.body.scrollHeight)");

        Thread.sleep(2000);

        driver.quit();

    }

}