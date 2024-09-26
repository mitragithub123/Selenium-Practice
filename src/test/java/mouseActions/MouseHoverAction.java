package mouseActions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverAction {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();

		WebElement desktopEle = driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		WebElement macEle = driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));

		Actions act = new Actions(driver);
		act.moveToElement(desktopEle).build().perform();

		// build()-Creates and action
		// perform()-Completes an action
		// We can directly use perform() (It will build also)
		// We can build & after sometime we can perform also.

		act.moveToElement(macEle).click().build().perform();

		// act.moveToElement(desktopEle).moveToElement(macEle).click().build().perform();--same
		// act.moveToElement(desktopEle).moveToElement(macEle).click().perform();--same
		
	}

}
