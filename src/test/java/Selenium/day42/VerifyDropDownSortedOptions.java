package Selenium.day42;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;

public class VerifyDropDownSortedOptions {

    static WebDriver driver;

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://testautomationpractice.blogspot.com/");

        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//h2[contains(text(),'Select menu')]")));

        WebElement element = driver.findElement(By.id("animals"));

        Select se = new Select(element);

        ArrayList originalList = new ArrayList();
        ArrayList tempList = new ArrayList();

        for (WebElement e : se.getOptions()) {
            originalList.add(e.getText());
            tempList.add(e.getText());
        }

        System.out.println("This is originalList before Sorting" + originalList);
        System.out.println("This is tempList before Sorting" + tempList + "\n");

        Collections.sort(tempList);

        System.out.println("This is originalList after Sorting" + originalList);
        System.out.println("This is tempList after Sorting" + tempList + "\n");

        if (originalList == tempList) {
            System.out.println("Dropdown not sorted");
        } else {
            System.out.println("Dropdown sorted");
        }

        driver.close();

    }

}