package utilities;
import org.testng.ITestListener;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportUtility implements ITestListener {
	
	ExtentSparkReporter sparkReporter;
	ExtentReports reports;
	ExtentTest test;
	
	public void configureReport() {
		Date date=new Date();
		SimpleDateFormat formatter=new SimpleDateFormat("ddMMyyyy_hhmmss");
		
		String strDate=formatter.format(date);
		File reportPath=new File(System.getProperty("user.dir")+"//ExtendReport");
		
		if (!reportPath.exists()) {
			reportPath.mkdir();
		}
		
	}

	
	

}
