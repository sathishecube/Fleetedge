package Test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import FleetEdge_Core.Core;
import FleetEdge_Util.*;

public class Email_Report extends Core
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]>EmailReportcases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase)
	{
		String acop =null;
		String[][] d2 = s.Read(path, sheet);
		ExtentTest node = reports.startTest("EmailReport");
		
		try
		{
			Util.set();
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
							data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 1 execution completed############################");
						}
						else
						{
							System.out.println("Page loaded Successfully");
							acop = "Fleet Status Page Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Pass" );
							System.out.println( "###################Test case 1 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
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
						driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[1]/table/tbody/tr/td[2]/div/div/ul/li[2]/div/div/ul/li[3]/a")).click();
						Thread.sleep(10000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(10000);
						String d=driver.findElement(By.xpath(".//*[@id='lblMenuPath2']")).getText();
						System.out.println(d);
						//d.equalsIgnoreCase("TEREX MATERIALS PROC • TIME-FENCE")
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("MySubscription")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationMonthly")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationWeekly")), driver) 
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationDaily")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("Warning")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("OperationHours")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("FenceAlert")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportCompanySearchBox")), driver))
						{
							System.out.println("Email Report Passed.");
							acop = "Email Report  Page Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Pass" );
							System.out.println( "###################Test case 2 execution completed############################");
						}
						else
						{
							System.out.println("Some of Element Missing in the Time Fence.");
							acop = "Email Report Page not Loaded Successfully";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 2 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				//My Subscription Verify.
				if(d2[i][0].equalsIgnoreCase("TC3"))
				{
					try
					{
						System.out.println( "###################Test case 3 is executing############################");
						AddFilter.pageNavigater();
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("MySubscription"))).click();
						Thread.sleep(8000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationMonthlyReport")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationWeeklyReport")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationDailyReport")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("WarningReport")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("OperatingHoursReport")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("FenceAlertReport")), driver))
						{
							System.out.println("My Subsription Passed.");
							acop = "My Subscription Tab Displaying as Expected.";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Pass" );
							System.out.println( "###################Test case 3 execution completed############################");
						}
						else
						{
							acop = "My Subscription Tab Missing Some of Element";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 3 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				//Utilization Monthly Tab.
				if(d2[i][0].equalsIgnoreCase("TC4"))
				{
					try
					{
						System.out.println( "###################Test case 4 is executing############################");
						String sDate=t.date(d2[3][5]);
						String str=d2[3][4];
						String asset=d2[3][3];
						String [] assetArray=asset.split(",");
						String [] strArray=str.split(",");
						AddFilter.pageNavigater();
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("UtilizationMonthly"))).click();
						Thread.sleep(3000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("Inside");
							Thread.sleep(1000);	
						}
						Thread.sleep(5000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("EmailFleetDashboard")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationMonthlySetting")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationMonthlySearchbox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationMonthlyPage")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationMonthlySetting")), driver)&& t.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationMonthlySearchbox")), driver))
						{
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyFav")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyEquipmentId")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlySerialNo")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyOwner")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyMake")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyModel")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyCategory")), driver))
							{
								System.out.println("dashboard pass.");
							}
							else
							{
								acop = "Some of Element Missing in Fleet Dashboard.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 4 execution completed############################");						
							}
							
							//Utilization Settings.
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyStartDate")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyDayofMonth")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyRecieveTime")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyClearButton")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlySaveButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyCancelButton")), driver))
							{
								
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationMonthlySearchbox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationMonthlySearchClearButton")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationMonthlySearchButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationMonthlySearchType")), driver))
								{
									for(int k=0;k<assetArray.length;k++)
									{
										WebElement search=driver.findElement(By.xpath(Object.getProperty("UtilizationMonthlySearchType")));
										List<WebElement> searchList=search.findElements(By.tagName("option"));
										for(WebElement text2 : searchList)
										{
											System.out.println(text2.getText());
											if(text2.getText().equalsIgnoreCase(strArray[2]))
											{
												text2.click();
											}
										}
										Thread.sleep(3000);
										driver.findElement(By.xpath(Object.getProperty("UtilizationMonthlySearchbox"))).clear();
										Thread.sleep(3000);
										driver.findElement(By.xpath(Object.getProperty("UtilizationMonthlySearchbox"))).sendKeys(assetArray[k]);
										Thread.sleep(2000);
										driver.findElement(By.xpath(Object.getProperty("UtilizationMonthlySearchButton"))).click();
										Thread.sleep(3000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("Inside");
											Thread.sleep(1000);	
										}
										Thread.sleep(5000);
										driver.findElement(By.xpath("//*[@id='EquipmentId_0']")).click();
										Thread.sleep(4000);
									}
								}
								else
								{
									System.out.println("Some Element Missing in the Search");
									acop = "Some Element Missing in the Search Module.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 4 execution completed############################");
								}
								driver.findElement(By.xpath(Object.getProperty("MonthlyStartDate"))).clear();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("MonthlyStartDate"))).sendKeys(sDate);
								Thread.sleep(3000);
								WebElement day=driver.findElement(By.xpath(Object.getProperty("MonthlyDayofMonth")));
								List<WebElement> dayList=day.findElements(By.tagName("option"));
								for(WebElement text : dayList)
								{
									System.out.println("Text : "+text.getText());
									if(text.getText().equalsIgnoreCase(strArray[0]))
									{
										text.click();
									}
								}
								driver.findElement(By.xpath(Object.getProperty("MonthlyRecieveTime"))).clear();
								Thread.sleep(3000);
								driver.findElement(By.xpath(Object.getProperty("MonthlyRecieveTime"))).sendKeys(strArray[1]);
								Thread.sleep(3000);
								driver.findElement(By.xpath(Object.getProperty("MonthlySaveButton"))).click();
								Thread.sleep(8000);
								if(t.isAlertPresent(driver))
								{
									driver.switchTo().alert().accept();
								}
								else
								{
									System.out.println("Saved Alert is missing.");
									acop = "Saved Alert is Missing.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 4 execution completed############################");
								}
								Thread.sleep(8000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("Inside");
									Thread.sleep(1000);	
								}
								Thread.sleep(5000);
								String label=driver.findElement(By.xpath(Object.getProperty("UtilizationMonthlyLabel"))).getText();
								System.out.println("Label : "+label);
								driver.findElement(By.xpath(Object.getProperty("MySubscription"))).click();
								Thread.sleep(15000);
								driver.findElement(By.xpath(Object.getProperty("UtilizationMonthlyReport"))).click();
								Thread.sleep(5000);
								String labelReport=driver.findElement(By.xpath(Object.getProperty("MonthlyReportLabel"))).getText();
								boolean  val = AddFilter.monthlyUtilization("MonthlyStartDate", "MonthlyDayofMonth", strArray[0], "MonthlyRecieveTime", sDate, "true", strArray[1]); 
								System.out.println("Boolean : "+val);
								if(val==true && labelReport.equalsIgnoreCase(label))
								{
									acop = "SuccessFully Saved utilization Monthly Report.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 4 execution completed############################");
								}
								else
								{
									acop = "Unable to Save the Monthly Utilization Report.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 4 execution completed############################");
								}
								
								//Clear
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("UtilizationMonthly"))).click();
								Thread.sleep(15000);
								driver.findElement(By.xpath(Object.getProperty("MonthlyClearButton"))).click();
								Thread.sleep(3000);
								if(t.isAlertPresent(driver))
								{
									driver.switchTo().alert().accept();
									Thread.sleep(8000);
									if(t.isAlertPresent(driver))
									{
										driver.switchTo().alert().accept();
										Thread.sleep(5000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("Inside");
											Thread.sleep(1000);	
										}
									}
									else
									{
										System.out.println("Deleted Alert is missing.");
										acop = "SuccessFully Deleted Alert is Missing.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 4 execution completed############################");
									}
								}
								else
								{
									System.out.println("Clear Alert is missing.");
									acop = "Clear Alert Missing.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 4 execution completed############################");
								}
								Thread.sleep(10000);
								String label1=driver.findElement(By.xpath(Object.getProperty("UtilizationMonthlyLabel"))).getText();
								System.out.println("Label : "+label1);
								String date=t.date("Today");
								System.out.println("date : "+date);
						//		boolean  val1 = AddFilter.dum("MonthlyStartDate", "MonthlyDayofMonth", "1", "MonthlyRecieveTime", "UtilizationMonthlyLabel", date, "true", strArray[1], label1);
								boolean  val1 = AddFilter.monthlyUtilization("MonthlyStartDate", "MonthlyDayofMonth", "1", "MonthlyRecieveTime", date, "true", "12:00 PM");
								System.out.println("val 1"+val1);
								if(val1==true &&(!label1.equalsIgnoreCase(label)))
								{
									System.out.println("Clear Pass");
									acop = "Clear Button Working as Expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 4 execution completed############################");
								}
								else
								{
									acop = "Clear Button not Working as Expected.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 4 execution completed############################");
								}
								
								//Cancel 
								driver.findElement(By.xpath(Object.getProperty("MonthlyStartDate"))).clear();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("MonthlyStartDate"))).sendKeys(sDate);
								Thread.sleep(3000);
								WebElement day1=driver.findElement(By.xpath(Object.getProperty("MonthlyDayofMonth")));
								List<WebElement> dayList1=day1.findElements(By.tagName("option"));
								for(WebElement text : dayList1)
								{
									System.out.println("Text : "+text.getText());
									if(text.getText().equalsIgnoreCase(strArray[0]))
									{
										text.click();
									}
								}
							//	String label11=driver.findElement(By.xpath(Object.getProperty("MonthlyReportLabel"))).getText();
								driver.findElement(By.xpath(Object.getProperty("MonthlyRecieveTime"))).clear();
								Thread.sleep(3000);
								driver.findElement(By.xpath(Object.getProperty("MonthlyRecieveTime"))).sendKeys(strArray[1]);
								Thread.sleep(3000);
								driver.findElement(By.xpath(Object.getProperty("MonthlyCancelButton"))).click();
								Thread.sleep(3000);
								if(t.isAlertPresent(driver))
								{
									driver.switchTo().alert().accept();
									Thread.sleep(3000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("Inside");
										Thread.sleep(1000);	
									}
								}
								else
								{
									System.out.println("Cancel Alert is missing.");
									acop = "Cancel Alert is Missing.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 4 execution completed############################");
								}
								Thread.sleep(8000);
								String label2=driver.findElement(By.xpath(Object.getProperty("UtilizationMonthlyLabel"))).getText();
								boolean  val11 = AddFilter.monthlyUtilization("MonthlyStartDate", "MonthlyDayofMonth", "1", "MonthlyRecieveTime", date, "true", "12:00 PM");
								System.out.println("val 1 : "+val11);
								if(val11 == true && (!label2.equalsIgnoreCase(label)))
								{
									System.out.println("Cancel Pass");
									acop = "Cancel Button Working as Expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 4 execution completed############################");
								}
								else
								{
									acop = "Cancel Button is not Working as Expected.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 4 execution completed############################");
								}
							}
							else
							{
								System.out.println("Some of Element Missing in the Monthly Utilization.");
								acop = "Some of Element Missing in the Monthly Utilization.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 4 execution completed############################");
							}
						}
						else
						{
							System.out.println("Utilization Monthly Fail.");
							acop = "Utilization Monthly Tab is not Displaying.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 4 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				//Utilization Monthly Report
				if(d2[i][0].equalsIgnoreCase("TC5"))
				{
					try
					{
						System.out.println( "###################Test case 5 is executing############################");
						String sDate=t.date(d2[4][5]);
						String str=d2[4][4];
						String [] strArray=str.split(",");
				//		AddFilter.pageNavigater();
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("MySubscription"))).click();
						Thread.sleep(10000);
						driver.findElement(By.xpath(Object.getProperty("UtilizationMonthlyReport"))).click();
						Thread.sleep(10000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyReportPeriodControl")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyStartDate")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyDayofMonth")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyRecieveTime")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyClearButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlySaveButton")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyCancelButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("MonthlyReportLabel")), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("MonthlyStartDate"))).clear();
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("MonthlyStartDate"))).sendKeys(sDate);
							Thread.sleep(3000);
							driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div/table/tbody/tr/td/div[2]/div[1]/div/div[2]/div/div[2]/div[1]/table/tbody/tr[2]/td[1]"));
							WebElement day=driver.findElement(By.xpath(Object.getProperty("MonthlyDayofMonth")));
							List<WebElement> dayList=day.findElements(By.tagName("option"));
							for(WebElement text : dayList)
							{
								System.out.println("Text : "+text.getText());
								if(text.getText().equalsIgnoreCase(strArray[0]))
								{
									text.click();
								}
							}
							driver.findElement(By.xpath(Object.getProperty("MonthlyRecieveTime"))).clear();
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("MonthlyRecieveTime"))).sendKeys(strArray[1]);
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("MonthlySaveButton"))).click();
							Thread.sleep(8000);
							if(t.isAlertPresent(driver))
							{
								driver.switchTo().alert().accept();
							}
							else
							{
								System.out.println("Saved Alert is missing.");
								acop = "Saved Alert is Missing.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
							Thread.sleep(8000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("Inside");
								Thread.sleep(1000);	
							}
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("UtilizationMonthlyReport"))).click();
							Thread.sleep(10000); 
							String label=driver.findElement(By.xpath(Object.getProperty("MonthlyReportLabel"))).getText();
							System.out.println("Label : "+label);
							driver.findElement(By.xpath(Object.getProperty("UtilizationMonthly"))).click();
							Thread.sleep(15000);
							String labelReport=driver.findElement(By.xpath(Object.getProperty("UtilizationMonthlyLabel"))).getText();
							boolean  val = AddFilter.monthlyUtilization("MonthlyStartDate", "MonthlyDayofMonth", strArray[0], "MonthlyRecieveTime", sDate, "true", strArray[1]); 
							System.out.println("Boolean : "+val);
							if(val==true && labelReport.equalsIgnoreCase(label))
							{
								acop = "SuccessFully Saved Utilization Monthly Report.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
							else
							{
								acop = "Unable to Save the Monthly Utilization Report.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
													
							//Clear
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("MySubscription"))).click();
							Thread.sleep(15000);
							driver.findElement(By.xpath(Object.getProperty("UtilizationMonthlyReport"))).click();
							Thread.sleep(10000);
							driver.findElement(By.xpath(Object.getProperty("MonthlyClearButton"))).click();
							Thread.sleep(3000);
							if(t.isAlertPresent(driver))
							{
								driver.switchTo().alert().accept();
								Thread.sleep(8000);
								if(t.isAlertPresent(driver))
								{
									driver.switchTo().alert().accept();
									Thread.sleep(5000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("Inside");
										Thread.sleep(1000);	
									}
								}
								else
								{
									System.out.println("Deleted Alert is missing.");
									acop = "SuccessFully Deleted Alert is Missing.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 5 execution completed############################");
								}
							}
							else
							{
								System.out.println("Clear Alert is missing.");
								acop = "Clear Alert Missing.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("UtilizationMonthlyReport"))).click();
							Thread.sleep(10000);
							String label1=driver.findElement(By.xpath(Object.getProperty("MonthlyReportLabel"))).getText();
							System.out.println("Label : "+label1);
							String date=t.date("Today");
							System.out.println("date : "+date);
							boolean  val1 = AddFilter.monthlyUtilization("MonthlyStartDate", "MonthlyDayofMonth", "8", "MonthlyRecieveTime", date, "true", "12:00 PM");
							System.out.println("val 1"+val1);
							if(val1==true &&(!label1.equalsIgnoreCase(label)))
							{
								System.out.println("Clear Pass");
								acop = "Clear Button Working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
							else
							{
								acop = "Clear Button not Working as Expected.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
						}
						else
						{
							System.out.println("Some of Element Missing in  the Utilization Monthly Report.");
							acop = "Some of Element Missing in  the Utilization Monthly Report.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "EmailReport", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "EmailReport", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 5 execution completed############################");
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
