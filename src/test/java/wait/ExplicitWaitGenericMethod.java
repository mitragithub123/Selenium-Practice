package wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWaitGenericMethod {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.orangescrum.com/");
		driver.manage().window().maximize();

		By getStartedLocator = By
				.cssSelector("aside[class='width-55-per left media-100 media-center'] a[title='Get Started Now']");
		waitForElement(driver, getStartedLocator, 5).click();

		By loginLocator = By.xpath("//a[normalize-space()='Log in']");
		waitForElement(driver, loginLocator, 5).click();

		driver.close();

	}

	public static WebElement waitForElement(WebDriver driver, By locator, int timeout) {
		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		mywait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return driver.findElement(locator);
	}
}
