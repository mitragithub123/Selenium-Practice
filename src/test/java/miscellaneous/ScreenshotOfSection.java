package miscellaneous;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotOfSection {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.opencart.com/");
		driver.manage().window().maximize();

		WebElement simpleToStartSection = driver.findElement(By.cssSelector("#feature"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scrollToSection = driver.findElement(By.cssSelector("#feature"));
		js.executeScript("arguments[0].scrollIntoView(true);", scrollToSection);
		
		// Selenium 4.x
		// Capturing sxreenshot of a particular section
		File source = simpleToStartSection.getScreenshotAs(OutputType.FILE);
		File destination = new File(System.getProperty("user.dir") + "\\screenshot\\sectionScreenshot.png");
		source.renameTo(destination);

	}

}
