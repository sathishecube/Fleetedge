package Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import FleetEdge_Core.Core;
import FleetEdge_Util.*;

public class IssueResolver extends Core 
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]> IssueResolverTest(Map<String, Object[]> data, int rc, String sheet, ExtentTest test, int scase, int ecase) 
	{
		
		try
		{
			String actRes = null;
			int counter=1;

			String[][] d = s.Read(path, sheet);

			driver = new FirefoxDriver(t.excel());
			driver.get(Object.getProperty("URL"));
			t.dologin(driver, d[0][2], d[0][3]);
			
		/*	try
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
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("IssueResolver")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 1 is executing******************************");
						Thread.sleep(5000);
						
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("IssueSearchType")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("SearchBox")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("SearchBtn")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("ClearBtn")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("NewIssue")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("EditIssue")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("DeleteIssue")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("ResolveIssue")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("ExportExcel")), driver))
						{
							System.out.println("All the elements are present in the Issue Resolver");
							actRes = "All the elements are present in the Issue Resolver";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 1 finished its execution*************************");
						}
						else
						{
							System.out.println("All the elements are not present in the Issue Resolver");
							actRes = "All the elements are not present in the Issue Resolver";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 1 finished its execution*************************");
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//search button
				if(d[i][0].equalsIgnoreCase("TC2"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("IssueResolver")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 2 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						Boolean search=false;
						Select type = new Select(driver.findElement(By.xpath(Object.getProperty("IssueSearchType"))));
						type.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						List<WebElement> tr = driver.findElements(By.xpath(".//*[@id='tblResolverList']/tbody/tr/td"));
						for(int j=0;j<tr.size();j++)
						{
							if(tr.get(j).getText().contains(split[1])){
								search = true;
								break;}
						}
						driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						if(search==true && driver.findElement(By.xpath(Object.getProperty("SearchBox"))).getText().isEmpty())
						{
							System.out.println("Search and Clear button are working as expected");
							actRes = "Search and Clear button are working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 2 finished its execution*************************");
						}
						else
						{
							System.out.println("Search and Clear button are not working as expected");
							actRes = "Search and Clear button are not working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 2 finished its execution*************************");
						}
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//new button
				if(d[i][0].equalsIgnoreCase("TC3"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("IssueResolver")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 3 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						Boolean create = false;
						driver.findElement(By.xpath(Object.getProperty("NewIssue"))).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("EquipmentName"))).sendKeys(split[0]);
						String date = t.date(split[1]);
						System.out.println("Date: " +date);
						driver.findElement(By.xpath(Object.getProperty("OccuredOn"))).sendKeys(date);
						Select type = new Select(driver.findElement(By.xpath(Object.getProperty("IssueType"))));
						type.selectByVisibleText(split[2]);
						Select urgency = new Select(driver.findElement(By.xpath(Object.getProperty("IssueUrgency"))));
						urgency.selectByValue(split[3]);
						driver.findElement(By.xpath(Object.getProperty("Save"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						String msg = t.alertWait();
						if(msg.equalsIgnoreCase("Issue created successfully"))
						{
							t.overlay(driver);
							Thread.sleep(2000);
							Select equip = new Select(driver.findElement(By.xpath(Object.getProperty("IssueSearchType"))));
							equip.selectByValue(split[4]);
							driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
							driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							List<WebElement> tr = driver.findElements(By.xpath(".//*[@id='tblResolverList']/tbody/tr/td"));
							for(int j=0;j<tr.size();j++)
							{
								System.out.println("val: " +tr.get(j).getText());
								if(tr.get(j).getText().contains(split[0])){
									create = true;
									break;}
							}
						}
						if(create==true)
						{
							System.out.println("New Button is working as expected");
							actRes = "New Button is working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 3 finished its execution*************************");
						}
						else
						{
							actRes = "New Button is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 3 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//edit button
				if(d[i][0].equalsIgnoreCase("TC4"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("IssueResolver")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 4 is executing******************************");
						Thread.sleep(5000);
						
						Boolean edit = false;
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						Select equip = new Select(driver.findElement(By.xpath(Object.getProperty("IssueSearchType"))));
						equip.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						driver.findElement(By.xpath(".//*[@id='tblResolverList']/tbody/tr/td[1]")).click();
						t.overlay(driver);
						Thread.sleep(1000);
						driver.findElement(By.xpath(Object.getProperty("EditIssue"))).click();
						Thread.sleep(3000);
						Select urgency = new Select(driver.findElement(By.xpath(Object.getProperty("IssueUrgency"))));
						urgency.selectByValue(split[2]);
						driver.findElement(By.xpath(Object.getProperty("Save"))).click();
						String msg = t.alertWait();
						if(msg.equalsIgnoreCase("Issue updated successfully"))
						{
							equip = new Select(driver.findElement(By.xpath(Object.getProperty("IssueSearchType"))));
							equip.selectByValue(split[0]);
							driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
							driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							List<WebElement> tr = driver.findElements(By.xpath(".//*[@id='tblResolverList']/tbody/tr/td"));
							for(int j=0;j<tr.size();j++)
							{
								System.out.println("val: " +tr.get(j).getText());
								if(tr.get(j).getText().contains(split[2])){
									edit = true;
									break;}
							}
						}
						if(edit==true)
						{
							actRes = "Edit Button is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 4 finished its execution*************************");
						}
						else
						{
							actRes = "Edit Button is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 4 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//Export Excel
				if(d[i][0].equalsIgnoreCase("TC5"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("IssueResolver")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 5 is executing******************************");
						Thread.sleep(5000);
						
						String totPgNo = driver.findElement(By.id("divPaging")).getText();
					//	System.out.println("Tot pg no: " +totPgNo);
						int sind=0, eind=0,recCount=0;
						String record = new String();
						if(totPgNo.contains("("))
						{
							sind = totPgNo.indexOf("(");
							eind = totPgNo.indexOf(")");
							record = totPgNo.substring(sind+1, eind);
							System.out.println("No of Records(approx): " +record);
						}
						String[] exactRec = record.split("records");
						System.out.println("Exact value of record: " +exactRec[0]);
						String rec = exactRec[0].replaceAll(" ", "");
						recCount = Integer.parseInt(rec);
						System.out.println("Records count: " +recCount);
						
						driver.findElement(By.xpath(Object.getProperty("ExportExcel"))).click();
						Thread.sleep(30000);
						System.out.println("Robot class");
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_DOWN);
						Thread.sleep(500);
						robot.keyRelease(KeyEvent.VK_DOWN);
						Thread.sleep(500);
						robot.keyPress(KeyEvent.VK_ENTER);
						Thread.sleep(500);
						robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(15000);
						int lastRow=0;
						try
						{
							FileInputStream in = new FileInputStream(new File("D:\\workspace\\TMP\\DownloadExcel\\IssueResolver.xls"));
							Workbook wb = new HSSFWorkbook(in);
							HSSFSheet sh = (HSSFSheet) wb.getSheetAt(0);
							lastRow = sh.getLastRowNum();
							System.out.println("LastRow: " +lastRow);		
							in.close();
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
						if(lastRow==recCount)
						{
							actRes = "Excel file is downloaded successfully and the Records count is matched";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 5 finished its execution*************************");
						}
						else
						{
							actRes = "Excel file is not downloaded successfully and the Records count is mismatched";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 5 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//Resolver button
				if(d[i][0].equalsIgnoreCase("TC6"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("IssueResolver")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 6 is executing******************************");
						Thread.sleep(5000);
						
						Boolean resolve = false;
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						Select equip = new Select(driver.findElement(By.xpath(Object.getProperty("IssueSearchType"))));
						equip.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						driver.findElement(By.xpath(".//*[@id='tblResolverList']/tbody/tr/td[1]")).click();
						t.overlay(driver);
						Thread.sleep(1000);
						driver.findElement(By.xpath(Object.getProperty("ResolveIssue"))).click();
						WebDriverWait wait = new WebDriverWait(driver, 20);
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[3]")));
						if(t.isElementPresentcheck(By.xpath("/html/body/div[3]"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("ResolveSubmit"))).click();
							String msg = t.alertWait();
							if(msg.equalsIgnoreCase("Issue resolved successfully"))
							{
								equip = new Select(driver.findElement(By.xpath(Object.getProperty("IssueSearchType"))));
								equip.selectByValue(split[0]);
								driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
								t.overlay(driver);
								Thread.sleep(1000);
								driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
								driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
								t.overlay(driver);
								Thread.sleep(1000);
								List<WebElement> tr = driver.findElements(By.xpath(".//*[@id='tblResolverList']/tbody/tr/td"));
								for(int j=0;j<tr.size();j++)
								{
									System.out.println("Val: " +tr.get(j).getText());
									if(tr.get(j).getText().contains("Y")){
										resolve = true;
										break;
									}
								}
							}
							else if(msg.contains("Resolver is not available for this issue type."))
							{
								actRes = "Resolver is not available for this type of Issue and the Issue cannot be Resolved";
								System.out.println(actRes);
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 6 finished its execution*************************");
							}
						}
						if(resolve==true)
						{
							actRes = "Resolve Button is working successfully";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 6 finished its execution*************************");
						}
						else
						{
							actRes = "Resolve Button is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 6 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//Delete button
				if(d[i][0].equalsIgnoreCase("TC7"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("IssueResolver")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 6 is executing******************************");
						Thread.sleep(5000);
						
						Boolean del = false;
						String msg="", success="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						Select equip = new Select(driver.findElement(By.xpath(Object.getProperty("IssueSearchType"))));
						equip.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						driver.findElement(By.xpath(".//*[@id='tblResolverList']/tbody/tr/td[1]")).click();
						t.overlay(driver);
						Thread.sleep(1000);
						driver.findElement(By.xpath(Object.getProperty("DeleteIssue"))).click();
						msg = t.alertWait();
						if(msg.contains("Do you want to delete the selected issue?"))
						{
							success = t.alertWait();
							if(success.equalsIgnoreCase("Selected issue deleted successfully "))
							{
								equip = new Select(driver.findElement(By.xpath(Object.getProperty("IssueSearchType"))));
								equip.selectByValue(split[0]);
								driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
								t.overlay(driver);
								Thread.sleep(1000);
								driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
								driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
								t.overlay(driver);
								Thread.sleep(1000);
								List<WebElement> tr = driver.findElements(By.xpath(".//*[@id='tblResolverList']/tbody/tr/td"));
								for(int j=0;j<tr.size();j++)
								{
									System.out.println("Val: " +tr.get(j).getText());
									if(tr.get(j).getText().equalsIgnoreCase("No Data Found"))
									{
										del = true;
										break;
									}
								}
							}
						}
						if(del==true)
						{
							actRes = "Delete Button is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 7 finished its execution*************************");
						}
						else
						{
							actRes = "Delete Button is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
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
