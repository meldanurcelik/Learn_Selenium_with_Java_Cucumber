package Selenium.day16;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class WebTable3_Pagination {

    static WebDriver driver;

    @Test
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Login
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();

        Thread.sleep(3000);

        // Admin-->User Management-->Users
        driver.findElement(By.xpath("//*[@id=\"menu_admin_viewAdminModule\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"menu_admin_UserManagement\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"menu_admin_viewSystemUsers\"]")).click();

        // thead
        int cols = driver.findElements(By.xpath("//*[@id='resultTable']/thead/tr/th")).size();

        String th2 = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/thead/tr/th[2]")).getText();
        String th3 = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/thead/tr/th[3]")).getText();
        String th4 = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/thead/tr/th[4]")).getText();
        String th5 = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/thead/tr/th[5]")).getText();

        System.out.println(th2 + " - " + th3 + " - " + th4 + " - " + th5);
        System.out.println("-------------------------------------------");

        // paging
        int pages = driver.findElements(By.xpath("//*[@id='frmList_ohrmListComponent']//ul[@class='paging top']//li")).size();

        for (int p = 4; p <= (pages - 2); p++) {

            WebElement link = driver.findElement(By.xpath("//*[@id='frmList_ohrmListComponent']//ul[@class='paging top']//li[" + p + "]//a"));
            link.click();

            // tbody
            int rows = driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr")).size();

            for (int r = 1; r <= rows; r++) {
                String col2 = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[" + r + "]/td[2]")).getText();
                String col3 = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[" + r + "]/td[3]")).getText();
                String col4 = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[" + r + "]/td[4]")).getText();
                String col5 = driver.findElement(By.xpath("//*[@id=\"resultTable\"]/tbody/tr[" + r + "]/td[5]")).getText();

                System.out.println(col2 + "  -  " + col3 + "  -  " + col4 + "  -  " + col5);
            }
        }

        driver.quit();

    }

}