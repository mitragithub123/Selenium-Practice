package relativeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorDemo2 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

		WebElement password = driver.findElement(By.id("password"));
		// above()
		WebElement userId = driver.findElement(RelativeLocator.with(By.tagName("input")).above(password));
		userId.sendKeys("ram");

		driver.close();

	}

}
