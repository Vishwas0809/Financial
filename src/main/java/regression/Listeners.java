package regression;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.internal.annotations.IListeners;

public class Listeners implements ITestListener {

	public void OnStart(ITestContext Result) {
		System.out.println();
	}
}


