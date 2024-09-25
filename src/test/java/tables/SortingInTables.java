package tables;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortingInTables {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.manage().window().maximize();

		// Clicking on column
		driver.findElement(By.xpath("//table//thead//th[1]")).click();

		// Capture all webelements in to list
		List<WebElement> vegNameList = driver.findElements(By.xpath("//table//tbody//tr//td[1]"));

		// Capture text of all web elements in to new (original) list
		List<String> originalList = vegNameList.stream().map(s -> s.getText()).collect(Collectors.toList());

		// Sorted list
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// Compare original list and sorted list
		if (originalList.equals(sortedList)) {
			System.out.println("The table is already sorted.");
		} else {
			System.out.println("The table is not sorted.");
		}

		// Assert.assertTrue(originalList.equals(sortedList));
	}

}
