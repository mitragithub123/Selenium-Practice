package shadowDom;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomHandling2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://selectorshub.com/xpath-practice-page/");
		driver.manage().window().maximize();

		// This Element is inside single shadow DOM.
		SearchContext shadow = driver.findElement(By.cssSelector("#userName")).getShadowRoot();
		Thread.sleep(1000);
		shadow.findElement(By.cssSelector("#kils")).sendKeys("Mitra");

	}

}
