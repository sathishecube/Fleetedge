package FleetEdge_Util;


public class TestConfig{


	//Mail configuration details
	public static String server= "";//"smtp.gmail.com";
	public static String from = "";//"abirami@startrakwireless.com";
	public static String password = "";//"Startrak123";
	public static String[] to ={};//{"abirami@startrakwireless.com","sathishb@startrakwireless.com"};
	public static String subject = "";//"Test Report";
	public static String messageBody ="";//"PFA for the RT-Web Automation Testresults";
	public static String attachmentPath="";//(System.getProperty("user.dir")+"\\TestResults.zip") ;
	public static String attachmentName="";//"TestOutput.zip";
	
	
	
	
	//SQL DATABASE DETAILS	
	public static String driver="";//"net.sourceforge.jtds.jdbc.Driver"; 
	public static String dbConnectionUrl="";//"jdbc:oracle:thin:@192.168.1.218:1521:ORCL"; 
	public static String dbUserName="";//"GP_SENTRY"; 
	public static String dbPassword="";//"gpindia"; 
	
	
	//MYSQL DATABASE DETAILS
	public static String mysqldriver="";//"com.mysql.jdbc.Driver";
	public static String mysqluserName = "";//"root";
	public static String mysqlpassword = "";//"selenium";
	public static String mysqlurl ="";// "jdbc:mysql://localhost:3306/7thfeb";
	
	
	
	
	
	
	
	
	
}

