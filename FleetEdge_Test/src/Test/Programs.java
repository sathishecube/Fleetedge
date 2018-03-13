package Test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import FleetEdge_Core.Core;
import FleetEdge_Util.*;

public class Programs extends Core
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]>Programscases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase)
	{
		String acop =null;
		String[][] d2 = s.Read(path, sheet);
		ExtentTest node = reports.startTest(sheet);
		try
		{
			driver = new FirefoxDriver(t.excel());
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
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 1 execution completed############################");
						}
						else
						{
							System.out.println("Page loaded Successfully");
							acop = "Fleet Status Page Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
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
						driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[1]/table/tbody/tr/td[2]/div/div/ul/li[2]/div/div/ul/li[4]/a")).click();
						Thread.sleep(10000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(10000);
						String d=driver.findElement(By.xpath(".//*[@id='lblMenuPath2']")).getText();
						System.out.println(d);
						if(d.equalsIgnoreCase("TEREX MATERIALS PROC • SETUP • PROGRAMS") && t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramsTab")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("CompanyAssociationTab")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EquipmentAssociationTab")), driver) 
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramList")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramTable")), driver))
													{
							System.out.println("Time Fence Passed.");
							acop = "Time Fence Page Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
							System.out.println( "###################Test case 2 execution completed############################");
						}
						else
						{
							System.out.println("Some of Element Missing in the Time Fence.");
							acop = "Time Fence Page not Loaded Successfully";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 2 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
									
									
				if(d2[i][0].equalsIgnoreCase("TC3"))
				{
					try
					{
						System.out.println( "###################Test case 3 is executing############################");	
					//	AddFilter.pageNavigater();
						driver.findElement(By.xpath(Object.getProperty("ProgramsTab"))).click();
						Thread.sleep(1000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(5000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramList")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramTable")), driver))
						{
						
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramTable")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramSearchHolder")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramNewButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramDeleteButton")), driver))	
							{
								System.out.println("Program List Pass");
							}
							else
							{
								System.out.println("Program List Table Fail");
								acop = "Some of Element Missing in the Program list.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 3 execution completed############################");
							}
							
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramNameTextbox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramTypeDropdown")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramYesNotification")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramNoNotification")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramRulesDropdown")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramStartDate")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramEndDate")), driver))
							{
								System.out.println("program pass.");
								acop = "Program Tab Clicking Working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 3 execution completed############################");

							}
							else
							{
								System.out.println("Some of Element Missing inthe  Program");
								acop = "Some of Element Missing in the Program.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 3 execution completed############################");
							}
						}
						else
						{
							System.out.println("programs tab not working as expected.");
							acop = "Program Tab is not Displaying properly.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 3 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}			
				
				
				if(d2[i][0].equalsIgnoreCase("TC4"))
				{
					try
					{
						System.out.println( "###################Test case 4 is executing############################");	
						String program=d2[3][4];
						String [] programArray=program.split(",");
						String sDate=t.date(d2[3][5]);
						String eDate=t.date(d2[3][6]);
				//		AddFilter.pageNavigater();
						Thread.sleep(5000);
						String textName=driver.findElement(By.xpath(Object.getProperty("ProgramNameTextbox"))).getAttribute("readonly");
					//	System.out.println( "text "+textName);
						String typeDropdown = driver.findElement(By.xpath(Object.getProperty("ProgramTypeDropdown"))).getAttribute("disabled");
					//	System.out.println("tyep"+typeDropdown);
						String yesNotification=driver.findElement(By.xpath(Object.getProperty("ProgramYesNotification"))).getAttribute("disabled");
					//	System.out.println("yes"+yesNotification);
						String noNotification=driver.findElement(By.xpath(Object.getProperty("ProgramNoNotification"))).getAttribute("disabled");
					//	System.out.println("No"+noNotification);
						String rulesDropdown=driver.findElement(By.xpath(Object.getProperty("ProgramRulesDropdown"))).getAttribute("disabled");
					//	System.out.println("rules"+rulesDropdown);
						String startDate=driver.findElement(By.xpath(Object.getProperty("ProgramStartDate"))).getAttribute("disabled");
					//	System.out.println("start"+startDate);
						String endDate=driver.findElement(By.xpath(Object.getProperty("ProgramEndDate"))).getAttribute("disabled");
					//	System.out.println("end "+endDate);
						if(textName.equalsIgnoreCase("true") && typeDropdown.equalsIgnoreCase("true") && yesNotification.equalsIgnoreCase("true") && noNotification.equalsIgnoreCase("true")
								&& rulesDropdown.equalsIgnoreCase("true") && startDate.equalsIgnoreCase("true") && endDate.equalsIgnoreCase("true"))
						{
							System.out.println("All of the Element is disabled before clicking the new button");
							
						}
						else
						{
							System.out.println("All of the program Element still present before clicking the new Button.");
							acop = "Program Tab is not Displaying properly.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 4 execution completed############################");
						}
						driver.findElement(By.xpath(Object.getProperty("ProgramNewButton"))).click();
						Thread.sleep(5000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramOkButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramCancelButton")), driver))
						{
							System.out.println(" new button pass");
							driver.findElement(By.xpath(Object.getProperty("ProgramNameTextbox"))).sendKeys(programArray[0]);
							WebElement type=driver.findElement(By.xpath(Object.getProperty("ProgramTypeDropdown")));
							List<WebElement> typeList=type.findElements(By.tagName("option"));
							for(WebElement text : typeList)
							{
								if(text.getText().equalsIgnoreCase(programArray[1]))
								{
									text.click();
								}
							}
							if(programArray[2].equalsIgnoreCase("Yes"))
							{
								driver.findElement(By.xpath(Object.getProperty("ProgramYesNotification"))).click();
							}
							else if(programArray[2].equalsIgnoreCase("No"))
							{
								driver.findElement(By.xpath(Object.getProperty("ProgramNoNotification"))).click();
							}
							
							WebElement rules=driver.findElement(By.xpath(Object.getProperty("ProgramRulesDropdown")));
							List<WebElement>rulesList=rules.findElements(By.tagName("option"));
							for(WebElement text : rulesList)
							{
								if(programArray[3].equalsIgnoreCase(text.getText()))
								{
									text.click();
								}
							}
							Thread.sleep(3000);
							AddFilter.readonlyRemover("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[2]/div/fieldset/div/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/div/div/div", "input");
							driver.findElement(By.xpath(Object.getProperty("ProgramStartDate"))).sendKeys(sDate);
							Thread.sleep(3000);
							AddFilter.readonlyRemover("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[2]/div/fieldset/div/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/div/div/div", "input");
							driver.findElement(By.xpath(Object.getProperty("ProgramEndDate"))).sendKeys(eDate);
							Thread.sleep(3000);
							driver.findElement(By.xpath("//*[@id='MainContainer_lblEDate']")).click();
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("ProgramOkButton"))).click();
							Thread.sleep(3000);
							if(t.isAlertPresent(driver))
							{
								driver.switchTo().alert().accept();
							}
							else
							{
								System.out.println("any alert is not present.");
								acop = "Any alert is not present while clicking the Ok Button.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 4 execution completed############################");
							}
							Thread.sleep(2000);
							WebElement row=driver.findElement(By.xpath("//*[@id='tblProgramList']"));
							List<WebElement>rowList=row.findElements(By.tagName("tr"));
							System.out.println("List : "+rowList.size());
							int cnt=rowList.size()-1;
							System.out.println("size "+cnt);
							WebElement column=driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[1]/div/fieldset/div/table/tbody/tr[1]/td/div[2]/table/tbody/tr["+cnt+"]"));
							List<WebElement> columnList=column.findElements(By.tagName("td"));
							for(WebElement text : columnList)
							{
								System.out.println("text : "+text.getText());
								if(text.getText().equalsIgnoreCase(programArray[0]))
								{
									System.out.println("program is created successfully.");
									acop = "Program is Created Successfully.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 4 execution completed############################");
									break;
								}
								else
								{
									System.out.println("Program is not created successfully");
									acop = "Unalbe to create the program.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 4 execution completed############################");
									break;
								}
							}
							
							//Cancel Button
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("ProgramNewButton"))).click();
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("ProgramCancelButton"))).click();
							Thread.sleep(2000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("Inside");
								Thread.sleep(1000);	
							}
							Thread.sleep(3000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramCancelButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramOkButton")), driver))
							{
								System.out.println("Cancel Fail");
								acop = "Cancel Button is not working as Expected.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 4 execution completed############################");
							}
							else
							{
								System.out.println("cancel Pass");
								acop = "Cancel Button is Working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 4 execution completed############################");
							}
							
						}
						else
						{
							System.out.println("New button is not working as expected.");
							acop = "New Button is not working as Expected.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 4 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				//program Edit.
				if(d2[i][0].equalsIgnoreCase("TC5"))
				{
					try
					{
						System.out.println( "###################Test case 5 is executing############################");	
						String program=d2[4][4];
						String sDate=t.date(d2[4][5]);
						String eDate=t.date(d2[4][6]);
						String [] programArray=program.split(",");
					//	AddFilter.pageNavigater();
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("ProgramSearchTextbox"))).sendKeys(programArray[0]);
						driver.findElement(By.xpath(Object.getProperty("programSearchButton"))).click();
						Thread.sleep(2000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("Inside");
							Thread.sleep(1000);	
						}
						Thread.sleep(3000);
						driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[1]/div/fieldset/div/table/tbody/tr[1]/td/div[2]/table/tbody/tr")).click();
						Thread.sleep(5000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("ProgramEditButton")), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("ProgramEditButton"))).click();
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("ProgramNameTextbox"))).clear();
							driver.findElement(By.xpath(Object.getProperty("ProgramNameTextbox"))).sendKeys(programArray[1]);
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("ProgramYesNotification"))).click();
							Thread.sleep(3000);
							AddFilter.readonlyRemover("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[2]/div/fieldset/div/table/tbody/tr[2]/td/table/tbody/tr[5]/td[2]/div/div/div", "input");
							driver.findElement(By.xpath(Object.getProperty("ProgramStartDate"))).clear();
							driver.findElement(By.xpath(Object.getProperty("ProgramStartDate"))).sendKeys(sDate);
							Thread.sleep(3000);
							AddFilter.readonlyRemover("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[2]/div/fieldset/div/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]/div/div/div", "input");
							driver.findElement(By.xpath(Object.getProperty("ProgramEndDate"))).clear();
							driver.findElement(By.xpath(Object.getProperty("ProgramEndDate"))).sendKeys(eDate);
							Thread.sleep(3000);
							driver.findElement(By.xpath("//*[@id='MainContainer_lblEDate']")).click();
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("ProgramOkButton"))).click();
							Thread.sleep(3000);
							if(t.isAlertPresent(driver))
							{
								driver.switchTo().alert().accept();
							}
							else
							{
								System.out.println("any alert is not present.");
								acop = "Any Alert is not present saving after the program.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
							driver.findElement(By.xpath(Object.getProperty("ProgramSearchTextbox"))).clear();
							driver.findElement(By.xpath(Object.getProperty("ProgramSearchTextbox"))).sendKeys(programArray[1]);
							driver.findElement(By.xpath(Object.getProperty("programSearchButton"))).click();
							Thread.sleep(2000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("Inside");
								Thread.sleep(1000);	
							}
							Thread.sleep(3000);
							WebElement row=driver.findElement(By.xpath("//*[@id='tblProgramList']"));
							List<WebElement>rowList=row.findElements(By.tagName("tr"));
							System.out.println("List : "+rowList.size());
							int cnt=rowList.size()-1;
							System.out.println("size "+cnt);
							String programName=driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[1]/div/fieldset/div/table/tbody/tr[1]/td/div[2]/table/tbody/tr["+cnt+"]/td[1]")).getText();
							System.out.println("program Name : "+programName);
							String startDate=driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[1]/div/fieldset/div/table/tbody/tr[1]/td/div[2]/table/tbody/tr["+cnt+"]/td[3]")).getText();
							System.out.println("startDate "+startDate);
							String endDate=driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[1]/div/fieldset/div/table/tbody/tr[1]/td/div[2]/table/tbody/tr["+cnt+"]/td[4]")).getText();
							System.out.println("EndDate : "+endDate);
							if(programName.equalsIgnoreCase(programArray[1]) || startDate.equalsIgnoreCase(sDate) || endDate.equalsIgnoreCase(eDate))
							{
								System.out.println("Successfully modified the program.");
								acop = "Successfully modified the program.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
							else
							{
								System.out.println("nable to modify the  program.");
								acop = "Unable to modify the  program.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
							driver.findElement(By.xpath(Object.getProperty("ProgramClearButton"))).click();
							Thread.sleep(2000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("Inside");
								Thread.sleep(1000);	
							}
							Thread.sleep(3000);
						}
						else
						{
							System.out.println("Edit button is missing");
							acop = "Edit Button is misisng.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 5 execution completed############################");

						}
						
					}
					catch(Exception e)
					{
						e.printStackTrace();						
					}
				}
				
				
				
				
				//Program Search
				if(d2[i][0].equalsIgnoreCase("TC6"))
				{
					try
					{
						System.out.println( "###################Test case 6 is executing############################");	
						String program=d2[5][4];
						String [] programArray=program.split(",");
						String input=d2[5][3];
						String [] inputArray=input.split(",");
				//		AddFilter.pageNavigater();
						for(int j=0;j<programArray.length;j++)
						{
							WebElement row=driver.findElement(By.xpath(Object.getProperty("ProgramSearchType")));
							List<WebElement>rowList=row.findElements(By.tagName("option"));
							for(WebElement text : rowList)
							{
								if(text.getText().equalsIgnoreCase(programArray[j]))
								{ 
									text.click();
									driver.findElement(By.xpath(Object.getProperty("ProgramSearchTextbox"))).clear();
									Thread.sleep(2000);
									driver.findElement(By.xpath(Object.getProperty("ProgramSearchTextbox"))).sendKeys(inputArray[j]);
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("programSearchButton"))).click();
									Thread.sleep(2000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("Inside");
										Thread.sleep(1000);	
									}
									Thread.sleep(3000);		
									j+=1;
									String name = driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[1]/div/fieldset/div/table/tbody/tr[1]/td/div[2]/table/tbody/tr/td["+j+"]")).getText();
									System.out.println("Name : "+name);
									j-=1;
									if(name.equalsIgnoreCase(inputArray[j]))
									{
										System.out.println("Search box working as Expected.");
										acop = "Search box working as Expected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 6 execution completed############################");
									}
									else
									{
										System.out.println("Program searching is not working as Expected.");
										acop = "Program searching is not working as Expected.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 6 execution completed############################");
									}
								}
							}
							
							//Clear Search
							driver.findElement(By.xpath(Object.getProperty("ProgramClearButton"))).click();
							Thread.sleep(5000);
							String box = driver.findElement(By.xpath(Object.getProperty("ProgramSearchTextbox"))).getText();
							System.out.println("box : "+box);
							if(box.equalsIgnoreCase(""))
							{
								System.out.println("Clear button working as Expected.");
								acop = "Clear button working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 6 execution completed############################");
							}
							else
							{
								System.out.println("Clear button is not working as Expected.");
								acop = "Clear button is not working as Expected.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 6 execution completed############################");
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
								
				//Company Association
				
				if(d2[i][0].equalsIgnoreCase("TC7"))
				{
					try
					{
						System.out.println( "###################Test case 7 is executing############################");	
						String program=d2[6][4];
						String [] programArray=program.split(",");
					//	AddFilter.pageNavigater();
						driver.findElement(By.xpath(Object.getProperty("CompanyAssociationTab"))).click();
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("Inside");
							Thread.sleep(1000);	
						}
						Thread.sleep(3000);	
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("CompanyList")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("CompanyInformation")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("CompanySearchHolder")), driver))
						{
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("CompanyProgramSearchTextbox"))).sendKeys(programArray[0]);
							driver.findElement(By.xpath(Object.getProperty("CompanyProgramSearchButton"))).click();
							Thread.sleep(2000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("Inside");
								Thread.sleep(1000);	
							}
							Thread.sleep(3000);
							driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/div/fieldset/div/table/tbody/tr/td/div[2]/table/tbody/tr")).click();
							Thread.sleep(5000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("CompanyTableName")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("CompanyTableGroupType")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("CompanyEditButton")), driver))
							{
								driver.findElement(By.xpath(Object.getProperty("CompanyEditButton"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("Inside");
									Thread.sleep(1000);	
								}
								Thread.sleep(3000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("CompanyAssignTable")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("CompanyUnassignTable")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignSearchHolder")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("CompanyOKButton")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("CompanyCancelButton")), driver))
								{
									System.out.println("Edit button working as expected.");
									acop = "Edit button working as expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 7 execution completed############################");
									
									if(t.isElementPresentcheck(By.xpath(Object.getProperty("AssignedSelectCompany")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AssignedGroupType")), driver))
									{
										System.out.println("Company Assigned pass");
									}
									else
									{
										System.out.println("Some of element missing in the Assigned table.");
										acop = "Some of element missing in the Assigned table.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 7 execution completed############################");
									}
									
									if(t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignedSelectCompany")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignedGroupType")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignedSearchType")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignedSearchbox")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignedSearchButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignedClearButton")), driver))
									{
										System.out.println("Unassigned pass");
									}
									else
									{
										System.out.println("Some of element misisng in the Unassign Table.");
										acop = "Some of element misisng in the Unassign Table.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 7 execution completed############################");
									}
								}
								else
								{
									System.out.println("Edit button is not working as Expected.");
									acop = "Edit bitton is not working as Expected.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 7 execution completed############################");
								}
							}
							else
							{
								System.out.println("Edit button is not displaying.");
								acop = "Edit button is not displaying.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 7 execution completed############################");
							}
						}
						else
						{
							System.out.println("Company tab is not displaying properly.");
							acop = "Company tab is not displaying properly.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 7 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				//company search
				if(d2[i][0].equalsIgnoreCase("TC8"))
				{
					try
					{
						System.out.println( "###################Test case 8 is executing############################");	
						String program=d2[7][4];
						String [] programArray=program.split(",");
						String type=d2[7][3];
						String [] typeArray=type.split(",");
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignedSearchButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignedClearButton")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignedSearchbox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignedSearchType")), driver))
						{
							for(int j=0;j<programArray.length;j++)
							{
								WebElement type1=driver.findElement(By.xpath(Object.getProperty("UnassignedSearchType")));
								List<WebElement> typeList = type1.findElements(By.tagName("option"));
								for(WebElement text : typeList)
								{
									System.out.println(j);
									if(text.getText().equalsIgnoreCase(programArray[j]))
									{	
										j+=2;
										System.out.println("J : "+j);
										text.click();
										Thread.sleep(3000);
										driver.findElement(By.xpath(Object.getProperty("UnassignedSearchbox"))).sendKeys(typeArray[j-2]);
										Thread.sleep(3000);
										driver.findElement(By.xpath(Object.getProperty("UnassignedSearchButton"))).click();
										Thread.sleep(2000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("Inside");
											Thread.sleep(1000);	
										}
										Thread.sleep(3000);
										String name = driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/div/fieldset/div[2]/table/tbody/tr[1]/td[3]/div/div[2]/table/tbody/tr[1]/td["+j+"]")).getText();
										System.out.println("Name : "+name);
										if(name.equalsIgnoreCase(typeArray[j-2]))
										{
											System.out.println(programArray[j-2]+" Searching working as Exected.");
											acop = programArray[j-2]+" Searching working as Exected.";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
											rc++;
											s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
											System.out.println( "###################Test case 8 execution completed############################");
										}
										else
										{
											System.out.println(programArray[j-2]+" Searching not working as Exected.");
											acop = programArray[j-2]+" Searching not working as Exected.";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 8 execution completed############################");
										}
										driver.findElement(By.xpath(Object.getProperty("UnassignedClearButton"))).click();
										Thread.sleep(2000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("Inside");
											Thread.sleep(1000);	
										}
										Thread.sleep(3000);
										String textName = driver.findElement(By.xpath(Object.getProperty("UnassignedSearchbox"))).getText();
										System.out.println("Text Name : "+textName);
										if(textName.equalsIgnoreCase(""))
										{
											System.out.println("Clear Button working as Expected.");
											acop = "Clear Button working as Expected.";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
											rc++;
											s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
											System.out.println( "###################Test case 8 execution completed############################");
										}
										else
										{
											System.out.println("Clear button is not working as Expected.");
											acop = "Clear button is not working as Expected.";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 8 execution completed############################");
										}
									    j-=2;
									}
								}
							}
							
						}
						else
						{
							System.out.println("Some of element missing in the search holder.");
							acop = "Some of element missing in the search holder.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 8 execution completed############################");
						}
							
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}	
						
				
				//company assigning
				if(d2[i][0].equalsIgnoreCase("TC9"))
				{
					try
					{
						System.out.println( "###################Test case 9 is executing############################");	
						String program=d2[8][4];
						String [] programArray=program.split(",");
						for(int j=0;j<programArray.length;j++)
						{
							WebElement type1=driver.findElement(By.xpath(Object.getProperty("UnassignedSearchType")));
							List<WebElement> typeList = type1.findElements(By.tagName("option"));
							for(WebElement text : typeList)
							{
								if(text.getText().equalsIgnoreCase("Company"))
								{
									text.click();
									driver.findElement(By.xpath(Object.getProperty("UnassignedSearchbox"))).clear();
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("UnassignedSearchbox"))).sendKeys(programArray[j]);
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("UnassignedSearchButton"))).click();
									Thread.sleep(2000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("Inside");
										Thread.sleep(1000);	
									}
									Thread.sleep(3000);
								/*	WebElement name=driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/div/fieldset/div[2]/table/tbody/tr[1]/td[3]/div/div[2]/table/tbody/tr"));
									List<WebElement> nameList=name.findElements(By.xpath("td[2]"));
									int k=0;
									for(WebElement t : nameList)
									{
										k++;
										System.out.println(t.getText());
										if(t.getText().equalsIgnoreCase(programArray[j]))
										{
										
										}
									}*/
									driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/div/fieldset/div[2]/table/tbody/tr[1]/td[3]/div/div[2]/table/tbody/tr[1]/td[1]/input")).click();
									Thread.sleep(2000);
									driver.findElement(By.xpath(Object.getProperty("CompanyAssignArrow"))).click();
									Thread.sleep(5000);
									
								}
							}
						}
						
						driver.findElement(By.xpath(Object.getProperty("CompanyOKButton"))).click();
						Thread.sleep(2000);
						if(t.isAlertPresent(driver))
						{
							driver.switchTo().alert().accept();
						}
						else
						{
							System.out.println("Succes alert is  not popups.");
							acop = "Success Alert is not popups";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 9 execution completed############################");
						}
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("Inside");
							Thread.sleep(1000);	
						}
						Thread.sleep(3000);
					/*	for(int j=0;j<programArray.length;j++)
						{
							WebElement comp=driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/div/fieldset/div[1]/div[1]/table/tbody/tr"));
							List<WebElement> compList=comp.findElements(By.tagName("td"));
							for(WebElement text : compList)
							{
								System.out.println("Size  : "+compList.size());
								System.out.println("program Size  :  "+programArray.length);
								if(programArray[j].equalsIgnoreCase(text.getText()))
								{
									flag=1;
								}
								else
								{
									flag=0;
									break;
								}
							}
						}*/
						WebElement comp=driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/div/fieldset/div[1]/div[1]/table/tbody"));
						List<WebElement> compList=comp.findElements(By.tagName("tr"));
						System.out.println("Size  : "+compList.size());
						System.out.println("program Size  :  "+programArray.length);
						if(compList.size()==programArray.length)
						{
							System.out.println("Company Assign pass");
							acop = "Company Assign working as Expected.";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
							System.out.println( "###################Test case 9 execution completed############################");
						}
						else
						{
							System.out.println("Company Assign is not working as Expected.");
							acop = "Company Assign is not working as Expected.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 9 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				//Program Search
				if(d2[i][0].equalsIgnoreCase("TC10"))
				{
					try
					{
						System.out.println( "###################Test case 10 is executing############################");	
						String program=d2[9][4];
						String [] programArray=program.split(",");
						String input=d2[9][3];
						String [] inputArray=input.split(",");
					//	AddFilter.pageNavigater();
						for(int j=0;j<programArray.length;j++)
						{
							WebElement row=driver.findElement(By.xpath(Object.getProperty("CompanyProgramSearchType")));
							List<WebElement>rowList=row.findElements(By.tagName("option"));
							for(WebElement text : rowList)
							{
								if(text.getText().equalsIgnoreCase(programArray[j]))
								{
									text.click();
									driver.findElement(By.xpath(Object.getProperty("CompanyProgramSearchTextbox"))).clear();
									Thread.sleep(2000);
									driver.findElement(By.xpath(Object.getProperty("CompanyProgramSearchTextbox"))).sendKeys(inputArray[j]);
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("CompanyProgramSearchButton"))).click();
									Thread.sleep(2000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("Inside");
										Thread.sleep(1000);	
									}
									Thread.sleep(3000);	
									j+=1;
									String name = driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/div/fieldset/div/table/tbody/tr/td/div[2]/table/tbody/tr/td["+j+"]")).getText();
									System.out.println("Name : "+name);
									j-=1;
									if(name.equalsIgnoreCase(inputArray[j]))
									{
										System.out.println("Search box working as Expected.");
										acop = "Search box working as Expected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 10 execution completed############################");
									}
									else
									{
										System.out.println("Program searching is not working as Expected.");
										acop = "Program searching is not working as Expected.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 10 execution completed############################");
									}
								}
							}
							
							//Clear Search
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("CompanyProgramClearButton"))).click();
							Thread.sleep(5000);
							String box = driver.findElement(By.xpath(Object.getProperty("CompanyProgramSearchTextbox"))).getText();
							System.out.println("box : "+box);
							if(box.equalsIgnoreCase(""))
							{
								System.out.println("Clear button working as Expected.");
								acop = "Clear button working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 10 execution completed############################");
							}
							else
							{
								System.out.println("Clear button is not working as Expected.");
								acop = "Clear button is not working as Expected.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 10 execution completed############################");
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				//Equipment Association
				if(d2[i][0].equalsIgnoreCase("TC11"))
				{
					try
					{
						System.out.println( "###################Test case 11 is executing############################");	
						String program=d2[10][4];
						String [] programArray=program.split(",");
					//	AddFilter.pageNavigater();
						driver.findElement(By.xpath(Object.getProperty("EquipmentAssociationTab"))).click();
						Thread.sleep(2000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("Inside");
							Thread.sleep(1000);	
						}
						Thread.sleep(3000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("EquipmentProgramList")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EquipmentInformation")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("EquipProgramSearchType")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EquipSearchbox")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("EquipSearchButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EquipClearButton")), driver))
						{
							System.out.println("Pass");
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("EquipSearchbox"))).sendKeys(programArray[0]);
							driver.findElement(By.xpath(Object.getProperty("EquipSearchButton"))).click();
							Thread.sleep(2000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("Inside");
								Thread.sleep(1000);	
							}
							Thread.sleep(3000);
							driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[3]/table/tbody/tr/td[1]/div/fieldset/div/table/tbody/tr/td/div[2]/table/tbody/tr/td[1]")).click();
							Thread.sleep(5000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("EquipEditButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EquipmentInformation")), driver))
							{
								driver.findElement(By.xpath(Object.getProperty("EquipEditButton"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("Inside");
									Thread.sleep(1000);	
								}
								Thread.sleep(3000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("EquipmentAssignTable")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EquipmentUnassignTable")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("EquipAssignArrow")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EquipUnassignArrow")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("EquipOkButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EquipCancelButton")), driver))
								{
									System.out.println("Edit Button is workign as Expected.");
									acop = "Edit Button is workign as Expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
								
									System.out.println( "###################Test case 11 execution completed############################");
									if( t.isElementPresentcheck(By.xpath(Object.getProperty("AssignEquipID")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AssignEquipSerilNo")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("AssignCompany")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AssignGroupType")), driver))
									{
										System.out.println("Assign Pass");
									}
									else
									{
										System.out.println("Some of element missing in the Assign Table.");
										acop = "Some of element missing in the Assign Table.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 11 execution completed############################");
									}
									
									if(t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignSearchType")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignSearchbox")), driver) 
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignSearchButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignClearButton")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignEquipID")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignSerialNo")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignCompany")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignGroupType")), driver))
									{
										System.out.println("Unassign Pass");
									}
									else
									{
										System.out.println("Some of element missing in the Unassign Table.");
										acop = "Some of element missing in the Unassign Table.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 11 execution completed############################");
									}
								}
							}
							else
							{
								System.out.println("Edit button is not displaying.");
								acop = "Edit Button is not working as Expected.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 11 execution completed############################");
							}
						}
						else
						{
							System.out.println("Equipment Association Tab is not Displaying properly.");
							acop = "Equipment Association Tab is not Displaying properly.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 11 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				if(d2[i][0].equalsIgnoreCase("TC12"))
				{
					try
					{
						System.out.println( "###################Test case 12 is executing############################");	
						String program=d2[11][4];	
						String [] programArray=program.split(",");
						String input=d2[11][3];
						String  [] inputArray=input.split(",");
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignSearchType")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignSearchbox")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignSearchButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UnassignClearButton")), driver))
						{
							for(int j=0;j<programArray.length;j++)
							{
								WebElement type =driver.findElement(By.xpath(Object.getProperty("UnassignSearchType")));
								List<WebElement>typeList=type.findElements(By.tagName("option"));
								for(WebElement text : typeList)
								{
									if(text.getText().equalsIgnoreCase(programArray[j]))
									{
										text.click();
										j+=2;
										driver.findElement(By.xpath(Object.getProperty("UnassignSearchbox"))).clear();
										Thread.sleep(2000);
										driver.findElement(By.xpath(Object.getProperty("UnassignSearchbox"))).sendKeys(inputArray[j-2]);
										Thread.sleep(5000);
										driver.findElement(By.xpath(Object.getProperty("UnassignSearchButton"))).click();
										Thread.sleep(1000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("Inside");
											Thread.sleep(1000);	
										}
										Thread.sleep(3000);
										String val=driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[3]/table/tbody/tr/td[2]/div/fieldset/div[2]/table/tbody/tr[1]/td[3]/div/div[2]/table/tbody/tr/td["+j+"]")).getText();
										System.out.println("Val : "+val);
										j-=2;
										if(val.equalsIgnoreCase(inputArray[j]))
										{
											acop = "Search Type of "+text.getText()+" is working as Expected.";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
											rc++;
											s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
											System.out.println( "###################Test case 12 execution completed############################");
										}
										else
										{
											acop = "Search Type of "+text.getText()+" is not working as Expected.";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 12 execution completed############################");
										}
									}
								}
							}
							
							//Equipment Clear.
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("UnassignClearButton"))).click();
							Thread.sleep(1000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("Inside");
								Thread.sleep(1000);	
							}
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("UnassignSearchbox"))).sendKeys(inputArray[0]);
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("UnassignClearButton"))).click();
							Thread.sleep(3000);
							String val=driver.findElement(By.xpath(Object.getProperty("UnassignSearchbox"))).getText();
							if(val.equalsIgnoreCase(""))
							{
								System.out.println("Clear Button is working as Expected.");
								acop = "Clear Button is working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 12 execution completed############################");
							}
							else
							{
								System.out.println("Clear Button is not working as Expected.");
								acop = "Clear Button is not working as Expected.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 12 execution completed############################");
							}
						}
						else
						{
							System.out.println("Some of element missing in the search holder.");
							acop = "Some of element missing in the search holder.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 12 execution completed############################");
						}
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				
				//Equipment Assign
				if(d2[i][0].equalsIgnoreCase("TC13"))
				{
					try
					{
						System.out.println( "###################Test case 13 is executing############################");	
						String program=d2[12][4];	
						String [] programArray=program.split(",");
						WebElement type =driver.findElement(By.xpath(Object.getProperty("UnassignSearchType")));
						List<WebElement>typeList=type.findElements(By.tagName("option"));
						for(WebElement text : typeList)
						{
							if(text.getText().equalsIgnoreCase("Equipment Id"))
							{
								text.click();
							}
						}
						Thread.sleep(3000);
						for(int j=0;j<programArray.length;j++)
						{
							driver.findElement(By.xpath(Object.getProperty("UnassignSearchbox"))).clear();
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("UnassignSearchbox"))).sendKeys(programArray[j]);
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("UnassignSearchButton"))).click();
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("Inside");
								Thread.sleep(1000);	
							}
							Thread.sleep(3000);
							String val=driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[3]/table/tbody/tr/td[2]/div/fieldset/div[2]/table/tbody/tr[1]/td[3]/div/div[2]/table/tbody/tr[1]/td[2]")).getText();
							if(programArray[j].equalsIgnoreCase(val))
							{
								driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[3]/table/tbody/tr/td[2]/div/fieldset/div[2]/table/tbody/tr[1]/td[3]/div/div[2]/table/tbody/tr[1]/td[1]/input")).click();
								Thread.sleep(1000);
								driver.findElement(By.xpath(Object.getProperty("EquipAssignArrow"))).click();
							}
						}
						driver.findElement(By.xpath(Object.getProperty("EquipOkButton"))).click();
						Thread.sleep(2000);
						if(t.isAlertPresent(driver))
						{
							driver.switchTo().alert().accept();
						}
						else
						{
							System.out.println("Success Alert is Missing.");
							acop = "Success Alert is not popups.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 13 execution completed############################");
						}
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("Inside");
							Thread.sleep(1000);	
						}
						Thread.sleep(2000);
						WebElement total=driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[3]/table/tbody/tr/td[2]/div/fieldset/div[1]/div[1]/table/tbody"));
						List<WebElement>totalList=total.findElements(By.tagName("tr"));
						System.out.println("Size of taotal : "+totalList.size());
						System.out.println("Program Array Size : "+programArray.length);
						if(programArray.length==totalList.size())
						{
							System.out.println("Equipment Assigned Successfully.");
							acop = "Equipment Assigned Successfully.";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
							System.out.println( "###################Test case 13 execution completed############################");
						}
						else
						{
							System.out.println("Unable to assign the Equipment.");
							acop = "Unable to assign the Equipment.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 13 execution completed############################");	
						}
						
						
						//Cancel Button.
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("EquipEditButton"))).click();
						Thread.sleep(2000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("Inside");
							Thread.sleep(1000);	
						}
						Thread.sleep(2000);
						driver.findElement(By.xpath(Object.getProperty("EquipCancelButton"))).click();
						Thread.sleep(2000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("Inside");
							Thread.sleep(1000);	
						}
						Thread.sleep(2000);
						if(!t.isElementPresentcheck(By.xpath(Object.getProperty("EquipmentAssignTable")), driver)  && ! t.isElementPresentcheck(By.xpath(Object.getProperty("EquipmentUnassignTable")), driver)
								&& ! t.isElementPresentcheck(By.xpath(Object.getProperty("EquipAssignArrow")), driver) && ! t.isElementPresentcheck(By.xpath(Object.getProperty("EquipUnassignArrow")), driver)
								&& ! t.isElementPresentcheck(By.xpath(Object.getProperty("EquipOkButton")), driver) && ! t.isElementPresentcheck(By.xpath(Object.getProperty("EquipCancelButton")), driver))
						{
							System.out.println("Cancel Button is working as Expected.");
							acop = "Cancel Button is working as Expected.";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
							System.out.println( "###################Test case 13 execution completed############################");
						}
						else
						{
							System.out.println("Cancel Button is not working as Expected.");
							acop = "Cancel Button is not working as Expected.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 13 execution completed############################");							}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				//Program Search
				if(d2[i][0].equalsIgnoreCase("TC14"))
				{
					try
					{
						System.out.println( "###################	Test case 14 is executing############################");	
						String program=d2[13][4];
						String [] programArray=program.split(",");
						String input=d2[13][3];
						String [] inputArray=input.split(",");
			//			AddFilter.pageNavigater();
						for(int j=0;j<programArray.length;j++)
						{
							WebElement row=driver.findElement(By.xpath(Object.getProperty("EquipProgramSearchType")));
							List<WebElement>rowList=row.findElements(By.tagName("option"));
							for(WebElement text : rowList)
							{
								if(text.getText().equalsIgnoreCase(programArray[j]))
								{
									text.click();
									driver.findElement(By.xpath(Object.getProperty("EquipSearchbox"))).clear();
									Thread.sleep(2000);
									driver.findElement(By.xpath(Object.getProperty("EquipSearchbox"))).sendKeys(inputArray[j]);
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("EquipSearchButton"))).click();
									Thread.sleep(2000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("Inside");
										Thread.sleep(1000);	
									}
									Thread.sleep(3000);
									j+=1;
									String name = driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[3]/table/tbody/tr/td[1]/div/fieldset/div/table/tbody/tr/td/div[2]/table/tbody/tr/td["+j+"]")).getText();
									System.out.println("Name : "+name);
									j-=1;
									if(name.equalsIgnoreCase(inputArray[j]))
									{
										System.out.println("Search box working as Expected.");
										acop = "Search box working as Expected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 14 execution completed############################");
									}
									else
									{
										System.out.println("Program searching is not working as Expected.");
										acop = "Program searching is not working as Expected.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 14 execution completed############################");
									}
								}
							}
							
							//Clear Search
							driver.findElement(By.xpath(Object.getProperty("EquipClearButton"))).click();
							Thread.sleep(5000);
							String box = driver.findElement(By.xpath(Object.getProperty("ProgramSearchTextbox"))).getText();
							System.out.println("box : "+box);
							if(box.equalsIgnoreCase(""))
							{
								System.out.println("Clear button working as Expected.");
								acop = "Clear button working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 14 execution completed############################");
							}
							else
							{
								System.out.println("Clear button is not working as Expected.");
								acop = "Clear button is not working as Expected.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 14 execution completed############################");
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				
				//Program Delete
				if(d2[i][0].equalsIgnoreCase("TC15"))
				{
					try
					{
						System.out.println( "###################Test case 15 is executing############################");	
						String program=d2[14][4];
						int flag=0;
						String [] programArray=program.split(",");
					//	AddFilter.pageNavigater();
						driver.findElement(By.xpath(Object.getProperty("ProgramsTab"))).click();
						Thread.sleep(2000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("Inside");
							Thread.sleep(1000);	
						}
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("ProgramSearchTextbox"))).sendKeys(programArray[0]);
						driver.findElement(By.xpath(Object.getProperty("programSearchButton"))).click();
						Thread.sleep(2000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("Inside");
							Thread.sleep(1000);	
						}
						Thread.sleep(3000);
						driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[1]/div/fieldset/div/table/tbody/tr[1]/td/div[2]/table/tbody/tr")).click();
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("ProgramDeleteButton"))).click();
						Thread.sleep(1000);
						if(t.isAlertPresent(driver))
						{
							driver.switchTo().alert().accept();
						}
						else
						{
							System.out.println("Alert is not present");
							acop = "Delete Alert is not Present.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 15 execution completed############################");

						}
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("ProgramClearButton"))).click();
						Thread.sleep(2000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("Inside");
							Thread.sleep(1000);	
						}
						Thread.sleep(3000);						
						WebElement row=driver.findElement(By.xpath("//*[@id='tblProgramList']"));
						List<WebElement>rowList=row.findElements(By.tagName("tr"));
						for(int j=1;j<rowList.size()-1;j++)	
						{
						//	System.out.println("no : "+j);
							String programName=driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/div[1]/table/tbody/tr/td[1]/div/fieldset/div/table/tbody/tr[1]/td/div[2]/table/tbody/tr["+j+"]/td[1]")).getText();
						//	System.out.println(programName);
							if(!programName.equalsIgnoreCase(programArray[0]))
							{
								System.out.println("pass");
								flag=1;
							}
							else
							{
								System.out.println("Unable to Delete the program.");
								flag=0;
								acop = "Unable to Delete the program.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 15 execution completed############################");
								break;
							}
						}
						if(flag==1)
						{
							System.out.println("Program successfully deleted.");
							acop = "Program successfully deleted.";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "Programs", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(filepath, "Programs", d2[i][0], rc, acop, "Pass" );
							System.out.println( "###################Test case 15 execution completed############################");
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