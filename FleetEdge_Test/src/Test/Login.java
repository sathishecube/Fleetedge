package Test;

import java.util.Map;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentTest;

import FleetEdge_Core.Core;
import FleetEdge_Util.*;

public class Login extends Core
{
	static Util t=new Util();
	@Test
	public static Map<String, Object[]> logintest(Map<String, Object[]> data, int rc, String sheet, ExtentTest test, int scase, int ecase)
	{
		String actRes = null;
		int counter = 1;
		
		String[][] d1 = s.Read(path, sheet);
		
		for(int i=scase-1;i<ecase;i++)
		{
			long stime = System.currentTimeMillis();
			if(d1[i][0].equalsIgnoreCase("TC1"))
			{
				try
				{
					driver = new FirefoxDriver(t.excel());
					driver.get(Object.getProperty("URL"));
					t.dologin(driver, d1[i][2], d1[i][3]);
					Thread.sleep(7000);
					System.out.println("**************************TestCase 1 is executing******************************");
					String msg = t.alertWait();
					if(msg.equalsIgnoreCase("Invalid Username / Password."))
					{
						System.out.println("Login Unsuccessful");
						actRes = "Login Unsuccessful"; 
						data.put(""+rc, new Object[]{d1[i][0], sheet, d1[i][1], d1[i][5], actRes,"Fail",t.timestamp(stime)});
						rc++;
						s.WriteInput(path, sheet, d1[i][0], counter, actRes, "Fail");
						System.out.println("*********************TestCase 1 finished its execution*************************");
					}
					else
					{
						Thread.sleep(5000);
						System.out.println("Login is successful");
						actRes = "Login is Successful";
						data.put(""+rc, new Object[]{d1[i][0], sheet, d1[i][1], d1[i][5], actRes,"Pass",t.timestamp(stime)});
						rc++;
						s.WriteInput(path, sheet, d1[i][0], counter, actRes, "Pass");
						t.logout();
						System.out.println("*********************TestCase 1 finished its execution*************************");
					}
				}
				catch(Exception e){
					e.printStackTrace();
				}
			}
				
			if(d1[i][0].equalsIgnoreCase("TC2"))
			{
				try
				{
					System.out.println("**************************TestCase 2 is executing******************************");
					driver = new FirefoxDriver(t.excel());
					driver.get(Object.getProperty("URL"));
					driver.manage().window().maximize();
					t.dologin(driver, d1[i][2], d1[i][3]);
					String alert = t.alertWait();
					//String currURL = driver.getCurrentUrl();
					if(alert.equalsIgnoreCase("Invalid Username / Password."))
					{
						System.out.println("Invalid username and password");
						actRes = "Invalid username and password";
						data.put(""+rc, new Object[]{d1[i][0], sheet, d1[i][1], d1[i][5], actRes,"Pass",t.timestamp(stime)});
						rc++;
						s.WriteInput(path, sheet, d1[i][0], counter, actRes, "Pass");
						System.out.println("*********************TestCase 2 finished its execution*************************");
					}
					else
					{
						System.out.println("Login is failed to support the correct username and password");
						actRes = "Login is failed to support the correct username and password";
						data.put(""+rc, new Object[]{d1[i][0], sheet, d1[i][1], d1[i][5], actRes,"Fail",t.timestamp(stime)});
						rc++;
						s.WriteInput(path, sheet, d1[i][0], counter, actRes, "Fail");
						System.out.println("*********************TestCase 2 finished its execution*************************");
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		}
		return data;
	}
}
