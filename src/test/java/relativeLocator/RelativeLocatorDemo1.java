package relativeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorDemo1 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		WebElement userId = driver.findElement(By.id("user-name"));
		
		// below()
		WebElement password = driver.findElement(RelativeLocator.with(By.tagName("input")).below(userId));
		password.sendKeys("ram");

		driver.close();

	}

}
