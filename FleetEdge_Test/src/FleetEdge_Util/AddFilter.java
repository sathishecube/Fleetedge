package FleetEdge_Util;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import FleetEdge_Core.Core;
import FleetEdge_Util.Util;
public class AddFilter extends Core
{
	static Util t=new Util();
	public static boolean fill(String Condition,String value,String[][] excelPath,String conditionType)
	{	int r=0;				
		int flag=0;
		boolean b =false;
		String condition =null;
		try
		{	String m = null;
			String Str=excelPath[15][4].toString();
			String[] array=conditionType.split(",");
			String Str1=excelPath[15][3].toString();
			String[] array1=Str1.split(",");
		//	String Str2=d2[15][2].toString();
			String[] value1=value.split(",");
			int ret=0;
			Thread.sleep(5000);
			for(int j=0;j<array.length;j++)
			{
			driver.findElement(By.xpath(Object.getProperty("All"))).click();
			Thread.sleep(3000);
			Select dropdown=new Select(driver.findElement(By.xpath(Object.getProperty("All"))));
			dropdown.selectByVisibleText("Add New Filter");
			Thread.sleep(1000);
			while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
			{
				System.out.println("inside while");
				Thread.sleep(1000);
			}
			Thread.sleep(5000);
			
			if(t.isElementPresentcheck(By.xpath(Object.getProperty("AddTable")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("ADDButton")), driver)
					&& t.isElementPresentcheck(By.xpath(Object.getProperty("SearchButton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("CloseButton")), driver)
					&& t.isElementPresentcheck(By.xpath(Object.getProperty("AddNewFilterValue")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("SaveAsNewFilter")), driver)
					&& t.isElementPresentcheck(By.xpath(Object.getProperty("FilterCondition")), driver)&& t.isElementPresentcheck(By.xpath(Object.getProperty("FilterInput")), driver))
			{
				System.out.println("Pass");
				if(t.isElementPresentcheck(By.xpath(Object.getProperty("AddNewFilterValue")), driver))
					{
						Select dropdown1 = new Select(driver.findElement(By.xpath(".//*[@id='drpColumnList']")));
						List<WebElement> allOptions = dropdown1.getOptions();
						for (WebElement option : allOptions) 
						{	 	  
							if(option.getText().equals(array[j])) 
							{ 
								option.click(); 
								Thread.sleep(5000);
							}
						}		
						
						Select dropdown11 = new Select(driver.findElement(By.xpath(".//*[@id='tblReportColumnFilter']/tbody/tr/td[2]/select")));
						List<WebElement> allOptions1 = dropdown11.getOptions();
							for (WebElement option : allOptions1) 
							{	 	  
								if(option.getText().equals(Condition)) 
								{ 
									option.click(); 
									Thread.sleep(5000);
								}
							}	
						
						Thread.sleep(5000);
						driver.findElement(By.xpath(Object.getProperty("FilterInput"))).sendKeys(value1[j]);
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("SaveAsNewFilter"))).click();
						Thread.sleep(1000);
						driver.findElement(By.xpath(Object.getProperty("FilterName"))).sendKeys(array[j]);
						Thread.sleep(3000);
						driver.findElement(By.xpath(Object.getProperty("NameSubmit"))).click();
						Thread.sleep(500);
						if(t.isAlertPresent(driver))
						{
							driver.switchTo().alert().accept();
						}
						Thread.sleep(2000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(5000);
						String Record=driver.findElement(By.xpath(".//*[@id='MainContainer_lbl_NoRecords']")).getText();
						if(Record.equalsIgnoreCase("No Records Found."))
						{
							System.out.println("No Records Found.");
							System.out.println(array1[j]);
							if(array1[j].equalsIgnoreCase("Equals"))
								{ b=true;
								System.out.println("Equal Condition : " +array[j]);
								return DeleteFilter(array[j],b);
								}
							else if(array1[j].equalsIgnoreCase("Contains"))
								{ b=true;
								return DeleteFilter(array[j],b);
								}
							else if(array1[j].equalsIgnoreCase("Having"))
								{ b=true;
								 return DeleteFilter(array[j],b);
								}
							else if(array1[j].equalsIgnoreCase("Is Empty"))
								{ b=true;
								return DeleteFilter(array[j],b);
								}
							else if(array1[j].equalsIgnoreCase("Is Not Empty"))
								{b=false;
								return DeleteFilter(array[j],b);
								}
						}
						else
						{
							
							System.out.println(value1[j]);
							String d=driver.findElement(By.xpath(".//*[@id='spnFilterTextPlaceHolder']/span/span")).getText();
							System.out.println(d);						
							if(t.isElementPresentcheck(By.xpath(".//*[@id='spnFilterTextPlaceHolder']/span/span"), driver))
								//	if(d.equalsIgnoreCase("Search result for '"+array[j]+" "+eql+" "+value1[j]+"', ... "))
							{
								Thread.sleep(3000);
								WebElement ver=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
								List<WebElement> var=ver.findElements(By.tagName("th"));
								int count=0;
								System.out.println("Array"+array[j]);
								for(WebElement Var : var)
								{
									count++;
									String Headertext=Var.getText();
							//		System.out.println(Headertext);
									if(Headertext.equalsIgnoreCase(array[j]))
									{
										ret=count;
										System.out.println("header"+Headertext);
										System.out.println("Return"+ret);
									}
								}
								System.out.println("get In");
								System.out.println("J : "+ret);
								String text=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']/th["+ret+"]")).getText();
								String Text=text.replaceAll("\\s", "");
								System.out.println(Text);
								m=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportCopy']")).getAttribute("totalrows");
								Integer m1=Integer.parseInt(m);
								System.out.println("Rows"+m);
								Select drop=new Select(driver.findElement(By.xpath(".//*[@id='pageSize']")));
								String Page=drop.getFirstSelectedOption().getText();
								System.out.println("Page : "+Page);
								Page=drop.getFirstSelectedOption().getText();
								List<WebElement> pag=driver.findElements(By.xpath(".//*[@id='goToPageNo']/option"));
								int c=0;
								for(WebElement Pag :pag)
								{
									c++;
								}
								System.out.println(c);
								if((c!=1))
								{
									Thread.sleep(3000);
									Select drop1=new Select(driver.findElement(By.xpath(".//*[@id='goToPageNo']")));
									String i=String.valueOf(c);
									System.out.println("is not");
									drop1.selectByValue(i);
									Thread.sleep(1000);
									while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
									{
										System.out.println("inside while");
										Thread.sleep(1000);
									}
									Thread.sleep(3000);
									List<WebElement> filter=driver.findElements(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr/td["+ret+"]"));
									for(WebElement Filter:filter)
									{
										String Text1=Filter.getText();
										System.out.println(Text1);
										if(Text1.equalsIgnoreCase(value1[j]))
										{	
											flag++;
											System.out.println(flag);
										}	
									}
									String f=String.valueOf(flag-1);
									System.out.println("after minus" +f);
									int c1=c-1;
									condition=c1+f;
								}
								else
								{
									List<WebElement> filter=driver.findElements(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr/td["+ret+"]"));
									for(WebElement Filter:filter)
									{
										String Text1=Filter.getText();
										System.out.println(Text1);
										if(Text1.equalsIgnoreCase(value1[j]))
										{	
											flag++;
											System.out.println(flag);
										}	
									}
									condition =	String.valueOf(flag);
								}
								
								System.out.println("Conditon : "+condition);
								if(m.equals(condition))
								{
									System.out.println("Is true");
									b=true;
									return	DeleteFilter(array[j],b);
																	
								}
								else
								{
									System.out.println("why false");
									b=false;
									return DeleteFilter(array[j],b);									
								}
							}
						}
						Thread.sleep(5000);
				}
			}
			else
			{
				System.out.println("fail");
			}
			}
			Thread.sleep(5000);
			driver.findElement(By.xpath(Object.getProperty("ClearFilter"))).click();
			Thread.sleep(1000);
			while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
			{
				System.out.println("inside while");
				Thread.sleep(1000);
			}
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b;
	}
	
	

	public static boolean chkHighlightupdate(String trValue,String colorList,String newColor,String dashColumn,String columnValue,String colorValue)
	{
		try
		{
		boolean	b=true;
		driver.findElement(By.xpath(Object.getProperty("Highlight"))).click();
		Thread.sleep(3000);
	//	String id=driver.findElement(By.xpath(".//*[@id='108|Row|Make|=|Powerscreen|#008000|']")).getAttribute("id");
	//	System.out.println(id);
		String id1=driver.findElement(By.xpath(".//*[@id='tblHighlightReport']/tbody/tr["+trValue+"]")).getAttribute("id");
		System.out.println("Id : "+id1);
		driver.findElement(By.id(id1)).click();
		WebElement update=driver.findElement(By.xpath(Object.getProperty(colorList)));
		List<WebElement> Update=update.findElements(By.tagName("option"));
		Thread.sleep(2000);
		for(WebElement text:Update)
		{
			String Text=text.getText();
		//	System.out.println("Color : "+Text);
			if(Text.equalsIgnoreCase(newColor))
			{
				Thread.sleep(5000);
				text.click();
			}
		}
		Thread.sleep(2000);
		if(t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightUpdatebutton")), driver) && t.isElementPresentcheck(By.xpath(Object.getProperty("HighlightDeleteButton")), driver))
		{
			driver.findElement(By.xpath(Object.getProperty("HighlightUpdatebutton"))).click();
			Thread.sleep(2000);
			while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
			{
				System.out.println("inside while");
				Thread.sleep(1000);
			}
			Thread.sleep(2000);
			int c1=0;
			WebElement col1=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
			List<WebElement>Col1=col1.findElements(By.tagName("th"));
			for(WebElement text:Col1)
			{
				c1++;
				String Text =text.getText();
				if(Text.equalsIgnoreCase(dashColumn))
				{
					List<WebElement>Row=driver.findElements(By.xpath(".//*[@id='tblFleetStatusReportFreeze']/tbody/tr/td["+c1+"]"));
					int r1=1;
					for(WebElement text1 :Row)
					{
						r1++;
						String Text1=text1.getText();
						if(Text1.equalsIgnoreCase(columnValue))
						{
						//	System.out.println("Column Value : "+Text1+r1);
				//			System.out.println("Value : "+driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportFreeze']/tbody/tr/td["+c1+"]")).getText());
							String Column =driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportFreeze']/tbody/tr["+r1+"]/td["+c1+"]")).getCssValue("background-color");
							System.out.println("Highlight new Updated Color :"+Column);
						//	System.out.println("New Updated Color :"+colorValue);
							if(Column.equalsIgnoreCase(colorValue))
							{
							//	System.out.println("Color verify");
							}
							else
							{
								System.out.println("Column verify Fail");
								return b=false;
							}														
						}
					}
				}
			}
		}
	}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return true;
	}
	
	public static boolean DeleteFilter(String FilterName,boolean b1)
	{
		try	
		{
			Select dropdown2 = new Select(driver.findElement(By.xpath(Object.getProperty("All"))));
			dropdown2.selectByVisibleText("Delete Filter");
			Thread.sleep(5000);
			WebElement del=driver.findElement(By.xpath(".//*[@id='tblFsUserCreatedFilterData']/tbody/tr/td/div"));
			List<WebElement>Del=driver.findElements(By.xpath(".//*[@id='tblFsUserCreatedFilterData']/tbody/tr/td[1]/div"));
			int d=1;
			for(WebElement Delete :Del)
			{
				d++;
				Thread.sleep(2000);
				String delete = Delete.getText();
				System.out.println(delete);
				if(delete.equalsIgnoreCase(FilterName))
				{	
					System.out.println(d);
					driver.findElement(By.xpath(".//*[@id='tblFsUserCreatedFilterData']/tbody/tr["+d+"]/td[2]/div/button")).click();
					Thread.sleep(500);
					if(t.isAlertPresent(driver))
					{
						driver.switchTo().alert().accept();
					}
					Thread.sleep(5000);
					while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
					{
						System.out.println("inside while");
						Thread.sleep(1000);
					}
					Thread.sleep(5000);
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return b1;
	}
	
	public static void pageNavigater()
	{
		try
		{
			Actions action = new Actions(driver);
			WebElement Fleet=driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[1]/table/tbody/tr/td[2]/div/div/ul/li[2]/a"));	
			action.moveToElement(Fleet);
			action.click().perform();
			Thread.sleep(1000);
			driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[1]/table/tbody/tr/td[2]/div/div/ul/li[2]/div/div/ul/li[5]/a")).click();
			Thread.sleep(10000);
			while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
			{
				System.out.println("inside while");
				Thread.sleep(1000);
			}
			Thread.sleep(5000);
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void pageRefresher()
	{
		try
		{
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(8000);
			while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
			{
				System.out.println("inside while");
				Thread.sleep(1000);
			}
			Thread.sleep(3000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static float dashboardValue(String colValue,String row )
	{
		String val =null;
		int j=0;
		float Value = 0;
		float number=0.0f;
		WebElement header=driver.findElement(By.xpath(".//*[@id='tblFleetStatusReportHeaderCopy']"));
		List<WebElement>Header=header.findElements(By.tagName("th"));
		for(WebElement text1 : Header)
		{
			j++;
			String Text1=text1.getText();
			if(Text1.equalsIgnoreCase(colValue))
			{
				 val = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+row+"]/td["+j+"]")).getText();
				 System.out.println("What i really get : "+val);
				 if(val==null)
					{
						Value=number;
						System.out.println("Null Value");
					}
					else if(val.equalsIgnoreCase(""))
					{
						Value=number;
						System.out.println("Empty String");
					}
					else
					{
						Value=Float.parseFloat(val);
						System.out.println("Value : "+val);
					}
				 break;
			}
		}
		return Value;
	}
	public static String dashboardString(String colValue,int r)
	{
		String val =null;
		int j=0;
		WebElement header=driver.findElement(By.xpath("//*[@id='tblFleetStatusReport']"));
		List<WebElement>Header=header.findElements(By.tagName("th"));
		for(WebElement text1 : Header)
		{
			j++;
			String Text1=text1.getText();
			if(Text1.equalsIgnoreCase(colValue))
			{
				 val = driver.findElement(By.xpath(".//*[@id='tblFleetStatusReport']/tbody/tr["+r+"]/td["+j+"]")).getText();
				 break;
			}
		}
		return val;
	}
	
	public static boolean monthlyUtilization(String sDatePath,String dayPath,String daySelect,String timeRecievePath,String sDate,String s1,String dayofRecieve)
	{
		try
		{
			String sdate=driver.findElement(By.xpath(Object.getProperty(sDatePath))).getAttribute("curdate");
	//		System.out.println("Date : "+sdate);
			WebElement dy=driver.findElement(By.xpath(Object.getProperty(dayPath)));
			List<WebElement>dyList=dy.findElements(By.xpath("option"));
			String s=null;
			for(WebElement text1 : dyList)
			{
				if(text1.getText().equalsIgnoreCase(daySelect))
				{
		//			System.out.println("attribute"+text1.getAttribute("selected"));
					s=text1.getAttribute("selected");
				}
			}
			String recieve=driver.findElement(By.xpath(Object.getProperty(timeRecievePath))).getAttribute("value");
	//		System.out.println("Recieve : "+recieve);
//			String labelReport=driver.findElement(By.xpath(Object.getProperty(labelPath))).getText();
	//		System.out.println("Report Label : "+labelReport);
			if(sDate.equalsIgnoreCase(sdate) && s.equalsIgnoreCase(s1) && recieve.equalsIgnoreCase(dayofRecieve) )
			{
				System.out.println("Total Pass");
				return true;
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return false;
	}
	public static void readonlyRemover(String path,String tag)
	{
		try
		{
			WebElement in=driver.findElement(By.xpath(path));
			List<WebElement> inputs = in.findElements(By.tagName(tag));

	for (WebElement input : inputs) {
	    ((JavascriptExecutor) driver).executeScript(
	                "arguments[0].removeAttribute('readonly','readonly')",input);
	}							Thread.sleep(3000);	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void assetDetails(String asset)
	{
		try
		{
			driver.findElement(By.xpath(Object.getProperty("Searialsearch"))).clear();;
			Thread.sleep(2000);
			WebElement ele = driver.findElement(By.xpath(Object.getProperty("Searialsearch")));
			ele.sendKeys(asset);
			Thread.sleep(4000);
			WebElement select = driver.findElement(By.id("ui-id-2"));
			List<WebElement> options = select.findElements(By.className("ui-corner-all"));
			System.out.println(options.size());
			for (WebElement option : options) 
			{	 	  
				System.out.println(option.getText());
				if(option.getText().equals(asset)) 
				{
			           option.click();
				}
			}
			Thread.sleep(5000);
			while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
			{
				System.out.println("inside while");
				Thread.sleep(1000);
			}
			Thread.sleep(3000);
			if(t.isElementPresentcheck(By.xpath(Object.getProperty("FullDetails")), driver)&&t.isElementPresentcheck(By.xpath(Object.getProperty("Directions")), driver))
			{
				System.out.println("Asset Selected.");
			//	WebElement select1 = driver.findElement(By.xpath("//*[@id='OwnersEquipmentID_0']"));
			//	JavascriptExecutor js = (JavascriptExecutor)driver;
			//	js.executeScript("arguments[0].click();", select1);
			//	driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/table/tbody/tr/td/div[2]/div/div[2]/div[6]/table/tbody/tr[2]/td[4]/div/a")).click();
			//	driver.findElement(By.partialLinkText(asset)).click();
			//	driver.findElement(By.xpath("//*[@id='OwnersEquipmentID_0']")).click();
				driver.findElement(By.xpath("/html/body/form/table[1]/tbody/tr/td/div[2]/div[2]/div[2]/table/tbody/tr/td/div[2]/div/div[2]/div[6]/table/tbody/tr[2]/td[2]/div/a")).click();
				Thread.sleep(5000);
				while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
				{
					System.out.println("inside while");
					Thread.sleep(1000);
				}
				Thread.sleep(5000);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void customDate(String sDate,String eDate)
	{
		try
		{
			int j=0;
			WebElement options1 = driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul"));
			List<WebElement> li1 = options1.findElements(By.cssSelector("[id^=lnk]"));
			for(WebElement text : li1)
			{
				j++;
				String Text=text.getAttribute("id");
				if(Text.equalsIgnoreCase("lnkCustom"))
				{
					Actions action1 = new Actions(driver);
					WebElement Fleet1=driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/a"));	
					action1.moveToElement(Fleet1);
					action1.click().perform();
					Thread.sleep(1000);
					driver.findElement(By.xpath(".//*[@id='tms-datemenu-wrapper']/ul/li/div/div/ul/li["+j+"]")).click();						
				}  
			}
			Thread.sleep(3000);
			Thread.sleep(2000);
			driver.findElement(By.xpath(Object.getProperty("CustomStartDate"))).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Object.getProperty("CustomStartDate"))).sendKeys(sDate);
			Thread.sleep(2000);
			driver.findElement(By.xpath(Object.getProperty("CustomEndDate"))).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath(Object.getProperty("CustomEndDate"))).sendKeys(eDate);
			Thread.sleep(2000);
			driver.findElement(By.xpath(".//*[@id='MainContainer_lblStartDate']")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath(Object.getProperty("CustomSearchButton"))).click();
			Thread.sleep(2000);
			while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
			{
			   System.out.println("inside while");
			   Thread.sleep(1000);
			}
			Thread.sleep(5000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public static int readGetNo(String path,String val)
	{
		int c=0;
		try
		{

			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);	
			XSSFSheet sh = wb.getSheetAt(0);
			int rows = sh.getLastRowNum();
			Row r = sh.getRow(0);
			int cell=r.getLastCellNum();
			for(int rowNum = 0 ; rowNum <1 ; rowNum++)
			{ 			
				for(c=1;c<cell;c++)
				{
					String excelString=sh.getRow(rowNum).getCell(c).getStringCellValue();
					if(val.equalsIgnoreCase(excelString))
					{
						break;
					}
				}
			}
		}catch(Exception e)
		{ e.printStackTrace();}
		return c;		
	}
	public static String excelRead(String path,int r,String findVal)
	{
		String val=null;
		try
		{
			int n = readGetNo(path,findVal);
				FileInputStream fis = new FileInputStream(path);
				XSSFWorkbook wb = new XSSFWorkbook(fis);	
				XSSFSheet sh = wb.getSheetAt(0);
				int rows = sh.getLastRowNum();
				for(int rowNum = 1 ; rowNum <= r ; rowNum++)
				{ 			
					for(int j=n;j<=n;j++)
					{
						val=sh.getRow(rowNum).getCell(j).getStringCellValue();
					}	
				}	
		}catch(Exception e)
		{ e.printStackTrace();}
		return val;	
	}
	
	public static int loopIncrement(String path)
	{
		int rows = 0 ;
		try
		{
			FileInputStream fis = new FileInputStream(path);
			XSSFWorkbook wb = new XSSFWorkbook(fis);	
			XSSFSheet sh = wb.getSheetAt(0);
			rows = sh.getLastRowNum();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return rows;
	}

	public static void  deleteChart(String chart)
	{
		try
		{
			driver.findElement(By.xpath(Object.getProperty("ManageChartButton"))).click();
			Thread.sleep(2000);
			WebElement chartTable=driver.findElement(By.xpath(Object.getProperty("CustomChartTable")+"/tbody"));
			List<WebElement> chartTableList = chartTable.findElements(By.tagName("tr"));		
			int n=0;
//			System.out.println("Chart : "+chart);
			for(WebElement count : chartTableList)
			{
//				System.out.println("Count : "+count.getText());
				n++;
				WebElement td=driver.findElement(By.xpath(Object.getProperty("CustomChartTable")+"/tbody/tr["+n+"]"));
				List<WebElement> tdList = td.findElements(By.tagName("td"));
				int m=0;
				for(WebElement text : tdList)
				{
					m++;
//					System.out.println("Text : "+text.getText());
					if(text.getText().equalsIgnoreCase(chart))
					{
//						System.out.println("text  in  : " +text.getText());
						String s=driver.findElement(By.xpath(Object.getProperty("CustomChartTable")+"/tbody/tr["+n+"]/td[1]")).getText();
//						System.out.println("S : "+s);
						driver.findElement(By.xpath(Object.getProperty("CustomChartTable")+"/tbody/tr["+n+"]/td[1]")).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath(Object.getProperty("ChartDeleteButton"))).click();
						Thread.sleep(500);
						if(t.isAlertPresent(driver))
						{
							driver.switchTo().alert().accept();
						}
						Thread.sleep(2000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(5000);
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String chartNameCHk(String chartName)
	{
		String val="Unable to create chart.";
		try
		{
			driver.findElement(By.xpath(Object.getProperty("ManageChartButton"))).click();
			Thread.sleep(5000);
			WebElement tbody=driver.findElement(By.xpath(Object.getProperty("CustomChartTable")+"/tbody"));
			List<WebElement> tbodyList = tbody.findElements(By.tagName("tr"));
//			System.out.println("Table Size : "+tbodyList.size());
			driver.findElement(By.xpath(Object.getProperty("ChartManageCloseButton"))).click();
			Thread.sleep(3000);
			WebElement chart1=driver.findElement(By.xpath(Object.getProperty("ChartCounts")));
			List<WebElement> chartList1=chart1.findElements(By.tagName("tr"));			
//			System.out.println("Chart Count : "+chartList1.size());
			int count=tbodyList.size()-1;			
			count = chartList1.size()-count;
			for(int n=1;n<=count;n++)
			{				
				String col=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td")).getAttribute("colspan");
//				System.out.println("Col attribute : "+col);
				if(col.equalsIgnoreCase("1"))
				{
					String col1 = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[1]/div/div[1]/table/tbody/tr/td[1]/div")).getText();
//					System.out.println("Col1 : "+col1);
					if(chartName.equalsIgnoreCase(col1))
					{
						System.out.println("First Column");
						val=col1;
						break;
					}
					else if(t.isElementPresentcheck(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[2]/div/div[1]/table/tbody/tr/td[1]/div"), driver))						
					{
						String col2 = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[2]/div/div[1]/table/tbody/tr/td[1]/div")).getText();
						System.out.println("Col2 : "+col2);	
						if(col2.equalsIgnoreCase(chartName))
						{
							System.out.println("Second Column");
							val=col2;
							break;
						}
					}
				}
				else
				{
					String name = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td/div/div[1]/table/tbody/tr/td[1]/div")).getText();
//					System.out.println("Name : "+name);
					if(chartName.equalsIgnoreCase(name))
					{
						val=name;
						break;
					}	
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return val;
		
	}
	
	public static int chartTable(String head,String val)
	{
		int m=0;
		try
		{
			WebElement table= driver.findElement(By.xpath(Object.getProperty("CustomChartTable")+"/tbody/tr[1]"));
			List<WebElement> tableList=table.findElements(By.tagName("th"));
			int n=0;
			for(WebElement text : tableList)
			{
				System.out.println("text : "+ text.getText());
				n++;
				if(text.getText().equalsIgnoreCase(head))
				{
					WebElement tbody=driver.findElement(By.xpath(Object.getProperty("CustomChartTable")+"/tbody"));
					List<WebElement> tbodyList = tbody.findElements(By.tagName("tr"));
					for(int l=2;l<=tbodyList.size();l++)
					{
						String s=driver.findElement(By.xpath("//*[@id='tblCustomChartList']/tbody/tr["+l+"]/td["+n+"]")).getText();
//						System.out.println("S : "+s);
						if(val.equalsIgnoreCase(s))
						{
							m++;
						}
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return m;
		
	}
	public static ArrayList<Integer> chartNo(String chartName)
	{
		ArrayList<Integer> al=new ArrayList<Integer>();
		try
		{
			driver.findElement(By.xpath(Object.getProperty("ManageChartButton"))).click();
			Thread.sleep(5000);
			WebElement tbody=driver.findElement(By.xpath(Object.getProperty("CustomChartTable")+"/tbody"));
			List<WebElement> tbodyList = tbody.findElements(By.tagName("tr"));
//			System.out.println("Table Size : "+tbodyList.size());
			driver.findElement(By.xpath(Object.getProperty("ChartManageCloseButton"))).click();
			Thread.sleep(3000);
			WebElement chart1=driver.findElement(By.xpath(Object.getProperty("ChartCounts")));
			List<WebElement> chartList1=chart1.findElements(By.tagName("tr"));			
//			System.out.println("Chart Count : "+chartList1.size());
			int count=tbodyList.size()-1;			
			count = chartList1.size()-count;
			for(int n=1;n<=count;n++)
			{				
				String col=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td")).getAttribute("colspan");
//				System.out.println("Col attribute : "+col);
				if(col.equalsIgnoreCase("1"))
				{
					String col1 = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[1]/div/div[1]/table/tbody/tr/td[1]/div")).getText();
//					System.out.println("Col1 : "+col1);
					if(chartName.equalsIgnoreCase(col1))
					{
						System.out.println("First Column");
						al.add(n);
						al.add(1);
						break;
					}
					else if(t.isElementPresentcheck(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[2]/div/div[1]/table/tbody/tr/td[1]/div"), driver))						
					{
						String col2 = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[2]/div/div[1]/table/tbody/tr/td[1]/div")).getText();
						System.out.println("Col2 : "+col2);	
						if(col2.equalsIgnoreCase(chartName))
						{
							System.out.println("Second Column");
							al.add(n);
							al.add(2);
							break;
						}
					}
				}
				else
				{
					String name = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td/div/div[1]/table/tbody/tr/td[1]/div")).getText();
//					System.out.println("Name : "+name);
					if(chartName.equalsIgnoreCase(name))
					{
						al.add(n);
						al.add(1);
						break;
					}	
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
	
	public static boolean date(String sDate,String eDate,String date,String startDate,String endDate,String middle)
	{
		try
		{
			DateTimeFormatter format = DateTimeFormatter.ofPattern("MM/dd");
		    LocalDateTime now = LocalDateTime.now();
		    LocalDateTime then = now.minusDays(6);
		   if(date.equalsIgnoreCase("Page Date Range"))
		   {
//			   System.out.println("date : "+now.format(format));
//			   System.out.println("date : "+then.format(format));
//			   System.out.println(sDate);
//			   System.out.println(eDate);
//			   System.out.println(startDate.subSequence(0, startDate.lastIndexOf("/")));
//			   System.out.println(endDate.subSequence(0, endDate.lastIndexOf("/")));
			   if(sDate.equals(startDate.subSequence(0, startDate.lastIndexOf("/"))) && eDate.equals(endDate.subSequence(0, endDate.lastIndexOf("/"))))
			   {
				   System.out.println("Date Format Working");
				   return true;
			   }
			   else
			   {
				   System.out.println("Date format not working.");
				   return false;
			   }
		   }
		   else if(date.equalsIgnoreCase("Last 7 days"))
		   {
			   if(then.format(format).equalsIgnoreCase(sDate) && now.format(format).equalsIgnoreCase(eDate))
			   {
				   System.out.println("Last Date Format Working");
				   return true;
			   }
			   else
			   {
				   System.out.println("Last Date format not working.");
				   return false;
			   }
		   }
		   else if(date.equalsIgnoreCase("1 Day / 7 Day / 30 Day"))
		   {
			   if(sDate.equalsIgnoreCase("1 Day") && middle.equalsIgnoreCase("7 Day") && eDate.equalsIgnoreCase("30 Day"))
			   {
				   System.out.println("Day Pass");
				   return true;
			   }
			   else
			   {
				   System.out.println("Day fail");
				   return false;
			   }
		   }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}
	public static void chartClick(String chartType,String date,String t,String chartName)
	{
		try
		{
			sequenceNumber(chartName);
			ArrayList<Integer> m = chartNo(chartName);
			ArrayList<String> al=new ArrayList<String>();
			ArrayList<Integer> s=new ArrayList<Integer>();
			System.out.println("M1 Values" + m.get(0));
			System.out.println("M2 Values" + m.get(0));
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("window.scrollBy(0,350)", "");
			if(chartType.equalsIgnoreCase("Column"))
			{
				if(date.equalsIgnoreCase("1 Day / 7 Day / 30 Day"))
				{
			        String d1Col1="0",d2Col1="0",d3Col1="0";
			        String d1Col2="0",d2Col2="0",d3Col2="0";
					for(int l=1;l<=3;l++)
					{
						for(int n=1;n<=3;n++)
						{
							Actions action = new Actions(driver);
							WebElement column1 = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+m.get(0)+"]/td["+m.get(1)+"]/div/div[2]/div/div/*[local-name() = 'svg']/*[local-name() = 'g'][5]/*[local-name() = 'g']["+l+"]/*[local-name() = 'rect']["+n+"]"));
							action.moveToElement(column1).build().perform();
							action.click();
							WebElement toolTip = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+m.get(0)+"]/td["+m.get(1)+"]/div/div[2]/div/div/*[local-name() = 'svg']/*[local-name() = 'g'][11]/*[local-name() = 'text']"));
					        List<WebElement> toolTipLines = toolTip.findElements(By.tagName("tspan"));
					        System.out.println("l : "+l +","+" n "+n);
					        s.add(toolTipLines.size());
					        System.out.println("Size of Tool Tip"+ toolTipLines.size());
					        if(toolTipLines.size()==0)
					        {
						        	al.add("0");
						        	al.add("0");
					        }
					        else
					        {
					        	for (WebElement toolTipLine : toolTipLines) {
						        	System.out.println("tool Tip : "+toolTipLine.getText());
						        	al.add(toolTipLine.getText());
						        }	
					        }
					        
						}
						l+=1;
					}
					if(!(s.get(0)==0))
					{
			        	d1Col1=al.get(1);
					}
					System.out.println("d1Col1 : "+d1Col1);
					if(!(s.get(1)==0))
					{
				        d2Col1=al.get(3);
					}
					System.out.println("d2Col1 : "+d2Col1);
					if(!(s.get(2)==0))
					{
				        d3Col1=al.get(5);
					}
					System.out.println("d3Col1 : "+d3Col1);
					if(!(s.get(3)==0))
					{
				        d1Col2=al.get(7);
				        if(d3Col1.equalsIgnoreCase(d1Col2))
				        {
				        	d1Col2="0";
				        }
					}
					System.out.println("d1Col2 : "+d1Col2);
					if(!(s.get(4)==0))
					{
				        d2Col2=al.get(9);
				        if(d2Col2.equalsIgnoreCase(d1Col2))
				        {
				        	d2Col2="0";
				        }
					}
					System.out.println("d2Col2 : "+d2Col2);
					if(!(s.get(5)==0))
					{
				        d3Col2=al.get(11);
				        if(d3Col2.equalsIgnoreCase(d2Col2))
				        {
				        	d3Col2="0";
				        }
					}		
					System.out.println("d3Col2 : "+d3Col2);
				}
			}
		}
		catch(Exception e)
		{
			 e.printStackTrace();
		}
	}
	public static void sequenceNumber(String chart)
	{
		try
		{
			driver.findElement(By.xpath(Object.getProperty("ManageChartButton"))).click();
			Thread.sleep(2000);
			WebElement chartTable=driver.findElement(By.xpath(Object.getProperty("CustomChartTable")+"/tbody"));
			List<WebElement> chartTableList = chartTable.findElements(By.tagName("tr"));		
			int n=0;
			for(WebElement count : chartTableList)
			{
				n++;
				WebElement td=driver.findElement(By.xpath(Object.getProperty("CustomChartTable")+"/tbody/tr["+n+"]"));
				List<WebElement> tdList = td.findElements(By.tagName("td"));				
				for(WebElement text : tdList)
				{					
					if(text.getText().equalsIgnoreCase(chart))
					{
						String s=driver.findElement(By.xpath(Object.getProperty("CustomChartTable")+"/tbody/tr["+n+"]/td[1]")).getText();
//						System.out.println("S : "+s);
						driver.findElement(By.xpath(Object.getProperty("CustomChartTable")+"/tbody/tr["+n+"]/td[1]")).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath(Object.getProperty("ChartEditButton"))).click();
						Thread.sleep(2000);
						driver.findElement(By.xpath(Object.getProperty("NoOfInnerChartSequence"))).clear();
						Thread.sleep(2000);
						driver.findElement(By.xpath(Object.getProperty("NoOfInnerChartSequence"))).sendKeys("1");
						Thread.sleep(2000);
						driver.findElement(By.xpath(Object.getProperty("ChartUpdateButton"))).click();
						Thread.sleep(1000);
						while(t.isElementPresentcheck(By.xpath(Object.getProperty("Overlay")), driver))
						{
							System.out.println("inside while");
							Thread.sleep(1000);
						}
						Thread.sleep(5000);
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static String chartDate(String chartName,String date,String startDate,String endDate,String chartType,String row1,String row2)
	{
		String get=null;
		String val = "Chart is not exists";
		String sDate = null,eDate=null,middle=null;
		try
		{
			driver.findElement(By.xpath(Object.getProperty("ManageChartButton"))).click();
			Thread.sleep(5000);
			WebElement tbody=driver.findElement(By.xpath(Object.getProperty("CustomChartTable")+"/tbody"));
			List<WebElement> tbodyList = tbody.findElements(By.tagName("tr"));
//			System.out.println("Table Size : "+tbodyList.size());
			driver.findElement(By.xpath(Object.getProperty("ChartManageCloseButton"))).click();
			Thread.sleep(3000);
			WebElement chart1=driver.findElement(By.xpath(Object.getProperty("ChartCounts")));
			List<WebElement> chartList1=chart1.findElements(By.tagName("tr"));			
//			System.out.println("Chart Count : "+chartList1.size());
			int count=tbodyList.size()-1;			
			count = chartList1.size()-count;
			for(int n=1;n<=count;n++)
			{
				String col=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td")).getAttribute("colspan");
//				System.out.println("Col attribute : "+col);
				if(chartType.equalsIgnoreCase("Column"))
				{
					System.out.println("Column");
					if(col.equalsIgnoreCase("1"))
					{
//						//*[@id="FuelUsage"]/div/*[local-name() = 'svg']/*[local-name() = 'g'][7]/*[local-name() = 'text'][3]
						String col1 = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[1]/div/div[1]/table/tbody/tr/td[1]/div")).getText();
//						System.out.println("Col1 : "+col1);
						if(chartName.equalsIgnoreCase(col1))
						{
							System.out.println("First Column");
							WebElement s=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[1]/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][9]"));
							List<WebElement> list=s.findElements(By.tagName("text"));
							sDate=list.get(0).getText();
							if(date.equalsIgnoreCase("1 Day / 7 Day / 30 Day"))
							{
								middle=list.get(1).getText();
								eDate=list.get(2).getText();
								System.out.println("Middle : "+middle);
							}
							else
							{
								eDate=list.get(6).getText();
							}
							if(t.isElementPresentcheck(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[1]/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][8]//*[local-name() = 'g']//*[local-name() = 'g']"), driver)
									&& t.isElementPresentcheck(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[1]/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][6]"), driver))
							{
								String column1=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[1]/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][8]//*[local-name() = 'g']//*[local-name() = 'g']//*[local-name() = 'g'][1]")).getText();
								String column2=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[1]/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][8]//*[local-name() = 'g']//*[local-name() = 'g']//*[local-name() = 'g'][2]")).getText();
								System.out.println("Column 1 : "+column1);
								System.out.println("Column 2 : "+column2);
								//*[@id='divCustomTabReportPanel']/table/tbody/tr[7]/td/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][6]
								get =String.valueOf(date(sDate,eDate,date,startDate,endDate,middle));
								if(get.equalsIgnoreCase("true") && column1.equalsIgnoreCase(row1) && column2.equalsIgnoreCase(row2))
								{
									val="true";
									System.out.println("Val Pass");
								}
								else
								{
									val="false";
									System.out.println("Val Fail");
								}
							}
							else
							{
								val="false";
								System.out.println("Val Fail");
								System.out.println("Is this now i checking.");
							}
							break;
						}
						else if(t.isElementPresentcheck(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[2]/div/div[1]/table/tbody/tr/td[1]/div"), driver))						
						{
							String col2 = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[2]/div/div[1]/table/tbody/tr/td[1]/div")).getText();
							System.out.println("Col2 : "+col2);	
							if(col2.equalsIgnoreCase(chartName))
							{
								System.out.println("Second Column");
								WebElement s=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[2]/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][9]"));
								List<WebElement> list=s.findElements(By.tagName("text"));
								sDate=list.get(0).getText();
								if(date.equalsIgnoreCase("1 Day / 7 Day / 30 Day"))
								{
									middle=list.get(1).getText();
									eDate=list.get(2).getText();
									System.out.println("Middle : "+middle);
								}
								else
								{
									eDate=list.get(6).getText();
								}
								if(t.isElementPresentcheck(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[2]/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][8]//*[local-name() = 'g']//*[local-name() = 'g']"), driver)
										&& t.isElementPresentcheck(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[2]/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][6]"), driver))
								{
									String column1=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[2]/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][8]//*[local-name() = 'g']//*[local-name() = 'g']//*[local-name() = 'g'][1]")).getText();
									String column2=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[2]/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][8]//*[local-name() = 'g']//*[local-name() = 'g']//*[local-name() = 'g'][2]")).getText();
									System.out.println("Column 1 : "+column1);
									System.out.println("Column 2 : "+column2);
									//*[@id='divCustomTabReportPanel']/table/tbody/tr[7]/td/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][6]
									get =String.valueOf(date(sDate,eDate,date,startDate,endDate,middle));
									if(get.equalsIgnoreCase("true") && column1.equalsIgnoreCase(row1) && column2.equalsIgnoreCase(row2))
									{
										val="true";
										System.out.println("Val Pass");
									}
									else
									{
										val="false";
										System.out.println("Val Fail");
									}
								}
								else
								{
									val="false";
									System.out.println("Val Fail");
									System.out.println("Is this now i checking.");
								}
								break;
							}
						}
					}
					else
					{
						String name = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td/div/div[1]/table/tbody/tr/td[1]/div")).getText();
//						System.out.println("Name : "+name);
						if(chartName.equalsIgnoreCase(name))
						{
							WebElement s=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][9]"));
							List<WebElement> list=s.findElements(By.tagName("text"));
							sDate=list.get(0).getText();
							if(date.equalsIgnoreCase("1 Day / 7 Day / 30 Day"))
							{
								middle=list.get(1).getText();
								eDate=list.get(2).getText();
								System.out.println("Middle : "+middle);
							}
							else
							{
								eDate=list.get(6).getText();
							}
							if(t.isElementPresentcheck(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][8]//*[local-name() = 'g']//*[local-name() = 'g']"), driver)
									&& t.isElementPresentcheck(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][6]"), driver))
							{
								String column1=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][8]//*[local-name() = 'g']//*[local-name() = 'g']//*[local-name() = 'g'][1]")).getText();
								String column2=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][8]//*[local-name() = 'g']//*[local-name() = 'g']//*[local-name() = 'g'][2]")).getText();
								System.out.println("Column 1 : "+column1);
								System.out.println("Column 2 : "+column2);
								//*[@id='divCustomTabReportPanel']/table/tbody/tr[7]/td/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][6]
								get =String.valueOf(date(sDate,eDate,date,startDate,endDate,middle));
								chartClick(chartType,date,"1",chartName);
								System.out.println(" Dashboard Value : "+dashboardValue(row1,"2"));
								if(get.equalsIgnoreCase("true") && column1.equalsIgnoreCase(row1) && column2.equalsIgnoreCase(row2))
								{
									val="true";
									System.out.println("Val Pass");
								}
								else
								{
									val="false";
									System.out.println("Val Fail");
								}
							}
							else
							{
								val="false";
								System.out.println("Val Fail");
								System.out.println("Is this now i checking.");
							}
							break;
						}	
					}
				}
				else if(chartType.equalsIgnoreCase("ColumnLine"))
				{
					System.out.println("Column Line");
					if(col.equalsIgnoreCase("1"))
					{
//						//*[@id="FuelUsage"]/div/*[local-name() = 'svg']/*[local-name() = 'g'][7]/*[local-name() = 'text'][3]
						String col1 = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[1]/div/div[1]/table/tbody/tr/td[1]/div")).getText();
//						System.out.println("Col1 : "+col1);
						if(chartName.equalsIgnoreCase(col1))
						{
							System.out.println("First Column");
							WebElement s=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[1]/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][9]"));
							List<WebElement> list=s.findElements(By.tagName("text"));
							sDate=list.get(0).getText();
							if(date.equalsIgnoreCase("1 Day / 7 Day / 30 Day"))
							{
								middle=list.get(1).getText();
								eDate=list.get(2).getText();
								System.out.println("Middle : "+middle);
							}
							else
							{
								eDate=list.get(6).getText();
							}
							val =String.valueOf(date(sDate,eDate,date,startDate,endDate,middle));
							for(WebElement text : list)
							{
								System.out.println("Text Value : "+text.getText());
							}
							break;
						}
						else if(t.isElementPresentcheck(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[2]/div/div[1]/table/tbody/tr/td[1]/div"), driver))						
						{
							String col2 = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[2]/div/div[1]/table/tbody/tr/td[1]/div")).getText();
							System.out.println("Col2 : "+col2);	
							if(col2.equalsIgnoreCase(chartName))
							{
								System.out.println("Second Column");
								WebElement s=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[2]/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][9]"));
								List<WebElement> list=s.findElements(By.tagName("text"));
								sDate=list.get(0).getText();
								if(date.equalsIgnoreCase("1 Day / 7 Day / 30 Day"))
								{
									middle=list.get(1).getText();
									eDate=list.get(2).getText();
									System.out.println("Middle : "+middle);
								}
								else
								{
									eDate=list.get(6).getText();
								}
								val =String.valueOf(date(sDate,eDate,date,startDate,endDate,middle));
								for(WebElement text : list)
								{
									System.out.println("Text Value : "+text.getText());
								}
								break;
							}
						}
					}
					else
					{
						String name = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td/div/div[1]/table/tbody/tr/td[1]/div")).getText();
//						System.out.println("Name : "+name);
						if(chartName.equalsIgnoreCase(name))
						{
							WebElement s=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][9]"));
							List<WebElement> list=s.findElements(By.tagName("text"));
							sDate=list.get(0).getText();
							if(date.equalsIgnoreCase("1 Day / 7 Day / 30 Day"))
							{
								middle=list.get(1).getText();
								eDate=list.get(2).getText();
								System.out.println("Middle : "+middle);
							}
							else
							{
								eDate=list.get(6).getText();
							}
							val =String.valueOf(date(sDate,eDate,date,startDate,endDate,middle));
							for(WebElement text : list)
							{
								System.out.println("Text Value : "+text.getText());
							}
							break;
						}	
					}
				}
				else if(chartType.equalsIgnoreCase("AverageColumnChart"))
				{
					System.out.println("AverageColumnChart");
					if(col.equalsIgnoreCase("1"))
					{
//						//*[@id="FuelUsage"]/div/*[local-name() = 'svg']/*[local-name() = 'g'][7]/*[local-name() = 'text'][3]
						String col1 = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[1]/div/div[1]/table/tbody/tr/td[1]/div")).getText();
//						System.out.println("Col1 : "+col1);
						if(chartName.equalsIgnoreCase(col1))
						{
							System.out.println("First Column");
							WebElement s=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[1]/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][9]"));
							List<WebElement> list=s.findElements(By.tagName("text"));
							sDate=list.get(0).getText();
							if(date.equalsIgnoreCase("1 Day / 7 Day / 30 Day"))
							{
								middle=list.get(1).getText();
								eDate=list.get(2).getText();
								System.out.println("Middle : "+middle);
							}
							else
							{
								eDate=list.get(6).getText();
							}
							val =String.valueOf(date(sDate,eDate,date,startDate,endDate,middle));
							for(WebElement text : list)
							{
								System.out.println("Text Value : "+text.getText());
							}
							break;
						}
						else if(t.isElementPresentcheck(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[2]/div/div[1]/table/tbody/tr/td[1]/div"), driver))						
						{
							String col2 = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[2]/div/div[1]/table/tbody/tr/td[1]/div")).getText();
							System.out.println("Col2 : "+col2);	
							if(col2.equalsIgnoreCase(chartName))
							{
								System.out.println("Second Column");
								WebElement s=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[2]/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][9]"));
								List<WebElement> list=s.findElements(By.tagName("text"));
								sDate=list.get(0).getText();
								if(date.equalsIgnoreCase("1 Day / 7 Day / 30 Day"))
								{
									middle=list.get(1).getText();
									eDate=list.get(2).getText();
									System.out.println("Middle : "+middle);
								}
								else
								{
									eDate=list.get(6).getText();
								}
								val =String.valueOf(date(sDate,eDate,date,startDate,endDate,middle));
								for(WebElement text : list)
								{
									System.out.println("Text Value : "+text.getText());
								}
								break;
							}
						}
					}
					else
					{
						String name = driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td/div/div[1]/table/tbody/tr/td[1]/div")).getText();
//						System.out.println("Name : "+name);
						if(chartName.equalsIgnoreCase(name))
						{
							WebElement s=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][9]"));
							List<WebElement> list=s.findElements(By.tagName("text"));
							sDate=list.get(0).getText();
							if(date.equalsIgnoreCase("1 Day / 7 Day / 30 Day"))
							{
								middle=list.get(1).getText();
								eDate=list.get(2).getText();
								System.out.println("Middle : "+middle);
							}
							else
							{
								eDate=list.get(6).getText();
							}
							val =String.valueOf(date(sDate,eDate,date,startDate,endDate,middle));
							if(val.equalsIgnoreCase("true") && t.isElementPresentcheck(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][8]"), driver)
									&& t.isElementPresentcheck(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[1]/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][8]//*[local-name() = 'g']//*[local-name() = 'g']//*[local-name() = 'g']"), driver))
							{
								String icon=driver.findElement(By.xpath("//*[@id='divCustomTabReportPanel']/table/tbody/tr["+n+"]/td[1]/div/div[2]/div/div/*[local-name() = 'svg']//*[local-name() = 'g'][8]//*[local-name() = 'g']//*[local-name() = 'g']//*[local-name() = 'g']")).getText();
								System.out.println("Icon : "+icon);
								System.out.println("What will happen really i dont know.");
							}
							break;
						}	
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return val;
	}
}

