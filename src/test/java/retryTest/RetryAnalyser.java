package retryTest;
import org.testng.ITestResult;
import org.testng.IRetryAnalyzer;

public class RetryAnalyser implements IRetryAnalyzer {
	
	int count=0;
	int retryLimit=4;
	
	public boolean retry(ITestResult result) {
		if(count<retryLimit) {
			count++;
			return true;
		}
		return false;
	}

}
