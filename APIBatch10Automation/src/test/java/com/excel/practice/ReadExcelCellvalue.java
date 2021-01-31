package com.excel.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelCellvalue {

	static FileInputStream fis;
	static XSSFWorkbook wb;
	public static void main(String[] args) {

		// String path="./Data folder/Test data financials.xlsx";

		File filepath = new File("./Data folder/Test data financials.xlsx");

		try {
			fis = new FileInputStream(filepath);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// Apachi POI>>JAR to handle Excel>>read the excel data as stream

		/*
		 * XSSFWorkbook wb = new Workbook();
		 * 
		 * XSSFSheet sht = wb.getSheetAt(0); XSSFRow row = sht.getRow(0);
		 * 
		 * XSSFCell cell = row.getCell(cellnum);
		 */

		try {
			 wb = new XSSFWorkbook(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		XSSFCell cellvalue = wb.getSheetAt(1).getRow(1).getCell(2);
		
		System.out.println(cellvalue.toString());
		
	}

}
