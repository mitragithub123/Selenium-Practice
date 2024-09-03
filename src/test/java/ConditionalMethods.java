import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConditionalMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.nopcommerce.com/register");
		Thread.sleep(5000);
		
		// isDisplayed(): We can check display status of an element
		WebElement logo = driver.findElement(By.cssSelector("img[alt='nopCommerce demo store']"));
		System.out.println("Display status of logo is: " + logo.isDisplayed());
		
		// isSelected(): Checks whether a web element is currently selected. This method
		// is typically used for elements like checkboxes, radio buttons, or options in
		// a dropdown list to determine if they are selected or not.
		boolean maleStatus = driver.findElement(By.cssSelector("#gender-male")).isSelected();
		System.out.println(maleStatus);

		// isEnabled(): Checks whether a web element is enabled or not. Typically used
		// for elements like buttons, input fields, or any interactive element where you
		// want to verify that the element is not disabled.
		boolean firstNameStatus = driver.findElement(By.cssSelector("#FirstName")).isSelected();
		System.out.println(firstNameStatus);
		
		driver.close();

	}

}
