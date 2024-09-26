package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickAndHoldAction {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();

		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

		WebElement draggable = driver.findElement(By.id("draggable"));
		Actions actions = new Actions(driver);

		// Perform click and hold action
		actions.clickAndHold(draggable)
				.pause(Duration.ofSeconds(2)) // Optional: Hold for 2 seconds
				.release()
				.perform();

	}

}
