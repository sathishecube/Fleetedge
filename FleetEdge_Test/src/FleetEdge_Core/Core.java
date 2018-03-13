package FleetEdge_Core;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import org.apache.log4j.Logger;

import FleetEdge_Util.*;
import Test.*;

public class Core 
{
	public static String filepath = System.getProperty("user.dir")+"\\TestResults\\Input_File.xlsx"; 
	public static String path = System.getProperty("user.dir")+"\\src\\FleetEdge_Properties\\Terex_Input.xlsx";
	public static Properties Object = new Properties();
	public static WebDriver driver = null ;
	public static Read_Write s = new Read_Write();	
	static Map<String, Object[]> data= new TreeMap<String, Object[]>();
	static Map<String, Object[]> data1= new TreeMap<String, Object[]>();
	static int rc = 100;
	public static Logger log = Logger.getLogger("devpinoyLogger"); 
	public static ExtentReports reports =new ExtentReports(System.getProperty("user.dir")+"\\TestResults\\TestResult.html",true);
	public static String[][] input = s.Read(path, "Summary");
	 
	@BeforeSuite
	public void beforeSet() throws IOException
	{
		Util.set();
		data.put(""+rc, new Object[] {"TC No", "Module", "Description", "Expected Result", "Actual Result", "Status", "Time(Sec.)"});
		rc++;
		
	}
	@Test
	public static void login() throws Exception
	
