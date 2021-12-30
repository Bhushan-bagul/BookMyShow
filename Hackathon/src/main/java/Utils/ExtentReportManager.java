package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReportManager
{
	
	public static ExtentReports report;
	
	
	
	public static ExtentReports getReportInstance()
	{
	
		if(report == null)
		{
			
		
		String reportname = DateUtils.getTimeStamp() + ".html";
		
		String path = System.getProperty("user.dir")+"/test-output/"+reportname;
						
		
		ExtentHtmlReporter Htmlreport = new ExtentHtmlReporter(path);
		
		
		report = new ExtentReports();
		report.attachReporter(Htmlreport);
		
		
		report.setSystemInfo("OS","Windows 11");
		report.setSystemInfo("Browser","Chrome");
		
		
		Htmlreport.config().setDocumentTitle("Test scenario Automation Results");
		Htmlreport.config().setReportName("Test seenario & Test Report");
		Htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);
		Htmlreport.config().setTimeStampFormat("MM dd,yyyy HH:mm:ss");
		
		
		}
		return report;
	}
	
	
}