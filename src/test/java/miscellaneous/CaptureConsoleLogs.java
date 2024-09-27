package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CaptureConsoleLogs {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://orangescrum.com/");
		driver.manage().window().maximize();

		// Capture console logs
		LogEntries logs = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logs) {
			System.out.println(entry.getMessage());
		}
	}

}
