package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil 
{

 public static long PAGE_LOAD_TIMEOUT = 20;	
 public static long IMPLICIT_WAIT = 10;	

public static String TEST_DATA_SHEETPATH = "E:\\Selenium_2022\\Excel_data\\Data.xlsx";

static Workbook book;
static Sheet sheet;


public static Object[][] getTestData(String sheetName) throws Exception, IOException
{
	FileInputStream file = null;
	try
	{
		file = new FileInputStream(TEST_DATA_SHEETPATH);
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	try
	{
		book=WorkbookFactory.create(file);
	}
	catch(InvalidFormatException e)
	{
		e.printStackTrace();
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
	sheet = book.getSheet(sheetName);

   Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
   for(int i=0;i<sheet.getLastRowNum();i++)
   {
	   for(int j=0;j<sheet.getRow(0).getLastCellNum();j++)
	   {
		   data[i][j] = sheet.getRow(i+1).getCell(j).toString();	   
	    }
   }
   
    return data;
}



}



