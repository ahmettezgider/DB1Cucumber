package fileProcess;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class _02ExcelRead1 {

    @Test
    public void readExcel_xls() throws IOException {

        // okunacak excel dosyasinin yolu ve adi
        String excelFile = "c:/proje/Excel1.xls";

        // excel dosyasi FileInputStrean ile okunur
        FileInputStream inputStream = new FileInputStream(excelFile);

        // excel icin bir workbook create ediliyor
        Workbook workbook = WorkbookFactory.create(inputStream);

        // workbokk daki sayfa secilir
        Sheet sheet1 = workbook.getSheet("Sayfa");

        // row'u (satir) belirlenir, secilir
        Row row = sheet1.getRow(0);

        // cell (hücre) belirlenir, secilir
        Cell cell = row.getCell(0);

        System.out.println(cell.toString());

        inputStream.close();

    }


    @Test
    public void readExcel_xlsx() throws IOException {

        // okunacak excel dosyasinin yolu ve adi
        String excelFile = "src/test/java/fileProcess/Users.xlsx";

        // excel dosyasi FileInputStrean ile okunur
        FileInputStream inputStream = new FileInputStream(excelFile);

        // excel icin bir workbook create ediliyor
        Workbook workbook = WorkbookFactory.create(inputStream);

        // workbokk daki sayfa secilir
        Sheet sheet1 = workbook.getSheetAt(0);

        // row'u (satir) belirlenir, secilir
        Row row = sheet1.getRow(0);

        // cell (hücre) belirlenir, secilir
        Cell cell = row.getCell(0);

        System.out.println(cell.toString());

        inputStream.close();

    }
}
