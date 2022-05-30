package Selenium.day19;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FixedDepositCalculator {

    static WebDriver driver;

    @Test
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(); // Launch the chrome browser
        driver.manage().window().maximize(); // Maximize your browser/page

        driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");

        String path = "src/test/java/Selenium/day19/Caldata.xlsx";

        XLUtils.setExcelFile(path, "Sheet1");

        int rowcount = XLUtils.getRowCount(path, "Sheet1");

        for (int i = 1; i <= rowcount; i++) {

            int princ = Integer.parseInt(XLUtils.getCellData(path, "Sheet1", i, 0));
            int rateofinterest = Integer.parseInt(XLUtils.getCellData(path, "Sheet1", i, 1));
            int per = Integer.parseInt(XLUtils.getCellData(path, "Sheet1", i, 2));
            String fre = XLUtils.getCellData(path, "Sheet1", i, 3);
            double exp_mvalue = Double.parseDouble(XLUtils.getCellData(path, "Sheet1", i, 4));

            driver.findElement(By.id("principal")).sendKeys(String.valueOf(princ));
            driver.findElement(By.id("interest")).sendKeys(String.valueOf(rateofinterest));
            driver.findElement(By.id("tenure")).sendKeys(String.valueOf(per));

            Select perioddrp = new Select(driver.findElement(By.id("tenurePeriod")));
            perioddrp.selectByVisibleText("year(s)");

            Select frequency = new Select(driver.findElement(By.id("frequency")));
            frequency.selectByVisibleText(fre);

            driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[1]/img")).click();

            String act_mvalue = driver.findElement(By.xpath("//*[@id='resp_matval']/strong")).getText();

            if (exp_mvalue == Double.parseDouble(act_mvalue)) {
                System.out.println("test passed");
            } else {
                System.out.println("test failed");
            }

            driver.findElement(By.xpath("//*[@id='fdMatVal']/div[2]/a[2]/img")).click(); // clear button

            Thread.sleep(3000);

        }

        driver.quit();

    }

}