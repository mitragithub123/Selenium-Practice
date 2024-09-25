package datePickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker1UsingMethod {
	// Select month and year (Future)
	public static void selectMonthAndYearFuture(WebDriver driver, String month, String year) {
		while (true) {
			String currentMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
			String currentYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
			if (currentMonth.equalsIgnoreCase(month) && currentYear.equals(year)) {
				break;
			}
			driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click(); // Next
		}
	}

	// Select month and year (Future)
	public static void selectMonthAndYearPast(WebDriver driver, String month, String year) {
		while (true) {
			String currentMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();
			String currentYear = driver.findElement(By.cssSelector(".ui-datepicker-year")).getText();
			if (currentMonth.equalsIgnoreCase(month) && currentYear.equals(year)) {
				break;
			}
			driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-w")).click();// Prev
		}
	}

	// Select date
	public static void selectDate(WebDriver driver, String date) {

		List<WebElement> dates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for (int i = 0; i < dates.size(); i++) {
			if (dates.get(i).getText().equals(date)) {
				dates.get(i).click();
				break;
			}
		}
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();

		driver.switchTo().frame(0);

		// Method 1 (Using sendKeys)
		// driver.findElement(By.cssSelector(".hasDatepicker")).sendKeys("09/25/2024");

		// Method 2
		String year = "2022";
		String month = "May";
		String date = "20";

		driver.findElement(By.cssSelector(".hasDatepicker")).click();

		// Select month and year
		selectMonthAndYearPast(driver, month, year);
		// selectMonthAndYearFuture(driver, month, year);

		// Select date
		selectDate(driver, date);

	}

}
