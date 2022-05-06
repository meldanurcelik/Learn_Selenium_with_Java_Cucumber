package Selenium.day18;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class FileUploadOrange {

    static WebDriver driver;

    @Test
    public static void main(String[] args) throws InterruptedException, FindFailed {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("https://opensource-demo.orangehrmlive.com/");

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");

        driver.findElement(By.id("txtPassword")).sendKeys("admin123");

        driver.findElement(By.id("btnLogin")).click();

        WebElement PIM = driver.findElement(By.xpath("//*[@id=\'menu_pim_viewPimModule\']/b"));
        WebElement Employeelist = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        WebElement addEployee = driver.findElement(By.xpath("//*[@id=\'menu_pim_addEmployee\']"));

        Actions act = new Actions(driver);
        act.moveToElement(PIM).moveToElement(Employeelist).moveToElement(addEployee).click().build().perform();

        WebElement photofile = driver.findElement(By.id("photofile"));
        act.click(photofile).build().perform();//Double click


        String imagesFilepath = "C:\\Users\\melda\\Documents\\IdeaProjects\\learn-selenium-with-java-cucumber\\src\\test\\java\\Selenium\\day18\\OrangeScreens\\";
        String inputFilepath = imagesFilepath + "inputfile\\";

        Screen s = new Screen();

        Pattern fileInputTextBox = new Pattern(imagesFilepath + "FileTextBox.png");
        Pattern openButton = new Pattern(imagesFilepath + "OpenButton.png");

        s.wait(fileInputTextBox, 20);
        s.type(fileInputTextBox, inputFilepath + "Apple.jpg");
        s.click(openButton);

        Thread.sleep(3000);

        driver.quit();

    }

}