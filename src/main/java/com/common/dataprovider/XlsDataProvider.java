package com.common.dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.common.Config;


/**
 * This class implements DataProvider to read the test cases from xlsx
 * It is using apache-poi and apache-poi-ooxml for parsing and reading xlsx.
 * 
 * The idea is simple, first fetch the headers from first row. then from next row
 * map each column with header name to provide key value pair as column name with column value
 * 
 * The class first reads the file from the path set in config for data folder and then its fetching 
 * xls based on API name passed as argument in this class method getTest Data.
 * 
 * 
 * @author abhijeeta_mohanty
 *
 */
public class XlsDataProvider implements DataProvider {
	
	public List<Map<String,String>> getTestData(String apiName) {
		String dataFolderPath = Config.getInstance().getDataFolderPath();
		File file = new File(dataFolderPath + File.separator + "xls" + File.separator + apiName + ".xlsx");
		List<Map<String, String>> dataList = new ArrayList<Map<String, String>>();
		try {
			try (FileInputStream fis = new FileInputStream(file);) 
			{
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
				XSSFSheet mySheet = workbook.getSheetAt(0);
				Iterator<Row> rowIterator = mySheet.rowIterator();
				Row row = rowIterator.next();
				while(rowIterator.hasNext()) {
					Map<String, String> rowMap = new HashMap<>();
					Iterator<Cell> cellIterator = rowIterator.next().cellIterator();
					int i=0;
					while(cellIterator.hasNext()) {
						Cell cell = cellIterator.next();
						if (cell.getCellTypeEnum().equals(CellType.NUMERIC)) {
							rowMap.put(row.getCell(i++).getStringCellValue(), Integer.toString(Double.valueOf(cell.getNumericCellValue()).intValue()));
						}
						else {
							rowMap.put(row.getCell(i++).getStringCellValue(), cell.getStringCellValue());
						}
					}
					dataList.add(rowMap);
				}
				workbook.close();
			}
		}
		catch (FileNotFoundException ex) {

		}
		catch (IOException ioex) {

		}
		return dataList;
	}
}
