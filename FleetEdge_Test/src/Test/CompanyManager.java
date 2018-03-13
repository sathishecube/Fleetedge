package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import FleetEdge_Core.Core;
import FleetEdge_Util.*;

public class CompanyManager extends Core
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]> CompanyManagerTest(Map<String, Object[]> data, int rc, String sheet, ExtentTest test, int scase, int ecase) 
	{
		try
		{
			String actRes = null;
			int counter=1;

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
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 1 is executing******************************");
						Thread.sleep(5000);
						
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("SearchBox")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("CompanySearchBtn")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("CompanyCreateBtn")), driver) || t.isElementPresentcheck(By.className("btnClear"), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("CompanyDeactivateBtn")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("SaveMakeBtn")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Information")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("CompanyEditInfo")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Users")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Permissions")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Sensors")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Roles")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("EventNotification")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("SmsTemplate")), driver))
						{
							System.out.println("All the elements are present in the Company Manager");
							actRes = "All the elements are present in the Company Manager";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 1 finished its execution*************************");
						}
						else
						{
							System.out.println("All the elements are not present in the Company Manager");
							actRes = "All the elements are not present in the Company Manager";
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
				//create button
				if(d[i][0].equalsIgnoreCase("TC2"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 2 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(Object.getProperty("CompanyCreateBtn"))).click();
						Thread.sleep(3000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							driver.findElement(By.xpath(".//*[@id='txtCCompanyName']")).sendKeys(split[0]);
							Select parent = new Select(driver.findElement(By.xpath(".//*[@id='drpParentCompany']")));
							parent.selectByVisibleText(split[1]);
							driver.findElement(By.xpath(".//*[@id='txtCCompanyCode']")).sendKeys(split[2]);
							Select logo = new Select(driver.findElement(By.xpath(".//*[@id='drpCCompanyLogo']")));
							logo.selectByVisibleText(split[3]);
							driver.findElement(By.xpath(".//*[@id='txtCCompanyDesc']")).sendKeys(split[4]);
							driver.findElement(By.xpath(".//*[@id='txtCPhone']")).sendKeys(split[5]);
							driver.findElement(By.xpath(".//*[@id='txtCExt']")).sendKeys(split[6]);
							driver.findElement(By.xpath(".//*[@id='txtCCity']")).sendKeys(split[7]);
							driver.findElement(By.xpath(".//*[@id='txtCCountry']")).sendKeys(split[8]);
							driver.findElement(By.xpath(".//*[@id='txtCAdminContact']")).sendKeys(split[9]);
							driver.findElement(By.xpath(".//*[@id='txtCAddress1']")).sendKeys(split[10]);
							driver.findElement(By.xpath(".//*[@id='txtCAddress2']")).sendKeys(split[11]);
							driver.findElement(By.xpath(".//*[@id='txtCFax']")).clear();
							driver.findElement(By.xpath(".//*[@id='txtCFax']")).sendKeys(split[12]);
							driver.findElement(By.xpath(".//*[@id='txtCState']")).sendKeys(split[13]);
							driver.findElement(By.xpath(".//*[@id='txtCZip']")).sendKeys(split[14]);
							driver.findElement(By.xpath(".//*[@id='txtCAlterEmail']")).sendKeys(split[15]);
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("CompanyInfoCreateBtn"))).click();
							t.overlay(driver);
							String msg = t.alertWait();
							if(msg.equalsIgnoreCase("Company created successfully!"))
							{
								Thread.sleep(3000);
								driver.findElement(By.xpath(".//*[@id='elClear']")).click();
								t.overlay(driver);
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
								driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
								t.overlay(driver);
								Thread.sleep(3000);
								String value = driver.findElement(By.xpath(".//*[@id='tblCompanyInfo']/tbody/tr[1]/td[2]")).getText();
								System.out.println("company name: " +value);
								if(value.equalsIgnoreCase(split[0]))
								{
									System.out.println("Company Created Successfully");
									actRes = "Company Created Successfully";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
									System.out.println("*********************TestCase 2 finished its execution*************************");
								}
								else
								{
									System.out.println("Company is not Created Successfully");
									actRes = "Company is not Created Successfully";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
									System.out.println("*********************TestCase 2 finished its execution*************************");
								}
							}
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//edit button
				if(d[i][0].equalsIgnoreCase("TC3"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 3 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Boolean edit=null,cancel=null;
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						String companyName = driver.findElement(By.xpath(".//*[@id='tblCompanyInfo']/tbody/tr[1]/td[2]")).getText();
						System.out.println("Company name: " +companyName);
						driver.findElement(By.xpath(Object.getProperty("CompanyEditInfo"))).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath(".//*[@id='txtCompanyName']")).clear();
						driver.findElement(By.xpath(".//*[@id='txtCompanyName']")).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("CompanyUpdate"))).click();
						String msg = t.alertWait();
						if(msg.equalsIgnoreCase("Company information updated!"))
						{
							Thread.sleep(5000);
							driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
							driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
							driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
							t.overlay(driver);
							String editCompany = driver.findElement(By.xpath(".//*[@id='tblCompanyInfo']/tbody/tr[1]/td[2]")).getText();
							System.out.println("Edited Company name: " +editCompany);
							if(editCompany.equalsIgnoreCase(split[1]))
								edit = true;
							else
								edit = false;
							
						}
						else
							edit = false;
						//cancel
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						driver.findElement(By.xpath(Object.getProperty("CompanyEditInfo"))).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath(".//*[@id='txtCompanyName']")).clear();
						driver.findElement(By.xpath(Object.getProperty("CompanyCancel"))).click();
						String clearCompany = driver.findElement(By.xpath(".//*[@id='tblCompanyInfo']/tbody/tr[1]/td[2]")).getText();
						System.out.println("Cancel oprn: " +clearCompany);
						if(clearCompany.equalsIgnoreCase(split[1]))
							cancel = true;
						else
							cancel = false;
						System.out.println("edit res: " +edit+ " and cancel res: " +cancel);
						//final check
						if(edit==true && cancel==true)
						{
							System.out.println("The selected Company is Updated successfully");
							actRes = "The selected Company is Updated successfully";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 3 finished its execution*************************");
						}
						else
						{
							System.out.println("The selected Company is not Updated successfully");
							actRes = "The selected Company is not Updated successfully";
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
				//save make button
				if(d[i][0].equalsIgnoreCase("TC4"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 4 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(7000);
						
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						driver.findElement(By.xpath(".//*[@id='divCompanyMakeTag']/div/input")).clear();

						driver.findElement(By.xpath(".//*[@id='divCompanyMakeTag']/div/input")).sendKeys(split[1]);
						Thread.sleep(2000);
						List<WebElement> option = driver.findElements(By.xpath("/html/body/ul[3]/li"));
						System.out.println("size: " +option.size());
						for(WebElement opt : option)
						{
							System.out.println("options: " +opt.getText());
							if(opt.getText().equalsIgnoreCase(split[1]))
							{
								opt.click();
								break;
							}
						}
						driver.findElement(By.xpath(Object.getProperty("SaveMakeBtn"))).click();
						t.overlay(driver);
						String msg = t.alertWait();
						if(msg.equalsIgnoreCase("Success"))
						{
							String make = driver.findElement(By.className("tagtacular_tag_tray")).getText();
						//	System.out.println("Make added text in the tray: " +make);
							if(make.contains(split[1]))
							{
								System.out.println("Save Make Button is working as expected");
								actRes = "Save Make Button is working as expected";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 4 finished its execution*************************");
							}
							else
							{
								System.out.println("Save Make Button is not working as expected");
								actRes = "Save Make Button is not working as expected";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
								System.out.println("*********************TestCase 4 finished its execution*************************");
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//deactivate button
				if(d[i][0].equalsIgnoreCase("TC5"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(5000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 5 is executing******************************");
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(d[i][5]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						driver.findElement(By.xpath(Object.getProperty("CompanyDeactivateBtn"))).click();
						String msg = t.alertWait();					
						if(msg.equalsIgnoreCase("Do you want to delete the selected company?"))
						{
							String success = t.alertWait();
							if(success.equalsIgnoreCase("Successfully deactivated"))
							{
								System.out.println("The selected Company is Deactivated successfully");
								actRes = "The selected Company is Deactivated successfully";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 5 finished its execution*************************");
							}
							else
							{
								System.out.println("The selected Company is not Deactivated successfully");
								actRes = "The selected Company is not Deactivated successfully";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
								System.out.println("*********************TestCase 5 finished its execution*************************");
							}
						} 
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//Edit button (Permission)
				if(d[i][0].equalsIgnoreCase("TC6"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 6 is executing******************************");
						Thread.sleep(3000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Boolean ok=null,cancel=null;
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						driver.findElement(By.xpath(Object.getProperty("Permissions"))).click();
						t.overlay(driver);
						WebElement assignTable = driver.findElement(By.xpath(".//*[@id='tblAssignedPermissionList']/tbody"));
						List<WebElement> assignTr = assignTable.findElements(By.tagName("tr"));
						System.out.println("Assigned table size: " +assignTr.size());
						ArrayList<String> before = new ArrayList<String>();
						for(int j=2;j<=assignTr.size();j++)
						{
							String tableData = driver.findElement(By.xpath(".//*[@id='tblAssignedPermissionList']/tbody/tr["+j+"]/td[1]")).getText();
							before.add(tableData);
							//System.out.println(before.get(j-2));
						}
					/*	WebDriverWait wait = new WebDriverWait(driver, 35);
						wait.until(ExpectedConditions.elementToBeClickable(By.xpath(Object.getProperty("PermissionEdit"))));*/
						Thread.sleep(15000);
						driver.findElement(By.xpath(Object.getProperty("PermissionEdit"))).click();
						WebElement editTable = driver.findElement(By.xpath(".//*[@id='tblEditPermissionList']/tbody"));
						List<WebElement> tr = editTable.findElements(By.tagName("tr"));
						System.out.println("Size of Permission table: " +tr.size());
						for(int k=2;k<=tr.size();k++)
						{
							String permissionStr = driver.findElement(By.xpath(".//*[@id='tblEditPermissionList']/tbody/tr["+k+"]/td[2]")).getText();
						//	System.out.println("Permission: " +permissionStr);
							if(permissionStr.equalsIgnoreCase(split[1]))
							{
								driver.findElement(By.xpath(".//*[@id='tblEditPermissionList']/tbody/tr["+k+"]/td[1]/div/input")).click();
								break;
							}
						}
						driver.findElement(By.xpath(Object.getProperty("PermissionOk"))).click();
						t.overlay(driver);
						String msg = t.alertWait();
						if(msg.equalsIgnoreCase("Success"))
						{
							Thread.sleep(3000);
							WebElement assignTable1 = driver.findElement(By.xpath(".//*[@id='tblAssignedPermissionList']/tbody"));
							List<WebElement> assignTr1 = assignTable1.findElements(By.tagName("tr"));
							System.out.println("Assigned table size: " +assignTr1.size());
							for(int l=2;l<=assignTr1.size();l++)
							{
								String tableData1 = driver.findElement(By.xpath(".//*[@id='tblAssignedPermissionList']/tbody/tr["+l+"]/td[1]")).getText();
								System.out.println("tableData: " +tableData1);
								if(tableData1.equalsIgnoreCase(split[1])){
									ok = true;
									break;}
								else
									ok = false;
							}
						}
						//cancel
						driver.findElement(By.xpath(Object.getProperty("PermissionEdit"))).click();
						editTable = driver.findElement(By.xpath(".//*[@id='tblEditPermissionList']/tbody"));
						List<WebElement> tr1 = editTable.findElements(By.tagName("tr"));
						System.out.println("Size of Permission table: " +tr1.size());
						for(int k=2;k<=tr1.size();k++)
						{
							String permissionStr = driver.findElement(By.xpath(".//*[@id='tblEditPermissionList']/tbody/tr["+k+"]/td[2]")).getText();
						//	System.out.println("Permission: " +permissionStr);
							if(permissionStr.equalsIgnoreCase(split[2]))
							{
								driver.findElement(By.xpath(".//*[@id='tblEditPermissionList']/tbody/tr["+k+"]/td[1]/div/input")).click();
								break;
							}
						}
						driver.findElement(By.xpath(Object.getProperty("PermissionCancel"))).click();
						t.overlay(driver);
						editTable = driver.findElement(By.xpath(".//*[@id='tblEditPermissionList']/tbody"));
						List<WebElement> tr2 = editTable.findElements(By.tagName("tr"));
						System.out.println("Size of Permission table: " +tr2.size());
						if(tr1.size()==tr2.size())
							cancel = true;
						else
							cancel = false;
						System.out.println("edit res: " +ok+ " cancel res: " +cancel);
						//final check
						if(ok==true && cancel==true)
						{
							System.out.println("The permission is enabled for the selected company and is successfully modified");
							actRes = "The permission is enabled for the selected company and is successfully modified";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 6 finished its execution*************************");
						}
						else
						{
							System.out.println("The permission is not modified for the selected company");
							actRes = "The permission is not modified for the selected company";
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
				//new button (role)
				if(d[i][0].equalsIgnoreCase("TC7"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 7 is executing******************************");
						Thread.sleep(3000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						
						driver.findElement(By.xpath(Object.getProperty("Roles"))).click();
						t.overlay(driver);
						driver.findElement(By.xpath(Object.getProperty("RoleNew"))).click();
						Thread.sleep(3000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("PassValue"))).sendKeys(split[1]);
							Thread.sleep(2000);
							driver.findElement(By.xpath(".//*[@id='btnRoleOk']")).click();
							t.overlay(driver);
							String msg = t.alertWait();
							if(msg.equalsIgnoreCase("Role created successfully"))
							{
								WebElement roleTable = driver.findElement(By.xpath(Object.getProperty("RoleTableData")));
								List<WebElement> roleData = roleTable.findElements(By.tagName("tr"));
								String roleCreated = "";
								for(int k=2;k<=roleData.size();k++)
								{
									String role = driver.findElement(By.xpath(".//*[@id='tblRoleList']/tbody/tr["+k+"]/td")).getText();
									System.out.println("Role name: " +role);
									if(role.equalsIgnoreCase(split[1]))
									{
										roleCreated = role;
										break;
									}		
								}
								if(roleCreated.equalsIgnoreCase(split[1]))
								{
									System.out.println("Role is created successfully");
									actRes = "Role is created successfully";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
									System.out.println("*********************TestCase 7 finished its execution*************************");
								}
								else
								{
									System.out.println("Role is not created successfully");
									actRes = "Role is not created successfully";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
									System.out.println("*********************TestCase 7 finished its execution*************************");
								}
							}
						}
						
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//edit button (roles)
				if(d[i][0].equalsIgnoreCase("TC8"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 8 is executing******************************");
						Thread.sleep(3000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						
						driver.findElement(By.xpath(Object.getProperty("Roles"))).click();
						t.overlay(driver);
						WebElement roleTable = driver.findElement(By.xpath(Object.getProperty("RoleTableData")));
						List<WebElement> roleData = roleTable.findElements(By.tagName("tr"));
						for(int j=2;j<=roleData.size();j++)
						{
							String role = driver.findElement(By.xpath(".//*[@id='tblRoleList']/tbody/tr["+j+"]/td")).getText();
							System.out.println("Edit Role name: " +role);
							if(role.equalsIgnoreCase(split[1]))
							{
								Thread.sleep(3000);
								driver.findElement(By.xpath(".//*[@id='tblRoleList']/tbody/tr["+j+"]/td")).click();
								t.overlay(driver);
								driver.findElement(By.xpath(Object.getProperty("RoleEdit"))).click();
								if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
								{
									driver.findElement(By.xpath(Object.getProperty("PassValue"))).clear();
									driver.findElement(By.xpath(Object.getProperty("PassValue"))).sendKeys(split[2]);
									Thread.sleep(2000);
									driver.findElement(By.xpath(".//*[@id='btnRoleOk']")).click();
									String msg = t.alertWait();
									if(msg.equalsIgnoreCase("Role updated successfully"))
										break;
								}
							}
						}
						WebElement roleTable1 = driver.findElement(By.xpath(Object.getProperty("RoleTableData")));
						List<WebElement> roleData1 = roleTable1.findElements(By.tagName("tr"));
						String editName = "";
						for(int j=2;j<=roleData1.size();j++)
						{
							String role = driver.findElement(By.xpath(".//*[@id='tblRoleList']/tbody/tr["+j+"]/td")).getText();
							if(role.equalsIgnoreCase(split[2]))
								editName = role;
						}
						if(editName.equalsIgnoreCase(split[2]))
						{
							System.out.println("Role is Edited successfully");
							actRes = "Role is Edited successfully";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 8 finished its execution*************************");
						}
						else
						{
							System.out.println("Role is not Edited successfully");
							actRes = "Role is not Edited successfully";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 8 finished its execution*************************");
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//delete button (roles)
				if(d[i][0].equalsIgnoreCase("TC9"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 9 is executing******************************");
						Thread.sleep(3000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(5000);
								
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						driver.findElement(By.xpath(Object.getProperty("Roles"))).click();
						WebElement roleTable = driver.findElement(By.xpath(Object.getProperty("RoleTableData")));
						List<WebElement> roleData = roleTable.findElements(By.tagName("tr"));
						System.out.println("Role table size: " +roleData.size());
						for(int j=2;j<=roleData.size();j++)
						{
							String role = driver.findElement(By.xpath(".//*[@id='tblRoleList']/tbody/tr["+j+"]/td")).getText();
							System.out.println("Role name: " +role);
							if(role.equalsIgnoreCase(split[1]))
							{
								Thread.sleep(3000);
								driver.findElement(By.xpath(".//*[@id='tblRoleList']/tbody/tr["+j+"]/td")).click();
								t.overlay(driver);
								driver.findElement(By.xpath(Object.getProperty("RoleDelete"))).click();
								String msg = t.alertWait();
								if(msg.equalsIgnoreCase("Do you want to deactivate the selected role?"))
								{
									String msg1 = t.alertWait();
									if(msg1.equalsIgnoreCase("Role deactivated successfully"))
										break;
								}
							}
						}
						Thread.sleep(3000);
						WebElement roleTable1 = driver.findElement(By.xpath(Object.getProperty("RoleTableData")));
						List<WebElement> roleData1 = roleTable1.findElements(By.tagName("tr"));
						Boolean delete = null;
						for(int k=2;k<=roleData1.size();k++)
						{
							String role1 = driver.findElement(By.xpath(".//*[@id='tblRoleList']/tbody/tr["+k+"]/td")).getText();
							System.out.println("Role name: " +role1);
							if(!role1.equalsIgnoreCase(split[1]))
								delete = true;
							else
								delete = false;
						}
						if(delete==true)
						{
							System.out.println("Delete button in Role is working as expected");
							actRes = "Delete button in Role is working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 9 finished its execution*************************");
						}
						else
						{
							System.out.println("Delete button in Role is not working as expected");
							actRes = "Delete button in Role is not working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 9 finished its execution*************************");
						}
						
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//copy from button (roles)
				if(d[i][0].equalsIgnoreCase("TC10"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 10 is executing******************************");
						Thread.sleep(3000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						
						driver.findElement(By.xpath(Object.getProperty("Roles"))).click();
						t.overlay(driver);
						driver.findElement(By.xpath(Object.getProperty("RoleCopy"))).click();
						t.overlay(driver);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("EnableAll"))).click();
							WebElement copy = driver.findElement(By.xpath(".//*[@id='tblCopyRole']/tbody"));
							List<WebElement> copyTab = copy.findElements(By.tagName("tr"));
							System.out.println("Copy table size: " +copyTab.size());
							for(int j=2;j<=copyTab.size();j++)
							{
								String table = driver.findElement(By.xpath(".//*[@id='tblCopyRole']/tbody/tr["+j+"]/td[2]")).getText();
								System.out.println("Copy table val: " +table);
								if(table.equalsIgnoreCase(split[1]))
								{
									driver.findElement(By.xpath(".//*[@id='tblCopyRole']/tbody/tr["+j+"]/td[1]/input")).click();
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("CopyFromOk"))).click();
									Thread.sleep(2000);
									t.overlay(driver);
									String msg = t.alertWait();
									if(msg.equalsIgnoreCase("Success"))
										break;
									else if(msg.contains("Duplicate Role Name -")){
										driver.findElement(By.xpath(Object.getProperty("CopyFromCancel"))).click();
										t.overlay(driver);
										break;}
								}
							}
						}
						//validation
						Thread.sleep(3000);
						WebElement roleTable = driver.findElement(By.xpath(Object.getProperty("RoleTableData")));
						List<WebElement> roleData = roleTable.findElements(By.tagName("tr"));
						Boolean copy = null;
						for(int k=2;k<=roleData.size();k++)
						{
							String role = driver.findElement(By.xpath(".//*[@id='tblRoleList']/tbody/tr["+k+"]/td")).getText();
							System.out.println("Role name: " +role);
							if(!role.equalsIgnoreCase(split[1]))
								copy = true;
							else
								copy = false;
						}
						if(copy==true)
						{
							System.out.println("Copy From button in Role is working as expected");
							actRes = "Copy From in Role is working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 10 finished its execution*************************");
						}
						else
						{
							System.out.println("Copy From in Role is not working as expected");
							actRes = "Copy From in Role is not working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 10 finished its execution*************************");
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//Assigned Edit button (role)
				if(d[i][0].equalsIgnoreCase("TC11"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 11 is executing******************************");
						Thread.sleep(3000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						
						driver.findElement(By.xpath(Object.getProperty("Roles"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						//copy the role
						driver.findElement(By.xpath(Object.getProperty("RoleCopy"))).click();
						t.overlay(driver);
						Thread.sleep(2000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("EnableAll"))).click();
							WebElement copy = driver.findElement(By.xpath(".//*[@id='tblCopyRole']/tbody"));
							List<WebElement> copyTab = copy.findElements(By.tagName("tr"));
							System.out.println("Copy table size: " +copyTab.size());
							for(int j=2;j<=copyTab.size();j++)
							{
								String table = driver.findElement(By.xpath(".//*[@id='tblCopyRole']/tbody/tr["+j+"]/td[2]")).getText();
								System.out.println("Copy table val: " +table);
								if(table.equalsIgnoreCase(split[1]))
								{
									driver.findElement(By.xpath(".//*[@id='tblCopyRole']/tbody/tr["+j+"]/td[1]/input")).click();
									Thread.sleep(3000);
									driver.findElement(By.xpath(Object.getProperty("CopyFromOk"))).click();
									Thread.sleep(1000);
									t.overlay(driver);
									String msg = t.alertWait();
									if(msg.equalsIgnoreCase("Success"))
										break;
									else if(msg.contains("Duplicate Role Name -")){
										driver.findElement(By.xpath(Object.getProperty("CopyFromCancel"))).click();
										t.overlay(driver);
										break;}
								}
							}
						}
						//assign permission for the Role
						WebElement roleTable = driver.findElement(By.xpath(Object.getProperty("RoleTableData")));
						List<WebElement> roleData = roleTable.findElements(By.tagName("tr"));
						for(int k=2;k<=roleData.size();k++)
						{
							String role = driver.findElement(By.xpath(".//*[@id='tblRoleList']/tbody/tr["+k+"]/td")).getText();
							System.out.println("Role name: " +role);
							if(role.equalsIgnoreCase(split[1])){
								driver.findElement(By.xpath(".//*[@id='tblRoleList']/tbody/tr["+k+"]/td")).click();
								break;}
						}
						WebElement assignEdit = driver.findElement(By.xpath(Object.getProperty("AssignedEdit")));
						JavascriptExecutor js = (JavascriptExecutor)driver;
						js.executeScript("arguments[0].click();", assignEdit);
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement permissionTable = driver.findElement(By.xpath(".//*[@id='tblEditRolePermission']/tbody"));
						List<WebElement> tr = permissionTable.findElements(By.tagName("tr"));
						System.out.println("Permission table size in Role: " +tr.size());
						for(int find=2;find<=tr.size();find++)
						{
							Thread.sleep(3500);
							String editVal = driver.findElement(By.xpath(".//*[@id='tblEditRolePermission']/tbody/tr[" +find+ "]/td[2]")).getText();
							System.out.println("Edit Permission table value: " +editVal);
							if(editVal.equalsIgnoreCase(split[2])){
								driver.findElement(By.xpath(".//*[@id='tblEditRolePermission']/tbody/tr[" +find+ "]/td[1]/div/input")).click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("RolePermissionOk"))).click();
								t.overlay(driver);
								break;
							}
						}
						Thread.sleep(2000);
						String msg = t.alertWait();
						Boolean edit = null;
						if(msg.equalsIgnoreCase("Success"))
						{
							WebDriverWait wait = new WebDriverWait(driver, 10);
							wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='tblRoleAssignedPermissions']/tbody")));
							WebElement table = driver.findElement(By.xpath(".//*[@id='tblRoleAssignedPermissions']/tbody"));
							List<WebElement> tab = table.findElements(By.tagName("tr"));
							for(int select=2;select<=tab.size();select++)
							{
								String tabVal = driver.findElement(By.xpath(".//*[@id='tblRoleAssignedPermissions']/tbody/tr["+select+"]/td[1]")).getText();
								System.out.println("Edited table val: " +tabVal);
								if(tabVal.equalsIgnoreCase(split[2])){
									edit = true;
									break;
								}
								else
									edit = false;
							}
						}
						//delete
						WebElement roleTable1 = driver.findElement(By.xpath(Object.getProperty("RoleTableData")));
						List<WebElement> roleData1 = roleTable1.findElements(By.tagName("tr"));
						for(int k=2;k<=roleData1.size();k++)
						{
							String role1 = driver.findElement(By.xpath(".//*[@id='tblRoleList']/tbody/tr["+k+"]/td")).getText();
							System.out.println("Role name: " +role1);
							if(role1.equalsIgnoreCase(split[1]))
							{
								driver.findElement(By.xpath(".//*[@id='tblRoleList']/tbody/tr["+k+"]/td")).click();
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("RoleDelete"))).click();
								String msg1 = t.alertWait();
								if(msg1.equalsIgnoreCase("Do you want to deactivate the selected role?"))
								{
									String success = t.alertWait();
									if(success.equalsIgnoreCase("Role deactivated successfully"))
										break;
								}
							}
						}
						if(edit==true)
						{
							System.out.println("Assigned Permission Edit Button in Role is working as expected");
							actRes = "Assigned Permission Edit Button in Role is working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 11 finished its execution*************************");
						}
						else
						{
							System.out.println("Assigned Permission Edit Button in Role is not working as expected");
							actRes = "Assigned Permission Edit Button in Role is not working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 11 finished its execution*************************");
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//search button (user)
				if(d[i][0].equalsIgnoreCase("TC12"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 12 is executing******************************");
						Thread.sleep(3000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						
						driver.findElement(By.xpath(Object.getProperty("Users"))).click();
						t.overlay(driver);
						Thread.sleep(5000);
						
						Select dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("UserSelect"))));
						dropdown.selectByValue(split[1]);					
						driver.findElement(By.xpath(Object.getProperty("UserSearchBox"))).sendKeys(split[2]);
						driver.findElement(By.xpath(Object.getProperty("BtnUserSearch"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						String tableVal = driver.findElement(By.xpath(".//*[@id='tblUserList']/tbody/tr[1]")).getText();
						System.out.println("table value: " +tableVal);
						driver.findElement(By.xpath(Object.getProperty("BtnUserClear"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						if(tableVal.contains(split[2]) && driver.findElement(By.xpath(Object.getProperty("UserSearchBox"))).getText().isEmpty())
						{
							System.out.println("Search and clear button are working as expected");
							actRes = "Search and clear button are working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 12 finished its execution*************************");
						}
						else
						{
							System.out.println("Search and clear button are not working as expected");
							actRes = "Search and clear button are not working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 12 finished its execution*************************");
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//Edit user button
				if(d[i][0].equalsIgnoreCase("TC13"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 13 is executing******************************");
						Thread.sleep(3000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(5000);

						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						
						driver.findElement(By.xpath(Object.getProperty("Users"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						Select dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("UserSelect"))));
						dropdown.selectByValue(split[1]);					
						driver.findElement(By.xpath(Object.getProperty("UserSearchBox"))).sendKeys(split[2]);
						driver.findElement(By.xpath(Object.getProperty("BtnUserSearch"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						driver.findElement(By.xpath(".//*[@id='tblUserList']/tbody/tr[1]/td[1]")).click();
						driver.findElement(By.xpath(Object.getProperty("UserEdit"))).click();
						Thread.sleep(5000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							Select dateFormat = new Select(driver.findElement(By.xpath(".//*[@id='ddEDateTimeFormat']")));
							dateFormat.selectByVisibleText(split[3]);
							driver.findElement(By.xpath(Object.getProperty("UserUpdate"))).click();
							String msg = t.alertWait();
							if(msg.equalsIgnoreCase("Changes updated successfully"))
							{
								System.out.println("The changes are updated successfully");
								actRes = "The changes are updated successfully";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 13 finished its execution*************************");
							}
							else
							{
								System.out.println("The changes are not updated successfully");
								actRes = "The changes are not updated successfully";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
								System.out.println("*********************TestCase 13 finished its execution*************************");
							}
						}
						
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//Deactivate user button
				if(d[i][0].equalsIgnoreCase("TC14"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 14 is executing******************************");
						Thread.sleep(3000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(5000);

						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						
						driver.findElement(By.xpath(Object.getProperty("Users"))).click();
						t.overlay(driver);
						Thread.sleep(3000);
						
						Select dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("UserSelect"))));
						dropdown.selectByValue(split[1]);
						driver.findElement(By.xpath(Object.getProperty("UserSearchBox"))).sendKeys(split[2]);
						driver.findElement(By.xpath(Object.getProperty("BtnUserSearch"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						driver.findElement(By.xpath(".//*[@id='tblUserList']/tbody/tr[1]/td[1]")).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath(Object.getProperty("UserDeactivate"))).click();
						t.overlay(driver);
						Thread.sleep(2000);
						String msg = t.alertWait();
						if(msg.equalsIgnoreCase("Do you want to deactivate the selected user?"))
						{
							String success = t.alertWait();
							if(success.equalsIgnoreCase("User deactivated successfully"))
							{
								Thread.sleep(2000);
								driver.findElement(By.xpath(Object.getProperty("BtnUserClear"))).click();
								t.overlay(driver);
								Thread.sleep(1000);
								dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("UserSelect"))));
								dropdown.selectByValue(split[1]);
								driver.findElement(By.xpath(Object.getProperty("UserSearchBox"))).sendKeys(split[2]);
								driver.findElement(By.xpath(Object.getProperty("BtnUserSearch"))).click();
								t.overlay(driver);
								Thread.sleep(1000);
								String value = driver.findElement(By.xpath(".//*[@id='tblUserList']/tbody/tr/td")).getText();
								System.out.println("table value: " +value);
												
								if(value.equalsIgnoreCase("No Data Found"))
								{
									System.out.println("The User is Deactivated Successfully");
									actRes = "The User is Deactivated Successfully";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
									System.out.println("*********************TestCase 14 finished its execution*************************");
								}
								else
								{
									System.out.println("The User is not Deactivated Successfully");
									actRes = "The User is not Deactivated Successfully";
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
									System.out.println("*********************TestCase 14 finished its execution*************************");
								}
							}
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//Edit Button in Sensors
				if(d[i][0].equalsIgnoreCase("TC15"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 15 is executing******************************");
						Thread.sleep(3000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);

						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						
						driver.findElement(By.xpath(Object.getProperty("Sensors"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						driver.findElement(By.xpath(Object.getProperty("SensorEdit"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						WebElement sensorTab = driver.findElement(By.xpath(".//*[@id='tblCMEditSensors']/tbody"));
						List<WebElement> table = sensorTab.findElements(By.tagName("tr"));
						System.out.println("Size of sensor table: " +table.size());
						for(int j=2;j<=table.size();j++)
						{
							String sensorName = driver.findElement(By.xpath(".//*[@id='tblCMEditSensors']/tbody/tr["+j+"]/td[2]")).getText();
							System.out.println("Sensor name: " +sensorName);
							if(sensorName.equalsIgnoreCase(split[1]))
							{
								driver.findElement(By.xpath(".//*[@id='tblCMEditSensors']/tbody/tr["+j+"]/td[1]/input")).click();
								Thread.sleep(1000);
								driver.findElement(By.xpath(Object.getProperty("SensorOk"))).click();
								String msg = t.alertWait();
								if(msg.equalsIgnoreCase("Sensors updated successfully."))
									break;
							}
						}
						//validate
						WebElement sensorsList = driver.findElement(By.xpath(".//*[@id='tblAssignedChartSensorsList']/tbody"));
						List<WebElement> list = sensorsList.findElements(By.tagName("tr"));
						System.out.println("Sensor Chart list size: " +list.size());
						Boolean edit=false;
						for(int find=2;find<=list.size();find++)
						{
							String name = driver.findElement(By.xpath(".//*[@id='tblAssignedChartSensorsList']/tbody/tr["+find+"]/td[1]")).getText();
							System.out.println("name of sensor: " +name);
							if(name.equalsIgnoreCase(split[1])){
								edit = true;
								break;}
						}
						if(edit==true)
						{
							System.out.println("Sensor Edit Button is working as expected");
							actRes = "Sensor Edit Button is working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 15 finished its execution*************************");
						}
						else
						{
							System.out.println("Sensor Edit Button is not working as expected");
							actRes = "Sensor Edit Button is not working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 15 finished its execution*************************");
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//Update Button in Event Notification
				if(d[i][0].equalsIgnoreCase("TC16"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 16 is executing******************************");
						Thread.sleep(3000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);

						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						
						driver.findElement(By.xpath(Object.getProperty("EventNotification"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						WebElement event = driver.findElement(By.xpath(".//*[@id='tblEventNotificationList']/tbody"));
						List<WebElement> eventData = event.findElements(By.tagName("tr"));
						System.out.println("Size of event table: " +eventData.size());
						int tr=0;
						String priority="", priorA="";
						Boolean sms=null,email=null,smsA=null,emailA=null;
						for(int j=2;j<=eventData.size();j++)
						{
							String eventName = driver.findElement(By.xpath(".//*[@id='tblEventNotificationList']/tbody/tr["+j+"]/td[1]")).getText();
							System.out.println("Event name: " +eventName);
							if(eventName.equalsIgnoreCase(split[1]))
							{
								tr = j;
								break;
							}						
						}
						System.out.println("tr number: " +tr);
						
						priority = new Select(driver.findElement(By.xpath(".//*[@id='tblEventNotificationList']/tbody/tr["+tr+"]/td[2]/select"))).getFirstSelectedOption().getText();
						System.out.println("Priority: " +priority);
						Thread.sleep(2000);
						Select prior = new Select(driver.findElement(By.xpath(".//*[@id='tblEventNotificationList']/tbody/tr["+tr+"]/td[2]/select")));
						prior.selectByValue(split[2]);
						
						sms = driver.findElement(By.xpath(".//*[@id='tblEventNotificationList']/tbody/tr["+tr+"]/td[3]/input")).isSelected();
						System.out.println("Sms: " +sms);
						driver.findElement(By.xpath(".//*[@id='tblEventNotificationList']/tbody/tr["+tr+"]/td[3]/input")).click();
						
						email = driver.findElement(By.xpath(".//*[@id='tblEventNotificationList']/tbody/tr["+tr+"]/td[4]/input")).isSelected();
						System.out.println("Email: " +email);
						Thread.sleep(3000);
						driver.findElement(By.xpath(".//*[@id='tblEventNotificationList']/tbody/tr["+tr+"]/td[4]/input")).click();
						
						driver.findElement(By.xpath(Object.getProperty("UpdateEvent"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						String alert = t.alertWait();
						if(alert.equalsIgnoreCase("Event notification updated successfully!"))
						{
							priorA = new Select(driver.findElement(By.xpath(".//*[@id='tblEventNotificationList']/tbody/tr["+tr+"]/td[2]/select"))).getFirstSelectedOption().getText();
							System.out.println("After editing priority: " +priorA);
							
							smsA = driver.findElement(By.xpath(".//*[@id='tblEventNotificationList']/tbody/tr["+tr+"]/td[3]/input")).isSelected();
							System.out.println("After editing Sms: " +smsA);
							
							emailA = driver.findElement(By.xpath(".//*[@id='tblEventNotificationList']/tbody/tr["+tr+"]/td[4]/input")).isSelected();
							System.out.println("After editing Email: " +emailA);
						}
						if(!priority.equalsIgnoreCase(priorA) && sms!=smsA && email!=emailA)
						{
							System.out.println("Update button is working as expected");
							actRes = "Update button is working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 16 finished its execution*************************");
						}
						else
						{
							System.out.println("Update button is not working as expected");
							actRes = "Update button is not working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 16 finished its execution*************************");
						}
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				//Edit Button in SMS/Email Template
				if(d[i][0].equalsIgnoreCase("TC17"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 17 is executing******************************");
						Thread.sleep(3000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);

						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						
						driver.findElement(By.xpath(Object.getProperty("SmsTemplate"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						WebElement templateTable = driver.findElement(By.xpath(".//*[@id='tblEmailTemplateList']/tbody"));
						List<WebElement> tab = templateTable.findElements(By.tagName("tr"));
						System.out.println("Size of Template Table: "+tab.size());
						for(int j=2;j<=tab.size();j++)
						{
							String value = driver.findElement(By.xpath(".//*[@id='tblEmailTemplateList']/tbody/tr["+j+"]/td[1]")).getText();
							System.out.println("Value: " +value);
							if(value.equalsIgnoreCase(split[1]))
							{
								driver.findElement(By.xpath(".//*[@id='tblEmailTemplateList']/tbody/tr["+j+"]/td[1]")).click();
								JavascriptExecutor js = (JavascriptExecutor)driver;
								js.executeScript("arguments[0].click();", driver.findElement(By.xpath(Object.getProperty("TemplateEdit")))); 
								t.overlay(driver);
								Thread.sleep(1000);
								break;
							}
						}
						driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/table/tbody/tr[4]/td[2]/div[2]/div/div[3]")).sendKeys(split[2]);
						driver.findElement(By.xpath(Object.getProperty("TemplateSave"))).click();
						String msg="",success = "",temp=""; 
						msg = t.alertWait();
						if(msg.equalsIgnoreCase("SMS/Email Template updated successfully."))
						{
							WebElement templateTable1 = driver.findElement(By.xpath(".//*[@id='tblEmailTemplateList']/tbody"));
							List<WebElement> tab1 = templateTable1.findElements(By.tagName("tr"));
							System.out.println("Size of Template Table: "+tab1.size());
							for(int k=2;k<=tab1.size();k++)
							{
								String value = driver.findElement(By.xpath(".//*[@id='tblEmailTemplateList']/tbody/tr["+k+"]/td[1]")).getText();
								System.out.println("Value: " +value);
								if(value.equalsIgnoreCase(split[1]))
								{
									driver.findElement(By.xpath(".//*[@id='tblEmailTemplateList']/tbody/tr["+k+"]/td[1]")).click();
									JavascriptExecutor js = (JavascriptExecutor)driver;
									js.executeScript("arguments[0].click();", driver.findElement(By.xpath(Object.getProperty("TemplateEdit"))));
									t.overlay(driver);
									Thread.sleep(1000);
									driver.findElement(By.xpath(Object.getProperty("ResetTemplate"))).click();
									temp = t.alertWait();
									if(temp.equalsIgnoreCase("Do you want to reset template!"))
									{
										driver.findElement(By.xpath(Object.getProperty("TemplateSave"))).click();
										success = t.alertWait();
										if(success.equalsIgnoreCase("SMS/Email Template updated successfully."))
											break;
									}
								}
							}
						}
						if(msg.equalsIgnoreCase(success))
						{
							System.out.println("Template is updated successfully");
							actRes = "Template is updated successfully";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 17 finished its execution*************************");
						}
						else
						{
							System.out.println("Template is not updated successfully");
							actRes = "Template is not updated successfully";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 17 finished its execution*************************");
						}
						
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
				if(d[i][0].equalsIgnoreCase("TC18"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 18 is executing******************************");
						Thread.sleep(3000);
						
						String msg="",tableCode="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);

						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						
						driver.findElement(By.xpath(Object.getProperty("EmailTemplate"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						driver.findElement(By.xpath(Object.getProperty("CreateEmailTemplate"))).click();
						t.overlay(driver);
						Thread.sleep(2000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							Select code = new Select(driver.findElement(By.xpath(Object.getProperty("TemplateCode"))));
							code.selectByVisibleText(split[1]);
							driver.findElement(By.xpath(Object.getProperty("Identifier"))).sendKeys(split[2]);
							driver.findElement(By.xpath(Object.getProperty("EmailSubject"))).sendKeys(split[3]);
							t.overlay(driver);
							Thread.sleep(1000);
							driver.findElement(By.className("jqte_editor")).click();						
							driver.findElement(By.className("jqte_editor")).sendKeys(split[4]);
							driver.findElement(By.xpath(Object.getProperty("EmailSaveBtn"))).click();
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Company email template created successfully."))
							{
								WebElement table = driver.findElement(By.xpath(".//*[@id='tblCompanyEmailTemplateList']/tbody"));
								List<WebElement> tr = table.findElements(By.tagName("tr"));
								for(int j=2;j<=tr.size();j++)
								{
									tableCode = driver.findElement(By.xpath(".//*[@id='tblCompanyEmailTemplateList']/tbody/tr["+j+"]/td[1]")).getText();
									System.out.println("Table Code: " +tableCode);
									if(tableCode.equalsIgnoreCase(split[1]))
										break;
								}
							}
							if(tableCode.equalsIgnoreCase(split[1]))
							{
								actRes = "Email Template is created successfully";
								System.out.println(actRes);
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 18 finished its execution*************************");
							}
							else
							{
								actRes = "Email Template is not created successfully";
								System.out.println(actRes);
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
								System.out.println("*********************TestCase 18 finished its execution*************************");
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//edit email template
				if(d[i][0].equalsIgnoreCase("TC19"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 19 is executing******************************");
						Thread.sleep(3000);
						
						String msg="",tableCode="",tabIdent="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);

						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						
						driver.findElement(By.xpath(Object.getProperty("EmailTemplate"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblCompanyEmailTemplateList']/tbody"));
						List<WebElement> tab = table.findElements(By.tagName("tr"));
						for(int find=2;find<=tab.size();find++)
						{
							tabIdent = driver.findElement(By.xpath(".//*[@id='tblCompanyEmailTemplateList']/tbody/tr["+find+"]/td[2]")).getText();
							System.out.println("Table identifier: " +tabIdent);
							if(tabIdent.equalsIgnoreCase(split[2]))
							{
								driver.findElement(By.xpath(".//*[@id='tblCompanyEmailTemplateList']/tbody/tr["+find+"]/td[2]")).click();
								break;
							}
						}
											
						driver.findElement(By.xpath(Object.getProperty("EditEmailTemplate"))).click();
						t.overlay(driver);
						Thread.sleep(2000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							driver.findElement(By.className("jqte_editor")).click();						
							driver.findElement(By.className("jqte_editor")).sendKeys(split[1]);
							driver.findElement(By.xpath(Object.getProperty("EmailSaveBtn"))).click();
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Company email template updated successfully."))
							{
								table = driver.findElement(By.xpath(".//*[@id='tblCompanyEmailTemplateList']/tbody"));
								List<WebElement> tr = table.findElements(By.tagName("tr"));
								for(int j=2;j<=tr.size();j++)
								{
									tableCode = driver.findElement(By.xpath(".//*[@id='tblCompanyEmailTemplateList']/tbody/tr["+j+"]/td[2]")).getText();
									System.out.println("Table Code: " +tableCode);
									if(tableCode.equalsIgnoreCase(split[2]))
									{
										driver.findElement(By.xpath(".//*[@id='tblCompanyEmailTemplateList']/tbody/tr["+j+"]/td[2]")).click();
										break;
									}
								}
								driver.findElement(By.xpath(Object.getProperty("EditEmailTemplate"))).click();
								if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
								{
									driver.findElement(By.className("jqte_editor")).click();
									if(driver.findElement(By.className("jqte_editor")).getText().contains(split[1]))
									{
										actRes = "Edit Button in Email Template is working as expected";
										System.out.println(actRes);
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
										System.out.println("*********************TestCase 19 finished its execution*************************");
									}
									else
									{
										actRes = "Edit Button in Email Template is not working as expected";
										System.out.println(actRes);
										data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
										rc++;
										s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
										System.out.println("*********************TestCase 19 finished its execution*************************");
									}
								}
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//delete email template
				if(d[i][0].equalsIgnoreCase("TC20"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("CompanyManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 20 is executing******************************");
						Thread.sleep(3000);
						
						Boolean del=false;
						String msg="",tabIdent="",success="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);

						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						t.overlay(driver);
						
						driver.findElement(By.xpath(Object.getProperty("EmailTemplate"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblCompanyEmailTemplateList']/tbody"));
						List<WebElement> tab = table.findElements(By.tagName("tr"));
						for(int find=2;find<=tab.size();find++)
						{
							tabIdent = driver.findElement(By.xpath(".//*[@id='tblCompanyEmailTemplateList']/tbody/tr["+find+"]/td[2]")).getText();
							System.out.println("Table identifier: " +tabIdent);
							if(tabIdent.equalsIgnoreCase(split[1]))
							{
								driver.findElement(By.xpath(".//*[@id='tblCompanyEmailTemplateList']/tbody/tr["+find+"]/td[2]")).click();
								break;
							}
						}
											
						driver.findElement(By.xpath(Object.getProperty("DeleteEmailTemplate"))).click();
						t.overlay(driver);
						Thread.sleep(2000);
						
						msg = t.alertWait();
						if(msg.equalsIgnoreCase("Do you want to remove the template?"))
						{
							success = t.alertWait();
							if(success.equalsIgnoreCase("Email Template removed successfully!"))
							{
								table = driver.findElement(By.xpath(".//*[@id='tblCompanyEmailTemplateList']/tbody"));
								List<WebElement> tab1 = table.findElements(By.tagName("tr"));
								for(int find=2;find<=tab1.size();find++)
								{
									tabIdent = driver.findElement(By.xpath(".//*[@id='tblCompanyEmailTemplateList']/tbody/tr["+find+"]/td[2]")).getText();
									System.out.println("Table identifier: " +tabIdent);
									if(tabIdent.equalsIgnoreCase(split[1]))
									{
										del = false;
										break;
									}
									else
										del = true;
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
							System.out.println("*********************TestCase 20 finished its execution*************************");
						}
						else
						{
							actRes = "Delete Button is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 20 finished its execution*************************");
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
