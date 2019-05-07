package com.java.framework.TestClasses;

import java.util.Properties;

import com.java.framework.Utils.EnvironmentPropertiesReader;
import com.java.framework.Utils.Excel;

public class ExcelReadDemo {

	static Object ob;
	static Excel objExcel;

	public static void main(String[] args) {

		objExcel = new Excel();
		ob = new Object();
		Properties prop;
		prop = EnvironmentPropertiesReader.getInstance().PropertiesFile();
		String folderName = prop.getProperty("FolderName");
		String fileName = prop.getProperty("FileName");
		String sheetName = prop.getProperty("SheetName");
		int row = 0;
		int col = 5;
		String value = "Status";
		String newRow = "yes";
		String color = "Green";
		try {

			ReadData1(folderName, fileName, sheetName);
			ReadData2(folderName, fileName, sheetName);
			writeData(row, col, value, newRow, color,sheetName, folderName, fileName);			

		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
		}

	}

	public static void ReadData1(String folderName, String fileName, String sheetName) {
		try {

			int sheetIndex = 3;
			objExcel.getExcelFile(folderName, fileName);
			int countOfRow = objExcel.getRowCount(folderName, fileName, sheetIndex);
			System.out.println("TotalCountOfRow are as follow : " + countOfRow);
			objExcel.getSheet(sheetName);
			ob = objExcel.readExcelUserInput(folderName, fileName, sheetIndex, 2, 2);
			String str = ob.toString();
			System.out.println(str);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void ReadData2(String folderName, String fileName, String sheetName) {
		try {

			int sheetIndex = 3;
			objExcel.getExcelFile(folderName, fileName);
			int countOfRow = objExcel.getRowCount(folderName, fileName, sheetIndex);
			System.out.println("TotalCountOfRow are as follow : " + countOfRow);
			objExcel.getSheet(sheetName);
			ob = objExcel.readExcelUserInput(folderName, fileName, sheetIndex, 1, 0);
			String str = ob.toString();
			System.out.println(str);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void writeData(int row, int col, String value, String newRow, String color, String sheetName, String folderName,
			String fileName) {
		try {
			objExcel.getExcelFile(folderName, fileName);
			objExcel.writeExcel(row, col, value, newRow, color, sheetName, folderName, fileName);
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e.getCause());
			System.out.println(e.getMessage());

		}
	}		
}
