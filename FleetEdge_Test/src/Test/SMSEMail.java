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

public class SMSEMail extends Core
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]> EMailTest(Map<String, Object[]> data, int rc, String sheet, ExtentTest test, int scase, int ecase) 
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
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("SmsEmailConfig")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 1 is executing******************************");
						Thread.sleep(5000);
						
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("IssueSearchType")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SearchBox")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("SearchBtn")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ClearBtn")),driver)
								&& t.isElementPresentcheck(By.xpath(".//*[@id='divPaging']"), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("EditConfig")),driver))
						{
							System.out.println("All the elements are present in the SMS or Email Template");
							actRes = "All the elements are present in the SMS or Email Template";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 1 finished its execution*************************");
						}
						else
						{
							System.out.println("All the elements are not present in the SMS or Email Template");
							actRes = "All the elements are not present in the SMS or Email Template";
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
				//search and clear button
				if(d[i][0].equalsIgnoreCase("TC2"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("SmsEmailConfig")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 2 is executing******************************");
						Thread.sleep(5000);
						
						int count=0;
						String tabVal="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						Select type = new Select(driver.findElement(By.xpath(Object.getProperty("IssueSearchType"))));
						type.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblConfigurationList']"));
						List<WebElement> head = table.findElements(By.tagName("th"));
						System.out.println("Head size: " +head.size());
						for(int find=1;find<=head.size();find++)
						{
							System.out.println("Head value: " +head.get(find).getText());
							if(head.get(find).getText().equalsIgnoreCase(split[0]))
							{
								count=find+1;
								tabVal = driver.findElement(By.xpath(".//*[@id='tblConfigurationList']/tbody/tr[1]/td["+count+"]")).getText();
								break;
							}
						}
						System.out.println("Head count: " +count);
						driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
						if(tabVal.equalsIgnoreCase(split[1]) && driver.findElement(By.xpath(Object.getProperty("SearchBox"))).getText().isEmpty())
						{
							actRes = "Search and Clear Button is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 2 finished its execution*************************");						
						}
						else
						{
							actRes = "Search and Clear Button is not working as expected";
							System.out.println(actRes);
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
				//Page no button
				if(d[i][0].equalsIgnoreCase("TC3"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("SmsEmailConfig")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 3 is executing******************************");
						Thread.sleep(5000);
						
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("Page")), driver))
						{
							List<WebElement> page = driver.findElements(By.xpath(Object.getProperty("Page")));
							for(WebElement pg: page)
							{
								System.out.println("Page no: " +pg.getText());
								if(pg.getText().equalsIgnoreCase(d[i][5]))
								{
									pg.click();
									t.overlay(driver);
									Thread.sleep(1000);
									break;
								}
							}
							WebElement num = driver.findElement(By.xpath("//*[@id='divPaging']"));
							List<WebElement> no = num.findElements(By.className("cPagingText"));
							for(WebElement n : no)
							{
								if(n.getText().equalsIgnoreCase(d[i][5]))
								{
									actRes = "The selected Page no is displayed successfully";
									System.out.println(actRes);
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
									System.out.println("*********************TestCase 3 finished its execution*************************");
								}
								else
								{
									actRes = "The selected Page no is not displayed successfully";
									System.out.println(actRes);
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
									System.out.println("*********************TestCase 3 finished its execution*************************");
								}
							}
						}
						else
						{
							actRes = "Single Page is only present and is displayed successfully";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 3 finished its execution*************************");
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
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("SmsEmailConfig")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 4 is executing******************************");
						Thread.sleep(5000);
						
						String value="",msg="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						Select type = new Select(driver.findElement(By.xpath(Object.getProperty("IssueSearchType"))));
						type.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						value = driver.findElement(By.xpath(".//*[@id='tblConfigurationList']/tbody/tr")).getText();
						System.out.println("Val: " +value);
						if(value.contains(split[1]))
						{
							driver.findElement(By.xpath(".//*[@id='tblConfigurationList']/tbody/tr/td[1]")).click();
							t.overlay(driver);
							Thread.sleep(3000);
						}
						driver.findElement(By.xpath(Object.getProperty("EditConfig"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[1]"), driver))
						{
							driver.findElement(By.className("jqte_editor")).click();
							driver.findElement(By.className("jqte_editor")).sendKeys(split[2]);
							driver.findElement(By.xpath(Object.getProperty("SaveEditConfig"))).click();
							msg = t.alertWait();
							if(msg.equalsIgnoreCase("Configuration updated successfully"))
							{
								actRes = "Edit Button is working as expected";
								System.out.println(actRes);;
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
