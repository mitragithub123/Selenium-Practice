package javaScriptExecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		

/*In Selenium Java, the JavaScriptExecutor interface is useful for executing JavaScript code directly in the browser, especially when standard Selenium methods cannot handle certain web elements or actions. This is particularly effective when interacting with hidden or disabled elements that don't respond to typical interactions like click() or sendKeys().

However, attempting to interact with elements that are blocked or obscured by other elements can lead to an ElementInterceptedException. This exception occurs when another element intercepts the interaction, preventing the intended action from being performed. In this scenarios, use JavascriptExecutor*/
		
		WebElement name = driver.findElement(By.cssSelector("#name"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// Passing text to input-Alternate of sendKeys()
		js.executeScript("arguments[0].setAttribute('value','john')", name);
		
		// ChromeDriver driver = new ChromeDriver();
		// If declared this way, we can write:
		// JavascriptExecutor js = driver; (Since a child class object can access a parent class object)
		// No type casting is required here, as per the hierarchy structure.
		
		// Clicking an elemnt-Alternate of click()
		WebElement gender = driver.findElement(By.cssSelector("#male"));
		js.executeScript("arguments[0].click()", gender);
		
		
		


	}

}
