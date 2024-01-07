package com.mohs10.ActionDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class XLUtils 
{

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static Workbook wb; 
	public static Sheet ws;
	public static Row row;
	public static Cell cell;
	public static CellStyle style;
	
	//To get the Count of the Rows
	public static int getRowCount(String xlfile,String xlsheet) throws IOException
	{		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;		
	}
	
	////To get the Count of the columns
	public static short getColumnCount(String xlfile,String xlsheet,int rownum) throws IOException
	{
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		short colcount = row.getLastCellNum();
		wb.close();
		fi.close();
		return colcount;
	}
	
	////To get the String Data 
	public static String getStringCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		String data;
		try 
		{
			cell = row.getCell(colnum);
			data = cell.getStringCellValue();
		} catch (Exception e) 
		{
			data = "";
		}
		wb.close();
		fi.close();
		return data;		
	}
	
	//To Fetch the Numeric data
	public static double getNumericCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		double data;
		try 
		{
			cell = row.getCell(colnum);
			data = cell.getNumericCellValue();
		} catch (Exception e) 
		{
			data = 0.0;
		}
		wb.close();
		fi.close();
		return data;		
	}
	
	//To get the Boolean values
	public static boolean getBooleanCellData(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		boolean data;
		try 
		{
			cell = row.getCell(colnum);
			data = cell.getBooleanCellValue();
		} catch (Exception e) 
		{
			data = false;
		}
		wb.close();
		fi.close();
		return data;		
	}

	//To Set the cell Data 
	public static void setCellData(String xlfile,String xlsheet,int rownum,int colnum,String data) throws IOException
	{
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	
	//To fill the colors in the cells
	public static void fillGreenColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);		
		cell.setCellStyle(style);
		
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
	
	public static void fillRedColor(String xlfile,String xlsheet,int rownum,int colnum) throws IOException
	{
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);		
		cell.setCellStyle(style);
		
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}

	
}
