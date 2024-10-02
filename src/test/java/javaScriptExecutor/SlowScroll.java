package javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SlowScroll {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://orangescrum.com/");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		int size = 0;
		while (!(size > 0)) {
			js.executeScript("window.scrollBy(0,100)");
			driver.findElements(By.cssSelector("section[class='whats_new'] aside")).size(); // Target any
			Thread.sleep(500);
		}
		System.out.println("Reached the target element");
	}

}
