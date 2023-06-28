package testBase;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import reusableComponents.PropertiesOperations;

public class ExtentReportNG {
	static ExtentReports extent;
	
	public static ExtentReports setupExtentReport() throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		
		String reportPath = System.getProperty("user.dir")+"/reports/ExecutionReport_"+actualDate+".html";
		
		ExtentSparkReporter sparkPeport = new ExtentSparkReporter(reportPath);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkPeport);
		
		sparkPeport.config().setDocumentTitle("DocumetnTitle");
		sparkPeport.config().setTheme(Theme.DARK);
		sparkPeport.config().setReportName("reportName");
		
		extent.setSystemInfo("Executed on Environment", PropertiesOperations.getPropertyValueByKey("url"));
		extent.setSystemInfo("Executed on Browser", PropertiesOperations.getPropertyValueByKey("browser"));
		extent.setSystemInfo("Executed on OS", System.getProperty("os.name"));
		extent.setSystemInfo("Executed by User", System.getProperty("user.name"));
		
		return extent;
		
	}
	
	

}
