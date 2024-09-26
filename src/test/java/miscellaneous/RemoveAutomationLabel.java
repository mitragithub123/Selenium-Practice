package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RemoveAutomationLabel {

	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		// Use setExperimentalOption to exclude the automation switch
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();
		System.out.println("Page Title: " + driver.getTitle());

	}

}
