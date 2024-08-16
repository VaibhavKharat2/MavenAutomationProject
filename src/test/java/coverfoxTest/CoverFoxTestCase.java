package coverfoxTest;

import java.io.IOException;
import java.time.Duration;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import coverFox4Utility.Utility;
import coverFoxBase.Base;
import coverfoxPom.CoverFox1HomePage;
import coverfoxPom.CoverFox2HealthPlanPage;
import coverfoxPom.CoverFox3MemberDetailsPage;
import coverfoxPom.CoverFox5ResultPage;
import coverfoxPom.Coverfox4AddressDetailsPage;

public class CoverFoxTestCase extends Base {

	CoverFox1HomePage homePage;
	CoverFox2HealthPlanPage healthPlanPage;
	CoverFox3MemberDetailsPage memberDetailsPage;
	Coverfox4AddressDetailsPage addressDetailsPage;
	CoverFox5ResultPage resultPage;
	
	public static Logger logger;

	@BeforeTest
	public void lounchBrowser() {
		
		logger=logger.getLogger("CoverFoxTest");
		PropertyConfigurator.configure("Log4j.properties");
		
		openBrowser();
		logger.info("Opening Browser");
		homePage = new CoverFox1HomePage(driver);
		healthPlanPage = new CoverFox2HealthPlanPage(driver);
		memberDetailsPage = new CoverFox3MemberDetailsPage(driver);
		addressDetailsPage = new Coverfox4AddressDetailsPage(driver);
		resultPage = new CoverFox5ResultPage(driver);

	}

	@BeforeClass
	public void preConditions() throws EncryptedDocumentException, IOException, InterruptedException {
		
		homePage.clickOnGenderButton();
		logger.info("Clicking On the next Button");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

		healthPlanPage.clickOnNextButton();
		logger.info("Clicking On the next Button");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3500));

		logger.warn("Enter age between 18 to 90");
		memberDetailsPage.selectAge(Utility.getDataFromExcell(0, 0, "Sheet4"));
		logger.info("Selecting the age from dropdown");
		// memberDetailsPage.selectAge(Utility.getDataFromPropertyFile("age"));
		Thread.sleep(2000);
		
		memberDetailsPage.clickOnNextButton();
		logger.info("Clicking On the next Button");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));

		logger.warn("Enter valid PinCode & MobNumber");
		addressDetailsPage.EnterAddressDetails(Utility.getDataFromExcell(0, 1, "Sheet4"),
				Utility.getDataFromExcell(0, 2, "Sheet4"));
		logger.info("Entering PinCode & MobNumber");
		// addressDetailsPage.EnterAddressDetails(Utility.getDataFromPropertyFile("pinCode"),
		// Utility.getDataFromPropertyFile("mobNo"));

		addressDetailsPage.clickOnContinueButton();
		logger.info("Clicking On the continue Button");
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
	}

	@Test
	public void validateBanners() throws IOException {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(7000));

		int planNumFromBanner = resultPage.getListOfPlanNumberFromBanner();
		int planNumFromText = resultPage.getPlansNumberFromText();
		//Assert.fail();
		Assert.assertEquals(planNumFromText, planNumFromBanner, "plan and list of banners total not matching");
		logger.info("Validating Banners");
	}

	@Test
	public void validateTestPlanElement() {
		//Assert.fail();
		Assert.assertTrue(resultPage.checkSortPlanElement(), "element is not present, test case failed");
		logger.info("Validating testPlan element");
	}

	@AfterClass
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		browserClose();
		logger.info("Closing the browser");

	}
}
