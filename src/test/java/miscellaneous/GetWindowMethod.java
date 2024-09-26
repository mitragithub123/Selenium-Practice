package miscellaneous;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetWindowMethod {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector(".blinkingText")).click();

		// Switch to next tab/window
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iterator = windows.iterator();
		while (iterator.hasNext()) {
			String window = iterator.next();
			driver.switchTo().window(window);
			Thread.sleep(5000);
			System.out.println(driver.getTitle());
		}

		// Switch to About page
		/*List<String> ids = new ArrayList<>(driver.getWindowHandles());
		driver.switchTo().window(ids.get(1));
		System.out.println(driver.getTitle());

		Thread.sleep(3000);*/

		// Again switches back
		/*driver.switchTo().window(ids.get(0));
		System.out.println(driver.getTitle());*

		// Loop through all windows and switch to each one
		/*for (int i = 1; i < ids.size(); i++) {
			driver.switchTo().window(ids.get(i));
			System.out.println("Window " + i + " Title: " + driver.getTitle());
		}*/

	}

}
