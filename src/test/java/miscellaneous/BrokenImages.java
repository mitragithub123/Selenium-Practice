package miscellaneous;

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

		int notDisplayedImages = 0;

		for (WebElement image : images) {
			String imageSrc = image.getAttribute("src");

			// Check if the src attribute is empty or null
			if (!image.isDisplayed()) {
				System.out.println(imageSrc + " -----> Image is not displayed on the page");
				notDisplayedImages++;
				continue; // Skip further checks for this image
			}

		}
		System.out.println("Total number of images not displayed on the page: " + notDisplayedImages);
		// driver.quit();
	}

}
