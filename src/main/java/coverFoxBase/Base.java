package coverFoxBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Reporter;

public class Base {

	public static WebDriver driver;
	// make driver static so thats only one copy is created

	public void openBrowser() {

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		driver = new ChromeDriver(opt);
	//	Reporter.log("Lounch browser", true);
		driver.manage().window().maximize();
		driver.get("https://www.coverfox.com/");
		//Reporter.log("Lounch url", true);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
	}

	public void browserClose() {
	//	Reporter.log("Close browser", true);
		driver.close();
	}
}
