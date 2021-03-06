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

public class EmailReportWizard  extends Core
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]>EmailReportWizardcases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase)
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
							data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 1 execution completed############################");
						}
						else
						{
							System.out.println("Page loaded Successfully");
							acop = "Fleet Status Page Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Pass" );
							System.out.println( "###################Test case 1 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
	
				//Email Report Wizard Verify 
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
						driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[1]/table/tbody/tr/td[2]/div/div/ul/li[2]/div/div/ul/li[5]/a")).click();
						Thread.sleep(10000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(10000);
						String d=driver.findElement(By.xpath(".//*[@id='lblMenuPath2']")).getText();
						System.out.println(d);
						if(d.equalsIgnoreCase("TEREX MATERIALS PROC � SETUP � REPORT WIZARD") && t.isElementPresentcheck(By.xpath(Object.getProperty("ReportWizard")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ReportCreatingWizard")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportCompanySearchbox")), driver))
						{
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportTable")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportCreateButton")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportEditButton")), driver))
							{
								acop = "Email Report Page Loaded Successfully";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 2 execution completed############################");
							}
							else
							{
								System.out.println("Some of Element missing in the Report Wizard.");
								acop = "Some of Element missing in the Report Wizard.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 2 execution completed############################");
							}
							
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportCreateTable")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ReportNextButton")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("ReportCancelButton")), driver))
							{
								System.out.println("Email report wizard loaded successfully.");
							}
							else
							{
								System.out.println("Some of Element missing in the report creating wizard.");
								acop = "Some of Element missing in the report creating wizard.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 2 execution completed############################");
							}
						}
						else
						{
							System.out.println("Some of Element missing in the Email Report Page.");
							acop = "Some of Element missing in the Email Report Page.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 2 execution completed############################");
							
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				// Report/Frequency
				if(d2[i][0].equalsIgnoreCase("TC3"))
				{	
					try
					{
						System.out.println( "###################Test case 3 is executing############################");
						String report=d2[2][4];
						String [] reportArray=report.split(",");
						String sDate = t.date(d2[2][5]);
						String eDate = t.date(d2[2][6]);
						AddFilter.pageNavigater();
						driver.findElement(By.xpath(Object.getProperty("EmailReportCreateButton"))).click();
						Thread.sleep(5000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportName")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportStartDate")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportEnadDate")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EmailMonthlyReport")), driver) 
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("EmailWeeklyReport")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EmailDailyReport")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportReceiveTime")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ReportStatusActive")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("ReportStatusDeactive")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ReportCancelButton")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("ReportNextButton")), driver))
						{
							System.out.println("Report/Frequency pass");
							acop = "Report/Frequency Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Pass" );
							System.out.println( "###################Test case 3 execution completed############################");
							
							WebElement name=driver.findElement(By.xpath(Object.getProperty("EmailReportName")));
							List<WebElement> nameList=name.findElements(By.tagName("option"));
							for(WebElement text : nameList)
							{
								if(text.getText().equalsIgnoreCase(reportArray[0]))
								{
									text.click();
								}
							}
							driver.findElement(By.xpath(Object.getProperty("EmailReportStartDate"))).sendKeys(sDate);
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("EmailReportEnadDate"))).sendKeys(eDate);
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("EmailReportReceiveTime"))).click();
							Thread.sleep(2000);
							if(reportArray[1].equalsIgnoreCase("Monthly"))
							{
								Thread.sleep(2000);
								System.out.println("Monthly in ");
								driver.findElement(By.xpath(Object.getProperty("EmailMonthlyReport"))).click();
								Thread.sleep(5000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportDayofMonth")), driver))
								{
									WebElement day=driver.findElement(By.xpath(Object.getProperty("EmailReportDayofMonth")));
									List<WebElement> dayList=day.findElements(By.tagName("option"));
									for(WebElement text : dayList)
									{
										if(text.getText().equalsIgnoreCase(d2[2][3]))
										{
											text.click();
										}
									}
								}
								else
								{
									System.out.println("Day of month is missing.");
									acop = " While Clicking the monthly its not display the Day of Month dropdown.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
							}
							else if(reportArray[1].equalsIgnoreCase("Weekly"))
							{
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("EmailWeeklyReport"))).click();
								Thread.sleep(5000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("ReportSunday")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ReportMonday")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("ReportTuesday")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ReportWednesday")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("ReportThursday")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ReportFriday")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("ReportSaturday")), driver) )
								{
									System.out.println("Weekly pass.");
									driver.findElement(By.xpath(Object.getProperty("Report"+d2[2][3]))).click();
								}
								else
								{
									System.out.println("weekly button is not working as expected.");
									acop = "weekly button is not working as expected.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
							}
							else if(reportArray[1].equalsIgnoreCase("Daily"))
							{
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("EmailDailyReport"))).click();
								Thread.sleep(5000);
								if( ! t.isElementPresentcheck(By.xpath(Object.getProperty("ReportSunday")), driver) && ! t.isElementPresentcheck(By.xpath(Object.getProperty("ReportMonday")), driver)
										&& ! t.isElementPresentcheck(By.xpath(Object.getProperty("ReportTuesday")), driver) && ! t.isElementPresentcheck(By.xpath(Object.getProperty("ReportWednesday")), driver)
										&& ! t.isElementPresentcheck(By.xpath(Object.getProperty("ReportThursday")), driver) &&  ! t.isElementPresentcheck(By.xpath(Object.getProperty("ReportFriday")), driver)
										&& ! t.isElementPresentcheck(By.xpath(Object.getProperty("ReportSaturday")), driver) && ! t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportDayofMonth")), driver))
								{
									System.out.println(" Pass daily");
								}
								else
								{
									System.out.println("Daily button is not working as Expected.");
									acop = "Daily button is not working as Expected.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
							}
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("EmailReportReceiveTime"))).clear();
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("EmailReportReceiveTime"))).sendKeys(reportArray[2]);
							Thread.sleep(2000);
							if(reportArray[3].equalsIgnoreCase("Active"))
							{
								driver.findElement(By.xpath(Object.getProperty("ReportStatusActive"))).click();
							}
							else if(reportArray[3].equalsIgnoreCase("De-Active"))
							{
								driver.findElement(By.xpath(Object.getProperty("ReportStatusDeactive"))).click();
							}
							Thread.sleep(5000);
							
							
						}
						else
						{
							System.out.println("Report/Frequency fail");
							acop = "Some of Element missing in Report/Frequency.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 3 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				// Filter/Sort 
				if(d2[i][0].equalsIgnoreCase("TC4"))
				{	
					try
					{
						System.out.println( "###################Test case 4 is executing############################");
						String type=d2[3][4];
						String [] typeArray=type.split(",")
;						driver.findElement(By.xpath(Object.getProperty("ReportNextButton"))).click();
						Thread.sleep(5000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("ReportFilterName")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ReportSortColumns")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("FilterPreviousButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("FilterNextButton")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("FilterCancelButton")), driver))
						{
							Thread.sleep(2000);
							acop = "Email Report Page Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Pass" );
							System.out.println( "###################Test case 4 execution completed############################");
							
							
							driver.findElement(By.xpath(Object.getProperty("FilterPreviousButton"))).click();
							Thread.sleep(5000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportTab")), driver))
							{
								System.out.println("Previus button is working as Expected.");
								acop = "Previus button is working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 4 execution completed############################");
							}
							else
							{
								System.out.println("Previous button is not working.");
								acop = "Previous button is not working.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 4 execution completed############################");
							}
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("ReportNextButton"))).click();
							Thread.sleep(5000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("EmailFilterTab")), driver))
							{
								System.out.println("Next button is working as Expected.");
								acop = "Next button is working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 4 execution completed############################");
							}
							else
							{
								System.out.println("Next button is not working.");
								acop = "Next button is not working.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 4 execution completed############################");
							}
							Thread.sleep(5000);
							
							WebElement all=driver.findElement(By.xpath(Object.getProperty("ReportFilterName")));
							List<WebElement>allList=all.findElements(By.tagName("option"));
							for(WebElement text : allList)
							{
								if(text.getText().equalsIgnoreCase(typeArray[0]))
								{
									text.click();
								}
							}
							
							WebElement sort=driver.findElement(By.xpath(Object.getProperty("ReportSortColumns")));
							List<WebElement>sortList=sort.findElements(By.tagName("option"));
							for(WebElement text : sortList)
							{
								if(text.getText().equalsIgnoreCase(typeArray[1]))
								{
									text.click();
								}
							}
							
						}
						else
						{
							System.out.println("Next button is not working or filter tab is not displaying properly.");
							acop = "Next button is not working or filter tab is not displaying properly.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 4 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				// Distribution
				if(d2[i][0].equalsIgnoreCase("TC5"))
				{	
					try
					{
						System.out.println( "###################Test case 5 is executing############################");
						String type=d2[4][4];
						String [] typeArray=type.split(",");
						driver.findElement(By.xpath(Object.getProperty("FilterNextButton"))).click();
						Thread.sleep(5000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("Distribution")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportADDEmailButton")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("DistributionPrevious")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("DistributionNext")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("DistributionCancel")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("DistributionEmails")), driver))
						{
							System.out.println("Distribution displaying propely.");
							
							driver.findElement(By.xpath(Object.getProperty("DistributionPrevious"))).click();
							Thread.sleep(5000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("EmailFilterTab")), driver))
							{
								System.out.println("Previus button is working as Expected.");
								acop = "Previus button is working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
							else
							{
								System.out.println("Previous button is not working.");
								acop = "Previous button is not working.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
							
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("DistributionNext"))).click();
							Thread.sleep(5000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("Distribution")), driver))
							{
								System.out.println("Next button is working as Expected.");
								acop = "Next button is working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
							else
							{
								System.out.println("Next button is not working.");
								acop = "Next button is not working.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "EmailReportWizard", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "EmailReportWizard", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
							Thread.sleep(5000);							
							
							driver.findElement(By.xpath(Object.getProperty("EmailReportADDEmailButton"))).click();
							Thread.sleep(2000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("Inside");
								Thread.sleep(1000);	
							}
							Thread.sleep(3000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportEmailTable")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EmailSelectType")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportEmailSearchbox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportEmailSearchButton")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportEmailClearButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportEmailSelectButton")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportEmailCancelButton")), driver))
							{
								WebElement email=driver.findElement(By.xpath(Object.getProperty("EmailSelectType")));
								List<WebElement>emailList=email.findElements(By.tagName("option"));
								for(WebElement text : emailList)
								{
									if(text.getText().equalsIgnoreCase(typeArray[0]))
									{
										text.click();
									}
								}
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("EmailReportEmailSearchbox"))).sendKeys(typeArray[1]);
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("EmailReportEmailSearchButton"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("Inside");
									Thread.sleep(1000);	
								}
								Thread.sleep(3000);
								WebElement tes = driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/tbody/tr[2]/td/div/table/tbody"));
								List<WebElement> testList=tes.findElements(By.tagName("tr"));
								System.out.println("Size"+testList.size());
								for(int j=1;j<=testList.size();j++)
								{
									String val=driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/tbody/tr[2]/td/div/table/tbody/tr["+j+"]/td[3]/div")).getText();
									System.out.println("val : "+val);
									if(typeArray[1].equalsIgnoreCase(val))
									{
										String s = driver.findElement(By.xpath("/html/body/div[3]/div[2]/table/tbody/tr[2]/td/div/table/tbody/tr["+j+"]/td[1]/div/input")).getAttribute("id");
										System.out.println("ID : "+s);
										driver.findElement(By.xpath("//*[@id='"+s+"']")).click();
										Thread.sleep(3000);
										driver.findElement(By.xpath(Object.getProperty("EmailReportEmailSelectButton"))).click();
										Thread.sleep(6000);
										WebElement emails=driver.findElement(By.xpath(Object.getProperty("DistributionEmails")));
										List<WebElement>emailsList=emails.findElements(By.tagName("tr"));
										System.out.println("Email Size :  "+emailsList.size());
										int n=testList.size()+1;
										System.out.println("N ; "+n);
										if(n==emailList.size())
										{
											System.out.println("now all passs");
										}
										else
										{
											System.out.println("all fail");
										}
									}
								}
								
							}
							
							
							//Cancel button 
							driver.findElement(By.xpath(Object.getProperty("EmailReportADDEmailButton"))).click();
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("Inside");
								Thread.sleep(1000);	
							}
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("EmailReportEmailCancelButton"))).click();
							Thread.sleep(5000);
							if(! t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportEmailTable")), driver) && ! t.isElementPresentcheck(By.xpath(Object.getProperty("EmailSelectType")), driver)
									&& ! t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportEmailSearchbox")), driver) && ! t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportEmailSearchButton")), driver)
									&& ! t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportEmailClearButton")), driver) && ! t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportEmailSelectButton")), driver)
									&& ! t.isElementPresentcheck(By.xpath(Object.getProperty("EmailReportEmailCancelButton")), driver))
							{
								System.out.println("Cancel button working as Expected.");
							}
							else
							{
								System.out.println("Email Cancel button is not working as expected.");
							}
						}
						else
						{
							System.out.println("Next button is not working or Distribution is not displaying properly.");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				//Preview
				if(d2[i][0].equalsIgnoreCase("TC6"))
				{	
					try
					{
						System.out.println( "###################Test case 6 is executing############################");
						driver.findElement(By.xpath(Object.getProperty("DistributionNext"))).click();
						Thread.sleep(2000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("Inside");
							Thread.sleep(1000);	
						}
						Thread.sleep(5000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("PreviewTable")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("PreviewPreviousButton")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("PreviewFinishButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("PreviewCancelButton")), driver))
						{
							System.out.println("Preview pass");
						}
						else
						{
							System.out.println("Preview fail");
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