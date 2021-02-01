package Resourses;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		//ExtentReprts,ExtentSparkReporter
		String path=System.getProperty("user.dir")+"\\reports\\index.html";
		System.out.println(path);
		ExtentSparkReporter reporter= new ExtentSparkReporter(path);
		reporter.config().setReportName("webAutomationResult");
		reporter.config().setDocumentTitle("Test Results");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Kund Nath Jha");
		return extent;
		
	}

}
