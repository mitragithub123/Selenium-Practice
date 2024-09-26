package miscellaneous;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Opens the url on the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);

		// Returns the title of the page
		String websiteTitle = driver.getTitle();
		System.out.println("The title of website is: " + websiteTitle);

		// Returns the url of the page
		String websiteUrl = driver.getCurrentUrl();
		System.out.println("The URL of website is: " + websiteUrl);

		// Returns the source code of the page (CTRL+U)
		String pageSource = driver.getPageSource();
		System.out.println(pageSource);

		// Return id of single browser window
		String windowId = driver.getWindowHandle();
		System.out.println("The window id of website is: " + windowId);

		// Return id of multiple browser windows
		driver.findElement(By.cssSelector("a[href='http://www.orangehrm.com']")).click();
		Set<String> windowIds = driver.getWindowHandles();// Get all window handles
		Iterator<String> iterator = windowIds.iterator();// Create an iterator for the window handles
		while (iterator.hasNext()) {// Iterate through all the window handles
			String handle = iterator.next();// Get the next window handle
			driver.switchTo().window(handle);// Switch to the window with the current handle
			System.out.println(driver.getWindowHandles());
		}
		driver.quit();

	}

}
