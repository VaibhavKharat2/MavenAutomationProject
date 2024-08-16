package coverfoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class Coverfox4AddressDetailsPage {

	@FindBy(className = "mp-input-text")
	private WebElement pinCode;

	@FindBy(id = "want-expert")
	private WebElement mobileNumber;

	@FindBy(xpath = "//div[text()='Continue']")
	private WebElement clickOnContinueButton;

	public Coverfox4AddressDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void EnterAddressDetails(String pinCodeNum, String mobNum) {
	//	Reporter.log("Entering PunCode and MobileNum", true);
		pinCode.sendKeys(pinCodeNum);
		mobileNumber.sendKeys(mobNum);
	}

	public void clickOnContinueButton() {
	//	Reporter.log("Clicking on continue button", true);
		clickOnContinueButton.click();
	}

}
