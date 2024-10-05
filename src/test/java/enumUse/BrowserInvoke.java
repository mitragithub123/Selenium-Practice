package enumUse;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserInvoke {
	public static WebDriver driver;

	public static WebDriver getDriver(Browser browser) {
		switch (browser) {
		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			System.out.println("No specific drivers found.");
			break;
		}
		return driver;
	}

	public static void main(String[] args) {
		driver = getDriver(Browser.CHROME);
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	}

}
