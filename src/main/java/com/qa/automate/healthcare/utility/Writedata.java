package com.qa.automate.healthcare.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Writedata {

	public static void main(String[] args) throws IOException {
		File file= new File("D://test.xlsx");
		FileInputStream fin=new FileInputStream(file);
		
		XSSFWorkbook book=new XSSFWorkbook();
		XSSFSheet sheet= book.getSheet("Sheet1");
		
		XSSFRow row = sheet.createRow(5);
		XSSFCell cell = row.createCell(5);
		
		for(int i=0;i<sheet.getPhysicalNumberOfRows();i++)
		{
			XSSFRow r = sheet.getRow(i);
			for(int j=0;j<row.getPhysicalNumberOfCells();j++)
			{
				XSSFCell c = r.getCell(j);
				c.setCellValue("Software");
				FileOutputStream fout =new FileOutputStream(file);
				book.write(fout);
				fout.close();
			}
		}
	}
}
