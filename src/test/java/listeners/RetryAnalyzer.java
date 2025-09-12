package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	int retryCount = 0;
	private static final int maxRetryCount = 1;
	@Override
	public boolean retry(ITestResult result) {
	  if (retryCount < maxRetryCount) {
		   retryCount++;
		   return true;  //retry failed test
	  }
		return false; // do not retry if passed or max retry reached
	}

}
