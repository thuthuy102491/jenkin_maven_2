package reportConfig;

import commons.GlobalConstants;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ExcelConfig {
	private Sheet currentSheet;
	private final String testDataExcelPath = GlobalConstants.getGlobalConstants().getDataPath() + "excelData.xlsx" ;
	private Map<String, Integer> columns;

	public static ExcelConfig getExcelData() {
		return new ExcelConfig();
	}

	public void switchToSheet(String name) {
		columns = new HashMap<String, Integer>();

		try (var workbooks = WorkbookFactory.create(new File(testDataExcelPath))) {
			currentSheet = workbooks.getSheet(name);
			currentSheet.getRow(0).forEach(cell -> {
				columns.put(cell.getStringCellValue(), cell.getColumnIndex());
			});
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getCellData(String columnName, int row) {
		var dataRow = currentSheet.getRow(row);
		return getCellDataAsString(dataRow.getCell(columns.get(columnName)));
	}

	private String getCellDataAsString(Cell cell) {
		String data;
		 switch (cell.getCellType()) {
			case STRING :
				data = cell.getStringCellValue();
				break;
			case NUMERIC :
				data = String.valueOf((cell.getNumericCellValue()) );
				break;
			case FORMULA :
				data = cell.getStringCellValue();
				break;
			default :
				data ="";
		}
		return data;
	}

}
