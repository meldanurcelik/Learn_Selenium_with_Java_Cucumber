package Selenium.day20;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SimpleInterestCalculator {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("https://www.easycalculation.com/simple-interest.php");

        driver.manage().window().maximize();

        String path = "src/test/java/Selenium/day20/SIdata.xlsx";

        XLUtils.setExcelFile(path, "Shee1");

        int rowcount = XLUtils.getRowCount(path, "Sheet1"); // NUMBER OF ROWS PRESENT IN A EXCEL SHEET

        for (int i = 1; i <= rowcount; i++) {
            int princ = Integer.parseInt(XLUtils.getCellData(path, "Sheet1", i, 0));
            int rateofinterest = Integer.parseInt(XLUtils.getCellData(path, "Sheet1", i, 1)); // type casting
            int time = Integer.parseInt(XLUtils.getCellData(path, "Sheet1", i, 2)); // type casting
            Double exp_si = Double.parseDouble(XLUtils.getCellData(path, "Sheet1", i, 3));
            Double finalamt = Double.parseDouble(XLUtils.getCellData(path, "Sheet1", i, 4));

            driver.findElement(By.name("res1")).sendKeys(String.valueOf(princ));
            driver.findElement(By.name("res2")).sendKeys(String.valueOf(rateofinterest));
            driver.findElement(By.name("res3")).sendKeys(String.valueOf(time));

            Select timedrp = new Select(driver.findElement(By.name("time")));
            timedrp.selectByVisibleText("Years");

            Thread.sleep(3000);

            String act_si = driver.findElement(By.name("res4")).getAttribute("value"); // Capture Simple Interest value

            if (exp_si == Double.parseDouble(act_si) && finalamt == (princ + Double.parseDouble(act_si))) {
                System.out.println("Test Passed");
                XLUtils.setCellData(path, "Sheet1", i, 5, "Passed");

            } else {
                System.out.println("Test Failed");
                XLUtils.setCellData(path, "Sheet1", i, 5, "Failed");
            }

            driver.findElement(By.xpath("//*[@id='dispCalcConts']/input[2]")).click(); // reset button

            Thread.sleep(3000);

        }

        driver.close();
    }

}