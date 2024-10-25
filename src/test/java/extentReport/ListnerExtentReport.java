package extentReport;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListnerExtentReport {
	@Test
	public void testReportPass() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// It will generate NoSuchElementException if used without wait
		// driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");
		WebElement userName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Username']")));
		userName.sendKeys("Admin");

		WebElement password = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Password']")));
		password.sendKeys("admin123");

		WebElement loginBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
		loginBtn.click();

		driver.close();

	}
	@Test
	public void testReportFail() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Explicit wait

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		// It will generate NoSuchElementException if used without wait
		// driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");
		WebElement userName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Username']")));
		userName.sendKeys("Admin");

		WebElement password = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[placeholder='Password']")));
		password.sendKeys("");

		WebElement loginBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[type='submit']")));
		loginBtn.click();
		
		Assert.assertTrue(false);

		driver.close();

	}
}
