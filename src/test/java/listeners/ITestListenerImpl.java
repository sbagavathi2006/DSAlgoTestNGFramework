package listeners;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class ITestListenerImpl implements ITestListener {//This tells TestNG to attach a custom listener to your test suite execution. Let me break it down:
	private static final Logger logger = LogManager.getLogger(ITestListenerImpl.class);
	
	  	@Override
	    public void onTestStart(ITestResult result) {//this all methods tell us the functionality of each testcase
	  		logger.info("Test Started: " + result.getName());
	    }
	    @Override
	    public void onTestSuccess(ITestResult result) {
	    	logger.info("Test Passed: " + result.getName());
	    }
	    @Override
	    public void onTestFailure(ITestResult result) {
	    	logger.error("Test Failed: " + result.getName(), result.getThrowable());
	    }
	    @Override
	    public void onTestSkipped(ITestResult result) {
	    	logger.warn("Test Skipped: " + result.getName());
	    }
	
	}