package datePickers;

import java.time.Duration;
import java.time.Month;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker2 {

	// User defined method for converting month from string--->Month
	static Month convertMonth(String month) {
		HashMap<String, Month> monthMap = new HashMap<String, Month>();

		monthMap.put("January", Month.JANUARY);
		monthMap.put("February", Month.FEBRUARY);
		monthMap.put("March", Month.MARCH);
		monthMap.put("April", Month.APRIL);
		monthMap.put("May", Month.MAY);
		monthMap.put("June", Month.JUNE);
		monthMap.put("July", Month.JULY);
		monthMap.put("August", Month.AUGUST);
		monthMap.put("September", Month.SEPTEMBER);
		monthMap.put("October", Month.OCTOBER);
		monthMap.put("November", Month.NOVEMBER);
		monthMap.put("December", Month.DECEMBER);

		Month vmonth = monthMap.get(month);

		if (vmonth == null) {
			System.out.println("Invalid Month...");
		}

		return vmonth;
	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement scrollToSection = driver.findElement(By.xpath("//h2[normalize-space()='Web Table']"));
		js.executeScript("arguments[0].scrollIntoView(true);", scrollToSection);

		driver.switchTo().frame("frame-one796456169");

		String requiredYear = "2022";
		String requiredMonth = "May";
		String requiredDate = "20";

		// Select year dropdown
		driver.findElement(By.cssSelector(".icon_calendar")).click();
		WebElement yearDropdown = driver.findElement(By.cssSelector(".ui-datepicker-year"));

		Select select = new Select(yearDropdown);
		select.selectByVisibleText(requiredYear);

		// Select displayed month
		while (true) {
			String displayMonth = driver.findElement(By.cssSelector(".ui-datepicker-month")).getText();

			// Convert required month and displayed month in to month objacts
			Month expectedMonth = convertMonth(requiredMonth);
			Month currentMonth = convertMonth(displayMonth);

			// Compare
			int result = expectedMonth.compareTo(currentMonth);

			// expectedMonth<currentMonth(Past)
			// expectedMonth>currentMonth(Future)

			// >0--Future month
			// <0--Past month
			// =0--Months are equal

			// >0--Future month (click next)
			if (result > 0) {
				driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-e")).click(); // Next
			}
			// <0--Past month (click previous)
			else if (result < 0) {
				driver.findElement(By.cssSelector(".ui-icon.ui-icon-circle-triangle-w")).click(); // Prev
			}
			// =0--Months are equal, break the loop
			else {
				break;
			}
		}

		// Select date
		List<WebElement> dates = driver
				.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));
		for (int i = 0; i < dates.size(); i++) {
			if (dates.get(i).getText().equals(requiredDate)) {
				dates.get(i).click();
				break;
			}
		}
	}

}
