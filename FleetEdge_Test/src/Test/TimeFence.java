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

public class TimeFence extends Core
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]>TimeFencecases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase)
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
							data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 1 execution completed############################");
						}
						else
						{
							System.out.println("Page loaded Successfully");
							acop = "Fleet Status Page Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
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
						driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[1]/table/tbody/tr/td[2]/div/div/ul/li[2]/div/div/ul/li[2]/a")).click();
						Thread.sleep(10000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(10000);
						String d=driver.findElement(By.xpath(".//*[@id='lblMenuPath2']")).getText();
						System.out.println(d);
						if(d.equalsIgnoreCase("TEREX MATERIALS PROC • TIME-FENCE") && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceList")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceSetting")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFleetSetting")), driver) 
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeNewButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeEditButton")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeDeleteButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeHistoryButton")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeAddEmailButton")), driver))
						{
							System.out.println("Time Fence Passed.");
							acop = "Time Fence Page Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
							System.out.println( "###################Test case 2 execution completed############################");
						}
						else
						{
							System.out.println("Some of Element Missing in the Time Fence.");
							acop = "Time Fence Page not Loaded Successfully";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 2 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				//Time New Button .
				if(d2[i][0].equalsIgnoreCase("TC3"))
				{
					try
					{
						System.out.println( "###################Test case 3 is executing############################");
						int flag=0,flag2=0;
						String sDate=t.date(d2[2][5]);
						String eDate=t.date(d2[2][6]);
						String fenceName = d2[2][4];
						String [] fenceNameArray =fenceName.split("#");
						String day=d2[2][3];
						String assetSearch=d2[2][2];
						String [] assetSearchArray=assetSearch.split(",");
						String [] dayArray = day.split(",");
						Thread.sleep(5000);
				//		AddFilter.pageNavigater();
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("TimeNewButton"))).click();
						Thread.sleep(3000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("TimeNewDialougeBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceNameTextBox")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeStartDate")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeEndDate")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeCreateFenceButton")), driver))
						{
						//	System.out.println("Time New Button Passed");
							driver.findElement(By.xpath(Object.getProperty("TimeFenceNameTextBox"))).clear();
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("TimeFenceNameTextBox"))).sendKeys(fenceNameArray[0]);
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("TimeStartDate"))).clear();
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("TimeStartDate"))).sendKeys(sDate);
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("TimeEndDate"))).clear();
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("TimeEndDate"))).sendKeys(eDate);
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("TimeCreateFenceButton"))).click();
							Thread.sleep(5000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(10000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceSetting")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceList")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFleetSetting")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeSaveButton")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeNewCancelButton")), driver))
							{
								Thread.sleep(5000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("TimePeriod")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceSettingClear")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeAllCheckBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeMondayCheckBox")), driver) 
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeTuesdayCheckBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeWednesDayCheckBox")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeThursDayCheckBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFriDayCheckBox")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeSaturDayCheckBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeSunDayCheckBox")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("DayTimeTable")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeEditStartDate")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeEditEndDate")), driver))
								{
						//			System.out.println("Edit Page Passed.");
									
								}
								else
								{
									System.out.println("Edit Page failled.");
									acop = "Some of Element Missing in the Edit Page.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
								
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("TimeSearchHolder")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceNameHolder")), driver))
								{
							//		System.out.println("Fence List passed.");
								}
								else
								{
									System.out.println("Fence List Failed.");
									acop = "Some of Element Missing in the FenceName List.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
								
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("TimeAssignedDashboard")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeUnassignedDashboard")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeAssignArrow")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeUnAssignArrow")), driver))
								{
							//		System.out.println("Fleet Setting Passed.");
									if(t.isElementPresentcheck(By.xpath(Object.getProperty("TimeSelectAllAssignedCheckBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeAssignedEquipID")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeAssignedSerialNo")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeAssignedOwner")), driver))
									{
										System.out.println("Assigned Pass.");
									}
									else
									{
										System.out.println("Assigned Fail.");
										acop = "Some of the Element Missing in the Assigned Table.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 3 execution completed############################");
									}
									
									if(t.isElementPresentcheck(By.xpath(Object.getProperty("TimeUnAssignedAllSelectCheckBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeUnAssignedEquipID")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeUnAssignedSerialNo")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeUnAssignedOwner")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeUnAssignedSearchBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeUnAssignedSearchType")), driver)
											&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeUnAssignedSearchButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeUnAssignedClearSearch")), driver))
									{
						//				System.out.println("Unassigend Pass");
									}
									else
									{
										System.out.println("Unassigned Fail.");
										acop = "Some of Element Missing in the Unassigned Table.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 3 execution completed############################");
									}
									
								}
								else
								{
									System.out.println("Fleet Setting Failed.");
									acop = "Some of the Element Missing in the Fleet Setting.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
								Thread.sleep(5000);
								
								//CheckBox Table Selecting.
								WebElement chk=driver.findElement(By.xpath("//*[@id='divTimePeriodDaySelection']/table/tbody/tr"));
								List<WebElement> chkBox=chk.findElements(By.tagName("td"));
								for(int k=0;k<dayArray.length;k++)
								{
									for(int j=0;j<chkBox.size();j++)
									{
										String chkText=chkBox.get(j).getText();
										System.out.println("Value : "+chkText);
										if(chkText.equalsIgnoreCase(dayArray[k]))
										{
											j++;
									//		System.out.println(j+" : K");
											Thread.sleep(3000);
											String id=driver.findElement(By.xpath("//*[@id='divTimePeriodDaySelection']/table/tbody/tr/td["+j+"]/input")).getAttribute("id");
									//		System.out.println("ID : "+id);
											driver.findElement(By.xpath("//*[@id='"+id+"']")).click();
											WebElement dayColor=driver.findElement(By.xpath("//*[@id='"+id+"']"));
											List<WebElement> dayColorList=dayColor.findElements(By.tagName("td"));
											for(int l=9;l<=18;l++)
											{
											//	System.out.println("DayColor : "+dayColorList.get(l).getCssValue("background-color"));
												String color=driver.findElement(By.xpath("//*[@id='"+id+"']/td["+l+"]")).getCssValue("background-color");
									//			System.out.println("Color : "+color);
												if(fenceNameArray[1].equalsIgnoreCase(color))
												{
									//				System.out.println("Color Same");
													flag=1;
												}
												else
												{
													flag=0;
													System.out.println("Color is not Same");
													acop = "CheckBox or the Color appearing is not Working as Expected. ";
													node.log(LogStatus.FAIL, acop);
													data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
													rc++;
													String scr = t.CaptureScreenshot();
													s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
													System.out.println( "###################Test case 3 execution completed############################");
													break;
												}
											}
											Thread.sleep(10000);
										}
									}
								}
								
								if(flag==1)
								{
									acop = "CheckBox Selecting Working as Expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
							
								//Manual table Clicking
								WebElement chkManual=driver.findElement(By.xpath("//*[@id='divTimePeriodDaySelection']/table/tbody/tr"));
								List<WebElement> chkManualList=chk.findElements(By.tagName("td"));
								for(int k=0;k<dayArray.length;k++)
								{
									for(int j=1;j<chkBox.size();j++)
									{
										String chkText=chkBox.get(j).getText();
										if(chkText.equalsIgnoreCase(dayArray[k]))
										{
											j++;
								//			System.out.println(j+" : j");
											String id=driver.findElement(By.xpath("//*[@id='divTimePeriodDaySelection']/table/tbody/tr/td["+j+"]/input")).getAttribute("id");
								//			System.out.println("ID : "+id);
											driver.findElement(By.xpath("//*[@id='"+id+"']/td[1]")).click();
											Thread.sleep(3000);
											String color=driver.findElement(By.xpath("//*[@id='"+id+"']/td[1]")).getCssValue("background-color");
									//		System.out.println("Color : "+color);
											if(color.equalsIgnoreCase(fenceNameArray[1]))
											{
									//			System.out.println("Manual Pass");
												acop = "Manually Clicking Fence Time Table is Working as Expected.";
												node.log(LogStatus.PASS, acop);
												data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
												rc++;
												s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
												System.out.println( "###################Test case 3 execution completed############################");
											}
											else
											{
												System.out.println("Unable to click the Time Table Cell.");
												acop = "Click While is not appear any color in the Selected Cell.";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 3 execution completed############################");
											}
										}
									}

								}
								
								//Assigning the Assets
								WebElement searchType = driver.findElement(By.xpath(Object.getProperty("TimeUnAssignedSearchType")));
								List<WebElement> searchTypeList=searchType.findElements(By.tagName("option"));
								int n=0;
								for(int k=0;k<assetSearchArray.length;k++)
								{
									for(WebElement type : searchTypeList)
									{
										n++;
										if(fenceNameArray[2].equalsIgnoreCase(type.getText()))
										{
											Thread.sleep(2000);
											type.click();
											driver.findElement(By.xpath(Object.getProperty("TimeUnAssignedSearchBox"))).sendKeys(assetSearchArray[k]);
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("TimeUnAssignedSearchButton"))).click();
											Thread.sleep(3000);
											while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
											{
												System.out.println("inside while");
												Thread.sleep(1000);
											}
											Thread.sleep(5000);
											driver.findElement(By.xpath(Object.getProperty("TimeAssignClick"))).click();
											Thread.sleep(3000);
											while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
											{
												System.out.println("inside while");
												Thread.sleep(1000);
											}
											Thread.sleep(3000);
											driver.findElement(By.xpath(Object.getProperty("TimeAssignArrow"))).click();
											Thread.sleep(3000);
											String val=driver.findElement(By.xpath("//*[@id='tblAssignedEquipment']/tbody/tr[2]/td["+n+"]")).getText();
										//	System.out.println("Assigned Val : "+val);
											if(val.equalsIgnoreCase(assetSearchArray[k]))
											{
									//			System.out.println("Both table have same values");	 
											}
											else
											{
												System.out.println("Unable to assing the asset	");
												acop = "Unable to assign the Assets.";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 3 execution completed############################");
											}
											
										}
									}
								}
								driver.findElement(By.xpath(Object.getProperty("TimeSaveButton"))).click();
								Thread.sleep(3000);
							/*	while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}*/
								Thread.sleep(10000);
								if(t.isAlertPresent(driver))
								{
									driver.switchTo().alert().accept();
								}
								else
								{
									System.out.println("Any alert is not present");
									acop = "Is not Display any Alert after Saving the Fence.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
								Thread.sleep(5000);
								int m=0;
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("TimeSelectedAssets")), driver))
								{
									String noRecord=driver.findElement(By.xpath("//*[@id='tblEquipmentList']/tbody/tr/td")).getText();
									if(noRecord.equalsIgnoreCase("No Data Found"))
									{
										System.out.println("Fail No Record After Saving the fence.");
										acop = "Fence Saved after the fleet table Display no Records.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 3 execution completed############################");
									}
									else
									{
										WebElement selectedTable=driver.findElement(By.xpath("//*[@id='tblEquipmentList']/thead/tr"));
										List<WebElement> selectedTableList=selectedTable.findElements(By.tagName("th"));
										for(int l=0;l<assetSearchArray.length;l++)
										{
											for(WebElement text : selectedTableList)
											{
												m++;
												if(fenceNameArray[2].equalsIgnoreCase(text.getText()))
												{
									//				System.out.println("Pass Text ; "+text.getText());
										//			System.out.println("M  : "+m);
													String	finalResult=driver.findElement(By.xpath("//*[@id='tblEquipmentList']/tbody/tr/td["+m+"]")).getText();
													if(finalResult.equalsIgnoreCase(assetSearchArray[l]))
													{
												//		System.out.println("Final pass");
														System.out.println("FinaL Values : "+finalResult);
														flag2=1;
													}
													else
													{
														System.out.println("Assigned Asset Miss Matching with Final Assigned Table.");
														acop = "Assigned Assest is not displaying after saving the Fence.";
														node.log(LogStatus.FAIL, acop);
														data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
														rc++;
														String scr = t.CaptureScreenshot();
														s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
														System.out.println( "###################Test case 3 execution completed############################");
													}
													
													if(flag2==1)
													{
														acop = "Fence Creating Working as Expected.";
														node.log(LogStatus.PASS, acop);
														data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
														rc++;
														s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
														System.out.println( "###################Test case 3 execution completed############################");
													}
												}
											}
										}	
									}
								
								}
								else
								{
									System.out.println("Assigned Table Missing.");	
									acop = "Assigned Table Missing.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
							}
							else
							{
								System.out.println("Some of Element Missing in the Edit page.");
								acop = "Some of Element Missing in the Edit Page.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 3 execution completed############################");
								
								Thread.sleep(3000);
								driver.findElement(By.xpath(Object.getProperty("TimeNewCancelButton"))).click();
								Thread.sleep(10000);
							}
						}
						else
						{
							System.out.println("Time New Button not working as Expected.");
							acop = "Time Fence is New Button not Working as Expected.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 3 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				
				//Fence Edit
				if(d2[i][0].equalsIgnoreCase("TC4"))
				{
					try
					{
						System.out.println( "###################Test case 4 is executing############################");
						Thread.sleep(5000);
				//		AddFilter.pageNavigater();
						Thread.sleep(5000);
						String fenceName = d2[3][4];
						String [] fenceNameArray=fenceName.split("#");
						String day=d2[3][3];
						String [] dayArray=day.split(",");
						String asset=d2[3][2];
						String [] assetArray=asset.split(",");
						int flag2=0,flag1=0,flag3=0,flag4=0,flag5=0;
						int flag=0,flag6=0;;
						driver.findElement(By.xpath(Object.getProperty("TimeFenceNameSearchbox"))).sendKeys(fenceNameArray[0]);
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("TimeFenceNameSearchButton"))).click();
						Thread.sleep(5000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("TimeEditButton"))).click();
						Thread.sleep(5000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(5000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceList")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceSetting")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFleetSetting")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeSaveButton")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeNewCancelButton")), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("TimeSelectAllAssignedCheckBox"))).click();
							Thread.sleep(5000);while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("TimeUnAssignArrow"))).click();
							Thread.sleep(3000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
							WebElement searchType = driver.findElement(By.xpath(Object.getProperty("TimeUnAssignedSearchType")));
							List<WebElement> searchTypeList=searchType.findElements(By.tagName("option"));
							int n=1;
							for(int j=0;j<assetArray.length;j++)
							{
								for(WebElement type : searchTypeList)
								{
									n++;
									if(type.getText().equalsIgnoreCase(fenceNameArray[1]))
									{
										Thread.sleep(2000);
										type.click();
										driver.findElement(By.xpath(Object.getProperty("TimeUnAssignedSearchBox"))).sendKeys(assetArray[j]);
										Thread.sleep(2000);
										driver.findElement(By.xpath(Object.getProperty("TimeUnAssignedSearchButton"))).click();
										Thread.sleep(3000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(5000);
										driver.findElement(By.xpath(Object.getProperty("TimeAssignClick"))).click();
										Thread.sleep(3000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(3000);
										driver.findElement(By.xpath(Object.getProperty("TimeAssignArrow"))).click();
										Thread.sleep(3000);
										String val=driver.findElement(By.xpath("//*[@id='tblAssignedEquipment']/tbody/tr/td["+n+"]")).getText();
										if(val.equalsIgnoreCase(assetArray[j]))
										{
											System.out.println("Asset Assigning is working as Expected."); 	
											flag=1;
										}
										else
										{
											flag=0;
											System.out.println("Asset Assigning is not working as Expected.");
											acop = "Asset Assigning is not working as Expected.";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 4 execution completed############################");
										}
									}
								}
							}
							if(flag==1)
							{
								acop = "Asset Assigning is working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 4 execution completed############################");
							}
							//Time Table Clear
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("TimeFenceSettingClear"))).click();
							Thread.sleep(10000);
							WebElement chkBox1 = driver.findElement(By.xpath("//*[@id='divTimePeriodDaySelection']/table/tbody/tr"));
							List<WebElement> chkBoxList=chkBox1.findElements(By.tagName("td"));
							for(int k=2;k<=chkBoxList.size();k++)
							{
								String id=driver.findElement(By.xpath("//*[@id='divTimePeriodDaySelection']/table/tbody/tr/td["+k+"]/input")).getAttribute("id");
						//		System.out.println("ID : "+id);
								WebElement dayColor=driver.findElement(By.xpath("//*[@id='"+id+"']"));
								List<WebElement> dayColorList=dayColor.findElements(By.tagName("td"));
								if(id.equalsIgnoreCase("chkAllDay"))
								{
									for(int a=3;a<=9;a++)
									{
										String id1=driver.findElement(By.xpath("//*[@id='divTimePeriodDaySelection']/table/tbody/tr/td["+a+"]/input")).getAttribute("id");
							//			System.out.println("ID1: "+id1);
										for(int l=9;l<=18;l++)
										{																		
											String clas=driver.findElement(By.xpath("//*[@id='"+id1+"']/td["+l+"]")).getAttribute("class");
											String color=driver.findElement(By.xpath("//*[@id='"+id1+"']/td["+l+"]")).getCssValue("background-color");
											if(clas.equalsIgnoreCase("") && color.equalsIgnoreCase("rgba(0, 0, 0, 0)"))
											{
												System.out.println(id+" Clear button Working as Expected.");
												flag1=1;
											}
											else
											{	
												flag1=0;
												System.out.println("Clear Button not working as Expected.");
												acop = "Clear Button not working as Expected.";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 4 execution completed############################");
												break;
											}
										}
									}
								}
								else
								{
									for(int l=9;l<=18;l++)
									{																		
										String clas=driver.findElement(By.xpath("//*[@id='"+id+"']/td["+l+"]")).getAttribute("class");
										String color=driver.findElement(By.xpath("//*[@id='"+id+"']/td["+l+"]")).getCssValue("background-color");
										if(clas.equalsIgnoreCase("") && color.equalsIgnoreCase("rgba(0, 0, 0, 0)"))
										{
											System.out.println("Clear Button Working as Expected.");
											flag1=1;
										}
										else
										{	flag1=0;
											System.out.println("Clear button not working as Expected.");
											acop = "Clear Button is not Working as Expected. ";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 4 execution completed############################");
											break;
										}
									}
								}
							}
							if(flag1==1)
							{
								acop = "Clear Button is working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 4 execution completed############################");
							}
						
							//CheckBox Table Selecting.
							WebElement chk=driver.findElement(By.xpath("//*[@id='divTimePeriodDaySelection']/table/tbody/tr"));
							List<WebElement> chkBox=chk.findElements(By.tagName("td"));
							for(int k=0;k<dayArray.length;k++)
							{
								for(int j=0;j<chkBox.size();j++)
								{
									String chkText=chkBox.get(j).getText();
									if(chkText.equalsIgnoreCase(dayArray[k]))
									{
										j++;
										Thread.sleep(3000);
										String id=driver.findElement(By.xpath("//*[@id='divTimePeriodDaySelection']/table/tbody/tr/td["+j+"]/input")).getAttribute("id");
								//		System.out.println("ID : "+id);
										driver.findElement(By.xpath("//*[@id='"+id+"']")).click();
										WebElement dayColor=driver.findElement(By.xpath("//*[@id='"+id+"']"));
										List<WebElement> dayColorList=dayColor.findElements(By.tagName("td"));
										for(int l=9;l<=18;l++)
										{
											String color=driver.findElement(By.xpath("//*[@id='"+id+"']/td["+l+"]")).getCssValue("background-color");
											if(fenceNameArray[2].equalsIgnoreCase(color))
											{
									//			System.out.println("Color Same");
												flag2=1;	
											}
											else
											{
												flag2=0;
												System.out.println("Color is not Same");
												acop = "CheckBox or the Color appearing is not Working as Expected. ";
												node.log(LogStatus.FAIL, acop);
												data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 4 execution completed############################");
											}
										}
										Thread.sleep(10000);
									}
								}
							}
							if(flag2==1)
							{
								acop = "Check Box  is working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 4 execution completed############################");
							}
							
							//Manual table Clicking
							WebElement chkManual=driver.findElement(By.xpath("//*[@id='divTimePeriodDaySelection']/table/tbody/tr"));
							List<WebElement> chkManualList=chk.findElements(By.tagName("td"));
							for(int k=0;k<dayArray.length;k++)
							{
								for(int j=1;j<chkBox.size();j++)
								{
									String chkText=chkBox.get(j).getText();
									if(chkText.equalsIgnoreCase(dayArray[k]))
									{
										j++;
										String id=driver.findElement(By.xpath("//*[@id='divTimePeriodDaySelection']/table/tbody/tr/td["+j+"]/input")).getAttribute("id");
								//		System.out.println("ID : "+id);
										driver.findElement(By.xpath("//*[@id='"+id+"']/td[1]")).click();
										Thread.sleep(3000);
										String color=driver.findElement(By.xpath("//*[@id='"+id+"']/td[1]")).getCssValue("background-color");
										if(color.equalsIgnoreCase(fenceNameArray[2]))
										{
											System.out.println("Time Table Selecting Working as Expected.");
											flag3=1;
										}
										else
										{	
											System.out.println("Unable to Select the time table.");
											acop = "Click While is not appear any color in the Clicked Cell.";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 4 execution completed############################");
										}
									}
								}
							}
							if(flag3==1)
							{
								acop = "Time Table Selecting Working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 4 execution completed############################");
							}
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("TimeSaveButton"))).click();
							Thread.sleep(5000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
							Thread.sleep(10000);
							if(t.isAlertPresent(driver))
							{
								driver.switchTo().alert().accept();
							}
							else
							{
								System.out.println("Any alert is not prsent");
								acop = "Is not Display any Alert after Saving the Fence.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 4 execution completed############################");
							}
							Thread.sleep(5000);

							//checking after the save.
							int m=0;
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("TimeSelectedAssets")), driver))
							{
								String noRecord=driver.findElement(By.xpath("//*[@id='tblEquipmentList']/tbody/tr/td")).getText();
								if(noRecord.equalsIgnoreCase("No Data Found"))
								{
									System.out.println("Fail No Record After Saving the fence.");
									acop = "Fence Saved after the fleet table Display no Records.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 4 execution completed############################");
								}
								else
								{
									WebElement selectedTable=driver.findElement(By.xpath("//*[@id='tblEquipmentList']/thead/tr"));
									List<WebElement> selectedTableList=selectedTable.findElements(By.tagName("th"));
									for(int l=0;l<assetArray.length;l++)
									{
										for(WebElement text : selectedTableList)
										{
											m++;
											if(fenceNameArray[1].equalsIgnoreCase(text.getText()))
											{
										//		System.out.println("Pass Text ; "+text.getText());
										//		System.out.println("M  : "+m);
												String	finalResult=driver.findElement(By.xpath("//*[@id='tblEquipmentList']/tbody/tr/td["+m+"]")).getText();
												if(finalResult.equalsIgnoreCase(assetArray[l]))
												{
													System.out.println("SuccessFully Saved the Fence.");
													flag4=1;
												}
												else
												{
													flag4=0;
													System.out.println("Assigned Asset Miss Matching with Final Assigned Table.");
													acop = "Assigned Assest is not displaying after saving the Fence.";
													node.log(LogStatus.FAIL, acop);
													data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
													rc++;
													String scr = t.CaptureScreenshot();
													s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
													System.out.println( "###################Test case 4 execution completed############################");
												}
												
												if(flag4==1)
												{
													acop = "Succesfully Assigned new Asset into Fence.";
													node.log(LogStatus.PASS, acop);
													data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
													rc++;
													s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
													System.out.println( "###################Test case 4 execution completed############################");
												}
											}
										}
									}	
								}
								
								//Time Table Checking after the save.
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("TimePeriod")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("DayTimeTable")), driver))
								{
									WebElement chkBox11 = driver.findElement(By.xpath("//*[@id='divTimePeriodDaySelection']/table/tbody/tr"));
									List<WebElement> chkBoxList1=chkBox11.findElements(By.tagName("td"));
							//		System.out.println("Day List Size "+chkBoxList1.size());
									for(int j=0;j<dayArray.length;j++)
									{
										for(int k=2;k<=chkBoxList1.size()-1;k++)
										{
											k++;										
											String val=driver.findElement(By.xpath("//*[@id='divTimePeriodDaySelection']/table/tbody/tr/td["+k+"]")).getText();
											if(dayArray[j].equalsIgnoreCase(val))
											{
												String id=driver.findElement(By.xpath("//*[@id='divTimePeriodDaySelection']/table/tbody/tr/td["+k+"]/input")).getAttribute("id");
									//			System.out.println("ID : "+id);
												WebElement dayColor=driver.findElement(By.xpath("//*[@id='"+id+"']"));
												List<WebElement> dayColorList=dayColor.findElements(By.tagName("td"));
												for(int l=9;l<=18;l++)
												{
													String color=driver.findElement(By.xpath("//*[@id='"+id+"']/td["+l+"]")).getCssValue("background-color");
													if(color.equalsIgnoreCase(fenceNameArray[2]))
													{
										//				System.out.println("Color Pass");
														flag5=1;
													}
													else
													{ 	flag5=0;
														System.out.println("Any changes is not applied after change.");
														acop = "Any changes is not applied after change.";
														node.log(LogStatus.FAIL, acop);
														data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
														rc++;
														String scr = t.CaptureScreenshot();
														s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
														System.out.println( "###################Test case 4 execution completed############################");
														break;
													}
												}
											} 
										}
									}
									
									if(flag5==1)
									{
										acop = "Succesfully Assigned new Time Table Using By CheckBox.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 4 execution completed############################");
									}
									for(int j=0;j<dayArray.length;j++)
									{
										for(int k=2;k<=chkBoxList1.size()-1;k++)
										{
											k++;										
											String val=driver.findElement(By.xpath("//*[@id='divTimePeriodDaySelection']/table/tbody/tr/td["+k+"]")).getText();
											if(dayArray[j].equalsIgnoreCase(val))
											{
												String id=driver.findElement(By.xpath("//*[@id='divTimePeriodDaySelection']/table/tbody/tr/td["+k+"]/input")).getAttribute("id");
									//			System.out.println("ID : "+id);
												String color=driver.findElement(By.xpath("//*[@id='"+id+"']/td[1]")).getCssValue("background-color");
									//			System.out.println("Color : "+color);
												if(color.equalsIgnoreCase(fenceNameArray[2]))
												{
										//			System.out.println("Color Pass");
													flag6=1;
												}
												else
												{
													flag6=0;
													System.out.println("Any changes is not applied after change.");
													acop = "Any changes is not applied after change.";
													node.log(LogStatus.FAIL, acop);
													data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
													rc++;
													String scr = t.CaptureScreenshot();
													s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
													System.out.println( "###################Test case 4 execution completed############################");
													break;
												}
											} 
										}
									}
									if(flag6==1)
									{
										acop = "Succesfully Assigned new Time Table by selecting time Range..";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 4 execution completed############################");
									}
								}
								else
								{
									System.out.println("Some of Element Missing after saving the fence at Time Table.");
									acop = "Some of Element Missing after saving the fence at Time Table.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 4 execution completed############################");
								}
						}
						else
						{
							System.out.println("Some of Element Missing in the Edit Page.");
							acop = "Some of Element Missing in the Edit Page.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 4 execution completed############################");
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("TimeNewCancelButton"))).click();
							Thread.sleep(10000);
						}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
					
					//Histroy	Button 
					if(d2[i][0].equalsIgnoreCase("TC5"))
					{
						try
						{
							System.out.println( "###################Test case 5 is executing############################");
						//	AddFilter.pageNavigater();
							String val=d2[4][4].toString();
							String[] array=val.split(",");
							int flag=0;
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("TimeFenceNameSearchbox"))).clear();
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("TimeFenceNameSearchbox"))).sendKeys(array[0]);
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("TimeFenceNameSearchButton"))).click();
							Thread.sleep(3000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("TimeFenceHistoryButton"))).click();
							Thread.sleep(6000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceHistoryTab")), driver))
							{
								WebElement fence=driver.findElement(By.xpath(Object.getProperty("TimeFenceNameHistory")));
								List<WebElement> fenceName=fence.findElements(By.tagName("th"));
								System.out.println("Fence Name  :" +fenceName.get(0).getText());
								if(fenceName.get(0).getText().equalsIgnoreCase(array[0]) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceHistoryTimeTable")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceHistoryCloseButton")), driver)	&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceHistoryTimeTable")), driver) 
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceHistoryDateRange")), driver))
								{
									System.out.println("It Displaying the Selected Fence is History");
									WebElement equpment=driver.findElement(By.xpath(Object.getProperty("TimeFenceEquipmentList")));
									List<WebElement> equpmentList=equpment.findElements(By.tagName("th"));
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
											data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 5 execution completed############################");
										}
									}
									if(flag==1)
									{
										System.out.println("All is Passed");
										acop = "TimeFence History Button Working as Expected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 5 execution completed############################");
									}
								}
								else
								{
									System.out.println("Its Displaying none selected Fence or Some Element Missing.");
									acop = "Some Element Missing in History Tap";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 5 execution completed############################");
								}
								Thread.sleep(3000);
								driver.findElement(By.xpath(Object.getProperty("TimeFenceHistoryCloseButton"))).click();
								Thread.sleep(3000);
							}
							else
							{
								System.out.println("Histroy Button Not Working");
								acop = "History Button Not Working as Expected.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					
					//Search Box.
					if(d2[i][0].equalsIgnoreCase("TC6"))
					{
						try
						{
							System.out.println( "###################Test case 6 is executing############################");
						//	AddFilter.pageNavigater();
							Thread.sleep(5000);
							String fenceName=d2[5][4];
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceNameSearchbox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceNameTable")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceNameSearchClearButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeFenceNameSearchButton")), driver))
							
								{
									driver.findElement(By.xpath(Object.getProperty("TimeFenceNameSearchbox"))).clear();
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("TimeFenceNameSearchbox"))).sendKeys(fenceName);
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("TimeFenceNameSearchButton"))).click();
									Thread.sleep(3000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(5000);
									WebElement table=driver.findElement(By.xpath(Object.getProperty("TimeFenceNameTable")));
									String tableName=table.findElement(By.tagName("td")).getText();
									System.out.println("Table Name : "+tableName);
									String chk=tableName.substring(0, fenceName.length());
								//	System.out.println("Text : "+chk);
									if(chk.equalsIgnoreCase(fenceName))
									{
										System.out.println("Fence Name Search Working as Expected.");
										acop = "Fence Name Button Working as Expected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 6 execution completed############################");
									
										driver.findElement(By.xpath(Object.getProperty("TimeFenceNameSearchClearButton"))).click();
										Thread.sleep(3000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(5000);
										String clearVal=driver.findElement(By.xpath(Object.getProperty("TimeFenceNameSearchbox"))).getText();
										System.out.println("Search box Value : "+clearVal);
										if(clearVal.equalsIgnoreCase(fenceName))
										{
											System.out.println("Clear Fail");
											acop = "Clear Button Not Working as Expected.";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 6 execution completed############################");
										}
										else
										{
											System.out.println("Clear pass");
											acop = "Clear Button Working as Expected.";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
											rc++;
											s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
											System.out.println( "###################Test case 6 execution completed############################");
										}
									}
									else
									{	
										System.out.println("Fence Name Searching Fail");
										acop = "Unable to search the fence Name.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 6 execution completed############################");
									}
								}
							else
							{
								System.out.println("Some Element Missing in Fence Name Search Table");
								acop = "Some Element Missing in Fence Name Search Table";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 6 execution completed############################");
							}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					
					
					//Add Email Button
					if(d2[i][0].equalsIgnoreCase("TC7"))
					{
						try
						{
							System.out.println( "###################Test case 7 is executing############################");
						//	AddFilter.pageNavigater();
							Thread.sleep(5000);
							String fenceName=d2[6][3].toString();
							String [] val=fenceName.split(",");
							String str=d2[6][4].toString();
							String[] excelTable=str.split(",");
							String str1=d2[6][2];
							String []addMail=str1.split(",");
							int flag=0;
							System.out.println("XY : "+driver.findElement(By.xpath("//*[@id='tblNotificationList']/tbody/tr/td[1]")).getText());
							driver.findElement(By.xpath(Object.getProperty("TimeFenceNameSearchbox"))).sendKeys(val[0]);
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("TimeFenceNameSearchButton"))).click();
							Thread.sleep(3000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("TimeAddEmailButton"))).click();
							Thread.sleep(3000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("TimeAddEmailDialogueBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeUserNameSearchType")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeAddEmailSearchBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeADDEmailSearchButton")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeADDEmailClearButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TimeSelectButton")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("TimeCancelButton")), driver))								
							{
								WebElement table=driver.findElement(By.xpath(Object.getProperty("TimeEmailADDTabel")));
								List<WebElement> tableList=table.findElements(By.tagName("th"));
								for(int k=0;k<excelTable.length;k++)
								{
							//		System.out.println(tableList.get(k).getText());
									String text=tableList.get(k).getText();
									if(excelTable[k].equalsIgnoreCase(text))
									{
										WebElement type=driver.findElement(By.xpath(Object.getProperty("TimeUserNameSearchType")));
										List<WebElement>typeList=type.findElements(By.tagName("option"));
										for(WebElement text1 : typeList)
										{
											if(val[1].equalsIgnoreCase(text1.getText()))
											{
												text1.click();
												driver.findElement(By.xpath(Object.getProperty("TimeAddEmailSearchBox"))).sendKeys(val[2]);
												Thread.sleep(3000);
												driver.findElement(By.xpath(Object.getProperty("TimeADDEmailSearchButton"))).click();
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
													tableVal=driver.findElement(By.xpath("/html/body/div[4]/div[2]/table/tbody/tr[2]/td/div/table/tbody/tr/td[2]/div")).getText();
													System.out.println("Name ; "+tableVal);
												}
												else if(val[1].equalsIgnoreCase("Email Id"))
												{
													tableVal=driver.findElement(By.xpath("/html/body/div[4]/div[2]/table/tbody/tr[2]/td/div/table/tbody/tr/td[3]/div")).getText();
													System.out.println("Email Id ; "+tableVal);
												}
												if(val[2].equalsIgnoreCase(tableVal))
												{
													driver.findElement(By.xpath("/html/body/div[4]/div[2]/table/tbody/tr[2]/td/div/table/tbody/tr/td[4]/div/input")).click();
													Thread.sleep(3000);
													driver.findElement(By.xpath("/html/body/div[4]/div[2]/table/tbody/tr[2]/td/div/table/tbody/tr/td[5]/div/input")).click();
													Thread.sleep(3000);
													driver.findElement(By.xpath(Object.getProperty("TimeSelectButton"))).click();
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
														data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
														rc++;
														String scr = t.CaptureScreenshot();
														s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
														System.out.println( "###################Test case 7 execution completed############################");
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
												//		System.out.println("MaiL List : "+m);
												//		System.out.println("Excel List : "+addMail[n]);
														if(m.equalsIgnoreCase(addMail[n]))
														{
											//				System.out.println("Total Pass");
															flag=1;
														}
														else
														{
															flag=0;
															acop = "Its not Saving Selected Notification requirment.";
															node.log(LogStatus.FAIL, acop);
															data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
															rc++;
															String scr = t.CaptureScreenshot();
															s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
															System.out.println( "###################Test case 7 execution completed############################");
														}
													}
													
													if(flag==1)
													{
														acop = "Table Created and Added Notification Setup SuccesFully.";
														node.log(LogStatus.PASS, acop);
														data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
														rc++;
														s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
														System.out.println( "###################Test case 7 execution completed############################");
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
										data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 7 execution completed############################");
									}
								}
								
							}
							else
							{
								System.out.println("Add Email Dialogue box dint displaying properly.");
								acop = "Add Email Dialogue box dint displaying properly.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 7 execution completed############################");
							}
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("TimeAddEmailButton"))).click();
							Thread.sleep(3000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("TimeCancelButton"))).click();
							Thread.sleep(6000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("TimeAddEmailDialogueBox")), driver))
							{
								System.out.println("Cancel Fail");
								acop = "Cancel Button is not working as Expected.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 7 execution completed############################");
							}
							else
							{
								System.out.println("Cancel pass");
								acop = "Table Cancel Working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 7 execution completed############################");
							}
							
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					}
					
					
					
					// Delete Button 
					if(d2[i][0].equalsIgnoreCase("TC8"))
					{
						try
						{
							System.out.println( "###################Test case 8 is executing############################");
						//	AddFilter.pageNavigater();
							String val=d2[7][4];
							int flag=0;
							WebElement table=driver.findElement(By.xpath("//*[@id='tblFenceName']"));
							List<WebElement>Table=table.findElements(By.tagName("tr"));
							for(WebElement text : Table)
							{
								String Text=text.getText();
								Text.substring(0, val.length());
								String chk=Text.substring(0, val.length());
								if(val.equalsIgnoreCase(chk))
								{	
									text.click();
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("TimeFenceDeleteButton"))).click();
									Thread.sleep(1000);
									if(t.isAlertPresent(driver))
									{
										driver.switchTo().alert().accept();
										Thread.sleep(12000);
										if(t.isAlertPresent(driver))
										{
											driver.switchTo().alert().accept();
										}
									}
									else
									{
										acop = "Its not pop the alert, Do you want to delete the selected fence?";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 8 execution completed############################");
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
								//	System.out.println("table : "+Table1.size());
									Thread.sleep(3000);
									for(WebElement text1 : Table1)
									{
										String Text1=text1.getText();
										Text1.substring(0, val.length());
								//		System.out.println("Text : "+Text1);
										if(val.equalsIgnoreCase(Text1))
										{
											System.out.println("Fail");
											acop = "Delete Button Not working as Expcted.";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 8 execution completed############################");
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
										data.put(""+rc, new Object[] {d2[i][0], "TimeFence", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "TimeFence", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 8 execution completed############################");
									}
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
