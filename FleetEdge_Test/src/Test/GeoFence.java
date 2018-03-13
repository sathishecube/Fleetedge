package Test;


import java.awt.RenderingHints.Key;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.LocaleUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.event.MouseEvent;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import FleetEdge_Core.Core;
import FleetEdge_Util.*;


public class GeoFence extends Core
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]>GeoFencecases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase)
	{
		String acop =null;
		String[][] d2 = s.Read(path, sheet);
		ExtentTest node = reports.startTest(sheet);
		try
		{
			Util.set();
//			driver = new FirefoxDriver(t.excel());
			driver = new FirefoxDriver();
			driver.get(Object.getProperty("URL"));
			t.dologin(driver ,d2[0][2], d2[0][3]);
			Thread.sleep(50000);
			while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
			{
				System.out.println("Inside");
				Thread.sleep(1000);	
			}
			Thread.sleep(3000);
			long stime=System.currentTimeMillis();
				for(int i=scase-1;i<ecase;i++ )
				{	
					//Status Verify
					if(d2[i][0].equalsIgnoreCase("TC1"))
					{	
						try
						{
							System.out.println( "###################Test case 1 is executing############################");
							if(!(t.isElementPresentcheck(By.xpath(Object.getProperty("Fleet")), driver))||!(t.isElementPresentcheck(By.xpath(Object.getProperty("Setup")), driver))||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("Admin")), driver))||!(t.isElementPresentcheck(By.xpath(Object.getProperty("Support")), driver))||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("Uname")), driver))||!(t.isElementPresentcheck(By.xpath(Object.getProperty("Map")), driver))||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("Map1")), driver))||!(t.isElementPresentcheck(By.xpath(Object.getProperty("Satllite")), driver))||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("Zoom")), driver))||!(t.isElementPresentcheck(By.xpath(Object.getProperty("ZoomIn")), driver))||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("ZoomOut")), driver))||!(t.isElementPresentcheck(By.xpath(Object.getProperty("SelectCompany")), driver))||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("Searialsearch")), driver))||!(t.isElementPresentcheck(By.xpath(Object.getProperty("Allin")), driver))||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("ClearFilter")), driver))||!(t.isElementPresentcheck(By.xpath(Object.getProperty("Highlight")), driver))||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("Savetofavorite")), driver))||!(t.isElementPresentcheck(By.xpath(Object.getProperty("Columns")), driver))||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("Download")), driver))||!(t.isElementPresentcheck(By.xpath(Object.getProperty("Subscription")), driver))||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("TermsofUse")), driver))||!(t.isElementPresentcheck(By.xpath(Object.getProperty("Privacy")), driver))||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("GotoPage")), driver))||!(t.isElementPresentcheck(By.xpath(Object.getProperty("Show")), driver))||
									!(t.isElementPresentcheck(By.xpath(Object.getProperty("Dashboard")), driver)))
							{
								System.out.println("Page not loaded Successfully");
								acop = "Fleet Status Page not Loaded Successfully";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 1 execution completed############################");
							}
							else
							{
								System.out.println("Page loaded Successfully");
								acop = "Fleet Status Page Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 1 execution completed############################");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					
					
					//Geo Fence Navigation.
					if(d2[i][0].equalsIgnoreCase("TC2"))
					{
						try
						{
							System.out.println( "###################Test case 2 is executing############################");
							Actions action = new Actions(driver);
							WebElement Fleet=driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[1]/table/tbody/tr/td[2]/div/div/ul/li[2]/a"));	
							action.moveToElement(Fleet);
							action.click().perform();
							Thread.sleep(1000);
							driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[1]/table/tbody/tr/td[2]/div/div/ul/li[2]/div/div/ul/li[1]/a")).click();
							Thread.sleep(10000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(10000);
							String d=driver.findElement(By.xpath(".//*[@id='lblMenuPath2']")).getText();
							System.out.println(d);
							if(d.equalsIgnoreCase("TEREX MATERIALS PROC • GEO-LOCATION") && t.isElementPresentcheck(By.xpath(Object.getProperty("MapSetting")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("FleetSetting")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("NewButton")), driver) 
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("EditButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EmailAddButton")), driver) 
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("DeleteButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HistoryButton")), driver) 
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("FenceNameSearchBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("FenceNameTable")), driver))
							{
								System.out.println("Page loaded Successfully");
								acop = "Geo Fence Page Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 2 execution completed############################");
							}
							else
							{
								System.out.println("Page not loaded Successfully");
								acop = "Geo Fence Page not Loaded Successfully";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 2 execution completed############################");
							}
				
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					
					//New Fence Creation
					if(d2[i][0].equalsIgnoreCase("TC3"))
					{
						try
						{
					//		AddFilter.pageNavigater();
							String fenceName=d2[2][3];
							String Str=d2[2][4].toString();
							String[] fleetName=Str.split(",");
							String sDate=t.date(d2[2][5]);
							String eDate=t.date(d2[2][6]);
					//		System.out.println("Start " +sDate);
					//		System.out.println("End "+eDate);
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("NewButton"))).click();
							Thread.sleep(3000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("NewFenceDialogueBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("NewFenceTextBox")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("CreateFenceButton")), driver))
							{
								System.out.println("New Fence");
								driver.findElement(By.xpath(Object.getProperty("NewFenceTextBox"))).clear();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("NewFenceTextBox"))).sendKeys(fenceName);
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("CreateFenceButton"))).click();
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("Inside");
									Thread.sleep(1000);	
								}
								Thread.sleep(5000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("Inside");
									Thread.sleep(1000);	
								}
								Thread.sleep(5000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("FenceNameSearchBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("FenceNameTable")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("FenceSaveButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("FenceCancelButton")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("MapSetting")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("FleetSetting")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("GeoZoomIn")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("GeoZoomOut")), driver) 
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("StopDrawing")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("DrawCircle")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("DrawShape")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("DrawRectangle")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("LocationSearchBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("FillColor")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("GeoMap")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("GeoSatellite")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("AssignedFleet")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UnAssignedFleet")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("AssignButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UnAssignButton")), driver))
								{
									System.out.println("Edit Page passed.");
									//Assigned DashBoard and UnAssigned Verify
									if(t.isElementPresentcheck(By.xpath(Object.getProperty("AssignedSelectAll")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AssignedEqupId")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("AssignedSerialNo")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AssignedOwner")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("AssignedInOut")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AssignedStartOn")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("AssignedEndOn")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UnAssignedSearchBox")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("UnAssignedDropDown")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UnAssignedSearchButton")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("UnAssignedClearbutton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UnAssignedSelectAll")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("UnAssignedEquipId")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UnAssignedSerialNo")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("UnAssignedOwner")), driver))
									{
										System.out.println("Assigned and Unassigned Dashboard Passed.");
										WebElement type=driver.findElement(By.xpath("//*[@id='drpEquipment']"));
										List<WebElement> Type=type.findElements(By.tagName("option"));
										for(int k=1;k<fleetName.length;k++)
										{
											for(WebElement text : Type)
											{
												if(fleetName[0].equalsIgnoreCase(text.getText()))
												{
													System.out.println(text.getText());
													text.click();
													Thread.sleep(2000);
													driver.findElement(By.xpath(Object.getProperty("UnAssignedSearchBox"))).clear();
													Thread.sleep(2000);
													driver.findElement(By.xpath(Object.getProperty("UnAssignedSearchBox"))).sendKeys(fleetName[k]);
													Thread.sleep(2000);
													driver.findElement(By.xpath(Object.getProperty("UnAssignedSearchButton"))).click();
													Thread.sleep(2000);
													while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
													{
														System.out.println("Inside");
														Thread.sleep(1000);	
													}
													Thread.sleep(5000);
													driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/table/tbody/tr[2]/td[3]/div/div/fieldset/div/div[4]/div[2]/table/tbody/tr/td[1]/input")).click();
													while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
													{
														System.out.println("Inside");
														Thread.sleep(1000);	
													}
													Thread.sleep(5000);
													driver.findElement(By.xpath(Object.getProperty("AssignButton"))).click();
													Thread.sleep(3000);
													if(t.isElementPresentcheck(By.xpath(Object.getProperty("GeoCustomDateDialogueBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("GeoStartDate")), driver)
															&& t.isElementPresentcheck(By.xpath(Object.getProperty("GeoEndDate")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("GeoDateOKButton")), driver))
													{
														System.out.println("Date Passed SuccessFully");
														driver.findElement(By.xpath(Object.getProperty("GeoStartDate"))).clear();
														Thread.sleep(2000);
														driver.findElement(By.xpath(Object.getProperty("GeoStartDate"))).sendKeys(sDate);
														Thread.sleep(2000);
														driver.findElement(By.xpath(Object.getProperty("GeoEndDate"))).clear();
														Thread.sleep(2000);
														driver.findElement(By.xpath(Object.getProperty("GeoEndDate"))).sendKeys(eDate);
														Thread.sleep(2000);
													//	driver.findElement(By.xpath(Object.getProperty("GeoCustomDateDialogueBox"))).click();
														driver.findElement(By.xpath("//*[@id='MainContainer_lblEndDate']")).click();
														Thread.sleep(2000);
														driver.findElement(By.xpath(Object.getProperty("GeoDateOKButton"))).click();
														Thread.sleep(3000);
										                Actions builder = new Actions(driver);
													}
													else
													{
														System.out.println("Date Missing");
													}
												}
											}
										}
									}
									else
									{
										System.out.println("Some Element Missing at the Assigend Dashboard");
									}
								}
								else
								{
									System.out.println("Some Element Missing in the Edit Page.");
								}
								
							}
							else
							{
								System.out.println("New Fence Fail");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					
					//Edit 
					if(d2[i][0].equalsIgnoreCase("TC4"))
					{
						
					} 
					
					
					
					if(d2[i][0].equalsIgnoreCase("TC5"))
					{
					
						try
						{
					//		AddFilter.pageNavigater();
							String val=d2[4][4];
							int flag=0;
							WebElement table=driver.findElement(By.xpath("//*[@id='tblFenceName']"));
							System.out.println(table.getTagName());
							List<WebElement>Table=table.findElements(By.tagName("tr"));
							System.out.println("table : "+Table.size());
							for(WebElement text : Table)
							{
								System.out.println(text.getText());
								String Text=text.getText();
								Text.substring(0, val.length());
								String chk=Text.substring(0, val.length());
								System.out.println("Text : "+chk);
								if(val.equalsIgnoreCase(chk))
								{	
									text.click();
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("DeleteButton"))).click();
									Thread.sleep(1000);
									if(t.isAlertPresent(driver))
									{
										System.out.println("Alert");
										driver.switchTo().alert().accept();
										Thread.sleep(3000);
										if(t.isAlertPresent(driver))
										{
											driver.switchTo().alert().accept();
										}
										Thread.sleep(6000);
										if(t.isAlertPresent(driver))
										{
											System.out.println("Alert 2");
											driver.switchTo().alert().accept();
										}
									}
									else
									{
										acop = "Its not pop the alert, Do you want to delete the selected fence?";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 5 execution completed############################");
									}
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(10000);
									if(t.isAlertPresent(driver))
									{
										driver.switchTo().alert().accept();
									}
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(10000);
									WebElement table1=driver.findElement(By.xpath("//*[@id='tblFenceName']"));
									List<WebElement>Table1=table1.findElements(By.tagName("tr"));
									System.out.println("table : "+Table1.size());
									Thread.sleep(3000);
									for(WebElement text1 : Table1)
									{
										String Text1=text1.getText();
										Text1.substring(0, val.length());
										System.out.println("Text : "+Text1);
										if(val.equalsIgnoreCase(Text1))
										{
											System.out.println("Fail");
											acop = "Delete Button Not working as Expcted.";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 3 execution completed############################");
											break;
										}
										else
										{
											flag=1;
										}
									}
									if(flag==1)
									{
										System.out.println("Pass");
										acop = "The Fence "+val+"Removed Succesfully.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 5 execution completed############################");
									}
									break;
								}
							}
								
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					
					
					if(d2[i][0].equalsIgnoreCase("TC6"))
					{
						try
						{
						//	AddFilter.pageNavigater();
							String val=d2[5][4].toString();
							String[] array=val.split(",");
							int flag=0;
							Thread.sleep(3000);
							WebElement table=driver.findElement(By.xpath("//*[@id='tblFenceName']"));
							System.out.println(table.getTagName());
							List<WebElement>Table=table.findElements(By.tagName("tr"));
							System.out.println("table : "+Table.size());
							for(WebElement text : Table)
							{
								if(val.equalsIgnoreCase(text.getText()))
								{
									text.click();
								}
							}
							driver.findElement(By.xpath(Object.getProperty("HistoryButton"))).click();
							Thread.sleep(6000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("GeoFenceHistroyTab")), driver))
							{
								WebElement fence=driver.findElement(By.xpath(Object.getProperty("GeoFenceNameHistory")));
								List<WebElement> fenceName=fence.findElements(By.tagName("th"));
								System.out.println("Fence Name  :" +fenceName.get(0).getText());
								if(fenceName.get(0).getText().equalsIgnoreCase(array[0]) && t.isElementPresentcheck(By.xpath(Object.getProperty("GeoHistroyMap")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("GeoHistoryClossbutton")), driver))
								{
									System.out.println("It Displaying the Selected Fence is History");
									WebElement equpment=driver.findElement(By.xpath(Object.getProperty("GeoFenceEquipmentList")));
									List<WebElement> equpmentList=equpment.findElements(By.tagName("th"));
									//int n=1;
									for(int k=0;k<equpmentList.size();k++)
									{
										System.out.println("Val : "+array[k+1]);
										if(equpmentList.get(k).getText().equalsIgnoreCase(array[k+1]))
										{
											System.out.println("Array : "+array[k+1]);
											flag=1;
										}
										else
										{
											System.out.println(array[k+1]+" Element Missing In History Table. ");
											acop = array[k+1]+" Element Missing In History Table. ";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 6 execution completed############################");
											break;
										}
									}
									if(flag==1)
									{
										System.out.println("All is Passed");
										acop = "Geo History Button Working as Expected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 6 execution completed############################");
									}
									
								}
								else
								{
									System.out.println("Its Displaying none selected Fence or Some Element Missing.");
									acop = "Some Element Missing in History Tap";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 6 execution completed############################");
								}
								Thread.sleep(3000);
								driver.findElement(By.xpath(Object.getProperty("GeoHistoryClossbutton"))).click();
								Thread.sleep(3000);
							}
							else
							{
								System.out.println("Histroy Button Not Working");
								acop = "History Button Not Working as Expected.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 6 execution completed############################");
							}
								
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					
					
					
					//Fence Name Search
					
					if(d2[i][0].equalsIgnoreCase("TC7"))
					{
						try
						{
							AddFilter.pageNavigater();
							Thread.sleep(5000);
							String fenceName=d2[6][4];
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("FenceNameSearchBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("FenceNameTable")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("FenceNameClearButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("FenceNameSearchButton")), driver))
							
								{
									driver.findElement(By.xpath(Object.getProperty("FenceNameSearchBox"))).sendKeys(fenceName);
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("FenceNameSearchButton"))).click();
									Thread.sleep(3000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(5000);
									WebElement table=driver.findElement(By.xpath(Object.getProperty("FenceNameTable")));
									String tableName=table.findElement(By.tagName("td")).getText();
									System.out.println("Table Name : "+tableName);
									String chk=tableName.substring(0, fenceName.length());
									System.out.println("Text : "+chk);
									if(chk.equalsIgnoreCase(fenceName))
									{
										System.out.println("Fence Name Search Working as Expected.");
										acop = "Fence Name Button Working as Expected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 7 execution completed############################");
										driver.findElement(By.xpath(Object.getProperty("FenceNameClearButton"))).click();
										Thread.sleep(3000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(5000);
										String clearVal=driver.findElement(By.xpath(Object.getProperty("FenceNameSearchBox"))).getText();
										System.out.println("Search box Value : "+clearVal);
										if(clearVal.equalsIgnoreCase(fenceName))
										{
											System.out.println("Clear Fail");
											acop = "Clear Button Not Working as Expected.";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 7 execution completed############################");
										}
										else
										{
											System.out.println("Clear pass");
											acop = "Clear Button Working as Expected.";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
											rc++;
											s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Pass" );
											System.out.println( "###################Test case 7 execution completed############################");
										}
									}
									else
									{	
										System.out.println("Fence Name Searching Fail");
										acop = "Unable to search the fence Name.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case7 execution completed############################");
									}
								}
							else
							{
								System.out.println("Some Element Missing in Fence Name Search Table");
								acop = "Some Element Missing in Fence Name Search Table";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case7 execution completed############################");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					
					//Add Email Button
					if(d2[i][0].equalsIgnoreCase("TC8"))
					{
						try
						{
							AddFilter.pageNavigater();
							Thread.sleep(5000);
							String fenceName=d2[7][3].toString();
							String [] val=fenceName.split(",");
							String str=d2[7][4].toString();
							String[] excelTable=str.split(",");
							String str1=d2[7][2];
							String []addMail=str1.split(",");
							int flag=0;
							System.out.println("XY : "+driver.findElement(By.xpath("//*[@id='tblNotificationList']/tbody/tr/td[1]")).getText());
							driver.findElement(By.xpath(Object.getProperty("FenceNameSearchBox"))).sendKeys(val[0]);
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("FenceNameSearchButton"))).click();
							Thread.sleep(3000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("EmailAddButton"))).click();
							Thread.sleep(3000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("GeoAddEmailDialogueBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("GeoUserNameSearchType")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("GeoAddEmailSearchBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("GeoADDEmailSearchButton")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("GeoADDEmailClearButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("GeoSelectButton")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("GeoCancelButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("GeoSendEmailCheckBox")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("GeoSendSMSCheckbox")), driver))								
							{
								WebElement table=driver.findElement(By.xpath(Object.getProperty("GeoEmailADDTabel")));
								List<WebElement> tableList=table.findElements(By.tagName("th"));
								for(int k=0;k<excelTable.length;k++)
								{
							//		System.out.println(tableList.get(k).getText());
									String text=tableList.get(k).getText();
									if(excelTable[k].equalsIgnoreCase(text))
									{
										WebElement type=driver.findElement(By.xpath(Object.getProperty("GeoUserNameSearchType")));
										List<WebElement>typeList=type.findElements(By.tagName("option"));
										for(WebElement text1 : typeList)
										{
											if(val[1].equalsIgnoreCase(text1.getText()))
											{
												text1.click();
												driver.findElement(By.xpath(Object.getProperty("GeoAddEmailSearchBox"))).sendKeys(val[2]);
												Thread.sleep(3000);
												driver.findElement(By.xpath(Object.getProperty("GeoADDEmailSearchButton"))).click();
												Thread.sleep(3000);
												while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
												{
													System.out.println("inside while");
													Thread.sleep(1000);
												}
												Thread.sleep(5000);
												String tableVal = null;
												if(val[1].equalsIgnoreCase("Name"))
												{
													tableVal=driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/div")).getText();
												//	System.out.println("Name ; "+tableVal);
												}
												else if(val[1].equalsIgnoreCase("Email Id"))
												{
													tableVal=driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[2]/td/div/table/tbody/tr/td[3]/div")).getText();
												//	System.out.println("Email Id ; "+tableVal);
												}
												if(val[2].equalsIgnoreCase(tableVal))
												{
													driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[2]/td/div/table/tbody/tr/td[4]/div/input")).click();
													Thread.sleep(3000);
													driver.findElement(By.xpath("/html/body/div[2]/div[2]/table/tbody/tr[2]/td/div/table/tbody/tr/td[5]/div/input")).click();
													Thread.sleep(3000);
													driver.findElement(By.xpath(Object.getProperty("GeoSelectButton"))).click();
													Thread.sleep(5000);
													if(t.isAlertPresent(driver))
													{
														driver.switchTo().alert().accept();
													}
													else
													{
														System.out.println("No Alert popups");
														acop = "Its not popup any alert.";
														node.log(LogStatus.FAIL, acop);
														data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
														rc++;
														String scr = t.CaptureScreenshot();
														s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Fail" );
														System.out.println( "###################Test case 8 execution completed############################");
													}
													Thread.sleep(5000);
													if(t.isAlertPresent(driver))
													{
														driver.switchTo().alert().accept();
													}
													Thread.sleep(1000);
													while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
													{
														System.out.println("inside while");
														Thread.sleep(1000);
													}
													Thread.sleep(5000);
													WebElement mail=driver.findElement(By.xpath("//*[@id='tblNotificationList']/tbody/tr"));
													List<WebElement>mailList=mail.findElements(By.tagName("td"));
													for(int n=0;n<addMail.length;n++)
													{														
														String m=mailList.get(n).getText();
														System.out.println("MaiL List : "+m);
														System.out.println("Excel List : "+addMail[n]);
														if(m.equalsIgnoreCase(addMail[n]))
														{
															System.out.println("Total Pass");
															flag=1;
														}
														else
														{
															acop = "Its not Saving Selected Notification requirment.";
															node.log(LogStatus.FAIL, acop);
															data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
															rc++;
															String scr = t.CaptureScreenshot();
															s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Fail" );
															System.out.println( "###################Test case 8 execution completed############################");
															break;
														}
													}
													
													if(flag==1)
													{
														acop = "Table Created and Added Notification Setup SuccesFully.";
														node.log(LogStatus.PASS, acop);
														data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
														rc++;
														s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Pass" );
														System.out.println( "###################Test case 8 execution completed############################");
													}
												}
											}
										}
										break;
									}
									else
									{
										System.out.println(text+" Element Missing in the table");
										acop = text+"Element Missing in the table";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 8 execution completed############################");
									}
								}
								
							}
							else
							{
								System.out.println("Add Email Dialogue box dint displaying properly.");
								acop = "Add Email Dialogue box dint displaying properly.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 8 execution completed############################");
							}
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("EmailAddButton"))).click();
							Thread.sleep(3000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("GeoCancelButton"))).click();
							Thread.sleep(6000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("GeoAddEmailDialogueBox")), driver))
							{
								System.out.println("Cancel Fail");
								acop = "Cancel Button is not working as Expected.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 8 execution completed############################");
							}
							else
							{
								System.out.println("Cancel pass");
								acop = "Table Cancel Working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "GeoFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "GeoFence", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 8 execution completed############################");
							}
							
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					
					
					Thread.sleep(10000);
					
				}						
		}
						
		catch(Exception e)
		{
			e.printStackTrace();
		}
		driver.quit();
		reports.endTest(node);
		reports.flush();
		return data;
	}
}
