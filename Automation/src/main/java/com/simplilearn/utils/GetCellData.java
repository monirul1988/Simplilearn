package com.simplilearn.utils;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class GetCellData {

	public static ArrayList<String> GetExcelData(String testcasename) throws IOException {
		
		Properties prop = new Properties();
        FileInputStream path = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
				prop.load(path);
				
				

		ArrayList<String> a = new ArrayList<String>();
		
		//FileInputStream fis = new FileInputStream("C:\\Users\\IBM_ADMIN\\Desktop\\project\\testdata.xlsx");
		
		FileInputStream fis = new FileInputStream(prop.getProperty("DataFilepath"));
		

		XSSFWorkbook wb = new XSSFWorkbook(fis);

		int sheet_count = wb.getNumberOfSheets();

		// System.out.println("number of sheets " + sheet_count);
		for (int i = 0; i < sheet_count; i++) {

			if (wb.getSheetName(i).equalsIgnoreCase("testdata")) {

				XSSFSheet sheet = wb.getSheetAt(i);
				{
					Iterator<Row> rows = sheet.iterator();
					Row firstRow = rows.next();
					Iterator<Cell> ce = firstRow.cellIterator();

					int k = 0;
					int column = 0;

					while (ce.hasNext()) {
						Cell value = ce.next();
						if (value.getStringCellValue().equalsIgnoreCase("Testcase")) {
							// System.out.println("done");---Column has been ientified

							column = k;
						}
						k++;
					}

					// System.out.println("column value " + column);

					while (rows.hasNext()) {

						Row r = rows.next();
						// System.out.println(r.getCell(column).getStringCellValue());

						if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename))

						{
							Iterator<Cell> cit = r.cellIterator();

							while (cit.hasNext()) {
								Cell c = cit.next();

								if (c.getCellTypeEnum()==CellType.STRING)
								{

								a.add(c.getStringCellValue());}
								else
								{
									a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								}
							}

						}

					}

				}

			}

		}
            return a;
	}

	public static void main(String[] args) throws IOException {
		
		GetExcelData("testcase");
		
		
		
	}
}