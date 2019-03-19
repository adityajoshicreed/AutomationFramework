package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.Constants;

public class ExcelUtil {

	public XSSFWorkbook wb = null;
	public XSSFSheet sheet = null;
	public final Logger log = LogManager.getLogger("Log");
	private File src = null;
	private FileInputStream fis = null;
	
	public ExcelUtil() throws IOException {
		try {
			src = new File(Constants.excelPath);
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			log.info("Reading Excel File");
		} catch (Exception e) {
			log.debug(e);
		}
		finally {
			fis.close();
		}
	}

	public String getData(int row, int col, String sheetName) {
		sheet = wb.getSheet(sheetName);
		CellType type = sheet.getRow(row).getCell(col).getCellTypeEnum();
		if (type == CellType.STRING) {
			String data = sheet.getRow(row).getCell(col).getStringCellValue();
			log.info("Returning data as "+data+" from Excel File");
			return data;
		}
		else if(type == CellType.NUMERIC) {
			double intValue = sheet.getRow(row).getCell(col).getNumericCellValue();
			String data =  new Double(intValue).toString();
			log.info("Returning data as "+data+" from Excel File");
			return data;
		}
		else {
			log.debug("Invalid Cell Type");
			throw new NullPointerException();
		}
	}
}

