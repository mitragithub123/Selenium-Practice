package keyboardActions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TabAndWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();

		// Selenium 4.x
		driver.switchTo().newWindow(WindowType.TAB); // Opens in new tab

		driver.get("https://www.orangehrm.com/");

		driver.switchTo().newWindow(WindowType.WINDOW); // Opens in new window

		driver.get("https://www.orangescrum.com/");

	}

}
