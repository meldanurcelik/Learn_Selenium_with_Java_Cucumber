package Selenium.day35;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class JavascriptExecutorDemo {
    static WebDriver driver;

    public static void main(String[] args) throws IOException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("https://www.twoplugs.com/");

        // Flash
        // ---------------------
        WebElement joinfree = driver.findElement(By.xpath("//header/div[1]/ul[1]/li[2]/a[1]"));
        // JavaScriptUtil.flash(joinfree,driver);

        // Drawing border & take screenshot
        // ------------------
        JavaScriptUtil.drawBorder(joinfree, driver);

        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("E:\\IdeaProjects\\learn-selenium-cucumber-with-java\\Screenshots\\twoplugs.png"));

        // Getting title of the page
        // ---------------------------
        String title = JavaScriptUtil.getTitleByJS(driver);
        System.out.println(title);

        // Clicking on element
        // --------------------------
        // WebElement loginBtn = driver.findElement(By.xpath("/html/body/div/header/div/ul/li[1]/a/span"));
        // JavaScriptUtil.clickElementByJS(loginBtn, driver);

        // Generate alert
        // --------------
        //JavaScriptUtil.generateAlert(driver, "Clicked on Login Button");

        // Refreshing page
        // ----------------
        JavaScriptUtil.refreshBrowserByJS(driver);

        // Get page inner text
        // -------------
        System.out.println(JavaScriptUtil.getPageInnerText(driver));

        // Scrolling down page
        JavaScriptUtil.scrollPageDown(driver);

        // Scroll we find element on page
        // WebElement image = driver.findElement(By.id("rslides3_s0"));
        // JavaScriptUtil.scrollIntoView(image, driver);

    }

}