package wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FluentWaitGenericMethod {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangescrum.com/");
		driver.manage().window().maximize();

		By getStartedLocator = By
				.cssSelector("aside[class='width-55-per left media-100 media-center'] a[title='Get Started Now']");
		waitForElement(driver, getStartedLocator).click();

		By loginLocator = By.xpath("//a[normalize-space()='Log in']");
		waitForElement(driver, loginLocator).click();

		driver.close();

	}
	public static WebElement waitForElement(WebDriver driver, final By locator) {

		Wait<WebDriver> mywait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);

		WebElement element = mywait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});
		return element;
	}
}
