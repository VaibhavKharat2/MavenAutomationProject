 package coverfoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class CoverFox2HealthPlanPage {

	@FindBy(className = "next-btn")
	private WebElement nextButton;

	public CoverFox2HealthPlanPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickOnNextButton() {
		//Reporter.log("Clicking On NextButton Of HealthPlanPage", true);
		nextButton.click();
	}
}
