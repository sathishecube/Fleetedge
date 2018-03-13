package Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.*;

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

import FleetEdge_Core.Core;
import FleetEdge_Util.*;

public class FleetEventReport extends Core
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]> FleetEventReporttest(Map<String, Object[]> data, int rc, String sheet, ExtentTest test, int scase, int ecase) 
	{
		try
		{
			String actRes = null;
			int counter = 1;
			
			String[][] d = s.Read(path, sheet);
			
			driver = new FirefoxDriver(t.excel());
			driver.get(Object.getProperty("URL"));
			t.dologin(driver, d[0][2], d[0][3]);
			
		  try
			{
				t.overlay(driver);
				String txt = d[0][5];
				String[] splitVal = txt.split(",");
				//company search
				t.company(driver,splitVal[0],splitVal[1]);
				t.overlay(driver);
			}
			catch(Exception e){
				e.printStackTrace();
			}
		
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
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("EventReport")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 1 is executing******************************");
					
						Thread.sleep(5000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("Date")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Filter")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Columns")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("ClearFilter")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Download")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Highlight")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Subscription")), driver))
						{
							System.out.println("All the elements are present in the Fleet Event Report Dashboard");
							actRes = "All the elements are present in the Fleet Event Report Dashboard";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 1 finished its execution*************************");
						}
						else
						{
							System.out.println("All the elements are not present in the Fleet Event Report Dashboard");
							actRes = "All the elements are not present in the Fleet Event Report Dashboard";
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
				//Dashboard
				if(d[i][0].equalsIgnoreCase("TC2"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(1000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("EventReport")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 2 is executing******************************");
						Thread.sleep(5000);
						WebElement options = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul"));
						List<WebElement> li = options.findElements(By.cssSelector("[id^=lnk]"));
						for(WebElement a : li)
							System.out.println("Menu: " +a.getAttribute("innerHTML"));
						System.out.println("size: " +li.size());
						WebElement date = driver.findElement(By.xpath(Object.getProperty("Date")));
						Actions act = new Actions(driver);
						act.moveToElement( date ).click( date );    
						act.perform();
						for(int j=1;j<=li.size();j++)
						{
							WebElement opt = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li[" +j+ "]"));
							Actions act1 = new Actions(driver);
							act1.moveToElement( opt ).click( opt );    
							act1.perform();
							t.overlay(driver);
								Thread.sleep(1000);
							if(t.isElementPresentcheck(By.id("tblFleetStatusReportHeaderCopy"), driver))
								break;
							act.moveToElement( date ).click( date );    
							act.perform();
						}
						
						Thread.sleep(1000);
						ArrayList<String> colval = new ArrayList<String>();
						ArrayList<String> dashval = new ArrayList<String>();
						driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
						WebElement ele = driver.findElement(By.xpath(Object.getProperty("ColumnSelect")));
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
				//pageno button verification
				if(d[i][0].equalsIgnoreCase("TC3"))
				{
					try
					{					
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("EventReport")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 3 is executing******************************");
						
						String str = d[i][5];
						String[] split = str.split(",");
						for(int count=0;count<split.length;count++)
							System.out.println("split val: " +split[count]);
						Thread.sleep(5000);
						WebElement options = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul"));
						List<WebElement> li = options.findElements(By.cssSelector("[id^=lnk]"));
						for(WebElement a : li)
							System.out.println("Menu: " +a.getAttribute("innerHTML"));
						System.out.println("size: " +li.size());
						WebElement date = driver.findElement(By.xpath(Object.getProperty("Date")));
						Actions act = new Actions(driver);
						act.moveToElement(date).click(date);    
						act.perform();
						
						for(int j=1;j<=li.size();j++)
						{
							WebElement opt = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li[" +j+ "]"));
							Actions act1 = new Actions(driver);
							act1.moveToElement(opt).click(opt);    
							act1.perform();
							t.overlay(driver);
							Thread.sleep(1000);
							if(t.isElementPresentcheck(By.xpath("html/body/div[2]"), driver))
							{
								String sdate = t.date(split[1]);
								String edate = t.date(split[2]);
								driver.findElement(By.xpath(Object.getProperty("StartDate"))).clear();
								driver.findElement(By.xpath(Object.getProperty("StartDate"))).sendKeys(sdate);
								driver.findElement(By.xpath(Object.getProperty("EndDate"))).clear();
								driver.findElement(By.xpath(Object.getProperty("EndDate"))).sendKeys(edate);
								//clicking on search button
								driver.findElement(By.xpath(".//*[@id='ui-id-2']")).click();
								WebElement searchBtn = driver.findElement(By.xpath(".//*[@id='MainContainer_btnCustomSearch']"));
								Actions srch = new Actions(driver); 
								srch.moveToElement(searchBtn).click(searchBtn);
								srch.perform();
								t.overlay(driver);
								Thread.sleep(1000);
							}
							Thread.sleep(7500);
							if(t.isElementPresentcheck(By.id("tblFleetStatusReportHeaderCopy"), driver))
							{
								Select row = new Select(driver.findElement(By.xpath(Object.getProperty("ShowRows"))));
								row.selectByValue(split[0]);		
								t.overlay(driver);
								Thread.sleep(1000);
								ArrayList<String> num = new ArrayList<String>();
								if(t.isElementPresentcheck(By.xpath(".//*[@id='PagingText']"), driver)){
								WebElement pg = driver.findElement(By.xpath(".//*[@id='PagingText']"));
								List<WebElement> Pg = pg.findElements(By.tagName("a"));
								for(WebElement pgN : Pg)
									num.add(pgN.getText());
								for(String p : num)
									System.out.println("Page No: " +p);
								if(Pg.get(0).getText().equalsIgnoreCase("2") && Pg.get(Pg.size()-1).getText().equalsIgnoreCase("Next 10"))
								{
									System.out.println("Page is displayed successfully");
									if(d[i][6].isEmpty())
									{
										System.out.println("The page for " +li.get(j).getAttribute("innerHTML")+ " is displayed successfully");
										actRes = "The page is displayed successfully";
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
											System.out.println("The selected page for " +li.get(j).getAttribute("innerHTML")+ " is displayed as expected");
											actRes = "The selected page is displayed as expected";
											data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
											rc++;
											s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
											System.out.println("*********************TestCase 3 finished its execution*************************");
										}
										else
										{
											System.out.println("The current page for " +li.get(j).getAttribute("innerHTML")+ " does not match with the page that is selected");
											actRes = "The current page does not match with the page that is selected";
											data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
											rc++;
											s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
											System.out.println("*********************TestCase 3 finished its execution*************************");
										}
									}
								}}
								else if(!t.isElementPresentcheck(By.xpath(".//*[@id='PagingText']"), driver))
								{
									System.out.println("Only one page is present in the Dashboard");
									actRes = "Single Page is present in the Dashboard and is displayed properly";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
									System.out.println("*********************TestCase 3 finished its execution*************************");
								}
								else
								{
									if(t.isElementPresentcheck(By.xpath("html/body/div[2]"), driver))
									{
										driver.findElement(By.xpath("html/body/div[2]/div[1]/a/span")).click();
										Thread.sleep(2000);
									}
									System.out.println("The page is not displayed properly");
									actRes = "The page is not displayed properly";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
									System.out.println("*********************TestCase 3 finished its execution*************************");
								}
							}
		
							else
								System.out.println("No Records Found");
							act.moveToElement(date).click(date);    
							act.perform();
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
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("EventReport")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 4 is executing******************************");
						Thread.sleep(5000);
						WebElement options = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul"));
						List<WebElement> li = options.findElements(By.cssSelector("[id^=lnk]"));
						for(WebElement a : li)
							System.out.println("Menu: " +a.getAttribute("innerHTML"));
						System.out.println("size: " +li.size());
						WebElement date = driver.findElement(By.xpath(Object.getProperty("Date")));
						Actions act = new Actions(driver);
						act.moveToElement(date).click(date);    
						act.perform();
						
						WebElement opt = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li[4]"));
						Actions act1 = new Actions(driver);
						act1.moveToElement(opt).click(opt);    
						act1.perform();
						t.overlay(driver);
						Thread.sleep(1000);
						if(t.isElementPresentcheck(By.id("tblFleetStatusReportHeaderCopy"), driver))
						{
							WebElement rows = driver.findElement(By.xpath(Object.getProperty("ShowRows")));
							List<WebElement> rowOpt = rows.findElements(By.tagName("option"));
							//	for(WebElement op : rowOpt)
							//		System.out.println("rowOpt: " +op.getText());
							System.out.println("rowOpt size: " +rowOpt.size());
							if(rowOpt.get(0).getText().equalsIgnoreCase("10") && rowOpt.get(rowOpt.size()-1).getText().equalsIgnoreCase("100")
									&& rowOpt.get(rowOpt.size()-2).getText().equalsIgnoreCase("75") && rowOpt.get(rowOpt.size()-3).getText().equalsIgnoreCase("50"))
							{
								System.out.println("all the options are present");
							}
							for(int k=0;k<rowOpt.size();k++)
							{
								Select sel = new Select(driver.findElement(By.xpath(Object.getProperty("ShowRows"))));
								sel.selectByIndex(k);
								t.overlay(driver);
								Thread.sleep(1000);
								ArrayList<WebElement> tr = new ArrayList<WebElement>();
								WebElement page = driver.findElement(By.xpath(Object.getProperty("Dashboard")));
								List<WebElement> pgData = page.findElements(By.tagName("tr"));
								for(WebElement pg : pgData)
									tr.add(pg);
								int size = tr.size()-1;
								System.out.println("Size: " +size);
								rows = driver.findElement(By.xpath(Object.getProperty("ShowRows")));
								List<WebElement> row = rows.findElements(By.tagName("option"));
								String rowSz = row.get(k).getText();
								if(size<=Integer.parseInt(rowSz))
								{
									System.out.println("The records " +size+ " per page is displayed successfully");
									actRes = "The records per page is displayed successfully";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
									System.out.println("*********************TestCase 4 finished its execution*************************");
								}
								else
								{
									System.out.println("The records " +size+ " per page is not displayed properly");
									actRes = "The records per page is not displayed properly";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
									System.out.println("*********************TestCase 4 finished its execution*************************");
								}
							}
						}
						else
						{
							System.out.println("No Record Found");
							actRes = "No Record Found";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 4 finished its execution*************************");
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//verify date
				if(d[i][0].equalsIgnoreCase("TC5"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("EventReport")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 5 is executing******************************");
						
						t.overlay(driver);
						Thread.sleep(1000);
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(5000);
						WebElement options = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul"));
						List<WebElement> li = options.findElements(By.cssSelector("[id^=lnk]"));
						for(WebElement a : li)
							System.out.println("Menu: " +a.getAttribute("innerHTML"));
						System.out.println("size: " +li.size());
						Thread.sleep(3000);
						WebElement date = driver.findElement(By.xpath(Object.getProperty("Date")));
						Actions act = new Actions(driver);
						act.moveToElement(date).click(date);    
						act.perform();
						Thread.sleep(3000);
						for(int j=1;j<=li.size();j++)
						{
							String sdate=null,edate=null;
							WebElement opt = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li[" +j+ "]/a"));
							Actions act1 = new Actions(driver);
							act1.moveToElement(opt).click(opt);
							act1.perform();
							t.overlay(driver);
							Thread.sleep(1000);
							if(t.isElementPresentcheck(By.xpath("html/body/div[2]"), driver))
							{
								sdate = t.date(split[1]);
								edate = t.date(split[2]);
								driver.findElement(By.xpath(Object.getProperty("StartDate"))).clear();
								driver.findElement(By.xpath(Object.getProperty("StartDate"))).sendKeys(sdate);
								driver.findElement(By.xpath(Object.getProperty("EndDate"))).clear();
								driver.findElement(By.xpath(Object.getProperty("EndDate"))).sendKeys(edate);
								driver.findElement(By.xpath(".//*[@id='ui-id-2']")).click();
								WebElement searchBtn = driver.findElement(By.xpath(".//*[@id='MainContainer_btnCustomSearch']"));
								Actions srch = new Actions(driver); 
								srch.moveToElement(searchBtn).click(searchBtn);
								srch.perform();
								t.overlay(driver);
								Thread.sleep(1000);
							}
							Thread.sleep(10000);
							if(t.isElementPresentcheck(By.id("tblFleetStatusReportHeaderCopy"), driver))
							{
								Select selRow = new Select(driver.findElement(By.xpath(Object.getProperty("ShowRows"))));
								selRow.selectByValue(split[0]);
								t.overlay(driver);
								Thread.sleep(1000);
								if(driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li["+j+"]/a")).getAttribute("innerHTML").equalsIgnoreCase("Today"))
								{
									System.out.println("in today");
									String min=null,max=null;
									min = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr[2]/td[11]")).getText();
									System.out.println("Min: " +min);
								
									Select selectPg = new Select(driver.findElement(By.xpath(Object.getProperty("GoToPage"))));
									int last = selectPg.getOptions().size();
									System.out.println("Last: " +last);
									selectPg.selectByIndex(last-1);
									t.overlay(driver);
									Thread.sleep(1000);
									WebElement pageData = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody"));
									List<WebElement> lastPg = pageData.findElements(By.tagName("tr"));
									int lastPage = lastPg.size();
								//	System.out.println("Size of lastPg: " +lastPage);
									max = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+lastPage+"]/td[11]")).getText();
									System.out.println("Max: " +max);
									
									Calendar cal = Calendar.getInstance();
									Date date1 = cal.getTime();
									System.out.println("date of today: "+date1);
									SimpleDateFormat minDate = new SimpleDateFormat("MM/dd/yyyy");
									String res = minDate.format(date1);
									
									Date d1 = minDate.parse(min);
									Date d2 = minDate.parse(max);
									Date d3 = minDate.parse(res);
									System.out.println("d1: " +minDate.format(d1));
									System.out.println("d2: " +minDate.format(d2));
									if(d1.equals(d2) && d1.equals(d3))
									{
										System.out.println("The date is within the Range");
										actRes = "The date is within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
									else if(date1.toString().equalsIgnoreCase(min) && date1.toString().equalsIgnoreCase(max))
									{
										System.out.println("The date is within the Range");
										actRes = "The date is within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
									else
									{
										System.out.println("The date is not within the Range");
										actRes = "The date is not within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
								}
								else if(driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li["+j+"]/a")).getAttribute("innerHTML").equalsIgnoreCase("Yesterday"))
								{
									System.out.println("in Yesterday");
									String min=null,max=null;
									min = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr[2]/td[11]")).getText();
									System.out.println("Min: " +min);
								
									Select selectPg = new Select(driver.findElement(By.xpath(Object.getProperty("GoToPage"))));
									int last = selectPg.getOptions().size();
									System.out.println("Last: " +last);
									selectPg.selectByIndex(last-1);
									t.overlay(driver);
									Thread.sleep(1000);
									WebElement pageData = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody"));
									List<WebElement> lastPg = pageData.findElements(By.tagName("tr"));
									int lastPage = lastPg.size();
								//	System.out.println("Size of lastPg: " +lastPage);
									max = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+lastPage+"]/td[11]")).getText();
									System.out.println("Max: " +max);
									
									Calendar cal = Calendar.getInstance();
									cal.add(Calendar.DATE, -1);
									Date date1 = cal.getTime();
									System.out.println("date of yesterday: "+date1);
									SimpleDateFormat minDate = new SimpleDateFormat("MM/dd/yyyy");
									String res = minDate.format(date1);
									
									Date d1 = minDate.parse(min);
									Date d2 = minDate.parse(max);
									Date d3 = minDate.parse(res);
									System.out.println("d1: " +minDate.format(d1));
									System.out.println("d2: " +minDate.format(d2));
									if(d1.equals(d2) && d1.equals(d3))
									{
										System.out.println("The date is within the Range");
										actRes = "The date is within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
									else if(date1.toString().equalsIgnoreCase(min) && date1.toString().equalsIgnoreCase(max))
									{
										System.out.println("The date is within the Range");
										actRes = "The date is within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
									else
									{
										System.out.println("The date is not within the Range");
										actRes = "The date is not within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
								}
								else if(driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li["+j+"]/a")).getAttribute("innerHTML").equalsIgnoreCase("Last Week"))
								{
									System.out.println("in Last Week");
									String min=null,max=null;
									min = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr[2]/td[11]")).getText();
									System.out.println("Min: " +min);
								
									Select selectPg = new Select(driver.findElement(By.xpath(Object.getProperty("GoToPage"))));
									int last = selectPg.getOptions().size();
									System.out.println("Last: " +last);
									selectPg.selectByIndex(last-1);
									t.overlay(driver);
									Thread.sleep(1000);
									WebElement pageData = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody"));
									List<WebElement> lastPg = pageData.findElements(By.tagName("tr"));
									int lastPage = lastPg.size();
								//	System.out.println("Size of lastPg: " +lastPage);
									max = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+lastPage+"]/td[11]")).getText();
									System.out.println("Max: " +max);
									
									Calendar cal = Calendar.getInstance();
									cal.add(Calendar.DATE, -7);
									Date date1 = cal.getTime();
									System.out.println("date of last week: "+date1);
									SimpleDateFormat minDate = new SimpleDateFormat("MM/dd/yyyy");
									String res = minDate.format(date1);
									
									Calendar cal1 = Calendar.getInstance();
									Date date2 = cal1.getTime();
									System.out.println("today date: " +date2);
									SimpleDateFormat maxDate = new SimpleDateFormat("MM/dd/yyy");
									String res1 = minDate.format(date2);
									
									Date d1 = minDate.parse(min);
									Date d2 = maxDate.parse(max);
									Date d3 = minDate.parse(res);
									Date d4 = minDate.parse(res1);
									if(d1.equals(d2) && d1.compareTo(d3)<0 && d1.compareTo(d4)<0)
									{
										System.out.println("The date is within the Range");
										actRes = "The date is within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
									else if(d1.after(date1) && d2.before(date2))
									{
										System.out.println("The date is within the Range");
										actRes = "The date is within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
									else
									{
										System.out.println("The date is not within the Range");
										actRes = "The date is not within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
								}
								else if(driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li["+j+"]/a")).getAttribute("innerHTML").equalsIgnoreCase("Last Month"))
								{
									System.out.println("in Last Month");
									String min=null,max=null;
									min = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr[2]/td[11]")).getText();
									System.out.println("Min: " +min);
									Select selectPg = new Select(driver.findElement(By.xpath(Object.getProperty("GoToPage"))));
									int last = selectPg.getOptions().size();
									System.out.println("Last: " +last);
									selectPg.selectByIndex(last-1);
									t.overlay(driver);
									Thread.sleep(1000);
									WebElement pageData = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody"));
									List<WebElement> lastPg = pageData.findElements(By.tagName("tr"));
									int lastPage = lastPg.size();
									max = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+lastPage+"]/td[11]")).getText();
									System.out.println("Max:" +max);
									
									Calendar cal = Calendar.getInstance();
									cal.add(Calendar.MONTH, -1);
									Date date1 = cal.getTime();
									System.out.println("date of last month: "+date1);
									SimpleDateFormat minDate = new SimpleDateFormat("MM/dd/yyyy");
									System.out.println("MinDate(format date): " +minDate.format(date1));
									
									Calendar cal1 = Calendar.getInstance();
									Date date2 = cal1.getTime();
									System.out.println("today date: " +date2);
									SimpleDateFormat maxDate = new SimpleDateFormat("MM/dd/yyy");
									System.out.println("MaxDate(format date): " +maxDate.format(date2));
									
									Date d1 = minDate.parse(min);
									Date d2 = maxDate.parse(max);
									System.out.println("d1: " +minDate.format(d1));
									System.out.println("d2: " +maxDate.format(d2));
									if(d1.after(date1) && d2.before(date2))
									{
										System.out.println("The date is within the Range");
										actRes = "The date is within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
									else if(d1.equals(d2) && d1.compareTo(date1)<0 && d1.compareTo(date2)>0)
									{
										System.out.println("The date is within the Range");
										actRes = "The date is within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
									else
									{
										System.out.println("The date is not within the Range");
										actRes = "The date is not within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
								}	
								else if(driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li["+j+"]/a")).getAttribute("innerHTML").equalsIgnoreCase("Last Quarter"))
								{
									System.out.println("in Last Quarter");
									String min=null,max=null;
									min = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr[2]/td[11]")).getText();
									System.out.println("Min: " +min);
									
									Select selectPg = new Select(driver.findElement(By.xpath(Object.getProperty("GoToPage"))));
									int last = selectPg.getOptions().size();
									System.out.println("Last: " +last);
									selectPg.selectByIndex(last-1);
									t.overlay(driver);
									Thread.sleep(1000);
									if(t.isElementPresentcheck(By.xpath(Object.getProperty("Dashboard")), driver))
									{
									WebElement pageData = driver.findElement(By.xpath(Object.getProperty("Dashboard")));
									List<WebElement> lastPg = pageData.findElements(By.tagName("tr"));
									int lastPage = lastPg.size();
									System.out.println("Size of lastPg: " +lastPage);
									max = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+lastPage+"]/td[11]")).getText();
									System.out.println("Max:" +max);
									
									Calendar cal = Calendar.getInstance();
									cal.add(Calendar.MONTH, -3);
									Date date1 = cal.getTime();
								//	System.out.println("date of last quarter: "+date1);
									SimpleDateFormat minDate = new SimpleDateFormat("MM/dd/yyyy");
									System.out.println("MinDate(format date): " +minDate.format(date1));
									
									Calendar cal1 = Calendar.getInstance();
									Date date2 = cal1.getTime();
							//		System.out.println("today date: " +date2);
									SimpleDateFormat maxDate = new SimpleDateFormat("MM/dd/yyy");
									System.out.println("MaxDate(format date): " +maxDate.format(date2));
									
									Date d1 = minDate.parse(min);
									Date d2 = maxDate.parse(max);
									System.out.println("d1: " +minDate.format(d1));
									System.out.println("d2: " +maxDate.format(d2));
									if(d1.after(date1) && d2.before(date2))
									{
										System.out.println("The date is within the Range");
										actRes = "The date is within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
									else if(min.equalsIgnoreCase(max) && d1.compareTo(date1)<0 && d1.compareTo(date2)>0)
									{
										System.out.println("The date is within the Range");
										actRes = "The date is within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
									else
									{
										System.out.println("The date is not within the Range");
										actRes = "The date is not within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}}else
									{
										System.out.println("No Record Found");
										actRes = "No Record Found";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
								}
								else if(driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li["+j+"]/a")).getAttribute("innerHTML").contains("Custom  - "))
								{
									System.out.println("in custom");
									String min=null,max=null;
									min = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr[2]/td[11]")).getText();
									System.out.println("Min: " +min);
									
									Select selectPg = new Select(driver.findElement(By.xpath(Object.getProperty("GoToPage"))));
									int last = selectPg.getOptions().size();
									System.out.println("Last: " +last);
									selectPg.selectByIndex(last-1);
									t.overlay(driver);
									Thread.sleep(1000);
									WebElement pageData = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody"));
									List<WebElement> lastPg = pageData.findElements(By.tagName("tr"));
									int lastPage = lastPg.size();
									System.out.println("Size of lastPg: " +lastPage);
									max = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+lastPage+"]/td[11]")).getText();
									System.out.println("Max:" +max);
									SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
									
									Date date1 = sdf.parse(sdate);
									Date date2 = sdf.parse(edate);
									Date d1 = sdf.parse(min);
									Date d2 = sdf.parse(max);
									if(d1.after(date1) && d2.before(date2))
									{
										System.out.println("The date is within the Range");
										actRes = "The date is within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
									else if(min.equalsIgnoreCase(max) && d1.compareTo(date1)<0 && d1.compareTo(date2)>0)
									{
										System.out.println("The date is within the Range");
										actRes = "The date is within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
									else
									{
										System.out.println("The date is not within the Range");
										actRes = "The date is not within the Range";
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
										System.out.println("*********************TestCase 5 finished its execution*************************");
									}
								}
							}
							else
							{
								System.out.println("No Record Found");
								actRes = "No Record Found";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 5 finished its execution*************************");
							}
							Thread.sleep(2000);
							act.moveToElement(date).click(date);    
							act.perform();
						}
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//add and delete filter
				if(d[i][0].equalsIgnoreCase("TC6"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("EventReport")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 6 is executing******************************");
						Thread.sleep(5000);
											
						WebElement options = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul"));
						List<WebElement> li = options.findElements(By.cssSelector("[id^=lnk]"));
						System.out.println("size: " +li.size());
						WebElement date = driver.findElement(By.xpath(Object.getProperty("Date")));
						Actions act = new Actions(driver);
						act.moveToElement(date).click(date);    
						act.perform();
						Thread.sleep(2000);
						Boolean search = null,save,close,delOpt = null;
						String str = d[i][5];
						String[] split = str.split(",");
						for(int j=0;j<split.length;j++)
							System.out.println("Split val: " +split[j]);
						WebElement opt = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li["+(li.size()-3)+"]"));
						Actions act1 = new Actions(driver);
						act1.moveToElement(opt).click(opt);    
						act1.perform();
						t.overlay(driver);
						Thread.sleep(1000);
					//	System.out.println(driver.findElement(By.xpath(Object.getProperty("Filter"))).getText());
						Select filter = new Select(driver.findElement(By.xpath(Object.getProperty("Filter"))));
						filter.selectByVisibleText(split[0]);
						t.overlay(driver);
						Thread.sleep(1000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("AddFilterPage")), driver))
						{
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("SelectID")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("FilterOperator")), driver)
									|| t.isElementPresentcheck(By.xpath(Object.getProperty("InputBox")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("AddBtn")), driver)
									|| t.isElementPresentcheck(By.xpath(Object.getProperty("AddSearch")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("NewReport")), driver)
									|| t.isElementPresentcheck(By.xpath(Object.getProperty("CloseBtn")), driver))
							{
								System.out.println("All the elements are present in the Add Filter page");
							}
							//verify search button
							Select id = new Select(driver.findElement(By.xpath(Object.getProperty("SelectID"))));
							id.selectByVisibleText(split[1]);
							Select operand = new Select(driver.findElement(By.xpath(Object.getProperty("FilterOperator"))));
							operand.selectByVisibleText(split[2]);
							driver.findElement(By.xpath(Object.getProperty("InputBox"))).sendKeys(split[3]);
							driver.findElement(By.xpath(Object.getProperty("AddSearch"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("Columns"))).click();
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("ColumnPage")), driver))
							{
								WebElement col = driver.findElement(By.xpath(Object.getProperty("ColumnSelect")));
								List<WebElement> colVal = col.findElements(By.tagName("option"));
								System.out.println("size: " +colVal.size());
								int count=0;
								for(int k=0;k<colVal.size();k++)
								{
									if(colVal.get(k).getText().equalsIgnoreCase(split[1]))
										count=k+1;
								}
								System.out.println("Count: " +count);
								driver.findElement(By.xpath(Object.getProperty("ColumnClose"))).click();
								Thread.sleep(7000);
								WebElement table = driver.findElement(By.xpath(Object.getProperty("Dashboard")));
								List<WebElement> tab = table.findElements(By.tagName("tr"));
								String[] tableData = new String[tab.size()];
								for(int sz=2;sz<tab.size();sz++)
								{
									tableData[sz-2] = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportFreeze']/tbody/tr["+sz+"]/td["+count+"]")).getText();
									if(tableData[sz-2].equalsIgnoreCase(split[3]))
										search = true;
									else
										search = false;
								/*	switch(split[2])
									{
										case "Equals":
											if(tableData[sz-2].equalsIgnoreCase(split[3]))
												search = true;
											//	System.out.println("search pass");}
											else
												search = false;
											//	System.out.println("search fail");}
											break;
										case "Contains":
											if(tableData[sz-2].contains(split[3]))
												search = true;
											//	System.out.println("search pass");}
											else
												search = false;
											//	System.out.println("search fail");}
											break;
										case "Having":
											if(tableData[sz-2].contains(split[3]))
												search = true;
											//	System.out.println("search pass");}
											else
												search = false;
											//	System.out.println("search fail");}
											break;
										case "Is Empty":
											
											break;
										case "Is Not Empty":
											
											break;
										case "Greater Than":
											
											break;
										case "Less Than":
											
											break;
										case "Not Equals":
											if(!tableData[sz-2].equalsIgnoreCase(split[3]))
												search = true;
											//	System.out.println("search pass");}
											else
												search = false;
											//	System.out.println("search fail");}
											break;
									}*/
								}
								
								t.clearFilter();
								Thread.sleep(3000);
								//save new filter verification
								Select filter1 = new Select(driver.findElement(By.xpath(Object.getProperty("Filter"))));
								filter1.selectByVisibleText(split[0]);
								Select id1 = new Select(driver.findElement(By.xpath(Object.getProperty("SelectID"))));
								id1.selectByVisibleText(split[1]);
								Select operand1 = new Select(driver.findElement(By.xpath(Object.getProperty("FilterOperator"))));
								operand1.selectByVisibleText(split[2]);
								driver.findElement(By.xpath(Object.getProperty("InputBox"))).sendKeys(split[3]);
							/*	WebElement input = driver.findElement(By.xpath(Object.getProperty("InputBox")));
								Actions in = new Actions(driver);
								in.moveToElement(input).sendKeys(split[3]);
								in.perform();*/
								Thread.sleep(3000);
								WebElement clickSave = driver.findElement(By.xpath(Object.getProperty("NewReport")));
								Actions click = new Actions(driver);
								click.moveToElement(clickSave).click(clickSave);
								click.perform();
								Thread.sleep(2000);
								driver.findElement(By.xpath(".//*[@id='MainContainer_txtFilterName']")).sendKeys(split[4]);
								driver.findElement(By.xpath(".//*[@id='MainContainer_btnSaveRowFilter']")).click();
								t.overlay(driver);
								Thread.sleep(1000);
								String a = t.alertWait();
								if(a.equalsIgnoreCase("Filter saved successfully"))
									save=true;
								else
									save=false;
								t.clearFilter();
								Thread.sleep(5000);
								//close
								Select filter2 = new Select(driver.findElement(By.xpath(Object.getProperty("Filter"))));
								filter2.selectByVisibleText(split[0]);
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("CloseBtn"))).click();
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("Dashboard")), driver))
										close=true;
								else
									close=false;
								t.clearFilter();
								Thread.sleep(3000);
								//delete filter verification
								Select deleteFilter = new Select(driver.findElement(By.xpath(Object.getProperty("Filter"))));
								deleteFilter.selectByVisibleText(d[i][6]);
								Thread.sleep(20000);
								if(t.isElementPresentcheck(By.xpath(".//*[@id='divTmsReportDeleteFilter']"), driver))
								{
									String name=null;
									WebElement delTable = driver.findElement(By.xpath(".//*[@id='tblFsUserCreatedFilterData']/tbody"));
									List<WebElement> delData = delTable.findElements(By.tagName("tr"));
									System.out.println("size: " +delData.size());
									for(int find=2;find<=delData.size();find++)
									{
										Thread.sleep(7000);
										name = driver.findElement(By.xpath(".//*[@id='tblFsUserCreatedFilterData']/tbody/tr["+find+"]/td[1]")).getText();
										System.out.println("name: " +name);
										if(name.equalsIgnoreCase(split[4]))
										{
											Thread.sleep(7000);
											driver.findElement(By.xpath(".//*[@id='tblFsUserCreatedFilterData']/tbody/tr["+find+"]/td[2]/div/button")).click();
											String delFil = t.alertWait();
											if(delFil.equalsIgnoreCase("Success"))
											{
												WebElement filterOpt = driver.findElement(By.xpath(Object.getProperty("Filter")));
												List<WebElement> options1 = filterOpt.findElements(By.tagName("option"));
												for(WebElement op : options1)
												{
													System.out.println("options: " +op.getText());
													if(op.getText().equalsIgnoreCase(split[4]))
														delOpt = false;
													else{
														delOpt=true;
														break;}
												}
											}
											else
											{
												delOpt=false;
												break;
											}
										}
									}
								}
								System.out.println("search result: " +search);
								System.out.println("save result: " +save);
								System.out.println("delete result: " +delOpt);
								System.out.println("close result: " +close);
								
								if(search==true && save==true && delOpt==true && close==true)
								{
									System.out.println("The Filter Options are working as expected");
									actRes = "The Filter Options are working as expected";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
									System.out.println("*********************TestCase 6 finished its execution*************************");
								}
								else
								{
									System.out.println("The Filter Options are not working as expected");
									actRes = "The Filter Options are not working as expected";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
									System.out.println("*********************TestCase 6 finished its execution*************************");
								}
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//clear filter
				if(d[i][0].equalsIgnoreCase("TC7"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("EventReport")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 7 is executing******************************");
						Thread.sleep(5000);
						
						WebElement options = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul"));
						List<WebElement> li = options.findElements(By.cssSelector("[id^=lnk]"));
						System.out.println("size: " +li.size());
						WebElement date = driver.findElement(By.xpath(Object.getProperty("Date")));
						Actions act = new Actions(driver);
						act.moveToElement(date).click(date);    
						act.perform();
						WebElement opt = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li["+(li.size()-3)+"]"));
						Actions act1 = new Actions(driver);
						act1.moveToElement(opt).click(opt);    
						act1.perform();
						t.overlay(driver);
						Thread.sleep(2000);
						t.clearFilter();
						Thread.sleep(3000);
						
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("Date")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Filter")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Columns")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("ClearFilter")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Download")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Highlight")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Subscription")), driver))
						{
							System.out.println("Clear Filter is working as expected");
							actRes = "Clear Filter is working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 7 finished its execution*************************");
						}
						else
						{
							System.out.println("Clear Filter is not working as expected");
							actRes = "Clear Filter is not working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 7 finished its execution*************************");
						}
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//highlight button
				if(d[i][0].equalsIgnoreCase("TC8"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("EventReport")));
						t.fleetSelect(driver,x,y);
						Thread.sleep(5000);
						
						System.out.println("**************************TestCase 8 is executing******************************");
						WebElement options = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul"));
						List<WebElement> li = options.findElements(By.cssSelector("[id^=lnk]"));
						System.out.println("size: " +li.size());
						WebElement date = driver.findElement(By.xpath(Object.getProperty("Date")));
						Actions act = new Actions(driver);
						act.moveToElement(date).click(date);    
						act.perform();
						WebElement opt = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li["+(li.size()-3)+"]"));
						Actions act1 = new Actions(driver);
						act1.moveToElement(opt).click(opt);    
						act1.perform();
						t.overlay(driver);
						Thread.sleep(1000);
						Boolean saveRow = null,clear = null,cancel = null,close = null,delete = null,update = null;
						//split values
						String str = d[i][5];
						String[] split = str.split(",");
						String str1 = d[i][6];
						String[] split1 = str1.split("#");
						Thread.sleep(3000);
						int sNo=0,equipId=0;
						
						//save button verification
						driver.findElement(By.xpath(Object.getProperty("Highlight"))).click();
						Thread.sleep(7000);
						if(t.isElementPresentcheck(By.xpath(".//*[@id='divHighlightRowColumnPHolder']"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("HighlightNew"))).click();
							Thread.sleep(3000);
							if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
							{
								driver.findElement(By.xpath(Object.getProperty("CheckRow"))).click();
								Select rowColor = new Select(driver.findElement(By.xpath(Object.getProperty("RowColor"))));
								rowColor.selectByVisibleText(split[0]);
								Select id = new Select(driver.findElement(By.xpath(Object.getProperty("RowId"))));
								id.selectByVisibleText(split[1]);
								Select oprn = new Select(driver.findElement(By.xpath(Object.getProperty("RowOperator"))));
								oprn.selectByVisibleText(split[2]);
								driver.findElement(By.xpath(Object.getProperty("RowText"))).sendKeys(split[3]);
								Thread.sleep(3000);
								//column selection
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
								String alert = t.alertWait();
								if(alert.equalsIgnoreCase("Filter saved successfully"))
								{
									System.out.println("row and column is highlighted successfully");
									t.overlay(driver);
									Thread.sleep(1000);
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
											sNo=k+1;
										else if(selVal.get(k).getText().equalsIgnoreCase(split[5]))
											equipId=k+1;
									}
									driver.findElement(By.xpath(Object.getProperty("ColumnClose"))).click();
									System.out.println("sno: " +sNo);
									System.out.println("equipId: " +equipId);
									Thread.sleep(7000);
									WebElement table = driver.findElement(By.xpath(Object.getProperty("Dashboard")));
									List<WebElement> tr = table.findElements(By.tagName("tr"));
									System.out.println("tr size: " +tr.size());
									String code=null;
									Thread.sleep(5000);
									for(int click=2;click<=tr.size();click++)
									{
										String snoValue = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+click+"]/td["+sNo+"]")).getText();
										if(snoValue.equalsIgnoreCase(split[3]))
										{
											WebElement colorCode = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+click+"]/td["+sNo+"]"));
											code = colorCode.getCssValue("background-color");
											if(code.equalsIgnoreCase(split1[0]))
												saveRow = true;
											else
												saveRow = false;
										}
										String equipValue = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+click+"]/td["+equipId+"]")).getText();
										if(equipValue.equalsIgnoreCase(split[7]))
										{
											WebElement colorCode = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+click+"]/td["+equipId+"]"));
											code = colorCode.getCssValue("background-color");
											if(code.equalsIgnoreCase(split1[1]))
												saveRow = true;
											else
												saveRow = false;
										}
									}
								}
								else
									saveRow=false;
							}
						}
						System.out.println("save result: "+saveRow);
						//cancel button verification
						driver.findElement(By.xpath(Object.getProperty("Highlight"))).click();
						Thread.sleep(7000);
						if(t.isElementPresentcheck(By.xpath(".//*[@id='divHighlightRowColumnPHolder']"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("HighlightNew"))).click();
							Thread.sleep(3000);
							if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
							{
								Thread.sleep(3000);
								driver.findElement(By.xpath(Object.getProperty("CancelHighlight"))).click();
								if(t.isElementPresentcheck(By.xpath(".//*[@id='divHighlightRowColumnPHolder']"), driver))
									cancel=true;
								else
									cancel=false;
							}
						}
						System.out.println("cancel result: "+cancel);
						//close button verification
						driver.findElement(By.xpath(Object.getProperty("Highlight"))).click();
						Thread.sleep(7000);
						if(t.isElementPresentcheck(By.xpath(".//*[@id='divHighlightRowColumnPHolder']"), driver))
						{
							Thread.sleep(7000);
							driver.findElement(By.xpath(Object.getProperty("HighlightNew"))).click();
							Thread.sleep(3000);
							if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
							{
								Thread.sleep(3000);
								driver.findElement(By.xpath(Object.getProperty("CloseHighlight"))).click();
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("Dashboard")), driver))
									close=true;
								else
									close=false;
							}
						}
						System.out.println("close result: " +close);
						//clear and update button verification
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
						System.out.println("update result: " +update);
						System.out.println("clear result: " +clear);
						//delete verification
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
						//final check
						if(saveRow==true && clear==true && cancel==true && close==true && delete==true && update==true)
						{
							System.out.println("Highlight is working as expected");
							actRes = "Highlight is working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 8 finished its execution*************************");
						}
						else
						{
							System.out.println("Highlight is not working as expected");
							actRes = "Highlight is not working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 8 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//column verification
				if(d[i][0].equalsIgnoreCase("TC9"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("EventReport")));
						t.fleetSelect(driver,x,y);
						Thread.sleep(3000);
						System.out.println("**************************TestCase 9 is executing******************************");
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(5000);
						
						WebElement options = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul"));
						List<WebElement> li = options.findElements(By.cssSelector("[id^=lnk]"));
						System.out.println("size: " +li.size());
						WebElement date = driver.findElement(By.xpath(Object.getProperty("Date")));
						Actions act = new Actions(driver);
						act.moveToElement(date).click(date);    
						act.perform();
						WebElement opt = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li["+(li.size()-3)+"]"));
						Actions act1 = new Actions(driver);
						act1.moveToElement(opt).click(opt);    
						act1.perform();
						t.overlay(driver);
						Thread.sleep(2000);
						int sz=0,newSz=0,position=0,newPos=0,removeSz=0;
						WebElement head = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
						List<WebElement> headSz = head.findElements(By.tagName("th"));
						for(int k=0;k<headSz.size();k++)
						{
							System.out.println("beforeup: " +headSz.get(k).getText());
							if(headSz.get(k).getText().equalsIgnoreCase(split[0])){
								System.out.println("inside if");
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
								Thread.sleep(2000);
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
								Thread.sleep(2000);
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
							System.out.println("The column is added in the Fleet Event Report Dashboard successfully");
							actRes = "The column is added in the Fleet Event Report Dashboard successfully";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 9 finished its execution*************************");
						}
						else
						{
							System.out.println("The column is not added in the Fleet Event Report Dashboard");
							actRes = "The column is not added in the Fleet Event Report Dashboard";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 9 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//download verification
				if(d[i][0].equalsIgnoreCase("TC10"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("EventReport")));
						t.fleetSelect(driver,x,y);
						Thread.sleep(3000);
						System.out.println("**************************TestCase 10 is executing******************************");
						
						//ArrayList<String> tr=new ArrayList<String>();
						int Count=0;
						int lastRow=0;
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(5000);
						
						WebElement options = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul"));
						List<WebElement> li = options.findElements(By.cssSelector("[id^=lnk]"));
						System.out.println("size: " +li.size());
						WebElement date = driver.findElement(By.xpath(Object.getProperty("Date")));
						Actions act = new Actions(driver);
						act.moveToElement(date).click(date);    
						act.perform();
						WebElement opt = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li["+li.size()+"]"));
						Actions act1 = new Actions(driver);
						act1.moveToElement(opt).click(opt);    
						act1.perform();
						if(t.isElementPresentcheck(By.xpath("html/body/div[2]"), driver))
						{
							String sdate = t.date(split[2]);
							String edate = t.date(split[3]);
							driver.findElement(By.xpath(Object.getProperty("StartDate"))).clear();
							driver.findElement(By.xpath(Object.getProperty("StartDate"))).sendKeys(sdate);
							driver.findElement(By.xpath(Object.getProperty("EndDate"))).clear();
							driver.findElement(By.xpath(Object.getProperty("EndDate"))).sendKeys(edate);
							//clicking on search button
							driver.findElement(By.xpath(".//*[@id='ui-id-2']")).click();
							WebElement searchBtn = driver.findElement(By.xpath(".//*[@id='MainContainer_btnCustomSearch']"));
							Actions srch = new Actions(driver); 
							srch.moveToElement(searchBtn).click(searchBtn);
							srch.perform();
							t.overlay(driver);
							Thread.sleep(1000);
						}
						Thread.sleep(10000);
						
						//download excel verification
						Select rows = new Select(driver.findElement(By.xpath(Object.getProperty("ShowRows"))));
						rows.selectByValue(split[0]);
						t.overlay(driver);
						Thread.sleep(2000);
						Select filter = new Select(driver.findElement(By.xpath(Object.getProperty("Filter"))));
						filter.selectByValue(split[1]);
						t.overlay(driver);
						Thread.sleep(2000);
						//Excel download
						driver.findElement(By.xpath(Object.getProperty("Download"))).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath(Object.getProperty("DownloadExcel"))).click();
						t.overlay(driver);
						Thread.sleep(40000);
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_DOWN);
						Thread.sleep(500);
						robot.keyRelease(KeyEvent.VK_DOWN);
						Thread.sleep(500);
						robot.keyPress(KeyEvent.VK_ENTER);
						Thread.sleep(500);
						robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(10000);
						String totPgNo = driver.findElement(By.id("divPaging")).getText();
					//	System.out.println("Tot pg no: " +totPgNo);
						int sind=0, eind=0;
						String record = new String();
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
						try{
						FileInputStream in = new FileInputStream("D:\\workspace\\TMP\\DownloadExcel\\AllEvent.xlsx");
						Workbook wb = new XSSFWorkbook(in);
						Sheet sh = wb.getSheetAt(0);
						lastRow = sh.getLastRowNum();
						
						
						Count = Integer.valueOf(exactRec[0]);}
						catch(NumberFormatException e)
						{
							e.printStackTrace();
						}
						System.out.println("LastRow: " +lastRow);
						System.out.println("count: " +Count);
						if(lastRow==Count)
						{
							System.out.println("The Excel file is downloaded successfully and the count is matched");
							actRes = "The file is downloaded successfully and the count is matched";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 10 finished its execution*************************");
						}
						else
						{
							System.out.println("The Excel file is not downloaded properly and the count is mismatched");
							actRes = "The file is not downloaded properly and the count is mismatched";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 10 finished its execution*************************");
						}
						
						//PDF download
					/*	driver.findElement(By.xpath(Object.getProperty("Download"))).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath(Object.getProperty("DownloadPDF"))).click();
						t.overlay(driver);
						Thread.sleep(25000);
						Robot robot1 = new Robot();
						robot1.keyPress(KeyEvent.VK_ENTER);
						Thread.sleep(500);
						robot1.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(10000);
						String totPgNo1 = driver.findElement(By.id("divPaging")).getText();
					//	System.out.println("Tot pg no: " +totPgNo);
						int sind1=0, eind1=0;
						String record1 = new String();
						if(totPgNo1.contains("("))
						{
							sind1 = totPgNo1.indexOf("(");
							eind1 = totPgNo1.indexOf(")");
							record1 = totPgNo1.substring(sind1+1, eind1);
							System.out.println("No of Records(approx): " +record1);
						}
						String[] exactRec1 = record1.split("records");
						System.out.println("Exact value of record: " +exactRec1[0]);
						int count = Integer.parseInt(exactRec1[0].trim());
						
						PDFTextStripper pdfStripper = new PDFTextStripper();
						PDDocument pdDoc = PDDocument.load(new File("D:\\workspace\\TMP\\DownloadExcel\\AllEvent.pdf"));
						int noOfPages = pdDoc.getNumberOfPages();
						System.out.println("no of pages: " +noOfPages);
						pdfStripper.setStartPage(1);
						pdfStripper.setEndPage(noOfPages);
						
						String text = null;
						text = pdfStripper.getText(pdDoc);
						System.out.println("text in pdf: " +text);
						
						int pdfCount = noOfPages*7;
						System.out.println("count of PDF: " +pdfCount);
						if(count<=pdfCount)
						{
							System.out.println("The PDF file is not downloaded properly and the count is matched");
							actRes = "The file is not downloaded properly and the count is matched";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 10 finished its execution*************************");
						}
						else
						{
							System.out.println("The PDF file is downloaded successfully and the count is mismatched");
							actRes = "The file is downloaded successfully and the count is mismatched";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 10 finished its execution*************************");
						}*/
					}
					
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//subscription verification
				if(d[i][0].equalsIgnoreCase("TC11"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Fleet")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("EventReport")));
						t.fleetSelect(driver,x,y);
						Thread.sleep(3000);
						System.out.println("**************************TestCase 11 is executing******************************");
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(7000);
						
						driver.findElement(By.xpath(Object.getProperty("Subscription"))).click();
						Thread.sleep(7000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
						{
							Thread.sleep(4000);
							Select filterType = new Select(driver.findElement(By.xpath(Object.getProperty("SubscriptionFilter"))));
							filterType.selectByValue(split[0]);
							String sdate = t.date(split[1]);
							String edate = t.date(split[2]);
							driver.findElement(By.xpath(Object.getProperty("SubscriptionSdate"))).sendKeys(sdate);
							driver.findElement(By.xpath(Object.getProperty("SubscriptionEdate"))).sendKeys(edate);
							driver.findElement(By.xpath(Object.getProperty("DailyFrequency"))).click();
							driver.findElement(By.xpath(Object.getProperty("ReceiveReport"))).sendKeys(split[3]);
							WebElement click = driver.findElement(By.xpath(Object.getProperty("AddEmail")));
							Actions clk = new Actions(driver);
							clk.moveToElement(click).click(click);
							clk.perform();
							Thread.sleep(10000);
					//		if(t.isElementPresentcheck(By.xpath("html/body/div[4]"), driver))
					//		{
								//clear button verify
								driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[6]);
								driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
								Thread.sleep(3000);
								driver.findElement(By.xpath(Object.getProperty("SubscriptionClear"))).click();
								if(driver.findElement(By.xpath(Object.getProperty("SearchBox"))).getText().isEmpty())
									System.out.println("Clear button is working properly");
								//Add email 
								Thread.sleep(5000);
								Select mail = new Select(driver.findElement(By.xpath(Object.getProperty("EmailSearch"))));
								mail.selectByValue(split[4]);
								driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[5]);
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
									System.out.println("*********************TestCase 11 finished its execution*************************");
								}
								else
								{
									System.out.println("Subscription button is not working as expected");
									actRes = "Subscription button is not working as expected";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
									System.out.println("*********************TestCase 11 finished its execution*************************");
								}
						//	}
						}
					}
					catch(Exception e){
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
