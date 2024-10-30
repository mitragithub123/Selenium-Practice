package wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/*An AJAX call is a web development technique that allows a website to update part of its content without reloading the entire page. AJAX stands for Asynchronous JavaScript and XML, and it's a collection of technologies that make web applications more responsive to user interaction.
*/

public class HandleAjaxCall {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/p/gui-elements-ajax-hidden.html");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector("#loadContent")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[id='ajaxContent'] h2")));
		System.out.println(element.getText());

	}
}
