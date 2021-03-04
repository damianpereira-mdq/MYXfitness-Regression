package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {

	int noOfRetries = 0;
	int noOfMaxRetries = 3;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		if (noOfRetries < noOfMaxRetries) {

			System.out.println(result.getName() + " Number of retry is " + (noOfRetries + 1));
			noOfRetries++;
			return true;

		}

		return false;
	}

}
