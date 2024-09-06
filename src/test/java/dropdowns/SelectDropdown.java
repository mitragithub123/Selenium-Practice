package dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		WebElement countryDropdown = driver.findElement(By.cssSelector("#country"));
		Select select = new Select(countryDropdown);
		// select.selectByVisibleText("Canada");
		// select.selectByIndex(5);
		select.selectByValue("uk");

		// Capture all options of dropdown and print
		List<WebElement> options = select.getOptions();
		System.out.println("No of options in the dropdown: " + options.size());
		for (WebElement option : options) {
			System.out.println(option.getText());
		}
		
		/*
		 * for(int i=0;i<options.size();i++) {
		 * System.out.println(options.get(i).getText()); }
		 */

	}

}
