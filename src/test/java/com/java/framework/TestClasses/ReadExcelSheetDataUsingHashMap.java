package com.java.framework.TestClasses;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelSheetDataUsingHashMap {
	
	
	public static void ReadingHasMapData()
	{
		File file=null;
		FileInputStream fileInputStream=null;
		Workbook wbWorkbook=null;
		Sheet sheet=null;
		Map<String, String> map=null;
		Row row=null;
		Cell cell=null;
		try {
			String pathString="C:\\Users\\dheeraj.singh\\git\\JavaFrameWork\\TestDataFile\\TestFile.xlsx";
			file=new File(pathString);
			fileInputStream=new FileInputStream(file);
			map=new HashMap<String, String>();
			if(pathString.endsWith(".xlsx"))
			{
				wbWorkbook=new XSSFWorkbook(fileInputStream);
			}
			else {
				wbWorkbook=new HSSFWorkbook(fileInputStream);
			}			
			sheet=wbWorkbook.getSheet("LoginData");			
			int totalRowCount=sheet.getPhysicalNumberOfRows();
			
			for(int i=1;i<totalRowCount;i++)
			{
				row=sheet.getRow(i);
				int totalCellCount=row.getPhysicalNumberOfCells();
				for(int j=0;j<totalCellCount-1;j++)
				{
					cell=row.getCell(j);
					int k=0;
					
					String keyUserName=sheet.getRow(i).getCell(k).getStringCellValue().trim();
					String valuePassword=sheet.getRow(i).getCell(k+1).getStringCellValue().trim();					
					map.put(keyUserName, valuePassword);
				}
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		ReadingHasMapData();
	}

}
