package com.classstudies.classquiz.dumpExcel.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.classstudies.classquiz.dumpExcel.entity.Excel;

public class ExcelHelper {

	private static String EXCEL_CONTENT_TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

	// check the the type of file
	// if its excel file then will returns true
	// else will returns false.
	public static boolean checkFileType(MultipartFile file) {

		String contentType = file.getContentType();

		return contentType.equals(EXCEL_CONTENT_TYPE);

//		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
//			return true;
//		}
//		
//		return false;
	}
	
	// ------------------------------------------------------------------------------------------------------------------------

	// this method converts excel file to list.
	@SuppressWarnings("resource")
	public static List<Excel> convertExcelToList(InputStream is) {

		List<Excel> list = new ArrayList<>();

		try {

			XSSFWorkbook workbook = new XSSFWorkbook(is);
			XSSFSheet sheet = workbook.getSheet("Sheet1");

			int rowNumber = 0;
			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {

				Row row = iterator.next();

				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cells = row.iterator();

				int cid = 0;

				Excel e = new Excel();

				while (cells.hasNext()) {

					Cell cell = cells.next();

					switch (cid) {

					case 0:
//						String numericCellValue = String.valueOf(cell.getNumericCellValue());
//						Long val = Long.parseLong(numericCellValue);
						e.setPolicyId(cell.getNumericCellValue());
						break;

					case 1:
						e.setExpiryMonth(cell.getStringCellValue());
						break;

					case 2:
						e.setLocation(cell.getStringCellValue());
						break;

					case 3:
						e.setState(cell.getStringCellValue());
						break;

					case 4:
						e.setRegion(cell.getStringCellValue());
						break;

					case 5:
						e.setInsuredValue(String.valueOf(cell.getNumericCellValue()));
						break;

					case 6:
						e.setConstruction(cell.getStringCellValue());
						break;

					case 7:
						e.setBusinessType(cell.getStringCellValue());
						break;

					default:
						break;
					}
					
					cid++;
				}
				list.add(e);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

}
