package Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;

import org.openqa.selenium.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import FleetEdge_Core.Core;
import FleetEdge_Util.*;

public class TerminalSummary extends Core
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]> TerminalSummarytest(Map<String, Object[]> data, int rc,String sheet, ExtentTest test, int scase, int ecase) 
	{
		try
		{
			String actRes = null;
			int counter=1;

			String[][] d = s.Read(path, sheet);

			driver = new FirefoxDriver(t.excel());
			driver.get(Object.getProperty("URL"));
			t.dologin(driver, d[0][2], d[0][3]);
			
		/*  try{
			t.overlay(driver);
			Thread.sleep(2000);
			String txt = d[0][5];
			String[] splitVal = txt.split(",");
			//company search
			
			t.company(driver,splitVal[0],splitVal[1]);
			t.overlay(driver);
			Thread.sleep(1000);
			}catch(Exception e){
				e.printStackTrace();
			}*/
			
			for(int i=scase-1;i<ecase;i++)
			{
				long stime = System.currentTimeMillis();
				if(d[i][0].equalsIgnoreCase("TC1"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("TerminalSummary")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 1 is executing******************************");
						Thread.sleep(5000);
						
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("Filter")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("ClearFilter")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Highlight")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Columns")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Download")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Subscription")), driver) 
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Columns")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("GoToPage")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("ShowRows")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("PageNo")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("TerminalDashboard")), driver))
						{
							System.out.println("All the Elements are present in the Dashboard");
							actRes = "All the Elements are present in the Dashboard";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 1 finished its execution*************************");
						}
						else
						{
							System.out.println("All the Elements are not present in the Dashboard");
							actRes = "All the Elements are not present in the Dashboard";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 1 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				//Dashboard verification
				if(d[i][0].equalsIgnoreCase("TC2"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("TerminalSummary")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 2 is executing******************************");
						Thread.sleep(5000);
						
						ArrayList<String> colval = new ArrayList<String>();
						ArrayList<String> dashval = new ArrayList<String>();
						driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
						WebElement ele = driver.findElement(By.xpath(Object.getProperty("ColumnSelect")));
						WebDriverWait wait = new WebDriverWait(driver, 10);
						wait.until(ExpectedConditions.elementToBeClickable(ele));
						List<WebElement> colEle = ele.findElements(By.tagName("option"));
						for(WebElement col : colEle)
						{
							System.out.println("Col val: "+col.getText());
							colval.add(col.getText().toLowerCase());
						}
						driver.findElement(By.xpath(Object.getProperty("ColumnClose"))).click();
						Thread.sleep(5000);
						WebElement ele1 = driver.findElement(By.id("tblFleetStatusReportHeaderCopy"));
						List<WebElement> elements = ele1.findElements(By.tagName("th"));
						for(WebElement val : elements)
						{
							System.out.println("Dashval: " +val.getText());
							dashval.add(val.getText().toLowerCase());
						}
						
						if(colval.equals(dashval))
						{
							System.out.println("All the elements are present in the Dashboard matched with column value");
							actRes = "All the elements are present in the Dashboard matched with column value";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 2 finished its execution*************************");
						}
						else
						{
							System.out.println("All the elements are not present in the Dashboard and mismatched with column value");
							actRes = "All the elements are not present in the Dashboard and mismatched with column value";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 2 finished its execution*************************");
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//page no button verify
				if(d[i][0].equalsIgnoreCase("TC3"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("TerminalSummary")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 3 is executing******************************");
						Thread.sleep(7000);
						
						Select row = new Select(driver.findElement(By.xpath(Object.getProperty("ShowRows"))));
						row.selectByValue(d[i][5]);		
						t.overlay(driver);
						Thread.sleep(1000);
						ArrayList<String> num = new ArrayList<String>();
						WebElement pg = driver.findElement(By.xpath(".//*[@id='PagingText']"));
						List<WebElement> Pg = pg.findElements(By.tagName("a"));
						for(WebElement pgN : Pg)
							num.add(pgN.getText());
					/*	for(String p : num)
							System.out.println("Page No: " +p); */
						if(Pg.get(0).getText().equalsIgnoreCase("2") && Pg.get(Pg.size()-1).getText().equalsIgnoreCase("Next 10"))
						{
							System.out.println("Page is displayed successfully");
							if(d[i][6].isEmpty())
							{
								System.out.println("The Page is displayed successfully");
								actRes = "The Page is displayed successfully";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 3 finished its execution*************************");
							}
							else
							{
								Select sel = new Select(driver.findElement(By.xpath(Object.getProperty("GoToPage"))));
								sel.selectByValue(d[i][6]);
								t.overlay(driver);
								Thread.sleep(1000);
								WebElement pg1 = driver.findElement(By.xpath(".//*[@id='PagingText']"));
								List<WebElement> page1 = pg1.findElements(By.tagName("a"));
								ArrayList<String> num1 = new ArrayList<String>();
								for(WebElement pgN : page1)
								{
									System.out.println("pg " +pgN.getText());
									num1.add(pgN.getText());
								}
								if(!num.contains(num1))
								{
									num.removeAll(num1);
									System.out.println("misval: " +num.toString());
								}
								//System.out.println("ExcelVal: " +d[i][6]);
								if(num.contains(d[i][6]))
								{
									System.out.println("The selected page is displayed as expected");
									actRes = "The selected page is displayed as expected";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
									System.out.println("*********************TestCase 3 finished its execution*************************");
								}
								else
								{
									System.out.println("The current page does not match with the page that is selected");
									actRes = "The current page does not match with the page that is selected";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
									System.out.println("*********************TestCase 3 finished its execution*************************");
								}
							}
						}
						else
						{
							System.out.println("Page is not displayed properly");
							actRes = "Page is not displayed properly";
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
				//records per page
				if(d[i][0].equalsIgnoreCase("TC4"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("TerminalSummary")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 4 is executing******************************");
						Thread.sleep(5000);
						
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("Dashboard")), driver))
						{
							WebElement records = driver.findElement(By.xpath(Object.getProperty("ShowRows")));
							List<WebElement> options = records.findElements(By.tagName("option"));
							for(WebElement op : options)
								System.out.println("Options: " +op.getText());
							if(options.get(0).getText().equalsIgnoreCase("10") && options.get(options.size()-1).getText().equalsIgnoreCase("100")
									&& options.get(options.size()-2).getText().equalsIgnoreCase("75") && options.get(options.size()-3).getText().equalsIgnoreCase("50"))
							{
								System.out.println("All the options are present");
							}
							for(int j=0;j<options.size();j++)
							{
								//Thread.sleep(3000);
								Select row = new Select(driver.findElement(By.xpath(Object.getProperty("ShowRows"))));
								row.selectByIndex(j);
								t.overlay(driver);
								Thread.sleep(1000);
								ArrayList<WebElement> table = new ArrayList<WebElement>();
								WebElement tbody = driver.findElement(By.xpath(Object.getProperty("Dashboard")));
								List<WebElement> tr = tbody.findElements(By.tagName("tr"));
								for(WebElement trData : tr)
									table.add(trData);
								int size = table.size()-1;
								System.out.println("Size: " +size);
								records = driver.findElement(By.xpath(Object.getProperty("ShowRows")));
								List<WebElement> opt = records.findElements(By.tagName("option"));
								String txt1 = opt.get(j).getText();
								System.out.println("Option val: " +txt1);
								if(size<=Integer.parseInt(txt1))
								{
									System.out.println("The records "+size+" per page is displayed successfully");
									actRes = "The Records per page is displayed properly";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1],d[i][7], actRes, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
									System.out.println("*********************TestCase 4 finished its execution*************************");
								}
								else
								{
									System.out.println("The records "+size+" per page is displayed successfully");
									actRes = "The Records per page is not displayed properly";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1],d[i][7], actRes, "Fail", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
									System.out.println("*********************TestCase 4 finished its execution*************************");
								}
							}
						}
						else
							System.out.println("Dashboard is not present");
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				//add and delete filter verification
				if(d[i][0].equalsIgnoreCase("TC5"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("TerminalSummary")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 5 is executing******************************");
						Thread.sleep(3000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						Boolean search=null,equal=null,contains=null,having=null,notEqual=null,close=null,save=null,del=null;
						int count=0;
						driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
						Thread.sleep(7000);
						WebElement col = driver.findElement(By.xpath(Object.getProperty("ColumnSelect")));
						List<WebElement> colVal = col.findElements(By.tagName("option"));
						for(int j=0;j<colVal.size();j++){
							System.out.println("col val: " +colVal.get(j).getText());
							if(colVal.get(j).getText().equalsIgnoreCase(split[1]))
								count = j+1;
						}
						System.out.println("count: " +count);
						Select filter = new Select(driver.findElement(By.xpath(Object.getProperty("Filter"))));
						filter.selectByValue(split[0]);
						WebElement selectOp = driver.findElement(By.className("cssDrpOperation"));
						List<WebElement> option = selectOp.findElements(By.tagName("option"));
						String[] oprn = new String[option.size()];
						for(int val=0;val<option.size();val++)
							oprn[val] = option.get(val).getText();
							
						System.out.println("size of dropdown: " +option.size());
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("ColumnClose"))).click();
						t.clearFilter();
						t.overlay(driver);
						Thread.sleep(1000);
						/*for(WebElement op : option)
							System.out.println("option values: " +op.getText());*/
						for(int k=0;k<option.size();k++)
						{
							Select filter1 = new Select(driver.findElement(By.xpath(Object.getProperty("Filter"))));
							filter1.selectByValue(split[0]);
							Thread.sleep(3000);
							if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
							{
							Select id = new Select(driver.findElement(By.xpath(Object.getProperty("SelectID"))));
							id.selectByValue(split[1]);
							Select operator = new Select(driver.findElement(By.className("cssDrpOperation")));
							operator.selectByIndex(k);
													
							switch(oprn[k])
							{
								case "Equals":
								System.out.println("in equals");
								driver.findElement(By.className("clsValue")).sendKeys(split[2]);
								driver.findElement(By.xpath(Object.getProperty("AddSearch"))).click();
								t.overlay(driver);
								Thread.sleep(7000);
								WebElement table = driver.findElement(By.xpath(Object.getProperty("TerminalDashboard")));
								List<WebElement> tr = table.findElements(By.tagName("tr"));
								String[] tableData = new String[tr.size()];
								for(int click=2;click<=tr.size();click++)
								{
									tableData[click-2] = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+click+"]/td["+count+"]")).getText();
									if(tableData[click-2].equalsIgnoreCase(split[2]))
										equal = true;
									else
										equal = false;
								}
								t.clearFilter();
								t.overlay(driver);
								Thread.sleep(1000);
								x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
								y =  driver.findElement(By.xpath(Object.getProperty("TerminalSummary")));
								t.fleetSelect(driver,x,y);
								Thread.sleep(1000);
								break;
								
							case "Contains":
								System.out.println("in contains");
								driver.findElement(By.className("clsValue")).sendKeys(split[3]);
								driver.findElement(By.xpath(Object.getProperty("AddSearch"))).click();
								t.overlay(driver);
								Thread.sleep(7000);
								WebElement table1 = driver.findElement(By.xpath(Object.getProperty("TerminalDashboard")));
								List<WebElement> tr1 = table1.findElements(By.tagName("tr"));
								String[] tableData1 = new String[tr1.size()];
								for(int click=2;click<=tr1.size();click++)
								{
									tableData1[click-2] = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+click+"]/td["+count+"]")).getText();
									if(tableData1[click-2].contains(split[3]))
										contains = true;
									else
										contains = false;
								}
								t.clearFilter();
								t.overlay(driver);
								Thread.sleep(1000);
								x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
								y =  driver.findElement(By.xpath(Object.getProperty("TerminalSummary")));
								t.fleetSelect(driver,x,y);
								Thread.sleep(1000);
								break;
							
							case "Having":
								System.out.println("in having");
								driver.findElement(By.className("clsValue")).sendKeys(split[4]);
								driver.findElement(By.xpath(Object.getProperty("AddSearch"))).click();
								t.overlay(driver);
								Thread.sleep(7000);
								WebElement table2 = driver.findElement(By.xpath(Object.getProperty("TerminalDashboard")));
								List<WebElement> tr2 = table2.findElements(By.tagName("tr"));
								String[] tableData2 = new String[tr2.size()];
								for(int click=2;click<=tr2.size();click++)
								{
									tableData2[click-2] = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+click+"]/td["+count+"]")).getText();
									if(tableData2[click-2].equalsIgnoreCase(split[4]))
										having = true;
									else
										having = false;
								}
								t.clearFilter();
								t.overlay(driver);
								Thread.sleep(1000);
								x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
								y =  driver.findElement(By.xpath(Object.getProperty("TerminalSummary")));
								t.fleetSelect(driver,x,y);
								Thread.sleep(1000);
								break;
							
							case "Is Empty":
								System.out.println("in is Empty");
								break;
							
							case "Is Not Empty":
								System.out.println("in is Not Empty");
								break;
							
							case "Greater Than":
								System.out.println("in greater than");
								break;
							
							case "Less Than":
								System.out.println("in less than");
								break;
							
							case "Not Equals":
								System.out.println("in Not Equals");
								driver.findElement(By.className("clsValue")).sendKeys(split[2]);
								driver.findElement(By.xpath(Object.getProperty("AddSearch"))).click();
								t.overlay(driver);
								Thread.sleep(7000);
								WebElement table11 = driver.findElement(By.xpath(Object.getProperty("TerminalDashboard")));
								List<WebElement> tr11 = table11.findElements(By.tagName("tr"));
								String[] tableData11 = new String[tr11.size()];
								for(int click=2;click<=tr11.size();click++)
								{
									tableData11[click-2] = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+click+"]/td["+count+"]")).getText();
									if(!tableData11[click-2].equalsIgnoreCase(split[2]))
										notEqual = true;
									else
										notEqual = false;
								}
								t.clearFilter();
								t.overlay(driver);
								Thread.sleep(1000);
								x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
								y =  driver.findElement(By.xpath(Object.getProperty("TerminalSummary")));
								t.fleetSelect(driver,x,y);
								Thread.sleep(1000);
								break;
							}
							}
						}
						if(equal==true && having==true && notEqual==true && contains==true)
							search = true;
						else
							search = false;
						System.out.println("search result: " +search);	
						
						//close verify
						Thread.sleep(5000);
						Select filter1 = new Select(driver.findElement(By.xpath(Object.getProperty("Filter"))));
						filter1.selectByValue(split[0]);
						Thread.sleep(3000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
						{
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("CloseBtn"))).click();
							Thread.sleep(2000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("TerminalDashboard")), driver))
								close = true;
							else
								close = false;
						}
						t.clearFilter();
						t.overlay(driver);
						Thread.sleep(1000);
						System.out.println("close result: "+close);
						
						//save new report
						Select filter2 = new Select(driver.findElement(By.xpath(Object.getProperty("Filter"))));
						filter2.selectByValue(split[0]);
						Thread.sleep(3000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
						{
							Select id = new Select(driver.findElement(By.xpath(Object.getProperty("SelectID"))));
							id.selectByValue(split[1]);
							Select operator = new Select(driver.findElement(By.className("cssDrpOperation")));
							operator.selectByValue(split[5]);
							driver.findElement(By.className("clsValue")).sendKeys(split[2]);
							driver.findElement(By.xpath(Object.getProperty("NewReport"))).click();
							Thread.sleep(3000);
							if(t.isElementPresentcheck(By.xpath("/html/body/div[4]"), driver))
							{
								driver.findElement(By.xpath("//*[@id='MainContainer_txtFilterName']")).sendKeys(split[6]);
								Thread.sleep(2000);
								driver.findElement(By.xpath("//*[@id='MainContainer_btnSaveRowFilter']")).click();
								Thread.sleep(3000);
								String success = t.alertWait();
								if(success.equalsIgnoreCase("Filter saved successfully"))
								{
									t.clearFilter();
									t.overlay(driver);
									Thread.sleep(1000);
									WebElement filterOpt = driver.findElement(By.xpath(Object.getProperty("Filter")));
									List<WebElement> fOpt = filterOpt.findElements(By.tagName("option"));
									System.out.println("fOpt size: " +fOpt.size());
									for(int find=0;find<fOpt.size();find++)
									{
										System.out.println("Text: "+fOpt.get(find).getText());
										if(fOpt.get(find).getText().equalsIgnoreCase(split[6]))
										{
											save = true;
											break;
										}
										else
											save = false;
									}
								}
								else
									save = false;
							}
							t.clearFilter();
							t.overlay(driver);
							Thread.sleep(1000);
						}
						System.out.println("save result: " +save);
						//delete filter
						Select delete = new Select(driver.findElement(By.xpath(Object.getProperty("Filter"))));
						delete.selectByValue(d[i][6]);
						Thread.sleep(3000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[4]"), driver))
						{
							String reportName = null;
							WebElement delTable = driver.findElement(By.xpath(".//*[@id='tblFsUserCreatedFilterData']/tbody"));
							List<WebElement> tab = delTable.findElements(By.tagName("tr"));
							System.out.println("del table size: " +tab.size());
							for(int sz=2;sz<=tab.size();sz++)
							{
								Thread.sleep(3000);
								reportName = driver.findElement(By.xpath(".//*[@id='tblFsUserCreatedFilterData']/tbody/tr["+sz+"]/td[1]")).getText();
								System.out.println("name: " +reportName);
								if(reportName.equalsIgnoreCase(split[6]))
								{
									Thread.sleep(3000);
									driver.findElement(By.xpath(".//*[@id='tblFsUserCreatedFilterData']/tbody/tr["+sz+"]/td[2]/div/button")).click();
									String msg = t.alertWait();
									if(msg.equalsIgnoreCase("Success"))
									{
										Thread.sleep(3000);
										WebElement filterOpt = driver.findElement(By.xpath(Object.getProperty("Filter")));
										List<WebElement> options1 = filterOpt.findElements(By.tagName("option"));
										for(WebElement op : options1)
										{
											System.out.println("options: " +op.getText());
											if(op.getText().equalsIgnoreCase(split[6]))
												del = false;
											else{
												del = true;
												break;}
										}
									}
									else
										del = false;
								}
							}
						}
						System.out.println("delete result: " +del);
						//final result
						if(search==true && close==true && save==true && del==true)
						{
							System.out.println("Add and Delete filter are working as expected");
							actRes = "Add and Delete filter are working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 5 finished its execution*************************");
						}
						else
						{
							System.out.println("Add and Delete filter are not working as expected");
							actRes = "Add and Delete filter are not working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 5 finished its execution*************************");
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				//clear filter verification
				if(d[i][0].equalsIgnoreCase("TC6"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("TerminalSummary")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 6 is executing******************************");
						Thread.sleep(2000);
						
						t.clearFilter();
						t.overlay(driver);
						Thread.sleep(1000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("Filter")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("ClearFilter")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Highlight")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Columns")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Download")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Subscription")), driver) 
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Columns")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("GoToPage")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("ShowRows")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("PageNo")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("TerminalDashboard")), driver))
						{
							System.out.println("Clear Filter is working as expected");
							actRes = "Clear Filter is working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 6 finished its execution*************************");
						}
						else
						{
							System.out.println("Clear Filter is not working as expected");
							actRes = "Clear Filter is not working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 6 finished its execution*************************");
						}
						
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				//highlight button verification
				if(d[i][0].equalsIgnoreCase("TC7"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("TerminalSummary")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 7 is executing******************************");
						Thread.sleep(3000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						
						String str1 = d[i][6];
						String[] split1 = str1.split("#");
						Thread.sleep(3000);
						Boolean saveHigh=null,cancel=null,clear=null,close=null,update=null,delete=null;
						int owner=0,assetId=0;
						driver.findElement(By.xpath(Object.getProperty("Highlight"))).click();
						Thread.sleep(10000);
						if(t.isElementPresentcheck(By.xpath(".//*[@id='divHighlightRowColumnPHolder']"), driver))
						{
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("HighlightNew"))).click();
							Thread.sleep(5000);
							//row highlight
							WebElement click1 = driver.findElement(By.xpath(Object.getProperty("CheckRow")));
							Actions act = new Actions(driver);
							act.moveToElement(click1).click(click1);
							act.perform();
							Select rowColor = new Select(driver.findElement(By.xpath(Object.getProperty("RowColor"))));
							rowColor.selectByVisibleText(split[0]);
							Select id = new Select(driver.findElement(By.xpath(Object.getProperty("RowId"))));
							id.selectByVisibleText(split[1]);
							Select oprn = new Select(driver.findElement(By.xpath(Object.getProperty("RowOperator"))));
							oprn.selectByVisibleText(split[2]);
							driver.findElement(By.xpath(Object.getProperty("RowText"))).sendKeys(split[3]);
							Thread.sleep(3000);
							//column highlight
							driver.findElement(By.xpath(Object.getProperty("CheckColumn"))).click();
							Select colColor = new Select(driver.findElement(By.xpath(Object.getProperty("ColumnColor"))));
							colColor.selectByVisibleText(split[4]);
							Select colId = new Select(driver.findElement(By.xpath(Object.getProperty("ColumnId"))));
							colId.selectByVisibleText(split[5]);
							Select colOprn = new Select(driver.findElement(By.xpath(Object.getProperty("ColumnOperator"))));
							colOprn.selectByVisibleText(split[6]);
							driver.findElement(By.xpath(Object.getProperty("ColumnText"))).sendKeys(split[7]);
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("SaveHighlight"))).click();
							Thread.sleep(2000);
							String a = t.alertWait();
							if(a.equalsIgnoreCase("Filter saved successfully"))
							{
								//filter the highlighted row and column
								Select fil = new Select(driver.findElement(By.xpath(Object.getProperty("Filter"))));
								fil.selectByValue(split[8]);
								Select id1 = new Select(driver.findElement(By.xpath(Object.getProperty("SelectID"))));
								id1.selectByVisibleText(split[1]);
								Select operand1 = new Select(driver.findElement(By.xpath(Object.getProperty("FilterOperator"))));
								operand1.selectByVisibleText(split[2]);
								driver.findElement(By.xpath(Object.getProperty("InputBox"))).sendKeys(split[3]);
								driver.findElement(By.xpath(Object.getProperty("AddSearch"))).click();
								t.overlay(driver);
								Thread.sleep(1000);
								driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
								WebElement sel = driver.findElement(By.xpath(Object.getProperty("ColumnSelect")));
								List<WebElement> selVal = sel.findElements(By.tagName("option"));
								for(int k=0;k<selVal.size();k++)
								{
									if(selVal.get(k).getText().equalsIgnoreCase(split[1]))
										owner=k+1;
									else if(selVal.get(k).getText().equalsIgnoreCase(split[5]))
										assetId=k+1;
								}
								driver.findElement(By.xpath(Object.getProperty("ColumnClose"))).click();
								System.out.println("owner: " +owner);
								System.out.println("assetId: " +assetId);
								Thread.sleep(5000);
								WebElement table = driver.findElement(By.xpath(Object.getProperty("Dashboard")));
								List<WebElement> tr = table.findElements(By.tagName("tr"));
								System.out.println("tr size: " +tr.size());
								String code=null;
								Thread.sleep(5000);
								for(int click=2;click<=tr.size();click++)
								{
									String snoValue = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+click+"]/td["+owner+"]")).getText();
									if(snoValue.equalsIgnoreCase(split[3]))
									{
										WebElement colorCode = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+click+"]/td["+owner+"]"));
										code = colorCode.getCssValue("background-color");
										if(code.equalsIgnoreCase(split1[0]))
											saveHigh = true;
										else
											saveHigh = false;
									}
									String equipValue = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+click+"]/td["+assetId+"]")).getText();
									if(equipValue.equalsIgnoreCase(split[7]))
									{
										WebElement colorCode = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+click+"]/td["+assetId+"]"));
										code = colorCode.getCssValue("background-color");
										if(code.equalsIgnoreCase(split1[1]))
											saveHigh = true;
										else
											saveHigh = false;
									}
								}
							}
							else
								saveHigh = false;
						}
						System.out.println("result for save: " +saveHigh);
						//cancel button
						driver.findElement(By.xpath(Object.getProperty("Highlight"))).click();
						Thread.sleep(10000);
						if(t.isElementPresentcheck(By.xpath(".//*[@id='divHighlightRowColumnPHolder']"), driver))
						{
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("HighlightNew"))).click();
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("CancelHighlight"))).click();
							if(t.isElementPresentcheck(By.xpath(".//*[@id='divHighlightRowColumnPHolder']"), driver))
								cancel=true;
							else
								cancel=false;
						}
						System.out.println("cancel result: " +cancel);
						//close button
						driver.findElement(By.xpath(Object.getProperty("Highlight"))).click();
						Thread.sleep(10000);
						if(t.isElementPresentcheck(By.xpath(".//*[@id='divHighlightRowColumnPHolder']"), driver))
						{
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("CloseHighlight"))).click();
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("Dashboard")), driver))
								close=true;
							else
								close=false;
						}
						System.out.println("close result: " +close);
						//clear and update button
						driver.findElement(By.xpath(Object.getProperty("Highlight"))).click();
						Thread.sleep(7000);
						if(t.isElementPresentcheck(By.xpath(".//*[@id='divHighlightRowColumnPHolder']"), driver))
						{
							driver.findElement(By.xpath(".//*[@id='tblHighlightReport']/tbody/tr[2]/td[1]")).click();
							Thread.sleep(4000);
							driver.findElement(By.xpath(Object.getProperty("AddRowBtn"))).click();
							if(driver.findElement(By.xpath(Object.getProperty("RowText"))).getText().isEmpty())
								clear = true;
							else
								clear = false;
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("RowText"))).sendKeys(split[3]);
							Select rowColor = new Select(driver.findElement(By.xpath(Object.getProperty("RowColor"))));
							rowColor.selectByVisibleText(split[4]);
							driver.findElement(By.xpath(Object.getProperty("UpdateHighlight"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							WebElement colorCode = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr[2]/td[1]"));
							String code = colorCode.getCssValue("background-color");
							if(code.equalsIgnoreCase(split1[1]))
								update = true;
							else
								update = false;
						}
						System.out.println("clear result: " +clear);
						System.out.println("update result: " +update);
						//delete button
						driver.findElement(By.xpath(Object.getProperty("Highlight"))).click();
						Thread.sleep(7000);
						if(t.isElementPresentcheck(By.xpath(".//*[@id='divHighlightRowColumnPHolder']"), driver))
						{
							driver.findElement(By.xpath(".//*[@id='tblHighlightReport']/tbody/tr[2]/td[1]")).click();
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("DeleteHighlight"))).click();
							String cnfrm = t.alertWait();
							if(cnfrm.equalsIgnoreCase("Do you want to delete the selected Highlight?"))
								delete = true;
							else
								delete = false;
						}
						System.out.println("delete result: " +delete);
						//final verification
						if(saveHigh==true && clear==true && cancel==true && close==true && delete==true && update==true)
						{
							System.out.println("Highlight is working as expected");
							actRes = "Highlight is working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 7 finished its execution*************************");
						}
						else
						{
							System.out.println("Highlight is not working as expected");
							actRes = "Highlight is not working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 7 finished its execution*************************");
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//column button verification
				if(d[i][0].equalsIgnoreCase("TC8"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("TerminalSummary")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 8 is executing******************************");
						Thread.sleep(3000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						
						int sz=0,newSz=0,position=0,newPos=0,removeSz=0;
						WebElement head = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
						List<WebElement> headSz = head.findElements(By.tagName("th"));
						for(int k=0;k<headSz.size();k++)
						{
							System.out.println("beforeup: " +headSz.get(k).getText());
							if(headSz.get(k).getText().equalsIgnoreCase(split[0])){
								position = k+1;
								break;}
						}
						System.out.println("position: " +position);
						sz = headSz.size();
						System.out.println("size of column: " +sz);
						Boolean add = null,up = null,down = null,remove = null,saveReport = null,delete = null,close = null;
						
						driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
						Thread.sleep(1000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnPage")), driver))
						{
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("ReportColumn")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("AddColumn")), driver)
									|| t.isElementPresentcheck(By.xpath(Object.getProperty("AddColumn")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnSelect")), driver)
									|| t.isElementPresentcheck(By.xpath(Object.getProperty("CloumnUp")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnDown")), driver)
									|| t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnRemove")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("SaveColumn")), driver)
									|| t.isElementPresentcheck(By.xpath(Object.getProperty("SaveReportColumn")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("DeleteReport")), driver)
									|| t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnClose")), driver))
								System.out.println("All the elements are present in the Column Report Settings");
							
							//save, add and remove button verification
							if(!t.isElementPresentcheck(By.xpath(Object.getProperty("AddColumn")), driver))
							{
								System.out.println("Add button is not visible since all the columns are added");
								add=true;
							}
							else
							{
							driver.findElement(By.xpath(Object.getProperty("AddColumn"))).click();
							driver.findElement(By.xpath(Object.getProperty("SaveColumn"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							head = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
							List<WebElement> addedCol = head.findElements(By.tagName("th"));
							newSz = addedCol.size();
							System.out.println("added column size: " +newSz);
							if(sz==(newSz-1))
								add = true;
							else
								add = false;
							}
							//remove
							driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnPage")), driver))
							{
								driver.findElement(By.xpath(".//*[@id='drpRCSettingSelectedColumn']/option["+newSz+"]")).click();
								driver.findElement(By.xpath(Object.getProperty("ColumnRemove"))).click();
								driver.findElement(By.xpath(Object.getProperty("SaveColumn"))).click();
								t.overlay(driver);
								Thread.sleep(1000);
								head = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
								List<WebElement> removeCol = head.findElements(By.tagName("th"));
								removeSz = removeCol.size();
								System.out.println("removed column size: " +removeSz);
								if(removeSz==sz)
									remove = true;
								else
									remove = false;
							}
						}
						//up button verification
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnPage")), driver))
						{
							driver.findElement(By.xpath(".//*[@id='drpRCSettingSelectedColumn']/option["+position+"]")).click();
							driver.findElement(By.xpath(Object.getProperty("CloumnUp"))).click();
							driver.findElement(By.xpath(Object.getProperty("SaveColumn"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							head = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
							List<WebElement> colPos = head.findElements(By.tagName("th"));
							for(int pos=0;pos<colPos.size();pos++)
							{
								System.out.println("afterup: " +colPos.get(pos).getText());
								if(colPos.get(pos).getText().equalsIgnoreCase(split[0])){
									newPos = pos+1;
									break;
								}
							}
							System.out.println("newpos: " +newPos);
							if(newPos==(position-1))
								up = true;
							else
								up = false;
						}
						//down button verification
						int pos1=0,newPos1=0;
						head = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
						List<WebElement> th = head.findElements(By.tagName("th"));
						for(int f=0;f<th.size();f++)
						{
							System.out.println("beforedown: " +th.get(f).getText());
							if(th.get(f).getText().equalsIgnoreCase(split[1])){
								pos1 = f+1;
								break;
							}
						}
						System.out.println("pos down: " +pos1);
						driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnPage")), driver))
						{
							driver.findElement(By.xpath(".//*[@id='drpRCSettingSelectedColumn']/option["+pos1+"]")).click();
							driver.findElement(By.xpath(Object.getProperty("ColumnDown"))).click();
							driver.findElement(By.xpath(Object.getProperty("SaveColumn"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							head = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
							List<WebElement> colPos1 = head.findElements(By.tagName("th"));
							for(int pos=0;pos<colPos1.size();pos++)
							{
								System.out.println("afterDown: " +colPos1.get(pos).getText());
								if(colPos1.get(pos).getText().equalsIgnoreCase(split[0])){
									newPos1 = pos1+1;
									break;
								}
							}
							System.out.println("newpos1: " +newPos1);
							if((newPos1-1)==pos1)
								down = true;
							else
								down = false;
						}
						//close and saveReport verification
						driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnPage")), driver))
						{
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("ColumnClose"))).click();
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("Dashboard")), driver))
								close = true;
							else
								close = false;
						}
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnPage")), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("SaveReportColumn"))).click();
							if(t.isElementPresentcheck(By.xpath("html/body/div[4]"), driver))
							{
								driver.findElement(By.xpath(Object.getProperty("ReportName"))).sendKeys(split[2]);
								Select saveFor = new Select(driver.findElement(By.xpath(".//*[@id='MainContainer_drpUserType']")));
								saveFor.selectByValue(split[3]);
								driver.findElement(By.xpath(".//*[@id='MainContainer_btnReportSave']")).click();
								Thread.sleep(3000);
								t.overlay(driver);
								Thread.sleep(1000);
								WebElement fleet = driver.findElement(By.xpath(Object.getProperty("Fleet")));
								Actions fleetSel = new Actions(driver);
								fleetSel.moveToElement(fleet).click(fleet);
								fleetSel.perform();
								Thread.sleep(3000);
								WebElement userReport = driver.findElement(By.xpath(".//*[@id='FEMenu_divMenus']/ul/li[1]/div/div[2]"));
								List<WebElement> userName = userReport.findElements(By.tagName("ul"));
								System.out.println("userdefined report size: " +userName.size());
								for(int rep=1;rep<=userName.size();rep++)
								{
									if(userName.get(rep).getText().equalsIgnoreCase(split[2])){
										saveReport = true;
										break;}
									else
										saveReport = false;
								}
							}
						}
						//delete report
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnPage")), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("DeleteReport"))).click();
							if(t.isElementPresentcheck(By.xpath(".//*[@id='UserDefinedpopup']"), driver))
							{
								WebElement delTable = driver.findElement(By.xpath(".//*[@id='tblFsUserDefinedMenuData']/tbody"));
								List<WebElement> del = delTable.findElements(By.tagName("tr"));
								String name = null;
								System.out.println("deltable size: " +del.size());
								for(int eventDel=2;eventDel<=del.size();eventDel++)
								{
									name = driver.findElement(By.xpath(".//*[@id='tblFsUserDefinedMenuData']/tbody/tr["+eventDel+"]/td[1]")).getText();
									System.out.println("name: " +name);
									System.out.println("excel val: " +split[2]);
									if(name.equalsIgnoreCase(split[2])){
										driver.findElement(By.xpath(".//*[@id='tblFsUserDefinedMenuData']/tbody/tr["+eventDel+"]/td[2]/div/button")).click();
										String delEvent = t.alertWait();
										if(delEvent.equalsIgnoreCase("Do you want to delete the selected report?"))
										{
											String del1 = t.alertWait();
											if(del1.equalsIgnoreCase("Success"))
												delete = true;
											else
												delete = false;
										}
										else
											delete = false;
									}
								}
							}
						}
						System.out.println("add result: " +add);
						System.out.println("down result: " +down);
						System.out.println("up result: " +up);
						System.out.println("remove result: " +remove);
						System.out.println("saveReport result: " +saveReport);
						System.out.println("close result: " +close);
						System.out.println("delete result: " +delete);
						//final check
						if(add==true && up==true && down==true && remove==true && saveReport==true && delete==true && close==true)
						{
							System.out.println("The column is added in the Terminal Summary successfully");
							actRes = "The column is added in the Terminal Summary successfully";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 8 finished its execution*************************");
						}
						else
						{
							System.out.println("The column is not added in the Terminal Summary");
							actRes = "The column is not added in the Terminal Summary";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 8 finished its execution*************************");
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//download button verification
				if(d[i][0].equalsIgnoreCase("TC9"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("TerminalSummary")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 9 is executing******************************");
						t.overlay(driver);
						Thread.sleep(1000);
						
						int lastRow=0;
						int sind=0, eind=0, records=0;
						String record = new String();
						//Excel download
						driver.findElement(By.xpath(Object.getProperty("Download"))).click();
						Thread.sleep(4000);
						driver.findElement(By.xpath(Object.getProperty("DownloadExcel"))).click();
						t.overlay(driver);
						Thread.sleep(65000);
						System.out.println("robot class");
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_DOWN);
						Thread.sleep(500);
						robot.keyRelease(KeyEvent.VK_DOWN);
						Thread.sleep(500);
						robot.keyPress(KeyEvent.VK_ENTER);
						Thread.sleep(500);
						robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(25000);
						System.out.println("robot class finished its execution");
						String totPgNo = driver.findElement(By.id("divPaging")).getText();
				//		System.out.println("Tot pg no: " +totPgNo);
						
						if(totPgNo.contains("("))
						{
							sind = totPgNo.indexOf("(");
							eind = totPgNo.indexOf(")");
							record = totPgNo.substring(sind+1, eind);
							System.out.println("No of Records(approx): " +record);
						}
						String trim = record.trim();
						System.out.println("trim recod: " +trim);
						String[] exactRec = trim.split(" records");
						System.out.println("Exact value of record: " +exactRec[0]);
						try
						{
							FileInputStream in = new FileInputStream("D:\\workspace\\TMP\\DownloadExcel\\Terminal Summary.xlsx");
							Workbook wb = new XSSFWorkbook(in);
							Sheet sh = wb.getSheetAt(0);
							lastRow = sh.getLastRowNum();
							System.out.println("LastRow: " +lastRow);
							records = Integer.valueOf(exactRec[0]);
							System.out.println("No of records: " +records);
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						if(lastRow==records)
						{
							System.out.println("The Excel file is downloaded successfully and the count is matched");
							actRes = "The file is downloaded successfully and the count is matched";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 9 finished its execution*************************");
						}
						else
						{
							System.out.println("The Excel file is not downloaded properly and the count is mismatched");
							actRes = "The file is not downloaded properly and the count is mismatched";
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
				//subscription button verification
				if(d[i][0].equalsIgnoreCase("TC10"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("TerminalSummary")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 10 is executing******************************");
						t.overlay(driver);
						Thread.sleep(1000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(5000);
						
						//add filter
						Select filter2 = new Select(driver.findElement(By.xpath(Object.getProperty("Filter"))));
						filter2.selectByValue(split[0]);
						Thread.sleep(3000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
						{
							Select id = new Select(driver.findElement(By.xpath(Object.getProperty("SelectID"))));
							id.selectByValue(split[1]);
							Select operator = new Select(driver.findElement(By.className("cssDrpOperation")));
							operator.selectByValue(split[2]);
							driver.findElement(By.className("clsValue")).sendKeys(split[3]);
							driver.findElement(By.xpath(Object.getProperty("NewReport"))).click();
							Thread.sleep(3000);
							if(t.isElementPresentcheck(By.xpath("/html/body/div[4]"), driver))
							{
								driver.findElement(By.xpath("//*[@id='MainContainer_txtFilterName']")).sendKeys(split[4]);
								Thread.sleep(2000);
								driver.findElement(By.xpath("//*[@id='MainContainer_btnSaveRowFilter']")).click();
								Thread.sleep(3000);
								String success = t.alertWait();
								if(success.equalsIgnoreCase("Filter saved successfully"))
								{
									t.clearFilter();
									t.overlay(driver);
									Thread.sleep(1000);
								}
								else
								{
									t.clearFilter();
									t.overlay(driver);
									Thread.sleep(1000);
								}
							}
						}
						Thread.sleep(10000);
						//subscription button verification
						driver.findElement(By.xpath(Object.getProperty("Subscription"))).click();
						Thread.sleep(7000);
				//		if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
					//	{
						//	Thread.sleep(4000);
							Select filterType = new Select(driver.findElement(By.xpath(Object.getProperty("SubscriptionFilter"))));
							filterType.selectByVisibleText(split[4]);
							String sdate = t.date(split[5]);
							String edate = t.date(split[6]);
							driver.findElement(By.xpath(Object.getProperty("SubscriptionSdate"))).sendKeys(sdate);
							driver.findElement(By.xpath(Object.getProperty("SubscriptionEdate"))).sendKeys(edate);
							driver.findElement(By.xpath(Object.getProperty("DailyFrequency"))).click();
							driver.findElement(By.xpath(Object.getProperty("ReceiveReport"))).sendKeys(split[7]);
							WebElement click = driver.findElement(By.xpath(Object.getProperty("AddEmail")));
							Actions clk = new Actions(driver);
							clk.moveToElement(click).click(click);
							clk.perform();
							Thread.sleep(10000);
					//		if(t.isElementPresentcheck(By.xpath("html/body/div[4]"), driver))
					//		{
								//clear button verify
								driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[8]);
								driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
								Thread.sleep(3000);
								driver.findElement(By.xpath(Object.getProperty("SubscriptionClear"))).click();
								if(driver.findElement(By.xpath(Object.getProperty("SearchBox"))).getText().isEmpty())
									System.out.println("Clear button is working properly");
								//Add email 
								Thread.sleep(5000);
								Select mail = new Select(driver.findElement(By.xpath(Object.getProperty("EmailSearch"))));
								mail.selectByValue(split[9]);
								driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[10]);
								driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("SubscriptionCheckbox"))).click();
								driver.findElement(By.xpath(Object.getProperty("SubscriptionSelect"))).click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("SubscriptionSave"))).click();
								Thread.sleep(3000);
								//Mail verification should be done in this test case
								String msg = t.alertWait();
								if(msg.equalsIgnoreCase("SUCCESS"))
								{
									System.out.println("Subscription button is working as expected");
									actRes = "Subscription button is working as expected";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
									System.out.println("*********************TestCase 10 finished its execution*************************");
								}
								else
								{
									System.out.println("Subscription button is not working as expected");
									actRes = "Subscription button is not working as expected";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
									System.out.println("*********************TestCase 10 finished its execution*************************");
								}
						//	}
					//	}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}
			
			t.logout();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return data;
	}
}
