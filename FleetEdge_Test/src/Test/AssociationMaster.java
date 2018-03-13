package Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentTest;

import FleetEdge_Core.Core;
import FleetEdge_Util.*;

public class AssociationMaster extends Core 
{
	static Util t=new Util();
	public static Map<String, Object[]> AssociationMastertest(Map<String, Object[]> data, int rc,String sheet, ExtentTest test, int scase, int ecase) 
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
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("AssociationMaster")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 1 is executing******************************");
						Thread.sleep(7000);
						
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("SelectionType")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("CompanyTextbox")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("CompanyClearBtn")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("CompanySearchBtn")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("TotalAssociationInformation")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("AssociationEditBtn")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("SearchBox")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionSearch")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("AssetTable")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("SubscriptionClear")), driver))
						{
							System.out.println("All the elements are present in the Association Master");
							actRes = "All the elements are present in the Association Master";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 1 finished its execution*************************");
						}
						else
						{
							System.out.println("All the elements are not present in the Association Master");
							actRes = "All the elements are not present in the Association Master";
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
				//total association information button
				if(d[i][0].equalsIgnoreCase("TC2"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("AssociationMaster")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 2 is executing******************************");
						Thread.sleep(7000);
						
						driver.findElement(By.xpath(Object.getProperty("TotalAssociationInformation"))).click();
						t.overlay(driver);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							driver.findElement(By.xpath("/html/body/div[1]/div[1]/button")).click();
							System.out.println("It display all the Association Information");
							actRes = "It display all the Association Information";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 2 finished its execution*************************");
						}
						else
						{
							System.out.println("The button is not working properly");
							actRes = "The button is not working properly";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 2 finished its execution*************************");
						}
						
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				//company search
				if(d[i][0].equalsIgnoreCase("TC3"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("AssociationMaster")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 3 is executing******************************");
						Thread.sleep(7000);
						
						while(t.isElementPresentcheck(By.xpath(".//*[@id='divGetAssignedAssetLoading']"), driver))
							Thread.sleep(1000);
						Thread.sleep(2000);
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblAssetList']/tbody"));
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						String[] before = new String[tr.size()];
						String[] after = new String[tr.size()];
						
						for(int j=0;j<tr.size();j++)
							before[j] = tr.get(j).getText();
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("CompanyTextbox"))).sendKeys(d[i][5]);
						Thread.sleep(2000);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='divGetAssignedAssetLoading']"), driver))
							Thread.sleep(1000);
						System.out.println("Company details are displayed in Machine-Association");
						
						//clear button
						driver.findElement(By.xpath(Object.getProperty("CompanyClearBtn"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='divGetAssignedAssetLoading']"), driver))
							Thread.sleep(1000);
						Thread.sleep(3000);
						table = driver.findElement(By.xpath(".//*[@id='tblAssetList']/tbody"));
						List<WebElement> tr1 = table.findElements(By.tagName("tr"));
						for(int k=0;k<tr.size();k++)
							after[k] = tr1.get(k).getText();
						
						if(Arrays.equals(before, after))
						{
							System.out.println("Search and Clear is working properly");
							actRes = "Search and Clear is working properly";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 3 finished its execution*************************");
						}
						else
						{
							System.out.println("Search and Clear is not working properly");
							actRes = "Search and Clear is not working properly";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 3 finished its execution*************************");
						}
						
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				//asset search
				if(d[i][0].equalsIgnoreCase("TC4"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("AssociationMaster")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 4 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(5000);
						Boolean eid=null,sno=null,model=null;
						
						WebElement id = driver.findElement(By.xpath(Object.getProperty("SelectionType")));
						List<WebElement> opt = id.findElements(By.tagName("option"));
						String[] option = new String[opt.size()];
						for(int val=0;val<opt.size();val++)
							option[val] = opt.get(val).getText();
						for(int j=0;j<opt.size();j++)
						{
							Select EId = new Select(driver.findElement(By.xpath(Object.getProperty("SelectionType"))));
							EId.selectByIndex(j);
							System.out.println("selected option: " +EId.getFirstSelectedOption().getText());
							switch(option[j])
							{
							case "EquipmentID":
								driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
								driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='divGetAssignedAssetLoading']"), driver))
									Thread.sleep(1000);
								Thread.sleep(3000);
								String text = new String();
								text = driver.findElement(By.xpath(".//*[@id='tblAssetList']/tbody/tr")).getText();
								if(text.contains(split[0]))
									eid = true;
								else
									eid = false;
								driver.findElement(By.xpath(Object.getProperty("SubscriptionClear"))).click();
								if(driver.findElement(By.xpath(Object.getProperty("SearchBox"))).getText().isEmpty())
									System.out.println("clear is working");
								while(t.isElementPresentcheck(By.xpath(".//*[@id='divGetAssignedAssetLoading']"), driver))
									Thread.sleep(1000);
								Thread.sleep(2000);
								break;
								
							case "Serial No":
								driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
								driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='divGetAssignedAssetLoading']"), driver))
									Thread.sleep(1000);
								Thread.sleep(3000);
								String text1 = new String();
								text1 = driver.findElement(By.xpath(".//*[@id='tblAssetList']/tbody/tr")).getText();
								if(text1.contains(split[1]))
									sno = true;
								else
									sno = false;
								driver.findElement(By.xpath(Object.getProperty("SubscriptionClear"))).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='divGetAssignedAssetLoading']"), driver))
									Thread.sleep(1000);
								Thread.sleep(2000);
								break;
								
							case "Model":
								driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[2]);
								driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='divGetAssignedAssetLoading']"), driver))
									Thread.sleep(1000);
								Thread.sleep(3000);
								String text2 = new String();
								text2 = driver.findElement(By.xpath(".//*[@id='tblAssetList']/tbody/tr")).getText();
								if(text2.contains(split[2]))
									model = true;
								else
									model = false;
								driver.findElement(By.xpath(Object.getProperty("SubscriptionClear"))).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='divGetAssignedAssetLoading']"), driver))
									Thread.sleep(1000);
								Thread.sleep(2000);
								break;
							}
						}
						
						if(eid==true && sno==true && model==true)
						{
							System.out.println("Search and clear button are working as expected in Asset list");
							actRes = "Search and clear button are working as expected in Asset list";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1],d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 4 finished its execution*************************");
						}
						else
						{
							System.out.println("Search and clear button are not working properly in Asset list");
							actRes = "Search and clear button are not working properly in Asset list";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1],d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 4 finished its execution*************************");
						}
					}catch(Exception e){
						e.printStackTrace();
					}
				}
				//edit button
				if(d[i][0].equalsIgnoreCase("TC5"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("AssociationMaster")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 5 is executing******************************");
						Thread.sleep(5000);
						
						Boolean edit=null,cancel=null;
						driver.findElement(By.xpath(Object.getProperty("AssociationEditBtn"))).click();
						Thread.sleep(10000);
						Select cmpny = new Select(driver.findElement(By.xpath(Object.getProperty("ShippingCompany"))));
						cmpny.selectByVisibleText(d[i][5]);
						WebElement tableVal = driver.findElement(By.xpath(".//*[@id='tblShippedAssetList']/tbody/tr[3]"));
						List<WebElement> td = tableVal.findElements(By.xpath("td"));
						String[] value = new String[td.size()];
						for(int k=0;k<td.size();k++)
							value[k] = td.get(k).getText();
						System.out.println("table val: " +value[0]);
			//			String x1 = value[0];
						driver.findElement(By.xpath(".//*[@id='tblShippedAssetList']/tbody/tr[3]/td[1]/input")).click();
						driver.findElement(By.xpath(Object.getProperty("MoveLeft"))).click();
						driver.findElement(By.xpath(Object.getProperty("Save"))).click();
						t.alertWait();
						String save = t.alertWait();
						if(save.equalsIgnoreCase("Success"))
						{
							while(t.isElementPresentcheck(By.xpath(".//*[@id='divGetAssignedAssetLoading']"), driver))
								Thread.sleep(1000);
							Thread.sleep(2000);
							edit = true;
						/*	driver.findElement(By.xpath(Object.getProperty("CompanyTextbox"))).sendKeys(value);
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='divGetAssignedAssetLoading']"), driver))
								Thread.sleep(1000);
							Thread.sleep(2000);
							WebElement tab = driver.findElement(By.xpath(".//*[@id='tblAssetList']/tbody/tr[1]/td[1]"));
							String searchVal = tab.getText();
							if(searchVal.equalsIgnoreCase(x1))
								edit = true;
							else
								edit = false;*/
						}
						else
						{
							System.out.println("not saved");
							edit = false;
						}
						//cancel
						driver.findElement(By.xpath(Object.getProperty("AssociationEditBtn"))).click();
						Thread.sleep(10000);
						Select cmpny1 = new Select(driver.findElement(By.xpath(Object.getProperty("ShippingCompany"))));
						cmpny1.selectByVisibleText(d[i][5]);
						WebElement tableVal1 = driver.findElement(By.xpath(".//*[@id='tblShippedAssetList']/tbody/tr[3]"));
						List<WebElement> td1 = tableVal1.findElements(By.xpath("td"));
						String[] value1 = new String[td1.size()];
						for(int k=0;k<td1.size();k++)
							value1[k] = td1.get(k).getText();
						System.out.println("table val: " +value1);
						driver.findElement(By.xpath(".//*[@id='tblShippedAssetList']/tbody/tr[3]/td[1]/input")).click();
						driver.findElement(By.xpath(Object.getProperty("MoveLeft"))).click();
						driver.findElement(By.xpath(Object.getProperty("Cancel"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='divGetAssignedAssetLoading']"), driver))
							Thread.sleep(1000);
						Thread.sleep(2000);
					/*	driver.findElement(By.xpath(Object.getProperty("CompanyTextbox"))).sendKeys(value);
						Thread.sleep(2000);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='divGetAssignedAssetLoading']"), driver))
							Thread.sleep(1000);
						Thread.sleep(2000);*/
						if(t.isElementPresentcheck(By.xpath(".//*[@id='tblAssetList']/tbody"), driver))
							cancel = true;
						else
							cancel = false;
						
						System.out.println("edit res: " +edit+ " cancel res: " +cancel);
						//final
						if(edit==true && cancel==true)
						{
							System.out.println("Edit button is working as expected");
							actRes = "Edit button are working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1],d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 5 finished its execution*************************");
						}
						else
						{
							System.out.println("Edit button is not working as expected");
							actRes = "Edit button are working as expected";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1],d[i][6], actRes, "Fail", t.timestamp(stime)});
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
				//manage company - search and clear verification
				if(d[i][0].equalsIgnoreCase("TC6"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("AssociationMaster")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 6 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(5000);
						Boolean id=null,name=null,mail=null,phno=null;;
						
						driver.findElement(By.xpath(Object.getProperty("ManageCompanyTab"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='divAssignedUserLoading']"), driver))
							Thread.sleep(1000);
						Thread.sleep(3000);
						WebElement uname = driver.findElement(By.xpath(Object.getProperty("UserDropdown")));
						List<WebElement> opt = uname.findElements(By.tagName("option"));
						String[] option = new String[opt.size()];
						for(int val=0;val<opt.size();val++)
							option[val] = opt.get(val).getText();
						for(int j=0;j<opt.size();j++)
						{
							Select dropdown = new Select(driver.findElement(By.xpath(Object.getProperty("UserDropdown"))));
							dropdown.selectByIndex(j);
							System.out.println("selected option: " +dropdown.getFirstSelectedOption().getText());
							switch(option[j])
							{
							case "Name":
								driver.findElement(By.xpath(Object.getProperty("UserTextBox"))).sendKeys(split[0]);
								driver.findElement(By.xpath(Object.getProperty("UserSearchBtn"))).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='divAssignedUserLoading']"), driver))
									Thread.sleep(1000);
								Thread.sleep(3000);
								String text = new String();
								text = driver.findElement(By.xpath(".//*[@id='tblUserList']/tbody/tr")).getText();
								if(text.contains(split[0]))
									name = true;
								else
									name = false;
								driver.findElement(By.xpath(Object.getProperty("UserClearBtn"))).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='divAssignedUserLoading']"), driver))
									Thread.sleep(1000);
								Thread.sleep(3000);
								if(driver.findElement(By.xpath(Object.getProperty("UserClearBtn"))).getText().isEmpty())
									System.out.println("Clear button is working properly");
								break;
								
							case "ID":
								driver.findElement(By.xpath(Object.getProperty("UserTextBox"))).sendKeys(split[1]);
								driver.findElement(By.xpath(Object.getProperty("UserSearchBtn"))).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='divAssignedUserLoading']"), driver))
									Thread.sleep(1000);
								Thread.sleep(3000);
								String text1 = new String();
								text1 = driver.findElement(By.xpath(".//*[@id='tblUserList']/tbody/tr")).getText();
								if(text1.contains(split[1]))
									id = true;
								else
									id = false;
								driver.findElement(By.xpath(Object.getProperty("UserClearBtn"))).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='divAssignedUserLoading']"), driver))
									Thread.sleep(1000);
								Thread.sleep(3000);
								if(driver.findElement(By.xpath(Object.getProperty("UserClearBtn"))).getText().isEmpty())
									System.out.println("Clear button is working properly");
								break;
								
							case "Phone No":
								driver.findElement(By.xpath(Object.getProperty("UserTextBox"))).sendKeys(split[2]);
								driver.findElement(By.xpath(Object.getProperty("UserSearchBtn"))).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='divAssignedUserLoading']"), driver))
									Thread.sleep(1000);
								Thread.sleep(3000);
								String text2 = new String();
								text2 = driver.findElement(By.xpath(".//*[@id='tblUserList']/tbody/tr")).getText();
								if(text2.contains(split[2]))
									phno = true;
								else
									phno = false;
								driver.findElement(By.xpath(Object.getProperty("UserClearBtn"))).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='divAssignedUserLoading']"), driver))
									Thread.sleep(1000);
								Thread.sleep(3000);
								if(driver.findElement(By.xpath(Object.getProperty("UserClearBtn"))).getText().isEmpty())
									System.out.println("Clear button is working properly");
								break;
								
							case "E-mail":
								driver.findElement(By.xpath(Object.getProperty("UserTextBox"))).sendKeys(split[3]);
								driver.findElement(By.xpath(Object.getProperty("UserSearchBtn"))).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='divAssignedUserLoading']"), driver))
									Thread.sleep(1000);
								Thread.sleep(3000);
								String text3 = new String();
								text3 = driver.findElement(By.xpath(".//*[@id='tblUserList']/tbody/tr")).getText();
								if(text3.contains(split[3]))
									mail = true;
								else
									mail = false;
								driver.findElement(By.xpath(Object.getProperty("UserClearBtn"))).click();
								while(t.isElementPresentcheck(By.xpath(".//*[@id='divAssignedUserLoading']"), driver))
									Thread.sleep(1000);
								Thread.sleep(3000);
								if(driver.findElement(By.xpath(Object.getProperty("UserClearBtn"))).getText().isEmpty())
									System.out.println("Clear button is working properly");
								break;
							}
						}
						
						if(id==true && name==true && phno==true && mail==true)
						{
							System.out.println("Search and clear button are working properly in User Account list");
							actRes = "Search and clear button are working properly in Asset list";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1],d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 6 finished its execution*************************");
						}
						else
						{
							System.out.println("Search and clear button are not working properly in User Account list");
							actRes = "Search and clear button are not working properly in Asset list";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1],d[i][6], actRes, "Fail", t.timestamp(stime)});
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
				//create company
				if(d[i][0].equalsIgnoreCase("TC7"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(10000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("AssociationMaster")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 7 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(4000);
						
						driver.findElement(By.xpath(Object.getProperty("ManageCompanyTab"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='divGroupInfoNonEditLoading']"), driver))
							Thread.sleep(1000);
						Thread.sleep(3000);
						//create company
						driver.findElement(By.xpath(Object.getProperty("CreateBtn"))).click();
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("CompanyName"))).sendKeys(split[0]);
						Thread.sleep(1000);
						Select type = new Select(driver.findElement(By.xpath(Object.getProperty("CompanyType"))));
						type.selectByValue(split[1]);
						Thread.sleep(1000);
						Select logo = new Select(driver.findElement(By.xpath(Object.getProperty("CompanyLogo"))));
						logo.selectByVisibleText(split[2]);
						Thread.sleep(1000);
						driver.findElement(By.xpath(Object.getProperty("CompanyCode"))).sendKeys(split[3]);
						driver.findElement(By.xpath(Object.getProperty("Description"))).sendKeys(split[4]);
						driver.findElement(By.xpath(Object.getProperty("CompanyOkBtn"))).click();
						while(t.isElementPresentcheck(By.xpath("//*[@id='divGroupInfoNonEditLoading']"), driver))
							Thread.sleep(1000);
						Thread.sleep(1000);
						String success = t.alertWait();
						if(success.equalsIgnoreCase("Company created successfully."))
						{
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("CompanyTextbox"))).sendKeys(split[0]);
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='divGroupInfoNonEditLoading']"), driver))
								Thread.sleep(1000);
							Thread.sleep(1000);
							String company = driver.findElement(By.id("MainContainer_lblGrpNameVal")).getText();
							System.out.println("company name: " +company);
							if(company.equalsIgnoreCase(split[0]))
							{	
								System.out.println("Company is created successfully");
								actRes = "Company is created successfully";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1],d[i][6], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 7 finished its execution*************************");
							}
							else
							{
								System.out.println("Company is not created successfully");
								actRes = "Company is not created successfully";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1],d[i][6], actRes, "Fail", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
								System.out.println("*********************TestCase 7 finished its execution*************************");
							}
						}
						//clear
						driver.findElement(By.xpath(Object.getProperty("CompanyClearBtn"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='divGroupInfoNonEditLoading']"), driver))
							Thread.sleep(1000);
						Thread.sleep(3000);
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//edit company details
				if(d[i][0].equalsIgnoreCase("TC8"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(10000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("AssociationMaster")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 8 is executing******************************");
						Thread.sleep(5000);
						
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(4000);
						
						driver.findElement(By.xpath(Object.getProperty("ManageCompanyTab"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='divGroupInfoNonEditLoading']"), driver))
							Thread.sleep(1000);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("CompanyTextbox"))).sendKeys(split[0]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='divGroupInfoNonEditLoading']"), driver))
							Thread.sleep(1000);
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("Edit"))).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath(Object.getProperty("CompanyName"))).clear();
						driver.findElement(By.xpath(Object.getProperty("CompanyName"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("CompanyOkBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						t.alertWait();
						String editMsg = t.alertWait();
						if(editMsg.equalsIgnoreCase("Company updated successfully."))
						{
							while(t.isElementPresentcheck(By.xpath(".//*[@id='divGroupInfoNonEditLoading']"), driver))
								Thread.sleep(1000);
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("CompanyTextbox"))).sendKeys(split[1]);
							Thread.sleep(2000);
							driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
							while(t.isElementPresentcheck(By.xpath(".//*[@id='divGroupInfoNonEditLoading']"), driver))
								Thread.sleep(1000);
							Thread.sleep(2000);
							String company = driver.findElement(By.id("MainContainer_lblGrpNameVal")).getText();
							System.out.println("company name: " +company);
							if(company.equalsIgnoreCase(split[1]))
							{
								System.out.println("Company is modified successfully");
								actRes = "Company is modified successfully";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1],d[i][6], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 8 finished its execution*************************");
							}
							else
							{
								System.out.println("Company is not modified successfully");
								actRes = "Company is not modified successfully";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1],d[i][6], actRes, "Fail", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
								System.out.println("*********************TestCase 8 finished its execution*************************");
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//delete company
				if(d[i][0].equalsIgnoreCase("TC9"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(10000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("AssociationMaster")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 9 is executing******************************");
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(Object.getProperty("ManageCompanyTab"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='divGroupInfoNonEditLoading']"), driver))
							Thread.sleep(1000);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("CompanyTextbox"))).sendKeys(d[i][5]);
						driver.findElement(By.xpath(Object.getProperty("CompanySearchBtn"))).click();
						while(t.isElementPresentcheck(By.xpath(".//*[@id='divGroupInfoNonEditLoading']"), driver))
							Thread.sleep(1000);
						Thread.sleep(5000);
						
						driver.findElement(By.xpath(Object.getProperty("DeleteCompany"))).click();
						String del = t.alertWait();
						if(del.equalsIgnoreCase("Do you want to delete the selected group?"))
						{
							
							String success1 = t.alertWait();
							if(success1.equalsIgnoreCase("Success"))
							{
								System.out.println("Company is deleted successfully");
								actRes = "Company is deleted successfully";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1],d[i][6], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 9 finished its execution*************************");
							}
							else
							{
								System.out.println("Company is not deleted successfully");
								actRes = "Company is not deleted successfully";
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1],d[i][6], actRes, "Fail", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
								System.out.println("*********************TestCase 9 finished its execution*************************");
							}
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
