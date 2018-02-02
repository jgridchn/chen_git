package retrylistener.net.group;


import java.util.Iterator;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class TestListener implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		Iterator<ITestResult> listOfFailedTests=context.getFailedTests().getAllResults().iterator();
		while(listOfFailedTests.hasNext()){
			ITestResult failedTest=listOfFailedTests.next();
			ITestNGMethod method=failedTest.getMethod();
			if(context.getFailedTests().getResults(method).size()>1){
				listOfFailedTests.remove();
			}else{
				if(context.getFailedTests().getResults(method).size()>1){
					listOfFailedTests.remove();
				}
			}
		}
		
	}

}
