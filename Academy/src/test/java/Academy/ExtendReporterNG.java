package Academy;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReporterNG 
{
	ExtentReports extent;
	
	public ExtentReports reportConfig()
	{
		String path = System.getProperty("user.dir")+"\\reports\\index.html"; // Setting the path of the report
		ExtentSparkReporter report = new ExtentSparkReporter(path); //Creating object for the ExtentSparkReporter class
		report.config().setReportName("Web Automation Report"); //Using the object created used the method setReportName to give the report a name
		report.config().setDocumentTitle("Test Results"); 
		
		extent = new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("QA", "Dipankar");
		return extent;
	
	}
	
	
	
}
