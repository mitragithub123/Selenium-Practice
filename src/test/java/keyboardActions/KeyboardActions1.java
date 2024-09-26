package keyboardActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyboardActions1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();

		WebElement leftInput = driver.findElement(By.cssSelector("#inputText1"));
		WebElement rightInput = driver.findElement(By.cssSelector("#inputText2"));

		leftInput.sendKeys("Jai sriram..");

		Actions act = new Actions(driver);

		// CTRL+A
		act.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build().perform();

		// CTRL+C
		act.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).build().perform();

		rightInput.click();

		// CTRL+V
		act.keyDown(Keys.CONTROL)
			.sendKeys("V")
			.keyUp(Keys.CONTROL)
			.build()
			.perform();
		// CTRL+SHIFT+A
		// act.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys("A").keyUp(Keys.SHIFT).keyUp(Keys.CONTROL).build().perform();
		
		// Enter
		// act.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build().perform();
		
	}

}