	{
	//	System.out.println(dataInput[0][0]);
		if(input[0][0].equalsIgnoreCase("Login") && input[0][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("Login");
			test.appendChild(test);
			String sd = input[0][2];
			float sd1 = Float.parseFloat(sd);
			int scase = Math.round(sd1);
			System.out.println("Start case:"+ scase);		
			
			String ed = input[0][3];
			float ed1 = Float.parseFloat(ed);
			int ecase = Math.round(ed1);
		
			data1 = Login.logintest(data1, rc, "Login",test ,scase,ecase);
			System.out.println("rc: "+rc);
			rc=rc+data1.size();
			System.out.println("data size :"+data1.size());
			data.putAll(data1);
			reports.endTest(test);
		}
	}
	
	@Test
	public static void FleetStatus() throws Exception
	{
		if(input[1][0].equalsIgnoreCase("FleetStatus") && input[1][1].equalsIgnoreCase("Y"))
		{
		ExtentTest test =reports.startTest("FleetStatus");
		test.appendChild(test);
		
		
		String sd = input[1][2];
		float sd1 = Float.parseFloat(sd);
		int scase = Math.round(sd1);
		System.out.println("Start case:"+ scase);
		
		String ed = input[1][3];
		float ed1 = Float.parseFloat(ed);
		int ecase = Math.round(ed1);
		System.out.println("End case:" +ecase);
		
		data1 = FleetStatus.Fleetstatuscases(data1, rc, "FleetStatus",test,scase,ecase);
		System.out.println("rc"+rc);
		rc=rc+data1.size();
		System.out.println("data size"+data1.size());
		data.putAll(data1);
		reports.endTest(test);
		}			
	}
	
	@Test
	public static void FleetSummary() throws Exception
	{
		if(input[2][0].equalsIgnoreCase("FleetSummary") && input[2][1].equalsIgnoreCase("Y"))
		{
		ExtentTest test =reports.startTest("FleetSummary");
		test.appendChild(test);
		
		
		String sd = input[2][2];
		float sd1 = Float.parseFloat(sd);
		int scase = Math.round(sd1);
		System.out.println("Start case:"+ scase);
		
		String ed = input[2][3];
		float ed1 = Float.parseFloat(ed);
		int ecase = Math.round(ed1);
		System.out.println("End case:" +ecase);
		
		data1 = FleetSummary.FleetSummarycases(data1, rc, "FleetSummary",test,scase,ecase);
		System.out.println("rc"+rc);
		rc=rc+data1.size();
		System.out.println("data size"+data1.size());
		data.putAll(data1);
		reports.endTest(test);
		}			
	}
	
	@Test
	public static void GeoFence() throws Exception
	{
		if(input[3][0].equalsIgnoreCase("GeoFence") && input[3][1].equalsIgnoreCase("Y"))
		{
		ExtentTest test =reports.startTest("GeoFence");
		test.appendChild(test);
		
		
		String sd = input[3][2];
		float sd1 = Float.parseFloat(sd);
		int scase = Math.round(sd1);
		System.out.println("Start case:"+ scase);
		
		String ed = input[3][3];
		float ed1 = Float.parseFloat(ed);
		int ecase = Math.round(ed1);
		System.out.println("End case:" +ecase);
		
		data1 = GeoFence.GeoFencecases(data1, rc, "GeoFence",test,scase,ecase);
		System.out.println("rc"+rc);
		rc=rc+data1.size();
		System.out.println("data size"+data1.size());
		data.putAll(data1);
		reports.endTest(test);
		}			
	}
	
	
	@Test
	public static void TimeFence() throws Exception
	{
		if(input[4][0].equalsIgnoreCase("TimeFence") && input[4][1].equalsIgnoreCase("Y"))
		{
		ExtentTest test =reports.startTest("TimeFence");
		test.appendChild(test);
		
		
		String sd = input[4][2];
		float sd1 = Float.parseFloat(sd);
		int scase = Math.round(sd1);
		System.out.println("Start case:"+ scase);
		
		String ed = input[4][3];
		float ed1 = Float.parseFloat(ed);
		int ecase = Math.round(ed1);
		System.out.println("End case:" +ecase);
		
		data1 = TimeFence.TimeFencecases(data1, rc, "TimeFence",test,scase,ecase);
		System.out.println("rc"+rc);
		rc=rc+data1.size();
		System.out.println("data size"+data1.size());
		data.putAll(data1);
		reports.endTest(test);
		}			
	}
	
	@Test
	public static void EmailReport() throws Exception
	{
		if(input[5][0].equalsIgnoreCase("EmailReport") && input[5][1].equalsIgnoreCase("Y"))
		{
		ExtentTest test =reports.startTest("EmailReport");
		test.appendChild(test);
		
		
		String sd = input[5][2];
		float sd1 = Float.parseFloat(sd);
		int scase = Math.round(sd1);
		System.out.println("Start case:"+ scase);
		
		String ed = input[5][3];  
		float ed1 = Float.parseFloat(ed);
		int ecase = Math.round(ed1);
		System.out.println("End case:" +ecase);
		
		data1 = Email_Report.EmailReportcases(data1, rc, "EmailReport",test,scase,ecase);
		System.out.println("rc"+rc);
		rc=rc+data1.size();
		System.out.println("data size"+data1.size());
		data.putAll(data1);
		reports.endTest(test);
		}			
	}
	
	@Test
	public static void Programs() throws Exception
	{
		if(input[6][0].equalsIgnoreCase("Programs") && input[6][1].equalsIgnoreCase("Y"))
		{
		ExtentTest test =reports.startTest("Programs");
		test.appendChild(test);
		
		
		String sd = input[6][2];
		float sd1 = Float.parseFloat(sd);
		int scase = Math.round(sd1);
		System.out.println("Start case:"+ scase);
		
		String ed = input[6][3];  
		float ed1 = Float.parseFloat(ed);
		int ecase = Math.round(ed1);
		System.out.println("End case:" +ecase);
		
		data1 = Programs.Programscases(data1, rc, "Programs",test,scase,ecase);

		System.out.println("rc"+rc);
		rc=rc+data1.size();
		System.out.println("data size"+data1.size());
		data.putAll(data1);
		reports.endTest(test);
		}			
	}
	
/*	@Test
	public static void EmailReportWizard() throws Exception
	{
		if(input[7][0].equalsIgnoreCase("EmailReportWizard") && input[7][1].equalsIgnoreCase("Y"))
		{
		ExtentTest test =reports.startTest("EmailReportWizard");
		test.appendChild(test);
		
		
		String sd = input[7][2];
		float sd1 = Float.parseFloat(sd);
		int scase = Math.round(sd1);
		System.out.println("Start case:"+ scase);
		
		String ed = input[7][3];  
		float ed1 = Float.parseFloat(ed);
		int ecase = Math.round(ed1);
		System.out.println("End case:" +ecase);
		
		data1 = EmailReportWizard.EmailReportWizardcases(data1, rc, "EmailReportWizard",test,scase,ecase);

		System.out.println("rc"+rc);
		rc=rc+data1.size();
		System.out.println("data size"+data1.size());
		data.putAll(data1);
		reports.endTest(test);
		}			
	}*/
	
	@Test
	public static void EmailReportWizard() throws Exception
	{
		if(input[7][0].equalsIgnoreCase("EmailReportWizard") && input[7][1].equalsIgnoreCase("Y"))
		{
		ExtentTest test =reports.startTest("EmailReportWizard");
		test.appendChild(test);
		
		
		String sd = input[7][2];
		float sd1 = Float.parseFloat(sd);
		int scase = Math.round(sd1);
		System.out.println("Start case:"+ scase);
		
		String ed = input[7][3];  
		float ed1 = Float.parseFloat(ed);
		int ecase = Math.round(ed1);
		System.out.println("End case:" +ecase);
		
		data1 = EmailReport_Wizard.EmailReportWizard1cases(data1, rc, "EmailReportWizard",test,scase,ecase);

		System.out.println("rc"+rc);
		rc=rc+data1.size();
		System.out.println("data size"+data1.size());
		data.putAll(data1);
		reports.endTest(test);
		}			
	}
	
	@Test
	public static void AssetDetails() throws Exception
	{
		if(input[8][0].equalsIgnoreCase("AssetDetails") && input[8][1].equalsIgnoreCase("Y"))
		{
		ExtentTest test =reports.startTest("AssetDetails");
		test.appendChild(test);
		
		
		String sd = input[8][2];
		float sd1 = Float.parseFloat(sd);
		int scase = Math.round(sd1);
		System.out.println("Start case:"+ scase);
		
		String ed = input[8][3];  
		float ed1 = Float.parseFloat(ed);
		int ecase = Math.round(ed1);
		System.out.println("End case:" +ecase);
		
		data1 = AssetDetails.AssetDetailscases(data1, rc, "AssetDetails",test,scase,ecase);

		System.out.println("rc"+rc);
		rc=rc+data1.size();
		System.out.println("data size"+data1.size());
		data.putAll(data1);
		reports.endTest(test);
		}		
		
	}
	
	@Test
	public static void EquipmentTerminalAssociation() throws Exception
	{
		if(input[11][0].equalsIgnoreCase("Equipment Terminal Association") && input[11][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("Equipment Terminal Association");
			test.appendChild(test);
			
			String s = input[11][2];
			float s1 = Float.parseFloat(s);
			int scase = Math.round(s1);
			
			String s2 = input[11][3];
			float s3 = Float.parseFloat(s2);
			int ecase = Math.round(s3);
			
			data1=ETA.ETAtest(data1,rc,"Equipment Terminal Association",test,scase,ecase);
			rc=rc+data1.size();
			data.putAll(data1);			
		}
	}
	
	@Test
	public static void FleetEventReport()
	{
		if(input[2][0].equalsIgnoreCase("Fleet Event Report") && input[2][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("Fleet Event Report");
			test.appendChild(test);
			String s = input[2][2];
			float s1 = Float.parseFloat(s);
			int scase = Math.round(s1);
			
			String s2 = input[2][3];
			float s3 = Float.parseFloat(s2);
			int ecase = Math.round(s3);
			
			data1=FleetEventReport.FleetEventReporttest(data1,rc,"Fleet Event Report",test,scase,ecase);
			rc=rc+data1.size();
			data.putAll(data1);			
		}
	}
	
	
	@Test
	public static void TerminalSummary()
	{
		if(input[3][0].equalsIgnoreCase("Terminal Summary") && input[3][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("Terminal Summary");
			test.appendChild(test);
			
			String s = input[3][2];
			float s1 = Float.parseFloat(s);
			int scase = Math.round(s1);
			
			String s2 = input[3][3];
			float s3 = Float.parseFloat(s2);
			int ecase = Math.round(s3);
			
			data1=TerminalSummary.TerminalSummarytest(data1,rc,"Terminal Summary",test,scase,ecase);
			rc=rc+data1.size();
			data.putAll(data1);			
		}
	}
	
	@Test
	public static void AssociationMaster()
	{
		if(input[4][0].equalsIgnoreCase("AssociationMaster") && input[4][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("AssociationMaster");
			test.appendChild(test);
			
			String s = input[4][2];
			float s1 = Float.parseFloat(s);
			int scase = Math.round(s1);
			
			String s2 = input[4][3];
			float s3 = Float.parseFloat(s2);
			int ecase = Math.round(s3);
			
			data1=AssociationMaster.AssociationMastertest(data1,rc,"AssociationMaster",test,scase,ecase);
			rc=rc+data1.size();
			data.putAll(data1);			
		}
	}
	
	@Test
	public static void CompanyManager()
	{
		if(input[5][0].equalsIgnoreCase("Company Manager") && input[5][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("Company Manager");
			test.appendChild(test);
			
			String s = input[5][2];
			float s1 = Float.parseFloat(s);
			int scase = Math.round(s1);
			
			String s2 = input[5][3];
			float s3 = Float.parseFloat(s2);
			int ecase = Math.round(s3);
			
			data1=CompanyManager.CompanyManagerTest(data1,rc,"Company Manager",test,scase,ecase);
			rc=rc+data1.size();
			data.putAll(data1);
		}
	}
	
	@Test
	public static void AssetDetailTab()
	{
		if(input[6][0].equalsIgnoreCase("AssetDetailTab") && input[6][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("AssetDetailTab");
			test.appendChild(test);
			
			String s = input[6][2];
			float s1 = Float.parseFloat(s);
			int scase = Math.round(s1);
			
			String s2 = input[6][3];
			float s3 = Float.parseFloat(s2);
			int ecase = Math.round(s3);
			
			data1=AssetDetailTab.AssetDetailTabTest(data1,rc,"AssetDetailTab",test,scase,ecase);
			rc=rc+data1.size();
			data.putAll(data1);
		}
	}
	
	@Test
	public static void ManageWidgets()
	{
		if(input[7][0].equalsIgnoreCase("ManageWidgets") && input[7][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("ManageWidgets");
			test.appendChild(test);
			
			String s = input[7][2];
			float s1 = Float.parseFloat(s);
			int scase = Math.round(s1);
			
			String s2 = input[7][3];
			float s3 = Float.parseFloat(s2);
			int ecase = Math.round(s3);
			
			data1=ManageWidgets.ManageWidgetsTest(data1,rc,"ManageWidgets",test,scase,ecase);
			rc=rc+data1.size();
			data.putAll(data1);
		}
	}
	
	@Test
	public static void IssueResolver()
	{
		if(input[8][0].equalsIgnoreCase("IssueResolver") && input[8][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("IssueResolver");
			test.appendChild(test);
			
			String s = input[8][2];
			float s1 = Float.parseFloat(s);
			int scase = Math.round(s1);
			
			String s2 = input[8][3];
			float s3 = Float.parseFloat(s2);
			int ecase = Math.round(s3);
			
			data1=IssueResolver.IssueResolverTest(data1,rc,"IssueResolver",test,scase,ecase);
			rc=rc+data1.size();
			data.putAll(data1);
		}
	}
	
	@Test
	public static void ModelManager()
	{
		if(input[9][0].equalsIgnoreCase("Model Manager") && input[9][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("Model Manager");
			test.appendChild(test);
			
			String s = input[9][2];
			float s1 = Float.parseFloat(s);
			int scase = Math.round(s1);
			
			String s2 = input[9][3];
			float s3 = Float.parseFloat(s2);
			int ecase = Math.round(s3);
			
			data1=ModelManager.ModelManagerTest(data1,rc,"Model Manager",test,scase,ecase);
			rc=rc+data1.size();
			data.putAll(data1);
		}
	}
	
	@Test
	public static void SendMail()
	{
		if(input[10][0].equalsIgnoreCase("Send Mail") && input[10][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("Send Mail");
			test.appendChild(test);
			
			String s = input[10][2];
			float s1 = Float.parseFloat(s);
			int scase = Math.round(s1);
			
			String s2 = input[10][3];
			float s3 = Float.parseFloat(s2);
			int ecase = Math.round(s3);
			
			data1=SendMail.SendMailTest(data1,rc,"Send Mail",test,scase,ecase);
			rc=rc+data1.size();
			data.putAll(data1);
		}
	}
	
	@Test
	public static void SMSorEmailTemplate()
	{
		if(input[11][0].equalsIgnoreCase("SMS or Email Template") && input[11][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("SMS or Email Template");
			test.appendChild(test);
			
			String s = input[11][2];
			float s1 = Float.parseFloat(s);
			int scase = Math.round(s1);
			
			String s2 = input[11][3];
			float s3 = Float.parseFloat(s2);
			int ecase = Math.round(s3);
			
			data1=SMSEMail.EMailTest(data1,rc,"SMS or Email Template",test,scase,ecase);
			rc=rc+data1.size();
			data.putAll(data1);
		}
	}
	
	
	@Test
	public static void SendSMSorSATMessage()
	{
		if(input[13][0].equalsIgnoreCase("Send SMS or SAT Message") && input[13][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("Send SMS or SAT Message");
			test.appendChild(test);
			
			String s = input[13][2];
			float s1 = Float.parseFloat(s);
			int scase = Math.round(s1);
			
			String s2 = input[13][3];
			float s3 = Float.parseFloat(s2);
			int ecase = Math.round(s3);
			
			data1=SendSMSorSATMessage.SendSMSorSATMessageTest(data1,rc,"Send SMS or SAT Message",test,scase,ecase);
			rc=rc+data1.size();
			data.putAll(data1);
		}
	}
	
	/*@Test
	public static void exe15()
	{
		if(input[14][0].equalsIgnoreCase("") && input[14][1].equalsIgnoreCase("Y"))
		{
			ExtentTest test =reports.startTest("");
			test.appendChild(test);
			
			String s = input[14][2];
			float s1 = Float.parseFloat(s);
			int scase = Math.round(s1);
			
			String s2 = input[14][3];
			float s3 = Float.parseFloat(s2);
			int ecase = Math.round(s3);
			
			data1=TerminalTest.TerminalTesting(data1,rc,"",scase,ecase);
			rc=rc+data1.size();
			data.putAll(data1);
		}
	}*/
	
	@AfterSuite
	public static void tearDown() throws Exception
	{
		
	//	excel.writeoutput(data, "Output");
		
		String file=System.getProperty("user.dir")+"\\TestResults\\Output.xlsx";
	//	excel1.Read(file, "TestOutput");
		s.WriteOutput(data, file);
	}
	
}
