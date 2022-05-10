package Selenium.day18;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.HashMap;

public class FilesDownloadUsingChrome {

    static WebDriver driver;

    @Test
    public static void main(String[] args) throws InterruptedException {

        //download files in required location using chrome
        HashMap<String, Object> chromePrefs = new HashMap<>();

        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.prompt_for_download", "false");
        chromePrefs.put("download.default_directory", "C:\\Users\\melda\\Downloads"); //configure path

        ChromeOptions option = new ChromeOptions();
        option.setExperimentalOption("prefs", chromePrefs);

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        cap.setCapability(ChromeOptions.CAPABILITY, option);  // end of code

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(cap); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("http://demo.automationtesting.in/FileDownload.html");

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement textbox = driver.findElement(By.cssSelector("div:nth-of-type(2) > .panel-body > .form-group > label"));
        js.executeScript("arguments[0].scrollIntoView();", textbox);

        //download text file
        driver.findElement(By.id("textbox")).sendKeys("testing txt file download");
        driver.findElement(By.id("createTxt")).click();
        driver.findElement(By.id("link-to-download")).click();

        Thread.sleep(3000);

        if (isFileExist("C:\\Users\\melda\\Downloads\\info.txt")) {
            System.out.println("Txt file exists");
        } else {
            System.out.println("Txt file not exists");
        }

        WebElement pdfbox = driver.findElement(By.cssSelector("div:nth-of-type(3) > .panel-body > .form-group > label"));
        js.executeScript("arguments[0].scrollIntoView();", pdfbox);

        //download pdf file
        driver.findElement(By.id("pdfbox")).sendKeys("testing pdf downlaod");
        driver.findElement(By.id("createPdf")).click();
        driver.findElement(By.id("pdf-link-to-download")).click();

        Thread.sleep(3000);

        if (isFileExist("C:\\Users\\melda\\Downloads\\info.pdf")) {
            System.out.println("Pdf file exists");
        } else {
            System.out.println("Pdf file not exists");
        }

        driver.quit();

    }

    static boolean isFileExist(String path) {
        File f = new File(path);

        if (f.exists()) {
            return true;
        } else {
            return false;
        }
    }

}