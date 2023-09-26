package fileProcess;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class _02ExcelRead1 {

    @Test
    public void readExcel_xls() throws IOException {

        // okunacak excel dosyasinin yolu ve adi
        String excelFile = "c:/proje/Excel1.xls";

        // excel dosyasi FileInputStrean ile okunur
        FileInputStream inputStream = new FileInputStream(excelFile);

        // excel icin bir workbook create ediliyor
        Workbook workbook = WorkbookFactory.create(inputStream);

        // workbook daki sayfa secilir
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

        // workbook daki sayfa secilir
        Sheet sheet1 = workbook.getSheetAt(0);

        // row'u (satir) belirlenir, secilir
        Row row = sheet1.getRow(0);

        // cell (hücre) belirlenir, secilir
        Cell cell = row.getCell(0);

        System.out.println(cell.toString());

        inputStream.close();

    }


    @Test
    public void readExcel_xlsx1() throws IOException {

        String excelFile = "src/test/java/fileProcess/Users.xlsx";

        FileInputStream inputStream = new FileInputStream(excelFile);

        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet1 = workbook.getSheetAt(0);

        int rowNum = sheet1.getPhysicalNumberOfRows();

        for (int i = 0; i < rowNum; i++) {
            Row row = sheet1.getRow(i);
            int cols = row.getPhysicalNumberOfCells();
            for (int j = 0; j < cols; j++) {
                System.out.print(row.getCell(j) + "\t");
            }
            System.out.println();
        }

        inputStream.close();

    }


    @Test
    public void testWriteToExcel() throws IOException {
        String excelFile = "src/test/java/fileProcess/Excel1.xls";
        String excelFile2 = "src/test/java/fileProcess/Excel2.xls";

        FileInputStream inputStream = new FileInputStream(excelFile);

        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet1 = workbook.getSheetAt(0);

        int rowNum = sheet1.getPhysicalNumberOfRows();

        Row row = sheet1.createRow(rowNum);
        Cell cell0 = row.createCell(0);
        cell0.setCellValue(101);
        inputStream.close();

        FileOutputStream outputStream = new FileOutputStream(excelFile);
        workbook.write(outputStream);
        outputStream.close();

    }


    @Test
    public void getDataFromExcel() throws IOException {

        String file = "src/test/java/fileProcess/atm-exporter.xlsx";

        List<List<String>> data = getData(file);
        for (List<String> row : data) {
            for (String cell : row) {
                System.out.printf("%-10s\t", cell);
            }
            System.out.println();
        }

    }

    @Test
    public void creteExcelFile() throws IOException {
        // xlsx icin XSSF....,  xls icin HSSF....
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Sheet2");

        Row row = sheet.createRow(0);

        Cell cell0 = row.createCell(0);
        cell0.setCellValue(10);

        row.createCell(1).setCellValue(20);

        String file = "src/test/java/fileProcess/MyExcel2.xlsx";
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();

    }



    @Test
    public void creteExcelFile2() throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();

        XSSFSheet sheet1 = workbook.createSheet("Sayfa1");
        Row row1 = sheet1.createRow(0);
        for (int i = 0; i < 10; i++) {
            row1.createCell(i).setCellValue(i+1);
        }

        XSSFSheet sheet2 = workbook.createSheet("Sayfa2");
        for (int i = 0; i < 10; i++) {
            Row row = sheet2.createRow(i);
            row.createCell(0).setCellValue(i+1);
        }






        String file = "src/test/java/fileProcess/MyExcel_creteExcelFile2.xlsx";
        FileOutputStream outputStream = new FileOutputStream(file);
        workbook.write(outputStream);
        outputStream.close();

    }






    public List<List<String>> getData(String path) throws IOException {

        List<List<String>> data = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheetAt(0);

        int rowNum = sheet.getPhysicalNumberOfRows();


        for (int i = 0; i < rowNum; i++) {
            Row row = sheet.getRow(i);
            int cells = row.getPhysicalNumberOfCells();
            List<String> rowData = new ArrayList<>();

            for (int j = 0; j < cells; j++) {
                Cell cell = row.getCell(j);
                if (cell!=null)
                    rowData.add(cell.toString());
                else
                    rowData.add("");
            }
            data.add(rowData);
        }
        return data;
    }




    public List<List<String>> getData(String path, String sheetName, int startRow, int endRow, int startCell, int endCell) throws IOException {

        List<List<String>> data = new ArrayList<>();

        FileInputStream inputStream = new FileInputStream(path);

        Workbook workbook = WorkbookFactory.create(inputStream);

        Sheet sheet = workbook.getSheet(sheetName);

        int rowNum = sheet.getPhysicalNumberOfRows();

        endRow = endRow<rowNum ? endRow : rowNum;

        for (int i = startRow; i < endRow; i++) {
            Row row = sheet.getRow(i);
            int cells = row.getPhysicalNumberOfCells();
            endCell = endCell<cells ? endCell : cells;
            List<String> rowData = new ArrayList<>();

            for (int j = startCell; j < endCell; j++) {
                Cell cell = row.getCell(j);
                rowData.add(cell.toString());
            }
            data.add(rowData);
        }
        return data;
    }





}
