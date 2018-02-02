package retrylistener.net.group;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry  implements IRetryAnalyzer{
	
	private int retryCount=0;
	private int MaxRetryCount=2;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub

		if(retryCount<MaxRetryCount){
			retryCount++;
			return true;
		}
		return false;
	}

	
}
