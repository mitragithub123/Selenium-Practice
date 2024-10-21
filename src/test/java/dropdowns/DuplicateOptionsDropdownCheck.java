package dropdowns;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateOptionsDropdownCheck {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		Select select = new Select(driver.findElement(By.cssSelector("#colors")));

		// Array list will allow duplicates but Set will not allow duplicates.
		Set<String> uniqueOptions = new HashSet<String>();

		List<WebElement> options = select.getOptions();

		boolean flag = false;
		int count = 0;

		for (WebElement option : options) {
			String optionText = option.getText();

			if (!uniqueOptions.add(optionText)) {
				// If uniqueOptions.add(optionText) is true, then the element was successfully
				// added to the set.
				// This means that the element was not already present in the set.
				// If uniqueOptions.add(optionText) is false, then uplicates are not allowed in
				// a set.
				System.out.println("Duplicate options found: " + optionText);
				flag = true;
				count++;
			}
		}

		System.out.println("Duplicate options count found: " + count);

		if (!flag) {
			System.out.println("No duplicates found in list box.");
		}

		driver.close();

	}

}
