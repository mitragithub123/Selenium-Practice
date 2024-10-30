package wait;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitForFileDownload {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://get.jenkins.io/windows-stable/2.426.1/jenkins.msi");

		String downloadPath = "‪C:\\Users\\Chandan\\Downloads";
		String fileName = "jenkins.msi";

		File file = new File(downloadPath, fileName);

		FluentWait<File> wait = new FluentWait<>(file)
				.withTimeout(Duration.ofMinutes(5))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(Exception.class)
				.withMessage("File is not downloaded");

		boolean isDownloaded = wait.until(f -> f.exists() && f.canRead());

		if (isDownloaded) {
			System.out.println("File is completely 100% downloaded");
		} else {
			System.out.println("File is not completely downloaded");
		}

	}

}
