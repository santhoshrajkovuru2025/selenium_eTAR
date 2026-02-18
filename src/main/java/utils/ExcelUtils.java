package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class ExcelUtils {

    public static Object[][] readExcel(String filePath) {

        ArrayList<String[]> dataList = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheetAt(0);

            DataFormatter formatter = new DataFormatter();

            boolean firstRow = true;

            for (Row row : sheet) {

                if (firstRow) {
                    firstRow = false;
                    continue;
                }

                int colCount = row.getLastCellNum();

                String[] data = new String[colCount];

                for (int i = 0; i < colCount; i++) {

                    Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

                    data[i] = formatter.formatCellValue(cell);
                }

                dataList.add(data);
            }

        } catch (IOException e) {

            throw new RuntimeException("Error reading Excel file: " + filePath, e);
        }

        Object[][] data = new Object[dataList.size()][];

        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }

        return data;
    }
}
