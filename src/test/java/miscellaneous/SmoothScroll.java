package miscellaneous;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SmoothScroll {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangescrum.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		WebElement target = driver
				.findElement(By.xpath("(//a[@title='Terms of Use'][normalize-space()='Terms of Use'])[1]"));
		while (target.isDisplayed()) {
			driver.findElement(By.tagName("body")).sendKeys(Keys.DOWN);
		}

	}

}
