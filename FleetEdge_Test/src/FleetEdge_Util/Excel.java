package FleetEdge_Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;





import java.util.Map;
import java.util.Set;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Hyperlink;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.annotations.Test;

public class Excel
{
	public  String path;
	public  FileInputStream fis = null;
	public  FileOutputStream fileOut =null;
	private Workbook workbook = null;
	private  Sheet sheet = null;
	private Row row   =null;
	private Cell cell = null;
	static Util u=new Util();
	public Excel( String path) 
	{
		this.path=path;
		{
			try
			{
				fis = new FileInputStream(path);
				workbook = new HSSFWorkbook(fis);

			}
			catch (Exception e) 
			{
				
				e.printStackTrace();
			}

		}

	}
	public int getRowCount(String sheetname)
	{
		int index = workbook.getSheetIndex(sheetname);
	//	System.out.println("Index  :"+index);
		if(index==-1)
			return 0;
		else{
		sheet = workbook.getSheetAt(index);
		int number=sheet.getLastRowNum()+1;
	//	System.out.println("Number  :"+number);
		return number;
		}
		
	}
	public int getColumnCount(String sheetName){
		// check if sheet exists
		if(!isSheetExist(sheetName))
		 return -1;
		
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);
		
		if(row==null)
			return -1;
		
		return row.getLastCellNum();		
	}

	public boolean isSheetExist(String sheetName)
	{
		int index = workbook.getSheetIndex(sheetName);
		if(index==-1)
		{
			index=workbook.getSheetIndex(sheetName.toUpperCase());
				if(index==-1)
					return false;
				else
					return true;
		}
		else
			return true;
	}

	public String getCellData(String sheetName,int colNum,int rowNum){
		try
		{
	//		System.out.println("CellData  :"+rowNum);	
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum-1);
			if(row==null)
				return "";
			cell = row.getCell(colNum);
			if(cell==null)
				return "";
			return cell.toString();
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
			return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
		}
	}
	public String writeoutput(Map<String, Object[]> data, String str)
	{
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("TestOutput");
		Set<String> keyset = data.keySet();
		int rownum = 0;
		for (String key : keyset)
	       {
			HSSFCellStyle style = workbook.createCellStyle();
			HSSFFont font = workbook.createFont();
			Row rows = sheet.createRow(rownum++);
			Object[] Arr =data.get(key);
			int cellno = 0;
			style.setFillForegroundColor(IndexedColors.BLUE.getIndex());
			
			
			//font.setBoldweight(true);
			font.setItalic(true);
			for (Object obj : Arr)
	           {    	   
	        	  
	        	   if(obj.toString().equalsIgnoreCase("Pass"))
	        	   {
	        		//   font.setBold(true);
	        		   style.setFont(font);
	        		   style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	        		//   style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        		   Cell cell = rows.createCell(cellno++);
	        		   cell.setCellStyle(style);
	        		   cell.setCellValue((String)obj);
	        		
	        		   
	        	   }
	        	   else if(obj.toString().equalsIgnoreCase("Fail"))
	        	   {
	        		  // font.setBold(true);
	        		   style.setFont(font);
	        		   style.setFillForegroundColor(IndexedColors.RED.getIndex());
	        		 //  style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        		   Cell cell = rows.createCell(cellno++);
	        		   cell.setCellStyle(style);
	        		   cell.setCellValue((String)obj);
	        		  
	        	   }
	        	   else if(obj.toString().equalsIgnoreCase("TC No") || obj.toString().equalsIgnoreCase("Module") || obj.toString().equalsIgnoreCase("Description")
	        			   || obj.toString().equalsIgnoreCase("Expected Result") || obj.toString().equalsIgnoreCase("Actual Result") 
	        			   || obj.toString().equalsIgnoreCase("Status") || obj.toString().equalsIgnoreCase("Execution Time(Sec.)"))
	        	   {
	        		   
	        		   style.setFillForegroundColor(IndexedColors.CORNFLOWER_BLUE.getIndex());
	        		 //  style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	        		   
	        		  // font.setBold(true);
	        		   style.setFont(font);
	        		   Cell cell = rows.createCell(cellno++);
	        		   cell.setCellStyle(style);
	        		   cell.setCellValue((String)obj);
	        		 
	        	   }
	        	   else if(obj.toString().equalsIgnoreCase("Total Time Consumed"))
	        	   {
	        		    Cell cell = rows.createCell(cellno++);
	        		   cell.setCellStyle(style);
	        		   cell.setCellValue((String)obj);
	        		  // font.setBold(true);
	        		   style.setFont(font);
	        		  
	        	   }
	        	   else
	               {
	        		   Cell cell = rows.createCell(cellno++);
	        		                      
	                   String string=obj.toString();
	                   try
	                   {
	                	   HSSFCellStyle style1 = workbook.createCellStyle();
		        		//   style.setAlignment(HorizontalAlignment.CENTER);
	                	   cell.setCellStyle(style1);
	                	   cell.setCellValue((String)obj);
	                   }
	                   catch(NumberFormatException e)
	                   {
	                	   cell.setCellValue((String)obj);
	                   }
	                   
	                   
	               }
	        	   
	           }
	           
	       }
	       try
	       {
	           FileOutputStream out = new FileOutputStream(new File(System.getProperty("user.dir")+"\\TestResults\\"+str+".xls"));
	           workbook.write(out);
	           out.close();
	           System.out.println("Output written successfully...");
	           
	       }
	       catch (Exception e)
	       {
	           e.printStackTrace();
	       }
	       finally
	       {
	    	   return (System.getProperty("user.dir")+"\\TestResults\\"+str+".xls");
	       }
	   }
	        		   
	        	   		    	 
	/* To write Pass to the output file */
	public void writePass(String tc, int counter, String sheet2, String acop)
	{
		try
		{
			
			FileInputStream fIP= new FileInputStream(System.getProperty("user.dir")+"\\TestResults\\Input.xls"); 
			
			Workbook wb = new HSSFWorkbook(fIP);
					
			
    		HSSFSheet worksheet = (HSSFSheet) wb.getSheet(sheet2); 
    		
    		Cell cell = null; // declare a Cell object
    		int rownum=0;
    		for(int c=1;c<=worksheet.getLastRowNum();c++)
    		{
    			System.out.println("TC :"+tc);
    			Cell cell1 = worksheet.getRow(c).getCell(0);
    			System.out.println(tc+":"+cell1.getStringCellValue());
    			if(tc.equalsIgnoreCase(cell1.getStringCellValue()))
    			{
    				rownum=cell1.getRowIndex();
    				break;
    			}
    		}
    		System.out.println("Rownumber : "+rownum);
    		cell=worksheet.getRow(rownum).getCell(5);
    		cell.setCellValue(acop);
    		cell = worksheet.getRow(rownum).getCell(6);   
    		if(!cell.getStringCellValue().equalsIgnoreCase("Fail"))
    			cell.setCellValue("Pass");  
    		    		
    		Thread.sleep(2000);
    		
    		System.out.println("PASS");
    		FileOutputStream output_file =new FileOutputStream(new File(System.getProperty("user.dir")+"\\TestResults\\Input.xls")); 
    		wb.write(output_file); 
    		output_file.close();  
    		counter++;
    		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

	
	/* To write Fail to the output file */
	
	public void writeFail(String tc, int counter, String sheet, String acop,String scr)
	{
		try
		{
			 
			FileInputStream fsIP= new FileInputStream(new File(System.getProperty("user.dir")+"\\TestResults\\Input.xls")); 
    		Workbook wb = new HSSFWorkbook(fsIP); 
    		Sheet worksheet = wb.getSheet(sheet);
    		Cell cell = null; 
    		int rownum=0;
    		CreationHelper createHelper = wb.getCreationHelper();
    		System.out.println(worksheet.getLastRowNum());
    		for(int c=1;c<worksheet.getLastRowNum();c++)
    		{
    			System.out.println("TC :"+tc);
    			Cell cell1 = worksheet.getRow(c).getCell(0);
    			
    			if(tc.equalsIgnoreCase(cell1.getStringCellValue()))
    			{
    				rownum=cell1.getRowIndex();
    				break;
    			}
    		}
    		System.out.println("Rownumber : "+rownum);
    		cell=worksheet.getRow(rownum).getCell(5);
    		cell.setCellValue(acop);
    		cell = worksheet.getRow(rownum).getCell(6);   
    		cell.setCellValue("Fail"); 
    		
    		
    		cell = worksheet.getRow(rownum).getCell(7);
		    cell.setCellValue(scr);
		    CreationHelper createHelper1 = wb.getCreationHelper();
		    CellStyle hlink_style = wb.createCellStyle();
		    
		    Hyperlink hp = createHelper1.createHyperlink(Hyperlink.LINK_FILE);
		    scr=scr.replace("\\", "/");
		    hp.setAddress(scr);
		    cell.setHyperlink(hp);
		    cell.setCellStyle(hlink_style);
		    System.out.println("FAIL");
    	   	      
    		
    		fsIP.close(); 
    		Thread.sleep(2000);
    		
    		FileOutputStream output_file = new FileOutputStream(new File(System.getProperty("user.dir")+"\\TestResults\\Input.xls")); 
    		wb.write(output_file); 
    		output_file.close();  
    		counter++;
    	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}



}



