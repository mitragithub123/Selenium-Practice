package dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector(".multiselect-selected-text")).click();// Opens multi select dropdown

		driver.findElement(By.cssSelector("input[value='Java']")).click();// Select single option

		// Capture all options
		List<WebElement> options = driver.findElements(By.cssSelector(".multiselect-container label"));
		System.out.println("No of options in the dropdown: " + options.size());

		// Print all options
		for (WebElement option : options) {
			System.out.println(option.getText());
		}

		// Select multiple options
		for (WebElement option : options) {
			String text = option.getText();
			if (text.equals("Python") || text.equals("MySQL")) {
				option.click();
			}
		}

	}

}
