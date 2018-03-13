package FleetEdge_Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_Write {	
	
//	public  String path;
	public  FileInputStream fis = null;	
	public 	Sheet sheet = null;
	
	/* Reading Excel file based on the extension calling corresponding function.*/
	public String[][] Read(String path,String sheetname) 
	{	
		String[][] d =null;
		try 
		{
			fis = new FileInputStream(path);
			if (path.endsWith("xlsx")) 
			{			
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sh =wb.getSheet(sheetname);				
				 d = readXLSXFile(sh);
			} 
			else if (path.endsWith("xls"))
			{				
				HSSFWorkbook wb = new HSSFWorkbook(fis);	
				HSSFSheet sh = wb.getSheet(sheetname);
				 d = readXLSFile(sh);
			} 
			else 
				System.out.println("The specified file is not a valid format");
		
		}catch (Exception e) 
			{e.printStackTrace();}
		return d;	
		
	}
	
	/* Reading XLS file */
	public static String[][] readXLSFile(Sheet sh) 
	{
		HSSFRow row;
		HSSFCell cell;
		
		int rows = sh.getLastRowNum()+1;		
		
		row =(HSSFRow) sh.getRow(0);
		int cols= row.getLastCellNum();		
		
		String[][] data = new String[rows-1][cols];
		try
		{
			for(int rowNum = 2 ; rowNum <= rows ; rowNum++)
			{ 			
				for(int colNum=0 ; colNum< cols; colNum++)
				{
					row = (HSSFRow) sh.getRow(rowNum-1);					
					if(row==null)
						
						System.out.println("Row has null value");
					
					cell = row.getCell(colNum);					
					if(cell==null)
						System.out.println("Cell has null value");
					System.out.println(cell);
				
					data[rowNum-2][colNum]= cell.toString(); 
				}
			}
		}catch(Exception e)
		{ e.printStackTrace();}		
		return data;		
	}
	
	/* Reading XLSF file */
	public static String[][] readXLSXFile(Sheet sh) 
	{
		
		
		XSSFRow row; 
		XSSFCell cell = null;
		int rows = sh.getLastRowNum()+1;
		
		
		row =(XSSFRow) sh.getRow(0);
		int cols= row.getLastCellNum();
		
		
		String[][] data = new String[rows-1][cols];
		try
		{
			for(int rowNum = 2 ; rowNum <= rows ; rowNum++)
			{ 			
				for(int colNum=0 ; colNum< cols; colNum++)
				{
									
				/*	row = (XSSFRow) sh.getRow(rowNum-1);					
					if(row==null)
						System.out.println("Row has null value");
					
					/*		cell = row.getCell(colNum);					
					if(cell==null)
						System.out.println("Cell has null value");*/
				
					data[rowNum-2][colNum]= getCellValue(sh,rowNum,colNum);
				}
			}
		}catch(Exception e)
		{ e.printStackTrace();}		
		
		return data;	
	}
	private static String getCellValue(Sheet sh,int rowNum, int colNum) 
	{
	XSSFRow row; 
	XSSFCell cell;
	row = (XSSFRow) sh.getRow(rowNum-1);	
	if(row==null)
	return "";

	cell = row.getCell(colNum);	
	if(cell==null)
	return "";
	return cell.toString();
	}
	
	
	
	/* Calling input file to update test status */
	public void WriteInput(String filepath,String sheetname,String tc, int counter,String acop,String result) 
	{	
		String[][] d =null;
		try 
		{
			fis = new FileInputStream(filepath);
			if (filepath.endsWith("xlsx")) 
			{				
				XSSFWorkbook wb = new XSSFWorkbook(fis);
				XSSFSheet sh =wb.getSheet(sheetname);					
				writeXL(tc,counter,acop,result,sh,filepath ,wb);
			} 
			else if (filepath.endsWith("xls"))
			{				
				HSSFWorkbook wb = new HSSFWorkbook(fis);	
				HSSFSheet sh = wb.getSheet(sheetname);					
    		    writeXL(tc,counter,acop,result,sh, filepath ,wb);
			} 
			else 
				System.out.println("The specified file is not a valid format");
		
		}catch (Exception e) 
			{e.printStackTrace();}		
	}
	
	/* Writing tetsstatus in input file */
	public void writeXL(String tc, int counter, String acop,String result ,Sheet sh,String filepath ,Workbook wb )
	{
		try
		{	   		
    		Cell cell = null; 
    		int rownum=0;    		
    		CellStyle style = wb.createCellStyle();
    		Font font = wb.createFont();
    		for(int c=1;c<=sh.getLastRowNum();c++)
    		{   			
    			Cell cell1 = sh.getRow(c).getCell(0);    			
    			if(tc.equalsIgnoreCase(cell1.getStringCellValue()))
    			{
    				rownum=cell1.getRowIndex();
    				break;
    			}
    		}    		
    		cell=sh.getRow(rownum).getCell(5);
    		cell.setCellValue(acop);
    		cell = sh.getRow(rownum).getCell(6);   
    		if(result.equalsIgnoreCase("Pass"))
    		{	
    			font.setColor(IndexedColors.GREEN.getIndex());     	
    			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
    			style.setFont(font);
    			style.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);
    			cell.setCellValue("Pass"); 
    			cell.setCellStyle(style);
    		}
    		
    		else
    		{
    			
    			font.setColor(IndexedColors.RED.getIndex());
    			font.setBoldweight(Font.BOLDWEIGHT_BOLD);
    			style.setFont(font);    			
    			style.setAlignment(CellStyle.ALIGN_CENTER_SELECTION);
    			cell.setCellValue("Fail"); 
    			cell.setCellStyle(style);
    		}
        	    
    		Thread.sleep(2000);    		
    		System.out.println(result);
    		
    		fis.close();
    		FileOutputStream output_file =new FileOutputStream(new File(filepath)); 
    		wb.write(output_file); 
    		output_file.close();  
    		counter++;
    		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	/* Writing data in the output file */
	public String WriteOutput (Map<String, Object[]> data,String filepath)
	{
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("TestOutput");
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset)
	       {
			XSSFCellStyle style = workbook.createCellStyle();
			XSSFFont font = workbook.createFont();
			Row rows = sheet.createRow(rownum++);
			Object[] Arr =data.get(key);
			int cellno = 0;
			style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
			font.setBold(true);
			for (Object obj : Arr)
	        {    	        	  
				if(obj.toString().equalsIgnoreCase("Pass"))
				{
					font.setBold(true);
	        		style.setFont(font);
	        		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	        		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        		Cell cell = rows.createCell(cellno++);
	        		cell.setCellStyle(style);
	        		cell.setCellValue((String)obj);        		
	        		   
	        	 }  
	        	 else if(obj.toString().equalsIgnoreCase("Fail"))
	        	 {
	        		font.setBold(true);
	        		style.setFont(font);
	        		style.setFillForegroundColor(IndexedColors.RED.getIndex());
	        		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        		Cell cell = rows.createCell(cellno++);
	        		cell.setCellStyle(style);
	        		cell.setCellValue((String)obj);	        		  
	        	  }
	        	   
	        	   else if(obj.toString().equalsIgnoreCase("TC No") || obj.toString().equalsIgnoreCase("Module") || obj.toString().equalsIgnoreCase("Description")
	        			   || obj.toString().equalsIgnoreCase("Expected Result") || obj.toString().equalsIgnoreCase("Actual Result") 
	        			   || obj.toString().equalsIgnoreCase("Status") || obj.toString().equalsIgnoreCase("Time(Sec.)"))
	        	   {	        		   
	        		   style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
	        		   style.setFillPattern(FillPatternType.SOLID_FOREGROUND);	        		   
	        		   font.setBold(true);
	        		   style.setFont(font);
	        		   Cell cell = rows.createCell(cellno++);
	        		   cell.setCellStyle(style);
	        		   cell.setCellValue((String)obj);
	        		 
	        	   }	        	  
	        	   else
	               {
	        		   Cell cell = rows.createCell(cellno++);
	        		                      
	                   String string=obj.toString();
	                   try
	                   {
	                	   XSSFCellStyle style1 = workbook.createCellStyle();
		        		   style.setAlignment(HorizontalAlignment.CENTER);
	                	   cell.setCellStyle(style1);
	                	   cell.setCellValue((String)obj);
	                   }
	                   catch(NumberFormatException e)
	                   {cell.setCellValue((String)obj);}	                   
	                   
	               }
	        	   
	           }
	           
	       }
	       try
	       {
	           FileOutputStream out = new FileOutputStream(new File(filepath));
	           workbook.write(out);
	           out.close();
	           System.out.println("Output written successfully in excel file.....");
	           
	       }
	       catch (Exception e)
	       {e.printStackTrace();}
	      
	       finally
	       { return (filepath);}
	   }
	
		

	}

