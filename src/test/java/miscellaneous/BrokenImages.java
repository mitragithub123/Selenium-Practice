package miscellaneous;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenImages {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.crmleaf.com/");
		driver.manage().window().maximize();

		// Find all images on the page
		List<WebElement> images = driver.findElements(By.tagName("img"));
		System.out.println("Total images present in the page: " + images.size());

		int brokenImages = 0;

		for (WebElement image : images) {
			String imageSrc = image.getAttribute("src");

			// Check if the src attribute is empty or null
			if (imageSrc == null || imageSrc.isEmpty()) {
				System.out.println("Image src is null or empty. Unable to verify the image.");
				continue;
			}

			try {
				URL url = new URL(imageSrc); // Convert the src URL string to a URL object
				HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Open HTTP connection
				connection.setConnectTimeout(5000); // Set timeout for connection
				connection.connect(); // Send the request

				// Check if the image is broken
				if (connection.getResponseCode() >= 400) {
					System.out.println(imageSrc + " -----> Broken image");
					brokenImages++;
				} /*
					 * else { System.out.println(imageSrc + " -----> Not broken"); }
					 */
			} catch (Exception e) {
				
			}
		}

		System.out.println("Total number of broken images: " + brokenImages);

		driver.quit();

	}

}
