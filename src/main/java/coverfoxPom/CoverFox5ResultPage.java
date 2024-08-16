package coverfoxPom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CoverFox5ResultPage {

	@FindBy(xpath = "//div[contains(text(),'Insurance Plans')]")
	private WebElement numberOfPlan;

	@FindBy(id = "plans-list")
	private List<WebElement> planListNumber;

	@FindBy(xpath = "//div[@class='title']")
	private WebElement sortPlan;

	public CoverFox5ResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public int getPlansNumberFromText() {
		String ar[] = numberOfPlan.getText().split(" ");
		int result = Integer.parseInt(ar[0]);
		return result;
	}

	public int getListOfPlanNumberFromBanner() {
		int bannerSize = planListNumber.size();
		return bannerSize;
	}

	public boolean checkSortPlanElement() {
		boolean result = sortPlan.isDisplayed();
		return result;
	}

}
