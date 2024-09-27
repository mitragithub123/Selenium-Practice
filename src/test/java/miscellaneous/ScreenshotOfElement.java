package miscellaneous;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotOfElement {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();

		WebElement simpleToStartSection = driver.findElement(By.cssSelector("img[title='OpenCart - Open Source Shopping Cart Solution']"));
		// Selenium 4.x
		// Capture screenshot of a web element
		File source = simpleToStartSection.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "\\screenshot\\elementScreenshot.png");
		if (!destination.exists()) {
			destination.mkdirs();
		}
		source.renameTo(destination);

	}

}
