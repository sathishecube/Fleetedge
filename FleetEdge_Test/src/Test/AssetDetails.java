package Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
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
import FleetEdge_Util.AddFilter;
import FleetEdge_Util.Util;
import FleetEdge_Util.Utildashboard;

public class AssetDetails extends Core
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]>AssetDetailscases(Map<String, Object[]> data, int rc ,String sheet, ExtentTest test,int scase,int ecase)
	{
	
		String acop =null;
		String[][] d2 = s.Read(path, sheet);
		ExtentTest node = reports.startTest(sheet);
		try
		{
			driver = new FirefoxDriver(t.excel());
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
							data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 1 execution completed############################");
						}
						else
						{
							System.out.println("Page loaded Successfully");
							acop = "Fleet Status Page Loaded Successfully";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
							System.out.println( "###################Test case 1 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				//
				if(d2[i][0].equalsIgnoreCase("TC2"))
				{	
					try
					{
						System.out.println( "###################Test case 2 is executing############################");
						String asset=d2[1][4];
						WebElement ele = driver.findElement(By.xpath(Object.getProperty("Searialsearch")));
						ele.sendKeys(asset);
						Thread.sleep(2000);
						WebElement select = driver.findElement(By.id("ui-id-2"));
						List<WebElement> options = select.findElements(By.className("ui-corner-all"));
						System.out.println(options.size());
						for (WebElement option : options) 
						{	 	  
							System.out.println(option.getText());
							if(option.getText().equals(asset)) 
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
							driver.findElement(By.partialLinkText(asset)).click();
							Thread.sleep(5000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
							String chk=driver.findElement(By.xpath(".//*[@id='lblMenuPath2']")).getText();
							System.out.println("Page Header : "+chk);
							if(chk.equalsIgnoreCase("TEREX MATERIALS PROC • DETAILS • "+asset))
							{
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("AssetSummaryTab")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AssetDetailsTab")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("AssetSummary")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AssetSearchbox")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("AssetPageDate")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AssetDetailsPageMap")), driver))
								{
									System.out.println("Asset Details page loaded and navigated successfully.");
									acop = "Asset Details page loaded and navigated successfully.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 2 execution completed############################");
								}
								else
								{
									System.out.println("Asset Details page properly loaded or some of element missing.");
									acop = "Asset Details page properly loaded or some of element missing.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 2 execution completed############################");
								
								}
							}
							else
							{
								System.out.println("Asset Details page header missing or miss match with asset name.");
								acop = "Asset Details page header missing or miss match with asset name.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 2 execution completed############################");
							
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				//Asset Summary
				if(d2[i][0].equalsIgnoreCase("TC3"))
				{	
					try
					{
						System.out.println( "###################Test case 3 is executing############################");
						AddFilter.assetDetails("PIDTP320EOMF70854");
						String asset=d2[2][4];
						String [] assetArray=asset.split(",");
						Thread.sleep(5000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("MachineInfo")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AssetSummaryName")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("MachineType")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SerialNumber")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("UnitID")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SoftwareVersion")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("HardwareVersion")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("NameUpdateButton")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("HardwareUpdateButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TerminalType")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("FirmwareVersion")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ObtimizerVersion")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("ProfileVersion")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TotalHours")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("TotalFuel")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UreaChart")), driver))
							
						{
							System.out.println("Summary pass");
							//Asset Name Update
							driver.findElement(By.xpath(Object.getProperty("NameUpdateButton"))).click();
							Thread.sleep(2000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("AssetNameDialoguebox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AssetNameTextbox")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("AssetNameUpdateButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AssetNameCancelButton")), driver))
							{
								System.out.println("Name update pass");
								driver.findElement(By.xpath(Object.getProperty("AssetNameTextbox"))).clear();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("AssetNameTextbox"))).sendKeys(assetArray[0]);
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("AssetNameUpdateButton"))).click();
								Thread.sleep(3000);
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
								Thread.sleep(3000);
								String name = driver.findElement(By.xpath(Object.getProperty("AssetSummaryName"))).getText();
								System.out.println("Asset Name : "+name);
								if(name.equalsIgnoreCase(assetArray[0]))
								{
									System.out.println("Asset Name Updated Successfully.");
									acop = "Asset Name Updated Successfully.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
								else
								{
									System.out.println("Unable to update new asset name.");
									acop = "Unable to update new asset name.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
							}
							else
							{
								System.out.println("Asset Name update button is not working as Expected.");
								acop = "Asset Name update button is not working as Expected.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 3 execution completed############################");
							}
							
							
							//Hardware Version update.
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("HardwareUpdateButton"))).click();
							Thread.sleep(3000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("HardwareDialoguebox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HardwareTextbox")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("HardwareNameUpdateButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HardwareCancelButton")), driver))
							{
								System.out.println("Hardware displays ");
								driver.findElement(By.xpath(Object.getProperty("HardwareTextbox"))).clear();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("HardwareTextbox"))).sendKeys(assetArray[1]);
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("HardwareNameUpdateButton"))).click();
								Thread.sleep(5000);
								String hardwareName = driver.findElement(By.xpath(Object.getProperty("HardwareVersionName"))).getText();
								System.out.println("Hardware Name : "+hardwareName);
								if(hardwareName.equalsIgnoreCase(assetArray[1]))
								{
									System.out.println("hardware name updated successfully.");
									acop = "hardware name updated successfully.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
								else if(hardwareName.equalsIgnoreCase(null))
								{
									System.out.println("hardware name is null, unable to update.");
									acop = "Hardware name is null, unable to update the hardware name.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
								else
								{
									System.out.println("Unable to update hardware name.");
									acop = "Unable to update hardware name.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 3 execution completed############################");
								}
							}
							else
							{
								System.out.println("Hardware version update button is not working as expected.");
								acop = "Hardware version update button is not working as expected.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 3 execution completed############################");
							}
							
						}
						else
						{
							System.out.println("Asset summary is not displaying propery or some of element missing.");
							acop = "Asset summary is not displaying propery or some of element missing.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 3 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				//Summary verify with fleet details
				if(d2[i][0].equalsIgnoreCase("TC4"))
				{	
					try
					{
						System.out.println( "###################Test case 4 is executing############################");
						String asset=d2[3][4];
						int flag=0;
						ArrayList<String> list=new ArrayList<String>();
						ArrayList<String> fleetList=new ArrayList<String>();
						AddFilter.assetDetails("PIDTP320EOMF70854");
						Thread.sleep(3000);
						String machineInfo = driver.findElement(By.xpath(Object.getProperty("MachineInfo"))).getAttribute("src");
						System.out.println("machine Info : "+machineInfo);
						list.add(machineInfo);
						String name=driver.findElement(By.xpath(Object.getProperty("AssetSummaryName"))).getText();
						System.out.println("Name : "+name);
						list.add(name);
						String machine=driver.findElement(By.xpath(Object.getProperty("MachineType"))).getText();
						System.out.println("Machine type : "+machine);
						Integer vl=Integer.valueOf(machine.indexOf(" "));
						String machineType=machine.substring(0, vl);
						System.out.println("Machine Type "+machineType);
						list.add(machineType);
						String serialNo = driver.findElement(By.xpath(Object.getProperty("SerialNumber"))).getText();
						System.out.println("Serial No : "+serialNo);
						list.add(serialNo);
						String unitId =driver.findElement(By.xpath(Object.getProperty("UnitID"))).getText();
						System.out.println("Unit Id : "+unitId);
						list.add(unitId);
						String terminalType=driver.findElement(By.xpath(Object.getProperty("TerminalType"))).getText();
						System.out.println("Terminal Type : "+terminalType);
						list.add(terminalType);
						String firmware=driver.findElement(By.xpath(Object.getProperty("FirmwareVersion"))) .getText();
						System.out.println("Firmware : "+firmware);
						list.add(firmware);
						String optimizer=driver.findElement(By.xpath(Object.getProperty("ObtimizerVersion"))).getText();
						System.out.println("Optimizer : "+optimizer);
						list.add(optimizer);
						String profile=driver.findElement(By.xpath(Object.getProperty("ProfileVersion"))).getText();
						System.out.println("Profile : "+profile);
						list.add(profile);
						String totalHour = driver.findElement(By.xpath(Object.getProperty("TotalHours"))).getText();
						System.out.println("TotalHour : "+totalHour);
						String totalHours=totalHour.substring(totalHour.indexOf("(")+1, totalHour.lastIndexOf(" "));
						System.out.println("TotalHours : "+totalHours);
						list.add(totalHours+0);
						String totalFuel = driver.findElement(By.xpath(Object.getProperty("TotalFuel"))).getText();
						System.out.println("fuel : "+totalFuel);
						String totalFuels=totalFuel.substring(totalFuel.indexOf("(")+1, totalFuel.indexOf("l")-1);
						System.out.println("Total Fuels : "+totalFuels);
						list.add(totalFuels);
					//	String ureaLvl=driver.findElement(By.xpath(Object.getProperty("UreaValue"))).getText();
					//	System.out.println("Urea value : "+ureaLvl);
					//	list.add(ureaLvl);
						System.out.println("Array Size : "+list.size());
						for(String text : list)
						{
							System.out.println("Asset Details : "+text);
						}
						Actions action = new Actions(driver);
						WebElement Fleet=driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[1]/table/tbody/tr/td[2]/div/div/ul/li[1]/a"));	
						action.moveToElement(Fleet);
						action.click().perform();
						Thread.sleep(1000);
						driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[1]/table/tbody/tr/td[2]/div/div/ul/li[1]/div/div[1]/ul/li[1]/a")).click();
						Thread.sleep(10000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(5000);
						WebElement ele = driver.findElement(By.xpath(Object.getProperty("Searialsearch")));
						ele.sendKeys(asset);
						Thread.sleep(2000);
						WebElement select = driver.findElement(By.id("ui-id-2"));
						List<WebElement> options = select.findElements(By.className("ui-corner-all"));
						System.out.println(options.size());
						for (WebElement option : options) 
						{	 	  
							System.out.println(option.getText());
							if(option.getText().equals(asset)) 
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
						String fleetType=driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/table/tbody/tr/td/div[2]/div/div[2]/div[6]/table/tbody/tr[2]/td[2]/div/img")).getAttribute("src");
						System.out.println("Fleet Type : "+fleetType);
						fleetList.add(fleetType);
						WebElement element=driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/table/tbody/tr/td/div[2]/div/div[2]/div[1]/table/tbody/tr[2]"));
						List<WebElement> elementList=element.findElements(By.tagName("td"));
						for(int k=2;k<elementList.size();k++)
						{
					//		System.out.println("Fleet :  "+elementList.get(k).getText());
							fleetList.add(elementList.get(k).getText());
						}
						System.out.println("Fleet Size : "+fleetList.size());
						for(String text : fleetList)
						{
							System.out.println("Fleet Status  : "+text);
						}
						
						for(int m=0;m<list.size();m++)
						{
							if(list.get(m).equalsIgnoreCase(fleetList.get(m)))
							{
								System.out.println("Array pass");
								flag=1;
							}
							else
							{
								System.out.println("Asset Detail page is details is not match with fleet status page.");
								acop = "Asset Detail page is details is not match with fleet status page.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 4 execution completed############################");
								break;
							}
						}
						if(flag==1)
						{
							System.out.println("Asset detail page is values matching with fleet status page.");
							acop = "Asset detail page is values matching with fleet status page.";
							node.log(LogStatus.PASS, acop);
							data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
							System.out.println( "###################Test case 4 execution completed############################");
						}
						Thread.sleep(5000);
						driver.findElement(By.partialLinkText(asset)).click();
						Thread.sleep(5000);
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
				
				//Details tab.
				if(d2[i][0].equalsIgnoreCase("TC5"))
				{	
					try
					{
						System.out.println( "###################Test case 5 is executing############################");
						AddFilter.assetDetails("PIDTP320EOMF70854");
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("AssetDetailsTab"))).click();
						Thread.sleep(5000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("DetailsTerminalLink")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("DetailsGeneralInfo")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("DetailsStatus")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("DetailsSensors")), driver))
						{
							System.out.println("Details pass");
							driver.findElement(By.xpath(Object.getProperty("DetailsTerminalLink"))).click();
							Thread.sleep(5000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("TerminalIdProfileTab")), driver))
							{
								System.out.println("profile pass");
								driver.findElement(By.xpath(Object.getProperty("TermianlClose"))).click();
								Thread.sleep(5000);
								System.out.println("Terminal link working as Expected.");
								acop = "Terminal link working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 5 execution completed############################");
							}
						}
						else
						{
							System.out.println("Details tab is not displaying properly.");
							acop = "Asset Detail page is details is not match with fleet status page.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 5 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				//Detail is fleet status verify
				if(d2[i][0].equalsIgnoreCase("TC6"))
				{	
					try
					{
						System.out.println( "###################Test case 6 is executing############################");
						AddFilter.assetDetails("PIDTP320EOMF70854");
						String asset=d2[5][4];
						int flag=0,flag1=0,flag2=0;
						ArrayList<String> generalArray=new ArrayList<String>();
						ArrayList<String> statusArray=new ArrayList<String>();
						ArrayList<String> sensorArray=new ArrayList<String>();
						ArrayList<String> sensorfArray=new ArrayList<String>();
						ArrayList<String> statusfArray=new ArrayList<String>();
						ArrayList<String> generalfArray=new ArrayList<String>();
						ArrayList<String> terminalArray=new ArrayList<String>();
						ArrayList<String> terminalfArray=new ArrayList<String>();
						driver.findElement(By.xpath(Object.getProperty("AssetDetailsTab"))).click();
						Thread.sleep(5000);
						WebElement generalInfo=driver.findElement(By.xpath(Object.getProperty("DetailsGeneralInfo")));
						List<WebElement>generalInfoList = generalInfo.findElements(By.tagName("tr"));
						System.out.println("Size : "+generalInfoList.size());
						for(WebElement text : generalInfoList)
						{
							System.out.println("General : "+text.getText());
							generalArray.add(text.getText());
						}
						for(String text : generalArray)
						{
							System.out.println("text : "+text);
						}
						WebElement status=driver.findElement(By.xpath(Object.getProperty("DetailsStatus")));
						List<WebElement>statusList=status.findElements(By.tagName("tr"));
						for(WebElement text : statusList)
						{
							System.out.println("Status List : "+text.getText());
							statusArray.add(text.getText());
						}
						for(String text : statusArray)
						{
							System.out.println("Status Array : "+text);
						}
						
						WebElement sensor=driver.findElement(By.xpath(Object.getProperty("DetailsSensors")));
						List<WebElement>sensorList=sensor.findElements(By.tagName("tr"));
						for(WebElement text : sensorList)
						{
							System.out.println("Status List : "+text.getText());
							sensorArray.add(text.getText());
						}
						for(String text : sensorArray)
						{
							System.out.println("Sensor Arrays : "+text);
						}
						//Terminal Profile
						driver.findElement(By.xpath(Object.getProperty("DetailsTerminalLink"))).click();
						Thread.sleep(5000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("TerminalIdProfileTab")), driver))
						{
							WebElement terminal=driver.findElement(By.xpath(Object.getProperty("TerminalIdProfileTab")));
							List<WebElement>terminalList=terminal.findElements(By.tagName("tr"));
							for(WebElement text : terminalList)
							{
								System.out.println("Terminal : "+text.getText());
								terminalArray.add(text.getText());
							}
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("TermianlClose"))).click();
						}
						Actions action = new Actions(driver);
						WebElement Fleet=driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[1]/table/tbody/tr/td[2]/div/div/ul/li[1]/a"));	
						action.moveToElement(Fleet);
						action.click().perform();
						Thread.sleep(1000);
						driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[1]/table/tbody/tr/td[2]/div/div/ul/li[1]/div/div[1]/ul/li[1]/a")).click();
						Thread.sleep(10000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(5000);
						WebElement ele = driver.findElement(By.xpath(Object.getProperty("Searialsearch")));
						ele.sendKeys(asset);
						Thread.sleep(2000);
						WebElement select = driver.findElement(By.id("ui-id-2"));
						List<WebElement> options = select.findElements(By.className("ui-corner-all"));
						System.out.println(options.size());
						for (WebElement option : options) 
						{	 	  
							System.out.println(option.getText());
							if(option.getText().equals(asset)) 
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
						driver.findElement(By.xpath(Object.getProperty("FullDetails"))).click();
						Thread.sleep(2000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(3000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("FleetDetails")), driver))
						{
							WebElement generalfInfo=driver.findElement(By.xpath(Object.getProperty("FleetGeneralInfo")));
							List<WebElement>generalfInfoList = generalfInfo.findElements(By.tagName("tr"));
							System.out.println("Size : "+generalfInfoList.size());
							for(WebElement text : generalfInfoList)
							{
								System.out.println(" Fleet General : "+text.getText());
								generalfArray.add(text.getText());
							}
							for(String text : generalfArray)
							{
								System.out.println("Fleet Array : "+text);
							}
						
							WebElement statusf=driver.findElement(By.xpath(Object.getProperty("FleetStatus")));
							List<WebElement>statusfList=statusf.findElements(By.tagName("tr"));
							for(WebElement text : statusfList)
							{
								System.out.println("Fleet Status List : "+text.getText());
								statusfArray.add(text.getText());
							}
							for(String text : statusfArray)
							{
								System.out.println("Fleet Status Array : "+text);
							}
						
							WebElement sensorf=driver.findElement(By.xpath(Object.getProperty("FleetSensors")));
							List<WebElement>sensorfList=sensorf.findElements(By.tagName("tr"));
							for(WebElement text : sensorfList)
							{
								System.out.println("Fleet Status List : "+text.getText());
								sensorfArray.add(text.getText());
							}
							for(String text : sensorfArray)
							{
								System.out.println("Fleet Sensor Arrays : "+text);
							}
							//Fleet Terminal 
							driver.findElement(By.xpath(Object.getProperty("FleetTerminalLink"))).click();
							Thread.sleep(5000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("FleetTerminalTab")), driver))
							{
								WebElement terminal=driver.findElement(By.xpath(Object.getProperty("FleetTerminalTab")));
								List<WebElement>terminalList=terminal.findElements(By.tagName("tr"));
								for(WebElement text : terminalList)
								{
									System.out.println("Terminal : "+text.getText());
									terminalfArray.add(text.getText());
								}
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("FleetTerminalClose"))).click();
							}
							
							//General Info 
							for(int j=0;j<generalArray.size();j++)
							{
								if(generalArray.get(j).equalsIgnoreCase(generalfArray.get(j)))
								{
									flag=1;
									System.out.println("General Info Details value is matching with fleet status");
								}
								else
								{
									flag=0;
									System.out.println("GeneralInfo Details is not match with fleet status value.");
									acop = "GeneralInfo Details is not match with fleet status value.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 6 execution completed############################");

									break;
								}
							}
						
							//Status
							for(int j=0;j<statusArray.size();j++)
							{
								if(statusArray.get(j).equalsIgnoreCase(statusfArray.get(j)))
								{
									System.out.println("Status Details value is matching with fleet status");
									flag1=1;
								}
								else
								{
									flag1=0;
									System.out.println("Status Array fail");
									acop = "Status Details is not match with fleet status value.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 6 execution completed############################");
									break;
								}
							}
					
							//Sensors 
							for(int j=0;j<sensorArray.size();j++)
							{
								if(sensorArray.get(j).equalsIgnoreCase(sensorfArray.get(j)))
								{
									System.out.println("Sensor Details value is matching with fleet status");
									flag2=1;
								}
								else
								{
									flag2=0;
									System.out.println("Sensor Detais is not match with fleet status value.");
									acop = "Sensor Details is not match with fleet status value.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 6 execution completed############################");
									break;
								}
							}
							
							//Fleet Terminal
						/*	for(int j=0;j<terminalArray.size();j++)
							{
								if(terminalArray.get(j).equalsIgnoreCase(terminalfArray.get(j)))
								{
									System.out.println("Terminal Array Pass");
								}
								else
								{
									System.out.println("Terminal Array Fail");
								}
							}*/
							if(flag==1)
							{
								acop = "General Info Details value is matching with fleet status.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 6 execution completed############################");
							}
							if(flag1==1)
							{
								acop = "Status Details value is matching with fleet status.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 6 execution completed############################");
							}
							if(flag2==1)
							{
								acop = "Sensor Details value is matching with fleet status.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 6 execution completed############################");
							}
							
							driver.findElement(By.xpath(Object.getProperty("FullDetailsClose"))).click();
							Thread.sleep(5000);
							driver.findElement(By.partialLinkText(asset)).click();
							Thread.sleep(5000);
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
				
				if(d2[i][0].equalsIgnoreCase("TC7"))
				{	
					try
					{
						System.out.println( "###################Test case 7 is executing############################");
						String date=d2[6][4];
						String [] dateArray=date.split(",");
						AddFilter.assetDetails("PIDTP320EOMF70854");
						for(int j=1;j<=dateArray.length;j++)
						{
							WebElement options = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul"));
							List<WebElement> li = options.findElements(By.cssSelector("[id^=lnk]"));
							String text=li.get(j-1).getAttribute("innerHTML");
							System.out.println("Inner Date : "+text);
							if(text.equalsIgnoreCase(dateArray[j-1]))
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
								if(text.equalsIgnoreCase("Today"))
								{
									driver.findElement(By.xpath(Object.getProperty("UtilizationTab"))).click();
									Thread.sleep(2000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(3000);
									String d=driver.findElement(By.xpath(Object.getProperty("UtilOpHrOneDay"))).getText();
									d=d.substring(d.indexOf("(")+1, d.indexOf(")"));
									System.out.println("Web Date : "+d);
									String datetoday=t.date(text);
									String dateToday=datetoday.substring(0, datetoday.lastIndexOf("/"));
									System.out.println("Date Today : "+dateToday);
									if(d.equalsIgnoreCase(dateToday))
									{
										System.out.println("Today date working as expected.");
										acop = "Today date working as expected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 7 execution completed############################");
									}
									else
									{
										System.out.println("Today date selecting is not working as Expected.");
										acop = "Today date selecting is not working as Expected.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 7 execution completed############################");										
									}
								}
								else if(text.equalsIgnoreCase("Yesterday"))
								{
									driver.findElement(By.xpath(Object.getProperty("UtilizationTab"))).click();
									Thread.sleep(2000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(3000);
									String d=driver.findElement(By.xpath(Object.getProperty("UtilOpHrOneDay"))).getText();
									d=d.substring(d.indexOf("(")+1, d.indexOf(")"));
									System.out.println("Web Date : "+d);
									String datetoday=t.date("Today-1");
									String dateToday=datetoday.substring(0, datetoday.lastIndexOf("/"));
									System.out.println("Date Today : "+dateToday);
									if(d.equalsIgnoreCase(dateToday))
									{
										System.out.println("Yesterday date selecting working as expected.");
										acop = "Yesterday date selecting working as expected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 7 execution completed############################");
									}
									else
									{
										System.out.println("Yesterday date selecting is not working as Expected.");
										acop = "Yesterday date selecting is not working as Expected.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 7 execution completed############################");
									}	
								}
								else if(text.equalsIgnoreCase("Last Week"))
								{
									driver.findElement(By.xpath(Object.getProperty("UtilizationTab"))).click();
									Thread.sleep(2000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(3000);
									String d=driver.findElement(By.xpath(Object.getProperty("UtilopHrSevenDay"))).getText();
									System.out.println("D : "+d);
									d=d.substring( d.indexOf("(")+1,d.lastIndexOf(")"));
									System.out.println("Web Last Week : "+d);
									String lastWeekDate = t.lastWeekDate();
									System.out.println("Last Week : "+lastWeekDate);
									if(d.equalsIgnoreCase(lastWeekDate))
									{
										System.out.println("LastWeek date selecting working as expected.");
										acop = "LastWeek date selecting working as expected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 7 execution completed############################");
									}
									else
									{
										System.out.println("LastWeek date selecting is not working as Expected.");
										acop = "LastWeek date selecting is not working as Expected.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 7 execution completed############################");
									}
								}
								else if(text.equalsIgnoreCase("Last Month"))
								{
									driver.findElement(By.xpath(Object.getProperty("UtilizationTab"))).click();
									Thread.sleep(2000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(3000);
									String d=driver.findElement(By.xpath(Object.getProperty("UtilOpHrThirtyDays"))).getText();
									System.out.println("D : "+d);
									d=d.substring( d.indexOf("(")+1,d.lastIndexOf(")"));
									System.out.println("Web Last Month : "+d);
									String lastMonthDate = t.lastMonthDate();
									System.out.println("Last Week : "+lastMonthDate);
									if(d.equalsIgnoreCase(lastMonthDate))
									{
										System.out.println("LastMonth date selecting working as expected.");
										acop = "LastMonth date selecting working as expected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 7 execution completed############################");
									}
									else
									{
										System.out.println("LastMonth date selecting is not working as Expected.");
										acop = "LastMonth date selecting is not working as Expected.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 7 execution completed############################");
									}
								}
									 
									
							}
							else
							{
								System.out.println(dateArray[j-1]+" Dafault Date Missing");			
								acop = dateArray[j-1]+" Dafault Date Missing";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 7 execution completed############################");
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				if(d2[i][0].equalsIgnoreCase("TC8"))
				{	
					try
					{
						System.out.println( "###################Test case 8 is executing############################");
						String date=d2[7][4];
						String [] dateArray=date.split(",");
						String startDate =t.date(d2[7][5]);
						String endDate = t.date(d2[7][6]);
						int j=0;
						AddFilter.assetDetails("PIDTP320EOMF70854");
						driver.findElement(By.xpath(Object.getProperty("UtilizationTab"))).click();
						Thread.sleep(2000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(3000);
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
							driver.findElement(By.xpath(Object.getProperty("EngineUsagePopup"))).click();
							Thread.sleep(10000);
							WebElement egnDate = driver.findElement(By.xpath(Object.getProperty("EngineDate")));
							List<WebElement> egnDateList = egnDate.findElements(By.tagName("text"));
							for(WebElement text : egnDateList)
							{
								//System.out.println(text.getText());
							}
							String startDateWeb = egnDateList.get(0).getText();
							String endDateWeb = egnDateList.get(egnDateList.size()-1).getText();
							startDate=startDate.substring(0, startDate.lastIndexOf("/"));
							endDate = endDate.substring(0, endDate.lastIndexOf("/"));
							System.out.println("Start Date : "+startDate);
							System.out.println("End Date : "+ endDate);
							String commanDate = startDate + " - " + endDate;
							String webDate =startDateWeb + " - " + endDateWeb;
							if(commanDate.equalsIgnoreCase(webDate))
							{
								System.out.println("Custom date selecting working as expected.");
								acop = "Custom date selecting working as expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 8 execution completed############################");
							}
							else
							{
								System.out.println("Custom date is not working as Expected.");
								acop = "Custom date is not working as Expected.";
								node.log(LogStatus.FAIL, acop);
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 8 execution completed############################");
							}
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("EngineClose"))).click();
							Thread.sleep(5000);
						}
						else
						{
							System.out.println("Custom date is not displaying properly.");
							acop = "Custom date is not displaying properly.";
							node.log(LogStatus.FAIL, acop);
							data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 8 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				if(d2[i][0].equalsIgnoreCase("TC9"))
				{	
					try
					{
						System.out.println( "###################Test case 9 is executing############################");
						String op=d2[8][4];
						String [] opArray=op.split(",");
						String startDate =t.date(d2[8][5]);
						String endDate = t.date(d2[8][6]);
						int j=0;
						AddFilter.assetDetails("PIDTP320EOMF70854");
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("UtilizationTab")), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("UtilizationTab"))).click();
							Thread.sleep(2000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(3000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("AssetDetailsPageMap")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UtilOperatingHoursTab")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("UtilFuelTab")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EngineUsageTab")), driver))
							{
								System.out.println("Utilzation tab displaying.");
								//Operating Hour Verify
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("UtilOpHrOneDay")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UtilopHrSevenDay")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("UtilOpHrThirtyDays")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UtilOpHrLifeTime")), driver))
								{
									System.out.println("operating is displaying.");
									String oneDay=driver.findElement(By.xpath(Object.getProperty("UtilOpHrOneDayText"))).getText();
									System.out.println("One day : "+oneDay);
									if(!oneDay.equalsIgnoreCase("No data for this time period."))
									{
										System.out.println("Data");
										oneDay=oneDay.substring(oneDay.indexOf(":")+2, oneDay.indexOf("H"));
										System.out.println("In Last month : "+oneDay);
										driver.findElement(By.xpath(Object.getProperty("SensorTab"))).click();
										Thread.sleep(2000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(3000);
										AddFilter.customDate(startDate, endDate);
										Thread.sleep(5000);
									    ArrayList<Float> val = new ArrayList<Float>();
										for(int k=0;k<opArray.length;k++)
										{
										   	float presentDayValue =AddFilter.dashboardValue(opArray[k],"2");
										   	System.out.println("Float : "+presentDayValue);
										   	val.add(presentDayValue);
										}
										System.out.println("Array Size : "+val.size());
										float workHours = val.get(0);
										float idleHours = val.get(1);
										float trackHours = val.get(2);
										float totalHours = workHours+idleHours+trackHours;
										System.out.println("Total : "+totalHours);
										float onefDay=Float.parseFloat(oneDay);
										if(onefDay==totalHours)
										{
											System.out.println("Operating hour one day is matching with sensors.");
											acop = "Operating hour one day is matching with sensors.";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
											rc++;
											s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
											System.out.println( "###################Test case 9 execution completed############################");
										}
										else
										{
											System.out.println("Operating hour one day is not match with sensors.");
											acop = "Operating hour one day is not match with sensors.";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 9 execution completed############################");
										}
										driver.findElement(By.xpath(Object.getProperty("UtilizationTab"))).click();
										Thread.sleep(2000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(3000);
									}
									else
									{
										System.out.println("No data for this time period.");
										acop = "No data for this time period.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 9 execution completed############################");
									}
									
									//Seven Day
									String lastWeek=driver.findElement(By.xpath(Object.getProperty("UtilopHrSevenDayText"))).getText();
									System.out.println("last Week : "+lastWeek);
									if(!lastWeek.equalsIgnoreCase("No data for this time period."))
									{
										System.out.println("Data");
										lastWeek=lastWeek.substring(lastWeek.indexOf(":")+2, lastWeek.indexOf("H"));
										System.out.println("In Last month : "+lastWeek);
										driver.findElement(By.xpath(Object.getProperty("SensorTab"))).click();
										Thread.sleep(2000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(3000);
										AddFilter.customDate(t.date("Today-6"), t.date("Today"));
										Thread.sleep(5000);
									    ArrayList<Float> val = new ArrayList<Float>();
										for(int k=0;k<opArray.length;k++)
										{
										   	float presentDayValue =AddFilter.dashboardValue(opArray[k],"2");
										   	System.out.println("Float : "+presentDayValue);
										   	val.add(presentDayValue);
										}
										System.out.println("Array Size : "+val.size());
										float workHours = val.get(0);
										float idleHours = val.get(1);
										float trackHours = val.get(2);
										float totalHours = workHours+idleHours+trackHours;
										System.out.println("Total : "+totalHours);
										float lastfWeek=Float.parseFloat(lastWeek);
										if(lastfWeek==totalHours)
										{
											System.out.println("Operating hour seven day is matching with sensors.");
											acop = "Operating hour seven day is matching with sensors.";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
											rc++;
											s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
											System.out.println( "###################Test case 9 execution completed############################");
										}
										else
										{
											System.out.println("Operating hours seven days is not match with sensors.");
											acop = "Operating hours seven days is not match with sensors.";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 9 execution completed############################");
										}
										driver.findElement(By.xpath(Object.getProperty("UtilizationTab"))).click();
										Thread.sleep(2000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(3000);
									}
									else
									{
										System.out.println("No data for this time period.");
										acop = "No data for this time period.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 9 execution completed############################");
									}
									
									//Thirty Days.
									String lastMonth=driver.findElement(By.xpath(Object.getProperty("UtilOpHrThirtyDaysText"))).getText();
									System.out.println("last Week : "+lastMonth);
									if(!lastMonth.equalsIgnoreCase("No data for this time period."))
									{
										System.out.println("Data");
										lastMonth=lastMonth.substring(lastMonth.indexOf(":")+2, lastMonth.indexOf("H"));
										System.out.println("In Last month : "+lastMonth);
										driver.findElement(By.xpath(Object.getProperty("SensorTab"))).click();
										Thread.sleep(2000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(3000);
										AddFilter.customDate(t.date("Today-29"), t.date("Today"));
										Thread.sleep(5000);
									    ArrayList<Float> val = new ArrayList<Float>();
										for(int k=0;k<opArray.length;k++)
										{
										   	float presentDayValue =AddFilter.dashboardValue(opArray[k],"2");
										   	System.out.println("Float : "+presentDayValue);
										   	val.add(presentDayValue);
										}
										System.out.println("Array Size : "+val.size());
										float workHours = val.get(0);
										float idleHours = val.get(1);
										float trackHours = val.get(2);
										float totalHours = workHours+idleHours+trackHours;
										System.out.println("Total : "+totalHours);
										float lastfMonth=Float.parseFloat(lastMonth);
										if( lastfMonth==totalHours)
										{
											System.out.println("Operating hour thirty day is matching with sensors.");
											acop = "Operating hour thirty day is matching with sensors.";
											node.log(LogStatus.PASS, acop);
											data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
											rc++;
											s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
											System.out.println( "###################Test case 9 execution completed############################");
										}
										else
										{
											System.out.println("Operating hours is Thirty day is not match with sensor.");
											acop = "Operating hours is Thirty day is not match with sensor.";
											node.log(LogStatus.FAIL, acop);
											data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 9 execution completed############################");
										}
										driver.findElement(By.xpath(Object.getProperty("UtilizationTab"))).click();
										Thread.sleep(2000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(3000);
									}
									else
									{
										System.out.println("No data for this time period.");
										acop = "No data for this time period.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 9 execution completed############################");
									}
									
								}
								else
								{
									System.out.println("Operating hours is not displaying.");
									acop = "Operating hours is not displaying.";
									node.log(LogStatus.FAIL, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 9 execution completed############################");
								}
								
								//Fuel
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("FuelOneDay")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("FuelSevenDays")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("FuelThirtyDays")), driver))
								{
									String fuelOneDay = driver.findElement(By.xpath(Object.getProperty("FuelOneDay"))).getText();
									System.out.println("Fuel One Day : "+fuelOneDay);
									String fuelSevenDays = driver.findElement(By.xpath(Object.getProperty("FuelSevenDays"))).getText();
									System.out.println("Fuel Seven  Days : "+fuelSevenDays);
									String fuelThirtyDays = driver.findElement(By.xpath(Object.getProperty("FuelThirtyDays"))).getText();
									System.out.println("Fuel Thirty Days : "+fuelThirtyDays);
									//Fuel one day
									driver.findElement(By.xpath(Object.getProperty("SensorTab"))).click();
									Thread.sleep(2000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(3000);
									AddFilter.customDate(startDate, endDate);
									Thread.sleep(5000);
									float fuelfOneDay =AddFilter.dashboardValue("Fuel Used","2");
									System.out.println("Float : "+fuelfOneDay);
									//fuel Seven day
									AddFilter.customDate(t.date("Today-6"), t.date("Today"));
									Thread.sleep(5000);
									float fuelfSevenDay =AddFilter.dashboardValue("Fuel Used","2");
									System.out.println("Float Sevenday : "+fuelfSevenDay);
									AddFilter.customDate(t.date("Today-29"), t.date("Today"));
									Thread.sleep(5000);
									float fuelfThirtyDay =AddFilter.dashboardValue("Fuel Used","2");
									System.out.println("Float Thirty days : "+fuelfThirtyDay);
									
									//Fuel One Day Verify
									float onefDay=Float.parseFloat(fuelOneDay);
									System.out.println("onef : "+onefDay);
									if(onefDay==fuelfOneDay)
									{
										System.out.println("fuel one day is matching with sensors.");
										acop = "fuel one day is matching with sensors.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 9 execution completed############################");
									}
									else
									{
										System.out.println("Fuel One day value is not match with sensor.");
										acop = "Fuel One day value is not match with sensor.";
										node.log(LogStatus.FAIL, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 9 execution completed############################");
									}
									
									//Fuel Seven Day Verify
									float sevenfDay=Float.parseFloat(fuelSevenDays);
									System.out.println("sevenf : "+sevenfDay);
									if(sevenfDay==fuelfSevenDay)
									{
										System.out.println("fuel seven day is matching with sensors.");
										acop = "fuel seven day is matching with sensors.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 9 execution completed############################");
									}
									else
									{
										System.out.println("Fuel Seven day fuel Fail");
										acop = "Fuel seven day is not match with sensor.";
										node.log(LogStatus.FAIL, acop);	
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 9 execution completed############################");
									}
									
									//Fuel Thirty day verify.
									float thirtyfDay=Float.parseFloat(fuelThirtyDays);
									System.out.println("thirtyf : "+thirtyfDay);
									if(thirtyfDay==fuelfThirtyDay)
									{
										System.out.println("Fuel thirty day is matching with sensors.");
										acop = "Fuel thirty day is matching with sensors.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 9 execution completed############################");
									}
									else
									{
										System.out.println("Fuel Thirty hour is not match with sensor.");
										acop = "Fuel Thirty hour is not match with sensor.";
										node.log(LogStatus.FAIL, acop);	
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 9 execution completed############################");
									}
								}
								else
								{
									System.out.println("Fuel dashboard is not displaying properly.");
									acop = "Fuel dashboard is not displaying properly.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 9 execution completed############################");
								}
								
								driver.findElement(By.xpath(Object.getProperty("UtilizationTab"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
								
								//Engine Usage.
								driver.findElement(By.xpath(Object.getProperty("EngineExcelDownload"))).click();
								Thread.sleep(10000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(15000);
								Robot robot = new Robot();
								robot.keyPress(KeyEvent.VK_DOWN);
								Thread.sleep(500);
								robot.keyRelease(KeyEvent.VK_DOWN);
								Thread.sleep(500);
								robot.keyPress(KeyEvent.VK_ENTER);
								Thread.sleep(500);
								robot.keyRelease(KeyEvent.VK_ENTER);
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("TransactionTab"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
								driver.findElement(By.xpath(Object.getProperty("TransactionExcelDownload"))).click();
								Thread.sleep(10000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(15000);
								robot.keyPress(KeyEvent.VK_DOWN);
								Thread.sleep(500);
								robot.keyRelease(KeyEvent.VK_DOWN);
								Thread.sleep(500);
								robot.keyPress(KeyEvent.VK_ENTER);
								Thread.sleep(500);
								robot.keyRelease(KeyEvent.VK_ENTER);
								Thread.sleep(5000);
								String excelFilePath = "D:\\workspace\\FleetEdge\\DownloadExcel\\TransactionHistory.xls";
								String excelFilePath1 = "D:\\workspace\\FleetEdge\\DownloadExcel\\Engine Status.xlsx";
								int loopingtime = Utildashboard.loopIncrement(excelFilePath,"TransactionHistory");
								ArrayList<String>list=new ArrayList();
								ArrayList<String>list1=new ArrayList();
								ArrayList<String>list2=new ArrayList();
								ArrayList<String>list3=new ArrayList();
								ArrayList<String>list4=new ArrayList();
								SimpleDateFormat format = new SimpleDateFormat("d/MM/yy hh:mm");
								SimpleDateFormat format1 = new SimpleDateFormat("MM/dd/yy HH:mm");
								SimpleDateFormat format2 = new SimpleDateFormat("dd/MM/yy hh:mm");
								SimpleDateFormat format3 = new SimpleDateFormat("dd/MM/yy hh:mm");
								SimpleDateFormat format4 = new SimpleDateFormat("d/MM/yy hh:mm");
								for(int l=0;l<loopingtime;l++)
								{
									String val=Utildashboard.excelRead(excelFilePath, l+1, "Data","TransactionHistory",1);	
									list.add(val);
								}
								for(int m=0;m<list.size();m++)
								{
									String chk=list.get(m).toString();
									String [] chkArray=chk.split(",");
									for(int l=0;l<chkArray.length;l++)
									{
										if(chkArray[l].equalsIgnoreCase(" EngOn"))
										{
											String val1=Utildashboard.excelRead(excelFilePath, m+1, "Transaction Date","TransactionHistory",1);
											list1.add(val1);
										}
										else if(chkArray[l].equalsIgnoreCase(" EngOff"))
										{
											String val1=Utildashboard.excelRead(excelFilePath, m+1, "Transaction Date","TransactionHistory",1);
											list4.add(val1);
										}
									}
								}
								Collections.reverse(list4);
								Collections.reverse(list1);
								int loopingtime1 = Utildashboard.loopIncrement(excelFilePath1,"Engine Status");
								for(int l=0;l<loopingtime1;l++)
								{
									int run=l+1;
									String eng=Utildashboard.excelRead(excelFilePath1, run, "Engine On Time","Engine Status",0);
									if(!eng.equalsIgnoreCase(""))
									{
										list2.add(eng);
									}
									String val1=Utildashboard.excelRead(excelFilePath1, run, "Engine Off Time","Engine Status",0);
									if(!val1.equalsIgnoreCase(""))
									{
										list3.add(val1);
									}
								}
								for(int n=0;n<list2.size();n++)
								{
									if(format.format(format2.parse(list1.get(n))).equals(format.format(format1.parse(list2.get(n)))))
									{
										System.out.println("Engine On Date is match with transaction.");
										acop = "Engine On Date is match with transaction.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 9 execution completed############################");
									}
									else
									{
										System.out.println("Engine On Date is not match with transaction "+format.format(format2.parse(list1.get(n))));
										acop = "Engine On Date is not match with transaction "+format.format(format2.parse(list1.get(n)));
										node.log(LogStatus.FAIL, acop);	
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 9 execution completed############################");
									}
								}
								for(int n=0;n<list3.size();n++)
								{
							//		System.out.println(format.format(format1.parse(list4.get(n))));
							//		System.out.println(format3.format(format4.parse(list3.get(n))));
									if(format3.format(format4.parse(list4.get(n))).equalsIgnoreCase(format2.format(format1.parse(list3.get(n)))))
									{
										System.out.println("Engine Off Date is match with transaction.");
										acop = "Engine On Date is match with transaction.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 9 execution completed############################");
									}
									else
									{
										System.out.println("Engine Off Date is not match with transaction "+format3.format(format4.parse(list4.get(n))));
										acop = "Engine Start Date is not match with transaction "+format3.format(format4.parse(list4.get(n)));
										node.log(LogStatus.FAIL, acop);	
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 9 execution completed############################");
									}
								}
							}
							else
							{
								System.out.println("Utilization tab is not displaying properly.");
								acop = "Utilization tab is not displaying properly.";
								node.log(LogStatus.FAIL, acop);	
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 9 execution completed############################");
							}
						}
						else
						{
							System.out.println("Utilization Tab is not displaying.");
							acop = "Utilization Tab is not displaying.";
							node.log(LogStatus.FAIL, acop);	
							data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 9 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
					driver.findElement(By.xpath(Object.getProperty("UtilizationTab"))).click();
					Thread.sleep(2000);
					while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
					{
						System.out.println("inside while");
						Thread.sleep(1000);
					}
					Thread.sleep(3000);
				}
				
				//Alarm Tab
				if(d2[i][0].equalsIgnoreCase("TC10"))
				{	
					try
					{
						System.out.println( "###################Test case 10 is executing############################");
						String alarm=d2[9][4];
						String [] alarmArray=alarm.split(",");
						String startDate =t.date(d2[9][5]);
						String endDate = t.date(d2[9][6]);
						String page=d2[9][3];
						String [] pageArray=page.split(",");
						int n=0;
						AddFilter.assetDetails("PIDTP320EOMF70854");
						driver.findElement(By.xpath(Object.getProperty("AlarmsTab"))).click();
						Thread.sleep(2000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(3000);
						AddFilter.customDate(t.date("Today"), t.date("Today"));
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("AllAlarmSourceDropdown")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("RequestAlarmsFromUnit")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmNotification")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmPrintReport")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmExportToExcel")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AssetDetailsPageMap")), driver))
						{
							System.out.println("alarm pass");
							//Alarm Dashboard verification.
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmStatus")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmSource")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmCode")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmDescription")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmActiveDate")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmLocation")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmManualClose")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmPriority")), driver))
							{
								System.out.println("Alarm Dashboard is displaying as Expected.");
								acop = "Alarm Dashboard is displaying as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 10 execution completed############################");
							}
							else if(t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmNoRecordFound")), driver))
							{
								System.out.println("No Records in the alarm dashboard.");
								acop = "No Record.";
								node.log(LogStatus.FAIL, acop);	
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 10 execution completed############################");
							}
							else
							{
								System.out.println("Some of Element Missing in the alarm Dashboard.");
								acop = "Some of Element Missing in the alarm Dashboard.";
								node.log(LogStatus.FAIL, acop);	
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 10 execution completed############################");
							}
							//Request Alarms From Unit.
							driver.findElement(By.xpath(Object.getProperty("RequestAlarmsFromUnit"))).click();
							Thread.sleep(2000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(3000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("RequestAlarmSuccessMessage")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("RequestAlarmCloseButton")), driver))
							{
								System.out.println("Request Alarm From Unit button working as Expected.");
								acop = "Request Alarm From Unit button working as Expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 10 execution completed############################");
							}
							else
							{
								System.out.println("While clicking Request Alarm from Unit button is not displaying the Success Message.");
								acop = "While clicking Request Alarm from Unit button is not displaying the Success Message.";
								node.log(LogStatus.FAIL, acop);	
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 10 execution completed############################");
							}
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("RequestAlarmCloseButton"))).click();
							Thread.sleep(2000);
							//Alarm Notification Settings.
							driver.findElement(By.xpath(Object.getProperty("AlarmNotification"))).click();
							Thread.sleep(5000);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmEventNotificationAlarm")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmAllCheckbox")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmHighCheckbox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmMediumCheckbox")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmLowCheckbox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmSubscriberButton")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmEventNotificationCloseButton")), driver))
							{
								System.out.println("Event Notification pass.");
								if(alarmArray[0].equalsIgnoreCase("All"))
								{
									driver.findElement(By.xpath(Object.getProperty("AlarmAllCheckbox"))).click();
								}
								else if(alarmArray[0].equalsIgnoreCase("High"))
								{
									driver.findElement(By.xpath(Object.getProperty("AlarmHighCheckbox"))).click();
								}
								else if(alarmArray[0].equalsIgnoreCase("Medium"))
								{
									driver.findElement(By.xpath(Object.getProperty("AlarmMediumCheckbox"))).click();
								}
								else if(alarmArray[0].equalsIgnoreCase("Low"))
								{
									driver.findElement(By.xpath(Object.getProperty("AlarmLowCheckbox"))).click();
								}
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("AlarmSubscriberButton"))).click();
								Thread.sleep(2000);
								if(t.isAlertPresent(driver))
								{
									driver.switchTo().alert().accept();
									acop = "Alarm Subscriber button working as Expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 10 execution completed############################");
								}
								else
								{
									System.out.println("Event Notification Alarm Subscription alert is not popups");
									acop = "Event Notification Alarm Subscription alert is not popups";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 10 execution completed############################");
								}
							}
							else
							{
								System.out.println("Event Notification button is not working as expected.");
								acop = "Event Notification button is not working as expected.";
								node.log(LogStatus.FAIL, acop);	
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 10 execution completed############################");
							}
							//All Alarm Source
							AddFilter.customDate(startDate, endDate);
							Thread.sleep(2000);
							for(n=1;n<alarmArray.length;n++)
							{
								WebElement source=driver.findElement(By.xpath(Object.getProperty("AllAlarmSourceDropdown")));
								List<WebElement>sourceList=source.findElements(By.tagName("option"));
								for(WebElement text : sourceList)
								{
									if(alarmArray[n].equalsIgnoreCase(text.getText()))
									{
										text.click();
										Thread.sleep(2000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(3000);
										if(!t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmDetailsNoRecordFound")), driver))
										{
											driver.findElement(By.xpath(Object.getProperty("AlarmExportToExcel"))).click();
											Thread.sleep(2000);
											while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
											{
												System.out.println("inside while");
												Thread.sleep(1000);
											}
											Thread.sleep(10000);
											Robot robot = new Robot();
											if(n==1)
											{
												robot.keyPress(KeyEvent.VK_DOWN);
												Thread.sleep(500);
												robot.keyRelease(KeyEvent.VK_DOWN);
												Thread.sleep(500);
												robot.keyPress(KeyEvent.VK_ENTER);
												Thread.sleep(500);
												robot.keyRelease(KeyEvent.VK_ENTER);
												Thread.sleep(5000);
											}
											else
											{
												robot.keyPress(KeyEvent.VK_ENTER);
												Thread.sleep(500);
												robot.keyRelease(KeyEvent.VK_ENTER);
												Thread.sleep(5000);
											} 
											String totalRows = driver.findElement(By.xpath(Object.getProperty("AlarmDashboardHeader"))).getAttribute("totalrows");
											System.out.println("TotalRows  paging : "+totalRows);
											String excelFilePath=null;
											if(n==1)
											{
												excelFilePath = "D:\\workspace\\FleetEdge\\DownloadExcel\\Alarms.xlsx";
											}
											else
											{
												n-=1;
												excelFilePath = "D:\\workspace\\FleetEdge\\DownloadExcel\\Alarms("+n+").xlsx";
												n+=1;
											}
											int loopingtime = Utildashboard.loopIncrement(excelFilePath,"Alarms");
											System.out.println("looping time : "+loopingtime);
											ArrayList<String>list=new ArrayList();
											for(int l=0;l<loopingtime;l++)
											{
												String val=Utildashboard.excelRead(excelFilePath, l+1, "Source","Alarms",0);	
												System.out.println("Val Source : "+val);
												list.add(val);
											}
											int m=0;
											System.out.println("Array Size : "+list.size());
											for(String ex : list)
											{
												m++;
												if(ex.equalsIgnoreCase(alarmArray[n]))
												{
													System.out.println("Excel Val :"+m+""+ex);
												}
											}
											int totalVal=Integer.parseInt(totalRows);
											if(m==totalVal)
											{
												System.out.println(alarmArray[n]+"is count is match with record.");
												acop = alarmArray[n]+"is count is match with record.";
												node.log(LogStatus.PASS, acop);
												data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
												rc++;
												s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
												System.out.println( "###################Test case 10 execution completed############################");
											}
											else
											{
												System.out.println(alarmArray[n]+"is count is not match with record.");
												acop = alarmArray[n]+"is count is not match with record.";
												node.log(LogStatus.FAIL, acop);	
												data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
												rc++;
												String scr = t.CaptureScreenshot();
												s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
												System.out.println( "###################Test case 10 execution completed############################");
											}
										}
										else
										{
											System.out.println("No data selected time period.");
											acop = "No data selected time period.";
											node.log(LogStatus.FAIL, acop);	
											data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
											rc++;
											String scr = t.CaptureScreenshot();
											s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
											System.out.println( "###################Test case 10 execution completed############################");
										}
										break;
									 }
								 }
							}
							//Print Report.
							String url1=driver.getCurrentUrl();
							System.out.println("url1 : "+url1);
							driver.findElement(By.xpath(Object.getProperty("AlarmPrintReport"))).click();
							Thread.sleep(6000);
							ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
							for(String tab : tabs2)
							{
								System.out.println("Array : "+tab);
							}
						    driver.switchTo().window(tabs2.get(1));
						    Thread.sleep(5000);	
							String url2=driver.getCurrentUrl();
							System.out.println("url2 : "+url2);
							url2=url2.substring(url2.indexOf("http:"), url2.length());
							System.out.println("After Convert "+url2) ;
							if(url1.equalsIgnoreCase(url2))
							{
								System.out.println("Print report button working as expected.");
								acop = "Print report button working as expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 10 execution completed############################");
							}
							else
							{
								System.out.println("While clicking print report it navigate to unexpected url.");
								acop = "While clicking print report it navigate to unexpected url.";
								node.log(LogStatus.FAIL, acop);	
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 10 execution completed############################");
							}
						    driver.close();
						    driver.switchTo().window(tabs2.get(0));
							
						    //Export to Excel
							Thread.sleep(3000);
							WebElement source=driver.findElement(By.xpath(Object.getProperty("AllAlarmSourceDropdown")));
							List<WebElement>sourceList=source.findElements(By.tagName("option"));
							for(WebElement text : sourceList)
							{
								if("All Alarm Source".equalsIgnoreCase(text.getText()))
								{
									text.click();
								}
							}
						//	AddFilter.customDate(startDate, endDate);
							Thread.sleep(2000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("AlarmExportToExcel"))).click();
							Thread.sleep(2000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(5000);
							Robot robot = new Robot();
						//	robot.keyRelease(KeyEvent.VK_DOWN);
							Thread.sleep(500);
							robot.keyRelease(KeyEvent.VK_DOWN);
							Thread.sleep(500);
							robot.keyPress(KeyEvent.VK_ENTER);
							Thread.sleep(500);
							robot.keyRelease(KeyEvent.VK_ENTER);
							Thread.sleep(5000);
							String totalRows = driver.findElement(By.xpath(Object.getProperty("AlarmDashboardHeader"))).getAttribute("totalrows");
							System.out.println("TotalRows : "+totalRows);
							String excelFilePath=null;
							n-=1; 
							excelFilePath = "D:\\workspace\\FleetEdge\\DownloadExcel\\Alarms("+n+").xlsx";
						//	n+=1;
							int loopingtime = Utildashboard.loopIncrement(excelFilePath,"Alarms");
							System.out.println("looping time : "+loopingtime);
							ArrayList<String>list=new ArrayList();
							for(int l=0;l<loopingtime;l++)
							{
								String val=Utildashboard.excelRead(excelFilePath, l+1, "Source","Alarms",0);	
								System.out.println("Val Source : "+val);
								list.add(val);
							}
							int totalVal=Integer.parseInt(totalRows);
							if(list.size()==totalVal)
							{
								System.out.println("Export to excel button working as expected.");
								acop = "Export to excel button working as expected.";
								node.log(LogStatus.PASS, acop);
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
								System.out.println( "###################Test case 10 execution completed############################");
							}
							else
							{
								System.out.println("Export to excel while its count is not match with data records");
								acop = "Export to excel while its count is not match with data records";
								node.log(LogStatus.FAIL, acop);	
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 10 execution completed############################");
							}
							
							//Paging
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmPageSize")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmPaging")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmGotoPage")), driver))
							{
								WebElement show=driver.findElement(By.xpath(Object.getProperty("AlarmPageSize")));
								List<WebElement> showList=show.findElements(By.tagName("option"));
								for(int m=1;m<pageArray.length;m++)
								{
									for(WebElement keep : showList)
									{
										if(keep.getText().equalsIgnoreCase(pageArray[m]))
										{
											keep.click();
											Thread.sleep(2000);
											while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
											{
												System.out.println("inside while");
												Thread.sleep(1000);
											}
											Thread.sleep(5000);
											show=driver.findElement(By.xpath(Object.getProperty("AlarmPageSize")));
											showList=show.findElements(By.tagName("option"));
											for(WebElement keep1 : showList)
											{
												if(keep1.getText().equalsIgnoreCase(pageArray[m]))
												{
													if(keep1.getAttribute("selected").equalsIgnoreCase("true"))
													{
														System.out.println("Selected.");
														WebElement row=driver.findElement(By.xpath("//*[@id='tblFleetStatusReport']/tbody"));
														List<WebElement> rowList=row.findElements(By.tagName("tr"));
														System.out.println("Row size : "+rowList.size() + " M : "+pageArray[m]);
														if(pageArray[m].equalsIgnoreCase(String.valueOf(rowList.size())))
														{
															System.out.println("Show Record dropdown working as expected.");
															acop = "Show Record dropdown working as expected.";
															node.log(LogStatus.PASS, acop);
															data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
															rc++;
															s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
															System.out.println( "###################Test case 10 execution completed############################");
														}
														else
														{
															System.out.println("Show row is not working as expected. its record count is mismatch with selected row.");
															acop = "Show row is not working as expected. its record count is mismatch with selected row.";
															node.log(LogStatus.FAIL, acop);	
															data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
															rc++;
															String scr = t.CaptureScreenshot();
															s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
															System.out.println( "###################Test case 10 execution completed############################");
														}
													}
													else
													{
														System.out.println("Show row dropdown is not working as expected.");
														acop = "Show row dropdown is not working as expected.";
														node.log(LogStatus.FAIL, acop);	
														data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
														rc++;
														String scr = t.CaptureScreenshot();
														s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
														System.out.println( "###################Test case 10 execution completed############################");
													}
													break;
												}
											}
											break;
										}
									}
								}
								//Page change.
								WebElement pag=driver.findElement(By.xpath(Object.getProperty("AlarmGotoPage")));
								List<WebElement> pageList=pag.findElements(By.tagName("option"));
								System.out.println("Size"+pageList.size() + pageArray[0]);
								for(WebElement text : pageList)
								{
									if(text.getText().equalsIgnoreCase(pageArray[0]))
									{
										text.click();
										Thread.sleep(2000);
										while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
										{
											System.out.println("inside while");
											Thread.sleep(1000);
										}
										Thread.sleep(5000);
										pag=driver.findElement(By.xpath(Object.getProperty("AlarmGotoPage")));
										pageList=pag.findElements(By.tagName("option"));
										for(WebElement text1 : pageList)
										{
											if(text1.getText().equalsIgnoreCase(pageArray[0]))
											{
												if(text1.getAttribute("selected").equalsIgnoreCase("true"))
												{
													System.out.println("Page selecting dropdown working as expected.");
													acop = "Page selecting dropdown working as expected.";
													node.log(LogStatus.PASS, acop);
													data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
													rc++;
													s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
													System.out.println( "###################Test case 10 execution completed############################");
												}
												else
												{
													System.out.println("Go to page dropdown is not working as expected.");
													acop = "Go to page dropdown is not working as expected.";
													node.log(LogStatus.FAIL, acop);	
													data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
													rc++;
													String scr = t.CaptureScreenshot();
													s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
													System.out.println( "###################Test case 10 execution completed############################");
												}
												break;
											}

										}
										break;
									}
								}
								
							}
							else
							{
								System.out.println("Enough data is not there to display paging or some of paging element missing.");
								acop = "Enough data is not there to display paging or some of paging element missing.";
								node.log(LogStatus.FAIL, acop);	
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 10 execution completed############################");
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				//Performance
				if(d2[i][0].equalsIgnoreCase("TC11"))
				{	
					try
					{
						System.out.println( "###################Test case 11 is executing############################");
						String performance=d2[10][4];
						String [] split=performance.split(",");
						String startDate =t.date(d2[10][5]);
						String endDate = t.date(d2[10][6]);
						String commonPath="D:\\workspace\\FleetEdge\\DownloadExcel\\";
						AddFilter.assetDetails("PIDTP320EOMF70854");
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("PerformanaceTab"))).click();
						Thread.sleep(2000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(3000);
						AddFilter.customDate(t.date("Today"), t.date("Today"));
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("ProductConveyorBelt")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("FuelUsageDashboard")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("AverageTPHDashboard")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TotalDailyProductionDashboard")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("FuelCostTextbox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("FuelCostSaveButton")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("TotalDailyProductionTonnage")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AssetDetailsPageMap")), driver))
						{
							String assetName=driver.findElement(By.xpath(Object.getProperty("AssetSummaryName"))).getText();
							System.out.println("Name : "+assetName);
							JavascriptExecutor jse = (JavascriptExecutor)driver;
					//		jse.executeScript("window.scrollBy(0,250)", "");							
					/*		if(t.isElementPresentcheck(By.xpath(Object.getProperty("ProductOneDay")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ProductSevenDays")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("ProductThirtyDays")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ProductMenu")), driver))
							{
								Robot r = new Robot();
							/*	driver.findElement(By.xpath(Object.getProperty("ProductMenu"))).click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("ProductPrintChart"))).click();
								Thread.sleep(5000);
								r.keyPress(KeyEvent.VK_ESCAPE);
								Thread.sleep(500);
								r.keyRelease(KeyEvent.VK_ESCAPE);
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("ProductMenu"))).click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("ProductPNG"))).click();
								Thread.sleep(5000);
								Utildashboard.downloadRobo();
								String productPNGPath=commonPath+assetName+"_"+split[0]+".png";
								System.out.println("Product PNG : "+productPNGPath);
								if(Utildashboard.fileExist(productPNGPath))
								{
									System.out.println("Png File Downloaded successfully.");
								}
								else
								{
									System.out.println("Unable to download the file Png.");
								}
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("ProductMenu"))).click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("ProductJPEG"))).click();
								Thread.sleep(5000);
								Utildashboard.downloadRobo();
								String productJPEGPath=commonPath+assetName+"_"+split[0]+".jpeg";
								System.out.println("Product PNG : "+productJPEGPath);
								if(Utildashboard.fileExist(productJPEGPath))
								{
									System.out.println("JPEG File Downloaded successfully.");
								}
								else
								{
									System.out.println("Unable to download the file JPEG.");
								}
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("ProductMenu"))).click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("ProductPDF"))).click();
								Thread.sleep(5000);
								Utildashboard.downloadRobo1();
								String productPDFPath=commonPath+assetName+"_"+split[0]+".pdf";
								System.out.println("Product PNG : "+productPDFPath);
								if(Utildashboard.fileExist(productPDFPath))
								{
									System.out.println("PDF File Downloaded successfully.");
								}
								else
								{
									System.out.println("Unable to download the file PDF.");
								}
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("ProductMenu"))).click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("ProductSVG"))).click();
								Thread.sleep(5000);
								Utildashboard.downloadRobo1();
								String productSVGPath=commonPath+assetName+"_"+split[0]+".svg";
								System.out.println("Product PNG : "+productSVGPath);
								if(Utildashboard.fileExist(productSVGPath))
								{
									System.out.println("SVG File Downloaded successfully.");
								}
								else
								{
									System.out.println("Unable to download the file SVG.");
								}
								Thread.sleep(5000);
								//Product One Day
								String productOneDay = driver.findElement(By.xpath(Object.getProperty("ProductOneDay"))).getText();
								System.out.println("One Day : "+productOneDay);
								driver.findElement(By.xpath(Object.getProperty("SensorTab"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
								AddFilter.customDate(t.date("Today"), t.date("Today"));
								Thread.sleep(5000);
								float presentDayValue =AddFilter.dashboardValue("Tonnage","2");
								System.out.println("Float : "+presentDayValue);
								if(presentDayValue == Float.parseFloat(productOneDay))
								{
									System.out.println("One Day Pass.");
								}
								else
								{
									System.out.println("One Day Fail."+Float.parseFloat(productOneDay));
								}
								
								//Product Seven Day
								driver.findElement(By.xpath(Object.getProperty("PerformanaceTab"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
								String productSevenDay = driver.findElement(By.xpath(Object.getProperty("ProductSevenDays"))).getText();
								System.out.println("One Seven : "+productSevenDay);
								driver.findElement(By.xpath(Object.getProperty("SensorTab"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
								AddFilter.customDate(t.date("Today-6"), t.date("Today"));
								Thread.sleep(5000);
								float presentDayValue1 =AddFilter.dashboardValue("Tonnage","2");
								System.out.println("Float : "+presentDayValue1);
								if(presentDayValue1 == Float.parseFloat(productSevenDay))
								{
									System.out.println("Seven Day Pass.");
								}
								else
								{
									System.out.println("Seven Day Fail."+Float.parseFloat(productSevenDay));
								}
								
								//Product Thirty Day
								driver.findElement(By.xpath(Object.getProperty("PerformanaceTab"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
								String productThirtyDay = driver.findElement(By.xpath(Object.getProperty("ProductThirtyDays"))).getText();
								System.out.println("One Thirty : "+productThirtyDay);
								driver.findElement(By.xpath(Object.getProperty("SensorTab"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
								AddFilter.customDate(t.date("Today-29"), t.date("Today"));
								Thread.sleep(5000);
								float presentDayValue2 =AddFilter.dashboardValue("Tonnage","2");
								System.out.println("Float : "+presentDayValue2);
								if(presentDayValue2 == Float.parseFloat(productThirtyDay))
								{
									System.out.println("Thirty Day Pass.");
								}
								else
								{
									System.out.println("Thirty Day Fail."+Float.parseFloat(productThirtyDay));
								}
								driver.findElement(By.xpath(Object.getProperty("PerformanaceTab"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
							}
							else
							{
								System.out.println("Product dates missing.");
							}*/
							
							//Fuel Usage 
						/*	if(t.isElementPresentcheck(By.xpath(Object.getProperty("FuelUsageOneDay")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("FuelUsageSevenDay")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("FuelUsageThirtyDays")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("FuelMenu")), driver))
							{								
							//	AddFilter.customDate(t.date("Today"), t.date("Today"));
								jse.executeScript("window.scrollBy(0,250)", "");	
								Robot r = new Robot();
							/*	driver.findElement(By.xpath(Object.getProperty("FuelMenu"))).click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("FuelReport"))).click();
								Thread.sleep(5000);
								r.keyPress(KeyEvent.VK_ESCAPE);
								Thread.sleep(500);
								r.keyRelease(KeyEvent.VK_ESCAPE);
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("FuelMenu"))).click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("FuelPNG"))).click();
								Thread.sleep(5000);
								Utildashboard.downloadRobo();
								String pngPath=commonPath+assetName+"_"+split[1]+".png";
								System.out.println("Fuel PNG : "+pngPath);
								if(Utildashboard.fileExist(pngPath))
								{
									System.out.println("Png File Downloaded successfully.");
								}
								else
								{
									System.out.println("Unable to download the file Png.");
								}
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("FuelMenu"))).click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("FuelJPEG"))).click();
								Thread.sleep(5000);
								Utildashboard.downloadRobo();
								String jpegPath=commonPath+assetName+"_"+split[1]+".jpeg";
								System.out.println("Fuel JPEG : "+jpegPath);
								if(Utildashboard.fileExist(jpegPath))
								{
									System.out.println("JPEG File Downloaded successfully.");
								}
								else
								{
									System.out.println("Unable to download the file JPEG.");
								}
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("FuelMenu"))).click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("FuelPDF"))).click();
								Thread.sleep(5000);
								Utildashboard.downloadRobo1();
								String pdfPath=commonPath+assetName+"_"+split[1]+".pdf";
								System.out.println("Fuel PDF : "+pdfPath);
								if(Utildashboard.fileExist(pdfPath))
								{
									System.out.println("PDF File Downloaded successfully.");
								}
								else
								{
									System.out.println("Unable to download the file PDF.");
								}
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("FuelMenu"))).click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("FuelSVG"))).click();
								Thread.sleep(5000);
								Utildashboard.downloadRobo1();
								String svgPath=commonPath+assetName+"_"+split[1]+".svg";
								System.out.println("Fuel Svg : "+svgPath);
								if(Utildashboard.fileExist(svgPath))
								{
									System.out.println("SVG File Downloaded successfully.");
								}
								else
								{
									System.out.println("Unable to download the file SVG.");
								}
								Thread.sleep(5000);
								//Fuel One day
								String fuelOneDay = driver.findElement(By.xpath(Object.getProperty("FuelUsageOneDay"))).getText();
								System.out.println("Fuel One Day : "+fuelOneDay);
								driver.findElement(By.xpath(Object.getProperty("SensorTab"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
								AddFilter.customDate(t.date("Today"), t.date("Today"));
								Thread.sleep(5000);
								float presentDayValue =AddFilter.dashboardValue("Tonnage","2");
								System.out.println("Float : "+presentDayValue);
								if(presentDayValue == Float.parseFloat(fuelOneDay))
								{
									System.out.println("One Day Pass.");
								}
								else
								{
									System.out.println("One Day Fail."+Float.parseFloat(fuelOneDay));
								}
								
								//Fuel Usage Seven Day
								driver.findElement(By.xpath(Object.getProperty("PerformanaceTab"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
								String fuelSevenDay = driver.findElement(By.xpath(Object.getProperty("FuelUsageSevenDay"))).getText();
								System.out.println("Fuel Seven : "+fuelSevenDay);
								driver.findElement(By.xpath(Object.getProperty("SensorTab"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
								AddFilter.customDate(t.date("Today-6"), t.date("Today"));
								Thread.sleep(5000);
								float presentDayValue1 =AddFilter.dashboardValue("Tonnage","2");
								System.out.println("Float : "+presentDayValue1);
								if(presentDayValue1 == Float.parseFloat(fuelSevenDay))
								{
									System.out.println("Seven Day Pass.");
								}
								else
								{
									System.out.println("Seven Day Fail."+Float.parseFloat(fuelSevenDay));
								}
								
								//Fuel Usage Thirty Day
								driver.findElement(By.xpath(Object.getProperty("PerformanaceTab"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
								String fuelThirtyDay = driver.findElement(By.xpath(Object.getProperty("FuelUsageThirtyDays"))).getText();
								System.out.println("Thirty : "+fuelThirtyDay);
								driver.findElement(By.xpath(Object.getProperty("SensorTab"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);
								AddFilter.customDate(t.date("Today-29"), t.date("Today"));
								Thread.sleep(5000);
								float presentDayValue2 =AddFilter.dashboardValue("Tonnage","2");
								System.out.println("Float : "+presentDayValue2);
								if(presentDayValue2 == Float.parseFloat(fuelThirtyDay))
								{
									System.out.println("Thirty Day Pass.");
								}
								else
								{
									System.out.println("Thirty Day Fail."+Float.parseFloat(fuelThirtyDay));
								}
								driver.findElement(By.xpath(Object.getProperty("PerformanaceTab"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(3000);	
							}
							else
							{
								System.out.println("Fuel Fail.");
							}*/
							
							//Average TPH & Average Gallons/Hour
						//	Object data3 = jse.executeScript("return chart.series.data;");
						//	System.out.println("data : "+data3);
							

						}
						else
						{
							System.out.println("performance tab is not displaying properly.");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				
				//Plant Data
				if(d2[i][0].equalsIgnoreCase("TC12"))
				{	
					try
					{
						System.out.println( "###################Test case 12 is executing############################");
						String alarm=d2[11][4];
						String [] alarmArray=alarm.split(",");
						String startDate =t.date(d2[11][5]);
						String endDate = t.date(d2[11][6]);
						AddFilter.assetDetails("PIDTP320EOMF70854");
						driver.findElement(By.xpath(Object.getProperty("PerformanaceTab"))).click();
						Thread.sleep(2000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(3000);
						AddFilter.customDate(t.date("Today"), t.date("Today"));
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				//Remote Commands
				if(d2[i][0].equalsIgnoreCase("TC13"))
				{	
					try
					{
						System.out.println( "###################Test case 13 is executing############################");
						String str=d2[12][4];
						String [] strArray=str.split(",");
						String autoit=d2[12][3];
						String [] autoitArray = autoit.split(",");
						String message=d2[12][2];
						String [] messageArray=message.split(",");
						String startDate =t.date(d2[12][5]);
						String endDate = t.date(d2[12][6]);
						AddFilter.assetDetails("PIDTP320AOMG62414");
						Thread.sleep(5000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("RemoteCommandsTab")), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("RemoteCommandsTab"))).click();
							Thread.sleep(2000);
							while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
							{
								System.out.println("inside while");
								Thread.sleep(1000);
							}
							Thread.sleep(3000);
						//	AddFilter.customDate(startDate, endDate);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("RemoteSendSMSButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("RemoteSendSatButton")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("RemoteSendUDPButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("RemoteRequestSoftwateUpdateButton")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("RemoteRequestStatus")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("RemoteRequestResetButton")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("RemoteRequestAlarmButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("RemoteRequestConfigButton")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("RemotePrintReportButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("RemoteExportToExcelButton")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("AssetDetailsPageMap")), driver))
							{	
								//Request Status Button
								driver.findElement(By.xpath(Object.getProperty("RemoteRequestStatus"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(6000);
								String statusMessage1=null;
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("StatusSuccessMessagebox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("StatusCloseButton")), driver))
								{
									System.out.println("Request status button is working as expected.");
									statusMessage1 = driver.findElement(By.xpath(Object.getProperty("StatusSuccessMessagebox"))).getText();
									System.out.println("Status Message1 : "+statusMessage1);
									acop = "Request status button is working as expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Request status button is not working as expected.");
									acop = "Request status button is not working as expected.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}								
								driver.findElement(By.xpath(Object.getProperty("StatusCloseButton"))).click();
								Thread.sleep(5000);
								if(! t.isElementPresentcheck(By.xpath(Object.getProperty("StatusSuccessMessagebox")), driver) && ! t.isElementPresentcheck(By.xpath(Object.getProperty("StatusCloseButton")), driver))
								{
									System.out.println("Status close button is working as Expected.");
									acop = "Status close button is working as Expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Status close button is not working as Expected.");
									acop = "Status close button is not working as Expected.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								//Status dashboard Verify.
								String status=AddFilter.dashboardString("Command Type", 1);
								System.out.println("Status : "+status);
								String statusType=AddFilter.dashboardString("Status", 1);
								System.out.println("Status : "+statusType);
								if(status.equalsIgnoreCase("Request Status Cmd") && statusType.equalsIgnoreCase("Queued"))
								{
									System.out.println("While clicking Request status button is command appear in the remotecommand dashboard.");
									acop = "While clicking Request status button is command appear in the remotecommand dashboard.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Status command message is not appear in the dashboard.");
									acop = "Status command message is not appear in the dashboard..";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								//Elapse Time Remaining Check
								driver.findElement(By.xpath(Object.getProperty("RemoteRequestStatus"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(6000);
								String statusMessage2=driver.findElement(By.xpath(Object.getProperty("StatusSuccessMessagebox"))).getText();
								System.out.println("Status Message : "+statusMessage2);
								if(statusMessage1.equalsIgnoreCase(messageArray[0]) && statusMessage2.equalsIgnoreCase(messageArray[1]))
								{
									System.out.println("Elapse Time function working as expected.");
									acop = "Elapse Time function working as expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Time Elapse function is not working as expected.");	
									acop = "Time Elapse function is not working as expected.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								driver.findElement(By.xpath(Object.getProperty("StatusCloseButton"))).click();
								
								
								//Request Reset Button
								driver.findElement(By.xpath(Object.getProperty("RemoteRequestResetButton"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(6000);
								String resetMessage1=null;
								System.out.println("Status Message1 : "+statusMessage1);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("ResetSuccessMessagebox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ResetCloseButton")), driver))
								{
									System.out.println("Request Reset button is working as expected.");
									resetMessage1=driver.findElement(By.xpath(Object.getProperty("ResetSuccessMessagebox"))).getText();
									acop = "Request Reset button is working as expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Request Reset button is not working as expected.");
									acop = "Request Reset button is not working as expected.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								driver.findElement(By.xpath(Object.getProperty("ResetCloseButton"))).click();
								Thread.sleep(5000);
								if(! t.isElementPresentcheck(By.xpath(Object.getProperty("ResetSuccessMessagebox")), driver) && ! t.isElementPresentcheck(By.xpath(Object.getProperty("ResetCloseButton")), driver))
								{
									System.out.println("Reset close button is working as Expected.");
									acop = "Reset close button is working as Expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Reset close button is not working as Expected.");
									acop = "Reset close button is not working as Expected.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								//Reset dashboard Verify.
								String reset=AddFilter.dashboardString("Command Type", 1);
								System.out.println("Reset : "+reset);
								String resetStatus=AddFilter.dashboardString("Status", 1);
								System.out.println("Status : "+resetStatus);
								if(reset.equalsIgnoreCase("") && resetStatus.equalsIgnoreCase("Queued"))
								{
									System.out.println("While clicking Request reset button is command appear in the remotecommand dashboard.");
									acop = "While clicking Request reset button is command appear in the remotecommand dashboard.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Reset command message is not appear in the dashboard.");
									acop = "Reset command message is not appear in the dashboard.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								//Elapse Time Remaining Check
								driver.findElement(By.xpath(Object.getProperty("RemoteRequestResetButton"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(6000);
								String resetMessage2=driver.findElement(By.xpath(Object.getProperty("ResetSuccessMessagebox"))).getText();
								System.out.println("Reset Message : "+resetMessage2);
								if(resetMessage1.equalsIgnoreCase(messageArray[0]) && resetMessage2.equalsIgnoreCase(messageArray[1]))
								{
									System.out.println("Time Elapse function working as expected.");
									acop = "Time Elapse function working as expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Time Elapse function is not working as expected.");	
									acop = "Time Elapse function is not working as expected.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								driver.findElement(By.xpath(Object.getProperty("ResetCloseButton"))).click();
								
								//Request Alarm Button
								driver.findElement(By.xpath(Object.getProperty("RemoteRequestAlarmButton"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(6000);
								String alarmMessage1=null;
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmSuccessMessagebox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmCloseButton")), driver))
								{
									System.out.println("Request Alarm button is working as expected.");
									alarmMessage1=driver.findElement(By.xpath(Object.getProperty("AlarmSuccessMessagebox"))).getText();
									System.out.println("Alarm Message : "+alarmMessage1);
									acop = "Request Alarm button is working as expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Request Alarm button is not working as expected.");
									acop = "Request Alarm button is not working as expected.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								driver.findElement(By.xpath(Object.getProperty("AlarmCloseButton"))).click();
								Thread.sleep(5000);
								if(! t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmSuccessMessagebox")), driver) && ! t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmCloseButton")), driver))
								{
									System.out.println("Alarm close button is working as Expected.");
									acop = "Alarm close button is working as Expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Alarm close button is not working as Expected.");
									acop = "Alarm close button is not working as Expected.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								//Alarm dashboard Verify.
								String alarm=AddFilter.dashboardString("Command Type", 1);
								System.out.println("Alarm : "+alarm);
								String alarmStatus=AddFilter.dashboardString("Status", 1);
								System.out.println("Status : "+alarmStatus);
								if(reset.equalsIgnoreCase("Request Alarm Cmd") && alarmStatus.equalsIgnoreCase("Queued"))
								{
									System.out.println("While clicking Request alarm button is command appear in the remotecommand dashboard.");
									acop = "While clicking Request alarm button is command appear in the remotecommand dashboard.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Alarm command message is not appear in the dashboard.");
									acop = "Alarm command message is not appear in the dashboard.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								//Elapse Time Remaining Check
								driver.findElement(By.xpath(Object.getProperty("RemoteRequestAlarmButton"))).click();							
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(6000);
								String alarmMessage2=driver.findElement(By.xpath(Object.getProperty("AlarmSuccessMessagebox"))).getText();
								System.out.println("alarm Message : "+alarmMessage2);
								if(alarmMessage1.equalsIgnoreCase(messageArray[0]) && alarmMessage2.equalsIgnoreCase(messageArray[1]))
								{
									System.out.println("Time Elapse function working as expected.");
									acop = "Time Elapse function working as expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Time Elapse function is not working as expected.");	
									acop = "Time Elapse function is not working as expected.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								driver.findElement(By.xpath(Object.getProperty("AlarmCloseButton"))).click();
								
								//Request Software Update Button
								driver.findElement(By.xpath(Object.getProperty("RemoteRequestSoftwateUpdateButton"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(6000);
								String softwareMessage1=null;
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("SoftwareSuccessMessagebox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SoftwareCloseButton")), driver))
								{
									System.out.println("Request Software Update button is working as expected.");
									softwareMessage1=driver.findElement(By.xpath(Object.getProperty("SoftwareSuccessMessagebox"))).getText();
									System.out.println("Software Message : "+softwareMessage1);
									acop = "Request Software Update button is working as expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Request Software Update button is not working as expected.");
									acop = "Request Software Update button is not working as expected.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								driver.findElement(By.xpath(Object.getProperty("SoftwareCloseButton"))).click();
								Thread.sleep(5000);
								if(! t.isElementPresentcheck(By.xpath(Object.getProperty("SoftwareSuccessMessagebox")), driver) && ! t.isElementPresentcheck(By.xpath(Object.getProperty("SoftwareCloseButton")), driver))
								{
									System.out.println("Software Update close button is working as Expected.");
									acop = "Software Update close button is working as Expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Software Update close button is not working as Expected.");
									acop = "Software Update close button is not working as Expected.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								//SoftwareUpdate dashboard Verify.
								String software=AddFilter.dashboardString("Command Type", 1);
								System.out.println("SoftwareUpdate : "+software);
								String softwareStatus=AddFilter.dashboardString("Status", 1);
								System.out.println("Status : "+softwareStatus);
								if(software.equalsIgnoreCase("") && softwareStatus.equalsIgnoreCase("Queued"))
								{
									System.out.println("While clicking Request softwareupdate button is command appear in the remotecommand dashboard.");
									acop = "While clicking Request softwareupdate button is command appear in the remotecommand dashboard.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Software update command is not display in the dahsboard.");
									acop = "Show row is not working as expected. its record count is mismatch with selected row.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								//Elapse Time Remaining Check
								driver.findElement(By.xpath(Object.getProperty("RemoteRequestSoftwateUpdateButton"))).click();							
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(6000);
								String softwareMessage2=driver.findElement(By.xpath(Object.getProperty("SoftwareSuccessMessagebox"))).getText();
								System.out.println("Software Message : "+softwareMessage2);
								if(softwareMessage1.equalsIgnoreCase(messageArray[0]) && softwareMessage2.equalsIgnoreCase(messageArray[1]))
								{
									System.out.println("Time Elapse function working as Expected.");
									acop = "Time Elapse function working as Expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Time Elapse function working is not as Expected.");
									acop = "Time Elapse function is not working as Expected.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								driver.findElement(By.xpath(Object.getProperty("SoftwareCloseButton"))).click();
																
								//Request Config Button
								driver.findElement(By.xpath(Object.getProperty("RemoteRequestConfigButton"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(6000);
								String configMessage1=null;
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("ConfigSuccessMessagebox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ConfigCloseButton")), driver))
								{
									System.out.println("Request Config button is working as expected.");
									configMessage1=driver.findElement(By.xpath(Object.getProperty("SoftwareSuccessMessagebox"))).getText();
									System.out.println("Config Message : "+configMessage1);
									acop = "Request Config button is working as expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Request Config button is not working as expected.");
									acop = "Request Config button is not working as expected.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								driver.findElement(By.xpath(Object.getProperty("ConfigCloseButton"))).click();
								Thread.sleep(5000);
								if(! t.isElementPresentcheck(By.xpath(Object.getProperty("ConfigSuccessMessagebox")), driver) && ! t.isElementPresentcheck(By.xpath(Object.getProperty("ConfigCloseButton")), driver))
								{
									System.out.println("Config close button is working as Expected.");
									acop = "Config close button is working as Expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Config close button is not working as Expected.");
									acop = "Config close button is not working as Expected.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								//Config dashboard Verify.
								String config=AddFilter.dashboardString("Command Type", 1);
								System.out.println("Config : "+config);
								String configStatus=AddFilter.dashboardString("Status", 1);
								System.out.println("Status : "+configStatus);
								if(config.equalsIgnoreCase("Request Config Cmd") && config.equalsIgnoreCase("Queued"))
								{
									System.out.println("While clicking Request config button is command appear in the remotecommand dashboard.");
									acop = "While clicking Request config button is command appear in the remotecommand dashboard.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Config command is not displaying in the dashboard after clicking the request config button");
									acop = "Config command is not displaying in the dashboard after clicking the request config button.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								
								//Elapse Time Remaining Check
								driver.findElement(By.xpath(Object.getProperty("RemoteRequestConfigButton"))).click();							
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(6000);
								String configMessage2=driver.findElement(By.xpath(Object.getProperty("ConfigSuccessMessagebox"))).getText();
								System.out.println("Config Message : "+configMessage2);
								if(configMessage1.equalsIgnoreCase(messageArray[0]) && configMessage2.equalsIgnoreCase(messageArray[1]))
								{
									System.out.println("Time Elapse function is working as expected.");
									acop = "Time Elapse function is working as expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Time Elapse function is not working as expected.");	
									acop = "Time Elapse function is not working as expected.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								driver.findElement(By.xpath(Object.getProperty("ConfigCloseButton"))).click();

								//Send Sms
								driver.findElement(By.xpath(Object.getProperty("RemoteSendSMSButton"))).click();
								Thread.sleep(6000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("RemoteSendSMSBox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("RemoteSendSMSUnitTextbox")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("RemoteSendSMSTextbox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("RemoteSMSSendButton")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("RemoteSMSClearButton")), driver))
								{
									System.out.println("Send sms button working as expected.");
									acop = "Send sms button working as expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
									
									WebElement unit= driver.findElement(By.xpath(Object.getProperty("RemoteSendSMSUnitTextbox")));
									unit.sendKeys(strArray[0]);
									Thread.sleep(3000);
									WebElement select = driver.findElement(By.id("ui-id-4"));
									List<WebElement> options = select.findElements(By.className("ui-corner-all"));
									System.out.println("Size : "+options.size());
									for (WebElement option : options) 
									{	 	  
										System.out.println("list : "+option.getText());
										if(option.getText().equals(strArray[0])) 
										{
									           option.click();
										}
									}
									driver.findElement(By.xpath(Object.getProperty("RemoteSendSMSTextbox"))).sendKeys(strArray[1]);
									Thread.sleep(2000);
									driver.findElement(By.xpath(Object.getProperty("RemoteSMSSendButton"))).click();
									Thread.sleep(2000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(3000);
									if(t.isElementPresentcheck(By.xpath(Object.getProperty("SMSAlertSuccessMessage")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SMSAlertCloseButton")), driver))
									{
										System.out.println("Sms sent successfully.");
										acop = "Sms sent successfully.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 13 execution completed############################");
									}
									else
									{
										System.out.println("Unable to send sms.");
										acop = "Unable to send sms.";
										node.log(LogStatus.FAIL, acop);	
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 13 execution completed############################");
									}
									driver.findElement(By.xpath(Object.getProperty("SMSAlertCloseButton"))).click();
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("RemoteSendSMSButton"))).click();
									unit= driver.findElement(By.xpath(Object.getProperty("RemoteSendSMSUnitTextbox")));
									unit.sendKeys(strArray[0]);
									Thread.sleep(3000);
									WebElement select1 = driver.findElement(By.id("ui-id-4"));
									List<WebElement> options1 = select1.findElements(By.className("ui-corner-all"));
									System.out.println("Size : "+options1.size());
									for (WebElement option : options1) 
									{	 	  
										System.out.println("list : "+option.getText());
										if(option.getText().equals(strArray[0])) 
										{
									           option.click();
										}
									}
									driver.findElement(By.xpath(Object.getProperty("RemoteSendSMSTextbox"))).sendKeys(strArray[1]);
									Thread.sleep(2000);
									driver.findElement(By.xpath(Object.getProperty("RemoteSMSClearButton"))).click();
									Thread.sleep(5000);
									String clrSMS=driver.findElement(By.xpath(Object.getProperty("SMSLength"))).getText();
									System.out.println("SMS : "+clrSMS);
									if(clrSMS.equalsIgnoreCase("0/160"))
									{
										System.out.println("SMS Clear button is working as expected.");
										acop = "SMS Clear button is working as expected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 13 execution completed############################");
									}
									else
									{
										System.out.println("SMS Clear button is not working as expected.");
										acop = "SMS Clear button is not working as expected.";
										node.log(LogStatus.FAIL, acop);	
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 13 execution completed############################");
									}
									Thread.sleep(2000);
									driver.findElement(By.xpath(Object.getProperty("RemoteSMSCloseButton"))).click();
								}
								else
								{
									System.out.println("Semd sms button is not working as expected.");
									acop = "Semd sms button is not working as expected.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								//Send sms dashboard Verify.
								AddFilter.pageRefresher();
								String sms=AddFilter.dashboardString("Command Type", 1);
								System.out.println("Send Sms : "+sms);
								String smsStatus=AddFilter.dashboardString("Status", 1);
								System.out.println("Status : "+smsStatus);
								String smsPing=AddFilter.dashboardString("Ping Command", 1);
								System.out.println("Ping : "+smsPing);
								if(sms.equalsIgnoreCase("SMS Cmd") && smsStatus.equalsIgnoreCase("Queued") && smsPing.equalsIgnoreCase(strArray[1]))
								{
									System.out.println("Sms command appeared in the remotecommand dashboard.");
									acop = "Sms command appeared in the remotecommand dashboard.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Sms command message is not added into the dashboard.");
									acop = "Sms command message is not added into the dashboard.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								
								/*
								//Send Sat
								Thread.sleep(5000);
								driver.findElement(By.xpath(Object.getProperty("RemoteSendSatButton"))).click();
								Thread.sleep(10000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("SatToTextbox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SatSubjectTextbox")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("SatBodyTextbox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SatAttachfile")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("SatSendButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SatClearButton")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("NewSatMessageTable")), driver)) 
								{
									System.out.println("Send sat button is working.");
									WebElement unit= driver.findElement(By.xpath(Object.getProperty("SatToTextbox")));
									unit.sendKeys(strArray[2]);
									Thread.sleep(3000);
									WebElement select = driver.findElement(By.id("ui-id-4"));
									List<WebElement> options = select.findElements(By.className("ui-corner-all"));
									System.out.println("Size : "+options.size());
									for (WebElement option : options) 
									{	 	  
										System.out.println("list : "+option.getText());
										if(option.getText().equals(strArray[2])) 
										{
									           option.click();
										}
									}
									driver.findElement(By.xpath(Object.getProperty("SatSubjectTextbox"))).sendKeys(strArray[3]);
									Thread.sleep(2000);
									driver.findElement(By.xpath(Object.getProperty("SatBodyTextbox"))).sendKeys(strArray[4]);
									Thread.sleep(2000);
									driver.findElement(By.xpath(Object.getProperty("SatAttachfile"))).click();
									Thread.sleep(3000);
									Runtime.getRuntime().exec(autoitArray[0]);
									Thread.sleep(2000);
									driver.findElement(By.xpath(Object.getProperty("SatSendButton"))).click();
								}
								else
								{
									System.out.println("Send sat button is not working.");
								}*/
								
								//Send UDP
								driver.findElement(By.xpath(Object.getProperty("RemoteSendUDPButton"))).click();
								Thread.sleep(3000);
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("SendUDPTable")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UDPUnitTextbox")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("UDPSMSTextbox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UDPSendButton")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("UDPClearButton")), driver))
								{
									System.out.println("UDP button is working.");
									acop = "Udp button is working as expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
									
									WebElement unit= driver.findElement(By.xpath(Object.getProperty("UDPUnitTextbox")));
									unit.sendKeys(strArray[5]);
									Thread.sleep(3000);
									WebElement select = driver.findElement(By.id("ui-id-4"));
									List<WebElement> options = select.findElements(By.className("ui-corner-all"));
									System.out.println("Size : "+options.size());
									for (WebElement option : options) 
									{	 	  
										System.out.println("list : "+option.getText());
										if(option.getText().equals(strArray[5])) 
										{
									           option.click();
										}
									}
									driver.findElement(By.xpath(Object.getProperty("UDPSMSTextbox"))).sendKeys(strArray[6]);
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("UDPSendButton"))).click();
									if(t.isElementPresentcheck(By.xpath(Object.getProperty("UDPSuccessMessage")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("UDPCloseButton")), driver))
									{
										driver.findElement(By.xpath(Object.getProperty("UDPCloseButton"))).click();
										System.out.println("UDP displaying success alert message.");
										acop = "Udp message sent.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 13 execution completed############################");
									}
									else
									{
										System.out.println("UDP is not displaying sucess alert Message.");
										acop = "UDP is not displaying sucess alert Message.";
										node.log(LogStatus.FAIL, acop);	
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 13 execution completed############################");
									}
									
									//UDP clear button.
									driver.findElement(By.xpath(Object.getProperty("RemoteSendUDPButton"))).click();
									Thread.sleep(3000);
									WebElement unit1= driver.findElement(By.xpath(Object.getProperty("UDPUnitTextbox")));
									unit1.sendKeys(strArray[5]);
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("UDPSMSTextbox"))).sendKeys(strArray[6]);
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("UDPClearButton"))).click();
									Thread.sleep(3000);
									String msg = driver.findElement(By.xpath(Object.getProperty("UDPMSGLength"))).getText();
									System.out.println("msg : "+msg);
									if(msg.equalsIgnoreCase("0/160"))
									{
										System.out.println("Udp clear button working as expected.");
										acop = "Udp clear button working as expected.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 13 execution completed############################");
									}
									else
									{
										System.out.println("UDP clear button is not working.");
										acop = "UDP clear button is not working.";
										node.log(LogStatus.FAIL, acop);	
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 13 execution completed############################");
									}
									Thread.sleep(2000);
									driver.findElement(By.xpath(Object.getProperty("UDPClose"))).click();
									AddFilter.pageRefresher();
									
									//UDP dashboard Verify.
									String udp=AddFilter.dashboardString("Command Type", 1);
									System.out.println("UDP : "+udp);
									String udpStatus=AddFilter.dashboardString("Status", 1);
									System.out.println("Status : "+udpStatus);
									String udpPing=AddFilter.dashboardString("Ping Command", 1);
									System.out.println("Ping : "+udpPing);
									if(udp.equalsIgnoreCase("UDP Cmd") && udpStatus.equalsIgnoreCase("Queued") && udpPing.equalsIgnoreCase(strArray[6]))
									{
										System.out.println("UPD dashboard pass");
										acop = "Udp message command appeared in the remotecommand dashboard.";
										node.log(LogStatus.PASS, acop);
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
										System.out.println( "###################Test case 13 execution completed############################");
									}
									else
									{
										System.out.println("Udp message is not added into dashboard.");
										acop = "Udp message is not added into dashboard.";
										node.log(LogStatus.FAIL, acop);	
										data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
										rc++;
										String scr = t.CaptureScreenshot();
										s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
										System.out.println( "###################Test case 13 execution completed############################");
									}
								}
								else
								{
									System.out.println("Udp button is not working as expected.");
									acop = "Udp button is not working as expected.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								
								//Print Report.
								String url1=driver.getCurrentUrl();
								System.out.println("url1 : "+url1);
								driver.findElement(By.xpath(Object.getProperty("RemotePrintReportButton"))).click();
								Thread.sleep(6000);
								ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
								for(String tab : tabs2)
								{
									System.out.println("Array : "+tab);
								}
							    driver.switchTo().window(tabs2.get(1));
							    Thread.sleep(5000);	
								String url2=driver.getCurrentUrl();
								System.out.println("url2 : "+url2);
								url2=url2.substring(url2.indexOf("http:"), url2.length());
								System.out.println("After Convert "+url2) ;
								if(url1.equalsIgnoreCase(url2))
								{
									System.out.println("Print report button working as expected.");
									acop = "Print report button working as expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("While clicking print report it navigate to unexpected url.");
									acop = "While clicking print report it navigate to unexpected url.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
							    driver.close();
							    driver.switchTo().window(tabs2.get(0));
							    
							    //Export to Excel
								Thread.sleep(3000);								
							//	AddFilter.customDate(startDate, endDate);
								driver.findElement(By.xpath(Object.getProperty("RemoteExportToExcelButton"))).click();
								Thread.sleep(2000);
								while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
								{
									System.out.println("inside while");
									Thread.sleep(1000);
								}
								Thread.sleep(10000);
								Robot robot = new Robot();
								robot.keyPress(KeyEvent.VK_DOWN);
								Thread.sleep(500);
								robot.keyRelease(KeyEvent.VK_DOWN);
								Thread.sleep(500);
								robot.keyPress(KeyEvent.VK_ENTER);
								Thread.sleep(500);
								robot.keyRelease(KeyEvent.VK_ENTER);
								Thread.sleep(5000);
								String totalRows = driver.findElement(By.xpath(Object.getProperty("RemoteCommandDashboard"))).getAttribute("totalrows");
								System.out.println("TotalRows : "+totalRows);
								String excelFilePath= "D:\\workspace\\FleetEdge\\DownloadExcel\\Ping.xlsx";
								int excelSize = Utildashboard.loopIncrement(excelFilePath,"Ping");
								System.out.println("looping time : "+excelSize);
								int totalVal=Integer.parseInt(totalRows);
								if(excelSize==totalVal)
								{
									System.out.println("Export to excel button working as expected.");
									acop = "Export to excel button working as expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Export to excel while its count is not match with data records");
									acop = "Export to excel while its count is not match with data records";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								
								//Paging
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("RemotePageSize")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("RemotePaging")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("RemoteGoToPage")), driver))
								{
									WebElement show=driver.findElement(By.xpath(Object.getProperty("RemotePageSize")));
									List<WebElement> showList=show.findElements(By.tagName("option"));
									for(int m=2;m<autoitArray.length;m++)
									{
										for(WebElement keep : showList)
										{
											if(keep.getText().equalsIgnoreCase(autoitArray[m]))
											{
												keep.click();
												Thread.sleep(2000);
												while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
												{
													System.out.println("inside while");
													Thread.sleep(1000);
												}
												Thread.sleep(5000);
												show=driver.findElement(By.xpath(Object.getProperty("RemotePageSize")));
												showList=show.findElements(By.tagName("option"));
												for(WebElement keep1 : showList)
												{
													if(keep1.getText().equalsIgnoreCase(autoitArray[m]))
													{
														if(keep1.getAttribute("selected").equalsIgnoreCase("true"))
														{
															System.out.println("Selected.");
															WebElement row=driver.findElement(By.xpath("//*[@id='tblFleetStatusReport']/tbody"));
															List<WebElement> rowList=row.findElements(By.tagName("tr"));
															System.out.println("Row size : "+rowList.size() + " M : "+autoitArray[m]);
															if(autoitArray[m].equalsIgnoreCase(String.valueOf(rowList.size())))
															{
																System.out.println("Show Record dropdown working as expected.");
																acop = "Show Record dropdown working as expected.";
																node.log(LogStatus.PASS, acop);
																data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
																rc++;
																s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
																System.out.println( "###################Test case 13 execution completed############################");
															}
															else
															{
																System.out.println("Show row is not working as expected. its record count is mismatch with selected row.");
																acop = "Show row is not working as expected. its record count is mismatch with selected row.";
																node.log(LogStatus.FAIL, acop);	
																data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
																rc++;
																String scr = t.CaptureScreenshot();
																s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
																System.out.println( "###################Test case 13 execution completed############################");
															}
														}
														else
														{
															System.out.println("Show row dropdown is not working as expected.");
															acop = "Show row dropdown is not working as expected.";
															node.log(LogStatus.FAIL, acop);	
															data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
															rc++;
															String scr = t.CaptureScreenshot();
															s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
															System.out.println( "###################Test case 13 execution completed############################");
														}
														break;
													}
												}
												break;
											}
										}
									}
									//Page change.
									WebElement pag=driver.findElement(By.xpath(Object.getProperty("RemoteGoToPage")));
									List<WebElement> pageList=pag.findElements(By.tagName("option"));
									System.out.println("Size"+pageList.size() + autoitArray[1]);
									for(WebElement text : pageList)
									{
										if(text.getText().equalsIgnoreCase(autoitArray[1]))
										{
											text.click();
											Thread.sleep(2000);
											while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
											{
												System.out.println("inside while");
												Thread.sleep(1000);
											}
											Thread.sleep(5000);
											pag=driver.findElement(By.xpath(Object.getProperty("RemoteGoToPage")));
											pageList=pag.findElements(By.tagName("option"));
											for(WebElement text1 : pageList)
											{
												if(text1.getText().equalsIgnoreCase(autoitArray[1]))
												{
													if(text1.getAttribute("selected").equalsIgnoreCase("true"))
													{
														System.out.println("Page selecting dropdown working as expected.");
														acop = "Page selecting dropdown working as expected.";
														node.log(LogStatus.PASS, acop);
														data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
														rc++;
														s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
														System.out.println( "###################Test case 13 execution completed############################");
													}
													else
													{
														System.out.println("Go to page dropdown is not working as expected.");
														acop = "Go to page dropdown is not working as expected.";
														node.log(LogStatus.FAIL, acop);	
														data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
														rc++;
														String scr = t.CaptureScreenshot();
														s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
														System.out.println( "###################Test case 13 execution completed############################");
													}
													break;
												}

											}
											break;
										}
									}
									
								}
								else
								{
									System.out.println("Enough data is not there to display paging or some of paging element missing.");
									acop = "Enough data is not there to display paging or some of paging element missing.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								
								//Dashboard verify
								if(t.isElementPresentcheck(By.xpath(Object.getProperty("PingTrackingNumber")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("PingOwner")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("PingEquipmentID")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("PingRequestedBy")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("PingRequestedDate")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("PingStatus")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("PingCompletedDate")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("PingCommandType")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("PingOperanID")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("PingCommand")), driver)
										&& t.isElementPresentcheck(By.xpath(Object.getProperty("PingMessageState")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("PingReceipt")), driver))
								{
									System.out.println("Remote Dashboard displaying as expected.");
									acop = "Remote Dashboard displaying as expected.";
									node.log(LogStatus.PASS, acop);
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Pass" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else if(t.isElementPresentcheck(By.xpath(Object.getProperty("RemoteNoRecords")), driver))
								{
									System.out.println("No Records in the Remote Command dashboards.");
									acop = "No Records in the Remote Command dashboards.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								else
								{
									System.out.println("Some of the element missing in the Remote command dashboard.");
									acop = "Some of the element missing in the Remote command dashboard.";
									node.log(LogStatus.FAIL, acop);	
									data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
									rc++;
									String scr = t.CaptureScreenshot();
									s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
									System.out.println( "###################Test case 13 execution completed############################");
								}
								
							}
							else
							{
								System.out.println("Some of element missing in the remote commands tab.");
								acop = "Some of element missing in the remote commands tab.";
								node.log(LogStatus.FAIL, acop);	
								data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
								rc++;
								String scr = t.CaptureScreenshot();
								s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
								System.out.println( "###################Test case 13 execution completed############################");
							}
						}
						else
						{
							System.out.println("Remote Commands tab is not added or not displayed in the Asset details page.");
							acop = "Remote Commands tab is not added or not displayed in the Asset details page.";
							node.log(LogStatus.FAIL, acop);	
							data.put(""+rc, new Object[] {d2[i][0], "AssetDetails", d2[i][1], d2[i][7], acop, "Fail", t.timestamp(stime)});
							rc++;
							String scr = t.CaptureScreenshot();
							s.WriteInput(filepath, "AssetDetails", d2[i][0], rc, acop, "Fail" );
							System.out.println( "###################Test case 13 execution completed############################");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				
				//Custom Tab.
				if(d2[i][0].equalsIgnoreCase("TC14"))
				{	
					try
					{
						System.out.println( "###################Test case 14 is executing############################");
						String custom=d2[13][4];
						String [] split=custom.split(",");
						String dateRange=d2[13][3];
						String [] dateRangeArray=dateRange.split(",");
						String sensor=d2[13][2];
						String [] sensorArray = sensor.split(",");
						String startDate =t.date(d2[13][5]);
						String endDate = t.date(d2[13][6]);
						AddFilter.assetDetails("PIDTP500HOMG32086");
						Thread.sleep(5000);
//						driver.findElement(By.xpath(Object.getProperty("CustomTap"))).click();
						driver.findElement(By.xpath(Object.getProperty("CustomTemp"))).click();
						Thread.sleep(2000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(3000);
//						AddFilter.sequenceNumber("AverageColumnChart1");
						/*for(int j=0,p=1;j<dateRangeArray.length;j++,p++)
						{
							if(dateRangeArray[j].equalsIgnoreCase("Page Date Range"))
							{
								AddFilter.customDate(startDate, endDate);
							}
							String s= AddFilter.chartDate("Column"+p,dateRangeArray[j],startDate,endDate);
							System.out.println("Date : "+s);
						}*/
						AddFilter.customDate(t.date("Today-20"), t.date("Today-14"));
			/*			JavascriptExecutor jse = (JavascriptExecutor)driver;
						jse.executeScript("window.scrollBy(0,250)", "");
						 Actions action = new Actions(driver);
						 WebElement element = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr[1]/td[1]/div/div[2]/div/div/*[local-name() = 'svg']/*[local-name() = 'g'][7]/*[local-name() = 'g'][1]/*[local-name() = 'rect'][1]"));
						 action.moveToElement(element).build().perform();
						 action.click();
						WebElement toolTip = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr[1]/td[1]/div/div[2]/div/div/*[local-name() = 'svg']/*[local-name() = 'g'][13]/*[local-name() = 'text']"));
				        List<WebElement> toolTipLines = toolTip.findElements(By.tagName("tspan"));
				        System.out.println("Size of Tool Tip"+ toolTipLines.size());
				        for (WebElement toolTipLine : toolTipLines) {
				        	System.out.println("tool Tip : "+toolTipLine.getText());
				        }*/
						driver.findElement(By.xpath(Object.getProperty("ManageChartButton"))).click();
						Thread.sleep(5000);
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("CustomChartTable")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("CustomChart")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("ChartNewButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ChartEditButton")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("ChartDeleteButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ChartManageCloseButton")), driver))
						{
							System.out.println("Custom Pass.");
							driver.findElement(By.xpath(Object.getProperty("ChartNewButton"))).click();
							Thread.sleep(2000);		
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("ChartBuilderSetting")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ChartTitleTextbox")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("ChartTypeDropdown")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("DateRangeTypeDropdown")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("NoOfInnerChart")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("NoOfInnerChartSequence")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("ChartForDropdown")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SingleChartPerRowCheckbox")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("SensorYAxisDropdown")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("DisplayNameTextbox")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("TypeDropdown")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SensorUnitTextbox")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("ColorCodeTextbox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ScalBySensorCheckbox")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("ScalMinValueTextbox")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ScalMaxValueTextbox")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("RowAddButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ChartSaveButton")), driver)
									&& t.isElementPresentcheck(By.xpath(Object.getProperty("ChartCloseButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ChartToolTip")), driver))
							{
								driver.findElement(By.xpath(Object.getProperty("ChartCloseButton"))).click();
								Thread.sleep(3000);
								driver.findElement(By.xpath(Object.getProperty("ChartManageCloseButton"))).click();
								for(int m=0;m<split.length;m++)
								{
									//Column
									for(int l=2,p=5;l<dateRangeArray.length;l++,p++)
									{
										if(split[m].equalsIgnoreCase("Column"))
										{
											driver.findElement(By.xpath(Object.getProperty("ManageChartButton"))).click();
											Thread.sleep(5000);
											driver.findElement(By.xpath(Object.getProperty("ChartNewButton"))).click();
											Thread.sleep(2000);
											String date=dateRangeArray[l];
											driver.findElement(By.xpath(Object.getProperty("ChartTitleTextbox"))).sendKeys(split[m]+p);
											Thread.sleep(2000);
											WebElement type=driver.findElement(By.xpath(Object.getProperty("ChartTypeDropdown")));
											List<WebElement> typeList=type.findElements(By.tagName("option"));
											for(WebElement text : typeList)
											{
												if(text.getText().equalsIgnoreCase(split[m]))
												{
													text.click();
												}
											}
//											Date Range (X-Axis)
											type=driver.findElement(By.xpath(Object.getProperty("DateRangeTypeDropdown")));
											typeList=type.findElements(By.tagName("option"));
											for(WebElement text : typeList)
											{
												if(text.getText().equalsIgnoreCase(date))
												{
													text.click();
												}
											}
											driver.findElement(By.xpath(Object.getProperty("ChartToolTip"))).sendKeys(split[m]);
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("SingleChartPerRowCheckbox"))).click();
											Thread.sleep(2000);
//											Sensor YAxis
											type=driver.findElement(By.xpath(Object.getProperty("SensorYAxisDropdown")));
											typeList=type.findElements(By.tagName("option"));
											for(WebElement text : typeList)
											{
												if(text.getText().equalsIgnoreCase(sensorArray[0]))
												{
													text.click();
												}
											}
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("DisplayNameTextbox"))).sendKeys(sensorArray[0]);
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("ColorCodeTextbox"))).sendKeys(sensorArray[2]);
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("RowAddButton"))).click();
											Thread.sleep(2000);
											
//											Second Column
											WebElement chart = driver.findElement(By.xpath(Object.getProperty("TableChart")+"/tbody"));
											List<WebElement> chartList=chart.findElements(By.tagName("tr"));
											System.out.println("Size of Table : "+chartList.size());
											if(chartList.size()==2 && t.isElementPresentcheck(By.xpath(Object.getProperty("SecondRowSenosr")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("SecondDisplayName")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SecondColumnType")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("SecondSensorUnit")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SecondColorCode")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("SecondScaleBySensor")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SecondScaleMin")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("SecondScaleMax")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SecondAddButton")), driver))
											{
												String secondRow = driver.findElement(By.xpath(Object.getProperty("RemoveButton"))).getText();
												System.out.println("Second Row : "+secondRow);
												type=driver.findElement(By.xpath(Object.getProperty("SecondRowSenosr")));
												typeList=type.findElements(By.tagName("option"));
												for(WebElement text : typeList)
												{
													if(text.getText().equalsIgnoreCase(sensorArray[1]))
													{
														text.click();
													}
												}
												Thread.sleep(2000);
												driver.findElement(By.xpath(Object.getProperty("SecondDisplayName"))).sendKeys(sensorArray[1]);
												Thread.sleep(2000);
												driver.findElement(By.xpath(Object.getProperty("SecondColorCode"))).sendKeys(sensorArray[3]);
												Thread.sleep(2000);
											}
											else
											{
												System.out.println("Add button is not working as expectd.");
											}
											
											driver.findElement(By.xpath(Object.getProperty("ChartSaveButton"))).click();
											Thread.sleep(2000);
											while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
											{
												System.out.println("inside while");
												Thread.sleep(1000);
											}
											Thread.sleep(5000);
											String val= AddFilter.chartNameCHk(split[m]+p);
											System.out.println("Val : "+val);
											if(val.equalsIgnoreCase(split[m]+p))
											{
												System.out.println("Chart Created Successfully.");
											}
											else
											{
												System.out.println("Unable to create the chart : "+split[m]+p);
											}
											Thread.sleep(2000);
											if(dateRangeArray[l].equalsIgnoreCase("Page Date Range"))
											{
												AddFilter.customDate(startDate, endDate);
											}
											String s= AddFilter.chartDate(split[m]+p,dateRangeArray[l],startDate,endDate,split[m],sensorArray[0],sensorArray[1]);
											System.out.println("Date : "+s);
											if(s.equalsIgnoreCase("true"))
											{
												System.out.println("Chart creation working as expected.");
											}
											else if(s.equalsIgnoreCase("false"))
											{
												System.out.println("Some of element missing in the created chart.  "+split[m]+p);
											}
											else if(s.equalsIgnoreCase("Chart is not exists"))
											{
												System.out.println(split[m]+p+"  chart is still not exists.");
											}
