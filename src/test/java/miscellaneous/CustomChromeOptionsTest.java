package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomChromeOptionsTest {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized"); // Maximizes the browser window
		options.addArguments("--disable-notifications"); // Disables browser notifications
		options.addArguments("--incognito"); // Opens the browser in incognito mode
		
		// options.addArguments("--start-maximized", "--disable-notifications", "--incognito");

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
		System.out.println("Page Title: " + driver.getTitle());
		driver.quit();

	}

}
