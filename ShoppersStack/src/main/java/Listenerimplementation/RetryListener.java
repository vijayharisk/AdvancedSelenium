package Listenerimplementation;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListener implements IRetryAnalyzer{
	int count=0;
	int limit=5;
	
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(count <= limit)
		{
			count = count+1;
			return true;
		}
		else {
		return false;
			}
	}
}
