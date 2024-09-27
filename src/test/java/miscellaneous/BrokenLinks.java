package miscellaneous;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.tagName("a"));
		// Returns list of urls in string format
		System.out.println("Total links present in the page: " + links.size());
		int brokenLinks = 0;
		int notBrokenLinks = 0;
		for (WebElement link : links) {
			String stringUrls = link.getAttribute("href");
			// If the href value is empty or null, the URL cannot be verified
			if (stringUrls == "null" || stringUrls.isEmpty() || stringUrls.equals("#")) {
				System.out.println("href value is null. So unable to verify the url");
				continue;
			}
			try {
				URL url = new URL(stringUrls); // Converts the string URL into a URL object
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();// Opens an HTTP connection
				connection.connect();// Connects to the server and sends a request
				if (connection.getResponseCode() >= 400) {
					System.out.println(stringUrls + "----->" + "Broken link");
					brokenLinks++;
				} else {
					System.out.println(stringUrls + "----->" + "Not Broken link");
					notBrokenLinks++;
				}
			} catch (Exception e) {

			}
		}
		System.out.println("Total no. of broken links: " + brokenLinks);
		System.out.println("Total no. of not broken links: " + notBrokenLinks);

	}

}


/*1. Find all anchor elements (links) on the page
2. Initialize brokenLinks and notBrokenLinks to 0

3. For each link in the list of links:
   a. Extract the href attribute (URL)
   b. If href is null, empty or #:
       i. Print "href value is null. So unable to verify the URL"
       ii. Continue to the next link
   c. Convert href string to URL object
   d. Open an HTTP connection to the URL
   e. Send a request and check the HTTP response code
       i. If response code is >= 400:
           - Print "Broken link"
           - Increment brokenLinks
       ii. Else:
           - Print "Not broken link"
           - Increment notBrokenLinks

4. Print the total number of broken and non-broken links*/













