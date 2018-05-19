package roi.roitest;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import home.test.google.pages.Google;
import home.test.google.pages.IWebApp;
import home.test.google.pages.IWebAppTest;
import home.test.google.pages.ResultPage;
import home.test.google.pages.StartPage;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

@Features("Search ")
public class SearchResultNumberTest implements IWebAppTest {

	private StartPage startPage;
	private Google google = new Google();
	private ResultPage resultPage;

	@BeforeClass
	public void setup() {
		startPage = google.opneStartPage();
	}

	@Stories("As user i want to see 10 search result")
	@Test
	public void testNumberofSearchResult() throws InterruptedException {
		resultPage = startPage.searchFor("Hello World!");
		int actualNumber = resultPage.getSearchResultNumber();
		Assert.assertEquals(actualNumber, 10, "The number of test result is incorrect: ");
	}

	// the same test as before but actualy in one line
	/*
	 * @Test public void testSearchResultNumber() { int actualNumber =
	 * google.opneStartPage().searchFor("Hello world!").getNumberOfresults();
	 * Assert.assertEquals(actualNumber, 10,
	 * "The number of test result is incorrect: "); }
	 */

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		google.close();

	}

	public IWebApp getTestedApp() {
		return this.google;
	}
}
