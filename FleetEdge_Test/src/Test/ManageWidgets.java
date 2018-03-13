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

public class ManageWidgets extends Core 
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]> ManageWidgetsTest(Map<String, Object[]> data, int rc, String sheet, ExtentTest test, int scase, int ecase) 
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
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ManageWidgets")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 1 is executing******************************");
						Thread.sleep(5000);
						
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("DropSearch")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("SearchBox")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionSearch")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionClear")),driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("New")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Unassign")),driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("WidgetName")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("WidgetType")),driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("TabSaveFor")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Sequence")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("TabDescription")), driver))
						{
							System.out.println("All the elements are present in the Manage Widgets");
							actRes = "All the elements are present in the Manage Widgets";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 1 finished its execution*************************");
						}
						else
						{
							System.out.println("All the elements are not present in the Manage Widgets");
							actRes = "All the elements are not present in the Manage Widgets";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
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
				//search button
				if(d[i][0].equalsIgnoreCase("TC2"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ManageWidgets")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 2 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						Select dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("DropSearch"))));
						dropdown.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						String value = driver.findElement(By.xpath(".//*[@id='tblWidgetList']/tbody/tr/td[1]")).getText();
						System.out.println("Searched Widget name: " +value);
						driver.findElement(By.xpath(Object.getProperty("SubscriptionClear"))).click();
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
				//new button
				if(d[i][0].equalsIgnoreCase("TC3"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ManageWidgets")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 3 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("New"))).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("WidgetName"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("TabDescription"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("WidgetType"))).sendKeys(split[2]);
						driver.findElement(By.xpath(Object.getProperty("TabSaveFor"))).sendKeys(split[3]);
						driver.findElement(By.xpath(Object.getProperty("Save"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						String msg = t.alertWait();
						if(msg.equalsIgnoreCase("Widget created successfully"))
						{
							Select dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("DropSearch"))));
							dropdown.selectByValue(split[4]);
							driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
							driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							
							String value = driver.findElement(By.xpath(".//*[@id='tblWidgetList']/tbody/tr/td[1]")).getText();
							System.out.println("Widget name: " +value);
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
				//edit button
				if(d[i][0].equalsIgnoreCase("TC4"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ManageWidgets")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 4 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						String value="",editVal="";
						Select dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("DropSearch"))));
						dropdown.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						 
						value = driver.findElement(By.xpath(".//*[@id='tblWidgetList']/tbody/tr/td[1]")).getText();
						System.out.println("Widget name: " +value);
						if(value.equalsIgnoreCase(split[1]))
						{
							driver.findElement(By.xpath(".//*[@id='tblWidgetList']/tbody/tr/td[1]")).click();
							t.overlay(driver);
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("Edit"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("WidgetName"))).clear();
							driver.findElement(By.xpath(Object.getProperty("WidgetName"))).sendKeys(split[2]);
							driver.findElement(By.xpath(Object.getProperty("Save"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							String msg = t.alertWait();
							if(msg.equalsIgnoreCase("Widget updated successfully"))
							{
								driver.findElement(By.xpath(Object.getProperty("SubscriptionClear"))).click();
								t.overlay(driver);
								Thread.sleep(1000);
								dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("DropSearch"))));
								dropdown.selectByValue(split[0]);
								driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[2]);
								driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
								t.overlay(driver);
								Thread.sleep(1000);
								
								editVal = driver.findElement(By.xpath(".//*[@id='tblWidgetList']/tbody/tr/td[1]")).getText();
								System.out.println("Edited widget name: " +editVal);
								if(editVal.equalsIgnoreCase(split[2]))
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
				//permission edit button
				if(d[i][0].equalsIgnoreCase("TC5"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ManageWidgets")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 5 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						String value="",permissionVal="",validate="";
						Select dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("DropSearch"))));
						dropdown.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						 
						value = driver.findElement(By.xpath(".//*[@id='tblWidgetList']/tbody/tr/td[1]")).getText();
						System.out.println("Widget name: " +value);
						if(value.equalsIgnoreCase(split[1]))
						{
							driver.findElement(By.xpath(".//*[@id='tblWidgetList']/tbody/tr/td[1]")).click();
							t.overlay(driver);
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("SensorAssignEdit"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							WebElement permission = driver.findElement(By.xpath(".//*[@id='tblEditPermissionList']/tbody"));
							List<WebElement> table = permission.findElements(By.tagName("tr"));
							System.out.println("Permission table size: " +table.size());
							for(int j=2;j<=table.size();j++)
							{
								permissionVal = driver.findElement(By.xpath(".//*[@id='tblEditPermissionList']/tbody/tr["+j+"]/td[2]")).getText();
								System.out.println("Permission: " +permissionVal);
								if(permissionVal.equalsIgnoreCase(split[2]))
								{
									driver.findElement(By.xpath(".//*[@id='tblEditPermissionList']/tbody/tr["+j+"]/td[1]/input")).click();
									driver.findElement(By.xpath(Object.getProperty("FeatureOk"))).click();
									String msg = t.alertWait();
									if(msg.equalsIgnoreCase("Success"))
									{
										driver.findElement(By.xpath(Object.getProperty("SubscriptionClear"))).click();
										t.overlay(driver);
										Thread.sleep(1000);
										break;
									}
									
								}
							}
							//validation
							dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("DropSearch"))));
							dropdown.selectByValue(split[0]);
							driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
							driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
							driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							 
							value = driver.findElement(By.xpath(".//*[@id='tblWidgetList']/tbody/tr/td[1]")).getText();
							System.out.println("Widget name: " +value);
							if(value.equalsIgnoreCase(split[1]))
							{
								driver.findElement(By.xpath(".//*[@id='tblWidgetList']/tbody/tr/td[1]")).click();
								t.overlay(driver);
								Thread.sleep(1000);
								WebElement assign = driver.findElement(By.xpath(".//*[@id='tblAssignedPermissionList']/tbody"));
								List<WebElement> tr = assign.findElements(By.tagName("tr"));
								System.out.println("size of assigned list: " +tr.size());
								for(int find=2;find<=tr.size();find++)
								{
									validate = driver.findElement(By.xpath(".//*[@id='tblAssignedPermissionList']/tbody/tr["+find+"]/td[1]")).getText();
									System.out.println("Validated list: " +validate);
									if(validate.equalsIgnoreCase(split[2]))
										break;
								}
							}
							if(validate.equalsIgnoreCase(split[2]))
							{
								System.out.println("Edit Button in Assigned Permission is working as expected");
								actRes = "Edit Button in Assigned Permission is working as expected";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 5 finished its execution*************************");
							}
							else
							{
								System.out.println("Edit Button in Assigned Permission is not working as expected");
								actRes = "Edit Button in Assigned Permission is not working as expected";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
								System.out.println("*********************TestCase 5 finished its execution*************************");
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//delete button
				if(d[i][0].equalsIgnoreCase("TC6"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ManageWidgets")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 6 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						String value="",msg="",success="",confirm="";
						Select dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("DropSearch"))));
						dropdown.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						 
						value = driver.findElement(By.xpath(".//*[@id='tblWidgetList']/tbody/tr/td[1]")).getText();
						System.out.println("Widget name: " +value);
						if(value.equalsIgnoreCase(split[1]))
						{
							driver.findElement(By.xpath(".//*[@id='tblWidgetList']/tbody/tr/td[1]")).click();
							t.overlay(driver);
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("Unassign"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Do you need to delete the Widget?"))
							{
								success = t.alertWait();
								if(success.equalsIgnoreCase("Widget deleted successfully"))
									System.out.println("Deleted the selected Widget");
							}
						}
						//validate
						driver.findElement(By.xpath(Object.getProperty("SubscriptionClear"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("DropSearch"))));
						dropdown.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						confirm = driver.findElement(By.xpath(".//*[@id='tblWidgetList']/tbody/tr/td")).getText();
						System.out.println("Deleted Widget name: " +confirm);
						if(confirm.equalsIgnoreCase("No Data Found"))
						{
							System.out.println("Delete Button is working as expected");
							actRes = "Delete Button is working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 6 finished its execution*************************");
						}
						else
						{
							System.out.println("Delete Button is not working as expected");
							actRes = "Delete Button is not working as expected";
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
