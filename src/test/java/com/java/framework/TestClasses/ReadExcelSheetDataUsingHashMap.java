package com.java.framework.TestClasses;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheetDataUsingHashMap {
String string;
	public static Map<String, Map<String, String>> ReadingHashMapData() {
				
		File file = null;
		FileInputStream fileInputStream = null;
		Workbook wbWorkbook = null;
		Sheet sheet = null;
		Map<String, String> map = null;
		Map<String, Map<String, String>> excelData = null;

		Row row = null;
		Cell cell = null;
		try {
			String pathString = "C:\\Users\\dheeraj.singh\\git\\JavaFrameWork\\TestDataFile\\TestFile.xlsx";
			file = new File(pathString);
			fileInputStream = new FileInputStream(file);
			map = new HashMap<String, String>();
			excelData = new HashMap<String, Map<String, String>>();
			if (pathString.endsWith(".xlsx")) {
				wbWorkbook = new XSSFWorkbook(fileInputStream);
			} else {
				wbWorkbook = new HSSFWorkbook(fileInputStream);
			}
			sheet = wbWorkbook.getSheet("LoginData");
			int totalRowCount = sheet.getPhysicalNumberOfRows();

			for (int i = 1; i < totalRowCount; i++) {
				row = sheet.getRow(i);
				int totalCellCount = row.getPhysicalNumberOfCells();
				for (int j = 0; j < totalCellCount - 1; j++) {
					cell = row.getCell(j);
					int k = 0;

					String keyUserName = sheet.getRow(i).getCell(k).getStringCellValue().trim();
					String valuePassword = sheet.getRow(i).getCell(k + 1).getStringCellValue().trim();
					map.put(keyUserName, valuePassword);
					excelData.put("ExcelTestData", map);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return excelData;
	}

	public static String SearchValueInExcel(String keyString) {
		String valueString = null;
		try {

			Map<String, String> dataMap = ReadingHashMapData().get("ExcelTestData");
			valueString = dataMap.get("naveenanimation20@gmail.com");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return valueString;
	}

	public static void ReadMapData() {
		try {
			Map<String, Map<String, String>> dataMap = ReadingHashMapData();
			for(Entry<String, Map<String, String>> entryEntries : dataMap.entrySet())
			{
				String keyString=entryEntries.getKey();
				Map<String, String>mapValueMap=entryEntries.getValue();
				System.out.println("Key name is  : " + keyString);
				for(Entry<String, String> keyValuePair:mapValueMap.entrySet())
				{
					String key=keyValuePair.getKey();
					String value=keyValuePair.getValue();
					System.out.println(key + " " + value);
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {

		String KeyToSearchValueInExcel = "naveenanimation20@gmail.com";
		String valueString = SearchValueInExcel(KeyToSearchValueInExcel);
		System.out.println("The value of " + KeyToSearchValueInExcel + " key is " + valueString);
		ReadMapData();
	}
}
