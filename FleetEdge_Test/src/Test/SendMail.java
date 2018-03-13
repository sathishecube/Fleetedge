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

public class SendMail extends Core 
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]> SendMailTest(Map<String, Object[]> data, int rc, String sheet, ExtentTest test, int scase, int ecase) 
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
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("SendMail")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 1 is executing******************************");
						Thread.sleep(5000);
						
						if(t.isElementPresentcheck(By.xpath(Object.getProperty("To")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Cc")), driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Subject")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("CreateHTMLContentBtn")),driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Content")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("BrowseBtn")),driver)
								|| t.isElementPresentcheck(By.xpath(Object.getProperty("Send")), driver) || t.isElementPresentcheck(By.xpath(Object.getProperty("Cancel")),driver)
								|| t.isElementPresentcheck(By.className(Object.getProperty("SelectTo")), driver) || t.isElementPresentcheck(By.className(Object.getProperty("SelectCc")), driver))
						{
							System.out.println("All the elements are present in the Send Mail");
							actRes = "All the elements are present in the Send Mail";
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 1 finished its execution*************************");
						}
						else
						{
							System.out.println("All the elements are not present in the Send Mail");
							actRes = "All the elements are not present in the Send Mail";
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
				//Select button (To)
				if(d[i][0].equalsIgnoreCase("TC2"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("SendMail")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 2 is executing******************************");
						Thread.sleep(5000);
						
						String value="";
						String str = d[i][5];
						String[] split = str.split(",");
						Boolean search=false, clear=false;
						Thread.sleep(5000);
						
						WebElement selectTo = driver.findElement(By.cssSelector("a[class='selectUser selectUserPopTo']"));
						selectTo.click();
						t.overlay(driver);
						Thread.sleep(2000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
						{
							//clear button verification
							Select to = new Select(driver.findElement(By.xpath(Object.getProperty("SelectionType"))));
							to.selectByVisibleText(split[0]);
							driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
							driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("SubscriptionClear"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							if(driver.findElement(By.xpath(Object.getProperty("SearchBox"))).getText().isEmpty())
								clear = true;
							//search button verification
							to = new Select(driver.findElement(By.xpath(Object.getProperty("SelectionType"))));
							to.selectByVisibleText(split[0]);
							driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
							driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							value = driver.findElement(By.xpath(".//*[@id='tblUserList']/tbody/tr/td[3]")).getText();
							if(value.equalsIgnoreCase(split[1]))
							{
								search = true;
								driver.findElement(By.xpath(".//*[@id='tblUserList']/tbody/tr/td[3]")).click();
								driver.findElement(By.xpath(Object.getProperty("SelectBtn"))).click();
								t.overlay(driver);
								Thread.sleep(2000);
							}
						}
						System.out.println("search: " +search+ " clear: " +clear);
						if(search==true && clear==true)
						{
							actRes = "Select Button in To is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 2 finished its execution*************************");
						}
						else
						{
							actRes = "Select Button in To is not working as expected";
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
				//Page no button in To
				if(d[i][0].equalsIgnoreCase("TC3"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("SendMail")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 3 is executing******************************");
						Thread.sleep(5000);
						
						WebElement selectTo = driver.findElement(By.cssSelector("a[class='selectUser selectUserPopTo']"));
						selectTo.click();
						t.overlay(driver);
						Thread.sleep(2000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
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
									actRes = "Page No Button in To is working as expected";
									System.out.println(actRes);
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
									System.out.println("*********************TestCase 3 finished its execution*************************");
								}
								else
								{
									actRes = "Page No Button in To is not working as expected";
									System.out.println(actRes);
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
									System.out.println("*********************TestCase 3 finished its execution*************************");
								}
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//Select Id in Cc
				if(d[i][0].equalsIgnoreCase("TC4"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("SendMail")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 4 is executing******************************");
						Thread.sleep(5000);
						
						String value="";
						String str = d[i][5];
						String[] split = str.split(",");
						Boolean search=false, clear=false;
						Thread.sleep(5000);
						
						WebElement selectCc = driver.findElement(By.cssSelector("a[class='selectUser selectUserPopCC']"));
						selectCc.click();
						t.overlay(driver);
						Thread.sleep(2000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
						{
							//clear button verification
							Select cc = new Select(driver.findElement(By.xpath(Object.getProperty("SelectionType"))));
							cc.selectByVisibleText(split[0]);
							driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
							driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							driver.findElement(By.xpath(Object.getProperty("SubscriptionClear"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							if(driver.findElement(By.xpath(Object.getProperty("SearchBox"))).getText().isEmpty())
								clear = true;
							//search button verification
							cc = new Select(driver.findElement(By.xpath(Object.getProperty("SelectionType"))));
							cc.selectByVisibleText(split[0]);
							driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
							driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							value = driver.findElement(By.xpath(".//*[@id='tblUserList']/tbody/tr/td[4]")).getText();
							if(value.equalsIgnoreCase(split[1]))
							{
								search = true;
								driver.findElement(By.xpath(".//*[@id='tblUserList']/tbody/tr/td[4]")).click();
								driver.findElement(By.xpath(Object.getProperty("SelectBtn"))).click();
								t.overlay(driver);
								Thread.sleep(2000);
							}
						}
						System.out.println("search: " +search+ " clear: " +clear);
						if(search==true && clear==true)
						{
							actRes = "Select Button in Cc is working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 4 finished its execution*************************");
						}
						else
						{
							actRes = "Select Button in Cc is not working as expected";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
							System.out.println("*********************TestCase 4 finished its execution*************************");
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//Page no button in Cc
				if(d[i][0].equalsIgnoreCase("TC5"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("SendMail")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 5 is executing******************************");
						Thread.sleep(5000);
						
						WebElement selectCc = driver.findElement(By.cssSelector("a[class='selectUser selectUserPopCC']"));
						selectCc.click();
						t.overlay(driver);
						Thread.sleep(2000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
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
									actRes = "Page No Button in Cc is working as expected";
									System.out.println(actRes);
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
									System.out.println("*********************TestCase 5 finished its execution*************************");
								}
								else
								{
									actRes = "Page No Button in Cc is not working as expected";
									System.out.println(actRes);
									data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Fail", t.timestamp(stime)});
									rc++;
									s.WriteInput(path, sheet, d[i][0], counter, actRes, "Fail");
									System.out.println("*********************TestCase 5 finished its execution*************************");
								}
							}
						}
					}
					catch(Exception e)
					{
						e.printStackTrace();
					}
				}
				//Send button
				if(d[i][0].equalsIgnoreCase("TC6"))
				{
					try
					{
						t.overlay(driver);
						Thread.sleep(3000);
						WebElement x = driver.findElement(By.xpath(Object.getProperty("Admin")));
						WebElement y =  driver.findElement(By.xpath(Object.getProperty("SendMail")));
						t.fleetSelect(driver,x,y);
						System.out.println("**************************TestCase 6 is executing******************************");
						Thread.sleep(5000);
						
						Boolean cancel=false;
						String msg="", value="";
						String str = d[i][5];
						String[] split = str.split(",");
						Thread.sleep(3000);
						
						//To
						WebElement selectTo = driver.findElement(By.cssSelector("a[class='selectUser selectUserPopTo']"));
						selectTo.click();
						t.overlay(driver);
						Thread.sleep(2000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
						{
							Select to = new Select(driver.findElement(By.xpath(Object.getProperty("SelectionType"))));
							to.selectByVisibleText(split[0]);
							driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[1]);
							driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							value = driver.findElement(By.xpath(".//*[@id='tblUserList']/tbody/tr/td[3]")).getText();
							if(value.equalsIgnoreCase(split[1]))
							{
								driver.findElement(By.xpath(".//*[@id='tblUserList']/tbody/tr/td[3]")).click();
								driver.findElement(By.xpath(Object.getProperty("SelectBtn"))).click();
								t.overlay(driver);
								Thread.sleep(2000);
							}
						}
						//Cc
						WebElement selectCc = driver.findElement(By.cssSelector("a[class='selectUser selectUserPopCC']"));
						selectCc.click();
						t.overlay(driver);
						Thread.sleep(2000);
						if(t.isElementPresentcheck(By.xpath("/html/body/div[2]"), driver))
						{
							Select cc = new Select(driver.findElement(By.xpath(Object.getProperty("SelectionType"))));
							cc.selectByVisibleText(split[0]);
							driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(split[2]);
							driver.findElement(By.xpath(Object.getProperty("SubscriptionSearch"))).click();
							t.overlay(driver);
							Thread.sleep(1000);
							value = driver.findElement(By.xpath(".//*[@id='tblUserList']/tbody/tr/td[3]")).getText();
							if(value.equalsIgnoreCase(split[2]))
							{
								driver.findElement(By.xpath(".//*[@id='tblUserList']/tbody/tr/td[3]")).click();
								driver.findElement(By.xpath(Object.getProperty("SelectBtn"))).click();
								t.overlay(driver);
								Thread.sleep(2000);
							}
						}
						//subject
						driver.findElement(By.xpath(Object.getProperty("Subject"))).sendKeys(split[3]);
						Thread.sleep(2000);
						//Attachment
						driver.findElement(By.xpath(Object.getProperty("BrowseBtn"))).click();
						Process attach = Runtime.getRuntime().exec("D:\\Magi\\AutoIt Proc\\SendMail.exe");
						attach.waitFor();
						//Content
						driver.findElement(By.xpath(Object.getProperty("CreateHTMLContentBtn"))).click();
						Thread.sleep(3000);
						System.out.println("In editor");
						driver.findElement(By.className("jqte_editor")).click();
						driver.findElement(By.className("jqte_editor")).sendKeys(split[4]);
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("CancelEmailContent"))).click();
						if(driver.findElement(By.xpath(Object.getProperty("Content"))).getText().isEmpty())
						{
							System.out.println("Content is empty");
							cancel = true;
						}
						//save button
						driver.findElement(By.xpath(Object.getProperty("CreateHTMLContentBtn"))).click();
						Thread.sleep(3000);
						System.out.println("In editor");
						driver.findElement(By.className("jqte_editor")).click();
						driver.findElement(By.className("jqte_editor")).sendKeys(split[4]);
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("SaveEmailContent"))).click();
						
						System.out.println("cancel: " +cancel);
						//result
						driver.findElement(By.xpath(Object.getProperty("Send"))).click();
						Thread.sleep(3000);
						msg = driver.findElement(By.id("MainContainer_lblStatus")).getText();
						if(msg.equalsIgnoreCase("Email sent successfully") && cancel==true)
						{
							actRes = "Email is Sent successfully";
							System.out.println(actRes);
							data.put(""+rc, new Object[]{d[i][0], sheet, d[i][1], d[i][6], actRes, "Pass", t.timestamp(stime)});
							rc++;
							s.WriteInput(path, sheet, d[i][0], counter, actRes, "Pass");
							System.out.println("*********************TestCase 6 finished its execution*************************");
						}
						else
						{
							actRes = "Email is not Sent successfully";
							System.out.println(actRes);
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
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return data;
	}

}
