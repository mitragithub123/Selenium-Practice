package linkCheckboxRadiobutton;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkCount {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();

		// Find no of links in the page.
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links in the web page: " + links.size());

		// Find link texts from all the links.
		for (WebElement link : links) {
			System.out.println(link.getText());
		}

		// Check how many links do not have href attribute (Broken links).
		int brokenLinks = 0;
		for (WebElement link : links) {
			String href = link.getAttribute("href");
			if (href == null) {
				brokenLinks++;
				System.out.println("Broken link found: " + link.getText());
			}
		}
		System.out.println("Count of broken links: " + brokenLinks);

		driver.close();
	}
}
