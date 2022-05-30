package Selenium.day19;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WritingExcel {

    public static void main(String[] args) throws IOException {

        FileOutputStream file = new FileOutputStream("src/test/java/Selenium/day19/Data2.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet = workbook.createSheet("Data2");

        for (int i = 0; i <= 5; i++) {
            XSSFRow row = sheet.createRow(i);

            for (int j = 0; j < 3; j++) {
                row.createCell(j).setCellValue("hello world!");
            }
        }

        workbook.write(file);

        System.out.println("Writing excel is completed");

    }

}
