package FleetEdge_Util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import FleetEdge_Core.Core;

public class Utildashboard extends Core
{
	public  String path;
	public static  FileInputStream fis = null;	
	public 	Sheet sheet = null;
	public static int readGetNo(String path,String val,String sheetname,int header)
	{
		int c=0;
		try
		{
			FileInputStream fis = new FileInputStream(path);
			if (path.endsWith("xlsx")) 
			{
			XSSFWorkbook wb = new XSSFWorkbook(fis);	
			XSSFSheet sh = wb.getSheet(sheetname);
			Row r = sh.getRow(1);
			int cell=r.getLastCellNum();
			for(int rowNum = header ; rowNum <=header ; rowNum++)
			{ 			
				for(c=1;c<cell;c++)
				{
					String excelString=sh.getRow(rowNum).getCell(c).getStringCellValue();
					if(val.equalsIgnoreCase(excelString))
					{
						break;
					}
				}
			}
			}else if (path.endsWith("xls")) 
			{
				HSSFWorkbook wb = new HSSFWorkbook(fis);	
				HSSFSheet sh = wb.getSheet(sheetname);
				Row r = sh.getRow(1);
				int cell=r.getLastCellNum();
				for(int rowNum = header ; rowNum <=header ; rowNum++)
				{ 			
					for(c=0;c<cell;c++)
					{
						String excelString=sh.getRow(rowNum).getCell(c).getStringCellValue();
						if(val.equalsIgnoreCase(excelString))
						{
							break;
						}
					}
				}
			}
		}catch(Exception e)
		{ e.printStackTrace();}
		return c;		
	}
	public static String excelRead(String path,int r,String findVal,String sheetname,int header)
	{
		String val=null;
		try
		{
			fis = new FileInputStream(path);
			int n = readGetNo(path,findVal,sheetname,header);
			if (path.endsWith("xlsx")) 
			{			
				XSSFWorkbook wb = new XSSFWorkbook(fis);	
				XSSFSheet sh = wb.getSheet(sheetname);
					
				for(int rowNum = 1 ; rowNum <= r ; rowNum++)
				{ 			
					for(int j=n;j<=n;j++)
					{
						DataFormatter formatter = new DataFormatter();
						val = formatter.formatCellValue(sh.getRow(rowNum).getCell(j));
						}
				}
			} 
			else if (path.endsWith("xls"))
			{				
				HSSFWorkbook wb = new HSSFWorkbook(fis);	
				HSSFSheet sh = wb.getSheet(sheetname);
				for(int rowNum = 1 ; rowNum <= r ; rowNum++)
				{ 			
					for(int j=n;j<=n;j++)
					{
						DataFormatter formatter = new DataFormatter();
						 val = formatter.formatCellValue(sh.getRow(rowNum).getCell(j));
					}
				}
			} 
			else 
				System.out.println("The specified file is not a valid format");		
		}catch(Exception e)
		{ e.printStackTrace();}
		return val;	
	}
	
	public static int loopIncrement(String path,String sheetname)
	{
		int rows = 0 ;
		try
		{
			FileInputStream fis = new FileInputStream(path);
			if (path.endsWith("xlsx")) 
			{
				XSSFWorkbook wb = new XSSFWorkbook(fis);	
				XSSFSheet sh = wb.getSheet(sheetname);
				rows = sh.getLastRowNum();
			}
			else if (path.endsWith("xls"))
			{
				HSSFWorkbook wb = new HSSFWorkbook(fis);	
				HSSFSheet sh = wb.getSheet(sheetname);
				rows = sh.getLastRowNum();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rows;
	}
	
	
	public static void fileDeleter(String filePath)
	{
		 try { 

	         File file = new File(filePath);
	         if(file.delete()) { 
	            System.out.println(file.getName() + " is deleted!");
	         } else {
	            System.out.println("Delete operation is failed.");
	    		}
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
	}
	
	public static void downloadRobo()
	{
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(500);
			r.keyRelease(KeyEvent.VK_DOWN);
			Thread.sleep(500);
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(500);
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void downloadRobo1()
	{
		try {
			Robot r = new Robot();
			r.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(500);
			r.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static boolean fileExist(String filePath)
	{
		boolean val = false;
		File f = new File(filePath);
		if(f.exists() && !f.isDirectory())
		{ 
			val= true;
		//	System.out.println("Return True");
		}
		else
		{
			val= false;
	//		System.out.println("Return False");
		}
		return val;	
	}
}
