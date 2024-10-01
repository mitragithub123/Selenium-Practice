package javaScriptExecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ZoomInZoomOut {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangescrum.com");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Zoom in
		js.executeScript("document.body.style.zoom='50%'");
		Thread.sleep(3000);
		// Zoom out
		js.executeScript("document.body.style.zoom='80%'");
		Thread.sleep(3000);

	}

}
