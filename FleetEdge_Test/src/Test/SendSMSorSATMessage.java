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

public class SendSMSorSATMessage extends Core
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]> SendSMSorSATMessageTest(Map<String, Object[]> data, int rc, String sheet, ExtentTest test, int scase, int ecase) 
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
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Support")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("TerminalTest")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 1 is executing******************************");
						Thread.sleep(5000);
						
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("SelectionType")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SearchBox")), driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("SearchBtn")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ClearBtn")),driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("MMC")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TestBtn")),driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("TerminalSN")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("TerminalType")),driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("EngineType")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SignalStrength")),driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("UTC")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("Longitude")),driver)
								&& t.isElementPresentcheck(By.xpath(Object.getProperty("Latitude")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("MNC")),driver))
						{
							System.out.println("All the elements are present in the Terminal Test");
							actRes = "All the elements are present in the Terminal Test";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 1 finished its execution*************************");
						}
						else
						{
							System.out.println("All the elements are not present in the Terminal Test");
							actRes = "All the elements are not present in the Terminal Test";
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
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Support")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("TerminalTest")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 2 is executing******************************");
						Thread.sleep(5000);
						
						String value="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						Select type = new Select(driver.findElement(By.xpath(Object.getProperty("SelectionType"))));
						type.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						WebElement table = driver.findElement(By.xpath(".//*[@id='tblTerminalList']/tbody"));
						List<WebElement> tr = table.findElements(By.tagName("tr"));
						for(int j=2;j<=tr.size();j++)
						{
							value = driver.findElement(By.xpath(".//*[@id='tblTerminalList']/tbody/tr["+j+"]/td[2]")).getText();
							System.out.println("Table value: " +value);
							if(value.equalsIgnoreCase(split[1]))
								break;
						}
						driver.findElement(By.xpath(Object.getProperty("ClearBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						if(value.equalsIgnoreCase(split[1]) && driver.findElement(By.xpath(Object.getProperty("SearchBox"))).getText().isEmpty())
						{
							actRes = "Search and Clear Button are working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 2 finished its execution*************************");
						}
						else
						{
							actRes = "Search and Clear Button are not working as expected";
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
				//test button
				if(d[i][0].equalsIgnoreCase("TC3"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Support")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("TerminalTest")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 3 is executing******************************");
						Thread.sleep(5000);
						
					//	String value="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						Select type = new Select(driver.findElement(By.xpath(Object.getProperty("SelectionType"))));
						type.selectByValue(split[0]);
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
						driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
						driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
						t.overlay(driver);
						Thread.sleep(1000);
						
						driver.findElement(By.xpath(Object.getProperty("TestBtn"))).click();
						
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

