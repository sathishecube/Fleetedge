package Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import FleetEdge_Core.Core;
import FleetEdge_Util.*;

public class ETA extends Core
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]> ETAtest(Map<String, Object[]> data, int rc, String sheet, ExtentTest test, int scase, int ecase)
	{
		String actRes = null;
		int counter=1;

		String[][] d = s.Read(path, sheet);
		try
		{		
			driver = new FirefoxDriver(t.excel());
			driver.get(Object.getProperty("URL"));
			t.dologin(driver, d[0][2], d[0][3]);
			
			t.overlay(driver);
			String txt = d[0][5];
			String[] splitVal = txt.split(",");
			//company search
			t.company(driver,splitVal[0],splitVal[1]);
			t.overlay(driver);
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		for(int i=scase-1;i<ecase;i++)
		{
			long stime = System.currentTimeMillis();
			if(d[i][0].equalsIgnoreCase("TC1"))
			{
				try{
					System.out.println("**************************TestCase 1 is executing******************************");
					t.overlay(driver);
					Thread.sleep(3000);
					WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
					WebElement y =  driver.findElement(By.xpath(Object.getProperty("EquipmentTerminalAss")));
					t.fleetSelect(driver,x,y);
					Thread.sleep(5000);
					if((t.isElementPresentcheck(By.xpath(Object.getProperty("SelectionType")), driver)) || (t.isElementPresentcheck(By.xpath(Object.getProperty("SearchBox")), driver))
							|| t.isElementPresentcheck(By.xpath(Object.getProperty("SearchBtn")), driver) || (t.isElementPresentcheck(By.xpath(Object.getProperty("New")), driver)) ||
							t.isElementPresentcheck(By.xpath(Object.getProperty("ClearBtn")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Edit")), driver) ||
							t.isElementPresentcheck(By.xpath(Object.getProperty("Unassign")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Deactivate")), driver) ||
							t.isElementPresentcheck(By.xpath(Object.getProperty("ExportExcel")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("BulkUpload")), driver)
							|| t.isElementPresentcheck(By.xpath(Object.getProperty("Page")), driver))
					{
						System.out.println("All the Elements are present in the Equipment Terminal Association");
						actRes = "All the Elements are present in the Equipment Terminal Association";
						data.put(""+rc, new Object[] {d[i][0], sheet, d[i][1], d[i][7], actRes,"Pass", t.timestamp(stime)});
						rc++;
						s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
						System.out.println("*********************TestCase 1 finished its execution*************************");
					}
					else
					{
						System.out.println("All the Elements are not present in the Equipment Terminal Association");
						actRes = "All the Elements are not present in the Equipment Terminal Association";
						data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
						rc++;
						s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
						System.out.println("*********************TestCase 1 finished its execution*************************");
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
				//Verification of Dashboard Elements
				if(d[i][0].equalsIgnoreCase("TC2"))
				{
					try{
					System.out.println("**************************TestCase 2 is executing******************************");
					t.overlay(driver);
					Thread.sleep(3000);
					WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
					WebElement y =  driver.findElement(By.xpath(Object.getProperty("EquipmentTerminalAss")));
					t.fleetSelect(driver,x,y);
					Thread.sleep(5000);
					if(!t.isElementPresentcheck(By.xpath(Object.getProperty("ETADashboard")), driver))
					{
						System.out.println("Dashboard is not present in Equipment Terminal Association");
					}
					else
					{
						System.out.println("Dashboard is present in Equipment Terminal Association");
						List<WebElement> row = driver.findElements(By.xpath(".//*[@id='tblEquipTerminalList']/thead/tr/th"));
						List<String> Data = new ArrayList<String>();
						for(WebElement r: row)
						{
							if(!r.getText().equalsIgnoreCase(""))
								Data.add(r.getText().toString());
						}
						System.out.println("Data: " +Data);
						String str = d[i][5];
						String[] split = str.split(",");
						int count=0;
						for(int j=0;j<split.length;j++)
							System.out.println("The split elements are: " +split[j]);
						for(int k=0;k<split.length;k++)
						{
							for(String rowdata : Data)
							{
								if(split[k].equalsIgnoreCase(rowdata))
								{
									count++;
									System.out.println("The element " +split[k]+ " is present");
								}
							}
						}
						if(count==(split.length))
						{
							System.out.println("All the Elements are present in the ETA Dashboard");
							actRes = "All the Elements are present in the ETA Dashboard";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 2 finished its execution*************************");
						}
						else
						{
							System.out.println("All the Elements are not present in the ETA Dashboard");
							actRes = "All the Elements are not present in the ETA Dashboard";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 2 finished its execution*************************");
						}
					}
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//Page no button verification
				if(d[i][0].equalsIgnoreCase("TC3"))
				{
					try{
					System.out.println("**************************TestCase 3 is executing******************************");
					t.overlay(driver);
					Thread.sleep(3000);
					WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
					WebElement y =  driver.findElement(By.xpath(Object.getProperty("EquipmentTerminalAss")));
					t.fleetSelect(driver,x,y);
					Thread.sleep(5000);
					List<WebElement> pageNo = driver.findElements(By.xpath(Object.getProperty("Page")));
					List<String> page = new ArrayList<String>();
					List<WebElement> leftpg = driver.findElements(By.xpath(".//*[@id='divPaging']/span/span"));
					String lpage = null;
					for(WebElement p : leftpg)
					{
						lpage = p.getText();
						System.out.println("Page selected: " +lpage);
					}
					for(WebElement pg : pageNo)
					{
						page.add(pg.getText());
					}
					System.out.println("Page: " +page);
					System.out.println("Page Size: " +page.size());
					if(page.get(page.size()-1).equalsIgnoreCase("Next 15>") && (!page.contains(lpage)))
					{
						System.out.println("Page is displayed successfully");
						actRes = "Page is displayed successfully";
						data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
						rc++;
						s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
						System.out.println("*********************TestCase 3 finished its execution*************************");
					}
					else
					{
						System.out.println("Page is not displayed successfully");
						actRes = "Page is not displayed successfully";
						data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
						rc++;
						s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
						System.out.println("*********************TestCase 3 finished its execution*************************");
					}
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				
				//Search button verification
				if(d[i][0].equalsIgnoreCase("TC4"))
				{
					try{
					System.out.println("**************************TestCase 4 is executing******************************");
					t.overlay(driver);
					Thread.sleep(3000);
					WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
					WebElement y =  driver.findElement(By.xpath(Object.getProperty("EquipmentTerminalAss")));
					t.fleetSelect(driver,x,y);
					Thread.sleep(5000);
					String str = d[i][5];
					String[] split = str.split(",");
					for(int j=0;j<split.length;j++)
						System.out.println("Split val: " +split[j]);
			
					driver.findElement(By.xpath(Object.getProperty("SelectionType"))).sendKeys(split[0]);
					System.out.println("Selected the type of search");
					driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
					driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
					Thread.sleep(7000);
					driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
					System.out.println("Click search icon");
					Thread.sleep(500);
					t.overlay(driver);
					Thread.sleep(2000);
					if(t.isElementPresentcheck(By.xpath(".//*[@id='tblEquipTerminalList']/tbody/tr"), driver))
					{
					List<WebElement> value = driver.findElements(By.xpath(".//*[@id='tblEquipTerminalList']/tbody/tr"));
					for(WebElement val : value)
					{
						System.out.println("Val: " +val.getText());
					}
					System.out.println("contains of res: " +value.get(0).getText().contains(split[1]));
					if(value.get(0).getText().contains(split[1]))
					{
						System.out.println("The searched Equipment is displayed successfully");
						actRes = "The searched Equipment is displayed successfully";
						data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
						rc++;
						s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
						System.out.println("*********************TestCase 4 finished its execution*************************");
					}
					else
					{
						System.out.println("The searched Equipment is not displayed successfully");
						actRes = "The searched Equipment is not displayed successfully";
						data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
						rc++;
						s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
						System.out.println("*********************TestCase 4 finished its execution*************************");
					}
					}
					else
						System.out.println("No Data Found");
					driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
					if(driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).getText().isEmpty())
						System.out.println("The text is cleared");
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//Verify new button
				if(d[i][0].equalsIgnoreCase("TC5"))
				{
					try{
					System.out.println("**************************TestCase 5 is executing******************************");
					t.overlay(driver);
					Thread.sleep(3000);
					WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
					WebElement y =  driver.findElement(By.xpath(Object.getProperty("EquipmentTerminalAss")));
					t.fleetSelect(driver,x,y);
					Thread.sleep(5000);
					String str = d[i][5];
					String[] split = str.split(",");
					for(int j=0;j<split.length;j++)
						System.out.println("Split val: " +split[j]);
					
					String str1 = d[i][6];
					String[] newSplit = str1.split(",");
					for(int j=0;j<newSplit.length;j++)
						System.out.println("Split val: " +newSplit[j]);
					Thread.sleep(2500);
					driver.findElement(By.xpath(Object.getProperty("New"))).click();
					Thread.sleep(5000);
					driver.findElement(By.xpath(Object.getProperty("SelectOwner"))).sendKeys(split[0]);
					driver.findElement(By.xpath(Object.getProperty("EquipmentS/N"))).sendKeys(split[1]);
					driver.findElement(By.xpath(Object.getProperty("EquipmentID"))).sendKeys(split[2]);
					if(!split[3].equalsIgnoreCase(""))
					{
						Select make = new Select(driver.findElement(By.xpath(Object.getProperty("SelectMake"))));
						make.selectByValue(split[3]);
						System.out.println("in selecting option of make");
					}
					else
					{
						System.out.println("In creating a new make");
						driver.findElement(By.xpath(Object.getProperty("MakeNewBtn"))).click();
						driver.findElement(By.xpath(Object.getProperty("MakeTextBox"))).sendKeys(newSplit[0]);
						driver.findElement(By.xpath(Object.getProperty("MakeCreateBtn"))).click();
					}
					if(!split[4].equalsIgnoreCase(""))
					{
						Select model = new Select(driver.findElement(By.xpath(Object.getProperty("SelectModel"))));
						model.selectByValue(split[4]);
						System.out.println("in selecting option of model");
					}
					else
					{
						System.out.println("In creating a new model");
						driver.findElement(By.xpath(Object.getProperty("ModelNewBtn"))).click();
						driver.findElement(By.xpath(Object.getProperty("ModelTextBox"))).sendKeys(newSplit[1]);
						driver.findElement(By.xpath(Object.getProperty("ModelCreateBtn"))).click();
					}
					if(!split[5].equalsIgnoreCase(""))
					{
						//Select category = new Select(driver.findElement(By.id("MainContainer_drpCategory")));
						//category.selectByValue(split[5]);
						driver.findElement(By.xpath(Object.getProperty("SelectCategory"))).sendKeys(split[5]);
						System.out.println("in selecting option of category");
					}
					else
					{
						System.out.println("In creating a new category");
						driver.findElement(By.xpath(Object.getProperty("CategoryNewBtn"))).click();
						driver.findElement(By.xpath(Object.getProperty("CategoryTextBox"))).sendKeys(newSplit[2]);
						driver.findElement(By.xpath(Object.getProperty("CategoryCreateBtn"))).click();
					}
					if(!split[6].equalsIgnoreCase(""))
					{
						//Select subcategory = new Select(driver.findElement(By.id("MainContainer_drpSubCategory")));
						//subcategory.selectByValue(split[6]);
						driver.findElement(By.xpath(Object.getProperty("SelectSubCategory"))).sendKeys(split[6]);
						System.out.println("in selecting option of sub category");
					}
					else
					{
						System.out.println("In creating a new sub category");
						driver.findElement(By.xpath(Object.getProperty("SubcategoryNewBtn"))).click();
						driver.findElement(By.xpath(Object.getProperty("SubcategoryTextBox"))).sendKeys(newSplit[3]);
						driver.findElement(By.xpath(Object.getProperty("SubcategoryCreateBtn"))).click();
					}
					//terminal selection
					Thread.sleep(3000);
					/*Select terminal = new Select(driver.findElement(By.id("MainContainer_drpMnetUnit")));
					terminal.selectByValue(split[7]);*/
					driver.findElement(By.xpath(Object.getProperty("TerminalS/N"))).sendKeys(split[7]);
					//pass tier value
					driver.findElement(By.xpath(Object.getProperty("Tier"))).sendKeys(split[8]);
					Thread.sleep(5000);
					
					//clear button verification
					driver.findElement(By.xpath(".//*[@id='divSoldDate']/div/span")).click();
					System.out.println("Clear button verification");
					driver.findElement(By.className("ui-datepicker-month")).sendKeys(split[9]);
					driver.findElement(By.className("ui-datepicker-year")).sendKeys(split[10]);					
					driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[4]/td[4]/a")).click();
					driver.findElement(By.xpath(Object.getProperty("DateClearBtn"))).click();
					
					if(driver.findElement(By.xpath(Object.getProperty("DatePicker"))).getText().isEmpty())
					{
						System.out.println("Date is cleared successfully");
						driver.findElement(By.xpath(".//*[@id='divSoldDate']/div/span")).click();
						driver.findElement(By.className("ui-datepicker-month")).sendKeys(split[9]);
						driver.findElement(By.className("ui-datepicker-year")).sendKeys(split[10]);
						driver.findElement(By.xpath(".//*[@id='ui-datepicker-div']/table/tbody/tr[3]/td[2]/a")).click();
						driver.findElement(By.xpath(Object.getProperty("Save"))).click();
						System.out.println("Clicked save button");
						String a = t.alertWait();
						if(a.equalsIgnoreCase("Created successfully"))
						{
							System.out.println("New Equipment is created successfully");
							actRes = "New Equipment is created successfully";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 5 finished its execution*************************");
						}
						else
						{
							System.out.println("New Equipment is not created successfully");
							actRes = "New Equipment is not created successfully";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 5 finished its execution*************************");
						}
					}	
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//verify edit button
				if(d[i][0].equalsIgnoreCase("TC6"))
				{
					try{
					
					t.overlay(driver);
					Thread.sleep(3000);
					WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
					WebElement y =  driver.findElement(By.xpath(Object.getProperty("EquipmentTerminalAss")));
					t.fleetSelect(driver,x,y);
					System.out.println("**************************TestCase 6 is executing******************************");
					Thread.sleep(5000);
					String str = d[i][5];
					String[] split = str.split(",");
					for(int j=0;j<split.length;j++)
						System.out.println("Split val: " +split[j]);
					driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
					driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
					driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
					t.overlay(driver);
					driver.findElement(By.xpath(".//*[@id='tblEquipTerminalList']/tbody/tr/td")).click();
					driver.findElement(By.xpath(Object.getProperty("Edit"))).click();
					Thread.sleep(5000);
					Select model = new Select(driver.findElement(By.xpath(Object.getProperty("SelectModel"))));
					model.selectByValue(split[1]);
					Thread.sleep(2000);
					driver.findElement(By.xpath(Object.getProperty("Save"))).click();
					String alert = t.alertWait();
					if(alert.equalsIgnoreCase("Updated successfully"))
					{
						System.out.println("The changes are updated successfully");
						actRes = "The changes are updated successfully";
						data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
						rc++;
						s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
						System.out.println("*********************TestCase 6 finished its execution*************************");
					}
					else
					{
						System.out.println("The changes are not updated successfully");
						actRes = "The changes are not updated successfully";
						data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
						rc++;
						s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
						System.out.println("*********************TestCase 6 finished its execution*************************");
					}
					driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
					if(driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).getText().isEmpty())
						System.out.println("The text is cleared");
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//unassign verification
				if(d[i][0].equalsIgnoreCase("TC7"))
				{
					try{
					
					t.overlay(driver);
					Thread.sleep(3000);
					WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
					WebElement y =  driver.findElement(By.xpath(Object.getProperty("EquipmentTerminalAss")));
					t.fleetSelect(driver,x,y);
					System.out.println("**************************TestCase 7 is executing******************************");
					Thread.sleep(5000);
					String str = d[i][5];
					String[] split = str.split(",");
					for(int j=0;j<split.length;j++)
						System.out.println("Split val: " +split[j]);
					Thread.sleep(3000);
					driver.findElement(By.xpath(Object.getProperty("SelectionType"))).sendKeys(split[0]);
					//Thread.sleep(3000);
					driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
					driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
					driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
					t.overlay(driver);
					Thread.sleep(3000);
					if(t.isElementPresentcheck(By.xpath(".//*[@id='tblEquipTerminalList']/tbody/tr/td"), driver))
					{
						driver.findElement(By.xpath(".//*[@id='tblEquipTerminalList']/tbody/tr/td")).click();
						driver.findElement(By.xpath(Object.getProperty("Unassign"))).click();
						Thread.sleep(5000);
						String cnfrm = t.alertWait();
						if(cnfrm.equalsIgnoreCase("Do you want to unassign Terminal from the selected Equipment?"))
						{
							String unassign = t.alertWait();
							if(unassign.equalsIgnoreCase("Selected Equipment Terminal unassigned successfully"))
							{
								System.out.println("The Equipment selected is Unassigned successfully");
								actRes = "The Equipment selected is Unassigned successfully";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 7 finished its execution*************************");
							}
							else
							{
								System.out.println("The Equipment selected is not Unassigned successfully");
								actRes = "The Equipment selected is not Unassigned successfully";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
								System.out.println("*********************TestCase 7 finished its execution*************************");
							}
						}
					}
					else
						System.out.println("No Data Found");
					driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
					if(driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).getText().isEmpty())
						System.out.println("The text is cleared");
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//Deactivate verification
				if(d[i][0].equalsIgnoreCase("TC8"))
				{
					try{
					
					t.overlay(driver);
					Thread.sleep(3000);
					WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
					WebElement y =  driver.findElement(By.xpath(Object.getProperty("EquipmentTerminalAss")));
					t.fleetSelect(driver,x,y);
					System.out.println("**************************TestCase 8 is executing******************************");
					Thread.sleep(5000);
					String str = d[i][5];
					String[] split = str.split(",");
					for(int j=0;j<split.length;j++)
						System.out.println("Split val: " +split[j]);
					Thread.sleep(3000);
					driver.findElement(By.xpath(Object.getProperty("SelectionType"))).sendKeys(split[0]);
					//Thread.sleep(3000);
					driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
					driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
					driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
					t.overlay(driver);
					Thread.sleep(3000);
					if(t.isElementPresentcheck(By.xpath(".//*[@id='tblEquipTerminalList']/tbody/tr/td"), driver))
					{
						driver.findElement(By.xpath(".//*[@id='tblEquipTerminalList']/tbody/tr/td")).click();
						driver.findElement(By.xpath(Object.getProperty("Deactivate"))).click();
						Thread.sleep(3000);
						String cnfrm = t.alertWait();
						if(cnfrm.equalsIgnoreCase("Do you want to deactivate the selected Equipment?"))
						{
							String deact = t.alertWait();
							if(deact.equalsIgnoreCase("Selected Equipment deactivate successfully"))
							{
								System.out.println("The Equipment selected is Deactivated successfully");
								actRes = "The Equipment selected is Deactivated successfully";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 8 finished its execution*************************");
							}
							else
							{
								System.out.println("The Equipment selected is not Deactivated successfully");
								actRes = "The Equipment selected is not Deactivated successfully";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
								System.out.println("*********************TestCase 8 finished its execution*************************");
							}
						}
					}
					else
						System.out.println("No Data Found");
					driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
					if(driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).getText().isEmpty())
						System.out.println("The text is cleared");
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//export excel verification
				if(d[i][0].equalsIgnoreCase("TC9"))
				{
					try
					{
					t.overlay(driver);
					Thread.sleep(3000);
					WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
					WebElement y =  driver.findElement(By.xpath(Object.getProperty("EquipmentTerminalAss")));
					t.fleetSelect(driver,x,y);
					Thread.sleep(5000);
						
					System.out.println("**************************TestCase 9 is executing******************************");
					driver.findElement(By.xpath(Object.getProperty("ExportExcel"))).click();
					Thread.sleep(15000);
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_DOWN);
					Thread.sleep(500);
					robot.keyRelease(KeyEvent.VK_DOWN);
					Thread.sleep(500);
					robot.keyPress(KeyEvent.VK_ENTER);
					Thread.sleep(500);
					robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(10000);
					ArrayList<String> pg = new ArrayList<String>();
					WebElement tableData = driver.findElement(By.xpath(".//*[@id='tblEquipTerminalList']/tbody"));
					List<WebElement> pageData = tableData.findElements(By.tagName("tr"));
					for(WebElement pgData : pageData)
					{
						System.out.println("Data : " +pgData.getText());
					}
					int tabSz = pageData.size();
					System.out.println("Table size : " +tabSz);
					String equip[] = new String[pageData.size()+3];
					for(int k=1;k<pageData.size()+1;k++)
					{
						equip[k] = driver.findElement(By.xpath(".//*[@id='tblEquipTerminalList']/tbody/tr[" +k+ "]/td[2]")).getText();
						System.out.println("Equipment S/N: " +equip[k]);
					}
					
					BufferedReader br = new BufferedReader(new FileReader("D:\\workspace\\TMP\\DownloadExcel\\EquipmentTerminal.xls"));
					String line;
					while((line=br.readLine())!= null)
					{
						for(int l=1;l<pageData.size()+1;l++){
						if(line.contains(equip[l]))// && line.contains(equip[2]))
							pg.add(equip[l]);
						}
					}
					br.close();
					int pgSz = pg.size();
					System.out.println("PageData: " +pg.toString());
					System.out.println("PgSize: " +pgSz);
				/*	String totPgNo = driver.findElement(By.id("divPaging")).getText();
					System.out.println("Tot pg no: " +totPgNo);
					int sind=0, eind=0;
					String record = new String();
					if(totPgNo.contains("("))
					{
						sind = totPgNo.indexOf("(");
						eind = totPgNo.indexOf(")");
						record = totPgNo.substring(sind+1, eind);
						System.out.println("No of Records(approx): " +record);
					}
					String[] exactRec = record.split("records");
					System.out.println("Exact value of record: " +exactRec[0]);*/
					if(tabSz==pgSz)
					{
						System.out.println("The Excel is downloaded successfully and the count is matched");
						actRes = "The Excel is downloaded successfully and the count is matched";
						data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
						rc++;
						s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
						System.out.println("*********************TestCase 9 finished its execution*************************");
					}
					else
					{
						System.out.println("The count is mismatched");
						actRes = "The count is mismatched";
						data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
						rc++;
						s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
						System.out.println("*********************TestCase 9 finished its execution*************************");
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
			//bulk upload verification
			if(d[i][0].equalsIgnoreCase("TC10"))
			{
				try
				{
					t.overlay(driver);
					Thread.sleep(3000);
					WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
					WebElement y =  driver.findElement(By.xpath(Object.getProperty("EquipmentTerminalAss")));
					t.fleetSelect(driver,x,y);
					Thread.sleep(5000);
					System.out.println("**************************TestCase 10 is executing******************************");
					
				/*	driver.findElement(By.xpath(Object.getProperty("BulkUpload"))).click();
					Thread.sleep(3000);
					driver.findElement(By.xpath(Object.getProperty("TemplateDownload"))).click();
					Thread.sleep(25000);
					Robot robot = new Robot();
					robot.keyPress(KeyEvent.VK_DOWN);
					Thread.sleep(500);
					robot.keyRelease(KeyEvent.VK_DOWN);
					Thread.sleep(500);
					robot.keyPress(KeyEvent.VK_ENTER);
					Thread.sleep(500);
					robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(7000);
					
					driver.findElement(By.xpath(Object.getProperty("Browse"))).click();
					Thread.sleep(2000);
					Process p = Runtime.getRuntime().exec("D:\\Magi\\AutoIt Proc\\BulkUploadETA.exe");
					Thread.sleep(2000);
					p.waitFor();
					Thread.sleep(3000);*/
					
					FileInputStream in = new FileInputStream(new File("D:\\workspace\\TMP\\DownloadExcel\\EquipmentTerminalTemplateUpload.xlsx"));
					Workbook workbook = new XSSFWorkbook(in);
					Sheet sheet1 = workbook.getSheetAt(0);
					Row row = sheet1.getRow(0);
					System.out.println("last row: " +sheet1.getLastRowNum());
					System.out.println("Last cell: " +row.getLastCellNum());
					String[] celValue = new String[row.getLastCellNum()+1];
					for(int j=0;j<sheet1.getLastRowNum();j++)
					{
						for(int k=0;k<row.getLastCellNum();k++)
						{
							celValue[j] = sheet1.getRow(j).getCell(k).toString();
							System.out.println("Cell value: " +celValue[j]);							
						}						
					}
				/*	if(d[i][5].equalsIgnoreCase("upload"))
					{
						driver.findElement(By.xpath(Object.getProperty("BulkUploadBtn"))).click();
						Thread.sleep(7000);
						String a = t.alertWait();
						if(a.equalsIgnoreCase("Upload Successfully"))
						{
							System.out.println("File Uploaded Successfully");
							actRes = "File Uploaded Successfully";
							data.put(""+rc, new Object[]{d[i][0], sheet1, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 10 finished its execution*************************");
						}
						else
						{
							System.out.println("File is not uploaded successfully");
							actRes = "File is not uploaded successfully";
							data.put(""+rc, new Object[]{d[i][0], sheet1, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 10 finished its execution*************************");
						}
					}
					else if(d[i][5].equalsIgnoreCase("cancel"))
					{
						driver.findElement(By.xpath(Object.getProperty("Cancel"))).click();
						System.out.println("File Uploaded is Cancelled Successfully");
						actRes = "File Uploaded is Cancelled Successfully";
						data.put(""+rc, new Object[]{d[i][0], sheet1, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
						rc++;
						s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
						System.out.println("*********************TestCase 10 finished its execution*************************");
					}
					else
					{
						System.out.println("File is not uploaded successfully");
						actRes = "File is not uploaded successfully";
						data.put(""+rc, new Object[]{d[i][0], sheet1, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
						rc++;
						s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
						System.out.println("*********************TestCase 10 finished its execution*************************");
					}*/
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		t.logout();
		return data;
	}
}
