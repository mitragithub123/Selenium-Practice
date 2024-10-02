package shadowDom;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ShadowDomHandling {

	public static void main(String[] args) throws InterruptedException {
		// The shadow dom elements can't be accessed through XPath, use cssSelector for
		// it.
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://dev.automationtesting.in/shadow-dom");
		driver.manage().window().maximize();

		// This Element is inside single shadow DOM.
		SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		String shadowElement = shadow.findElement(By.cssSelector("#shadow-element")).getText();
		System.out.println(shadowElement);

		// This Element is inside 2 nested shadow DOM.
		SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		String nestedShadowElement = shadow1.findElement(By.cssSelector("#nested-shadow-element")).getText();
		System.out.println(nestedShadowElement);

		// This Element is inside 3 nested shadow DOM.
		SearchContext shadow00 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow01 = shadow00.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		SearchContext shadow02 = shadow01.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
		Thread.sleep(1000);
		String multiNestedShadowElement = shadow02.findElement(By.cssSelector("#multi-nested-shadow-element"))
				.getText();
		System.out.println(multiNestedShadowElement);

	}

}
