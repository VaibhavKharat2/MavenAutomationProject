package coverFox4Utility;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import coverFoxBase.Base;

public class Listener extends Base implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {

		Reporter.log(result.getName() + " executation start", true);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Reporter.log(result.getName() + " execution failed", true);

		try {
			Utility.takeScreenShot(driver, result.getName());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


}
