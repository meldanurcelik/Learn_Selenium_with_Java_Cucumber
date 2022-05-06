package Selenium.day17;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {

    static WebDriver driver;

    @Test
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        WebElement source_element = driver.findElement(By.id("box6")); //Italy - source element

        WebElement target_element = driver.findElement(By.id("box106"));//Rome -target element

        Actions act = new Actions(driver);

        act.dragAndDrop(source_element, target_element).build().perform(); //Drag and drop

        Thread.sleep(2000);

        driver.quit();

    }

}