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

public class FleetStatus extends Core
{
	static Util t=new Util();
	
//	public void test()
	@Test
	public static Map<String, Object[]>Fleetstatuscases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase)
	{
		String acop =null;
		String[][] d2 = s.Read(path, sheet);
		ExtentTest node = reports.startTest(sheet);
		int counter =1;
		try {
			Util.set();
//			driver = new FirefoxDriver(t.excel());
			driver = new FirefoxDriver();
			driver.get(Object.getProperty("URL"));
			t.dologin(driver ,d2[0][2], d2[0][3]);
			Thread.sleep(25000);
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
								data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 1 execution completed############################");
							}
							else
							{
								System.out.println("Page loaded Successfully");
								acop = "Fleet Status Page Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
								rc++;
								 s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 1 execution completed############################");
							}
						}catch(Exception e)
						{e.printStackTrace();}
					}
					
						//Company Changing
						if(d2[i][0].equalsIgnoreCase("TC2"))
						{
						try
						{
							System.out.println( "###################Test case 2 is executing############################");
							driver.findElement(By.xpath(Object.getProperty("Comapanysearch"))).clear();
							Thread.sleep(5000);	
							String Company =d2[1][4];
							WebElement ele = driver.findElement(By.xpath(Object.getProperty("Comapanysearch")));
							ele.sendKeys(Company);
							Thread.sleep(2000);
							WebElement select = driver.findElement(By.id("ui-id-1"));
							List<WebElement> options = select.findElements(By.className("divBold"));
							System.out.println(options.size());
							for (WebElement option : options) 
							{	 	  
								System.out.println(option.getText());
								if(option.getText().equals("Company : "+Company))            
									option.click();   
							 }
							System.out.println("Navigate to other Company");
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("Inside");
								Thread.sleep(1000);	
							}
							Thread.sleep(3000);
							String Chk=driver.findElement(By.xpath(".//*[@id='lblMenuPath2']")).getText();
							if(Chk.equalsIgnoreCase(Company+" • FLEET • FLEET STATUS"))
							{
								System.out.println("Page loaded Successfully");
								acop = "Company Changing is working as expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
								rc++;
								 s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 2 execution completed############################");	
									
								}
								else
								{
									System.out.println("Page not loaded Successfully");
									acop = "Company Changing is not working as expected.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );	
								}
							//Status Verify
							Thread.sleep(5000);
							System.out.println( "###################Test case 2 is executing############################");
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
								data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 2 execution completed############################");
							}
							else
							{
								System.out.println("Page loaded Successfully");
								acop = "Fleet Status Page Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 2 execution completed############################");
							}
							Thread.sleep(5000);						
							driver.findElement(By.xpath(".//*[@id='txtCompanyAutoComplete']")).clear();
							Thread.sleep(5000);	
							WebElement ele1 = driver.findElement(By.xpath(".//*[@id='txtCompanyAutoComplete']"));
							ele1.sendKeys("mat");
							Thread.sleep(2000);

							WebElement select1 = driver.findElement(By.id("ui-id-1"));
							  List<WebElement> options1 = select1.findElements(By.className("divBold"));
							  System.out.println(options1.size());
							for (WebElement option : options1) 
							{	 	  
							  if(option.getText().equals("Company : Terex Materials Proc"))            
							           option.click();   
							 }
							System.out.println("Navigate to other Company");
							Thread.sleep(10000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("Inside");
								Thread.sleep(1000);	
							}
							Thread.sleep(3000);	
							System.out.println("Search Failed ... No data Found ");
							if(t.isAlertPresent(driver))
							{
								driver.switchTo().alert().accept();
							}
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						}
						
			
						
						// Filter
						if(d2[i][0].equalsIgnoreCase("TC3"))
						{
							try
							{  
								System.out.println( "###################Test case 3 is executing############################");
								Thread.sleep(5000);
								String s1=d2[2][4].toString();
								System.out.println(s);
								String[] array=s1.split(",");
								for(int j=0;j<array.length;j++)
								{
								if(array[j].equalsIgnoreCase("Add New Filter"))
								{
								driver.findElement(By.xpath(Object.getProperty("All"))).click();
								Thread.sleep(1000);
								Select dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("All"))));
								dropdown.selectByVisibleText(array[j]);
								Thread.sleep(5000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("AddTable")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ADDButton")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("CloseButton")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("AddNewFilterValue")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SaveAsNewFilter")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("FilterCondition")), driver)&& t.isElementPresentcheck(By.xpath(Object.getProperty("FilterInput")), driver))
									
								{
									System.out.println("Page loaded Successfully");
									acop = "Add New Filter Loaded Successfully";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
								else
								{

									System.out.println("Page not loaded Successfully");
									acop = "Add New Filter not Loaded Successfully";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
																	 s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("CloseButton"))).click();;
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("ClearFilter"))).click();
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								}
								
								//Favorite
								System.out.println( "###################Test case 3 is executing############################");
								Thread.sleep(5000);
								if(array[j].equalsIgnoreCase("Favorite"))
								{
								driver.findElement(By.xpath(Object.getProperty("All"))).click();
								Thread.sleep(1000);
								Select dropdown1 = new Select(driver.findElement(By.xpath(Object.getProperty("All"))));
								dropdown1.selectByVisibleText(array[j]);
								Thread.sleep(5000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
								String b=driver.findElement(By.xpath(".//*[@id='spnFilterTextPlaceHolder']/span/span")).getText();
								if(b.equalsIgnoreCase("Search result for 'Favorite'"))
								{
									System.out.println("Page loaded Successfully");
									acop = "Favorite Filter Loaded Successfully";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
								else
								{
									System.out.println("Page not loaded Successfully");
									acop = "Favorite Filter not Loaded Successfully";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									 s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("ClearFilter"))).click();
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								}
								
								// Delete Filter
								System.out.println( "###################Test case 3 is executing############################");
								if(array[j].equalsIgnoreCase("Delete Filter"))							
								{
									driver.findElement(By.xpath(Object.getProperty("All"))).click();
									Thread.sleep(1000);
									Select dropdown1 = new Select(driver.findElement(By.xpath(Object.getProperty("All"))));
									dropdown1.selectByVisibleText(array[j]);
									Thread.sleep(5000);
									if(t.isElementPresentcheck(By.xpath(Object.getProperty("DeleteFilterTable")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("DeleteFilterClose")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("DeleteFilterHeader1")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("DeleteFilterHeader2")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("DeleteFilterDefaultFavorite")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("DeleteFilterDefaultFavoriteDeleteButton")), driver))	
									{
										System.out.println("Page loaded Successfully");
										acop = "Delete Filter Loaded Successfully";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 3 execution completed############################");
									}
									else
									{
										System.out.println("Page not loaded Successfully");
										acop = "Delete Filter not Loaded Successfully";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 3 execution completed############################");
									}
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("DeleteFilterClose"))).click();
									Thread.sleep(5000);
									driver.findElement(By.xpath(Object.getProperty("ClearFilter"))).click();
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
								}
								
								}
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						
						
						//Clear Filter
						if(d2[i][0].equalsIgnoreCase("TC4"))
						{
							try
							{
								System.out.println( "###################Test case 4 is executing############################");
								Thread.sleep(5000);
								String s1=d2[3][4].toString();
								String[] array=s1.split(",");
								String d=driver.findElement(By.xpath(".//*[@id='divPaging']/div[1]/span")).getText();
								for(int j=0;j<array.length;j++)
								{
								if(array[j].equalsIgnoreCase("Favorite"))
								{
									driver.findElement(By.xpath(Object.getProperty("All"))).click();
									Thread.sleep(1000);
									Select dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("All"))));
									dropdown.selectByVisibleText(array[j]);
									Thread.sleep(5000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("ClearFilter"))).click();
									if(t.isElementEnabledcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(3000);
										String d1=driver.findElement(By.xpath(".//*[@id='divPaging']/div[1]/span")).getText();
										if(d.equalsIgnoreCase(d1))
										{
											System.out.println("Page loaded Successfully");
											acop = "Clear Filter Working as Expected";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
											rc++;
											s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
											System.out.println( "###################Test case 4 execution completed############################");
										}
										else
										{
											System.out.println("Page not loaded Successfully");
											acop = "Clear Filter not working as Expected. Its Still Now to Stay in the "+array[j];
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
																			 s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 4 execution completed############################");
										}
									}
									else
									{
										System.out.println("Page not loaded Successfully");
										acop = "Clear Filter not working  as Expected";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
																		 s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 4 execution completed############################");
									}
								}
								}
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						
						//Save To Favorite
						if(d2[i][0].equalsIgnoreCase("TC5"))
						{
							System.out.println( "###################Test case 5 is executing############################");
							String l=d2[4][4];
							int n = Integer.parseInt(l),c=0;
							for( c=0;c<n;c++)
							{
								driver.findElement(By.xpath(".//*[@id='EquipmentId_"+c+"']/input")).click();
								Thread.sleep(200);
							}
							String s1=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportFreeze']")).getAttribute("totalrows");
							System.out.println("Total Records :"+s1);	
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("Savetofavorite"))).click();
							Thread.sleep(5000);
							
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							if(t.isAlertPresent(driver))
							{
								driver.switchTo().alert().accept();
								System.out.println("Page loaded Successfully");
								acop = "Alert Message Popups.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 5 execution completed############################");
								
							}
							else
							{
								System.out.println("Page not loaded Successfully");
								acop = "Alert Message not popus";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
																 s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("All"))).click();
							Thread.sleep(1000);
							Select dropdown1 = new Select(driver.findElement(By.xpath(Object.getProperty("All"))));
							dropdown1.selectByVisibleText("Favorite");
							Thread.sleep(5000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
							String s2=	driver.findElement(By.id("tblFleetStatusReportFreeze")).getAttribute("totalrows");
						//	System.out.println("Total Records"+s1);	
							System.out.println( "###################Test case 5 is executing############################");
							if(s1.equalsIgnoreCase(s2))
							{
								System.out.println("Page not loaded Successfully");
								acop = "Save TO Favorite not Working as Expected.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
																 s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
							else
							{
								System.out.println("Page loaded Successfully");
								acop = "Save TO Favorite Working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
							driver.findElement(By.xpath(Object.getProperty("ClearFilter"))).click();
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(3000);
						}
						
						//Asset  Details Selection
						if(d2[i][0].equalsIgnoreCase("TC6"))
						{
							try
							{
								System.out.println( "###################Test case 6 is executing############################");
								String Asset=d2[5][4];
								WebElement ele = driver.findElement(By.xpath(Object.getProperty("Searialsearch")));
								ele.clear();
								ele.sendKeys(Asset);
								Thread.sleep(2000);
								WebElement select = driver.findElement(By.id("ui-id-2"));
								List<WebElement> options = select.findElements(By.className("ui-corner-all"));
								System.out.println(options.size());
								for (WebElement option : options) 
								{	 	  
									System.out.println(option.getText());
									if(option.getText().equals(Asset))            
									{
										option.click();
									}
								}
								Thread.sleep(5000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("FullDetails")), driver)&&t.isElementPresentcheck(By.xpath(Object.getProperty("Directions")), driver))
								{
									System.out.println("Asset Selected.");
									driver.findElement(By.partialLinkText(Asset)).click();
									Thread.sleep(5000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(5000);
									String Chk=driver.findElement(By.xpath(".//*[@id='lblMenuPath2']")).getText();
									if(Chk.equalsIgnoreCase("Terex Materials Proc • Details • "+Asset))
									{
										System.out.println("Page loaded Successfully");
										acop = "It Can able to Select the Asset and loading the Asset Details Page.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 6 execution completed############################");								}
									else
									{
										System.out.println("Page not loaded Successfully");
										acop = "It Cant able to Select the Asset and not loading the Asset Details Page.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 6 execution completed############################");							
									}
									Thread.sleep(1000);
									Actions action = new Actions(driver);
									WebElement Fleet=driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]"));	
									action.moveToElement(Fleet);
									action.click().perform();
									Thread.sleep(1000);
									driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/div/div[1]/ul/li[1]/a")).click();
									Thread.sleep(3000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(5000);
									}
								}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						
						// Asset Search Box
						if(d2[i][0].equalsIgnoreCase("TC7"))	
						{
							try
							{
								System.out.println( "###################Test case 7 is executing############################");
								Thread.sleep(10000);
								String Asset=d2[6][4];
								WebElement ele = driver.findElement(By.xpath(Object.getProperty("Searialsearch")));
								ele.clear();
								ele.sendKeys(Asset);
								Thread.sleep(2000);
								WebElement select = driver.findElement(By.id("ui-id-2"));
								List<WebElement> options = select.findElements(By.className("ui-corner-all"));
								System.out.println(options.size());
								for(WebElement option : options) 
								{	 	  
									System.out.println(option.getText());
									if(option.getText().equals(Asset))
									{
										option.click();
									}
								}
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("FullDetails")), driver)&&t.isElementPresentcheck(By.xpath(Object.getProperty("Directions")), driver))
								{
									Thread.sleep(1000);
									String Serial=driver.findElement(By.xpath(".//*[@id='spnFilterTextPlaceHolder']/span/span")).getText();
									System.out.println(Serial);
									if(Serial.equalsIgnoreCase("Search result for 'SERIAL NO. Contains "+Asset+"',"))
									{
										System.out.println("Page loaded Successfully");
										acop = "Entered Asset Serial No by Selected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 7 execution completed############################");		
									}
									else
									{
										System.out.println("Page not loaded Successfully");
										acop = "Unable to Search the Asset.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
																		 s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 7 execution completed############################");										}
								}
								else
								{
									System.out.println("Page not loaded Successfully");
									acop = "Unable to Search the Asset.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
																	 s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 7 execution completed############################");	
								}
								driver.findElement(By.xpath(Object.getProperty("ClearFilter"))).click();
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						
						//Page No of Records
						if(d2[i][0].equalsIgnoreCase("TC8"))	
						{
							try
							{
								System.out.println( "###################Test case 8 is executing############################");
								String page=d2[7][4];
								System.out.println("Excel"+page);
								Thread.sleep(5000);
								WebElement Pag=driver.findElement(By.xpath(".//*[@id='PagingText']"));
								List<WebElement> Page=Pag.findElements(By.tagName("a"));
								System.out.println("Size"+Page.size());
								for(int k=0;k<Page.size();k++)
								{
									System.out.println(Page.get(k).getText());
								}
								String s1=Page.get(	Page.size()-1).getText();
								if(Page.get(Page.size()-1).getText().equalsIgnoreCase("Next"))
								{
									System.out.println("Paging Text Loaded SuccessFully");
									if(page.isEmpty())
									{
										System.out.println("Page loaded Successfully");
										acop = "Page Navication Working as Expected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 8 execution completed############################");	
									}
									else
									{
										Thread.sleep(3000);
										driver.findElement(By.xpath(Object.getProperty("GotoPage"))).click();
										Thread.sleep(1000);
										Select dropdown=new Select(driver.findElement(By.xpath(Object.getProperty("GotoPage"))));
										dropdown.selectByValue(page);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(3000);
										Pag =driver.findElement(By.xpath(".//*[@id='goToPageNo']"));
										Page =Pag.findElements(By.tagName("option"));
										System.out.println(Page.size());
										for(int p=0;p<Page.size();p++)
										{
											if(Page.get(p).getText().equalsIgnoreCase(page))
											{
												if(Page.get(p).getAttribute("selected").equalsIgnoreCase("true"))
												{
													acop = "Selected Page Displayed as expected";
													node.log(LogStatus.PASS, acop);
													data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
													rc++;
													s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
													System.out.println( "###################Test case 8 execution completed1############################");
													break;
												}
												else
												{
													System.out.println("Current Page doesnot match the Page which is selected ");
													acop = "Pagination not displayed as expected";
													node.log(LogStatus.FAIL, acop);
													data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
													rc++;
													String scr = t.CaptureScreenshot();
													s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
													System.out.println( "###################Test case 8 execution completed############################");
													break;
												}
											}
										}	
										
									}
									
								}
								else
								{
									System.out.println("Pagination not Displayed ");
									acop = "Pagination not displayed as expected";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 8 execution completed############################");
								}
								driver.findElement(By.xpath(Object.getProperty("ClearFilter"))).click();
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						
						
						//Columns
						if(d2[i][0].equalsIgnoreCase("TC9"))	
						{
							try
							{
								System.out.println( "###################Test case 9 is executing############################");
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
								Thread.sleep(5000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnsReport")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ReportColumns")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("ReportAddButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("Up")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("Remove")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("Down")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnsSaveButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnsSaveAsNewReport")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnsDeleteButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnsCloseButton")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("SelectedReportColumns")), driver))
								{
									WebElement Head=driver.findElement(By.xpath(".//*[@id='drpRCSettingColumnList']"));
									List<WebElement> headers=Head.findElements(By.tagName("option"));
									WebElement s1 = driver.findElement(By.xpath(Object.getProperty("SelectedReportColumns")));
									List<WebElement> size=s1.findElements(By.tagName("option"));
									int k=size.size();
									System.out.println("K"+k);
									while(k<=75)
									{
										driver.findElement(By.xpath(Object.getProperty("ReportAddButton"))).click();
											Thread.sleep(200);
											k++;
									}
									Thread.sleep(1000);
									if(t.isAlertPresent(driver))
									{
										driver.switchTo().alert().accept();
										acop = "Report exceeds the maximum no. of columns(75) is this Alert popups.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 9 execution completed############################");
									}
									else
									{
										System.out.println("Pagination not Displayed ");
										acop = "Alert is not popups. ";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 9 execution completed############################");										
									}
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(5000);
										driver.findElement(By.xpath(Object.getProperty("ColumnsCloseButton"))).click();
										Thread.sleep(5000);
									}
								else
								{
									System.out.println("Pagination not Displayed ");
									acop = "Columns Button not displayed as expectet";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 9 execution completed############################");		
									}
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}
						}
						
						
						
						//Columns Modify
						if(d2[i][0].equalsIgnoreCase("TC10"))	
						{
							System.out.println( "###################Test case 10 is executing############################");
							try
							{	
								Thread.sleep(5000);
								String Str=d2[9][4].toString();
								String[] arry=Str.split(","); 
								for(int j=0;j<arry.length;j++)	
								{
									driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
									Thread.sleep(5000);
									if(t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnsReport")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ReportColumns")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("ReportAddButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("Up")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("Remove")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("Down")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnsSaveButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnsSaveAsNewReport")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnsDeleteButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnsCloseButton")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("SelectedReportColumns")), driver))
									{	
										driver.findElement(By.xpath(Object.getProperty("ReportColumns"))).click();
										WebElement web=driver.findElement(By.xpath(".//*[@id='drpRCSettingColumnList']"));
										List<WebElement> report=web.findElements(By.tagName("option"));
										for(int k=0;k<report.size();k++)
										{
											String Report1=report.get(k).getText();
											if(Report1.equalsIgnoreCase(arry[j]))
											{									
												driver.findElement(By.xpath(Object.getProperty("ReportColumns"))).click();
												String Report=report.get(k).getAttribute("value");
												Select dropdown=new Select(driver.findElement(By.xpath(Object.getProperty("ReportColumns"))));
												dropdown.selectByValue(Report);
												Thread.sleep(2000);
												driver.findElement(By.xpath(Object.getProperty("ReportAddButton"))).click();
												Thread.sleep(1000);
												WebElement web1=driver.findElement(By.xpath(Object.getProperty("SelectedReportColumns")));
												report=web1.findElements(By.tagName("option"));
												for(int w=report.size();w>1;)
												{
													driver.findElement(By.xpath(".//*[@id='drpRCSettingSelectedColumn']/option["+w+"]")).click();
													Thread.sleep(1000);
													for(int u=0;u<report.size()-2;u++)
														driver.findElement(By.xpath(Object.getProperty("Up"))).click();
														break;
												}
												Thread.sleep(1000);
												String c=driver.findElement(By.xpath(".//*[@id='drpRCSettingSelectedColumn']/option[2]")).getText();
												if(arry[j].equalsIgnoreCase(c))
												{
													driver.findElement(By.xpath(Object.getProperty("ColumnsSaveButton"))).click();
													while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
													{
														System.out.println("inside while");
														Thread.sleep(1000);
													}
													Thread.sleep(5000);
													String d=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']/th[2]")).getText();
													System.out.println(d);
													if(d.equalsIgnoreCase(arry[j]))
													{
														acop = "Column added and moved to up";
														node.log(LogStatus.PASS, acop);
														data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
														rc++;
														s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
														System.out.println( "###################Test case 10 execution completed1############################");
													}
													System.out.println("Selected Element is Moved up Successfully.");
												}
												else
												{
													System.out.println("Element Moving Up");
													acop = "Unable to move the selected Element to up.";
													node.log(LogStatus.FAIL, acop);
													data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
													rc++;
													String scr = t.CaptureScreenshot();
													s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
													System.out.println( "###################Test case 10 execution completed############################");		
												}
											
											//Move to Down
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
											Thread.sleep(5000);
											Thread.sleep(1000);
											driver.findElement(By.xpath(".//*[@id='drpRCSettingSelectedColumn']/option[2]")).click();
											Thread.sleep(1000);
											for(int u=0;u<5;u++)
											{
												driver.findElement(By.xpath(Object.getProperty("Down"))).click();
								
											}
											Thread.sleep(1000);
											String c1=driver.findElement(By.xpath(".//*[@id='drpRCSettingSelectedColumn']/option[7]")).getText();
											if(c1.equalsIgnoreCase(arry[j]))
											{
												driver.findElement(By.xpath(Object.getProperty("ColumnsSaveButton"))).click();
												while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
												{
													System.out.println("inside while");
													Thread.sleep(1000);
												}
												Thread.sleep(5000);
												String d=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']/th[7]")).getText();
												System.out.println(d);
												if(d.equalsIgnoreCase(arry[j]))
												{
													acop = "Column added and moved to Down";
													node.log(LogStatus.PASS, acop);
													data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
													rc++;
													s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
													System.out.println( "###################Test case 10 execution completed1############################");
												}
												else
												{
													System.out.println("Element Moving Down");
													acop = "Unable to move the selected Element to Down.";
													node.log(LogStatus.FAIL, acop);
													data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
													rc++;
													String scr = t.CaptureScreenshot();
													s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
													System.out.println( "###################Test case 10 execution completed############################");													
												}
											}
											else
											{
												System.out.println("Element Moving Down");
												acop = "Unable to move the selected Element to Down.";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 10 execution completed############################");
											}
											
											//Removing Column
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
											Thread.sleep(5000);
											driver.findElement(By.xpath(".//*[@id='drpRCSettingSelectedColumn']/option[7]")).click();
											Thread.sleep(1000);
											driver.findElement(By.xpath(Object.getProperty("Remove"))).click();
											Thread.sleep(1000);											
											driver.findElement(By.xpath(Object.getProperty("ColumnsSaveButton"))).click();
											while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
											{
												System.out.println("inside while");
												Thread.sleep(1000);
											}
											Thread.sleep(5000);
											String d=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']/th[7]")).getText();
											System.out.println(d);
											if(d.equalsIgnoreCase(arry[j]))
											{
												System.out.println("Column Removing");
												acop = "Unable to Remove the Selected Column.";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 10 execution completed############################");											
											}
											else
											{
												acop = "Column Reoved Successfully";
												node.log(LogStatus.PASS, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
												rc++;
												s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
												System.out.println( "###################Test case 10 execution completed1############################");										
											}
										}
									}
										Thread.sleep(5000);
								}
								else
								{
									System.out.println("Column Button not Working");
									acop = "Column Button not Working.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 10 execution completed############################");
								}
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					
						
						//Adding New Report Column
						if(d2[i][0].equalsIgnoreCase("TC11"))	
						{
							try
							{
								System.out.println( "###################Test case 11 is executing############################");
								String Str=d2[10][4].toString();
								String[] array=Str.split(",");
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
								Thread.sleep(5000);
								WebElement report=driver.findElement(By.xpath(Object.getProperty("SelectedReportColumns")));
								List<WebElement> Report=report.findElements(By.tagName("option"));
								for(int k=Report.size();k>1;k--)
								{
									driver.findElement(By.xpath(".//*[@id='drpRCSettingSelectedColumn']/option["+k+"]")).click();
									Thread.sleep(500);
									driver.findElement(By.xpath(Object.getProperty("Remove"))).click();
									Thread.sleep(500);
								}
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("ReportColumns"))).click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("ReportColumns"))).click();
								for(int j=0;j<array.length;j++)
								{
									if(t.isElementPresentcheck(By.xpath("html/body/div[2]"), driver))
									{
										Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='drpRCSettingColumnList']")));
										List<WebElement> allOptions = dropdown.getOptions();
										for (WebElement option : allOptions) 
										{	 	  
											if(option.getText().equals(array[j])) 
											{ 
												option.click(); 
												Thread.sleep(5000);
												driver.findElement(By.xpath(".//*[@id='btnAddRCSetting']")).click();
											}
										}
									}
								}
								//Verifying whether the column added is added successfully
								List<WebElement> ele =  driver.findElements(By.xpath(".//*[@id='drpRCSettingSelectedColumn']/option"));
								for(int j=0;j<array.length;j++)
								{
									for (WebElement option : ele) 
									{	 	  
										if(option.getText().equals(array[j]))
										{
											System.out.println(array[j]+" : Column added successfully");
										}
								}
								}
								driver.findElement(By.xpath(Object.getProperty("ColumnsSaveAsNewReport"))).click();
								Thread.sleep(3000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("SaveAsNewReort")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SaveAsNewReportCancel")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("SaveAsNewReportName")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SaveForDropdown")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("SaveAsNewReportSubmit")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SaveAsNewReportCloseButton")), driver))
									{
									Thread.sleep(1000);
									driver.findElement(By.xpath(Object.getProperty("SaveAsNewReportName"))).sendKeys(d2[10][2]);
									Thread.sleep(1000);
									Select select=new Select(driver.findElement(By.xpath(".//*[@id='MainContainer_drpUserType']")));
									List<WebElement> dropdown=select.getOptions();
									for(WebElement drop : dropdown)
									{
										if(drop.equals("d2[10][3]"))
										{
											drop.click();
											Thread.sleep(5000);
										}
									}
									Thread.sleep(1000);
									driver.findElement(By.xpath(Object.getProperty("SaveAsNewReportSubmit"))).click();
									Thread.sleep(5000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(3000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(5000);
									String d=driver.findElement(By.xpath(".//*[@id='lblMenuPath2']")).getText();
									if(d.equalsIgnoreCase("Terex Materials Proc • FLEET • FLEET STATUS"))
									{
										System.out.println("Report Created SuccessFully");
									}
									else
									{
										System.out.println("Unable to save the report");
										acop = "Unable to Save the Report";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 11 execution completed############################");
									}
									Thread.sleep(5000);
									Actions action = new Actions(driver);
									WebElement Fleet=driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]"));	
									action.moveToElement(Fleet);
									action.click().perform();
									Thread.sleep(1000);
									WebElement user=driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/div/div[2]"));
									List<WebElement> User=user.findElements(By.tagName("ul"));
									int cnt=0;
									for(WebElement UserDefined : User)
									{
										cnt++;
										System.out.println(UserDefined.getText());
										if(UserDefined.getText().equals(d2[10][2]))
										{
											System.out.println("Navigate to user Defined page :"+d2[10][2]);
											driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/div/div[2]/ul["+cnt+"]/li/a")).click();	
										}
									}
									Thread.sleep(1000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(5000);
									String name=driver.findElement(By.xpath(".//*[@id='lblMenuPath2']")).getText();
									System.out.println(name);
									if(name.equalsIgnoreCase("TEREX MATERIALS PROC • FLEET • "+d2[10][2]))
									{
										acop = "Report Created and Navigated to "+d2[10][2]+" Successfully";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 11 execution completed1############################");	
										
									/*	WebElement Header=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
										List<WebElement> header=Header.findElements(By.tagName("th"));
										for(int j=0;j<array.length;j++)
										{
											for(int k=0;k<header.size();k++)
											{
												String value=header.get(k).getText();
												if(value.equalsIgnoreCase(array[j]))
												{
													System.out.println(array[j]+" Added Successfully into Dashboard");
												}
											}
										}*/
									}
									else
									{
										System.out.println("Unable to Navigate ");
										acop = "Unable to Navigate to "+d2[10][2]+"Page.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 11 execution completed############################");	
									}
								}
								else
								{
								System.out.println("Save Report Button not Working");
								acop = "Save Report Button Not Working as Expected.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 11 execution completed############################");
								}
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						
						
						// Delete the user Defined
						if(d2[i][0].equalsIgnoreCase("TC12"))	
						{
							try
							{
								System.out.println( "###################Test case 12 is executing############################");
								String Str=d2[11][4].toString();
								String[] array=Str.split(",");
								Actions action = new Actions(driver);
								WebElement Fleet1=driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]"));	
								action.moveToElement(Fleet1);
								action.click().perform();
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("ColumnsDeleteButton"))).click();
								Thread.sleep(5000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("Delete")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("DeleteCloseButton")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("DeleteReportName")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("DeleteHeader")), driver))
									{
										Thread.sleep(2000);
										WebElement Element=driver.findElement(By.xpath(".//*[@id='tblFsUserDefinedMenuDataPanelItemContent']"));
										List<WebElement> List=Element.findElements(By.className("GridCellDiv"));
										for(int j=0;j<array.length;j++)
										{
											System.out.println("Size"+List.size());
											for(int k=0;k<List.size();k++)
											{
												String s1=List.get(k).getText();
												if(s1.equalsIgnoreCase(array[j]))
												{	
													System.out.println("K : "+k);
													driver.findElement(By.xpath(".//*[@id='tblFsUserDefinedMenuData']/tbody/tr["+k+"]/td[2]/div/button")).click();
													Thread.sleep(1000);
													if(t.isAlertPresent(driver))
													{
														driver.switchTo().alert().accept();
														System.out.println("Its Popups the Do you want to delete the selected report? Alert");
														System.out.println("Alert Accepted Successfully");
													}
													else
													{
														System.out.println("Its Not popups any Alert");
														acop = "Its Not popups any Alert";
														node.log(LogStatus.FAIL, acop);
														data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
														rc++;
														String scr = t.CaptureScreenshot();
														s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
														System.out.println( "###################Test case 12 execution completed############################");
													}
													Thread.sleep(2000);
													if(t.isAlertPresent(driver))
													{
														driver.switchTo().alert().accept();
														System.out.println("Its now popups Success Alert.");
														Thread.sleep(2000);
													}
													else
													{
														System.out.println("Unable to Popups the Success Alert.");
														acop = "Unable to Popups the Success Alert";
														node.log(LogStatus.FAIL, acop);
														data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
														rc++;
														String scr = t.CaptureScreenshot();
														s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
														System.out.println( "###################Test case 12 execution completed############################");
													}
													Thread.sleep(8000);
													while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
													{
														System.out.println("inside while");
														Thread.sleep(1000);
													}
													Thread.sleep(10000);
													WebElement Fleet=driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]"));	
													action.moveToElement(Fleet);
													action.click().perform();
													Thread.sleep(1000);
													
													WebElement user1=driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/div/div[2]"));
													List<WebElement> User1=user1.findElements(By.tagName("ul"));
													for(WebElement text:User1)
													{
														String Text=text.getText();
														if(Text.equalsIgnoreCase(array[j]))
														{
															acop = "Report "+array[j]+" is Unable to Delete.";
															node.log(LogStatus.FAIL, acop);
															data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
															rc++;
															String scr = t.CaptureScreenshot();
															s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
															System.out.println( "###################Test case 12 execution completed############################");
															break;
														}
														else
														{
															System.out.println("Report "+array[j]+" is Deleted Successfully.");
															acop = "Report "+array[j]+" is Deleted Successfully.";
															node.log(LogStatus.PASS, acop);
															data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
															rc++;
															s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
															System.out.println( "###################Test case 12 execution completed1############################");	
															break;
														}
													}
											}
										}
									}
								}
								else
								{
									String record=driver.findElement(By.xpath(".//*[@id='tblFsUserDefinedMenuData']/tbody/tr/td/span")).getText();
									if(t.isElementPresentcheck(By.xpath(".//*[@id='tblFsUserDefinedMenuData']/tbody/tr/td/span"), driver))
									{
										if(record.equalsIgnoreCase("No Records Found"))
										acop = "No Records in the table";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 12 execution completed1############################");	
										Thread.sleep(2000);
										driver.findElement(By.xpath(Object.getProperty("DeleteCloseButton"))).click();
										Thread.sleep(2000);
										driver.findElement(By.xpath(Object.getProperty("ColumnsCloseButton"))).click();
									}
									else
									{
										System.out.println("Unable to Click Delete Reprot Button");
										acop = "Unable to Click Delete Reprot Button";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 12 execution completed############################");
										driver.findElement(By.xpath(Object.getProperty("DeleteCloseButton"))).click();
										Thread.sleep(2000);
										driver.findElement(By.xpath(Object.getProperty("ColumnsCloseButton"))).click();
									}
								}
								Thread.sleep(10000);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						
						//Fleet Dash board
						if(d2[i][0].equalsIgnoreCase("TC13"))	
						{							
							try
							{
								System.out.println( "###################Test case 13 is executing############################");
								Thread.sleep(5000);
								String Str=d2[12][4];
								String s2=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']/th[1]/div")).getText();
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("Dashboard")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("Searialsearch")), driver)
										&& s2.equalsIgnoreCase(Str))
								{
									Thread.sleep(2000);
									WebElement dash=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
									List<WebElement> Dash =dash.findElements(By.tagName("th"));
									Thread.sleep(2000);
									driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
									Thread.sleep(2000);
									driver.findElement(By.xpath(".//*[@id='drpRCSettingSelectedColumn']/option[1]")).click();
									Thread.sleep(2000);
									driver.findElement(By.xpath(Object.getProperty("Remove"))).click();
									Thread.sleep(1000);
									if(t.isAlertPresent(driver))
									{
										driver.switchTo().alert().accept();
										System.out.println("Have to Delete the Columns Fav. while it popups the Alert Can not remove Fav. column.");
										Thread.sleep(5000);
										String s1=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']/th[1]/div")).getText();
										if(s1.equalsIgnoreCase(Str))
										{
											System.out.println("Working fine, the Default Column Fav is Unable to Delete.");

											Thread.sleep(2000);
											WebElement col=driver.findElement(By.xpath(".//*[@id='drpRCSettingSelectedColumn']"));
											List<WebElement> Col=col.findElements(By.tagName("option"));
											Thread.sleep(5000);
											for(int j=0;j<Dash.size();j++)
											{
												String dashboard = Dash.get(j).getText();
												System.out.println("Dashboard Value : "+dashboard);	
											}
											for(int k=0;k<Col.size();k++)
											{		
												String	columns=Col.get(k).getText();
												System.out.println("Columns Value : "+columns);
											}	
											if(Dash.size()==Col.size())
											{
												acop = "Unable to Delete the Fav. Column while popups alert and Dashboard Columns equal to Columns Report";
												node.log(LogStatus.PASS, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
												rc++;
												s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
												System.out.println( "###################Test case 13 execution completed1############################");
											}
											else
											{
												System.out.println("Dashboard Columns is not equal to Column report");
												acop = "Dashboard Columns is not equal to Column report";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 13 execution completed############################");
											}
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("ColumnsCloseButton"))).click();
											Thread.sleep(5000);
										}
										else
										{
											System.out.println("It popup Alert and  deleted the Fav. Column");
											acop = "It popups the  Alert and  delete thed Fav. Column";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 13 execution completed############################");
										}
									}
									else
									{
										System.out.println("Its not popup any Alert, while Deleting the Fav Column");
										acop = "Its not popup any Alert, while Deleting the Fav Column";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
																		 s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 13 execution completed############################");
									}									
								}
								else 
								{
									System.out.println("Dashboard is not showing properly");
									acop = "Dashboard is not showing properly";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
																	 s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");								}

								}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						
						
						
						//Remove From Favorite
						if(d2[i][0].equalsIgnoreCase("TC14"))	
						{
							try
							{
								Thread.sleep(5000);
								Select dropdown=new Select(driver.findElement(By.xpath(Object.getProperty("All"))));
								dropdown.selectByVisibleText("Favorite");
								Thread.sleep(1000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(10000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("RemovefromFavorites")), driver))
								{
									Thread.sleep(5000);
									driver.findElement(By.xpath(".//*[@id='EquipmentId_0']")).click();
									Thread.sleep(2000);
									String d=	driver.findElement(By.xpath(".//*[@id='OwnersEquipmentId~SerialNumber_0']")).getText();
									Thread.sleep(2000);
									driver.findElement(By.xpath(Object.getProperty("RemovefromFavorites"))).click();
									Thread.sleep(3000);
									if(t.isAlertPresent(driver))
									{
										driver.switchTo().alert().accept();
										System.out.println("Alert Popups");
									}
									else
									{
										System.out.println("It did not popups the Alert Message, Removed From Favorite Equipment.");
										acop = "It did not popups the Alert Message, Removed From Favorite Equipment.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 14 execution completed############################");	
									}
									Thread.sleep(1000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(5000);
									String d1=	driver.findElement(By.xpath(".//*[@id='OwnersEquipmentId~SerialNumber_0']")).getText();
									//String d1=d2[13][4];
									if(d.equalsIgnoreCase(d1))
									{
										System.out.println("It did not Remove the Selected Asset From Favorite.");
										acop = "It did not Remove the Selected Asset From Favorite.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 14 execution completed############################");								
									}
									else
									{
										acop = "Selected Asset Successfully Removed From Favorites.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 14 execution completed1############################");								
									}
									}
									else
									{
										System.out.println("Favorite Filter not caontains the Remove from Favorites Button.");
										acop = "Favorite Filter not caontains the Remove from Favorites Button.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
																		 s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 14 execution completed############################");		
									}
									Thread.sleep(5000);
									driver.findElement(By.xpath(Object.getProperty("ClearFilter"))).click();
									Thread.sleep(1000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(5000);
								}
								catch(Exception e)
								{
									e.printStackTrace();
								}
						}	
						
						
						
						//Asset Location Map
						if(d2[i][0].equalsIgnoreCase("TC15"))	
						{
							try
							{
								Thread.sleep(5000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("Map")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("Map1")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("Satllite")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("Pegman")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("Zoom")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ZoomIn")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("ZoomOut")), driver))
								{
									String s1=driver.findElement(By.xpath(".//*[@id='divMapFrame']/div/div/div[7]/img")).getAttribute("style");
									System.out.println(s);	
									Thread.sleep(1000);
									driver.findElement(By.xpath(Object.getProperty("Zoom"))).click();
									Thread.sleep(1000);
									String s2=	driver.findElement(By.xpath(".//*[@id='divMapFrame']/div/div/div[7]/img")).getAttribute("style");
									System.out.println(s1);	
									Thread.sleep(1000);
									if(s1.equalsIgnoreCase(s2))
									{
										System.out.println("Unable to Maximaize the Map");
										acop = "Unable to Maximaize the Map";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 15 execution completed############################");									
									}
									else
									{
										System.out.println("Map Pass");
										Actions action = new Actions(driver);
										WebElement Fleet=driver.findElement(By.xpath(".//*[@id='divMapFrame']/div/div/div[10]/div[1]/div[1]"));	
										action.moveToElement(Fleet);
										action.click().perform();
										Thread.sleep(1000);
										
										driver.findElement(By.xpath(".//*[@id='divMapFrame']/div/div/div[10]/div[1]")).getAttribute("title");
										
										String d=driver.findElement(By.xpath(".//*[@id='divMapFrame']/div/div/div[10]/div[1]/div[2]/div/span/div")).getAttribute("style");
										System.out.println(d);
										driver.findElement(By.xpath(".//*[@id='divMapFrame']/div/div/div[10]/div[1]/div[2]/div/span")).click();
										Thread.sleep(1000);
										String d1=driver.findElement(By.xpath(".//*[@id='divMapFrame']/div/div/div[10]/div[1]/div[2]/div/span/div")).getAttribute("style");
										System.out.println(d1);
										if(d.equalsIgnoreCase(d1))
										{
											System.out.println("While Clicking Terrian it not make any Changes in Map");
											acop = "While Clicking Terrian it not make any Changes in Map";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
																			 s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 15 execution completed############################");							
										}
										else
										{
											System.out.println("Terrain Pass");
										}
										Thread.sleep(1000);
										driver.findElement(By.xpath(".//*[@id='divMapFrame']/div/div/div[10]/div[1]/div[2]/div/span")).click();
										
										//Map Label
										Thread.sleep(1000);
										driver.findElement(By.xpath(Object.getProperty("Satllite"))).click();
										Thread.sleep(1000);
										WebElement sat=driver.findElement(By.xpath(Object.getProperty("Satllite")));	
										action.moveToElement(sat);
										action.click().perform();
										Thread.sleep(1000);
										String l=driver.findElement(By.xpath(".//*[@id='divMapFrame']/div/div/div[10]/div[2]/div[2]/div/span/div")).getAttribute("style");
										System.out.println(l);
										Thread.sleep(1000);
										driver.findElement(By.xpath(".//*[@id='divMapFrame']/div/div/div[10]/div[2]/div[2]/div/span")).click();
										Thread.sleep(1000);
										String l1=driver.findElement(By.xpath(".//*[@id='divMapFrame']/div/div/div[10]/div[2]/div[2]/div/span/div")).getAttribute("style");
										System.out.println(l1);
										if(l.equalsIgnoreCase(l1))
										{
											System.out.println("Sate Fail");
										}
										else
										{
											System.out.println("Sate Pass");
										}
									}
								}
								else
								{
									System.out.println("Map is not got refreshed  properly");
									acop = "Map is not got Refreshed Properly";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 15 execution completed############################");								
								}
								Thread.sleep(10000);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
							
						
						//Add New Filter
						if(d2[i][0].equalsIgnoreCase("TC16"))	
						{
							try
							{
								String Str=d2[15][4].toString();
								String[] array=Str.split(",");
								String Str1=d2[15][3].toString();
								String[] array1=Str1.split(",");
								String Str2=d2[15][2].toString();
								//	String[] value=Str2.split(",");
								/*	int ret=0;
								Thread.sleep(5000);
										for(int j=0;j<array.length;j++)
								{
								driver.findElement(By.xpath(Object.getProperty("All"))).click();
								Thread.sleep(3000);
								Select dropdown=new Select(driver.findElement(By.xpath(Object.getProperty("All"))));
								dropdown.selectByVisibleText("Add New Filter");
								Thread.sleep(1000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(5000);
								
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("AddTable")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ADDButton")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("CloseButton")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("AddNewFilterValue")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SaveAsNewFilter")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("FilterCondition")), driver)&& t.isElementPresentcheck(By.xpath(Object.getProperty("FilterInput")), driver))
								{
									System.out.println("Pass");
									driver.findElement(By.xpath(".//*[@id='drpColumnList']")).click();
									Thread.sleep(1000);
									driver.findElement(By.xpath(".//*[@id='drpColumnList']")).click();
										if(t.isElementPresentcheck(By.xpath(Object.getProperty("AddNewFilterValue")), driver))
										{
											Select dropdown1 = new Select(driver.findElement(By.xpath(".//*[@id='drpColumnList']")));
											List<WebElement> allOptions = dropdown1.getOptions();
											for (WebElement option : allOptions) 
											{	 	  
												if(option.getText().equals(array[j])) 
												{ 
													option.click(); 
													Thread.sleep(5000);
												}
											}		
											
											Select dropdown11 = new Select(driver.findElement(By.xpath(".//*[@id='tblReportColumnFilter']/tbody/tr/td[2]/select")));
											List<WebElement> allOptions1 = dropdown11.getOptions();
												for (WebElement option : allOptions1) 
												{	 	  
													if(option.getText().equals(array1)) 
													{ 
														option.click(); 
														Thread.sleep(5000);
													}
												}	
											
											Thread.sleep(5000);
											driver.findElement(By.xpath(Object.getProperty("FilterInput"))).sendKeys(value[j]);
											Thread.sleep(3000);
											driver.findElement(By.xpath(Object.getProperty("SaveAsNewFilter"))).click();
											Thread.sleep(1000);
											driver.findElement(By.xpath(Object.getProperty("FilterName"))).sendKeys(array[j]);
											Thread.sleep(3000);
											driver.findElement(By.xpath(Object.getProperty("NameSubmit"))).click();
											Thread.sleep(500);
											if(t.isAlertPresent(driver))
											{
												driver.switchTo().alert().accept();
											}
											while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
											{
												System.out.println("inside while");
												Thread.sleep(1000);
											}
											Thread.sleep(5000);
											WebElement ver=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
											List<WebElement> var=ver.findElements(By.tagName("th"));
											int count=0;
											for(WebElement Var : var)
											{
												count++;
												String Headertext=Var.getText();
												if(Headertext.equalsIgnoreCase(array[j]))
												{
													 ret=count;
													System.out.println("header"+Headertext);
													System.out.println("Return"+ret);
												}
											}
											String d=driver.findElement(By.xpath(".//*[@id='spnFilterTextPlaceHolder']/span/span")).getText();
										//	System.out.println(d);
											if(d.equalsIgnoreCase("Search result for '"+array[j]+" "+d2[15][3]+" "+value[j]+"', ..."))
											{
												System.out.println("get In");
												int w=j+2;
												System.out.println("J : "+ret);
												String text=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']/th["+ret+"]")).getText();
												String Text=text.replaceAll("\\s", "");
												System.out.println(Text);
												String m=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportCopy']")).getAttribute("totalrows");
												Integer m1=Integer.parseInt(m);
												System.out.println("Rows"+m);
											//	WebElement fil=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr/td["+j+"]"));
												List<WebElement> filter=driver.findElements(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr/td["+ret+"]"));
												int flag=0;
												for(WebElement Filter:filter)
												{
													flag++;
													String Text1=Filter.getText();
													System.out.println(Text1);
													if(Text1.equalsIgnoreCase(value[j]))
													{
														System.out.println(flag);
													}
													else
													{}
												}
												}
											
											Thread.sleep(10000);
											driver.findElement(By.xpath(Object.getProperty("ClearFilter"))).click();
											Thread.sleep(1000);
											while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
											{
												System.out.println("inside while");
												Thread.sleep(1000);
											}
											Thread.sleep(5000);
										}
										
									}
								
								else
								{
									System.out.println("fail");
								}
								}
								Thread.sleep(10000);*/
							Thread.sleep(5000);	
							String[][] d3 = s.Read(System.getProperty("user.dir")+"\\src\\FleetEdge_Properties\\Fleet.xlsx", "FleetStatus");
							for(int e=0;e<array1.length;e++)
							{
								boolean strCheckFIlter=false;
								if(array1[e].equalsIgnoreCase("Equals"))
								{
									strCheckFIlter = AddFilter.fill(array1[e], Str2,d3,Str);
									System.out.println(strCheckFIlter);
									if(true==strCheckFIlter)
									{
										System.out.println("equals");
										acop = "AddFilter "+array1[e]+"Condition Working Fine";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 16 execution completed1############################");
									}
									else
									{
										System.out.println("Equal fail");
										acop = "Add Filter Not Working Well in this : "+array1[e]+"Condition";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 16 execution completed############################");
									}
								}
								if(array1[e].equalsIgnoreCase("Contains"))
								{
									strCheckFIlter = AddFilter.fill(array1[e], Str2,d3,Str);
									System.out.println(strCheckFIlter);
									if(true==strCheckFIlter)
									{
										System.out.println("Contains");
										acop = "AddFilter "+array1[e]+"Condition Working Fine";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 16 execution completed1############################");
									}
									else
									{
										System.out.println("Contains fail");
										acop = "Add Filter Not Working Well in this : "+array1[e]+"Condition";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 16 execution completed############################");
									}									
								}
								if(array1[e].equalsIgnoreCase("Having"))
								{
									strCheckFIlter = AddFilter.fill(array1[e], Str2,d3,Str);
									System.out.println(strCheckFIlter);
									if(true==strCheckFIlter)
									{
										System.out.println("Having");
										acop = "AddFilter "+array1[e]+"Condition Working Fine";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 16 execution completed1############################");
									}
									else
									{
										System.out.println("Having fail");
										acop = "Add Filter Not Working Well in this : "+array1[e]+"Condition";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 16 execution completed############################");
									}										
								}
								if(array1[e].equalsIgnoreCase("Is Empty"))
								{
									strCheckFIlter = AddFilter.fill(array1[e], Str2,d3,Str);
									System.out.println(strCheckFIlter);
									if(false==strCheckFIlter)
									{
										System.out.println("Is Empty");
										acop = "AddFilter "+array1[e]+"Condition Working Fine";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 16 execution completed1############################");
									}
									else
									{
										System.out.println("Is Empty Fail");
										acop = "Add Filter Not Working Well in this : "+array1[e]+"Condition";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 16 execution completed############################");
									}
								}
								if(array1[e].equalsIgnoreCase("Is Not Empty"))
								{
									strCheckFIlter = AddFilter.fill(array1[e], Str2,d3,Str);
									System.out.println(strCheckFIlter);
									if(false==strCheckFIlter)
									{
										System.out.println("Is Not Empty");
										acop = "AddFilter "+array1[e]+"Condition Working Fine";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 16 execution completed1############################");
									}
									else
									{
										System.out.println("Is Not Empty fail");
										acop = "Add Filter Not Working Well in this : "+array1[e]+"Condition";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 16 execution completed############################");
									}
								}
							}																
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						
						
						
						//Column Sort
						if(d2[i][0].equalsIgnoreCase("TC17"))	
						{
							try
							{	
								String Str=d2[16][4].toString();
								String [] array=Str.split(",");
								for(int v=0;v<array.length;v++)
								{	
									Thread.sleep(5000);
									String rowRecords=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportCopy']")).getAttribute("totalrows");
									System.out.println("Total No of Records Before Sort : "+rowRecords);
									Thread.sleep(2000);
									Actions actions = new Actions(driver);
									WebElement sort=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
									List<WebElement> Sort=sort.findElements(By.tagName("th"));
									System.out.println("Header Size :"+Sort.size());
									ArrayList<String> obtainedList = new ArrayList<>();
									ArrayList<String> sortedList = new ArrayList<>();   
									ArrayList<String> rowData = new ArrayList<String>();
									int cnt1=0;
									for(WebElement col:Sort)
									{
										cnt1++;
										String Colum=col.getText();
										if(Colum.equalsIgnoreCase(array[v]))
										{										
											List<WebElement> elementList= driver.findElements(By.xpath(".//*[@id='tblFleetStatusReportFreeze']/tbody/tr/td["+cnt1+"]"));
											System.out.println("Element List Size : "+ elementList.size());
											for(WebElement element :elementList)
											{	
												//	System.out.println(" Column :"+element.getText());
												String Element=element.getText();
												obtainedList.add(Element);
											}
										}
									}
									WebElement sort1=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
									List<WebElement> Sort1=sort1.findElements(By.tagName("th"));
									System.out.println("List Size :" +Sort1.size());
									for(WebElement row : Sort1)
									{	
										rowData.add(row.getText().toString());								
									}
									int r=rowData.size();
									System.out.println(r);
									int cnt=0;
									for(int j=0;j<rowData.size();j++)
									{
										System.out.println(rowData.get(j).toString());
										String value=rowData.get(j).toString() ;
										cnt++;
										if(value.equalsIgnoreCase(array[v]))
										{
											WebElement el=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']/th["+cnt+"]/div/a"));	
											WebElement clas=driver.findElement(By.className("TmsReportColumnSort"));										
											actions.moveToElement(el).moveToElement(clas);
											actions.click(el);
											actions.perform();
											System.out.println(cnt);
											Thread.sleep(1000);
											while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
											{
												System.out.println("inside while");
												Thread.sleep(1000);
											}
											Thread.sleep(5000);
											String d = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']/th["+cnt+"]/div/a")).getAttribute("sortorder");
											System.out.println(d);
											if(d.equalsIgnoreCase("Ascending"))
											{
												String ascendingRecords=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportCopy']")).getAttribute("totalrows");
												if(rowRecords.equalsIgnoreCase(ascendingRecords))
												{
													if(t.isElementPresentcheck(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']/th["+cnt+"]/div/a/span"), driver))
													{
														System.out.println("Ascending Pass");
														acop = "Colum Sorted SuccessFully";
														node.log(LogStatus.PASS, acop);
														data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
														rc++;
														String scr = t.CaptureScreenshot();
														s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
														System.out.println( "###################Test case 17 execution completed############################");
													}
													else
													{
														System.out.println("Sort Arrow Missing");
														acop = "Unable to locate and sort the column";
														node.log(LogStatus.FAIL, acop);
														data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
														rc++;
														String scr = t.CaptureScreenshot();
														s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
														System.out.println( "###################Test case 17 execution completed############################");
													}
												}
												else
												{
													System.out.println("Sort Ascending When a time Total Records got Changed.");
													acop = "Sort Ascending When a time Total Records got Changing";
													node.log(LogStatus.FAIL, acop);
													data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
													rc++;
													String scr = t.CaptureScreenshot();
													s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
													System.out.println( "###################Test case 17 execution completed############################");
												}
												/*	Collections.sort(obtainedList);
											List<WebElement> elementList= driver.findElements(By.xpath(".//*[@id='tblFleetStatusReportFreeze']/tbody/tr/td["+cnt+"]"));
											System.out.println("element List Size : "+ elementList.size());
											for(WebElement afterSort : elementList)
											{
												sortedList.add(afterSort.getText().toString());
											}									
											Assert.assertTrue(sortedList.equals(obtainedList));*/
											}
											else if(d.equalsIgnoreCase("Descending"))
											{
												String descendingRecords=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportCopy']")).getAttribute("totalrows");
												if(descendingRecords.equalsIgnoreCase(rowRecords))
												{
													System.out.println("Descending Pass");
													if(t.isElementPresentcheck(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']/th["+cnt+"]/div/a/span"), driver))
													{
														System.out.println("Descending Pass");
														acop = "Column Sorted SuccessFully.";
														node.log(LogStatus.PASS, acop);
														data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
														rc++;
														String scr = t.CaptureScreenshot();
														s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
														System.out.println( "###################Test case 17 execution completed############################");
													}
													else
													{
														System.out.println("Descending Sort Arrow Missing");
														acop = "Not able to loacte and sort the column";
														node.log(LogStatus.FAIL, acop);
														data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
														rc++;
														String scr = t.CaptureScreenshot();
														s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
														System.out.println( "###################Test case 17 execution completed############################");
													}
												}
												else
												{
													System.out.println("Sort Descending When a time Total Records got Changing");
													acop = "Sort Descending When a time Total Records got Changing";
													node.log(LogStatus.FAIL, acop);
													data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
													rc++;
													String scr = t.CaptureScreenshot();
													s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
													System.out.println( "###################Test case 17 execution completed############################");								

												}
												/*	Collections.reverse(obtainedList);
											List<WebElement> elementList= driver.findElements(By.xpath(".//*[@id='tblFleetStatusReportFreeze']/tbody/tr/td["+cnt+"]"));
											System.out.println("element List Size : "+ elementList.size());
											for(WebElement afterSort : elementList)
											{
												sortedList.add(afterSort.getText().toString());
											}									
											Assert.assertTrue(sortedList.equals(obtainedList));*/
											}
											else
											{
												System.out.println("Unable to Sort");
												acop = "Unable to Sort the Column";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 17 execution completed############################");								
											}									
											Thread.sleep(10000);
										}
									}
								}
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						
						
						
						//Show Records
						if(d2[i][0].equalsIgnoreCase("TC18"))
						{
							try
							{
								String Str=d2[17][4].toString();
								String[] array=Str.split(",");
								Select select=new Select(driver.findElement(By.xpath(Object.getProperty("Show"))));
								List<WebElement> show=select.getOptions();
								ArrayList<String> rowData=new ArrayList<String>();
								System.out.println("List Size"+show.size());
								String totalRecord= driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportCopy']")).getAttribute("totalrows");
							//	driver.findElement(By.xpath(Object.getProperty("Show"))).click();
								Thread.sleep(1000);
								String[] val=new String[show.size()+1];
								for(int j=1;j<=show.size();j++)
								{
									String value=driver.findElement(By.xpath(".//*[@id='pageSize']/option["+j+"]")).getText();
									val[j]=value;
									System.out.println(val[j]);
								}
								if(val[1].equalsIgnoreCase("10") && val[2].equalsIgnoreCase("50") && val[3].equalsIgnoreCase("75") && val[4].equalsIgnoreCase("100"))
								{
									driver.findElement(By.xpath(Object.getProperty("Show"))).click();
									Thread.sleep(1000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(5000);
									WebElement list=driver.findElement(By.xpath(Object.getProperty("Show")));
									List<WebElement> Sort1=list.findElements(By.tagName("option"));
									Thread.sleep(2000);
									for(WebElement row : Sort1)
									{	
										rowData.add(row.getText().toString());								
									}
									Thread.sleep(1000);
									System.out.println(+val.length-1);
									for(int k=1;k<=val.length-1;k++)
									{
										Select dropdown = new Select(driver.findElement(By.xpath(".//*[@id='pageSize']")));
										List<WebElement> allOptions = dropdown.getOptions();
										System.out.println(allOptions.size());
										System.out.println("Val :"+val[k]);
										driver.findElement(By.xpath(".//*[@id='pageSize']/option["+k+"]")).click();
										Thread.sleep(1000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(5000);
										WebElement row=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportFreeze']/tbody"));
										List<WebElement> Row=row.findElements(By.tagName("tr"));
									//	System.out.println("Row Size : "+Row.size() );
										int rowCount=Row.size()-1;
										String Count=String.valueOf(rowCount);
										System.out.println("Row Count : "+rowCount);
										Thread.sleep(1000);
										if(val[k].equals(Count))
										{
											String totalRecords= driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportCopy']")).getAttribute("totalrows");
											if(totalRecords.equalsIgnoreCase(totalRecord))
											{
												System.out.println("Show Rows Working as Expected.");
												acop = "Show Rows Working as Expected.";
												node.log(LogStatus.PASS, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
												System.out.println( "###################Test case 18 execution completed############################");
											}
											else
											{
												System.out.println("Changing Records Page to "+val[k]+"While Total Records COunt Got Changed");
												acop = "Changing Records Page to "+val[k]+"While Total Records COunt Got Changed";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 18 execution completed############################");
											}											
										}
										else
										{
											System.out.println("Per Page Record Count MissMatch");
											acop = "Per Page Record Count MissMatch";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 18 execution completed############################");
										}
									}
							}
							else
							{
								System.out.println("Records Column Missing");
								acop = "Records Column Missing";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 18 execution completed############################");								

							}
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						
						//HighLight
						if(d2[i][0].equalsIgnoreCase("TC19"))
						{
							try
							{	
								String Str=d2[18][4].toString();
								String[] array=Str.split(",");
								String Str2=d2[18][3].toString();
								String[] array2=Str2.split("#");
								Thread.sleep(5000);
 								driver.findElement(By.xpath(Object.getProperty("Highlight"))).click();
								Thread.sleep(5000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightTab")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightNew")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightClose")), driver))
								{
									Thread.sleep(2000);
									driver.findElement(By.xpath(Object.getProperty("HighlightNew"))).click();
									Thread.sleep(2000);
									if(t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightClose")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightRow")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightColumn")), driver) &&  t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightRowColor")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightColumnColor")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightRowList")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightColumnList")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightRowCondition")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightColumnCondition")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightRowText")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightColumnText")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightRowAddButton")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightColumnAddButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightSaveButton")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightCancelButton")), driver))
									{
										driver.findElement(By.xpath(Object.getProperty("HighlightRow"))).click();
										Thread.sleep(2000);
										driver.findElement(By.xpath(Object.getProperty("HighlightColumn"))).click();
										Thread.sleep(2000);
										//row Setting
										WebElement rowColor=driver.findElement(By.xpath(Object.getProperty("HighlightRowColor")));
										List<WebElement> RowColor=rowColor.findElements(By.tagName("option"));																															
										int cnt=0;
										for(WebElement text: RowColor)
										{												
											String Text=text.getText();
											cnt++;
											if(Text.equalsIgnoreCase(array[0]))
											{											
												Thread.sleep(5000);
												text.click();
												//	driver.findElement(By.xpath(".//*[@id='drpRowHighlightColor']/option["+cnt+"]")).click();
												System.out.println("Color");											
											}
										}
										int cnt1=0;
										WebElement rowList=driver.findElement(By.xpath(Object.getProperty("HighlightRowList")));
										List<WebElement> RowList=rowList.findElements(By.tagName("option"));
										Thread.sleep(2000);
										for(WebElement text : RowList)
										{	
											cnt1++;
											String Text=text.getText();
											if(Text.equalsIgnoreCase(array[1]))
											{	
												Thread.sleep(5000);
												text.click();
										//		driver.findElement(By.xpath(".//*[@id='drpRowHighlightColumnList']/option["+cnt1+"]")).click();
												System.out.println("List");													
											}
										}
										int cnt2=0;
										WebElement rowCondition=driver.findElement(By.xpath(Object.getProperty("HighlightRowCondition")));
										List<WebElement>RowCondition=rowCondition.findElements(By.tagName("option"));
										Thread.sleep(2000);
										for(WebElement text : RowCondition)
										{
											String Text=text.getText();
											cnt2++;
											if(Text.equalsIgnoreCase(array[2]))
											{
												Thread.sleep(5000);
												text.click();
												//driver.findElement(By.xpath(".//*[@id='drpRowHighlightOperator']/option["+cnt2+"]")).click();
												System.out.println(Text);
											}
										}
										Thread.sleep(3000);
										driver.findElement(By.xpath(Object.getProperty("HighlightRowText"))).sendKeys(array[3]);
									
										//Column Setting
										Thread.sleep(2000);
										WebElement columnColor=driver.findElement(By.xpath(Object.getProperty("HighlightColumnColor")));
										List<WebElement> ColumnColor=columnColor.findElements(By.tagName("option"));
										Thread.sleep(2000);
										for(WebElement text1 :ColumnColor)
										{
											String Text=text1.getText();
											if(Text.equalsIgnoreCase(array[4]))
											{
												Thread.sleep(5000);
												text1.click();
											}
										}
										WebElement columnList=driver.findElement(By.xpath(Object.getProperty("HighlightColumnList")));
										List<WebElement>ColumnList=columnList.findElements(By.tagName("option"));
										Thread.sleep(2000);
										for(WebElement text1 : ColumnList)
										{
											String Text=text1.getText();
											if(Text.equalsIgnoreCase(array[5]))
											{
												Thread.sleep(5000);
												text1.click();
											}
										}
										WebElement columnCondition=driver.findElement(By.xpath(Object.getProperty("HighlightColumnCondition")));
										List<WebElement> ColumnCondition=columnCondition.findElements(By.tagName("option"));
										Thread.sleep(2000);
										for(WebElement text1 :ColumnCondition)
										{
											String Text=text1.getText();
											if(Text.equalsIgnoreCase(array[6]))
											{
												Thread.sleep(5000);
												text1.click();
											}
										}
										Thread.sleep(3000);
										driver.findElement(By.xpath(Object.getProperty("HighlightColumnText"))).sendKeys(array[7]);
										Thread.sleep(3000);
										driver.findElement(By.xpath(Object.getProperty("HighlightSaveButton"))).click();
										Thread.sleep(1000);
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
										//Row Highlight Verify
										int c=0,flag=0;
										WebElement col=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
										List<WebElement>Col=col.findElements(By.tagName("th"));
										for(WebElement text :Col)
										{
											c++;
											String Text=text.getText();
											if(Text.equalsIgnoreCase(array[1]))
											{
												List<WebElement>Row=driver.findElements(By.xpath(".//*[@id='tblFleetStatusReportFreeze']/tbody/tr/td["+c+"]"));
												int r=1;
												for(WebElement text1 : Row)
												{
													r++;
													String Text1=text1.getText();
													if(Text1.equalsIgnoreCase(array[3]))
													{	
														String result = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+r+"]/td["+c+"]")).getCssValue("background-color");
											
														if(result.equalsIgnoreCase(array2[0]))
														{
														//	System.out.println("Result :"+array2[0]);
															System.out.println("Row Color Added SuccessFully");
															flag=1;
														}
														else
														{
															acop = "Row Highlight not working as Expected";
															node.log(LogStatus.FAIL, acop);
															data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
															rc++;
															String scr = t.CaptureScreenshot();
															s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
															System.out.println( "###################Test case 19 execution completed############################");															break;
														}
													}
												}	
											}
										}
										if(flag==1)
										{
											acop = "Highligh Rows Working as Expected.";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
											System.out.println( "###################Test case 19 execution completed############################");
										}
										//Verify Column 
										int c1=0,flag1=0;
										WebElement col1=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
										List<WebElement>Col1=col1.findElements(By.tagName("th"));
										for(WebElement text:Col1)
										{
											c1++;
											String Text =text.getText();
											if(Text.equalsIgnoreCase(array[5]))
											{
												List<WebElement>Row=driver.findElements(By.xpath(".//*[@id='tblFleetStatusReportFreeze']/tbody/tr/td["+c1+"]"));
												int r1=1;
												for(WebElement text1 :Row)
												{
													r1++;
													String Text1=text1.getText();
													if(Text1.equalsIgnoreCase(array[7]))
													{
													//	System.out.println("Column Value : "+Text1+r1);
														System.out.println("Value : "+driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportFreeze']/tbody/tr/td["+c1+"]")).getText());
														String Column =driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportFreeze']/tbody/tr["+r1+"]/td["+c1+"]")).getCssValue("background-color");
														System.out.println("Column Color :"+Column);
														System.out.println("array Color :"+array2[1]);
														if(Column.equalsIgnoreCase(array2[1]))
														{
															System.out.println("Column Color added Successfully ");
															flag1=1;
														}
														else
														{
															System.out.println("Column verify Fail");
															acop = "Column Highligh not Working as Expected.";
															node.log(LogStatus.FAIL, acop);
															data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
															rc++;
															String scr = t.CaptureScreenshot();
															s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
															System.out.println( "###################Test case 19 execution completed############################");
															break;
														}														
													}
												}
											}
										}
										if(flag1==1)
										{
											acop = "Highlight Columns Working as Expected.";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
											System.out.println( "###################Test case 19 execution completed############################");
										}
										Thread.sleep(3000);
										boolean row=AddFilter.chkHighlightupdate("2", "HighlightRowColor", array[8], array[1], array[3], array2[2]);
										///System.out.println(row);
										if(true==row)
										{
											System.out.println("Selected Row Color Changed");
											acop = "Highlight Update Working as Expected For Rows Highlight.";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
											System.out.println( "###################Test case 19 execution completed############################");
										}
										else
										{
											System.out.println("unable to Update new Color");
											acop = "Unable to Update new Color on Rows";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 19 execution completed############################");
										}
										Thread.sleep(3000);
										boolean column=AddFilter.chkHighlightupdate("3", "HighlightColumnColor", array[9], array[5], array[7], array2[3]);
									//	System.out.println("Column : " +column);
										if(true==column)
										{
											System.out.println("Selected Column Color Changed");
											acop = "Highlight Update Working as Expected for Columns Highlight.";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
											System.out.println( "###################Test case 19 execution completed############################");
										}
										else
										{
											System.out.println("unalbe to update new Color in Column");
											acop = "Unable to Update new Color on Columns";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 19 execution completed############################");
										}
										
										//Highlight Delete
										Thread.sleep(3000);
										driver.findElement(By.xpath(Object.getProperty("Highlight"))).click();
										Thread.sleep(3000);
										WebElement del= driver.findElement(By.xpath(".//*[@id='tblHighlightReport']/tbody"));
										List<WebElement> Del=del.findElements(By.xpath("tr"));
								//		System.out.println("Delete Size "+Del.size());
										for(int j=1;j<=Del.size()-1;j++)
										{
											j++;
											driver.findElement(By.xpath(".//*[@id='tblHighlightReport']/tbody/tr["+j+"]")).click();
											Thread.sleep(5000);
											driver.findElement(By.xpath(Object.getProperty("HighlightDeleteButton"))).click();
											if(t.isAlertPresent(driver))
											{
												driver.switchTo().alert().accept();
												Thread.sleep(2000);
												while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
												{
													System.out.println("inside while");
													Thread.sleep(1000);
												}
												Thread.sleep(5000);
												acop = "Highlight Delete Button Working as Expected.";
												node.log(LogStatus.PASS, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
												System.out.println( "###################Test case 19 execution completed############################");
											}
											else
											{
												acop = "Delete Alert Missing";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 19 execution completed############################");
											}
											Thread.sleep(5000);
										}	
											//Highlight Clear
											driver.findElement(By.xpath(Object.getProperty("Highlight"))).click();
											Thread.sleep(3000);
											driver.findElement(By.xpath(".//*[@id='tblHighlightReport']/tbody/tr[2]")).click();
											Thread.sleep(3000);
											driver.findElement(By.xpath(Object.getProperty("HighlightCancelButton"))).click();
											Thread.sleep(3000);
											if(t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightRow")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightColumn")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightRowColor")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightColumnColor")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightRowList")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightColumnList")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightRowCondition")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightColumnCondition")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightRowText")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightColumnText")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightRowAddButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightColumnAddButton")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightCancelButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightDeleteButton")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightUpdatebutton")), driver))
											{
												acop = "Clear But not Working as Expected";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 19 execution completed############################");											}
											else
											{
												System.out.println("clear");
												acop = "Highlight Clear Button Working as Expected.";
												node.log(LogStatus.PASS, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
												System.out.println( "###################Test case 19 execution completed############################");											
											}
											
											//Highlight Close
											Thread.sleep(3000);
											driver.findElement(By.xpath(".//*[@id='tblHighlightReport']/tbody/tr[2]")).click();
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("HighlightClose"))).click();
											Thread.sleep(3000);
											if(t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightTab")), driver))
											{
												acop = "Close Button not Working as Expected.";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 19 execution completed############################");											
											}
											else
											{
												System.out.println("Close");
												acop = "Highlights Working  as Expected.";
												node.log(LogStatus.PASS, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
												System.out.println( "###################Test case 19 execution completed############################");
											}
									}
									else
									{
										acop = "Highlight New Button not Working as Expected.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 19 execution completed############################");									
									}
										Thread.sleep(10000);
								}
								else
								{
									acop = "Highlight Button Not Working as Expected.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 19 execution completed############################");								
								}
								Thread.sleep(10000);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						

						//Delete Filter
						if(d2[i][0].equalsIgnoreCase("TC20"))
						{
							try
							{
								String Condition=d2[19][3];
								String value=d2[19][2];
								int flag=0;
								String[][] excelPath = s.Read(System.getProperty("user.dir")+"\\src\\FleetEdge_Properties\\Fleet.xlsx", "FleetStatus");
								String conditionType=d2[19][4];
								AddFilter.fill(Condition, value, excelPath, conditionType);
								Thread.sleep(5000);
								WebElement del=driver.findElement(By.xpath(Object.getProperty("All")));
								List<WebElement> Del=del.findElements(By.tagName("option"));
								for(WebElement text : Del)
								{
									String Text=text.getText();
									if(Text.equalsIgnoreCase(conditionType))
									{
										System.out.println("Delete Fail");
										acop = "Delete Filter is Not Working as Expected.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 20 execution completed############################");										
									}
									else
									{
										flag=1;
									}									
								}
								if(flag==1)
								{
									acop = "Delete Filter Working  as Expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 20 execution completed############################");		
								}
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						
						//File Download
						if(d2[i][0].equalsIgnoreCase("TC21"))
						{
							try
							{
								String Str=d2[20][4].toString();
								String [] array=Str.split(",");
								Thread.sleep(5000);
								int pageSize=0,recordsCount=0;
								ArrayList<String> tr=new ArrayList<String>();
								for(int k=0;k<array.length;k++)
								{

									String s1=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportFreeze']")).getAttribute("totalrows");
									System.out.println("Total Records :"+s1);
									pageSize=Integer.parseInt(s1);
									driver.findElement(By.xpath(Object.getProperty("Download"))).click();
									Thread.sleep(3000);
									if(t.isElementPresentcheck(By.xpath(Object.getProperty("PDF")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("Excel")), driver))
									{
										Thread.sleep(3000);
										driver.findElement(By.xpath(Object.getProperty(array[k]))).click();
										Thread.sleep(3000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(50000);
										Robot robot = new Robot();
										robot.keyPress(KeyEvent.VK_DOWN);
										Thread.sleep(500);
										robot.keyRelease(KeyEvent.VK_DOWN);
										Thread.sleep(500);
										robot.keyPress(KeyEvent.VK_ENTER);
										Thread.sleep(500);
										robot.keyRelease(KeyEvent.VK_ENTER);
										Thread.sleep(5000);
										try
										{
											//BufferedReader reader = new BufferedReader(new FileReader("D:\\workspace\\FleetEdge\\DownloadExcel\\Fleet Status.xlsx"));									
											if(array[k].equalsIgnoreCase("Excel"))
											{
												String excelFilePath = "D:\\workspace\\FleetEdge\\DownloadExcel\\Fleet Status.xlsx";
												FileInputStream input = new FileInputStream(new File(excelFilePath));
												Workbook workbook = new XSSFWorkbook(input);
												Sheet sheet1 = workbook.getSheetAt(0);
												int m=0;
												input.close();
												recordsCount=sheet1.getLastRowNum();
													if(recordsCount == pageSize)
												{
													System.out.println("Reocrds count matching... Pass");
													acop = "Record Count Matching With Excel.";
													node.log(LogStatus.PASS, acop);
													data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
													rc++;
													s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
													System.out.println( "###################Test case 21 execution completed############################");
												}
												else
												{
													System.out.println("Records count mismatch... Fail");
													acop = "Record Count Mismatch With Excel";
													node.log(LogStatus.FAIL, acop);
													data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
													rc++;
													String scr = t.CaptureScreenshot();
													s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
													System.out.println( "###################Test case 21 execution completed############################");
												}
											}
											else
											{
												List<String> lines = new ArrayList<String>();
												String pdfPath="D:\\workspace\\FleetEdge\\DownloadExcel\\Fleet Status.pdf";
												PDDocument doc = PDDocument.load(new File(pdfPath));
												int count = doc.getNumberOfPages();
												System.out.println("Count : "+count);
												int val=pageSize/23+1;
 												if(val==count)
												{
													System.out.println("Pdf Pass");
													acop = "Record Count Matching With PDF";
													node.log(LogStatus.PASS, acop);
													data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
													rc++;
													s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
													System.out.println( "###################Test case 21 execution completed############################");
												}
												else
												{
													System.out.println("Pdf fail");
													acop = "Record Count Mismatch wih PDF";
													node.log(LogStatus.FAIL, acop);
													data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
													rc++;
													String scr = t.CaptureScreenshot();
													s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
													System.out.println( "###################Test case 21 execution completed############################");
												}
											}
										}
										catch(Exception e)
										{
											e.printStackTrace();
										}
									}
									else
									{
										System.out.println("Download Button not Working as Expected");
										acop = "Download Button not Working as Expected";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 21 execution completed############################");
									}
								}
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
						
						
						
						
						//Subscription
						if(d2[i][0].equalsIgnoreCase("TC22"))
						{
							try
							{
								String Str=d2[21][4].toString();
								String [] array=Str.split(",");
								String sdate=t.date(d2[21][2]);
								String edate=t.date(d2[21][3]);
								Thread.sleep(5000);								
								driver.findElement(By.xpath(Object.getProperty("Subscription"))).click();
								Thread.sleep(2000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionFilter")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionTable")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionStartDate")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionEndDate")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionMonthly")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionWeekly")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionDaily")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionRecieveReport")), driver) 
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionEmailTextBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionADDEmailButton")), driver) 
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionStatusActive")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionStatusDeactive")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionSave")), driver))
								{
									System.out.println("Pass");
									WebElement filter=driver.findElement(By.xpath(Object.getProperty("SubscriptionFilter")));
									List<WebElement> Filter=filter.findElements(By.tagName("option"));
									for(WebElement text : Filter)
									{
										String Text=text.getText();
										if(Text.equalsIgnoreCase(array[0]))
										{
											text.click();
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("SubscriptionStartDate"))).sendKeys(sdate);
											Thread.sleep(1000);
											driver.findElement(By.xpath(Object.getProperty("SubscriptionEndDate"))).sendKeys(edate);
											Thread.sleep(1000);
											WebElement check=driver.findElement(By.xpath(".//*[@id='divEmailSubscription']/table/tbody/tr[3]/td[2]"));
											List<WebElement>Check=check.findElements(By.tagName("input"));
											for(WebElement text1 : Check)
											{
												String Text1=text1.getAttribute("value");
												System.out.println("Check Box : "+Text1);
												if(Text1.equalsIgnoreCase(array[1]))
												{
													text1.click();
													System.out.println("In");
													if(array[1].equalsIgnoreCase("M"))
													{
														if(t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionDayOfMonth")), driver))
														{
															WebElement day =driver.findElement(By.xpath(Object.getProperty("SubscriptionDayOfMonth")));
															List<WebElement>Day =day.findElements(By.tagName("option"));
															for(WebElement text2 : Day)
															{
																String Text2=text.getText();
																if(Text2.equalsIgnoreCase(array[2]))
																{
																	System.out.println("Inner");	
																	text2.click();
																}
															}
														}
													}
													else if(array[1].equalsIgnoreCase("W"))
													{
														if(t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionRecievingDay")), driver))
														{
															WebElement day=driver.findElement(By.xpath(Object.getProperty("SubscriptionRecievingDay")));
															List<WebElement>Day=day.findElements(By.tagName("span"));
															int c=0;
															for(WebElement text2 : Day)
															{
																c++;
																String Text2=text2.getText();
																System.out.println("WeeKly "+Text2 );
																if(Text2.equalsIgnoreCase(array[3]))
																{
																	Thread.sleep(2000);
																	//text2.click();
																	driver.findElement(By.xpath(".//*[@id='idDay']/span["+c+"]/input")).click();
																	System.out.println("WeekLy Selected."+c);
																}
															}
														}
													}											
												}
											}
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("SubscriptionRecieveReport"))).sendKeys("05:00 pm");
											Thread.sleep(1000);
										/*	WebElement recieve=driver.findElement(By.xpath(Object.getProperty("SubscriptionRecieveReport")));
											List<WebElement> Recieve=recieve.findElements(By.tagName("input"));
											for(WebElement text2 : Recieve )
											{
												String Text2=text.getText();
												if(Text2.equalsIgnoreCase("05:00 pm"))
												{
													text2.click();
												}
											}*/
											//driver.findElement(By.xpath(Object.getProperty("SubscriptionRecieveReport"))).sendKeys("05:00 pm");
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("SubscriptionADDEmailButton"))).click();
											Thread.sleep(2000);
											if(t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionEmailData")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionSearchtype")), driver) 
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionSearchTextBox")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionSearchButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionClearButton")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionSelectButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionCancelButton")), driver))
											{
												driver.findElement(By.xpath(Object.getProperty("SubscriptionSearchTextBox"))).sendKeys(array[4]);
												Thread.sleep(1000);
												driver.findElement(By.xpath(Object.getProperty("SubscriptionSearchButton"))).click();
												Thread.sleep(5000);
												driver.findElement(By.xpath(".//*[@id='tblUserList']/tbody/tr/td[1]/div")).click();
												Thread.sleep(1000);
												driver.findElement(By.xpath(Object.getProperty("SubscriptionSelectButton"))).click();
												Thread.sleep(1000);
											}
											else
											{
												acop = "AddEmail Button Not Working Well.";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 22 execution completed############################");
											}
											WebElement status=driver.findElement(By.xpath(".//*[@id='divEmailSubscription']/table/tbody/tr[8]/td[2]"));
											List<WebElement>Status = status.findElements(By.tagName("input"));
											int c=0;
											for(WebElement text4 : Status)
											{	c++;
												String Text4=text4.getAttribute("value");
												System.out.println(Text4);
												if(Text4.equalsIgnoreCase(array[5]))
												{
													driver.findElement(By.xpath(".//*[@id='divEmailSubscription']/table/tbody/tr[8]/td[2]/input["+c+"]")).click();
												}
											}
											Thread.sleep(3000);
											driver.findElement(By.xpath(Object.getProperty("SubscriptionSave"))).click();
											Thread.sleep(500);
											if(t.isAlertPresent(driver))
											{
												driver.switchTo().alert().accept();
												Thread.sleep(1000);
												System.out.println("Alert Present");
												while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
												{
													System.out.println("inside while");
													Thread.sleep(1000);
												}
												acop = "Email Subscription Created Successfully.";
												node.log(LogStatus.PASS, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Pass", t.timestamp(stime)});
												rc++;
												s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
												System.out.println( "###################Test case 22 execution completed############################");
											}
											else
											{
												System.out.println("Alert Not Pressent");
												acop = "Alert not Presenting";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 22 execution completed############################");
											}
											
										}
									}	
								}
								else
								{	
									System.out.println("Fail");
									acop = "Subscription Button not Working Well.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][5], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 22 execution completed############################");
								}
								Thread.sleep(10000);
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
						}
					
						
						
						
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