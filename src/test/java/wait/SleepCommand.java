//NoSuchElementException: Element not present on page. (Sysnchronization). It is the standard exception provided by Selenium WebDriver.

//ElementNotFoundException: Locator is wrong.It is not part of Selenium WebDriver but may appear in custom frameworks or libraries.
package wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SleepCommand {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		Thread.sleep(5000);// Pause execution

		// It will generate NoSuchElementException if used without wait
		driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");
		
		driver.close();

	}

}
