package wait;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitExample {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(10)) // Maximum wait																					// time
				.pollingEvery(Duration.ofSeconds(2)) // Polling interval
				.ignoring(NoSuchElementException.class); // Exceptions to ignore

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// It will generate NoSuchElementException if used without wait
		// driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");

		WebElement userName = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("input[placeholder='Username']"));
			}
		});
		userName.sendKeys("Admin");

		WebElement password = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("input[placeholder='Password']"));
			}
		});
		password.sendKeys("admin123");

		WebElement loginBtn = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.cssSelector("button[type='submit']"));
			}
		});
		loginBtn.click();

		driver.close();

	}

}
