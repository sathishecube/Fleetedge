package FleetEdge_Util;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;	

import FleetEdge_Core.Core;

public class Util extends Core
{
	public static String mailscreenshotpath;

	public static void set() throws  IOException
	{
		if(driver==null)
		{
			FileInputStream in = new FileInputStream(System.getProperty("user.dir")+"\\src\\FleetEdge_Properties\\Object.properties");
			Object.load(in);
			
			if(Object.getProperty("browser").equalsIgnoreCase("chrome"))
				System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			
			else if(Object.getProperty("browser").equalsIgnoreCase("firefox"))
				System.setProperty("webdriver.gecko.driver", "////amxserver//amx-share//STW_QA//Jar files//geckodriver.exe");
			
			else if(Object.getProperty("browser").equalsIgnoreCase("ie"))
				System.setProperty("webdriver.ie.driver", "D:\\internetexplorerdriver.exe");
		}
		
	}
	
	public void logout() 
	{
		try 
		{
			Thread.sleep(3000);
			WebElement welcome = driver.findElement(By.xpath(Object.getProperty("Welcome")));
			WebElement logout = driver.findElement(By.xpath(Object.getProperty("Logout")));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", welcome);
			js.executeScript("arguments[0].click()", logout);
			Thread.sleep(7000);
			driver.close();
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void fleetSelect(WebDriver driver, WebElement menu, WebElement submenu) 
	{
		try
		{
			/*WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(menu));
			Actions fl = new Actions(driver);
			fl.moveToElement(menu).click(menu);
			fl.perform();
			wait.until(ExpectedConditions.elementToBeClickable(submenu));
			Actions eve = new Actions(driver);
			eve.moveToElement(submenu).click(submenu);
			eve.perform();
			Thread.sleep(3000);*/
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", menu);
			js.executeScript("arguments[0].click()", submenu);
			while(isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
				Thread.sleep(1000);
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void clearFilter() 
	{
		try
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath(Object.getProperty("ClearFilter"))).click();
			while(isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
				Thread.sleep(1000);
			Thread.sleep(2000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public String alertWait() 
	{
		String msg="";
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert confirm = driver.switchTo().alert();
			msg = confirm.getText();
			System.out.println("Alert msg: " +msg);
			confirm.accept();
			Thread.sleep(2000);
			while(isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
				Thread.sleep(1000);
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//finally{
		return msg;
	}

	public void overlay(WebDriver driver) 
	{
		try
		{
			while(isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
				Thread.sleep(1000);
			Thread.sleep(3000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void searchModel(String string, String string2, String search) 
	{
		try
		{
			Select type = new Select(driver.findElement(By.xpath(Object.getProperty("SelectionType"))));
			type.selectByValue(string);
			driver.findElement(By.xpath(Object.getProperty("SearchBox"))).clear();
			driver.findElement(By.xpath(Object.getProperty("SearchBox"))).sendKeys(string2);
			driver.findElement(By.xpath(Object.getProperty("SearchBtn"))).click();
			overlay(driver);
			Thread.sleep(1000);
			
			search = driver.findElement(By.xpath(".//*[@id='tblDataList']/tbody/tr/td[1]")).getText();
			System.out.println("Search value: " +search);
			if(search.equalsIgnoreCase(string2))
			{
				driver.findElement(By.xpath(".//*[@id='tblDataList']/tbody/tr/td[1]")).click();
				overlay(driver);
				Thread.sleep(1000);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static int filter(String data,String xpath)
	{
		List<WebElement> element=driver.findElements(By.tagName(xpath));
		int n=0;
		String[] arr=data.split(",");
		for(int i=0;i<arr.length;i++)
		{
			for(int j=0;j<element.size();j++)
			{
				String Text=element.get(j).getText();
				
				if(Text.equalsIgnoreCase(arr[i]))
				{
					j++;
					 n=j;
					 break;
				}
			}
		}
		return n;
		
	}
	public  String filter1(String excel,String xpath)
	{
		List<WebElement> element=driver.findElements(By.xpath(xpath));
		String input=null;
		String[] array=excel.split(",");
		for(int i=0;i<array.length;i++)
		{
			for(int j=0;j<element.size();j++)
			{
				String Text=element.get(j).getText();
				{
					input=array[i];
					System.out.println(input);
				}
			}
		}
		return input;
	}
	public String timestamp(long Stime)
	{
		long Etime = System.currentTimeMillis();
		long Ttime = Etime - Stime;
		long Exetime =Ttime /1000 ;
		return Long.toString(Exetime);
	}
	

	/*Generating timestamp */
	public static String generateTimeStamp()
	{
		Calendar cal = new GregorianCalendar();
		  int month = cal.get(Calendar.MONTH); //3
		  int year = cal.get(Calendar.YEAR); //2014
		  int sec =cal.get(Calendar.SECOND);
		  int min =cal.get(Calendar.MINUTE);
		  int date = cal.get(Calendar.DATE);
		  int day =cal.get(Calendar.HOUR_OF_DAY);
		  String timestamp = year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec;
		  return timestamp;
	}

	/* This method is used to compare expected with Actual */
	public boolean testStatus(String eopt, String aopt)
	{
		System.out.println(eopt+":"+aopt);
		if(eopt.equalsIgnoreCase(aopt))
		{
			return true;
		}
		else
			return false;
	}
	
	//Checking whether the element is present or not		
	public boolean isElementPresentcheck(By by, WebDriver driver)
	{
		try
		{
			System.out.println("searching for "+driver.findElement(by).getAttribute("id"));
			if(driver.findElement(by).isDisplayed())
			{
				System.out.println(driver.findElement(by).getAttribute("id")+" is present...");
				return true;
			}
			else
			{
				System.out.println(driver.findElement(by).getAttribute("id")+" is not present...");
				return false;
			}
		}
		catch (Exception e)
		{
			System.out.println("Element is not present...");
			return false;
		}
	}
	
	 /* This method finds and returns if there is an alert present. */
	 public boolean isAlertPresent(WebDriver driver)
		{ 
		 try 
		    { 
				driver.switchTo().alert(); 
		        return true; 
		    }  
		    catch (NoAlertPresentException Ex) 
		    { 
		    	Ex.printStackTrace();
		        return false; 
		    }   
		} 
//	 Alert Text
	 public String alertText()
	 {
		 Alert alert=driver.switchTo().alert();
		 return alert.getText();
	 }
	
	// Reading the data from excel sheet
	/*public static String[][] getData(String sheetName)
	{
		int rows = excel.getRowCount(sheetName);
		int cols= excel.getColumnCount(sheetName);
		
		String[][] data = new String[rows-1][cols];
		
		for(int rowNum = 2 ; rowNum <= rows ; rowNum++)
		{ 		
			
			for(int colNum=0 ; colNum< cols; colNum++)
			{
				data[rowNum-2][colNum]=excel.getCellData(sheetName, colNum, rowNum); 
			}
		}
		
		return data;
		
	}*/
	
	//Converting the folder /file into zip format
	
	/* Element checking function */
	public boolean isElementPresent(By by, WebDriver driver)
	{
		try
		{
			driver.findElement(by).click();
			System.out.println("Element found...");
			return true;
		}
		catch (Exception e)
		{
			System.out.println("Element not found...");
			return false;
		}
	}
	public String cutString(String s1,String s2)
	{
		try
		{
			int pt1=0;
					String cut1="Null";
					if(s1.isEmpty())
						System.out.println("Empty String..");
					if(s1.contains(s2))
					{
						pt1=s1.indexOf(s2);
						cut1 = s1.substring(0, pt1);
					}
					if(!s1.equalsIgnoreCase(cut1))
					{
						s1=cut1;
						System.out.println(cut1.length());
						System.out.println(cut1);
						System.out.println(s1);
					}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			return s1;
		}
	}
	public String dateConvert(String sdate)
	{
		String out = null;
		int sdateNew=0;
		if(sdate.length()>=6)
		{
			 sdateNew = Integer.parseInt(sdate.substring(6));
		}
		try
		{
			
			if(sdate.length()>5 && sdate.startsWith("Today"))
			{
				if(sdate.charAt(5)=='+')
				{
					sdate=sdate.substring(6);
					System.out.println(sdate);
					Calendar c = Calendar.getInstance();
			        c.add(Calendar.DATE, sdateNew);
			        Date date = c.getTime();
			        System.out.println(date);
			        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yy");
			        String todayDate = sdf1.format(date);
					//System.out.println("Today date : "+todayDate);
					out =todayDate;
				}
				else if(sdate.charAt(5)=='-')
				{
					sdate=sdate.substring(6);
					System.out.println(sdate);
					Calendar c = Calendar.getInstance();
			        c.add(Calendar.DATE, -sdateNew);
			        Date date = c.getTime();
			        System.out.println(date);
			        SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yy");
			        String todayDate = sdf1.format(date);
					//System.out.println("Today date : "+todayDate);
					out =todayDate;
				}
				else
				{
					System.out.println(sdate+" is invalid...");
					out ="NA";
				}
			}
			else if(sdate.equalsIgnoreCase("Today"))
			{
				System.out.println(sdate+" is today...");
				Calendar c = Calendar.getInstance();
				Date date = c.getTime();
				System.out.println(date);
				
				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MMM-yy");
		        String todayDate = sdf1.format(date);
				//System.out.println("Today date : "+todayDate);
				out =todayDate;
			}
			else
			{
				System.out.println("Invalid start date...");
				out="NA";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			System.out.println(out);
			return out;
		}
	}
	public int dateCompare(String startDateString, String endDateString, String DateString)
	{
		int ret=0;
		try
		{
			DateFormat df = new SimpleDateFormat("dd-MMM-yy"); 
		    Date startDate = null,endDate = null,date = null;
		    startDate = df.parse(startDateString);
		    System.out.println(startDate); 
		    endDate = df.parse(endDateString);
		    System.out.println(endDate); 
		    date = df.parse(DateString);
		    System.out.println(date); 
		    
		    if(date.compareTo(startDate)>=0 && date.compareTo(endDate)<=0)
		  	{
				System.out.println("Date is within range");
				ret = 1;
			}
			else
			{
				System.out.println("Date is out of range");
				ret = 0;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			return ret;
		}

	}
	public boolean unitofMeasure(WebDriver driver, Properties obj, String mainMenu,String page,String button, String toolTip, String toolTipval, String settingsUnit)
	{
		boolean status = false;
		try
		{
			driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
				driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
				driver.findElement(By.xpath(obj.getProperty("Displaysettings"))).click();
				String Units = driver.findElement(By.xpath(settingsUnit)).getText();
				driver.findElement(By.xpath(mainMenu)).click();
				while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				System.out.println("inside while");
				Thread.sleep(1000);
			}
				driver.findElement(By.xpath(page)).click();
				while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
				{
					System.out.println("inside while");
					Thread.sleep(1000);
				}
				driver.findElement(By.xpath(button)).click();
				String unitsTooltip="Null";
				Thread.sleep(1000);
				
				if(driver.findElement(By.xpath(toolTip)).isDisplayed()){
					unitsTooltip = driver.findElement(By.xpath(toolTipval)).getAttribute("textContent");
				}
				else
				{	System.out.println("Not displayed...");
				System.out.println(Units+":"+unitsTooltip);
				}
				if(unitsTooltip.contains("Fahrenheit") || unitsTooltip.contains("Celsius"))
				{
					String[] arrSplit = unitsTooltip.split(" ");
					unitsTooltip = arrSplit[0];
					System.out.println("Inside If Loop"+unitsTooltip);
				}
				else
				{
					System.out.println(unitsTooltip);
				}
				if(Units.equalsIgnoreCase(unitsTooltip))
				{
					status = true;
				}
				else
				{
					status = false;
				}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			return status;
		}
	}
	
	public void clearDateRange(WebDriver driver,Properties obj)
	{
	try
	{
	driver.findElement(By.xpath(obj.getProperty("EditDateRange"))).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath(obj.getProperty("ClearDaterange"))).click();
	}
	catch(Exception ex)
	{
	ex.printStackTrace();
	}
	
	
	}
	
	////////////////////Clear Filter ///////////////////
	public void clearFilter(WebDriver driver,Properties obj,String clearFilter)
	{	
		try
		{

			Thread.sleep(2000);
			driver.findElement(By.xpath(obj.getProperty(clearFilter))).click();
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			if(isAlertPresent(driver))
			{
				Alert alert;
				alert = driver.switchTo().alert();	
				String chk1 = driver.switchTo().alert().getText();
				System.out.println(alert.getText());
				alert.accept();
			}
			while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				Thread.sleep(1000);
			}
			Thread.sleep(1000);
			/*while(isAlertPresent(driver))
			{
				Alert alert;
				alert = driver.switchTo().alert();	
				alert.accept();
			}
			while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				Thread.sleep(1000);
			}
			Thread.sleep(1000);*/

		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	/////////////////////////////////////////////////////
	
	public boolean dateSort(String[] dateArray)
	{
		boolean status=false;
		String [] returnString = new String[dateArray.length];
		String [] returnString1 = new String[dateArray.length];
		try
		{
			String [][] arr = new String[dateArray.length][];
			
			
			for(int i=0;i<dateArray.length;i++)
				{

				if(dateArray[i].length()==10)
					arr[i]=dateArray[i].split("-");
				else
				{
					String [] array ={"-","-","-"};
					arr[i]=array;
				}
				}

			for(int i=0;i<arr.length;i++)
			{
				returnString[i]=arr[i][2]+arr[i][0]+arr[i][1];
				returnString1[i]=arr[i][2]+arr[i][0]+arr[i][1];
				System.out.println(returnString[i]);
			}
			
			Arrays.sort(returnString);

			for(int i=0;i<returnString1.length;i++)
				System.out.println(returnString[i]+"::"+returnString1[i]);
			status = Arrays.equals(returnString, returnString1);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			return status;
		}
	}
	
	public static String downloadPath = "\\\\amxserver\\amx-share\\STW_QA\\Rtweb Automation\\Downloaded Excel";
	public   FirefoxProfile excelDownload()  throws Exception {
	{
		/*ChromeOptions profile = new ChromeOptions();
		try{
			
				profile..CAPABILITY.
			
		        profile.setPreference("browser.download.folderList", 2);
		        profile.setPreference("browser.download.manager.showWhenStarting", false);
		        profile.setPreference("browser.download.dir", downloadPath);
		        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/vnd.ms-excel");
		        profile.setExperimentalOption(name, value);

		        
		        
		        HashMap<String, Object> chromePrefs = new HashMap<String, Object>(); 
		        chromePrefs.put("profile.default_content_settings.popups", 0); 
		        chromePrefs.put("download.default_directory", downloadPath); 
		        chromePrefs.put("browser.helperApps.neverAsk.saveToDisk","application/vnd.ms-excel");
		        
		        ChromeOptions options = new ChromeOptions(); 
		        HashMap<String, Object> chromeOptionsMap = new HashMap<String, Object>(); 
		        profile.setExperimentalOption("prefs", chromePrefs); 
		        options.addArguments("--test-type"); 
		        DesiredCapabilities cap = DesiredCapabilities.chrome(); 
		        cap.setCapability(ChromeOptions.CAPABILITY, chromeOptionsMap); 
		        cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); 
		        cap.setCapability(ChromeOptions.CAPABILITY, profile); */
		FirefoxProfile profile = new FirefoxProfile();
		try{
		
		        profile.setPreference("browser.download.folderList", 2);
		        profile.setPreference("browser.download.manager.showWhenStarting", false);
		        profile.setPreference("browser.download.dir", downloadPath);
		        profile.setPreference("browser.helperApps.neverAsk.saveToDisk","application/vnd.ms-excel");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}		
		finally
		{
			return profile;
		}
	}
	}
	public boolean unitofMeasure1(WebDriver driver, Properties obj, String mainMenu, String page, String reportCode, String HistoryReport, String button, String toolTip, String toolTipval, String settingsUnit)
	{
		
		boolean status = false;
		try
		{
			driver.findElement(By.xpath(obj.getProperty("ReeferTrak"))).click();
				driver.findElement(By.xpath(obj.getProperty("Settings"))).click();
				driver.findElement(By.xpath(obj.getProperty("Displaysettings"))).click();
				String Units = driver.findElement(By.xpath(settingsUnit)).getText();
				driver.findElement(By.xpath(mainMenu)).click();
				while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				System.out.println("inside while");
				Thread.sleep(1000);
			}
				driver.findElement(By.xpath(page)).click();
				while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
				{
					System.out.println("inside while");
					Thread.sleep(1000);
				}
				//driver.findElement(By.xpath(obj.getProperty("ReeferSearch"))).sendKeys(Asset);
				driver.findElement(By.xpath(obj.getProperty("SearchButton"))).click();
  			while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
  			{
					System.out.println("inside while");
  				Thread.sleep(1000);
  			}
  			if(isElementPresentcheck(By.xpath(".//*[@id='div-"+reportCode+"-datagrid-tbody']/tr/td[2]/a"), driver))
				{
  				driver.findElement(By.xpath(".//*[@id='div-"+reportCode+"-datagrid-tbody']/tr/td[2]/a")).click();	
				}
  			else if(isElementPresentcheck(By.xpath(".//*[@id='div-"+reportCode+"-datagrid-tbody']/tr/td[1]/a"), driver))
			{
				driver.findElement(By.xpath(".//*[@id='div-"+reportCode+"-datagrid-tbody']/tr/td[1]/a")).click();	
			} 
  			while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				System.out.println("inside while loop");
				Thread.sleep(1000);
			} 
  			Thread.sleep(4000);
			driver.findElement(By.xpath(HistoryReport)).click();
			while(isElementPresentcheck(By.xpath(".//*[@id='DivOverlayChild']"), driver))
			{
				System.out.println("inside while");
				Thread.sleep(1000);
			}
				driver.findElement(By.xpath(button)).click();
				String unitsTooltip="Null";
				Thread.sleep(1000);
				
				if(driver.findElement(By.xpath(toolTip)).isDisplayed()){
					unitsTooltip = driver.findElement(By.xpath(toolTipval)).getAttribute("textContent");
				}
				else
				{	System.out.println("Not displayed...");
				System.out.println(Units+":"+unitsTooltip);
				}
				if(unitsTooltip.contains("Fahrenheit") || unitsTooltip.contains("Celsius"))
				{
					String[] arrSplit = unitsTooltip.split(" ");
					unitsTooltip = arrSplit[0];
					System.out.println("Inside If Loop"+unitsTooltip);
				}
				else
				{
					System.out.println(unitsTooltip);
				}
				if(Units.equalsIgnoreCase(unitsTooltip))
				{
					status = true;
				}
				else
				{
					status = false;
				}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			return status;
		}
	}
	public static boolean isElementEnabledcheck(By by, WebDriver driver)
	{

		try
		{
			System.out.println("searching for "+driver.findElement(by).getAttribute("id"));
			if(driver.findElement(by).isEnabled())
			{
				System.out.println(driver.findElement(by).getAttribute("id")+" is present...");
				return true;
			}
			else
			{
				System.out.println(driver.findElement(by).getAttribute("id")+" is not present...");
				return false;
			}
		}
		catch (Exception e)
		{
			System.out.println("Element is not present...");
			return false;
		}
	}
	public boolean dologin(WebDriver driver,String uname, String Pwd) throws Exception
	{
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(Object.getProperty("Username"))).clear();
		System.out.println("Entering username");
		driver.findElement(By.xpath(Object.getProperty("Username"))).sendKeys(uname);
		driver.findElement(By.xpath(Object.getProperty("Password"))).clear();
		System.out.println("Entering Password");
		driver.findElement(By.xpath(Object.getProperty("Password"))).sendKeys(Pwd);
		
		System.out.println("Clicking on the login button");
		WebElement w = driver.findElement(By.xpath(Object.getProperty("LoginButton")));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "");
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ESCAPE);
		r.delay(200);
		r.keyRelease(KeyEvent.VK_ESCAPE);
		w.click();
		Thread.sleep(25000);
		return true;
	}
	public static String CaptureScreenshot() throws IOException
	{
		  Calendar cal = new GregorianCalendar();
		  int month = cal.get(Calendar.MONTH); 
		  int year = cal.get(Calendar.YEAR); 
		  int sec =cal.get(Calendar.SECOND);
		  int min =cal.get(Calendar.MINUTE);
		  int date = cal.get(Calendar.DATE);
		  int day =cal.get(Calendar.HOUR_OF_DAY);
		  mailscreenshotpath = System.getProperty("user.dir")+"\\Screenshot\\"+year+"_"+date+"_"+(month+1)+"_"+day+"_"+min+"_" +sec+".jpeg";
		  File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  FileUtils.copyFile(scrFile, new File(mailscreenshotpath));
		  return mailscreenshotpath;
	}
	
	public String date(String str) 
	{
		String val = null;
		int ind=0;
		//start date
		if(str.length()>=6)
		{
			ind=Integer.parseInt(str.substring(6));
			//System.out.println("ind val " +ind);
		}
		try
		{
			if(str.length()>5 && str.startsWith("Today"))
			{
				if(str.charAt(5)=='+')
				{
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DATE, ind);
					Date date = cal.getTime();
					System.out.println("Date: " +date);
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
					System.out.println("Expect date: " +sdf.format(date));
					val = sdf.format(date);
				}
				else if(str.charAt(5)=='-')
				{
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DATE, -ind);
					Date date = cal.getTime();
					System.out.println("Date: " +date);
					SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
					System.out.println("Expect date: " +sdf.format(date));
					val = sdf.format(date);
				}
				else
					System.out.println("invalid date");
			}
			else if(str.equalsIgnoreCase("Today"))
			{
				Calendar cal = Calendar.getInstance();
				Date date = cal.getTime();
				System.out.println("Date: " +date);
				SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				System.out.println("expect date: " +sdf.format(date));
				val = sdf.format(date);
			}
			else
			{
				System.out.println("Invalid date");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	return val;
	}
	
	public static String downloadPath1 ="D:\\workspace\\FleetEdge\\DownloadExcel";
	public FirefoxOptions excel()
	{
	//	isFileDownloaded(downloadPath1);
	 	FirefoxOptions options = new FirefoxOptions();
	     options.addPreference("browser.download.folderList", 2);
	     options.addPreference("browser.download.manager.showWhenStarting",false);	   
	     options.addPreference("browser.download.dir", downloadPath1);
	     //options.addPreference("browser.helperApps.neverAsk.saveToDisk","");   
	     options.addPreference("browser.helperApps.neverAsk.saveToDisk","application/vnd.ms-excel, text/csv");	
	     options.addPreference("browser.helperApps.neverAsk.saveToDisk","application/xlsx, text/csv");
	     return options;

	}
	public static String lastWeekDate()
	{			
		String date=null;
		try
		{
		    Calendar c = Calendar.getInstance();
		    int i = c.get(Calendar.DAY_OF_WEEK) - c.getFirstDayOfWeek();
		    c.add(Calendar.DATE, -i - 7);
		    Date start = c.getTime();
		    c.add(Calendar.DATE, 6);
		    Date end = c.getTime();
		    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
		   // System.out.println(start + " - " + end);
		   System.out.println(sdf.format(start) + " - " + sdf.format(end));
		   date = sdf.format(start) + " - " + sdf.format(end);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return date;
	
	}
	public static String lastMonthDate()
	{
		String date =null;
		try
		{
			Calendar c = Calendar.getInstance();
		    SimpleDateFormat sdf = new SimpleDateFormat("MM/dd"); 
		    int i = c.get(Calendar.DAY_OF_YEAR);
			c.add(Calendar.DATE, -i -29);    
			Date start = c.getTime();
			c.add(Calendar.DATE, +29);
			Date end = c.getTime();
			System.out.println(sdf.format(start) + " - " + sdf.format(end));
			date = sdf.format(start) + " - " + sdf.format(end);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return date;
	}
	
	public void company(WebDriver driver, String strMatch, String companyName) 
	{
		try
		{
			driver.findElement(By.xpath(".//*[@id='txtCompanyAutoComplete']")).clear();
			Thread.sleep(3000);	
			WebElement cmpnyEle = driver.findElement(By.xpath(".//*[@id='txtCompanyAutoComplete']"));
			cmpnyEle.sendKeys(strMatch);
			Thread.sleep(4000);
			WebElement select = driver.findElement(By.id("ui-id-1"));
			List<WebElement> opti = select.findElements(By.className("divBold"));
			System.out.println(opti.size());
			for (WebElement option : opti) 
			{
				System.out.println("inside for");
				System.out.println(option.getText());
				if(option.getText().equals(companyName))            
					option.click();   
			}
			while(isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
				Thread.sleep(1000);
			Thread.sleep(3000);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
