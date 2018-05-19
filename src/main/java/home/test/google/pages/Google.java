package home.test.google.pages;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import ru.yandex.qatools.allure.annotations.Step;

public class Google implements IWebApp {
	private WebDriver driver;
	private static final String baseUrl = "https://www.google.com/";

	@Step("Open google start page: " + baseUrl)
	public StartPage opneStartPage() {
		String pathSeparator = File.separator;
		String pathToDriver = "assets" + pathSeparator + "webdriver" + pathSeparator + "geckodriver.exe";
		System.setProperty("webdriver.gecko.driver", pathToDriver);

		driver = new FirefoxDriver();
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
