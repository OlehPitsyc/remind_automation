package home.test.google.pages;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import home.test.google.page.Browser;
import ru.yandex.qatools.allure.annotations.Step;

public class Google implements IWebApp {
	private WebDriver driver;
	private static final String baseUrl = "https://www.google.com/";

	@Step("Open google start page: " + baseUrl)
	public StartPage opneStartPage() {
		driver = Browser.getDriver();
		driver.get(baseUrl);
		return new StartPage(driver);
	}

	public void close() {
		if (this.driver != null)
			this.driver.quit();
		this.driver = null;
	}

	public File makeScreenshot() {
		return TakesScreenshot.class.cast(this.driver).getScreenshotAs(OutputType.FILE);
		/*
		 * File screenPng = new File("assets/screenshot" + LocalDateTime.now().getHour()
		 * + ".png"); try { FileUtils.copyFile(screen, screenPng); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); } return
		 * screenPng;
		 */
	}

}
