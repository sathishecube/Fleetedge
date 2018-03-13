package Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import FleetEdge_Core.Core;
import FleetEdge_Util.*;

public class FleetSummary extends Core
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]>FleetSummarycases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase)
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
							data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 1 execution completed############################");
						}
						else
						{
							System.out.println("Page loaded Successfully");
							acop = "Fleet Status Page Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							 s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
							System.out.println( "###################Test case 1 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					
				}
					
				//Fleet Summary Navigation	
				if(d2[i][0].equalsIgnoreCase("TC2"))
				{
					try
					{
						System.out.println( "###################Test case 2 is executing############################");
			//			AddFilter.pageNavigater();
						Actions action = new Actions(driver);
						WebElement Fleet=driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/a"));	
						action.moveToElement(Fleet);
						action.click().perform();
						Thread.sleep(1000);
						driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/div/div[1]/ul/li[2]/a")).click();
						Thread.sleep(10000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(10000);
						String d=driver.findElement(By.xpath(".//*[@id='lblMenuPath2']")).getText();
						System.out.println(d);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("Highlight")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("Columns")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("Download")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("Dashboard")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("Show")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("GotoPage")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("DateRange")), driver) && d.equalsIgnoreCase("TEREX MATERIALS PROC • FLEET • FLEET SUMMARY"))
						{
							System.out.println("Page loaded Successfully");
							acop = "Fleet Status Page Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
							System.out.println( "###################Test case 2 execution completed############################");			
						}
						else
						{
							System.out.println("Page not loaded Successfully");
							acop = "Fleet Status Page not Loaded Successfully";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 2 execution completed############################");
						}
						Thread.sleep(10000);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				//Date Setting
				if(d2[i][0].equalsIgnoreCase("TC3"))
				{
					try
					{
						String Str=d2[2][4].toString();
						String[] array=Str.split(",");
						String Str2=d2[2][3].toString();
						String[] array2=Str2.split(",");
				//		AddFilter.pageNavigater();
						Thread.sleep(3000);
						float todayValue=AddFilter.dashboardValue(array2[0],"8");
				    	System.out.println("Today"+todayValue);
						Thread.sleep(3000);
						for(int j=1;j<=array.length;j++)
						{
							WebElement options = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul"));
							List<WebElement> li = options.findElements(By.cssSelector("[id^=lnk]"));
							String Text=li.get(j-1).getAttribute("innerHTML");
							if(Text.equalsIgnoreCase(array[j-1]))
							{
								Actions action = new Actions(driver);
								WebElement Fleet=driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/a"));	
								action.moveToElement(Fleet);
								action.click().perform();
								Thread.sleep(1000);
								driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li["+j+"]")).click();
								Thread.sleep(3000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(5000);
								String assetName=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportFreeze']/tbody/tr[8]/td[2]")).getText();
								System.out.println("Asset Name : "+assetName);
							   	float presentDayValue =AddFilter.dashboardValue(array2[0],"8");
								System.out.println("presentDay Value : "+presentDayValue);
								Thread.sleep(3000);
								if(todayValue<=presentDayValue)
								{
									driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportFreeze']/tbody/tr[8]/td[2]")).click();  
									Thread.sleep(15000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
									   System.out.println("inside while");
									   Thread.sleep(1000);
									}
									Thread.sleep(20000);	
									WebElement options1 = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul"));
									List<WebElement> li1 = options1.findElements(By.cssSelector("[id^=lnk]"));
									String Text1=li1.get(j-1).getAttribute("innerHTML");
									if(Text1.equalsIgnoreCase(array[j-1]))
									{
										Actions action1 = new Actions(driver);
										WebElement Fleet1=driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/a"));	
										action1.moveToElement(Fleet1);
										action1.click().perform();
										Thread.sleep(1000);
										driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li["+j+"]")).click();
										Thread.sleep(5000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
										   System.out.println("inside while");
										   Thread.sleep(1000);
										}
										Thread.sleep(5000);
									 }
									 String AssetName=driver.findElement(By.xpath(Object.getProperty("AssetName"))).getText();
									 System.out.println("Asset Name : "+AssetName);
									 if(assetName.equalsIgnoreCase(AssetName))
									 {
										 System.out.println("Asset Name Same");
										 WebElement tab=driver.findElement(By.xpath(".//*[@id='asset_tabs']/ul"));
										 List<WebElement>Tab=tab.findElements(By.tagName("li"));
										 Thread.sleep(5000);
										 for(WebElement text3 : Tab)
										 {
											 String Text3=text3.getText();
											 System.out.println(Text3);
											 if(Text3.equals(d2[2][2]))
											 {
												 Thread.sleep(3000);
												 text3.click();
												 Thread.sleep(5000);
												 while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
												 {
													System.out.println("inside while");
													Thread.sleep(1000);
												 }
												 Thread.sleep(15000);
												 int m=1;
												 float totalValue = AddFilter.dashboardValue(array2[0], "2"); 	
												 System.out.println("total Value : "+totalValue);
												 if(totalValue == presentDayValue)
												 {
													 System.out.println("Success");
													 Thread.sleep(3000);
													 acop = "Date Verification Working as Expected.";
													 node.log(LogStatus.PASS, acop);
													 data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
													 rc++;
													 s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
													 System.out.println( "###################Test case 3 execution completed############################");
												//	 AddFilter.pageNavigater();
													 Actions action1 = new Actions(driver);
													 WebElement Fleet1=driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/a"));	
													 action1.moveToElement(Fleet1);
													 action1.click().perform();
													 Thread.sleep(1000);
													 driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/div/div[1]/ul/li[2]/a")).click();
													 Thread.sleep(10000);
													 while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
													 {
													     System.out.println("inside while");
													   	 Thread.sleep(1000);
													}
													Thread.sleep(5000);	
												 }   
												 else
												 {
													 System.out.println(array[j-1]+" : Values Not Matching");
													 Thread.sleep(5000);
													 acop = array[j-1]+" : Values Not Matching";
													 node.log(LogStatus.FAIL, acop);
													 data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
													 rc++;
													 String scr = t.CaptureScreenshot();
												     s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
													 System.out.println( "###################Test case 3 execution completed############################");
													// AddFilter.pageNavigater();
													 Actions action1 = new Actions(driver);
													 WebElement Fleet1=driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/a"));	
													 action1.moveToElement(Fleet1);
													 action1.click().perform();
													 Thread.sleep(1000);
													 driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/div/div[1]/ul/li[2]/a")).click();
													 Thread.sleep(10000);
													 while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
													 {
														System.out.println("inside while");
														Thread.sleep(1000);
													}
													Thread.sleep(5000);					
												 }
											/*	 WebElement sensors=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
												 List<WebElement> Sensors=sensors.findElements(By.tagName("th"));
												 Thread.sleep(3000);
												 for(WebElement sen : Sensors)
												 {
													 m++;
													 String Sen=sen.getText().toString();
													 if(Sen.equalsIgnoreCase(array2[0]))
													 {
														
														 break;
													 }		  
												 }  */
												 break;
											   }
										   }
										  Thread.sleep(5000);
									   }
								   }
								   	else
								   	{
										System.out.println("Value Lower than Present");
										acop = "Value lower than Present Value";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 3 execution completed############################");
									}
									Thread.sleep(5000);
							}
							else
							{
								System.out.println(array[j-1]+" Dafault Date Missing");
								acop = array[j-1]+" Dafault Date Missing";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 3 execution completed############################");
							}
							
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
					
				//Custom Date
				if(d2[i][0].equalsIgnoreCase("TC4"))
				{
					try
					{
						Thread.sleep(5000);
						String Str=d2[3][4].toString();
						String [] array=Str.split(",");
						String startDate =t.date(d2[3][5]);
						String endDate = t.date(d2[3][6]);
						Thread.sleep(5000);
					//	AddFilter.pageNavigater();
						Actions action = new Actions(driver);
						WebElement Fleet=driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/a"));	
						action.moveToElement(Fleet);
						action.click().perform();
						Thread.sleep(1000);
						driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/div/div[1]/ul/li[2]/a")).click();
						Thread.sleep(10000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(8000);
						int j=0;
						Float todayValue = AddFilter.dashboardValue(array[0],"10");
						System.out.println("todayvalue : "+todayValue);
						WebElement options1 = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul"));
						List<WebElement> li1 = options1.findElements(By.cssSelector("[id^=lnk]"));
						for(WebElement text : li1)
						{
							j++;
						   String Text=text.getAttribute("id");
						   if(Text.equalsIgnoreCase("lnkCustom"))
						   {
							   Actions action1 = new Actions(driver);
							   WebElement Fleet1=driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/a"));	
							   action1.moveToElement(Fleet1);
							   action1.click().perform();
							   Thread.sleep(1000);
							   driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li["+j+"]")).click();						
						   }  
					   }
						Thread.sleep(3000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("CustomDate")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("CustomStartDate")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("CustomEndDate")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("CustomSearchButton")), driver))
						{
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("CustomStartDate"))).clear();
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("CustomStartDate"))).sendKeys(startDate);
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("CustomEndDate"))).clear();
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("CustomEndDate"))).sendKeys(endDate);
							Thread.sleep(2000);
							driver.findElement(By.xpath(".//*[@id='MainContainer_lblStartDate']")).click();
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("CustomSearchButton"))).click();
							Thread.sleep(2000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
							   System.out.println("inside while");
							   Thread.sleep(1000);
							}
							Thread.sleep(5000);
							float value=AddFilter.dashboardValue(array[0],"10");
							System.out.println("Value dash : "+value );	
							if(todayValue<=value)
							{
								System.out.println("Success");
								driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportFreeze']/tbody/tr[10]/td[2]")).click();
								Thread.sleep(20000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
								   System.out.println("inside while");
								   Thread.sleep(1000);
								}
								Thread.sleep(5000);
								WebElement options = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul"));
								List<WebElement> li = options.findElements(By.cssSelector("[id^=lnk]"));
								int m=0;
								for(WebElement text : li)
								{
									m++;
								   String Text=text.getAttribute("id");
								   if(Text.equalsIgnoreCase("lnkCustom"))
								   {
									   Actions action1 = new Actions(driver);
									   WebElement Fleet1=driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/a"));	
									   action1.moveToElement(Fleet1);
									   action1.click().perform();
									   Thread.sleep(1000);
									   driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li["+m+"]")).click();	
									   Thread.sleep(2000);
									   driver.findElement(By.xpath(Object.getProperty("CustomStartDate"))).clear();
									   Thread.sleep(1000);
									   driver.findElement(By.xpath(Object.getProperty("CustomStartDate"))).sendKeys(startDate);
									   Thread.sleep(2000);
									   driver.findElement(By.xpath(Object.getProperty("CustomEndDate"))).clear();
									   Thread.sleep(1000);
									   driver.findElement(By.xpath(Object.getProperty("CustomEndDate"))).sendKeys(endDate);
									   Thread.sleep(2000);
									   driver.findElement(By.xpath(".//*[@id='MainContainer_lblStartDate']")).click();
									   Thread.sleep(2000);
									   driver.findElement(By.xpath(Object.getProperty("CustomSearchButton"))).click();
									   Thread.sleep(2000);
									   while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									   {
										  System.out.println("inside while");
										  Thread.sleep(1000);
									   }
										Thread.sleep(5000);
										break;
								   }  
							   }
									Thread.sleep(3000);
									WebElement tab=driver.findElement(By.xpath(".//*[@id='asset_tabs']/ul"));
									List<WebElement>Tab=tab.findElements(By.tagName("li"));
									Thread.sleep(5000);
									for(WebElement text3 : Tab)
									{
									   String Text3=text3.getText();
									   System.out.println(Text3);
									   if(Text3.equals(d2[3][2]))
									   {
										   Thread.sleep(3000);
										   text3.click();
										   Thread.sleep(5000);
										   while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										   {
											   System.out.println("inside while");
											   Thread.sleep(1000);
										   }
										   Thread.sleep(5000);
										   break;
									   }
									}
									Thread.sleep(5000);
									WebElement sensors=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
									List<WebElement> Sensors=sensors.findElements(By.tagName("th"));
									Thread.sleep(3000);
									float TotalValue = 0;
									//  totalValue=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr[2]/td["+m1+"]")).getText();
									TotalValue=AddFilter.dashboardValue(array[0], "2");   
									System.out.println("Total Value : "+TotalValue);
									if(value==TotalValue)
									{
										System.out.println("Completed");
									  	acop = "Custom Date Range Working as Expected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 4 execution completed############################");
										
										Thread.sleep(3000);
									//	AddFilter.pageNavigater(); 
										Actions action1 = new Actions(driver);
										WebElement Fleet1=driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/a"));	
										action1.moveToElement(Fleet1);
										action1.click().perform();
										Thread.sleep(1000);
										driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/div/div[1]/ul/li[2]/a")).click();
										Thread.sleep(10000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(5000);
									}
									 else
									 {
										 acop = "Custom Date Range Not Working as Expected, Data MissMatch. ";
										 node.log(LogStatus.FAIL, acop);
										 data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										 rc++;
										 String scr = t.CaptureScreenshot();
										 s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
										 System.out.println( "###################Test case 4 execution completed############################");
										 Actions action1 = new Actions(driver);
										 WebElement Fleet1=driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/a"));	
										 action1.moveToElement(Fleet1);
										 action1.click().perform();
										 Thread.sleep(1000);
										 driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/div/div[1]/ul/li[2]/a")).click();
										 Thread.sleep(10000);
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
								acop = "Presentdate value is higher than selected date. ";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 4 execution completed############################");		
							}
						}
						else
						{
							System.out.println("Custom Date Not Popups.");
							acop = "Custom Date Table is not Displays. ";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 4 execution completed############################");		
						}
					}						
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				//Column
				if(d2[i][0].equalsIgnoreCase("TC5"))	
				{
					try
					{
					//	AddFilter.pageNavigater();
						System.out.println( "###################Test case 5 is executing############################");
						Integer Str=Integer.parseInt(d2[4][4]);
						System.out.println("Integer : "+Str);
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
						//	WebElement Head=driver.findElement(By.xpath(".//*[@id='drpRCSettingColumnList']"));
						//	List<WebElement> headers=Head.findElements(By.tagName("option"));
							WebElement s1 = driver.findElement(By.xpath(Object.getProperty("SelectedReportColumns")));
							List<WebElement> size=s1.findElements(By.tagName("option"));
							int k=size.size();
							System.out.println("K"+k);
							while(k<=Str)
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
								data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
							else
							{
								System.out.println("Pagination not Displayed ");
								acop = "Alert is not popups. ";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 5 execution completed############################");										
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
							data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 5 execution completed############################");		
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
				}
				
				//Column Modify
				if(d2[i][0].equalsIgnoreCase("TC6"))	
				{
					System.out.println( "###################Test case 6 is executing############################");
					try
					{	
						Thread.sleep(5000);
				//		AddFilter.pageNavigater();
						Thread.sleep(3000);
						String Str=d2[5][4].toString();
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
							//	driver.findElement(By.xpath(Object.getProperty("ReportColumns"))).click();
								WebElement web=driver.findElement(By.xpath(".//*[@id='drpRCSettingColumnList']"));
								List<WebElement> report=web.findElements(By.tagName("option"));
								for(int k=0;k<report.size();k++)
								{
									String Report1=report.get(k).getText();
									if(Report1.equalsIgnoreCase(arry[j]))
									{									
									//	driver.findElement(By.xpath(Object.getProperty("ReportColumns"))).click();
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
												data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
												rc++;
												s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
												System.out.println( "###################Test case 6 execution completed1############################");
											}
											System.out.println("Selected Element is Moved up Successfully.");
										}
										else
										{
											System.out.println("Element Moving Up");
											acop = "Unable to move the selected Element to up.";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 6 execution completed############################");		
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
											data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
											rc++;
											s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
											System.out.println( "###################Test case 6 execution completed1############################");
										}
										else
										{
											System.out.println("Element Moving Down");
											acop = "Unable to move the selected Element to Down.";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 6 execution completed############################");													
										}
									}
									else
									{
										System.out.println("Element Moving Down");
										acop = "Unable to move the selected Element to Down.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 6 execution completed############################");
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
										data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 6 execution completed############################");											
									}
									else
									{
										acop = "Column Reoved Successfully";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 6 execution completed1############################");										
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
							data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 6 execution completed############################");
						}
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
				
				
				
				//Adding New Report Column
				if(d2[i][0].equalsIgnoreCase("TC7"))	
				{
					try
					{
						System.out.println( "###################Test case 7 is executing############################");
				//		AddFilter.pageNavigater();
						String Str=d2[6][4].toString();
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
							driver.findElement(By.xpath(Object.getProperty("SaveAsNewReportName"))).sendKeys(d2[6][2]);
							Thread.sleep(1000);
							Select select=new Select(driver.findElement(By.xpath(".//*[@id='MainContainer_drpUserType']")));
							List<WebElement> dropdown=select.getOptions();
							for(WebElement drop : dropdown)
							{
								if(drop.equals("d2[6][3]"))
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
							if(d.equalsIgnoreCase("Terex Materials Proc • FLEET • FLEET Summary"))
							{
								System.out.println("Report Created SuccessFully");
							}
							else
							{
								System.out.println("Unable to save the report");
								acop = "Unable to Save the Report";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 7 execution completed############################");
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
								if(UserDefined.getText().equals(d2[6][2]))
								{
									System.out.println("Navigate to user Defined page :"+d2[6][2]);
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
							if(name.equalsIgnoreCase("TEREX MATERIALS PROC • FLEET • "+d2[6][2]))
							{
								acop = "Report Created and Navigated to "+d2[10][2]+" Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "FleetStatus", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 7 execution completed1############################");	
								
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
								acop = "Unable to Navigate to "+d2[6][2]+"Page.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 7 execution completed############################");	
							}
						}
						else
						{
						System.out.println("Save Report Button not Working");
						acop = "Save Report Button Not Working as Expected.";
						node.log(LogStatus.FAIL, acop);
						data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
						rc++;
						String scr = t.CaptureScreenshot();
						s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
						System.out.println( "###################Test case 7 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				// Delete the user Defined
				if(d2[i][0].equalsIgnoreCase("TC8"))	
				{
					try
					{
						System.out.println( "###################Test case 8 is executing############################");
				//		AddFilter.pageNavigater();
						String Str=d2[7][4].toString();
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
												data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 8 execution completed############################");
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
												data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 8 execution completed############################");
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
													data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
													rc++;
													String scr = t.CaptureScreenshot();
													s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
													System.out.println( "###################Test case 8 execution completed############################");
													break;
												}
												else
												{
													System.out.println("Report "+array[j]+" is Deleted Successfully.");
													acop = "Report "+array[j]+" is Deleted Successfully.";
													node.log(LogStatus.PASS, acop);
													data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
													rc++;
													s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
													System.out.println( "###################Test case 8 execution completed1############################");	
													break;
												}
											}
											break;
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
								data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 8 execution completed1############################");	
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
								data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 8 execution completed############################");
							
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
				if(d2[i][0].equalsIgnoreCase("TC9"))	
				{							
					try
					{
						System.out.println( "###################Test case 9 is executing############################");
				//		AddFilter.pageNavigater();
						Thread.sleep(5000);
						String Str=d2[8][4];
						String s2=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']/th[1]/div")).getText();
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("Dashboard")), driver) && s2.equalsIgnoreCase(Str))
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
										data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 9 execution completed1############################");
									}
									else
									{
										System.out.println("Dashboard Columns is not equal to Column report");
										acop = "Dashboard Columns is not equal to Column report";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 9 execution completed############################");
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
									data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 9 execution completed############################");
								}
							}
							else
							{
								System.out.println("Its not popup any Alert, while Deleting the Fav Column");
								acop = "Its not popup any Alert, while Deleting the Fav Column";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 9 execution completed############################");
							}									
						}
						else 
						{
							System.out.println("Dashboard is not showing properly");
							acop = "Dashboard is not showing properly";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 9 execution completed############################");								}

						}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				
				//Column Sort
				if(d2[i][0].equalsIgnoreCase("TC10"))	
				{
					try
					{	
						String Str=d2[9][4].toString();
						String [] array=Str.split(",");
						System.out.println( "###################Test case 10 is executing############################");
				//		AddFilter.pageNavigater();
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
												data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
												System.out.println( "###################Test case 10 execution completed############################");
											}
											else
											{
												System.out.println("Sort Arrow Missing");
												acop = "Unable to locate and sort the column";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 10 execution completed############################");
											}
										}
										else
										{
											System.out.println("Sort Ascending When a time Total Records got Changed.");
											acop = "Sort Ascending When a time Total Records got Changing";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 10 execution completed############################");
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
												data.put(""+rc, new Object[] {d2[i][0], "FleetStatus", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
												System.out.println( "###################Test case 10 execution completed############################");
											}
											else
											{
												System.out.println("Descending Sort Arrow Missing");
												acop = "Not able to loacte and sort the column";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 10 execution completed############################");
											}
										}
										else
										{
											System.out.println("Sort Descending When a time Total Records got Changing");
											acop = "Sort Descending When a time Total Records got Changing";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 10 execution completed############################");								

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
										data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 10 execution completed############################");								
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
				
				
				
				//HighLight
				if(d2[i][0].equalsIgnoreCase("TC11"))
				{
					try
					{	
						String Str=d2[10][4].toString();
						String[] array=Str.split(",");
						String Str2=d2[10][3].toString();
						String[] array2=Str2.split("#");
						Thread.sleep(5000);
						System.out.println( "###################Test case 11 is executing############################");
				//		AddFilter.pageNavigater();
						Thread.sleep(3000);
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
													data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
													rc++;
													String scr = t.CaptureScreenshot();
													s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
													System.out.println( "###################Test case 11 execution completed############################");															break;
												}
											}
										}	
									}
								}
								if(flag==1)
								{
									acop = "Highligh Rows Working as Expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 11 execution completed############################");
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
													data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
													rc++;
													String scr = t.CaptureScreenshot();
													s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
													System.out.println( "###################Test case 11 execution completed############################");
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
									data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 11 execution completed############################");
								}
								Thread.sleep(3000);
								boolean row=AddFilter.chkHighlightupdate("2", "HighlightRowColor", array[8], array[1], array[3], array2[2]);
								///System.out.println(row);
								if(true==row)
								{
									System.out.println("Selected Row Color Changed");
									acop = "Highlight Update Working as Expected For Rows Highlight.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 11 execution completed############################");
								}
								else
								{
									System.out.println("unable to Update new Color");
									acop = "Unable to Update new Color on Rows";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 11 execution completed############################");
								}
								Thread.sleep(3000);
								boolean column=AddFilter.chkHighlightupdate("3", "HighlightColumnColor", array[9], array[5], array[7], array2[3]);
							//	System.out.println("Column : " +column);
								if(true==column)
								{
									System.out.println("Selected Column Color Changed");
									acop = "Highlight Update Working as Expected for Columns Highlight.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 11 execution completed############################");
								}
								else
								{
									System.out.println("unalbe to update new Color in Column");
									acop = "Unable to Update new Color on Columns";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 11 execution completed############################");
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
										data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 11 execution completed############################");
									}
									else
									{
										acop = "Delete Alert Missing";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 11 execution completed############################");
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
										data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 11 execution completed############################");											}
									else
									{
										System.out.println("clear");
										acop = "Highlight Clear Button Working as Expected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 11 execution completed############################");											
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
										data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 11 execution completed############################");											
									}
									else
									{
										System.out.println("Close");
										acop = "Highlights Working  as Expected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 11 execution completed############################");
									}
							}
							else
							{
								acop = "Highlight New Button not Working as Expected.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 11 execution completed############################");									
							}
								Thread.sleep(10000);
						}
						else
						{
							acop = "Highlight Button Not Working as Expected.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 11 execution completed############################");								
						}
						Thread.sleep(10000);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				

				
				//Show Records
				if(d2[i][0].equalsIgnoreCase("TC12"))
				{
					try
					{
						String Str=d2[11][4].toString();
						String[] array=Str.split(",");
				//		AddFilter.pageNavigater();
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
										data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 12 execution completed############################");
									}
									else
									{
										System.out.println("Changing Records Page to "+val[k]+"While Total Records COunt Got Changed");
										acop = "Changing Records Page to "+val[k]+"While Total Records COunt Got Changed";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 12 execution completed############################");
									}											
								}
								else
								{
									System.out.println("Per Page Record Count MissMatch");
									acop = "Per Page Record Count MissMatch";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 12 execution completed############################");
								}
							}
					}
					else
					{
						System.out.println("Records Column Missing");
						acop = "Records Column Missing";
						node.log(LogStatus.FAIL, acop);
						data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
						rc++;
						String scr = t.CaptureScreenshot();
						s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
						System.out.println( "###################Test case 12 execution completed############################");								

					}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				
				//Page No of Records
				if(d2[i][0].equalsIgnoreCase("TC13"))	
				{
					try
					{
						System.out.println( "###################Test case 13 is executing############################");
			//			AddFilter.pageNavigater();
						String page=d2[12][4];
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
								data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 13 execution completed############################");	
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
											data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
											rc++;
											s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
											System.out.println( "###################Test case 13 execution completed1############################");
											break;
										}
										else
										{
											System.out.println("Current Page doesnot match the Page which is selected ");
											acop = "Pagination not displayed as expected";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 13 execution completed############################");
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
							data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 13 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				
				//File Download
				if(d2[i][0].equalsIgnoreCase("TC14"))
				{
					try
					{
			//			AddFilter.pageNavigater();
						Actions action = new Actions(driver);
						WebElement Fleet=driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/a"));	
						action.moveToElement(Fleet);
						action.click().perform();
						Thread.sleep(1000);
						driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/div/div[1]/ul/li[2]/a")).click();
						Thread.sleep(10000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(10000);
						Thread.sleep(5000);
						String Str=d2[13][4].toString();
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
								Thread.sleep(80000);
								try
								{
									//		BufferedReader reader = new BufferedReader(new FileReader("D:\\workspace\\FleetEdge\\DownloadExcel\\Fleet Status.xlsx"));									
									if(array[k].equalsIgnoreCase("Excel"))
									{
										Robot robot = new Robot();
										robot.keyPress(KeyEvent.VK_DOWN);
										Thread.sleep(500);
										robot.keyRelease(KeyEvent.VK_DOWN);
										Thread.sleep(500);
										robot.keyPress(KeyEvent.VK_ENTER);
										Thread.sleep(500);
										robot.keyRelease(KeyEvent.VK_ENTER);
										Thread.sleep(5000);
										String excelFilePath = "D:\\workspace\\FleetEdge\\DownloadExcel\\Fleet Summary.xlsx";
								//		FileInputStream input = new FileInputStream(new File(excelFilePath));
								//		Workbook workbook = new XSSFWorkbook(input);
								//		Sheet sheet1 = workbook.getSheetAt(0);
								//		System.out.println(sheet1.getLastRowNum());
										int m=0;
								//		input.close();
										//recordsCount=tr.size()-5;
								//		recordsCount=sheet1.getLastRowNum()-4;
										BufferedReader reader = new BufferedReader(new FileReader(excelFilePath));
										String line;
										
										int m1=0;
										while ((line = reader.readLine()) != null)
										{
								//		System.out.println(line);
										
									//	if(line.contains("tr"))
										tr.add(line);
									//	System.out.println(records.get(i));
										m1++;
										}
										reader.close();
										recordsCount=tr.size()-10;
										System.out.println("recordcount"+recordsCount);
									//	System.out.println(recordsCount+":"+pageSize);
										if(recordsCount == pageSize)
										{
											System.out.println("Reocrds count matching... Pass");
											acop = "Record Count Matching With Excel.";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
											rc++;
											s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
											System.out.println( "###################Test case 14 execution completed############################");
										}
										else
										{
											System.out.println("Records count mismatch... Fail");
											acop = "Record Count Mismatch With Excel";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 14 execution completed############################");
										}
									}
									else
									{
										Robot robot = new Robot();	
										robot.keyPress(KeyEvent.VK_ENTER);
										Thread.sleep(500);
										robot.keyRelease(KeyEvent.VK_ENTER);
										Thread.sleep(5000);
										String pdfPath="D:\\workspace\\FleetEdge\\DownloadExcel\\Fleet Summary.pdf";
										PDDocument doc = PDDocument.load(new File(pdfPath));
										int count = doc.getNumberOfPages();
										System.out.println("Count : "+count);
										int val=pageSize/23;
											if(val==count)
										{
											System.out.println("Pdf Pass");
											acop = "Record Count Matching With PDF";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
											rc++;
											s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Pass" );
											System.out.println( "###################Test case 14 execution completed############################");
										}
										else
										{
											System.out.println("Pdf fail");
											acop = "Record Count Mismatch wih PDF";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 14 execution completed############################");
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
								data.put(""+rc, new Object[] {d2[i][0], "FleetSummary", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "FleetSummary", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 14 execution completed############################");
							}
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
