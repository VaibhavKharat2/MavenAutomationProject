package coverfoxPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

public class CoverFox3MemberDetailsPage {

	@FindBy(id = "Age-You")
	private WebElement selectAge;

	@FindBy(xpath = "//div[text()='Next']")
	private WebElement nextButton;

	public CoverFox3MemberDetailsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void selectAge(String age) {
		//Reporter.log("Selecting age", true);
		Select s = new Select(selectAge);
		s.selectByValue(age + "y");
	}

	public void clickOnNextButton() {
		//Reporter.log("Clicking on next button", true);
		nextButton.click();
	}
}
