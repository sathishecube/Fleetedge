package Test;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import FleetEdge_Core.Core;
import FleetEdge_Util.*;

public class AssetDetailTab extends Core
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]> AssetDetailTabTest(Map<String, Object[]> data, int rc, String sheet, ExtentTest test, int scase, int ecase) 
	{
	
		try{
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
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("AssetTab")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 1 is executing******************************");
						Thread.sleep(5000);
						
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("DropSearch")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("SearchBox")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("SearchBtn")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("ClearBtn")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("TabName")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("TabDescription")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("New")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Unassign")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("TabType")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("TabSaveFor")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Sequence")), driver))
						{
							System.out.println("All the elements are present in the Asset Detail Tab");
							actRes = "All the elements are present in the Asset Detail Tab";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 1 finished its execution*************************");
						}
						else
						{
							System.out.println("All the elements are not present in the Asset Detail Tab");
							actRes = "All the elements are not present in the Asset Detail Tab";
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
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("AssetTab")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 2 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						Select dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("DropSearch"))));
						dropdown.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						 
						String value = driver.findElement(By.xpath(".//*[@id='tblTabList']/tbody/tr/td[1]")).getText();
						System.out.println("tab name: " +value);
						driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						if(value.equalsIgnoreCase(split[1]) && driver.findElement(By.xpath(Object.getProperty("SearchBox"))).getText().isEmpty())
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
				//New  button
				if(d[i][0].equalsIgnoreCase("TC3"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("AssetTab")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 3 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("New"))).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("TabName"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("TabDescription"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("TabType"))).sendKeys(split[2]);
						driver.findElement(By.xpath(Object.getProperty("TabSaveFor"))).sendKeys(split[3]);
						driver.findElement(By.xpath(Object.getProperty("Save"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						String msg = t.alertWait();
						if(msg.equalsIgnoreCase("Tab created successfully"))
						{
							Select dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("DropSearch"))));
							dropdown.selectByValue(split[4]);
							driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
							driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							 
							String value = driver.findElement(By.xpath(".//*[@id='tblTabList']/tbody/tr/td[1]")).getText();
							System.out.println("tab name: " +value);
							if(value.equalsIgnoreCase(split[0]))
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
								System.out.println("New Button is not working as expected");
								actRes = "New Button is not working as expected";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
								System.out.println("*********************TestCase 3 finished its execution*************************");
							}
						}
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//Edit button
				if(d[i][0].equalsIgnoreCase("TC4"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("AssetTab")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 4 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						String value="",edit="";
						Select dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("DropSearch"))));
						dropdown.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						 
						value = driver.findElement(By.xpath(".//*[@id='tblTabList']/tbody/tr/td[1]")).getText();
						System.out.println("tab name: " +value);
						if(value.equalsIgnoreCase(split[1]))
						{
							driver.findElement(By.xpath(".//*[@id='tblTabList']/tbody/tr/td[1]")).click();
							t.overlay(driver);
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("Edit"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("TabSaveFor"))).sendKeys(split[2]);
							driver.findElement(By.xpath(Object.getProperty("Save"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							String msg = t.alertWait();
							if(msg.equalsIgnoreCase("Tab updated successfully"))
							{
								driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
								t.overlay(driver);
								Thread.sleep(1000);
								Select dropdown1 = new Select(driver.findElement(By.xpath(Object.getProperty("DropSearch"))));
								dropdown1.selectByValue(split[0]);
								driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
								driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
								t.overlay(driver);
								Thread.sleep(1000);
								 
								edit = driver.findElement(By.xpath(".//*[@id='tblTabList']/tbody/tr")).getText();
								System.out.println("Edited value: " +edit);
								if(edit.contains(split[2]))
								{
									System.out.println("Edit Button is working as expected");
									actRes = "Edit Button is working as expected";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
									System.out.println("*********************TestCase 4 finished its execution*************************");
								}
								else
								{
									System.out.println("Edit Button is not working as expected");
									actRes = "Edit Button is not working as expected";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
									System.out.println("*********************TestCase 4 finished its execution*************************");
								}
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//Add Sensor Profile Button
				if(d[i][0].equalsIgnoreCase("TC5"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("AssetTab")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 5 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						String value="",msg="",name="";
						Boolean add=false,remove=false,checkbox=false;
						Select dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("DropSearch"))));
						dropdown.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						 
						value = driver.findElement(By.xpath(".//*[@id='tblTabList']/tbody/tr/td[1]")).getText();
						System.out.println("tab name: " +value);
						if(value.equalsIgnoreCase(split[1]))
						{
							driver.findElement(By.xpath(".//*[@id='tblTabList']/tbody/tr/td[1]")).click();
							t.overlay(driver);
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("SensorProfile"))).click();
							if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
							{
								checkbox = driver.findElement(By.xpath(".//*[@id='chkSelectAllSensor']")).isSelected();
								System.out.println("Checkbox: " +checkbox);
								if(checkbox==true)
								{
									add=true;
									Select opt = new Select(driver.findElement(By.xpath(Object.getProperty("ColumnSelect"))));
									List<WebElement> option = opt.getOptions();
									for(int j=0;j<option.size();j++)
									{
										System.out.println("Option: " +option.get(j).getText());
										if(option.get(j).getText().equalsIgnoreCase(split[3]))
										{
											option.get(j).click();
											driver.findElement(By.xpath(Object.getProperty("ColumnRemove"))).click();
											driver.findElement(By.xpath(Object.getProperty("SaveSensorBtn"))).click();
											msg = t.alertWait();
											if(msg.equalsIgnoreCase("Sensor Profile Updated."))
												break;
										}
									}
								}
								else
								{
								Select sensor = new Select(driver.findElement(By.xpath(Object.getProperty("ReportColumn"))));
								sensor.selectByVisibleText(split[2]);
								driver.findElement(By.xpath(Object.getProperty("AddColumn"))).click();
								Select opt = new Select(driver.findElement(By.xpath(Object.getProperty("ColumnSelect"))));
								List<WebElement> option = opt.getOptions();
								for(int j=0;j<option.size();j++)
								{
									System.out.println("Option: " +option.get(j).getText());
									if(option.get(j).getText().equalsIgnoreCase(split[3]))
									{
										option.get(j).click();
										driver.findElement(By.xpath(Object.getProperty("ColumnRemove"))).click();
										driver.findElement(By.xpath(Object.getProperty("SaveSensorBtn"))).click();
										msg = t.alertWait();
										if(msg.equalsIgnoreCase("Sensor Profile Updated."))
											break;
									}
								}
								}
							}
						}
						//validation
						driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("DropSearch"))));
						dropdown.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						name = driver.findElement(By.xpath(".//*[@id='tblTabList']/tbody/tr/td[1]")).getText();
						System.out.println("Tab name: " +name);
						if(name.equalsIgnoreCase(split[1]))
						{
							driver.findElement(By.xpath(".//*[@id='tblTabList']/tbody/tr/td[1]")).click();
							t.overlay(driver);
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("SensorProfile"))).click();
							if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
							{
								Select opt = new Select(driver.findElement(By.xpath(Object.getProperty("ColumnSelect"))));
								List<WebElement> option = opt.getOptions();
								for(int k=0;k<option.size();k++)
								{
									System.out.println("add: " +option.get(k).getText());
									if(option.get(k).getText().equalsIgnoreCase(split[2])){
										add = true;
										break;}
								}
								for(int l=0;l<option.size();l++)
								{
									System.out.println("remove: " +option.get(l).getText());
									if(!option.get(l).getText().equalsIgnoreCase(split[3])){
										remove = true;
										break;}
								}
								driver.findElement(By.xpath(Object.getProperty("CancelSensorBtn"))).click();
								t.overlay(driver);
								Thread.sleep(1000);
							}
						}
						System.out.println("Add: " +add+ " Remove: " +remove);
						if(add==true && remove==true)
						{
							System.out.println("Add Sensor Profile Button is working as expected");
							actRes = "Add Sensor Profile Button is working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 5 finished its execution*************************");
						}
						else
						{
							System.out.println("Add Sensor Profile Button is not working as expected");
							actRes = "Add Sensor Profile Button is not working as expected";	
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
				//Assigned Permission Edit button
				if(d[i][0].equalsIgnoreCase("TC6"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("AssetTab")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 6 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						String value="",text="",msg="",tableName="";
						Select dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("DropSearch"))));
						dropdown.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						 
						value = driver.findElement(By.xpath(".//*[@id='tblTabList']/tbody/tr/td[1]")).getText();
						System.out.println("tab name: " +value);
						if(value.equalsIgnoreCase(split[1]))
						{
							driver.findElement(By.xpath(".//*[@id='tblTabList']/tbody/tr/td[1]")).click();
							t.overlay(driver);
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("SensorAssignEdit"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							WebElement assign = driver.findElement(By.xpath(".//*[@id='tblEditUnAssignedPermissionList']/tbody"));
							List<WebElement> name = assign.findElements(By.tagName("tr"));
							System.out.println("Size of unassign table: " +name.size());
							for(int j=2;j<=name.size();j++)
							{
								text = driver.findElement(By.xpath(".//*[@id='tblEditUnAssignedPermissionList']/tbody/tr["+j+"]/td[2]")).getText();
								System.out.println("Table value: " +text);
								if(text.equalsIgnoreCase(split[2]))
								{
									driver.findElement(By.xpath(".//*[@id='tblEditUnAssignedPermissionList']/tbody/tr["+j+"]/td[1]/input")).click();
									driver.findElement(By.xpath(Object.getProperty("MoveLeft"))).click();
									driver.findElement(By.xpath(Object.getProperty("FeatureOk"))).click();
									msg = t.alertWait();
									if(msg.equalsIgnoreCase("Success"))
										break;
								}
							}
						}
						//validate
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblAssignedPermissionList']/tbody"));
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						System.out.println("Size of assigned table: " +tr.size());
						for(int sel=2;sel<=tr.size();sel++)
						{
							tableName = driver.findElement(By.xpath(".//*[@id='tblAssignedPermissionList']/tbody/tr["+sel+"]/td[1]")).getText();
							System.out.println("Table name: " +tableName);
							if(tableName.equalsIgnoreCase(split[2]))
								break;
						}
						if(tableName.equalsIgnoreCase(split[2]))
						{
							System.out.println("Permission Edit Button is working as expected");
							actRes = "Permission Edit Button is working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 7 finished its execution*************************");
						}
						else
						{
							System.out.println("Permission Edit Button is not working as expected");
							actRes = "Permission Edit Button is not working as expected";
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
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("AssetTab")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 7 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						String value="",msg="",success="",validate="";
						Select dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("DropSearch"))));
						dropdown.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						 
						value = driver.findElement(By.xpath(".//*[@id='tblTabList']/tbody/tr/td[1]")).getText();
						System.out.println("tab name: " +value);
						if(value.equalsIgnoreCase(split[1]))
						{
							driver.findElement(By.xpath(".//*[@id='tblTabList']/tbody/tr/td[1]")).click();
							t.overlay(driver);
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("Unassign"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Do you need to delete the Tab?"))
							{
								success = t.alertWait();
								if(success.equalsIgnoreCase("Tab deleted successfully"))
								{
									driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
									t.overlay(driver);
									Thread.sleep(1000);
								}
							}
						}
						Select dropdown1 = new Select(driver.findElement(By.xpath(Object.getProperty("DropSearch"))));
						dropdown1.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						 
						validate = driver.findElement(By.xpath(".//*[@id='tblTabList']/tbody/tr/td")).getText();
						System.out.println("tab name: " +value);
						if(validate.equalsIgnoreCase("No Data Found"))
						{
							System.out.println("Delete button is working as expected");
							actRes = "Delete button is working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 7 finished its execution*************************");
						}
						else
						{
							System.out.println("Delete Button is not working as expected");
							actRes = "Delete Button is not working as expected";
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
