package com.excel.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelColumnValue {
	static FileInputStream fis;
	static XSSFWorkbook wb;

	public static void main(String[] args) {

		File filepath = new File("./Data folder/Test data financials.xlsx");
		try {
			fis = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// apachi poi

		try {
			wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		/// column code

		XSSFSheet sht = wb.getSheetAt(1);
		// XSSFRow row = sht.getRow(1);
		// System.out.println(row);
		int RowCount = sht.getPhysicalNumberOfRows();
		// int RowCount = sht.getRow(1);
		System.out.println(RowCount);

		// loop
		// List<String> mylist = new ArrayList<String>();
		Set<String> mylist = new LinkedHashSet<String>();
		int ColumnCount = 0;

		for (int i = 0; i < RowCount; i++) {

			XSSFRow row = sht.getRow(1);
			ColumnCount = row.getLastCellNum();

			for (int j = 0; j < ColumnCount; j++) {

				Cell cellvalue = row.getCell(j);
				//System.out.println(cellvalue);
				DataFormatter df = new DataFormatter();
				mylist.add(df.formatCellValue(cellvalue).toString());

			}
		}
		System.out.println("column number=" + ColumnCount);
		System.out.println(mylist);
	}
}
