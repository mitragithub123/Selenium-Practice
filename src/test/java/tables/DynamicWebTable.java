package tables;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicWebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice.expandtesting.com/dynamic-table");
		driver.manage().window().maximize();

		List<WebElement> tableRows = driver.findElements(By.xpath("//table[@class='table table-striped']//tr"));
		System.out.println("Total rows: " + tableRows.size());

		for (int i = 1; i <= tableRows.size(); i++) {
			WebElement browserName = driver
					.findElement(By.xpath("//table[@class='table table-striped']//tr[" + i + "]//td[1]"));
			String browserText = browserName.getText().trim();
			System.out.println("Row " + i + ": " + browserText);
			if (browserText.equalsIgnoreCase("chrome")) {
				String cpuPercentage = driver
						.findElement(By
								.xpath("//td[normalize-space()='Chrome']//following-sibling::*[contains(text(),'%')]"))
						.getText();
				String cpuValue = driver.findElement(By.cssSelector("#chrome-cpu")).getText();

				System.out.println("CPU Percentage in table: " + cpuPercentage);// 8.9%
				System.out.println("CPU Value in box: " + cpuValue);// Chrome CPU: 8.9%
				String[] arr=cpuValue.split(":");
				String cpuValueText=arr[1].trim();	

				if (cpuPercentage.trim().equalsIgnoreCase(cpuValueText)) {
					System.out.println("CPU loads are equal...");
					Assert.assertTrue(true);
				} else {
					System.out.println("CPU loads are n't equal...");
					Assert.assertTrue(false);
				}
				break;
			}
		}

	}

}
