package miscellaneous;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindWebElementOnScrollingPageInfinitely {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://booksbykilo.in/new-books");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;

		boolean isFound = false;
		while (!isFound) {
			List<WebElement> books = driver.findElements(By.cssSelector(".book_display h3"));
			for (WebElement book : books) {
				if (book.getText().equals("The Vile Victorians")) {
					System.out.println(book.getText() + " Book found...");
					isFound = true;
					break;
				}
			}
			js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
			Thread.sleep(3000);
		}
		driver.quit();
	}

}