//											AddFilter.deleteChart(split[m]+p);
										}
									}									
//									driver.findElement(By.xpath(Object.getProperty("ChartCloseButton"))).click();
									
									//AverageColumnChart
							/*		for(int l=0,p=1;l<dateRangeArray.length;l++,p++)
									{
//										System.out.println(split[m]+" Name");
										if(split[m].equalsIgnoreCase("AverageColumnChart"))
										{
											String date=dateRangeArray[l];
											driver.findElement(By.xpath(Object.getProperty("ChartTitleTextbox"))).sendKeys(split[m]+p);
											Thread.sleep(2000);
											WebElement type=driver.findElement(By.xpath(Object.getProperty("ChartTypeDropdown")));
											List<WebElement> typeList=type.findElements(By.tagName("option"));
											for(WebElement text : typeList)
											{
												if(text.getText().equalsIgnoreCase(split[m]))
												{
													text.click();
												}
											}
//											Date Range (X-Axis)
											type=driver.findElement(By.xpath(Object.getProperty("DateRangeTypeDropdown")));
											typeList=type.findElements(By.tagName("option"));
											for(WebElement text : typeList)
											{
												if(text.getText().equalsIgnoreCase(date))
												{
													text.click();
												}
											}
											driver.findElement(By.xpath(Object.getProperty("ChartToolTip"))).sendKeys(split[m]);
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("SingleChartPerRowCheckbox"))).click();
											Thread.sleep(2000);
//											Sensor YAxis
											type=driver.findElement(By.xpath(Object.getProperty("SensorYAxisDropdown")));
											typeList=type.findElements(By.tagName("option"));
											for(WebElement text : typeList)
											{
												if(text.getText().equalsIgnoreCase(sensorArray[0]))
												{
													text.click();
												}
											}
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("DisplayNameTextbox"))).sendKeys(sensorArray[0]);
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("ColorCodeTextbox"))).sendKeys(sensorArray[2]);
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("RowAddButton"))).click();
											Thread.sleep(2000);
											
//											Second Column
											WebElement chart = driver.findElement(By.xpath(Object.getProperty("TableChart")+"/tbody"));
											List<WebElement> chartList=chart.findElements(By.tagName("tr"));
											System.out.println("Size of Table : "+chartList.size());
											if(chartList.size()==2 && t.isElementPresentcheck(By.xpath(Object.getProperty("SecondRowSenosr")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("SecondDisplayName")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SecondColumnType")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("SecondSensorUnit")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SecondColorCode")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("SecondScaleBySensor")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SecondScaleMin")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("SecondScaleMax")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SecondAddButton")), driver))
											{
												String secondRow = driver.findElement(By.xpath(Object.getProperty("RemoveButton"))).getText();
												System.out.println("Second Row : "+secondRow);
												type=driver.findElement(By.xpath(Object.getProperty("SecondRowSenosr")));
												typeList=type.findElements(By.tagName("option"));
												for(WebElement text : typeList)
												{
													if(text.getText().equalsIgnoreCase(sensorArray[1]))
													{
														text.click();
													}
												}
												Thread.sleep(2000);
												driver.findElement(By.xpath(Object.getProperty("SecondDisplayName"))).sendKeys(sensorArray[1]);
												Thread.sleep(2000);
												driver.findElement(By.xpath(Object.getProperty("SecondColorCode"))).sendKeys(sensorArray[3]);
												Thread.sleep(2000);
											}
											else
											{
												System.out.println("Add button is not working as expectd.");
											}
											
											//More than 2 alert Checking
											driver.findElement(By.xpath(Object.getProperty("SecondAddButton"))).click();
											Thread.sleep(500);
											if(t.isAlertPresent(driver))
											{
												System.out.println(t.alertText());
												if("Average Column Chart does not allow to add more than 2 sensor!".equalsIgnoreCase(t.alertText()))
												{
													System.out.println("Alert Displaying as expected.");
												}
												else
												{
													System.out.println("Alert Message miss match.");
												}
												driver.switchTo().alert().accept();
											}
											Thread.sleep(2000);
											
											driver.findElement(By.xpath(Object.getProperty("ChartSaveButton"))).click();
											Thread.sleep(2000);
											while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
											{
												System.out.println("inside while");
												Thread.sleep(1000);
											}
											Thread.sleep(5000);
											String val= AddFilter.chartNameCHk(split[m]+p);
											System.out.println("Val : "+val);
											if(val.equalsIgnoreCase(split[m]+p))
											{
												System.out.println("Chart Created Successfully.");
											}
											else
											{
												System.out.println("Unable to create the chart : "+split[m]+p);
											}
											Thread.sleep(2000);
											if(dateRangeArray[l].equalsIgnoreCase("Page Date Range"))
											{
												AddFilter.customDate(startDate, endDate);
											}
											String s= AddFilter.chartDate(split[m]+p,dateRangeArray[l],startDate,endDate,split[m],sensorArray[0],sensorArray[1]);
											System.out.println("Date : "+s);
											if(s.equalsIgnoreCase("true"))
											{
												System.out.println("Chart creation working as expected.");
											}
											else if(s.equalsIgnoreCase("false"))
											{
												System.out.println("Some of element missing in the created chart.  "+split[m]+p);
											}
											else if(s.equalsIgnoreCase("Chart is not exists"))
											{
												System.out.println(split[m]+p+"  chart is still not exists.");
											}
//											AddFilter.deleteChart(split[m]+p);
											driver.findElement(By.xpath(Object.getProperty("ManageChartButton"))).click();
											Thread.sleep(5000);
											driver.findElement(By.xpath(Object.getProperty("ChartNewButton"))).click();
											Thread.sleep(2000);
										}
									}	*/
									
									//ColumnLine
							/*		for(int l=0,p=4;l<dateRangeArray.length;l++,p++)
									{
										System.out.println(split[m]+" Name");
										if(split[m].equalsIgnoreCase("ColumnLine"))
										{
											String date=dateRangeArray[l];
											driver.findElement(By.xpath(Object.getProperty("ChartTitleTextbox"))).sendKeys(split[m]+p);
											Thread.sleep(2000);
											WebElement type=driver.findElement(By.xpath(Object.getProperty("ChartTypeDropdown")));
											List<WebElement> typeList=type.findElements(By.tagName("option"));
											for(WebElement text : typeList)
											{
												if(text.getText().equalsIgnoreCase(split[m]))
												{
													text.click();
												}
											}
//											Date Range (X-Axis)
											type=driver.findElement(By.xpath(Object.getProperty("DateRangeTypeDropdown")));
											typeList=type.findElements(By.tagName("option"));
											for(WebElement text : typeList)
											{
												if(text.getText().equalsIgnoreCase(date))
												{
													text.click();
												}
											}
											driver.findElement(By.xpath(Object.getProperty("ChartToolTip"))).sendKeys(split[m]);
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("SingleChartPerRowCheckbox"))).click();
											Thread.sleep(2000);
//											Sensor YAxis
											type=driver.findElement(By.xpath(Object.getProperty("SensorYAxisDropdown")));
											typeList=type.findElements(By.tagName("option"));
											for(WebElement text : typeList)
											{
												if(text.getText().equalsIgnoreCase(sensorArray[0]))
												{
													text.click();
												}
											}
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("DisplayNameTextbox"))).sendKeys(sensorArray[0]);
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("ColorCodeTextbox"))).sendKeys(sensorArray[2]);
											Thread.sleep(2000);
											driver.findElement(By.xpath(Object.getProperty("RowAddButton"))).click();
											Thread.sleep(2000);
											
//											Second Column
											WebElement chart = driver.findElement(By.xpath(Object.getProperty("TableChart")+"/tbody"));
											List<WebElement> chartList=chart.findElements(By.tagName("tr"));
											System.out.println("Size of Table : "+chartList.size());
											if(chartList.size()==2 && t.isElementPresentcheck(By.xpath(Object.getProperty("SecondRowSenosr")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("SecondDisplayName")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SecondColumnType")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("SecondSensorUnit")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SecondColorCode")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("SecondScaleBySensor")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SecondScaleMin")), driver)
													&& t.isElementPresentcheck(By.xpath(Object.getProperty("SecondScaleMax")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SecondAddButton")), driver))
											{
												String secondRow = driver.findElement(By.xpath(Object.getProperty("RemoveButton"))).getText();
												System.out.println("Second Row : "+secondRow);
												type=driver.findElement(By.xpath(Object.getProperty("SecondRowSenosr")));
												typeList=type.findElements(By.tagName("option"));
												for(WebElement text : typeList)
												{
													if(text.getText().equalsIgnoreCase(sensorArray[1]))
													{
														text.click();
													}
												}
												Thread.sleep(2000);
												driver.findElement(By.xpath(Object.getProperty("SecondDisplayName"))).sendKeys(sensorArray[1]);
												Thread.sleep(2000);
												driver.findElement(By.xpath(Object.getProperty("SecondColorCode"))).sendKeys(sensorArray[3]);
												Thread.sleep(2000);
											}
											else
											{
												System.out.println("Add button is not working as expectd.");
											}
											
											//More than 2 alert Checking
											driver.findElement(By.xpath(Object.getProperty("SecondAddButton"))).click();
											Thread.sleep(500);
											if(t.isAlertPresent(driver))
											{
												System.out.println(t.alertText());
												if("Average Column Chart does not allow to add more than 2 sensor!".equalsIgnoreCase(t.alertText()))
												{
													System.out.println("Alert Displaying as expected.");
												}
												else
												{
													System.out.println("Alert Message miss match.");
												}
												driver.switchTo().alert().accept();
											}
											Thread.sleep(2000);
											
											driver.findElement(By.xpath(Object.getProperty("ChartSaveButton"))).click();
											Thread.sleep(2000);
											while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
											{
												System.out.println("inside while");
												Thread.sleep(1000);
											}
											Thread.sleep(5000);
											String val= AddFilter.chartNameCHk(split[m]+p);
											System.out.println("Val : "+val);
											if(val.equalsIgnoreCase(split[m]+p))
											{
												System.out.println("Chart Created Successfully.");
											}
											else
											{
												System.out.println("Unable to create the chart : "+split[m]+p);
											}
											Thread.sleep(2000);
											if(dateRangeArray[l].equalsIgnoreCase("Page Date Range"))
											{
												AddFilter.customDate(startDate, endDate);
											}
											String s= AddFilter.chartDate(split[m]+p,dateRangeArray[l],startDate,endDate,split[m]);
											System.out.println("Date : "+s);
											if(s.equalsIgnoreCase("true"))
											{
												System.out.println("Chart creation working as expected.");
											}
											else if(s.equalsIgnoreCase("false"))
											{
												System.out.println("Some of element missing in the created chart.  "+split[m]+p);
											}
											else if(s.equalsIgnoreCase("Chart is not exists"))
											{
												System.out.println(split[m]+p+"  chart is still not exists.");
											}
//											AddFilter.deleteChart(split[m]+p);
											driver.findElement(By.xpath(Object.getProperty("ManageChartButton"))).click();
											Thread.sleep(5000);
											driver.findElement(By.xpath(Object.getProperty("ChartNewButton"))).click();
											Thread.sleep(2000);
										}
									}*/
									
//									driver.findElement(By.xpath(Object.getProperty("ChartManageCloseButton"))).click();
								}
							}
							else
							{
								driver.findElement(By.xpath(Object.getProperty("ChartCloseButton"))).click();
								Thread.sleep(3000);
								driver.findElement(By.xpath(Object.getProperty("ChartManageCloseButton"))).click();
								System.out.println("New Button is not working as expected.");
							}
						}
						else
						{
							System.out.println("Custom Fail.");
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
