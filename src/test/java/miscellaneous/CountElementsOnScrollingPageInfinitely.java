package miscellaneous;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CountElementsOnScrollingPageInfinitely {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://booksbykilo.in/new-books");
		driver.manage().window().maximize();

		// Here counting of elements while scrolling (using JavasciptExecutor & actions)
		// will not work.

		Actions action = new Actions(driver);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int prevCount = 0;
		int currentCount = 0;

		while (true) {
			List<WebElement> books = driver.findElements(By.cssSelector(".book_display h3"));
			currentCount = books.size();
			if (currentCount == prevCount) {
				break;
			}
			prevCount = currentCount;
			action.sendKeys(Keys.END).build().perform();
			// js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

			Thread.sleep(3000);

		}
		System.out.println("Total books present: " + currentCount);
	}

}
