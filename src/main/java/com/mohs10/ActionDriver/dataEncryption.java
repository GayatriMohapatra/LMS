package com.mohs10.ActionDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class dataEncryption {
    @Test
    public static String encryptData(String excelFilePath, String excelsheet) throws IOException {
        // Construct the path to the input Excel file
        File inputFile = new File(excelFilePath);

        // Open the input Excel file
        FileInputStream fis = new FileInputStream(inputFile);

        // Create a Workbook object
        Workbook workbook = WorkbookFactory.create(fis);

        // Get the sheet with the data to encrypt
        Sheet sheet = workbook.getSheet(excelsheet);

        // Get the row and cell for the data to encrypt
        int rowIndex = 1; // Assuming the data starts from the 2nd row
        int columnIndex = 1; // Assuming the data is in the second column (index 1)

        Row row = sheet.getRow(rowIndex);
        Cell cellToEncrypt = row.getCell(columnIndex);

        // Check if the cell is not null and not empty
        if (cellToEncrypt != null && !cellToEncrypt.getStringCellValue().isEmpty()) {
            // Get the cell value
            String dataToEncrypt = cellToEncrypt.getStringCellValue();
            System.out.print(dataToEncrypt);

            // Encode the data using URL-safe Base64 encoding
            byte[] encodedBytes = Base64.getUrlEncoder().encode(dataToEncrypt.getBytes(StandardCharsets.UTF_8));
            String encryptedData = new String(encodedBytes, StandardCharsets.UTF_8);

            // Write the encrypted data back to the same cell
            cellToEncrypt.setCellValue(encryptedData);

            // Set the column header for the encrypted data
            if (row.getRowNum() == 0) {
                sheet.getRow(0).createCell(0).setCellValue("Encrypted Data");
            }

            System.out.println(encryptedData);
        }

        // Save the changes to the Excel file
        FileOutputStream fos = new FileOutputStream(inputFile);
        workbook.write(fos);
        fos.close();
        workbook.close();

        return excelsheet;
    }
}
