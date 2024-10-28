package miscellaneous;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FileDownloadVerification {

	public static void main(String[] args) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://practice.expandtesting.com/download");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("a[data-testid='1729965849986_sample.txt']")).click();
		Thread.sleep(5000);

		String fileName = "1729965849986_sample.txt";
		String downloadDir = System.getProperty("user.home") + "\\Downloads";

		File dir = new File(downloadDir);
		File[] files = dir.listFiles();
		boolean isFileDownloaded = false;

		if (files != null) {
			for (File file : files) {
				if (file.getName().equals(fileName)) {
					isFileDownloaded = true;
					System.out.println("File downloaded successfully: " + fileName);
					break;
				}
			}
		}

		if (!isFileDownloaded) {
			System.out.println("File not found in the download folder.");
		}

	}

}
