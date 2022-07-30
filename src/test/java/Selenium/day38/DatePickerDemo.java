package Selenium.day38;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class DatePickerDemo {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.expedia.ca/");

        driver.findElement(By.xpath("//button[@id='d1-btn']")).click();

        String month = "September 2022";
        String exp_date = "10";

        while (true) {
            String text = driver.findElement(By.cssSelector("div.uitk-date-picker-month:nth-child(1) > h2.uitk-date-picker-month-name.uitk-type-medium")).getText();
            if (text.equals(month)) {
                break;
            } else {
                driver.findElement(By.cssSelector(".uitk-date-picker-menu-pagination-container.uitk-layout-flex.uitk-layout-flex-justify-content-space-between > button:nth-of-type(2)")).click();
            }
        }

        List<WebElement> allDates = driver.findElements(By.xpath("//form[1]/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/div[1]/table[1]/tbody[1]/tr/td/button[1]"));

        for (WebElement ele : allDates) {
            String date_text = ele.getAttribute("data-day");
            if (date_text.equals(exp_date)) {
                ele.click();
                break;
            }
        }

    }

}