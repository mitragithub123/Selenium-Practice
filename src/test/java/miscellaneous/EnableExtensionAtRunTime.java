package miscellaneous;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtensionAtRunTime {

	public static void main(String[] args) {
		// Enable extensions in browser
		// Step 1: Add CRX Extractor/Downloader to chrome Browser (manually)
		// Step 2: Add SelectorsHub plugin to chrome browser (manually)
		// Step 3: Capture crx file for selectors hub extension
		// Navigate to the Chrome Web Store page extension and search Selecors hub.
		// Right-click and click "Get CRX of this extension"
		// Step 4: pass crx file path in automation script in Chrome Options

		ChromeOptions options = new ChromeOptions();
		File file = new File(System.getProperty("user.dir") + "\\crx\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");

		options.addExtensions(file);

		WebDriver driver = new ChromeDriver(options);

		driver.get("https://text-compare.com/");
	}

}
