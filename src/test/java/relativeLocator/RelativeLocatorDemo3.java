package relativeLocator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorDemo3 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		driver.manage().window().maximize();
		WebElement wishList = driver.findElement(By.xpath("//span[normalize-space()='Wish List (0)']"));

		// toLeftOf()
		WebElement myAcc = driver.findElement(RelativeLocator.with(By.tagName("span")).toLeftOf(wishList));
		System.out.println(myAcc.getText());

		// toRightOf()
		WebElement shoppingCart = driver.findElement(RelativeLocator.with(By.tagName("span")).toRightOf(wishList));
		System.out.println(shoppingCart.getText());

		WebElement opencartElement = driver.findElement(By.xpath("//a[normalize-space()='OpenCart']"));
		// near()
		WebElement nearElement = driver.findElement(RelativeLocator.with(By.tagName("div")).near(opencartElement));
		System.out.println(nearElement.getText());

		driver.close();

	}

}
