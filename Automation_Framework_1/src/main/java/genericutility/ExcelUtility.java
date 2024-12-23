package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Debashish
 */
public class ExcelUtility {
	/**
	 * This method takes sheetName,rowIndex,colIndex as an argument and returns value present in the cell
	 * @param sheetName
	 * @param rowIndex
	 * @param colIndex
	 * @return value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

	public String getStringDataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		/**
		 * this method return string value from excel
		 */
		FileInputStream fis = new FileInputStream("./src/test/resources/Testdata/TestScriptData1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getStringCellValue();
	}

	public boolean getBooleanDataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		/**
		 * this method return boolean value from excel
		 */
		FileInputStream fis = new FileInputStream("./src/test/resources/Testdata/TestScriptData1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
	}
	public double getNumberDataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		/**
		 * this method return number value from excel
		 */
		FileInputStream fis = new FileInputStream("./src/test/resources/Testdata/TestScriptData1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getNumericCellValue();
	}
	public LocalDateTime getdateDataFromExcel(String sheetName,int rowIndex,int colIndex) throws EncryptedDocumentException, IOException {
		/**
		 * this method return localdateTime value from excel
		 */
		FileInputStream fis = new FileInputStream("./src/test/resources/Testdata/TestScriptData1.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();
	}
}




