package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HeadlessTest {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless"); // Run in headless mode
		options.addArguments("--no-sandbox"); // Bypass OS security model (useful in some environments)
		options.addArguments("--disable-gpu"); // Disable GPU acceleration
		options.addArguments("--window-size=1920x1080"); // Set window size in headless mode // Effective in headless
															// mode
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
		System.out.println("Page Title: " + driver.getTitle());

		driver.quit();

	}

}
