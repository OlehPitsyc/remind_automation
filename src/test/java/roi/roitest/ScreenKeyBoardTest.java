package roi.roitest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import home.test.google.pages.Google;
import home.test.google.pages.IWebApp;
import home.test.google.pages.IWebAppTest;
import home.test.google.pages.StartPage;

public class ScreenKeyBoardTest implements IWebAppTest {

	private StartPage startPage;
	private Google google = new Google();
	WebElement keyboard;

	@BeforeClass
	public void setup() {
		startPage = google.opneStartPage();
	}

	@Test(priority = 1)
	public void testKeyboardAppearance() {
		startPage.openScreenKeyboard();
		Assert.assertTrue(startPage.isScreenKeyboardDisplayed(),
				"Screen keyboard should be displayed after click on keyboard icon");

	}

	@Test(priority = 2)
	public void testKeyBoardClose() {
		startPage.closeScreenKeyboard();
		Assert.assertFalse(startPage.isScreenKeyboardDisplayed(),
				"Screen keyboard should be hidedden after click on Close(x) icon");

	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		google.close();

	}

	@Override
	public IWebApp getTestedApp() {
		return this.google;
	}
}
