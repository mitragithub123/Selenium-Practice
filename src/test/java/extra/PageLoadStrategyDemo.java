package extra;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PageLoadStrategyDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL); // Default
		// options.setPageLoadStrategy(PageLoadStrategy.EAGER);
		// options.setPageLoadStrategy(PageLoadStrategy.NONE);

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangescrum.com/");

	}
// Refer
// https://www.selenium.dev/documentation/webdriver/drivers/options/
}
