package tables;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FilterTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();

		// Locate the search input field and enter filter value (e.g., 'Rice')
		WebElement searchBox = driver.findElement(By.id("search-field"));
		searchBox.sendKeys("Rice");

		// Capture all the rows displayed after filtering
		List<WebElement> filteredRows = driver.findElements(By.xpath("//table//tbody//tr//td[1]"));

		// Convert the filtered rows to a list of Strings
		List<String> filteredList = filteredRows.stream().map(s -> s.getText()).collect(Collectors.toList());

		// Check if all the results contain the filter value ('Rice')
		boolean filterWorks = filteredList.stream().allMatch(name -> name.contains("Rice"));

		// Output the result of the filter check
		if (filterWorks) {
			System.out.println("Filter works correctly. All results contain 'Rice'.");
		} else {
			System.out.println("Filter does not work correctly. Not all results contain 'Rice'.");
		}

	}

}
