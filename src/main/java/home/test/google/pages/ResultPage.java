package home.test.google.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class ResultPage {

	private WebDriver driver;

	@FindBy(css = ".g")
	private List<WebElement> resultList;

	public ResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}

	@Attachment("Search Result Number")
	@Step("Calculate the result number")
	public int getSearchResultNumber() {
		WebDriverWait waiter = new WebDriverWait(driver, 10);
		waiter.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".g"), 0));
		waiter.until(ExpectedConditions.visibilityOfAllElements(resultList));
		return resultList.size();
	}
}
