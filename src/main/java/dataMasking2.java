import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mohs10.base.StartBrowser;

public class dataMasking2 extends StartBrowser {
	
	
	public static WebDriver driver;
	public static void maskEmail(By locator, String email, String excelfile, String excelsheet) throws Exception {
	    // Load Excel file
	    FileInputStream file = new FileInputStream(excelfile);
	    Workbook workbook = WorkbookFactory.create(file);
	    Sheet sheet = workbook.getSheet(excelsheet);

	    // Find the row with the matching email
	    for (Row row : sheet) {
	        Cell emailCell = row.getCell(2);
	        if (emailCell == null) {
	            continue;
	        }
	        String rowEmail = emailCell.getStringCellValue();
	        if (rowEmail.equals(email)) {
	            // Replace characters with asterisks
	            String[] parts = email.split("@");
	            if (parts.length == 1) {
	                // Invalid email format, return original email
	                // return email;
	            }
	            String username = parts[0];
	            int length = username.length();
	            String masked = "";
	            for (int j = 0; j < length; j++) {
	                masked += "x";
	            }
	            email = masked + "@" + parts[1];
	            break;
	        }
	    }

	    // If no match is found, return the original email
	    // return email;

	    // Pass the masked email to the script
	    System.out.println(email);
	    WebElement ele3 = driver.findElement(locator);
	    ele3.sendKeys(email);
	    file.close();
	}


}
