package day16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable1 {

    static WebDriver driver;

    @Test
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("C:\\Users\\melda\\Documents\\IdeaProjects\\learn-selenium-with-java-cucumber\\src\\test\\java\\day16\\WebTable.html");

        int rows = driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();
        System.out.println(rows);

        int columns = driver.findElements(By.xpath("/html/body/table/tbody/tr[1]/th")).size();
        System.out.println(columns);

        System.out.println("BookName" + "    " + "Product" + "    " + "Article" + "    " + "Price");

        for (int r = 2; r <= rows; r++) {
            for (int c = 1; c <= columns; c++) {
                String value = driver.findElement(By.xpath("/html/body/table/tbody/tr[" + r + "]/td[" + c + "]")).getText();
                System.out.print(value + "    ");
            }
            System.out.println();
        }

    }
}