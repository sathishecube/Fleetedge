package Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
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

public class ModelManager extends Core 
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]> ModelManagerTest(Map<String, Object[]> data, int rc, String sheet, ExtentTest test, int scase, int ecase) 
	{
		try
		{
			String actRes = null;
			int counter = 1;

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
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 1 is executing******************************");
						Thread.sleep(5000);
						
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("SelectionType")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("SearchBox")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("SearchBtn")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("ClearBtn")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("CopyParts")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("CreateModel")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("EditModel")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("DeactivateModel")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("AlarmsTab11")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("InformationTab")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("PartsTab")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("ChecklistTab")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("IntervalTab")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Page")), driver))
						{
							System.out.println("All the elements are present in the Model Manager");
							actRes = "All the elements are present in the Model Manager";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 1 finished its execution*************************");
						}
						else
						{
							System.out.println("All the elements are not present in the Model Manager");
							actRes = "All the elements are not present in the Model Manager";
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
				//search and clear button
				if(d[i][0].equalsIgnoreCase("TC2"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 2 is executing******************************");
						Thread.sleep(5000);
						
						String value="";
						String str = d[i][5];
						String[] split = str.split(",");
						
						Select type = new Select(driver.findElement(By.xpath(Object.getProperty("SelectionType"))));
						type.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						value = driver.findElement(By.xpath(".//*[@id='tblDataList']/tbody/tr/td[1]")).getText();
						System.out.println("Search value: " +value);
						driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						if(value.equalsIgnoreCase(split[1]) && driver.findElement(By.xpath(Object.getProperty("SearchBox"))).getText().isEmpty())
						{
							actRes = "Search and Clear Button are working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 2 finished its execution*************************");
						}
						else
						{
							actRes = "Search and Clear Button are not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
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
				//page no button
				if(d[i][0].equalsIgnoreCase("TC3"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 3 is executing******************************");
						Thread.sleep(5000);
						
						int page = Integer.parseInt(d[i][5]);
						System.out.println("Page no: " +page);
						List<WebElement> tag = driver.findElements(By.xpath(".//*[@id='divPaging']/span/a"));
						System.out.println("size: " +tag.size());
						
						for(int j=0;j<tag.size();j++)
						{
							System.out.println("J: "+j+" pg: " +tag.get(j).getText());
							if(tag.get(j).getText().equalsIgnoreCase(d[i][5]))
							{
								System.out.println("j: " +j);
								driver.findElement(By.xpath(".//*[@id='divPaging']/span/a["+(j+1)+"]")).click();
								t.overlay(driver);
								Thread.sleep(1000);
								break;
							}
						}
						Thread.sleep(3000);
						ArrayList<String> number = new ArrayList<String>();
						List<WebElement> tag1 = driver.findElements(By.xpath(".//*[@id='divPaging']/span/a"));
						for(int k=0;k<tag1.size();k++){
							number.add(tag1.get(k).getText());
							System.out.println("list: " +number);}
						
						if(!number.contains(d[i][5]))
						{
							actRes = "The Selected Page is displayed successfully";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 3 finished its execution*************************");
						}
						else
						{
							actRes = "The Selected Page is not displayed successfully";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
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
				//create model
				if(d[i][0].equalsIgnoreCase("TC4"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 4 is executing******************************");
						Thread.sleep(5000);
						
						String value = "";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("CreateModel"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						if(t.isElementPresentcheck(By.xpath("/html/body/form/div[7]"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("ModelTextBox"))).sendKeys(split[0]);
							if(split[1].equalsIgnoreCase("New Model Image"))
							{
								Select type = new Select(driver.findElement(By.xpath(Object.getProperty("UploadModelType"))));
								type.selectByVisibleText(split[1]);
								driver.findElement(By.xpath(Object.getProperty("BrowseBtn"))).click();
								Process p = Runtime.getRuntime().exec("D:\\Magi\\AutoIt Proc\\ModelManager.exe");
								p.waitFor();
							}
							else if(split[1].equalsIgnoreCase("Existing Model Image"))
							{
								Select type = new Select(driver.findElement(By.xpath(Object.getProperty("UploadModelType"))));
								type.selectByVisibleText(split[1]);
								driver.findElement(By.xpath(Object.getProperty("ExistingModelName"))).sendKeys(split[2]);
								Thread.sleep(2000);
								List<WebElement> modeltype = driver.findElements(By.xpath("/html/body/ul[2]/li"));
								System.out.println("size: " +modeltype.size());
								for(WebElement opt : modeltype)
								{
									System.out.println("Option: " +opt.getText());
									if(opt.getText().equalsIgnoreCase(split[2]))
									{
										opt.click();
										break;
									}
								}
							}
							driver.findElement(By.xpath(Object.getProperty("Description"))).sendKeys(split[3]);
							Select copy = new Select(driver.findElement(By.xpath(Object.getProperty("CopyModelList"))));
							copy.selectByVisibleText(split[4]);
							Select source = new Select(driver.findElement(By.xpath(Object.getProperty("Source"))));
							source.selectByValue(split[5]);
							driver.findElement(By.xpath(Object.getProperty("BulkUploadBtn"))).click();						
						}
						String msg = t.alertWait();
						if(msg.equalsIgnoreCase("Model created successfully."))
						{
							Thread.sleep(2000);
							Select type = new Select(driver.findElement(By.xpath(Object.getProperty("SelectionType"))));
							type.selectByValue(split[6]);
							driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[0]);
							driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							
							value = driver.findElement(By.xpath(".//*[@id='tblDataList']/tbody/tr/td[1]")).getText();
							System.out.println("Search value: " +value);
							if(value.equalsIgnoreCase(split[0]))
							{
								actRes = "The Model is created successfully in Model Manager";
								System.out.println(actRes);
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 4 finished its execution*************************");
							}
							else
							{
								actRes = "The Model is not created successfully in Model Manager";
								System.out.println(actRes);
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
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
				//edit model button
				if(d[i][0].equalsIgnoreCase("TC5"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 5 is executing******************************");
						Thread.sleep(5000);
						
						String value = "", msg="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],value);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("EditModel"))).click();
						Thread.sleep(3000);
						if(split[2].equalsIgnoreCase("New Model Image"))
						{
							Select uploadType = new Select(driver.findElement(By.xpath(Object.getProperty("UploadModelType"))));
							uploadType.selectByVisibleText(split[2]);
							driver.findElement(By.xpath(Object.getProperty("BrowseBtn"))).click();
							Process p = Runtime.getRuntime().exec("D:\\Magi\\AutoIt Proc\\ModelManager.exe");
							p.waitFor();
						}
						else if(split[2].equalsIgnoreCase("Existing Model Image"))
						{
							Select uploadType = new Select(driver.findElement(By.xpath(Object.getProperty("UploadModelType"))));
							uploadType.selectByVisibleText(split[2]);
							driver.findElement(By.xpath(Object.getProperty("ExistingModelName"))).sendKeys(split[3]);
							Thread.sleep(2000);
							List<WebElement> modeltype = driver.findElements(By.xpath("/html/body/ul[2]/li"));
							System.out.println("size: " +modeltype.size());
							for(WebElement opt : modeltype)
							{
								System.out.println("Option: " +opt.getText());
								if(opt.getText().equalsIgnoreCase(split[3]))
								{
									opt.click();
									break;
								}
							}
						}
						driver.findElement(By.xpath(Object.getProperty("EditUploadBtn"))).click();
						msg = t.alertWait();
						if(msg.equalsIgnoreCase("Model Updated successfully!"))
						{
							actRes = "The changes are modified successfully";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 5 finished its execution*************************");
						}
						else
						{
							actRes = "The changes are not modified as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
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
				//copy button in model
				if(d[i][0].equalsIgnoreCase("TC6"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 6 is executing******************************");
						Thread.sleep(5000);
						
						String value = "",msg="";
						String str = d[i][5];
						String[] split = str.split(",");
						/*String str1 = d[i][6];
						String[] split1 = str1.split(",");*/
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],value);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("CopyParts"))).click();
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("TextCopyModel"))).sendKeys(split[2]);
							Thread.sleep(3000);
							List<WebElement> copyTo = driver.findElements(By.xpath("/html/body/ul[4]/li"));
							System.out.println("size: " +copyTo.size());
							for(WebElement opt : copyTo)
							{
								System.out.println("Option: " +opt.getText());
								if(opt.getText().equalsIgnoreCase(split[2]))
								{
									opt.click();
									break;
								}
							}
							if(!d[i][6].isEmpty())
							{
								if(d[i][6].contains("Parts"))
									driver.findElement(By.xpath(Object.getProperty("CheckParts"))).click();
								if(d[i][6].contains("CheckList"))
									driver.findElement(By.xpath(Object.getProperty("CheckCList"))).click();
								if(d[i][6].contains("Intervals"))
									driver.findElement(By.xpath(Object.getProperty("CheckIntervals"))).click();
								if(d[i][6].contains("Alarms"))
									driver.findElement(By.xpath(Object.getProperty("CheckAlarms"))).click();
							}
							driver.findElement(By.xpath(Object.getProperty("CopyModelBtn"))).click();
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Copied successfully."))
							{
								actRes = "Copy Button is working as expected";
								System.out.println(actRes);
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 6 finished its execution*************************");
							}
							else
							{
								actRes = "Copy Button is not working as expected";
								System.out.println(actRes);
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
								System.out.println("*********************TestCase 6 finished its execution*************************");
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//deactivate model button
				if(d[i][0].equalsIgnoreCase("TC7"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 7 is executing******************************");
						Thread.sleep(5000);
						
						String value = "", success="", msg="", record="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],value);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("DeactivateModel"))).click();
						msg = t.alertWait();
						if(msg.equalsIgnoreCase("Deactive Model will Deactivate Alarms, Parts and Interval. Do you want to Deactivate?"))
						{
							success = t.alertWait();
							if(success.equalsIgnoreCase("Model Deactivated successfully."))
							{
								Select type = new Select(driver.findElement(By.xpath(Object.getProperty("SelectionType"))));
								type.selectByValue(split[0]);
								driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
								driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
								t.overlay(driver);
								Thread.sleep(1000);
								
								record = driver.findElement(By.xpath(".//*[@id='tblDataList']/tbody/tr/td[1]")).getText();
								System.out.println("Search value: " +record);
								if(record.equalsIgnoreCase("No Record Found"))
								{
									actRes = "Deactivate Button is working as expected";
									System.out.println(actRes);
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
									System.out.println("*********************TestCase 7 finished its execution*************************");
								}
								else
								{
									actRes = "Deactivate Button is not working as expected";
									System.out.println(actRes);
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
									System.out.println("*********************TestCase 7 finished its execution*************************");
								}
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//create parts button
				if(d[i][0].equalsIgnoreCase("TC8"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 8 is executing******************************");
						Thread.sleep(5000);
						
						String msg="",value="",search="";
						Boolean create = false;
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],search);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("PartsTab"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						driver.findElement(By.xpath(Object.getProperty("CreatePartBtn"))).click();
						Thread.sleep(1000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("TextPartName"))).sendKeys(split[2]);
							driver.findElement(By.xpath(Object.getProperty("TextPartNum"))).sendKeys(split[3]);
							driver.findElement(By.xpath(Object.getProperty("BrowseRed"))).click();
							Process red = Runtime.getRuntime().exec("D:\\Magi\\AutoIt Proc\\RedIcon.exe");
							red.waitFor(); 
							driver.findElement(By.xpath(Object.getProperty("BrowseYellow"))).click();
							Process yellow = Runtime.getRuntime().exec("D:\\Magi\\AutoIt Proc\\YellowIcon.exe");
							yellow.waitFor();
							driver.findElement(By.xpath(Object.getProperty("BrowseGreen"))).click();
							Process green = Runtime.getRuntime().exec("D:\\Magi\\AutoIt Proc\\GreenIcon.exe");
							green.waitFor();
							driver.findElement(By.xpath(Object.getProperty("SavePartBtn"))).click();
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Part created successfully!"))
								System.out.println("Part created successfully!");
						}
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblPartsDataList']/tbody"));
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						System.out.println("Part table size: " +tr.size());
						for(int j=2;j<=tr.size();j++)
						{
							value = driver.findElement(By.xpath(".//*[@id='tblPartsDataList']/tbody/tr[" +j+ "]/td[2]")).getText();
							System.out.println("Part name: " +value);
							if(value.equalsIgnoreCase(split[2]))
							{
								create = true;
								break;
							}
						}
						if(create==true)
						{
							actRes = "Create Button in Parts is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 8 finished its execution*************************");
						}
						else
						{
							actRes = "Create Button in Parts is not working as expected";
							System.out.println(actRes);
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
				//edit parts button
				if(d[i][0].equalsIgnoreCase("TC9"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 9 is executing******************************");
						Thread.sleep(5000);
						
						Boolean edit=false;
						String value = "", msg="",search="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],search);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("PartsTab"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblPartsDataList']/tbody"));
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						System.out.println("Part table size: " +tr.size());
						for(int j=2;j<=tr.size();j++)
						{
							value = driver.findElement(By.xpath(".//*[@id='tblPartsDataList']/tbody/tr[" +j+ "]/td[2]")).getText();
							System.out.println("Part name: " +value);
							if(value.equalsIgnoreCase(split[2]))
							{
								driver.findElement(By.xpath(".//*[@id='tblPartsDataList']/tbody/tr[" +j+ "]/td[2]")).click();
								break;
							}
						}
						driver.findElement(By.xpath(Object.getProperty("EditPartBtn"))).click();
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("TextPartName"))).clear();
							driver.findElement(By.xpath(Object.getProperty("TextPartName"))).sendKeys(split[3]);
							driver.findElement(By.xpath(Object.getProperty("SavePartBtn"))).click();
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Part updated successfully!"))
								System.out.println("Part updated successfully!");
							else
							{
								System.out.println(msg);
								driver.findElement(By.xpath("/html/body/div[1]/div[1]/a/span")).click();
								t.overlay(driver);
								Thread.sleep(1000);
							}
						}
						table = driver.findElement(By.xpath(".//*[@id='tblPartsDataList']/tbody"));
						List<WebElement> tr1 = table.findElements(By.tagName("tr"));
						System.out.println("Part table size: " +tr1.size());
						for(int j=2;j<=tr1.size();j++)
						{
							value = driver.findElement(By.xpath(".//*[@id='tblPartsDataList']/tbody/tr[" +j+ "]/td[2]")).getText();
							System.out.println("Part name: " +value);
							if(value.equalsIgnoreCase(split[3]))
							{
								edit = true;
								break;
							}
						}
						if(edit==true)
						{
							actRes = "Edit Button in Parts is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 9 finished its execution*************************");
						}
						else
						{
							actRes = "Edit Button in Parts is not working as expected";
							System.out.println(actRes);
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
				//copy parts button
				if(d[i][0].equalsIgnoreCase("TC10"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 10 is executing******************************");
						Thread.sleep(5000);
						
						int size=0,newSz=0;
						String msg="",search="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],search);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("PartsTab"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblPartsDataList']/tbody"));
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						size = tr.size();
						System.out.println("Part table size: " +size);
						
						driver.findElement(By.xpath(Object.getProperty("CopyModelPart"))).click();
						Thread.sleep(2000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("CopyPartSearch"))).sendKeys(split[2]);
							List<WebElement> option = driver.findElements(By.xpath("/html/body/ul[5]/li"));
							System.out.println("size of option: " +option.size());
							for(WebElement opt : option)
							{
								System.out.println("Option: " +opt.getText());
								if(opt.getText().equalsIgnoreCase(split[2]))
								{
									opt.click();
									break;
								}
							}
							driver.findElement(By.xpath(Object.getProperty("CopyPartsBtn"))).click();
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Part copied successfully."))
							{
								table = driver.findElement(By.xpath(".//*[@id='tblPartsDataList']/tbody"));
								List<WebElement> tr1 = table.findElements(By.tagName("tr"));
								newSz = tr1.size();
								System.out.println("size of new table: " +newSz);
							}
							if(newSz!=size)
							{
								actRes = "Parts Copy Button is working as expected";
								System.out.println(actRes);
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 10 finished its execution*************************");
							}
							else
							{
								actRes = "Parts Copy Button is not working as expected";
								System.out.println(actRes);
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
								System.out.println("*********************TestCase 10 finished its execution*************************");
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//bulk upload button in parts
				if(d[i][0].equalsIgnoreCase("TC11"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 11 is executing******************************");
						Thread.sleep(5000);
						
						Boolean result = false;
						int size=0,newSz=0;
						String msg="",search="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],search);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("PartsTab"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblPartsDataList']/tbody"));
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						size = tr.size();
						System.out.println("Part table size: " +size);
						driver.findElement(By.xpath(Object.getProperty("BulkUploadPart"))).click();
						//Template download
						driver.findElement(By.xpath(Object.getProperty("TemplateDownloadPart"))).click();
						Thread.sleep(25000);
						System.out.println("in Robot class");
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_DOWN);
						Thread.sleep(500);
						robot.keyRelease(KeyEvent.VK_DOWN);
						Thread.sleep(500);
						robot.keyPress(KeyEvent.VK_ENTER);
						Thread.sleep(500);
						robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(15000);
						
						driver.findElement(By.xpath(Object.getProperty("BrowsePartsBtn"))).click();
						Process browse = Runtime.getRuntime().exec("D:\\Magi\\AutoIt Proc\\PartsUpload.exe");
						browse.waitFor();
						if(d[i][6].equalsIgnoreCase("Upload"))
						{
							driver.findElement(By.xpath(Object.getProperty("UploadPartsBtn"))).click();
							Thread.sleep(7000);
							msg = t.alertWait();
							if(msg.equalsIgnoreCase(" Successfully Uploaded. "))
								result = true;							
						}
						else if(d[i][6].equalsIgnoreCase("Cancel"))
						{
							driver.findElement(By.xpath(Object.getProperty("CancelPartsBtn"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							table = driver.findElement(By.xpath(".//*[@id='tblPartsDataList']/tbody"));
							List<WebElement> tr1 = table.findElements(By.tagName("tr"));
							newSz = tr1.size();
							System.out.println("Part table size: " +newSz);
							if(newSz==size)
								result = true;
						}
						if(result==true)
						{
							actRes = "Bulk Upload Button in Part is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 11 finished its execution*************************");
						}
						else
						{
							actRes = "Bulk Upload Button in Part is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 11 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//deactivate parts button
				if(d[i][0].equalsIgnoreCase("TC12"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 12 is executing******************************");
						Thread.sleep(5000);
						
				//		ArrayList<String> tab = new ArrayList<String>();
						Boolean delete=false;
						String value="", msg="", success="",search="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],search);
						Thread.sleep(3000);
											
						driver.findElement(By.xpath(Object.getProperty("PartsTab"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblPartsDataList']/tbody"));
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						System.out.println("Part table size: " +tr.size());
						for(int j=2;j<=tr.size();j++)
						{
							value = driver.findElement(By.xpath(".//*[@id='tblPartsDataList']/tbody/tr[" +j+ "]/td[2]")).getText();
							System.out.println("Part name: " +value);
							if(value.equalsIgnoreCase(split[2]))
							{
								driver.findElement(By.xpath(".//*[@id='tblPartsDataList']/tbody/tr[" +j+ "]/td[2]")).click();
								break;
							}
						}
						driver.findElement(By.xpath(Object.getProperty("DeactivatePartBtn"))).click();
						msg = t.alertWait();
						if(msg.equalsIgnoreCase("Do you want to deactivate the Model Part."))
						{
							success = t.alertWait();
							if(success.equalsIgnoreCase("Part deactivated successfully!"))
								System.out.println("Part deactivated successfully!");
						}
						WebElement table1 = driver.findElement(By.xpath(".//*[@id='tblPartsDataList']/tbody"));
						List<WebElement> tr1 = table1.findElements(By.tagName("tr"));
						System.out.println("Part table size: " +tr1.size());
						for(int k=2;k<tr.size();k++)
						{
							value = driver.findElement(By.xpath(".//*[@id='tblPartsDataList']/tbody/tr[" +k+ "]/td[2]")).getText();
							System.out.println("Part name: " +value);
							if(!value.equalsIgnoreCase(split[2]))
								delete = true;
							else
							{
								delete = false;
								break;
							}
						}
				/*		if(!tab.contains(split[2]))
							delete = true;
						else
							delete = false;*/
						//if(delete==true)
						if(delete==true)
						{
							actRes = "Deactivate Button in Part is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 12 finished its execution*************************");
						}
						else
						{
							actRes = "Deactivate Button in Part is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 12 finished its execution*************************");
						}
						
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//create checklist button
				if(d[i][0].equalsIgnoreCase("TC13"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 13 is executing******************************");
						Thread.sleep(5000);
						
						Boolean create=false;
						String value = "", msg="",search="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],search);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("ChecklistTab"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						driver.findElement(By.xpath(Object.getProperty("ChecklistCreate"))).click();
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("ChecklistItem"))).sendKeys(split[2]);
							driver.findElement(By.xpath(Object.getProperty("ChecklistAction"))).sendKeys(split[3]);
							driver.findElement(By.xpath(Object.getProperty("SaveChecklist"))).click();
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Checklist created successfully."))
								System.out.println("Checklist created successfully.");
						}
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblChecklistDataList']/tbody")); 
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						System.out.println("Size of checklist table: " +tr.size());
						for(int j=2; j<=tr.size(); j++)
						{
							value = driver.findElement(By.xpath(".//*[@id='tblChecklistDataList']/tbody/tr[" +j+"]/td[1]")).getText();
							System.out.println("table data: " +value);
							if(value.equalsIgnoreCase(split[2]))
							{
								create = true;
								break;
							}
						}
						if(create==true)
						{
							actRes = "Create Button in Checklist is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 13 finished its execution*************************");
						}
						else
						{
							actRes = "Create Button in Checklist is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 13 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//edit checklist button
				if(d[i][0].equalsIgnoreCase("TC14"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 14 is executing******************************");
						Thread.sleep(5000);
						
						Boolean edit=false;
						String value = "", msg="", action="", search="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],search);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("ChecklistTab"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblChecklistDataList']/tbody")); 
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						System.out.println("Size of checklist table: " +tr.size());
						for(int j=2; j<=tr.size(); j++)
						{
							value = driver.findElement(By.xpath(".//*[@id='tblChecklistDataList']/tbody/tr[" +j+"]/td[1]")).getText();
							System.out.println("table data: " +value);
							if(value.equalsIgnoreCase(split[2]))
							{
								driver.findElement(By.xpath(".//*[@id='tblChecklistDataList']/tbody/tr[" +j+"]/td[1]")).click();
								break;
							}
						}
						driver.findElement(By.xpath(Object.getProperty("ChecklistEdit"))).click();
						Thread.sleep(3000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("ChecklistItem"))).clear();
							driver.findElement(By.xpath(Object.getProperty("ChecklistItem"))).sendKeys(split[3]);
							Thread.sleep(3000);
							driver.findElement(By.xpath(Object.getProperty("SaveChecklist"))).click();
							Thread.sleep(3000);
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Checklist updated successfully."))
								System.out.println("Checklist updated successfully.");
							else
							{
								System.out.println("Checklist not updated successfully.");
								driver.findElement(By.xpath("/html/body/div[1]/div[1]/a/span")).click();
								t.overlay(driver);
								Thread.sleep(1000);
							}
						}
						WebElement table1 = driver.findElement(By.xpath(".//*[@id='tblChecklistDataList']/tbody")); 
						List<WebElement> tr1 = table1.findElements(By.tagName("tr"));
						System.out.println("Size of checklist table: " +tr1.size());
						for(int k=2; k<=tr1.size(); k++)
						{
							action = driver.findElement(By.xpath(".//*[@id='tblChecklistDataList']/tbody/tr[" +k+"]/td[1]")).getText();
							System.out.println("Action: " +action);
							if(action.equalsIgnoreCase(split[3]))
							{
								edit = true;
								break;
							}
						}
						if(edit==true)
						{
							actRes = "Edit Button in Checklist is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 14 finished its execution*************************");
						}
						else
						{
							actRes = "Edit Button in Checklist is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 14 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//copy checklist button
				if(d[i][0].equalsIgnoreCase("TC15"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 15 is executing******************************");
						Thread.sleep(5000);
						
						int size=0,newSz=0;
						String msg="",search="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],search);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("ChecklistTab"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblChecklistDataList']/tbody")); 
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						size = tr.size();
						System.out.println("Size of checklist table: " +size);
						
						driver.findElement(By.xpath(Object.getProperty("ChecklistCopyBtn"))).click();
						if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("CopyChecklistName"))).sendKeys(split[2]);
							List<WebElement> option = driver.findElements(By.xpath("/html/body/ul[5]/li"));
							for(WebElement opt : option)
							{
								System.out.println("Option: " +opt.getText());
								if(opt.getText().equalsIgnoreCase(split[2]))
								{
									opt.click();
									break;
								}
							}
							driver.findElement(By.xpath(Object.getProperty("ChecklistSaveCopy"))).click();
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Checklist copied successfully."))
							{
								table = driver.findElement(By.xpath(".//*[@id='tblChecklistDataList']/tbody")); 
								List<WebElement> tr1 = table.findElements(By.tagName("tr"));
								newSz = tr1.size();
								System.out.println("Size of new checklist table: " +newSz);
							}
							if(newSz!=size)
							{
								actRes = "Checklist Copy Button is working as expected";
								System.out.println(actRes);
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 15 finished its execution*************************");
							}
							else
							{
								actRes = "Checklist Copy Button is not working as expected";
								System.out.println(actRes);
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
								System.out.println("*********************TestCase 15 finished its execution*************************");
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//bulk upload checklist button
				if(d[i][0].equalsIgnoreCase("TC16"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 16 is executing******************************");
						Thread.sleep(5000);
						
						Boolean result = false;
						int size=0,newSz=0;
						String msg="",search="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],search);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("ChecklistTab"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblChecklistDataList']/tbody"));
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						size = tr.size();
						System.out.println("checklist table size: " +size);
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("ChecklistBulkUpload"))).click();
						//Template download
						driver.findElement(By.xpath(Object.getProperty("ChecklistTemplateDownload"))).click();
						Thread.sleep(25000);
						System.out.println("in Robot class");
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_DOWN);
						Thread.sleep(500);
						robot.keyRelease(KeyEvent.VK_DOWN);
						Thread.sleep(500);
						robot.keyPress(KeyEvent.VK_ENTER);
						Thread.sleep(500);
						robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(15000);
						
						driver.findElement(By.xpath(Object.getProperty("ChecklistBrowseBtn"))).click();
						Process browse = Runtime.getRuntime().exec("D:\\Magi\\AutoIt Proc\\ChecklistUpload.exe");
						browse.waitFor();
						if(d[i][6].equalsIgnoreCase("Upload"))
						{
							driver.findElement(By.xpath(Object.getProperty("ChecklistUploadBtn"))).click();
							Thread.sleep(7000);
							msg = t.alertWait();
							if(msg.equalsIgnoreCase(" Successfully Uploaded. "))
								result = true;							
						}
						else if(d[i][6].equalsIgnoreCase("Cancel"))
						{
							driver.findElement(By.xpath(Object.getProperty("ChecklistCancelBtn"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							table = driver.findElement(By.xpath(".//*[@id='tblChecklistDataList']/tbody"));
							List<WebElement> tr1 = table.findElements(By.tagName("tr"));
							newSz = tr1.size();
							System.out.println("New Checklist table size: " +newSz);
							if(newSz==size)
								result = true;
						}
						if(result==true)
						{
							actRes = "Bulk Upload Button in Checklist is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 16 finished its execution*************************");
						}
						else
						{
							actRes = "Bulk Upload Button in Checklist is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 16 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//deactivate checklist button
				if(d[i][0].equalsIgnoreCase("TC17"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 17 is executing******************************");
						Thread.sleep(5000);
						
				//		ArrayList<String> tab = new ArrayList<String>();
						Boolean result = false;
						String value="", msg="", success="", search="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],search);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("ChecklistTab"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblChecklistDataList']/tbody")); 
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						System.out.println("Size of checklist table: " +tr.size());
						for(int j=2; j<=tr.size(); j++)
						{
							value = driver.findElement(By.xpath(".//*[@id='tblChecklistDataList']/tbody/tr[" +j+"]/td[1]")).getText();
							System.out.println("table data: " +value);
							if(value.equalsIgnoreCase(split[2]))
							{
								driver.findElement(By.xpath(".//*[@id='tblChecklistDataList']/tbody/tr[" +j+"]/td[1]")).click();
								break;
							}
						}
						driver.findElement(By.xpath(Object.getProperty("ChecklistDeactivate"))).click();
						msg = t.alertWait();
						if(msg.equalsIgnoreCase("Do you want to deactivate the Model Checklist."))
						{
							success = t.alertWait();
							if(success.equalsIgnoreCase("Checklist deactivated successfully."))
								System.out.println("Checklist deactivated successfully.");
						}
						WebElement table1 = driver.findElement(By.xpath(".//*[@id='tblChecklistDataList']/tbody")); 
						List<WebElement> tr1 = table1.findElements(By.tagName("tr"));
						System.out.println("Size of checklist table after Deactivating: " +tr1.size());
						for(int k=2; k<=tr1.size(); k++)
						{
							value = driver.findElement(By.xpath(".//*[@id='tblChecklistDataList']/tbody/tr[" +k+"]/td[1]")).getText();
							System.out.println("table data: " +value);
							if(!value.equalsIgnoreCase(split[2]))
								result = true;
							else
							{
								result = false;
								break;
							}
						}
						if(result==true)
						{
							actRes = "Deactivate in Checklist is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 17 finished its execution*************************");
						}
						else
						{
							actRes = "Deactivate in Checklist is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 17 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//create interval button
				if(d[i][0].equalsIgnoreCase("TC18"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 18 is executing******************************");
						Thread.sleep(5000);
						
						String value="", msg="", search="";
						Boolean create=false;
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],search);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("IntervalTab"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						driver.findElement(By.xpath(Object.getProperty("CreateInterval"))).click();
						Thread.sleep(3000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("IntervalName"))).sendKeys(split[2]);
							Select maintainedBy = new Select(driver.findElement(By.xpath(Object.getProperty("IntervalType"))));
							maintainedBy.selectByValue(split[3]);
							if(split[3].equalsIgnoreCase("Calendar"))
							{
								Select calDate = new Select(driver.findElement(By.xpath(Object.getProperty("IntervalCalendarDate"))));
								calDate.selectByValue(split[4]);
							}
							else if(split[3].equalsIgnoreCase("Engine Hours"))
							{
								Select sensor = new Select(driver.findElement(By.xpath(Object.getProperty("SensorReading"))));
								sensor.selectByValue(split[5]);
							}
							
							Select tier = new Select(driver.findElement(By.xpath(Object.getProperty("IntervalTier"))));
							tier.selectByValue(split[6]);
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("AddParts")), driver))
							{
								Select parts = new Select(driver.findElement(By.xpath(Object.getProperty("PartsList"))));
								parts.selectByVisibleText(split[7]);
								driver.findElement(By.xpath(Object.getProperty("AddParts"))).click();
							}
							else
							{
								System.out.println("No more Parts to Add");
							}
							if(t.isElementPresentcheck(By.xpath(Object.getProperty("AddChecklist")), driver))
							{
								Select checklist = new Select(driver.findElement(By.xpath(Object.getProperty("ChecklistDrop"))));
								checklist.selectByVisibleText(split[8]);
								driver.findElement(By.xpath(Object.getProperty("AddChecklist"))).click();
							}
							else
							{
								System.out.println("No more Parts/Checklist to Add");
							}
							driver.findElement(By.xpath(Object.getProperty("CreateIntervalBtn"))).click();
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Interval Created Successfully."))
								System.out.println("Interval Created Successfully.");
							WebElement table = driver.findElement(By.xpath(".//*[@id='tblIntervalsDataList']/tbody"));
							List<WebElement> tr = table.findElements(By.tagName("tr"));
							System.out.println("Created table size: " +tr.size());
							for(int k=2;k<=tr.size();k++)
							{
								value = driver.findElement(By.xpath(".//*[@id='tblIntervalsDataList']/tbody/tr["+k+"]/td[1]")).getText();
								System.out.println("Table interval name: " +value);
								if(value.equalsIgnoreCase(split[2]))
								{
									create = true;
									break;
								}
							}
							if(create==true)
							{
								actRes = "Create Interval Button is working as expected";
								System.out.println(actRes);
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 18 finished its execution*************************");
							}
							else
							{
								actRes = "Create Interval Button is not working as expected";
								System.out.println(actRes);
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
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
				//edit interval button
				if(d[i][0].equalsIgnoreCase("TC19"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 19 is executing******************************");
						Thread.sleep(5000);
						
						String value="", msg="", search="", result="";
						Boolean edit=false;
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],search);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("IntervalTab"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblIntervalsDataList']/tbody"));
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						System.out.println("Created table size: " +tr.size());
						for(int k=2;k<=tr.size();k++)
						{
							value = driver.findElement(By.xpath(".//*[@id='tblIntervalsDataList']/tbody/tr["+k+"]/td[1]")).getText();
							System.out.println("Table interval name: " +value);
							if(value.equalsIgnoreCase(split[2]))
							{
								driver.findElement(By.xpath(".//*[@id='tblIntervalsDataList']/tbody/tr["+k+"]/td[1]")).click();
								break;
							}
						}
						driver.findElement(By.xpath(Object.getProperty("EditInterval"))).click();
						Thread.sleep(3000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("IntervalName"))).clear();
							driver.findElement(By.xpath(Object.getProperty("IntervalName"))).sendKeys(split[3]);
							driver.findElement(By.xpath(Object.getProperty("CreateIntervalBtn"))).click();
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Interval Updated Successfully."))
								System.out.println("Interval Updated Successfully.");
							else
							{
								if(t.isElementPresentcheck(By.xpath("/html/body/div[1]/div[1]/a/span"), driver))
								{
									driver.findElement(By.xpath("/html/body/div[1]/div[1]/a/span")).click();
									t.overlay(driver);
									Thread.sleep(3000);
								}
							}
						}
						WebElement updatedTable = driver.findElement(By.xpath(".//*[@id='tblIntervalsDataList']/tbody"));
						List<WebElement> updatedTr = updatedTable.findElements(By.tagName("tr"));
						System.out.println("Created table size: " +updatedTr.size());
						for(int l=2;l<=updatedTr.size();l++)
						{
							result = driver.findElement(By.xpath(".//*[@id='tblIntervalsDataList']/tbody/tr["+l+"]/td[1]")).getText();
							System.out.println("Table interval name: " +result);
							if(result.equalsIgnoreCase(split[3]))
							{
								edit = true;
								break;
							}
						}
						if(edit==true)
						{
							actRes = "Edit Interval Button is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 19 finished its execution*************************");
						}
						else
						{
							actRes = "Edit Interval Button is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 19 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}	
				}
				//copy interval button
				if(d[i][0].equalsIgnoreCase("TC20"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 20 is executing******************************");
						Thread.sleep(5000);
						
						String value="", msg="", search="",result="";
						Boolean copy = false;
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],search);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("IntervalTab"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblIntervalsDataList']/tbody"));
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						for(int j=2;j<=tr.size();j++)
						{
							value = driver.findElement(By.xpath(".//*[@id='tblIntervalsDataList']/tbody/tr["+j+"]/td[1]")).getText();
							System.out.println("Table interval name: " +value);
							if(value.equalsIgnoreCase(split[2]))
							{
								driver.findElement(By.xpath(".//*[@id='tblIntervalsDataList']/tbody/tr["+j+"]/td[1]")).click();
								driver.findElement(By.xpath(Object.getProperty("CopyIntervalBtn"))).click();
								break;
							}
						}
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							Select interval = new Select(driver.findElement(By.xpath(Object.getProperty("DropCopyInterval"))));
							interval.selectByValue(split[3]);
							Select tier = new Select(driver.findElement(By.xpath(Object.getProperty("DropCopyIntervalsTier"))));
							tier.selectByValue(split[4]);
							driver.findElement(By.xpath(Object.getProperty("CreateCopyInterval"))).click();
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Interval copied sucessfully."))
								System.out.println("Interval copied sucessfully.");
							else
							{
								driver.findElement(By.xpath("/html/body/div[1]/div[1]/a/span")).click();
							}
						}
						WebElement table1 = driver.findElement(By.xpath(".//*[@id='tblIntervalsDataList']/tbody"));
						List<WebElement> tr1 = table1.findElements(By.tagName("tr"));
						for(int k=2;k<=tr1.size();k++)
						{
							result = driver.findElement(By.xpath(".//*[@id='tblIntervalsDataList']/tbody/tr["+k+"]/td[1]")).getText();
							System.out.println("Table interval name: " +result);
							if(result.contains(split[3]))
							{
								copy = true;
								break;
							}
							else
								copy = false;
						}
						if(copy==true)
						{
							actRes = "Copy Interval Button is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 20 finished its execution*************************");
						}
						else
						{
							actRes = "Copy Interval Button is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
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
				//deactivate interval button
				if(d[i][0].equalsIgnoreCase("TC21"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 21 is executing******************************");
						Thread.sleep(5000);
						
						String value="", msg="", search="",success="",result="";
						Boolean del = false;
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],search);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("IntervalTab"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblIntervalsDataList']/tbody"));
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						for(int j=2;j<=tr.size();j++)
						{
							value = driver.findElement(By.xpath(".//*[@id='tblIntervalsDataList']/tbody/tr["+j+"]/td[1]")).getText();
							System.out.println("Table interval name: " +value);
							if(value.equalsIgnoreCase(split[2]))
							{
								driver.findElement(By.xpath(".//*[@id='tblIntervalsDataList']/tbody/tr["+j+"]/td[1]")).click();
								driver.findElement(By.xpath(Object.getProperty("DeactivateInterval"))).click();
								msg = t.alertWait();
								if(msg.equalsIgnoreCase("Do you want to deactivate the Model Interval."))
								{
									success = t.alertWait();
									if(success.equalsIgnoreCase("Interval Deactivated Successfully"))
										break;
								}
							}
						}
						WebElement table1 = driver.findElement(By.xpath(".//*[@id='tblIntervalsDataList']/tbody"));
						List<WebElement> tr1 = table1.findElements(By.tagName("tr"));
						for(int k=2;k<=tr1.size();k++)
						{
							result = driver.findElement(By.xpath(".//*[@id='tblIntervalsDataList']/tbody/tr["+k+"]/td[1]")).getText();
							System.out.println("Check deleted Table interval name: " +result);
							if(result.equalsIgnoreCase(split[2]))
							{
								del = false;
								break;
							}
							else
								del = true;
						}
						if(del==true)
						{
							actRes = "Deactivate Interval Button is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 21 finished its execution*************************");
						}
						else
						{
							actRes = "Deactivate Interval Button is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 21 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//search and clear button in alarm
				if(d[i][0].equalsIgnoreCase("TC22"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 22 is executing******************************");
						Thread.sleep(5000);
						
						String search = "",headValue="", tableVal="";
						int headCount=0;
						Boolean searchVal = false;
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0], split[1], search);
						Thread.sleep(2000);
						
						driver.findElement(By.xpath(Object.getProperty("AlarmsTab11"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						Select source = new Select(driver.findElement(By.xpath(Object.getProperty("SelectEngineType"))));
						source.selectByValue(split[2]);
						Select language = new Select(driver.findElement(By.xpath(Object.getProperty("SelectLang"))));
						language.selectByValue(split[3]);
						driver.findElement(By.xpath(Object.getProperty("AlarmSearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody"));
						List<WebElement> head = table.findElements(By.tagName("th"));
						for(int j=1;j<=head.size();j++)
						{
							headValue = driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody/tr[1]/th[" +j+"]")).getText();
							System.out.println("Head value: " +headValue);
							if(headValue.equalsIgnoreCase(split[4]))
							{
								headCount = j;
								break;
							}
						}
						System.out.println("Head count: " +headCount);
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						for(int sel=2;sel<=tr.size();sel++)
						{
							tableVal = driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody/tr[" +sel+ "]/td[" +headCount+ "]")).getText();
							System.out.println("Search type value in table: " +tableVal);
							if(tableVal.equalsIgnoreCase(split[2]))
								searchVal = true;
							else
							{
								searchVal = false;
								break;
							}
						}
						driver.findElement(By.xpath(Object.getProperty("AlarmClearBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						if(searchVal==true)
						{
							actRes = "Search and Clear Button in Alarm is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 22 finished its execution*************************");
						}
						else
						{
							actRes = "Search and Clear Button in Alarm is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 22 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//create alarm button
				if(d[i][0].equalsIgnoreCase("TC23"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 23 is executing******************************");
						Thread.sleep(5000);
						
						String search = "",msg="", tableVal="";
						Boolean create = false,reset = false;
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0], split[1], search);
						Thread.sleep(2000);
						
						driver.findElement(By.xpath(Object.getProperty("AlarmsTab11"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						driver.findElement(By.xpath(Object.getProperty("AddAlarm"))).click();
						Thread.sleep(3000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("AlarmDescription"))).sendKeys(split[2]);
							driver.findElement(By.xpath(Object.getProperty("AlarmSPN"))).sendKeys(split[3]);
							driver.findElement(By.xpath(Object.getProperty("AlarmFMI"))).sendKeys(split[4]);
							Select tier = new Select(driver.findElement(By.xpath(Object.getProperty("AlarmTier"))));
							tier.deselectAll();
							tier.selectByValue(split[5]);
							Select source = new Select(driver.findElement(By.xpath(Object.getProperty("AlarmSource"))));
							source.selectByVisibleText(split[6]);
							Select prior = new Select(driver.findElement(By.xpath(Object.getProperty("AlarmPriority"))));
							prior.selectByValue(split[7]);
							driver.findElement(By.xpath(Object.getProperty("ResetAlarmBtn"))).click();
							
							if(driver.findElement(By.xpath(Object.getProperty("AlarmDescription"))).getText().isEmpty() && 
									driver.findElement(By.xpath(Object.getProperty("AlarmSPN"))).getText().isEmpty())
							{
								reset = true;
								System.out.println("Reset button is working");
								driver.findElement(By.xpath(Object.getProperty("CancelAlarmBtn"))).click();
								t.overlay(driver);
								Thread.sleep(1000);
							}
							else
								reset = false;
						}
						
						driver.findElement(By.xpath(Object.getProperty("AddAlarm"))).click();
						Thread.sleep(3000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("AlarmDescription"))).sendKeys(split[2]);
							driver.findElement(By.xpath(Object.getProperty("AlarmSPN"))).sendKeys(split[3]);
							driver.findElement(By.xpath(Object.getProperty("AlarmFMI"))).clear();
							driver.findElement(By.xpath(Object.getProperty("AlarmFMI"))).sendKeys(split[4]);
							Select tier = new Select(driver.findElement(By.xpath(Object.getProperty("AlarmTier"))));
							tier.deselectAll();
							tier.selectByValue(split[5]);
							Select source = new Select(driver.findElement(By.xpath(Object.getProperty("AlarmSource"))));
							source.selectByVisibleText(split[6]);
							Select prior = new Select(driver.findElement(By.xpath(Object.getProperty("AlarmPriority"))));
							prior.selectByValue(split[7]);
							driver.findElement(By.xpath(Object.getProperty("CreateAlarmBtn"))).click();
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Alarm added successfully."))
								System.out.println("Alarm Created");
							else if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
							{
								driver.findElement(By.xpath(Object.getProperty("CancelAlarmBtn"))).click();
								t.overlay(driver);
								Thread.sleep(1000);
							}						
						}
						Select source = new Select(driver.findElement(By.xpath(Object.getProperty("SelectEngineType"))));
						source.selectByVisibleText(split[6]);
						Select language = new Select(driver.findElement(By.xpath(Object.getProperty("SelectLang"))));
						language.selectByValue(split[8]);
						driver.findElement(By.xpath(Object.getProperty("AlarmSearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody"));
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						for(int j=2;j<=tr.size();j++)
						{
							tableVal = driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody/tr["+j+"]/td[1]")).getText();
							System.out.println("Table data: " +tableVal);
							if(tableVal.equalsIgnoreCase(split[3]))
							{
								create = true;
								break;
							}
							else
								create = false;
						}
						if(reset==true && create==true)
						{
							actRes = "Create Alarm Button is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 23 finished its execution*************************");
						}
						else
						{
							actRes = "Create Alarm Button is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 23 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//edit button in alarm
				if(d[i][0].equalsIgnoreCase("TC24"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 24 is executing******************************");
						Thread.sleep(5000);
						
						String search="",searchVal="",msg="",result="";
						Boolean edit= false;
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0], split[1], search);
						Thread.sleep(2000);
						
						driver.findElement(By.xpath(Object.getProperty("AlarmsTab11"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody"));
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						for(int j=2;j<=tr.size();j++)
						{
							searchVal = driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody/tr["+j+"]/td[2]")).getText();
							System.out.println("Searched value is: " +searchVal);
							if(searchVal.equalsIgnoreCase(split[2]))
							{
								driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody/tr["+j+"]/td[2]")).click();
								break;
							}
						}
						driver.findElement(By.xpath(Object.getProperty("AlarmEditBtn"))).click();
						Thread.sleep(3000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
						{
							Thread.sleep(7000);
							driver.findElement(By.xpath(Object.getProperty("EditAlarmDescription"))).clear();
							driver.findElement(By.xpath(Object.getProperty("EditAlarmDescription"))).sendKeys(split[3]);
							driver.findElement(By.xpath(Object.getProperty("AlarmEditUpdate"))).click();
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Alarm updated successfully."))
								System.out.println("Alarm is edited");
							else if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
							{
								driver.findElement(By.xpath(Object.getProperty("AlarmEditCancel"))).click();
								t.overlay(driver);
								Thread.sleep(2000);
							}
						}
						Select source = new Select(driver.findElement(By.xpath(Object.getProperty("SelectEngineType"))));
						source.selectByVisibleText(split[4]);
						Select language = new Select(driver.findElement(By.xpath(Object.getProperty("SelectLang"))));
						language.selectByValue(split[5]);
						driver.findElement(By.xpath(Object.getProperty("AlarmSearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(3000);
						table = driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody"));
						List<WebElement> tr1 = table.findElements(By.tagName("tr"));
						for(int k=2;k<=tr1.size();k++)
						{
							result = driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody/tr["+k+"]/td[2]")).getText();
							System.out.println("Result value: " +result);
							if(result.equalsIgnoreCase(split[3]))
							{
								edit = true;
								break;
							}
						}
						if(edit==true)
						{
							actRes = "Edit Button in Alarm is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 24 finished its execution*************************");
						}
						else
						{
							actRes = "Edit Button in Alarm is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 24 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//page no button in alarm
				if(d[i][0].equalsIgnoreCase("TC25"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 25 is executing******************************");
						Thread.sleep(5000);
						
						String search="";
						Boolean result = false;
						String str = d[i][5];
						String[] split = str.split(",") ;
						Thread.sleep(3000);
						
						t.searchModel(split[0], split[1], search);
						Thread.sleep(2000);
						
						driver.findElement(By.xpath(Object.getProperty("AlarmsTab11"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						WebElement num = driver.findElement(By.xpath(Object.getProperty("AlarmPaging")));
						List<WebElement> page = num.findElements(By.tagName("a"));
						for(WebElement pg : page)
						{
							System.out.println("Page numb: " +pg.getText());
							if(pg.getText().equalsIgnoreCase(d[i][6]))
							{
								pg.click();
								t.overlay(driver);
								Thread.sleep(1000);
								break;
							}
						}
						List<WebElement> selectedPg = num.findElements(By.className("cPagingText"));
						for(WebElement pageNum : selectedPg)
						{
							System.out.println("Selected Page is: " +pageNum.getText());
							if(pageNum.getText().equalsIgnoreCase(d[i][6])){
								result = true;
								break;
							}
						}
						if(result==true)
						{
							actRes = "The Selected Page is displayed successfully";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 25 finished its execution*************************");
						}
						else
						{
							actRes = "The Selected Page is not displayed properly";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 25 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//copy alarm
				if(d[i][0].equalsIgnoreCase("TC26"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 26 is executing******************************");
						Thread.sleep(5000);
						
						String search="",searchVal="",msg="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0], split[1], search);
						Thread.sleep(2000);
						
						driver.findElement(By.xpath(Object.getProperty("AlarmsTab11"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody"));
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						for(int j=2;j<=tr.size();j++)
						{
							searchVal = driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody/tr["+j+"]/td[2]")).getText();
							System.out.println("Searched value is: " +searchVal);
							if(searchVal.equalsIgnoreCase(split[2]))
							{
								driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody/tr["+j+"]/td[2]")).click();
								break;
							}
						}
						driver.findElement(By.xpath(Object.getProperty("CopyAlarmBtn"))).click();
						Thread.sleep(2000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							driver.findElement(By.xpath(Object.getProperty("CopyAlarmModel"))).sendKeys(split[3]);
							Thread.sleep(2000);
							List<WebElement> option = driver.findElements(By.xpath("/html/body/ul[5]/li"));
							System.out.println("Size of option: " +option.size());
							for(WebElement opt: option)
							{
								System.out.println("Options: " +opt.getText());
								if(opt.getText().equalsIgnoreCase(split[3]))
								{
									opt.click();
									break;
								}
							}
							driver.findElement(By.xpath(Object.getProperty("SaveCopyAlarm"))).click();
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Alarm copied successfully."))
							{
								actRes = "Copy Alarm Button is working as expected";
								System.out.println(actRes);
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
								System.out.println("*********************TestCase 26 finished its execution*************************");
							}
							else
							{
								actRes = "Copy Alarm Button is not working as expected";
								System.out.println(actRes);
								data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
								rc++;
								s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
								System.out.println("*********************TestCase 26 finished its execution*************************");
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//bulk upload in alarm
				if(d[i][0].equalsIgnoreCase("TC27"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 27 is executing******************************");
						Thread.sleep(5000);
						
						Boolean result = false;
						int size=0;
						String msg="",search="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],search);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("AlarmsTab11"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody"));
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						size = tr.size();
						System.out.println("Alarm table size: " +size);
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("AlarmBulkUploadBtn"))).click();
						//Template download
						driver.findElement(By.xpath(Object.getProperty("AlarmTemplateDownload"))).click();
						Thread.sleep(25000);
						System.out.println("in Robot class");
						Robot robot = new Robot();
						robot.keyPress(KeyEvent.VK_DOWN);
						Thread.sleep(500);
						robot.keyRelease(KeyEvent.VK_DOWN);
						Thread.sleep(500);
						robot.keyPress(KeyEvent.VK_ENTER);
						Thread.sleep(500);
						robot.keyRelease(KeyEvent.VK_ENTER);
						Thread.sleep(15000);
						
						driver.findElement(By.xpath(Object.getProperty("AlarmBrowseBtn"))).click();
						Process browse = Runtime.getRuntime().exec("D:\\Magi\\AutoIt Proc\\AlarmUpload.exe");
						browse.waitFor();
						if(d[i][6].equalsIgnoreCase("Upload"))
						{
							driver.findElement(By.xpath(Object.getProperty("AlarmUploadBtn"))).click();
							Thread.sleep(7000);
							msg = t.alertWait();
							if(msg.equalsIgnoreCase(" Successfully Uploaded. "))
								result = true;							
						}
						else if(d[i][6].equalsIgnoreCase("Cancel"))
						{
							driver.findElement(By.xpath(Object.getProperty("AlarmUploadCancelBtn"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
						}
						if(result==true)
						{
							actRes = "Bulk Upload Button in Alarm is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 27 finished its execution*************************");
						}
						else
						{
							actRes = "Bulk Upload Button in Alarm is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 27 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//deactivate alarm button
				if(d[i][0].equalsIgnoreCase("TC28"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("ModelManager")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 28 is executing******************************");
						Thread.sleep(5000);
						
						String msg="",search="", value="",success="",result="";
						Boolean delete = false;
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						t.searchModel(split[0],split[1],search);
						Thread.sleep(3000);
						
						driver.findElement(By.xpath(Object.getProperty("AlarmsTab11"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody"));
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						for(int j=2;j<=tr.size();j++)
						{
							value = driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody/tr["+j+"]/td[2]")).getText();
							System.out.println("Value: " +value);
							if(value.equalsIgnoreCase(split[2]))
							{
								driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody/tr["+j+"]/td[2]")).click();
								break;
							}
						}
						driver.findElement(By.xpath(Object.getProperty("RemoveAlarm"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						msg = t.alertWait();
						if(msg.equalsIgnoreCase("Do you want to Remove selected Alarm?"))
						{
							success = t.alertWait();
							if(success.equalsIgnoreCase("Removed Successfully"))
							{
								table = driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody"));
								List<WebElement> tr1 = table.findElements(By.tagName("tr"));
								for(int k=2;k<=tr1.size();k++)
								{
									result = driver.findElement(By.xpath(".//*[@id='tblAlarmDataList']/tbody/tr["+k+"]/td[2]")).getText();
									System.out.println("Table values: " +result);
									if(result.equalsIgnoreCase(split[2]))
									{
										delete = false;
										break;
									}
									else
										delete = true;
								}
							}
						}
						if(delete==true)
						{
							actRes = "Deactivate Alarm Button is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 28 finished its execution*************************");
						}
						else
						{
							actRes = "Deactivate Alarm Button is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][7], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 28 finished its execution*************************");
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
