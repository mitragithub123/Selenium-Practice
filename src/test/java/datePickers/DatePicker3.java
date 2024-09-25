package datePickers;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker3 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://oslive-v4.2.andolasoft.co.in/signin");
		driver.manage().window().maximize();

		WebElement email = driver.findElement(By.cssSelector("input[placeholder='Enter your email']"));
		email.sendKeys("andolasoft.user133@gmail.com");
		WebElement password = driver.findElement(By.cssSelector("input[placeholder='Enter your password']"));
		password.sendKeys("Mitra@1234");
		WebElement signIn = driver.findElement(By.cssSelector("input[value='Sign In']"));
		signIn.click();

		driver.findElement(By.cssSelector("button[title='Create Project']")).click();
		driver.findElement(By.cssSelector("input[placeholder='Start Date']")).click();

		String requiredYear = "2025";
		String requiredMonth = "May";
		String requiredDate = "20";

		// Select year dropdown
		WebElement yearDropdown = driver.findElement(By.cssSelector(".react-datepicker__year-select"));
		Select selectYear = new Select(yearDropdown);
		selectYear.selectByVisibleText(requiredYear);
		
		// Select month dropdown
		WebElement monthDropdown = driver.findElement(By.cssSelector(".react-datepicker__month-select"));
		Select selectMonth = new Select(monthDropdown);
		selectMonth.selectByVisibleText(requiredMonth);

		// Select date
		List<WebElement> dates = driver.findElements(By.cssSelector(".react-datepicker__day"));
		for (int i = 0; i < dates.size(); i++) {
			if (dates.get(i).getText().equals(requiredDate)) {
				dates.get(i).click();
				break;
			}
		}

	}

}
